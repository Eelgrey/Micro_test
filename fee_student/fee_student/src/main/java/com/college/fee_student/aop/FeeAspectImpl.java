package com.college.fee_student.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.college.fee_student.fee.FeeModel;

@Aspect
@Configuration
public class FeeAspectImpl {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before(value = "execution(* com.college.fee_student.fee.FeeSubmitService.*(..)) and args(fee)")
	public void before(JoinPoint jp, FeeModel fee) {
		logger.info("Before call for -------------------------- "+jp);
		logger.info("Before call for fee  -------------------------- "+ fee.getFeeAmt());
	}

	@After(value = "execution(* com.college.fee_student.fee.FeeSubmitService.*(..)) and args(fee)")
	public void after(JoinPoint jp, FeeModel fee) {
		logger.info("After call for -------------------------- "+ jp);
		logger.info("After call for fee  -------------------------- "+ fee.getFeeAmt());
	}
	
//	@AfterReturning(value = "execution(* com.college.fee_student.fee.FeeController.*(..))")
//	public void around(JoinPoint jp) {
//		logger.info("AfterReturning call for fee txn sts -------------------------- "+jp.getClass());
//	}

}
