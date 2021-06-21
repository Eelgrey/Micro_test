package com.college.api_gateway.zuul;



import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulApiFilter extends ZuulFilter{

	public static final Logger logger=LogManager.getLogger(ZuulApiFilter.class);

	//log the content of the request  
	@Override  
	public Object run() throws ZuulException  
	{   
		HttpServletRequest request=RequestContext.getCurrentContext().getRequest(); //getting the current HTTP request that is to be handle  
		logger.info("request -> {} request uri-> {}", request, request.getRequestURI());  //prints the detail of the requestin the log  
		return null;  
	}  
	@Override  
	public String filterType()   
	{  
		return "pre"; //intercept all the request before execution  
	}
	@Override
	public boolean shouldFilter() {
		return true; //executing filter for every request  
	}
	@Override
	public int filterOrder() {
		return 1; //setting filter order to 1
	}  

}
