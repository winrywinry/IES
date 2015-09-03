package com.sssystem.edu.common;

public class TestNotUpdateException extends RuntimeException {
	public TestNotUpdateException() {
		super("시험이 등록되지 않았습니다.");
	}
}
