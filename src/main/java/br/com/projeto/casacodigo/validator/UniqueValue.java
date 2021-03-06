package br.com.projeto.casacodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {

    // error message
    String message() default "{br.com.projeto.beanvalidation.uniquevalue}";

    // represents group of constraint
    Class<?>[] groups() default {};

    // represents additional information about annotation
    Class<? extends Payload>[] payload() default {};

    String fieldName();

    Class<?> domainClass();
}
