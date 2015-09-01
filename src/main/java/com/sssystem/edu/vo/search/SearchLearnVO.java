package com.sssystem.edu.vo.search;

public class SearchLearnVO {

  private int seq_no;
  private String searchTp;
  private String searchWord;
  private int dept_no;
  private int page_no;
  private int total;

  public SearchLearnVO() {
    // TODO Auto-generated constructor stub
  }

  public SearchLearnVO(int seq_no, String searchTp, String searchWord, int dept_no,
      int page_no, int total) {
    super();
    this.seq_no = seq_no;
    this.searchTp = searchTp;
    this.searchWord = searchWord;
    this.dept_no = dept_no;
    this.page_no = page_no;
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

  public String getSearchWord() {
    return searchWord;
  }

  public void setSearchWord(String searchWord) {
    this.searchWord = searchWord;
  }

  public int getDept_no() {
    return dept_no;
  }

  public void setDept_no(int dept_no) {
    this.dept_no = dept_no;
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

  @Override
  public String toString() {
    return "PageBean [seq_no=" + seq_no + ", searchTp=" + searchTp
        + ", searchWord=" + searchWord + ", dept_no=" + dept_no + ", page_no="
        + page_no + ", total=" + total + "]";
  }


}
