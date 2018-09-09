package com.tzxylao.manager.exception;

public class NoFoundExcepiton extends Exception {
 
	private static final long serialVersionUID = -5955607821816077172L;

    public NoFoundExcepiton(String errorInfo) {
		super(errorInfo);
	}
}