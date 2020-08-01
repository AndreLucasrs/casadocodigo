package br.com.projeto.casacodigo.novoautor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEmailDuplicadoAutorValidador implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return NovoAutorRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        NovoAutorRequest request = (NovoAutorRequest) o;
        Optional<Autor> autor = autorRepository.findByEmail(request.getEmail());

        if (autor.isPresent()) {
            errors.rejectValue("email", null, "Já existe um(a) outro(a) autor(a) com o mesmo email " + request.getEmail());
        }
    }
}
