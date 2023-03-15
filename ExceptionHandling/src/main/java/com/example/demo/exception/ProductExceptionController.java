package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {
	@ExceptionHandler(value=ProductnotFoundException.class)
	public ResponseEntity<Object> exception(ProductnotFoundException exception){
		return new ResponseEntity<> ("product not found",HttpStatus.NOT_FOUND);
		}
	

}
