package br.com.mecanica.dao;

import br.com.mecanica.config.Conexao;
import br.com.mecanica.model.Veiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VeiculoDAO {


    public int cadastrar(Veiculo veiculo) {
        String sql = "INSERT INTO veiculos (placa, marca, modelo, cor, ano, id_cliente) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getMarca());
            stmt.setString(3, veiculo.getModelo());
            stmt.setString(4, veiculo.getCor());
            stmt.setString(5, veiculo.getAno());
            stmt.setInt(6, veiculo.getIdCliente());

            stmt.executeUpdate();

            var rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // 👈 ID gerado
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }
}