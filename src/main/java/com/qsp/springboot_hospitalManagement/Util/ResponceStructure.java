package com.qsp.springboot_hospitalManagement.Util;

import lombok.Data;

@Data
public class ResponceStructure<T> {

	private String message;
	private int status;
	private T data;
}
