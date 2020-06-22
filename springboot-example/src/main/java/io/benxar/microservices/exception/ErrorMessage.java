package io.benxar.microservices.exception;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.springframework.http.HttpStatus;

/**
 * 
 * @author  benxar
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {
 
    private Timestamp timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public ErrorMessage(HttpStatus status, String message) {
        super();
        this.timestamp = new Timestamp(new Date().getTime());
        this.status = status.value();
        this.error = status.getReasonPhrase();
        this.message = message;
    }

    public ErrorMessage(HttpStatus status, String message, String path) {
        super();
        this.timestamp = new Timestamp(new Date().getTime());
        this.status = status.value();
        this.error = status.getReasonPhrase();
        this.message = message;
        this.path = path;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}