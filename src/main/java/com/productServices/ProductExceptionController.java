package com.productServices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {
	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<Object> exception() {
		return new ResponseEntity<>(
				"Product Not Found - create a product either using MangoDB or using Create Product Call",
				HttpStatus.METHOD_NOT_ALLOWED);
	}
}
