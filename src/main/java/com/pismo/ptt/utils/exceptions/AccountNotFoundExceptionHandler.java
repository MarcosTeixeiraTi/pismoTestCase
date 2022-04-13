package com.pismo.ptt.utils.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AccountNotFoundExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { AccountNotFoundException.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException exception, WebRequest request) {
		String bodyOfResponse = "Conta não encontrada";
		return handleExceptionInternal(exception, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

}
