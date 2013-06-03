package com.rollingstone.spring.simplejdbc.domain;

import java.util.Date;

/**
 * @author Binit Datta
 * 
 */
public class Employee {

	long empId;
	String empName;
	Date dob;
	Date doj;
	String appraisalRemarks;
	float salary;

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getAppraisalRemarks() {
		return appraisalRemarks;
	}

	public void setAppraisalRemarks(String appraisalRemarks) {
		this.appraisalRemarks = appraisalRemarks;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

}
