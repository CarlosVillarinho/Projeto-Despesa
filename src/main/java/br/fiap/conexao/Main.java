package br.fiap.conexao;

import br.fiap.modelo.Categoria;
import br.fiap.modelo.CategoriaDAO;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //TESTA CONEXAO
        //System.out.println(Conexao.conectar());

        CategoriaDAO dao = new CategoriaDAO();

        //CRIA NOVOS ELEMENTOS
        //Categoria categoria = new Categoria(3L, "educaçao");
        //Categoria categoriaL = new Categoria(4L, "Comercio");

        //INSERE O DADO
        //dao.inserir(categoria);
        //dao.inserir(categoriaL);

        //SELECT, MOSTRA A TABELA COM OS ELEMENTOS
        List<Categoria> Lista = dao.listar();
        for (Categoria categoria : Lista){
            System.out.println(categoria.getId() + " ---> " + categoria.getCategoria());
        }
    }
}
