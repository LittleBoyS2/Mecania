package br.com.mecanica.dao;
<<<<<<< HEAD
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
=======

public class ClienteDAO {
>>>>>>> 8d9e572fe163169de2b9a9a897dd5cf79d506a58
}
