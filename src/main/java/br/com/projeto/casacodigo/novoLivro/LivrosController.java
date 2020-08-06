package br.com.projeto.casacodigo.novoLivro;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class LivrosController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/livros")
    @Transactional
    public String criar(@RequestBody @Valid LivrosRequest resquest) {

        Livro novoLivro = resquest.toModel(manager);
        manager.persist(novoLivro);
        return novoLivro.toString();
    }
}
