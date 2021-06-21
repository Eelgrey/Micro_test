package com.college.create_student_app.create;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="FeeStudent")
public interface FeignProxyClass {
	
	@PostMapping("/fee/submitFee")
	FeeModel submitCollegeFee(FeeModel fee);


}
