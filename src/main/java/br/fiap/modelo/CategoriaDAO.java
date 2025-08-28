package br.fiap.modelo;

import br.fiap.conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    //ATRIBUTOS
    private PreparedStatement ps; //ELA SABE ONDE ESTA O BANCO DE DADOS, COMO CHEGAR E TRANSPORTA O SQL QUE VAI PARA DENTRO DO BANCO
    private ResultSet rs;
    private String sql;

    //METODOS
    public void inserir(Categoria categoria){
        //sql = "insert into java_categoria values (?, ?)"; //TRADICIONAL
        sql = "insert into java_categoria values (seqc.nextval, ?)"; //SEQUENCIA

        try(Connection connection = Conexao.conectar()){
            ps = connection.prepareStatement(sql);
           //ps.setLong(1, categoria.getId()); //TRADICIONAL
            //ps.setString(2, categoria.getCategoria()); //TRADICIONAL
            ps.setString(1, categoria.getCategoria()); //SEQUENCIA
            ps.execute();
        }
        catch (SQLException e){
            System.out.println("erro ao inserir no banco de dados\n" + e);
        }
    }

    public List<Categoria> listar(){
        List<Categoria> lista = new ArrayList<>();
        sql = "select * from java_categoria";

        try(Connection connection = Conexao.conectar()){
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                lista.add(new Categoria(rs.getLong("id_categoria"), rs.getString("categoria")));
            }
        }
        catch (SQLException e){
            System.out.println("erro ao listar categorias\n" + e);
        }

        return lista;
    }
}
