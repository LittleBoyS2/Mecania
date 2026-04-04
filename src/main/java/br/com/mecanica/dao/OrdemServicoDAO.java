package br.com.mecanica.dao;
<<<<<<< HEAD
import br.com.mecanica.config.Conexao;
import br.com.mecanica.model.Cliente;
import br.com.mecanica.model.Veiculo;
import br.com.mecanica.model.OrdemServico;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdemServicoDAO {
    public void inserir(OrdemServico os) throws SQLException {
        String sql = "INSERT INTO ordem_servico (Id, problema, diagnostico, status, data_entrada, data_saida, valor_total) VALUES (?, ?, ?, ?, ?, ?, ?)";

        Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, os.getVeiculo().getId());
        stmt.setString(2, os.getProblema());
        stmt.setString(3, os.getDiagnostico());
        stmt.setString(4, os.getStatus());
        stmt.setString(5, os.getDataEntrada());
        stmt.setString(6, os.getDataSaida());
        stmt.setDouble(7, os.getValorTotal());

        stmt.execute();
        stmt.close();
        conn.close();
    }

    public List<OrdemServico> listar() throws SQLException {
        List<OrdemServico> lista = new ArrayList<>();

        String sql = "SELECT os.*, v.id_veiculo, v.modelo, v.placa " +
                "FROM ordem_servico os " +
                "JOIN veiculos v ON os.id_veiculo = v.id_veiculo";

        Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            OrdemServico os = new OrdemServico();

            os.setId(rs.getInt("id_os"));
            os.setProblema(rs.getString("problema"));
            os.setDiagnostico(rs.getString("diagnostico"));
            os.setStatus(rs.getString("status"));
            os.setDataEntrada(rs.getString("data_entrada"));
            os.setDataSaida(rs.getString("data_saida"));
            os.setValorTotal(rs.getDouble("valor_total"));

            // 🔗 criando o veículo
            Veiculo v = new Veiculo();
            v.setId(rs.getInt("id_veiculo"));
            v.setModelo(rs.getString("modelo"));
            v.setPlaca(rs.getString("placa"));

            os.setVeiculo(v);

            lista.add(os);
        }

        rs.close();
        stmt.close();
        conn.close();

        return lista;
    }

    public void atualizar(OrdemServico os) throws SQLException {
        String sql = "UPDATE ordem_servico SET problema=?, diagnostico=?, status=?, data_saida=?, valor_total=? WHERE id_os=?";

        Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, os.getProblema());
        stmt.setString(2, os.getDiagnostico());
        stmt.setString(3, os.getStatus());
        stmt.setString(4, os.getDataSaida());
        stmt.setDouble(5, os.getValorTotal());
        stmt.setInt(6, os.getId());

        stmt.execute();
        stmt.close();
        conn.close();
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM ordem_servico WHERE id_os = ?";

        Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);
        stmt.execute();

        stmt.close();
        conn.close();
    }
=======

public class OrdemServico {
>>>>>>> 8d9e572fe163169de2b9a9a897dd5cf79d506a58
}
