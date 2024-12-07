package com.qsp.springboot_hospitalManagement.exception;

public class BranchIdNotFound extends RuntimeException{
	
	String Message = "Branch with given id not found";
	
	public String getMessage()
	{
		return Message;

}
}