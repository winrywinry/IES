package com.sssystem.edu.vo;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class AttachFileVO {

	//÷������ beans
	private int attach_no; //÷�����Ϲ�ȣ
	private int ref_no; //�Խù� ��ȣ
	private String table_nm;//���̺��
	private String attach_file;//���ϸ�
	private Date Input_DT;//÷������ �ۼ���
	private Date attachTime_stamp; //÷�μ����� 
	private int attach_seq;//���ϼ���
	private MultipartFile attach;
	
	public AttachFileVO() {
		// TODO Auto-generated constructor stub
	}

	public MultipartFile getAttach() {
		return attach;
	}

	public void setAttach(MultipartFile attach) {
		this.attach = attach;
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
