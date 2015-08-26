package com.sssystem.edu.common;

public class SetBoardTitle {
	
	public static String getBoardTitle(String boardGb) {
		String pageTitle = "";
		if("10".equals(boardGb)) {
			pageTitle = "공지사항";
			
		} else if ("20".equals(boardGb)) {
			pageTitle = "자료실";
			
		} else if ("30".equals(boardGb)) {
			pageTitle = "자유게시판";
			
		} else if ("40".equals(boardGb)) {
			pageTitle = "질문과답변";
			
		} else if ("50".equals(boardGb)) {
			pageTitle = "FAQ";
			
		} else if ("60".equals(boardGb)) {
			pageTitle = "건의사항";
		}
		
		return pageTitle;
	}
}
