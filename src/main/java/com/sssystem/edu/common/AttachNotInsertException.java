package com.sssystem.edu.common;

public class AttachNotInsertException extends RuntimeException {
	public AttachNotInsertException() {
		super("첨부파일이 등록되지 않았습니다.");
	}
}
