package br.com.projeto.casacodigo.validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<?> klass;

    public void initialize(ExistsId constraint) {
        klass = constraint.domainClass();
    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object o = entityManager.find(klass, value);
        return Objects.nonNull(o);
    }
}
