package com.college.fee_student.fee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeeSubmitServiceImpl implements FeeSubmitService{
	
	@Autowired
	FeeSubmitRepo repo;
	
	public FeeModel submitFees(FeeModel fee)throws Exception{
		FeeModel f=new FeeModel();
		if(fee!=null && fee.getFeeAmt()>1000) {
			fee.setFeeTxnSts(1);
			fee.setFeeTxnDesc("Success");
			f=repo.save(fee);
		}else {
			fee.setFeeTxnSts(0);
			fee.setFeeTxnDesc("Failure");
			f=repo.save(fee);
		}
		return f;
	}

}
