package com.lixiaozhuo.exception;

//文件类型异常
public class FileTypeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FileTypeException(String message) {
		super(message);

	}

	public FileTypeException(Throwable cause) {
		super(cause);

	}

}
