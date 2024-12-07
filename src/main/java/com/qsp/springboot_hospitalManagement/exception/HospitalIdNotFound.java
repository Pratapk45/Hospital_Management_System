package com.qsp.springboot_hospitalManagement.exception;

public class HospitalIdNotFound extends RuntimeException{
	
	String Message = "Hospital with given id not found";
	
	public String getMessage()
	{
		return Message;
		
	}
}
