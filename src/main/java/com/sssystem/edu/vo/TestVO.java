package com.sssystem.edu.vo;

import java.util.Date;

public class TestVO {
	private int test_no;
	private int edu_no;
	private int q_no;
	private String question;
	private String gubun;
	private String answer_nm;
	private String corr_answer;
	private int user_no;
	private Date input_dt;
	
	public TestVO() {
	}

	public TestVO(int test_no, int edu_no, int q_no, String question,
			String gubun, String answer_nm, String corr_answer, int user_no,
			Date input_dt) {
		super();
		this.test_no = test_no;
		this.edu_no = edu_no;
		this.q_no = q_no;
		this.question = question;
		this.gubun = gubun;
		this.answer_nm = answer_nm;
		this.corr_answer = corr_answer;
		this.user_no = user_no;
		this.input_dt = input_dt;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public int getTest_no() {
		return test_no;
	}

	public void setTest_no(int test_no) {
		this.test_no = test_no;
	}

	public int getEdu_no() {
		return edu_no;
	}

	public void setEdu_no(int edu_no) {
		this.edu_no = edu_no;
	}

	public int getQ_no() {
		return q_no;
	}

	public void setQ_no(int q_no) {
		this.q_no = q_no;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getGubun() {
		return gubun;
	}

	public void setGubun(String gubun) {
		this.gubun = gubun;
	}

	public String getAnswer_nm() {
		return answer_nm;
	}

	public void setAnswer_nm(String answer_nm) {
		this.answer_nm = answer_nm;
	}

	public String getCorr_answer() {
		return corr_answer;
	}

	public void setCorr_answer(String corr_answer) {
		this.corr_answer = corr_answer;
	}

	public Date getInput_dt() {
		return input_dt;
	}

	public void setInput_dt(Date input_dt) {
		this.input_dt = input_dt;
	}

	@Override
	public String toString() {
		return "TestBean [test_no=" + test_no + ", edu_no=" + edu_no
				+ ", q_no=" + q_no + ", question=" + question
				+ ", gubun=" + gubun + ", answer_nm=" + answer_nm
				+ ", corr_answer=" + corr_answer + ", input_dt=" + input_dt
				+ "]";
	}

}
