package com.sssystem.edu.vo;

import java.util.Date;

public class AuthVO {
	private int auth_no;
	private int edu_no;
	private int dept_no;
	private String job_str;
	private Date input_dt;
	
	public AuthVO() {
		// TODO Auto-generated constructor stub
	}

	public AuthVO(int auth_no, int edu_no, int dept_no, String job_str,
			Date input_dt) {
		super();
		this.auth_no = auth_no;
		this.edu_no = edu_no;
		this.dept_no = dept_no;
		this.job_str = job_str;
		this.input_dt = input_dt;
	}

	public int getAuth_no() {
		return auth_no;
	}

	public void setAuth_no(int auth_no) {
		this.auth_no = auth_no;
	}

	public int getEdu_no() {
		return edu_no;
	}

	public void setEdu_no(int edu_no) {
		this.edu_no = edu_no;
	}

	public int getDept_no() {
		return dept_no;
	}

	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}

	public String getJob_str() {
		return job_str;
	}

	public void setJob_str(String job_str) {
		this.job_str = job_str;
	}

	public Date getInput_dt() {
		return input_dt;
	}

	public void setInput_dt(Date input_dt) {
		this.input_dt = input_dt;
	}

	@Override
	public String toString() {
		return "AuthVO [auth_no=" + auth_no + ", edu_no=" + edu_no
				+ ", dept_no=" + dept_no + ", job_str=" + job_str
				+ ", input_dt=" + input_dt + "]";
	}
	
	

	
}
