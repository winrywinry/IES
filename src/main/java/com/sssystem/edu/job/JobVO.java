package com.sssystem.edu.job;

public class JobVO {

	  private int job_no;
	  private String job_nm;

	  public JobVO() {
	  }

	  public JobVO(int job_no, String job_nm) {
	    super();
	    this.job_no = job_no;
	    this.job_nm = job_nm;
	  }

	  public int getJob_no() {
	    return job_no;
	  }

	  public void setJob_no(int job_no) {
	    this.job_no = job_no;
	  }

	  public String getJob_nm() {
	    return job_nm;
	  }

	  public void setJob_nm(String job_nm) {
	    this.job_nm = job_nm;
	  }

}
