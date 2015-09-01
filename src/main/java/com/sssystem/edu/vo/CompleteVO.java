package com.sssystem.edu.vo;

import java.sql.Date;

public class CompleteVO {
	private int edu_no;
	private int user_no;
	private int score;
	private String ANSWER;
	private Date input_dt;
	private Date start_dt;
	private Date end_dt;
	
	public CompleteVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompleteVO(int edu_no, int user_no, int score, String aNSWER,
			Date input_dt, Date start_dt, Date end_dt) {
		super();
		this.edu_no = edu_no;
		this.user_no = user_no;
		this.score = score;
		ANSWER = aNSWER;
		this.input_dt = input_dt;
		this.start_dt = start_dt;
		this.end_dt = end_dt;
	}


	public int getEdu_no() {
		return edu_no;
	}


	public void setEdu_no(int edu_no) {
		this.edu_no = edu_no;
	}


	public int getUser_no() {
		return user_no;
	}


	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public String getANSWER() {
		return ANSWER;
	}


	public void setANSWER(String aNSWER) {
		ANSWER = aNSWER;
	}


	public Date getInput_dt() {
		return input_dt;
	}


	public void setInput_dt(Date input_dt) {
		this.input_dt = input_dt;
	}


	public Date getStart_dt() {
		return start_dt;
	}


	public void setStart_dt(Date start_dt) {
		this.start_dt = start_dt;
	}


	public Date getEnd_dt() {
		return end_dt;
	}


	public void setEnd_dt(Date end_dt) {
		this.end_dt = end_dt;
	}
}
