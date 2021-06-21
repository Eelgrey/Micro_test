package com.college.fee_student.fee;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FeeModel implements Serializable {

	private static final long serialVersionUID = 6061264109511787607L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column
	private int feeTxnId;
	
	@Column
	private int stuId;
	
	@Column
	private double feeAmt;
	
	@Column
	private int feeTxnSts;
	
	@Column
	private String feeTxnDesc;


	public FeeModel() {
		super();
	}

	public FeeModel(int feeTxnId, double feeAmt, int feeTxnSts, String feeTxnDesc) {
		super();
		this.feeTxnId = feeTxnId;
		this.feeAmt = feeAmt;
		this.feeTxnSts = feeTxnSts;
		this.feeTxnDesc=feeTxnDesc;
	}

	public int getFeeTxnId() {
		return feeTxnId;
	}

	public void setFeeTxnId(int feeTxnId) {
		this.feeTxnId = feeTxnId;
	}

	public double getFeeAmt() {
		return feeAmt;
	}

	public void setFeeAmt(double feeAmt) {
		this.feeAmt = feeAmt;
	}

	public int getFeeTxnSts() {
		return feeTxnSts;
	}

	public void setFeeTxnSts(int feeTxnSts) {
		this.feeTxnSts = feeTxnSts;
	}
	
	public String getFeeTxnDesc() {
		return feeTxnDesc;
	}

	public void setFeeTxnDesc(String feeTxnDesc) {
		this.feeTxnDesc = feeTxnDesc;
	}
	
	
}
