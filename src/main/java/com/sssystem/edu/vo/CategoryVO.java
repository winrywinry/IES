package com.sssystem.edu.vo;

public class CategoryVO {
	private String action;
	private String no;
	private String nm;
	
	private int category_no;
	private int ref_no;
	private int lev_no;
	private String category_nm;
	private int category_cnt;
	private int dept_no;

	public CategoryVO() {
	}

	
	public CategoryVO(int category_no, int ref_no, int lev_no,
			String category_nm, int category_cnt, int dept_no) {
		super();
		this.category_no = category_no;
		this.ref_no = ref_no;
		this.lev_no = lev_no;
		this.category_nm = category_nm;
		this.category_cnt = category_cnt;
		this.dept_no = dept_no;
	}


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	public String getNo() {
		return no;
	}


	public void setNo(String no) {
		this.no = no;
	}


	public String getNm() {
		return nm;
	}


	public void setNm(String nm) {
		this.nm = nm;
	}


	public int getDept_no() {
		return dept_no;
	}


	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}


	public int getCategory_cnt() {
		return category_cnt;
	}

	public void setCategory_cnt(int category_cnt) {
		this.category_cnt = category_cnt;
	}

	public int getCategory_no() {
		return category_no;
	}

	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}

	public int getRef_no() {
		return ref_no;
	}

	public void setRef_no(int ref_no) {
		this.ref_no = ref_no;
	}

	public int getLev_no() {
		return lev_no;
	}

	public void setLev_no(int lev_no) {
		this.lev_no = lev_no;
	}

	public String getCategory_nm() {
		return category_nm;
	}

	public void setCategory_nm(String category_nm) {
		this.category_nm = category_nm;
	}

	@Override
	public String toString() {
		return "CategoryBean [category_no=" + category_no + ", ref_no="
				+ ref_no + ", lev_no=" + lev_no + ", category_nm="
				+ category_nm + ", category_cnt=" + category_cnt + "]";
	}

}
