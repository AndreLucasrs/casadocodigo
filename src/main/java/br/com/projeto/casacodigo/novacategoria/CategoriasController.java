package br.com.projeto.casacodigo.novacategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class CategoriasController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/categorias")
    @Transactional
    public String cria(@RequestBody @Valid NovaCategoriaRequest request) {
        Categoria categoria = request.toModel();
        manager.persist(categoria);
        return categoria.toString();
    }
}
