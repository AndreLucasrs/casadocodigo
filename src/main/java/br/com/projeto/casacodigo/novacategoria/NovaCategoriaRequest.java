package br.com.projeto.casacodigo.novacategoria;

import br.com.projeto.casacodigo.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public Categoria toModel() {
        return new Categoria(this.nome);
    }

    public String getNome() {
        return nome;
    }
}
