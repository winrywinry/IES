package com.sssystem.edu.qna;

import java.sql.Date;

public class QnaBoardVO {
	
	private int qna_no; //게시물번호
	private int edu_no; //교육번호
	private String board_gb; //게시판구분
	private int secret_yn; //공개여부
	private String title; //제목
	private String q_contents; //질문내용
	private String a_contents; //답변내용
	private int visit_no; //조회수
	private java.util.Date question_dt; //작성일
	private java.util.Date answer_dt; //답변일
	private Date time_stamp; //수정일
	private int q_user_no; //작성자 번호
	private int a_user_no; //답변자 번호
	private String a_user_nm;//답변자 이름
	private int next_idx;
	private int pre_idx;
	private java.util.Date next_dt;
	private java.util.Date pre_dt;	
	private String next_title;
	private String pre_title;
	private int rownum;
	private int page_no;
	private int total;
	private int manage_yn;
	

	public QnaBoardVO() {
		// TODO Auto-generated constructor stub
	}



	public int getQna_no() {
		return qna_no;
	}



	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}



	public int getEdu_no() {
		return edu_no;
	}



	public void setEdu_no(int edu_no) {
		this.edu_no = edu_no;
	}



	public String getBoard_gb() {
		return board_gb;
	}



	public void setBoard_gb(String board_gb) {
		this.board_gb = board_gb;
	}



	public int getSecret_yn() {
		return secret_yn;
	}



	public void setSecret_yn(int secret_yn) {
		this.secret_yn = secret_yn;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getQ_contents() {
		return q_contents;
	}



	public void setQ_contents(String q_contents) {
		this.q_contents = q_contents;
	}



	public String getA_contents() {
		return a_contents;
	}



	public void setA_contents(String a_contents) {
		this.a_contents = a_contents;
	}



	public int getVisit_no() {
		return visit_no;
	}



	public void setVisit_no(int visit_no) {
		this.visit_no = visit_no;
	}



	public java.util.Date getQuestion_dt() {
		return question_dt;
	}



	public void setQuestion_dt(java.util.Date question_dt) {
		this.question_dt = question_dt;
	}



	public java.util.Date getAnswer_dt() {
		return answer_dt;
	}



	public void setAnswer_dt(java.util.Date answer_dt) {
		this.answer_dt = answer_dt;
	}



	public Date getTime_stamp() {
		return time_stamp;
	}



	public void setTime_stamp(Date time_stamp) {
		this.time_stamp = time_stamp;
	}



	public int getQ_user_no() {
		return q_user_no;
	}



	public void setQ_user_no(int q_user_no) {
		this.q_user_no = q_user_no;
	}



	public int getA_user_no() {
		return a_user_no;
	}



	public void setA_userno(int a_userno) {
		this.a_user_no = a_user_no;
	}



	public int getNext_idx() {
		return next_idx;
	}



	public void setNext_idx(int next_idx) {
		this.next_idx = next_idx;
	}



	public int getPre_idx() {
		return pre_idx;
	}



	public void setPre_idx(int pre_idx) {
		this.pre_idx = pre_idx;
	}



	public String getNext_title() {
		return next_title;
	}



	public void setNext_title(String next_title) {
		this.next_title = next_title;
	}



	public String getPre_title() {
		return pre_title;
	}



	public void setPre_title(String pre_title) {
		this.pre_title = pre_title;
	}



	public int getRownum() {
		return rownum;
	}



	public void setRownum(int rownum) {
		this.rownum = rownum;
	}



	public int getPage_no() {
		return page_no;
	}



	public void setPage_no(int page_no) {
		this.page_no = page_no;
	}



	public int getTotal() {
		return total;
	}



	public void setTotal(int total) {
		this.total = total;
	}



	public void setA_user_no(int a_user_no) {
		this.a_user_no = a_user_no;
	}



	public java.util.Date getNext_dt() {
		return next_dt;
	}



	public void setNext_dt(java.util.Date next_dt) {
		this.next_dt = next_dt;
	}



	public java.util.Date getPre_dt() {
		return pre_dt;
	}



	public void setPre_dt(java.util.Date pre_dt) {
		this.pre_dt = pre_dt;
	}



	public int getManage_yn() {
		return manage_yn;
	}



	public void setManage_yn(int manage_yn) {
		this.manage_yn = manage_yn;
	}



	public String getA_user_nm() {
		return a_user_nm;
	}



	public void setA_user_nm(String a_user_nm) {
		this.a_user_nm = a_user_nm;
	}

}
