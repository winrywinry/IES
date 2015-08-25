package kr.or.sssystem.edu.board;

import java.sql.Date;

public class ReplyVO {

	private int comment_no;
	private int board_no;
	private int user_no;
	private String user_nm;
	private String Contents;
	private Date input_dt;
	private Date time_stamp;
	
	public ReplyVO() {
		// TODO Auto-generated constructor stub
	}

	public ReplyVO(int comment_no, int board_no, int user_no, String user_nm,
			String contents, Date input_dt, Date time_stamp) {
		super();
		this.comment_no = comment_no;
		this.board_no = board_no;
		this.user_no = user_no;
		this.user_nm = user_nm;
		Contents = contents;
		this.input_dt = input_dt;
		this.time_stamp = time_stamp;
	}

	public int getComment_no() {
		return comment_no;
	}

	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getUser_nm() {
		return user_nm;
	}

	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}

	public String getContents() {
		return Contents;
	}

	public void setContents(String contents) {
		Contents = contents;
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
	
}
