package com.college.create_student_app.create;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AddStudentController {
	
	@Autowired
	AddStudentService service;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@Autowired
	Environment environment;
	
	private static final Logger logger = LogManager.getLogger(AddStudentController.class);
	
	@PostMapping("/addStudent")
	public StudentModel addStudent(@RequestBody StudentModel stu) {
		try {


			String port = environment.getProperty("local.server.port");
			logger.info("Port access :: "+ port);
//			FeeModel fee=new FeeModel();
//			fee.setFeeAmt(stu.getFeeAmt());
//			fee=restTemplate.postForObject("http://localhost:9081/submitFee",fee,FeeModel.class);
//			if(fee!=null && fee.getFeeTxnSts()==1) {
				StudentModel s=service.addStudentInSystem(stu);
				return s;
//			}else {
//				return new StudentModel();	
//			}
			
		}catch (Exception e) {
			return new StudentModel();
		}
		
		
	}

}
