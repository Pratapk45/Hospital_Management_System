package com.qsp.springboot_hospitalManagement.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qsp.springboot_hospitalManagement.Dto.Hospital;
import com.qsp.springboot_hospitalManagement.Util.ResponceStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(HospitalIdNotFound.class)
	public ResponseEntity<ResponceStructure<String>> idNotFoundExceptionHandler(HospitalIdNotFound notFound)
	{
		ResponceStructure<String> structure = new ResponceStructure<>();
		structure.setMessage("Id Not Found ");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData(notFound.getMessage());
	
		return new ResponseEntity<>(structure ,HttpStatus.BAD_REQUEST);
		
	
	}
	//Search:  handlemethod
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
	//	return super.handleMethodArgumentNotValid(ex, headers, status, request);
		
		List<ObjectError> errors= ex.getAllErrors();
		Map<String ,String> map = new HashMap<String ,String>();
		for(ObjectError oe : errors)
		{
			FieldError error = (FieldError)oe;
			String FieldName = error.getField();
			String message = error.getDefaultMessage();
			map.put(FieldName, message);
		}
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}

}
