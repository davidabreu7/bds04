package com.devsuperior.bds04.controller.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    private List<FieldError> fieldErros = new ArrayList<FieldError>();

    public List<FieldError> getFieldErros() {
        return fieldErros;
    }
}
