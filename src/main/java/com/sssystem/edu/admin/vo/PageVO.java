package com.sssystem.edu.admin.vo;

public class PageVO {
  private int dept_no;
  private int job_no;
  private int manage_yn;
  private int admin_yn;
  private String searchWord;
  private int page;
  private int total;
  private int seq_no;
  private String searchTp;
  private int page_no;
  
public PageVO() {
	// TODO Auto-generated constructor stub
}

public PageVO(int dept_no, int job_no, int manage_yn, int admin_yn,
		String searchWord, int page, int total, int seq_no, String searchTp,
		int page_no) {
	super();
	this.dept_no = dept_no;
	this.job_no = job_no;
	this.manage_yn = manage_yn;
	this.admin_yn = admin_yn;
	this.searchWord = searchWord;
	this.page = page;
	this.total = total;
	this.seq_no = seq_no;
	this.searchTp = searchTp;
	this.page_no = page_no;
}

public int getDept_no() {
	return dept_no;
}

public void setDept_no(int dept_no) {
	this.dept_no = dept_no;
}

public int getJob_no() {
	return job_no;
}

public void setJob_no(int job_no) {
	this.job_no = job_no;
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

public String getSearchWord() {
	return searchWord;
}

public void setSearchWord(String searchWord) {
	this.searchWord = searchWord;
}

public int getPage() {
	return page;
}

public void setPage(int page) {
	this.page = page;
}

public int getTotal() {
	return total;
}

public void setTotal(int total) {
	this.total = total;
}

public int getSeq_no() {
	return seq_no;
}

public void setSeq_no(int seq_no) {
	this.seq_no = seq_no;
}

public String getSearchTp() {
	return searchTp;
}

public void setSearchTp(String searchTp) {
	this.searchTp = searchTp;
}

public int getPage_no() {
	return page_no;
}

public void setPage_no(int page_no) {
	this.page_no = page_no;
}

@Override
public String toString() {
	return "PageVO [dept_no=" + dept_no + ", job_no=" + job_no + ", manage_yn="
			+ manage_yn + ", admin_yn=" + admin_yn + ", searchWord="
			+ searchWord + ", page=" + page + ", total=" + total + ", seq_no="
			+ seq_no + ", searchTp=" + searchTp + ", page_no=" + page_no + "]";
}

}
