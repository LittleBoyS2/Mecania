package br.com.mecanica;

import br.com.mecanica.config.Conexao;
import br.com.mecanica.dao.ClienteDAO;
import br.com.mecanica.model.Cliente;
import br.com.mecanica.dao.VeiculoDAO;
import br.com.mecanica.model.Veiculo;
import br.com.mecanica.dao.OrdemServicoDAO;
import br.com.mecanica.model.OrdemServico;


import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {

            Conexao.conectar();
            System.out.println("Conexão com o banco estabelecida!");

            int opcao;

            do {
                System.out.println("\n=== MENU ===");
                System.out.println("1 - Cadastrar OS");
                System.out.println("2 - Listar OS");
                System.out.println("3 - Atualizar OS");
                System.out.println("4 - Deletar OS");
                System.out.println("0 - Sair");
                System.out.print("Escolha: ");
                opcao = input.nextInt();
                input.nextLine();

                switch (opcao) {

                    case 1:
                        // 🔥 CADASTRO COMPLETO

                        Cliente cliente = new Cliente();

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
                        int idCliente = clienteDAO.cadastrar(cliente);

                        if (idCliente == -1) {
                            System.out.println("Erro ao cadastrar cliente!");
                            break;
                        }

                        Veiculo veiculo = new Veiculo();

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

                        veiculo.setIdCliente(idCliente);

                        VeiculoDAO veiculoDAO = new VeiculoDAO();
                        int idVeiculo = veiculoDAO.cadastrar(veiculo);

                        if (idVeiculo <= 0) {
                            System.out.println("Erro ao cadastrar veículo!");
                            break;
                        }

                        veiculo.setId(idVeiculo);

                        OrdemServico os = new OrdemServico();

                        os.setVeiculo(veiculo);

                        System.out.print("Problema: ");
                        os.setProblema(input.nextLine());

                        System.out.print("Diagnóstico: ");
                        os.setDiagnostico(input.nextLine());

                        System.out.print("Valor: ");
                        os.setValorTotal(Double.parseDouble(input.nextLine().replace(",", ".")));

                        os.setStatus("Aberto");
                        os.setDataEntrada("2026-03-31 00:00:00");

                        OrdemServicoDAO dao = new OrdemServicoDAO();
                        dao.inserir(os);

                        System.out.println("OS cadastrada com sucesso!");
                        break;

                    case 2:
                        List<OrdemServico> lista = new OrdemServicoDAO().listar();

                        for (OrdemServico item : lista) {
                            System.out.println("\nID: " + item.getId());
                            System.out.println("Problema: " + item.getProblema());
                            System.out.println("Veículo: " + item.getVeiculo().getModelo());
                        }
                        break;

                    case 3:
                        OrdemServico osAtualizar = new OrdemServico();

                        System.out.print("ID: ");
                        osAtualizar.setId(input.nextInt());
                        input.nextLine();

                        System.out.print("Problema: ");
                        osAtualizar.setProblema(input.nextLine());

                        System.out.print("Diagnóstico: ");
                        osAtualizar.setDiagnostico(input.nextLine());

                        System.out.print("Status: ");
                        osAtualizar.setStatus(input.nextLine());

                        System.out.print("Data saída: ");
                        osAtualizar.setDataSaida(input.nextLine());

                        System.out.print("Valor: ");
                        osAtualizar.setValorTotal(Double.parseDouble(input.nextLine().replace(",", ".")));

                        new OrdemServicoDAO().atualizar(osAtualizar);

                        System.out.println("Atualizado!");
                        break;

                    case 4:
                        System.out.print("ID: ");
                        int id = input.nextInt();
                        input.nextLine();

                        new OrdemServicoDAO().deletar(id);

                        System.out.println("Deletado!");
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }

            } while (opcao != 0);
        } catch (Exception e) {
            System.err.println("\n[ERRO]: Ocorreu um problema durante a execução:");
            e.printStackTrace();
        } finally {

            input.close();
        }
    }
}