package br.com.projeto.casacodigo.novacategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeNomeDuplicadoCategoriaValidator implements Validator {

    @Autowired
    private CategoriaRepository repository;

    @Override
    public boolean supports(Class<?> aClass) {
        return NovaCategoriaRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }
        NovaCategoriaRequest request = (NovaCategoriaRequest) o;
        Optional<Categoria> categoria = repository.findByNome(request.getNome());

        if(categoria.isPresent()) {
            errors.rejectValue("nome", "Já existe uma categoria com o mesmo nome " + request.getNome());
        }
    }
}
