package com.sssystem.edu.admin.vo;

public class PageVO {

  private int dept_no;
  private int job_no;
  private int manage_yn;
  private int admin_yn;
  private String searchWord;
  private int page;
  private int total;

  public PageVO() {
    // TODO Auto-generated constructor stub
  }

  public PageVO(int dept_no, int job_no, int manage_yn, int admin_yn,
      String searchWord, int page, int total) {
    this.dept_no = dept_no;
    this.job_no = job_no;
    this.manage_yn = manage_yn;
    this.admin_yn = admin_yn;
    this.searchWord = searchWord;
    this.page = page;
    this.total = total;
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

  @Override
  public String toString() {
    return "PageBean [dept_no=" + dept_no + ", job_no=" + job_no
        + ", manage_yn=" + manage_yn + ", admin_yn=" + admin_yn
        + ", searchWord=" + searchWord + ", page=" + page + ", total=" + total
        + "]";
  }
}
