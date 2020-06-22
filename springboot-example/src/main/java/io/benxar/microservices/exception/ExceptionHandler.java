package io.benxar.microservices.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/** 
 * 
 * @author  benxar
 */
@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
 
  @Override
  protected ResponseEntity<Object> handleMissingServletRequestParameter(
      final MissingServletRequestParameterException ex, 
      final HttpHeaders headers, 
      final HttpStatus status, 
      final WebRequest request) {

    final ErrorMessage error  = new ErrorMessage(status, ex.getLocalizedMessage());
    return new ResponseEntity<Object>(error, new HttpHeaders(), status);
  }

  @org.springframework.web.bind.annotation.ExceptionHandler({
    ForbiddenException.class
  }) 
  protected ResponseEntity<Object> handleForbidden(
      final ForbiddenException ex,
      final WebRequest request) {      
      
      final HttpStatus status = HttpStatus.FORBIDDEN;  
      final ErrorMessage error  = new ErrorMessage(status, ex.getLocalizedMessage(), ex.getPath());
      return new ResponseEntity<Object>(error, new HttpHeaders(), status);
  }

}