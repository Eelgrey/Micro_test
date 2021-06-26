package com.college.fee_student.fee;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeeController {
	
	@Autowired
	FeeSubmitService feeService;
	
	@Autowired
	Environment environment;
	
	public static final Logger logger=LogManager.getLogger(FeeController.class);
	
	@PostMapping("/submitFee")
	public FeeModel submitFee(@RequestBody FeeModel fee)throws Exception  {
		String port = environment.getProperty("local.server.port");
		logger.info("Port access :: "+ port);
		FeeModel f=feeService.submitFees(fee);
		return f;
		//throw new ArithmeticException();
	}

}
