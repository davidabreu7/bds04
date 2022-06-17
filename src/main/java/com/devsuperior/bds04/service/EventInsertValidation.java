package com.devsuperior.bds04.service;

import com.devsuperior.bds04.controller.exception.FieldError;
import com.devsuperior.bds04.dto.EventDto;
import com.devsuperior.bds04.service.validation.EventInsertValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventInsertValidation implements ConstraintValidator<EventInsertValid, EventDto> {

    @Override
    public void initialize(EventInsertValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(EventDto eventDto, ConstraintValidatorContext context) {

        List<FieldError> errors = new ArrayList<>();

        LocalDate eventDate = eventDto.getDate();
        if (eventDate.isBefore(LocalDate.now())){
            errors.add(new FieldError("date", "A data do evento não pode ser passada"));
        }

        for (FieldError e : errors) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getError())
                    .addConstraintViolation();
        }

        return errors.isEmpty();
    }
}
