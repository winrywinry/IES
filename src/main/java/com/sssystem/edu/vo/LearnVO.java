package com.sssystem.edu.vo;

import java.util.Date;


public class LearnVO {

  private int edu_no;
  private int dept_no;
  private int category_no;
  private int essential_yn;
  private String title;
  private String contents;
  private Date period_st;
  private Date period_ed;
  private String contents_tag;
  private int favorite_cnt;
  private int view_cnt;
  private String edu_test;
  private int user_no;
  private Date input_dt;
  private Date time_stamp;
  private Date start_dt;
  private Date end_dt;
  
public LearnVO() {
	super();
	// TODO Auto-generated constructor stub
}

public LearnVO(int edu_no, int dept_no, int category_no, int essential_yn,
		String title, String contents, Date period_st, Date period_ed,
		String contents_tag, int favorite_cnt, int view_cnt, String edu_test,
		int user_no, Date input_dt, Date time_stamp, Date start_dt, Date end_dt) {
	super();
	this.edu_no = edu_no;
	this.dept_no = dept_no;
	this.category_no = category_no;
	this.essential_yn = essential_yn;
	this.title = title;
	this.contents = contents;
	this.period_st = period_st;
	this.period_ed = period_ed;
	this.contents_tag = contents_tag;
	this.favorite_cnt = favorite_cnt;
	this.view_cnt = view_cnt;
	this.edu_test = edu_test;
	this.user_no = user_no;
	this.input_dt = input_dt;
	this.time_stamp = time_stamp;
	this.start_dt = start_dt;
	this.end_dt = end_dt;
}

public int getEdu_no() {
	return edu_no;
}

public void setEdu_no(int edu_no) {
	this.edu_no = edu_no;
}

public int getDept_no() {
	return dept_no;
}

public void setDept_no(int dept_no) {
	this.dept_no = dept_no;
}

public int getCategory_no() {
	return category_no;
}

public void setCategory_no(int category_no) {
	this.category_no = category_no;
}

public int getEssential_yn() {
	return essential_yn;
}

public void setEssential_yn(int essential_yn) {
	this.essential_yn = essential_yn;
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

public Date getPeriod_st() {
	return period_st;
}

public void setPeriod_st(Date period_st) {
	this.period_st = period_st;
}

public Date getPeriod_ed() {
	return period_ed;
}

public void setPeriod_ed(Date period_ed) {
	this.period_ed = period_ed;
}

public String getContents_tag() {
	return contents_tag;
}

public void setContents_tag(String contents_tag) {
	this.contents_tag = contents_tag;
}

public int getFavorite_cnt() {
	return favorite_cnt;
}

public void setFavorite_cnt(int favorite_cnt) {
	this.favorite_cnt = favorite_cnt;
}

public int getView_cnt() {
	return view_cnt;
}

public void setView_cnt(int view_cnt) {
	this.view_cnt = view_cnt;
}

public String getEdu_test() {
	return edu_test;
}

public void setEdu_test(String edu_test) {
	this.edu_test = edu_test;
}

public int getUser_no() {
	return user_no;
}

public void setUser_no(int user_no) {
	this.user_no = user_no;
}

public Date getInput_dt() {
	return input_dt;
}

public void setInput_dt(Date input_dt) {
	this.input_dt = input_dt;
}

public Date getTime_stamp() {
	return time_stamp;
}

public void setTime_stamp(Date time_stamp) {
	this.time_stamp = time_stamp;
}

public Date getStart_dt() {
	return start_dt;
}

public void setStart_dt(Date start_dt) {
	this.start_dt = start_dt;
}

public Date getEnd_dt() {
	return end_dt;
}

public void setEnd_dt(Date end_dt) {
	this.end_dt = end_dt;
}
  

}
