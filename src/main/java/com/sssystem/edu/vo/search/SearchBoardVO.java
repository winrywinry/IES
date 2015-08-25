package com.sssystem.edu.vo.search;

public class SearchBoardVO {
	
	private String searchTp;
	private String searchWord;
	private int board_gb;
	private int page_no;
	private int total;

	public SearchBoardVO() {
		// TODO Auto-generated constructor stub
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

	public int getBoard_gb() {
		return board_gb;
	}
	
	public void setBoard_gb(int board_gb) {
		this.board_gb = board_gb;
	}

	@Override
	public String toString() {
		return "SearchBean [board_gb=" + board_gb + ", searchTp=" + searchTp + ", searchWord="
				+ searchWord + "]";
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

	
}
