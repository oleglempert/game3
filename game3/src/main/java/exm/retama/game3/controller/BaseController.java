package exm.retama.game3.controller;

import exm.retama.game3.DefaultExceptionAttributes;
import exm.retama.game3.ExceptionAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class BaseController {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String,Object>> handleException(Exception exception, HttpServletRequest request){
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		logger.error("- Exception : ",exception);
		
		ExceptionAttributes exceptionAttributes = new DefaultExceptionAttributes();
		Map<String,Object> resposeBody = exceptionAttributes.getExceptionAttributes(exception, request, status);
		return new ResponseEntity<Map<String,Object>>(resposeBody,status);
	}
	@ExceptionHandler({MethodArgumentNotValidException.class, IllegalArgumentException.class})
	public ResponseEntity<Map<String,Object>>handleNoResultException(Exception exception,HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ExceptionAttributes exceptionAttributes = new DefaultExceptionAttributes();
		Map<String,Object> resposeBody = exceptionAttributes.getExceptionAttributes(exception, request, status);
		logger.error(exception.getMessage(), exception);
		return new ResponseEntity<Map<String,Object>>(resposeBody,status);
	}
}