package br.com.mecanica.dao;

import br.com.mecanica.config.Conexao;
import br.com.mecanica.model.Cliente;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClienteDAO {
    public int cadastrar(Cliente cliente){

        String sql = "INSERT INTO clientes (nome, cpf, telefone, email, endereco) VALUES (?, ?, ?, ?, ?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getEndereco());

            stmt.executeUpdate();

            var rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);//
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
