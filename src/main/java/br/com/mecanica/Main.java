<<<<<<< HEAD
package br.com.mecanica;

import br.com.mecanica.config.Conexao;
import br.com.mecanica.dao.ClienteDAO;
import br.com.mecanica.model.Cliente;
import br.com.mecanica.dao.VeiculoDAO;
import br.com.mecanica.model.Veiculo;
import br.com.mecanica.dao.OrdemServicoDAO;
import br.com.mecanica.model.OrdemServico;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            // Tenta estabelecer conexão inicial
            Conexao.conectar();
            System.out.println("Conexão com o banco estabelecida!");

            // --- CADASTRO DE CLIENTE ---
            Cliente cliente = new Cliente();
            System.out.println("\n>>> Cadastro de Cliente");
            System.out.print("Nome: ");
            cliente.setNome(input.nextLine());

            System.out.print("CPF: ");
            cliente.setCpf(input.nextLine());

            System.out.print("Telefone: ");
            cliente.setTelefone(input.nextLine());

            System.out.print("Email: ");
            cliente.setEmail(input.nextLine());

            System.out.print("Endereço: ");
            cliente.setEndereco(input.nextLine());

            ClienteDAO clienteDAO = new ClienteDAO();
            clienteDAO.cadastrar(cliente);
            System.out.println("Cliente cadastrado com sucesso!");

            // --- CADASTRO DE VEÍCULO ---
            Veiculo veiculo = new Veiculo();
            System.out.println("\n>>> Cadastro de Veículo");
            System.out.print("Placa: ");
            veiculo.setPlaca(input.nextLine());

            System.out.print("Modelo: ");
            veiculo.setModelo(input.nextLine());

            System.out.print("Ano: ");
            veiculo.setAno(input.nextLine());

            System.out.print("Cor: ");
            veiculo.setCor(input.nextLine());

            System.out.print("Marca: ");
            veiculo.setMarca(input.nextLine());

            // Aqui associamos o veículo ao cliente (se sua classe Veiculo tiver esse campo)
            // veiculo.setCliente(cliente);

            VeiculoDAO veiculoDAO = new VeiculoDAO();
            veiculoDAO.cadastrar(veiculo);
            System.out.println("Veículo cadastrado com sucesso!");

            // --- CADASTRO DE ORDEM DE SERVIÇO ---
            System.out.println("\n>>> Abrindo Ordem de Serviço");
            OrdemServico os = new OrdemServico();

            // Associamos o objeto veiculo que acabamos de preencher
            os.setVeiculo(veiculo);

            System.out.print("Descrição do Problema: ");
            os.setProblema(input.nextLine());

            System.out.print("Diagnóstico Inicial: ");
            os.setDiagnostico(input.nextLine());

            os.setStatus("Aberto");
            os.setDataEntrada("2026-03-31");

            System.out.print("Valor Total Estimado: ");
            os.setValorTotal(Double.parseDouble(input.nextLine()));

            OrdemServicoDAO dao = new OrdemServicoDAO();
            dao.inserir(os);

            System.out.println("Ordem de Serviço (OS) cadastrada com sucesso!");

        } catch (Exception e) {
            System.err.println("\n[ERRO]: Ocorreu um problema durante a execução:");
            e.printStackTrace();
        } finally {
            // Fecha o scanner para evitar vazamento de memória
            input.close();
        }
    }
}
=======
public class Main {
}
>>>>>>> 8d9e572fe163169de2b9a9a897dd5cf79d506a58
