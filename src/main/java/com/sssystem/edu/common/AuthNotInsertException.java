package com.sssystem.edu.common;

public class AuthNotInsertException extends RuntimeException {
	public AuthNotInsertException() {
		super("권한이 등록되지 않았습니다.");
	}
}
