package br.com.mecanica.dao;

<<<<<<< HEAD
import br.com.mecanica.config.Conexao;
import br.com.mecanica.model.Veiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VeiculoDAO {

    // Alterado para retornar boolean: ajuda o Dashboard a saber se exibe "Sucesso" ou "Erro"
    public boolean cadastrar(Veiculo veiculo) {
        // Certifique-se de que o nome das colunas abaixo é EXATAMENTE igual ao do seu banco
        // Se houver uma coluna id_cliente, adicione ela aqui também
        String sql = "INSERT INTO veiculo (placa, marca, modelo, cor, ano) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getMarca());
            stmt.setString(3, veiculo.getModelo());
            stmt.setString(4, veiculo.getCor());
            stmt.setString(5, veiculo.getAno());

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar veículo: " + e.getMessage());
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
=======
public class VeiculoDAO {
}
>>>>>>> 8d9e572fe163169de2b9a9a897dd5cf79d506a58
