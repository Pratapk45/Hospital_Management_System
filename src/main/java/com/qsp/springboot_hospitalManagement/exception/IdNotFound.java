package com.qsp.springboot_hospitalManagement.exception;

import lombok.Data;

@Data
public class IdNotFound extends RuntimeException{
	
     private String Message ;
     

}
