package it.team4tech.familybalance.exceptions;

import javax.ws.rs.core.Response.Status;

@SuppressWarnings("serial")
public class ServiceException extends RuntimeException {

	private String exceptionName;
	private Status exceptionStatus;
	private String exceptionMessage;
	
	public ServiceException() {
		//
	}
	
	public ServiceException(String name, Status status, String message) {
		this.exceptionName = name;
		this.exceptionStatus = status;
		this.exceptionMessage = message;
	}
	
	//GETTERS & SETTERS
	
	public String getExceptionName() {
		return exceptionName;
	}
	public void setExceptionName(String exceptionName) {
		this.exceptionName = exceptionName;
	}
	public Status getExceptionStatus() {
		return exceptionStatus;
	}
	public void setExceptionStatus(Status exceptionStatus) {
		this.exceptionStatus = exceptionStatus;
	}
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
}
