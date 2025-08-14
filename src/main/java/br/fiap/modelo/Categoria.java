package br.fiap.modelo;

public class Categoria {
    //ATRIBUTOS
    private Long id;
    private String categoria;

    //CONSTRUCAO
    public Categoria(Long id, String categoria) {
        this.id = id;
        this.categoria = categoria;
    }

    //GET e SET
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
