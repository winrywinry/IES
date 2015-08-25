package com.sssystem.edu.qna;

public class CheckAuthVO {

	private int manage_yn;
	private int admin_yn;
	public CheckAuthVO() {
		// TODO Auto-generated constructor stub
	}
	public CheckAuthVO(int manage_yn, int admin_yn) {
		this.manage_yn = manage_yn;
		this.admin_yn = admin_yn;
	}
	public int getManage_yn() {
		return manage_yn;
	}
	public void setManage_yn(int manage_yn) {
		this.manage_yn = manage_yn;
	}
	public int getAdmin_yn() {
		return admin_yn;
	}
	public void setAdmin_yn(int admin_yn) {
		this.admin_yn = admin_yn;
	}
}
