package com.sssystem.edu.vo;

import java.sql.Date;

public class BoardVO {
	
	//공지사항,자유게시판,자료실
	private int board_no; // 게시물번호
	private int user_no; // 회원번호
	private String board_gb;//게시판구분
	private String title; //게시판 제목
	private String contents; // 내용
	private int view_cnt; //조회수
	private java.util.Date input_dt;//작성일
	private Date time_stamp; //수정일
	private String comment_cnt; //댓글수
	private int edu_no; //교육번호
	private int next_idx;
	private int pre_idx;
	private String next_title;
	private String pre_title;
	private java.util.Date next_dt;
	private java.util.Date pre_dt;
	private int rownum;
	private int page_no;
	private int total;
	private String user_nm;
	
	public BoardVO() {
		
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getBoard_gb() {
		return board_gb;
	}

	public void setBoard_gb(String board_gb) {
		this.board_gb = board_gb;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getView_cnt() {
		return view_cnt;
	}

	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}

	public java.util.Date getInput_dt() {
		return input_dt;
	}

	public void setInput_dt(java.util.Date input_dt) {
		this.input_dt = input_dt;
	}

	public Date getTime_stamp() {
		return time_stamp;
	}

	public void setTime_stamp(Date time_stamp) {
		this.time_stamp = time_stamp;
	}

	public String getComment_cnt() {
		return comment_cnt;
	}

	public void setComment_cnt(String comment_cnt) {
		this.comment_cnt = comment_cnt;
	}

	public int getEdu_no() {
		return edu_no;
	}

	public void setEdu_no(int edu_no) {
		this.edu_no = edu_no;
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

	public String getUser_nm() {
		return user_nm;
	}

	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}
}
