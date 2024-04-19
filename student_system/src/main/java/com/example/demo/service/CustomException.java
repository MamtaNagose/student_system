package com.example.demo.service;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomException {

	@ExceptionHandler(RuntimeException.class)
	public String cusRunTimeExp() {

		return "<<<<<<<<RuntimeException>>>>>>>";

	}

}
