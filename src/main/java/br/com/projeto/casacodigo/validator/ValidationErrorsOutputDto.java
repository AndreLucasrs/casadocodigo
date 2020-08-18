package br.com.projeto.casacodigo.validator;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorsOutputDto {

    private List<String> globalErroMessages = new ArrayList<>();
    private List<FieldErrorOutputDto> fieldErrors = new ArrayList<>();

    public void addError(String message) {
        globalErroMessages.add(message);
    }

    public void addFieldError(String field, String message) {
        FieldErrorOutputDto fieldError = new FieldErrorOutputDto(field, message);
        fieldErrors.add(fieldError);
    }

    public List<String> getGlobalErroMessages() {
        return globalErroMessages;
    }

    public List<FieldErrorOutputDto> getFieldErrors() {
        return fieldErrors;
    }
}
