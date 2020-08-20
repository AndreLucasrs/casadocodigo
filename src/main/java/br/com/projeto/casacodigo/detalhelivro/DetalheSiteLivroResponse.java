package br.com.projeto.casacodigo.detalhelivro;

import br.com.projeto.casacodigo.novoLivro.Livro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class DetalheSiteLivroResponse {

    private String titulo;
    private DatalheSiteAutorResponse autor;
    private String isbn;
    private int numeroPaginas;
    private BigDecimal preco;
    private String resumo;
    private String sumario;
    private String dataPublicacao;

    public DetalheSiteLivroResponse(Livro livro) {
        titulo = livro.getTitulo();
        autor = new DatalheSiteAutorResponse(livro.getAutor());
        isbn = livro.getIsbn();
        numeroPaginas = livro.getNumeroPaginas();
        preco = livro.getPreco();
        resumo = livro.getResumo();
        sumario = livro.getSumario();
        dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public DatalheSiteAutorResponse getAutor() {
        return autor;
    }

    public void setAutor(DatalheSiteAutorResponse autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }
}
