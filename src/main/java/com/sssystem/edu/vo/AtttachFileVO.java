package com.sssystem.edu.vo;

import java.sql.Date;

public class AtttachFileVO {

	//첨부파일 beans
	private int attach_no; //첨부파일번호
	private int ref_no; //게시물 번호
	private String table_nm;//테이블명
	private String attach_file;//파일명
	private Date Input_DT;//첨부파일 작성일
	private Date attachTime_stamp; //첨부수정일 
	private int attach_seq;//파일순서
	
	public AtttachFileVO() {
		// TODO Auto-generated constructor stub
	}

	public int getAttach_no() {
		return attach_no;
	}

	public void setAttach_no(int attach_no) {
		this.attach_no = attach_no;
	}

	public int getRef_no() {
		return ref_no;
	}

	public void setRef_no(int ref_no) {
		this.ref_no = ref_no;
	}

	public String getTable_nm() {
		return table_nm;
	}

	public void setTable_nm(String table_nm) {
		this.table_nm = table_nm;
	}

	public String getAttach_file() {
		return attach_file;
	}

	public void setAttach_file(String attach_file) {
		this.attach_file = attach_file;
	}

	public Date getInput_DT() {
		return Input_DT;
	}

	public void setInput_DT(Date input_DT) {
		Input_DT = input_DT;
	}

	public Date getAttachTime_stamp() {
		return attachTime_stamp;
	}

	public void setAttachTime_stamp(Date attachTime_stamp) {
		this.attachTime_stamp = attachTime_stamp;
	}

	public int getAttach_seq() {
		return attach_seq;
	}

	public void setAttach_seq(int attach_seq) {
		this.attach_seq = attach_seq;
	}

}
