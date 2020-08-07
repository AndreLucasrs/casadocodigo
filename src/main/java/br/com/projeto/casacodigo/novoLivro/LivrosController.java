package br.com.projeto.casacodigo.novoLivro;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping(value = "/livros")
    public List<LivroResponse> lista() {
        List<Livro> listaLivro = manager.createQuery("FROM Livro", Livro.class).getResultList();
        List<LivroResponse> response = listaLivro.stream().map(livro -> new LivroResponse(livro)).collect(Collectors.toList());
        return response;
    }
}
