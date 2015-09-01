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
	private int user_no;
	private Date input_dt;
	private Date time_stamp;

	public LearnVO() {
		// TODO Auto-generated constructor stub
	}

	public LearnVO(int edu_no, int dept_no, int category_no, int essential_yn,
			String title, String contents, Date period_st, Date period_ed,
			String contents_tag, int favorite_cnt, int view_cnt, int user_no,
			Date input_dt, Date time_stamp) {
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
		this.user_no = user_no;
		this.input_dt = input_dt;
		this.time_stamp = time_stamp;
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

	@Override
	public String toString() {
		return "LearnVO [edu_no=" + edu_no + ", dept_no=" + dept_no
				+ ", category_no=" + category_no + ", essential_yn="
				+ essential_yn + ", title=" + title + ", contents=" + contents
				+ ", period_st=" + period_st + ", period_ed=" + period_ed
				+ ", contents_tag=" + contents_tag + ", favorite_cnt="
				+ favorite_cnt + ", view_cnt=" + view_cnt + ", user_no="
				+ user_no + ", input_dt=" + input_dt + ", time_stamp="
				+ time_stamp + "]";
	}
	
}
