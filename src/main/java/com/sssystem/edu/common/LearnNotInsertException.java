package com.sssystem.edu.common;

public class LearnNotInsertException extends RuntimeException {
	public LearnNotInsertException() {
		super("교육이 등록되지 않았습니다.");
	}
}
