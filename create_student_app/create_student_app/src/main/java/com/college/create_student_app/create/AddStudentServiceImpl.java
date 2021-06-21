package com.college.create_student_app.create;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddStudentServiceImpl implements AddStudentService {
	
	@Autowired
	AddStudentRepo repo;
	
	@Autowired
	AddStudentTxnRepo txn;
	
	@Autowired
	FeignProxyClass proxy;

	@Override
	public StudentModel addStudentInSystem(StudentModel stu) throws Exception {
		StudentModelTxn t= new StudentModelTxn();
		BeanUtils.copyProperties(stu, t);
		t.setSts("Inactive");
		t=txn.save(t);
		
		
		// add fee payment
		FeeModel fee=new FeeModel();
		fee.setFeeAmt(stu.getFeeAmt());
		fee=proxy.submitCollegeFee(fee);
		StudentModel s= new StudentModel();
		if(fee!=null && fee.getFeeTxnSts()==1) {
			stu.setSts("Active");
			 s=repo.save(stu);
		}else {
			stu.setSts("Inactive");
			 s=repo.save(stu);
		}
		return s;
	}
	

}
