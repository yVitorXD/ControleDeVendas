/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.model.Clientes;
import br.com.projeto.jdbc.ConnectionFactory;

import com.mysql.cj.xdevapi.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.mysql.cj.protocol.Resultset;
import java.sql.ResultSet;

/**
 *
 * @author Vitor
 */
//Esta classe sera responsavel pelos métodos que
//vao fazer interaçao com a tabela de clientes
public class ClientesDAO {

    private Connection con;

    public ClientesDAO() {
        //con vai receber uma nova conexao
        this.con = new ConnectionFactory().getConnection();
    }

    //Método para Cadastrar Cliente
    public void cadastrarCliente(Clientes obj) {

        try {

            //1 passo - criar o comando sql
            String sql = "insert into tb_clientes(nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());

            //3 passo - Executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    //Método Alterar Cliente
    public void alterarCliente() {

    }

    //Método Excluir Cliente
    public void excluirCliente() {

    }

    //Método Listar todos os Clientes
    public List<Clientes> listarCliente() {

        //Cria uma Lista, Executa o comando, pega o resultado do comando
        //armazena em um objeto o cliente, adiciona esse objeto na lista e retorna o objeto
        
        try {

            //1 passo criar a list
            List<Clientes> lista = new ArrayList<>();

            //2 passo - criar o comando sql, organizar e executar
            String sql = "select * from tb_clientes";
            PreparedStatement stmt = con.prepareStatement(sql);

            //
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Clientes obj = new Clientes();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("cpf"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);

            }

            return lista;

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro " + erro);
            return null;

        }

        
        
    }

}
