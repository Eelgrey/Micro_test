package com.college.create_student_app.create;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentModel implements Serializable {

	private static final long serialVersionUID = 2898592343338666766L;
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int stuID;
	
	@Column
	private String name;
	
	@Column
	private String course;
	
	@Column
	private String sts;
	
	@Column
	private double feeAmt;
	
	public double getFeeAmt() {
		return feeAmt;
	}

	public void setFeeAmt(double feeAmt) {
		this.feeAmt = feeAmt;
	}

	public StudentModel() {
		
	}
	
//	public StudentModel(int id, String name, String course, String sts) {
//		super();
//		this.stuID = id;
//		this.name = name;
//		this.course = course;
//		this.sts=sts;
//	}
//	

	public int getStuID() {
		return stuID;
	}

	public void setStuID(int stuID) {
		this.stuID = stuID;
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
