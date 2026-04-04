package br.com.mecanica.dao;
import br.com.mecanica.config.Conexao;
import br.com.mecanica.model.Cliente;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClienteDAO {
    public void cadastrar(Cliente cliente){

        String sql = "INSERT INTO clientes (nome, cpf, telefone, email, endereco) VALUES (?, ?, ?, ?, ?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getEndereco());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
