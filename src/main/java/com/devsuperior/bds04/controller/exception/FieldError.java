package com.devsuperior.bds04.controller.exception;

public class FieldError {

    private String error;
    private String message;

    public FieldError() {
    }

    public FieldError(String error, String message) {
        this.error = error;
        this.message = message;
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
}
