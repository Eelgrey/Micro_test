package com.college.create_student_app.create;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class StudentModelTxn implements Serializable {

	private static final long serialVersionUID = -8092896358369054607L;

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String course;
	
	@Column
	private String sts;
	
	@Column
	private double feeAmt;
	
	public StudentModelTxn() {
		
	}
	
	public double getFeeAmt() {
		return feeAmt;
	}

	public void setFeeAmt(double feeAmt) {
		this.feeAmt = feeAmt;
	}

	

	
//	public StudentModelTxn(int id, String name, String course, String sts) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.course = course;
//		this.sts=sts;
//	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getSts() {
		return sts;
	}

	public void setSts(String sts) {
		this.sts = sts;
	}

}

