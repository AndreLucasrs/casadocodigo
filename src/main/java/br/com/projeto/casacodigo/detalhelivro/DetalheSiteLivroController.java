package br.com.projeto.casacodigo.detalhelivro;

import br.com.projeto.casacodigo.novoLivro.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Objects;

@RestController
public class DetalheSiteLivroController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping(value = "/produtos/{id}")
    public ResponseEntity detalhe(@PathVariable("id") Long id) {

        Livro livroBuscado = manager.find(Livro.class, id);
        if (Objects.isNull(livroBuscado)) {
            return ResponseEntity.notFound().build();
        }

        DetalheSiteLivroResponse detalheLivroResponse = new DetalheSiteLivroResponse(livroBuscado);
        return ResponseEntity.ok(detalheLivroResponse);
    }
}
