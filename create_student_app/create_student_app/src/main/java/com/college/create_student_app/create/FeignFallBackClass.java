package com.college.create_student_app.create;


import org.springframework.stereotype.Component;

@Component 
class FeignFallBackClass implements FeignProxyClass{

	@Override
	public FeeModel submitCollegeFee(FeeModel fee) {
		FeeModel f=new FeeModel();
		f.setFeeAmt(0.00);
		f.setFeeTxnDesc("Default Data");
		f.setFeeTxnId(000);
		f.setFeeTxnSts(2);
		System.out.println("Setting default fee data :: ");
		return f;
	}
	
//	implements FallbackFactory<FeignProxyClass>{
//}

//	@Override
//	public FeeModel submitCollegeFee(FeeModel fee) {
//		FeeModel f=new FeeModel();
//		f.setFeeAmt(0.00);
//		f.setFeeTxnDesc("Default Data");
//		f.setFeeTxnId(000);
//		f.setFeeTxnSts(2);
//		System.out.println("Setting default fee data :: ");
//		return f;
//	}

//	@Override
//	public FeignProxyClass create(Throwable cause) {
//		return new FeignProxyClass() {
//			
//			@Override
//			public FeeModel submitCollegeFee(FeeModel fee) {
//				FeeModel f=new FeeModel();
//				f.setFeeAmt(0.00);
//				f.setFeeTxnDesc("Default Data");
//				f.setFeeTxnId(000);
//				f.setFeeTxnSts(2);
//				System.out.println("Setting default fee data :: ");
//				return f;
//			}
//		};
//	}
	

}
