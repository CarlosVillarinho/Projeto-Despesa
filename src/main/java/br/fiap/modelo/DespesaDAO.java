package br.fiap.modelo;

import br.fiap.conexao.Conexao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DespesaDAO {
    //ATRIBUTOS
    private PreparedStatement ps; //ELA SABE ONDE ESTA O BANCO DE DADOS, COMO CHEGAR E TRANSPORTA O SQL QUE VAI PARA DENTRO DO BANCO
    private ResultSet rs;
    private String sql;

    //METODOS
    public void inserir(Despesa despesa){
        //sql = "insert into java_despesa values (?, ?, ?, ?, ?)"; //TRADICIONAL
        sql = "insert into java_despesa values (seqd.nextval, ?, ?, ?, ?)"; //SEQUENCIA

        try(Connection connection = Conexao.conectar()){
            ps = connection.prepareStatement(sql);
            //ABAIXO CONFIGURAMOS CADA UMA DES INTERROGACOES, CADA ELEMNTO POR SUA VEZ
            //ps.setLong(1, despesa.getId()); //TRADICIONAL
            //ps.setString(2, despesa.getDescricao()); //TRADICIONAL
            ps.setString(1, despesa.getDescricao()); //SEQUENCIA
           //ps.setDouble(3, despesa.getValor()); //TRADICIONAL
            ps.setString(2, despesa.getDescricao()); //SEQUENCIA
            //ps.setDate(4, Date.valueOf(despesa.getData())); //TRADICIONAL
            ps.setString(3, despesa.getDescricao()); //SEQUENCIA
            //ps.setLong(5, despesa.getCategoria().getId()); //TRADICIONAL
            ps.setString(4, despesa.getDescricao()); //SEQUENCIA
            ps.execute();
        }
        catch (SQLException e){
            System.out.println("erro ao inserir despesa\n" + e);
        }
    }

    public List<Despesa> listar(){
        List<Despesa> lista = new ArrayList<>();
        sql = "select * from java_despesa";

        try(Connection connection = Conexao.conectar()){
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Despesa despesa = new Despesa();
                despesa.setId(rs.getLong("id_despesa"));
                despesa.setDescricao(rs.getString("descricao"));
                despesa.setValor(rs.getDouble("valor"));
                despesa.setData(rs.getDate("data").toLocalDate());
                despesa.setCategoria(new Categoria(rs.getLong("id_categoria"), ""));
                lista.add(despesa);
            }
        }
        catch (SQLException e){
            System.out.println("erro ao listar despesa\n" + e);
        }

        return lista;
    }

    public List<Despesa> relatorio(){
        List<Despesa> lista = new ArrayList<>();
        sql = "select d.descricao, d.valor, d.data, c.categoria\n" +
                "from java_despesa d\n" +
                "inner join java_categoria c\n" +
                "on d.id_categoria = c.id_categoria";

        try(Connection connection = Conexao.conectar()){
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Despesa despesa = new Despesa();
                despesa.setDescricao(rs.getString("descricao"));
                despesa.setValor(rs.getDouble("valor"));
                despesa.setData(rs.getDate("data").toLocalDate());
                despesa.setCategoria(new Categoria(0L, rs.getString("categoria")));
                lista.add(despesa);
            }
        }
        catch (SQLException e){
            System.out.println("erro ao listar relatorio\n" + e);
        }

        return lista;
    }
}
