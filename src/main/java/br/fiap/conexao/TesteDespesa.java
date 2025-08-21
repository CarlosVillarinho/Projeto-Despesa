package br.fiap.conexao;

import br.fiap.modelo.Categoria;
import br.fiap.modelo.Despesa;
import br.fiap.modelo.DespesaDAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TesteDespesa {
    public static void main(String[] args) {

        //TRAZ OS OBJETOS: DAO
        DespesaDAO dao = new DespesaDAO();
        //FORMATA O MODELO DA DATA
        DateTimeFormatter mascara = DateTimeFormatter.ofPattern("dd/MM/yyyy");

//        Despesa despesa = new Despesa();
//        //ADICIONANDO ELEMENTOS NA TABELA
//        despesa.setId(102L);
//        despesa.setDescricao("Lanche na FIAP");
//        despesa.setValor(45.00);
//        despesa.setCategoria(new Categoria(4l, ""));
//        despesa.setData(LocalDate.parse("21/08/2025", mascara));
//        dao.inserir(despesa);

        //ADICIONANDO MAIS ELEMENTOS NA TABELA
//        despesa.setId(103L);
//        despesa.setDescricao("Monster para assistir aula de Java");
//        despesa.setValor(20.00);
//        despesa.setCategoria(new Categoria(3l, ""));
//        despesa.setData(LocalDate.parse("21/08/2025", mascara));
//        dao.inserir(despesa);

        List<Despesa> Lista = dao.listar();
        for (Despesa despesa : Lista) {
            System.out.println(despesa.getId());
            System.out.println(despesa.getDescricao());
            System.out.println(despesa.getValor());
            System.out.println(despesa.getData());
            System.out.println(despesa.getCategoria().getId());
        }
    }
}
