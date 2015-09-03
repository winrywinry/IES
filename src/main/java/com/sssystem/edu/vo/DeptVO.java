package com.sssystem.edu.vo;

public class DeptVO {
	private int[] dept;
	private int dept_no;
	private String dept_nm;
	private String section_nm;
	private String team_nm;
	private int user_no;
	private String category_nm;

	public DeptVO() {
	}
	
	public DeptVO(int dept_no, String dept_nm) {
		super();
		this.dept_no = dept_no;
		this.dept_nm = dept_nm;
	}

	public DeptVO(int dept_no, String dept_nm, String section_nm,
			String team_nm, int user_no) {
		super();
		this.dept_no = dept_no;
		this.dept_nm = dept_nm;
		this.section_nm = section_nm;
		this.team_nm = team_nm;
		this.user_no = user_no;
	}

	public int[] getDept() {
		return dept;
	}

	public void setDept(int[] dept) {
		this.dept = dept;
	}

	public int getDept_no() {
		return dept_no;
	}

	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}

	public String getDept_nm() {
		return dept_nm;
	}

	public void setDept_nm(String dept_nm) {
		this.dept_nm = dept_nm;
	}

	public String getSection_nm() {
		return section_nm;
	}

	public void setSection_nm(String section_nm) {
		this.section_nm = section_nm;
	}

	public String getTeam_nm() {
		return team_nm;
	}

	public void setTeam_nm(String team_nm) {
		this.team_nm = team_nm;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getCategory_nm() {
		return category_nm;
	}

	public void setCategory_nm(String category_nm) {
		this.category_nm = category_nm;
	}

}
