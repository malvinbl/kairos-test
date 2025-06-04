package com.kairos.test.pvp.infrastructure.http.controller.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ExceptionsHandler {

	private static final String ERROR = "error";

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Map<String, Object>> handle(MethodArgumentTypeMismatchException e) {
		log.error("Exception ocurred: ", e);
		String error = "Malformed JSON request";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(Map.of(ERROR, error));
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<Map<String, Object>> handle(MissingServletRequestParameterException e) {
		log.error("Exception ocurred: ", e);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(Map.of(ERROR, e.getMessage()));
	}

	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<Map<String, Object>> handle(ResponseStatusException e) {
		log.error("Exception ocurred: ", e);
		HttpStatus statusCode = (HttpStatus) e.getStatusCode();
		return switch (statusCode) {
			case NOT_FOUND -> {
				String error = "Resource not found";
				yield ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(Map.of(ERROR, error));
			}
			default -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(Map.of(ERROR, e.getMessage()));
		};
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> handle(Exception e) {
		log.error("Exception ocurred: ", e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(Map.of(ERROR, e.getMessage()));
	}

}
