package com.college.fee_student.fee;

import org.springframework.stereotype.Service;

@Service
public interface FeeSubmitService {

	FeeModel submitFees(FeeModel fee)throws Exception;
}
