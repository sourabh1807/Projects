package com.test.prediction.exception.handler;

import com.test.prediction.exception.InvalidInputException;
import com.test.prediction.exception.response.ErrorResponseVO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PredictionExceptionHandler {
	
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<ErrorResponseVO> handlePPFraudException(InvalidInputException ex) {
		ErrorResponseVO error = new ErrorResponseVO(ex.getErrorMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}	

}
