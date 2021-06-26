package com.college.create_student_app.create;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;


//@FeignClient(name="FeeStudent")
@FeignClient(name="FeeStudent", fallbackFactory =FeignFallBackClass.class)
public interface FeignProxyClass {
	
	@PostMapping("/fee/submitFee")
	FeeModel submitCollegeFee(FeeModel fee);
	
//	public default FeeModel getDefaultData(FeeModel fee) {
//		FeeModel f=new FeeModel();
//		f.setFeeAmt(0.00);
//		f.setFeeTxnDesc("Default Data");
//		f.setFeeTxnId(000);
//		f.setFeeTxnSts(2);
//		System.out.println("Setting default fee data :: ");
//		return f;
//	}


}
