package com.sssystem.edu.common;

public class BoardNotInsertException extends RuntimeException {
	public BoardNotInsertException() {
		super("자료실에 등록되지 않았습니다.");
	}
}
