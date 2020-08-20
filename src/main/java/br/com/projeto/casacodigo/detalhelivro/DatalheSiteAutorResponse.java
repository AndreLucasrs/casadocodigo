package br.com.projeto.casacodigo.detalhelivro;

import br.com.projeto.casacodigo.novoautor.Autor;

public class DatalheSiteAutorResponse {

    private String nome;
    private String descricao;

    public DatalheSiteAutorResponse(Autor autor) {
        nome = autor.getNome();
        descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
