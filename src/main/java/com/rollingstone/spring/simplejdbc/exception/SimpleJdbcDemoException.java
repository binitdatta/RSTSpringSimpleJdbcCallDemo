package com.rollingstone.spring.simplejdbc.exception;



/**
 * The Class SimpleJdbcDemoException.
 *
 * @author Binit Datta
 */

public class SimpleJdbcDemoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2320833462226234955L;
	/** The exception msg. */
	private String exceptionMsg;
	private String errorCode;
	/**
	 * Instantiates a new uD m3 generic exception.
	 *
	 * @param exceptionMsg the exception msg
	 */
	public SimpleJdbcDemoException(String exceptionMsg) {
		super(exceptionMsg);
		this.exceptionMsg = exceptionMsg;
	}
	/**
	 * Instantiates a new uD m3 generic exception.
	 */
	public SimpleJdbcDemoException(){
		super();
	}
	/***
	 * @param errorMsg
	 * @param e
	 */
	public SimpleJdbcDemoException(String errorMsg,Throwable e){
		super(errorMsg,e);
		this.exceptionMsg = errorMsg;
	}
	/**
	 * Gets the exception msg.
	 * @return the exception msg
	 */
	public String getExceptionMsg() {
		return this.exceptionMsg;
	}
	/**
	 * Sets the exception msg.
	 * @param exceptionMsg the new exception msg
	 */
	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}