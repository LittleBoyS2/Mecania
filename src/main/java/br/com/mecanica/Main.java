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

            // --- CADASTRO DO CLIENTE ---
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

            int idCliente = clienteDAO.cadastrar(cliente);

            if (idCliente == -1) {
                System.out.println("Erro ao cadastrar cliente!");
                return;
            }


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

            veiculo.setIdCliente(idCliente);

            VeiculoDAO veiculoDAO = new VeiculoDAO();

            int idVeiculo = veiculoDAO.cadastrar(veiculo);
            if (idVeiculo <= 0) {
                System.out.println("Erro ao cadastrar veículo!");
                return;
            }

            System.out.println("Veículo cadastrado com sucesso!");


            // --- CADASTRO DA ORDEM DE SERVIÇO ---

            System.out.println("\n>>> Abrindo Ordem de Serviço");
            OrdemServico os = new OrdemServico();
            OrdemServicoDAO dao = new OrdemServicoDAO();

            os.setVeiculo(veiculo);

            System.out.print("Descrição do Problema: ");
            os.setProblema(input.nextLine());

            System.out.print("Diagnóstico Inicial: ");
            os.setDiagnostico(input.nextLine());

            System.out.print("Valor Total Estimado (coloque . inves de ,): ");
            os.setValorTotal(Double.parseDouble(input.nextLine()));

            os.setStatus("Aberto");
            os.setDataEntrada("2026-03-31");

            veiculo.setId(idVeiculo);
            dao.inserir(os);

            System.out.println("Ordem de Serviço (OS) cadastrada com sucesso!");



            int opcao;

            do {
                System.out.println("\n=== MENU ===");
                System.out.println("1 - Listar OS");
                System.out.println("2 - Atualizar OS");
                System.out.println("3 - Deletar OS");
                System.out.println("4 - Gravar");
                System.out.print("Escolha: ");
                opcao = input.nextInt();
                input.nextLine();

                switch (opcao) {

                    case 1:

                        List<OrdemServico> lista = dao.listar();

                        if (lista.isEmpty()) {
                            System.out.println("Nenhuma OS encontrada.");
                        } else {
                            for (OrdemServico osItem : lista) {

                                System.out.println("\n--- ORDEM DE SERVIÇO ---");
                                System.out.println("ID: " + osItem.getId());
                                System.out.println("Problema: " + osItem.getProblema());
                                System.out.println("Diagnóstico: " + osItem.getDiagnostico());
                                System.out.println("Status: " + osItem.getStatus());
                                System.out.println("Data Entrada: " + osItem.getDataEntrada());
                                System.out.println("Data Saída: " + osItem.getDataSaida());
                                System.out.println("Valor: " + osItem.getValorTotal());

                                System.out.println("Veículo:");
                                System.out.println("  ID: " + osItem.getVeiculo().getId());
                                System.out.println("  Modelo: " + osItem.getVeiculo().getModelo());
                                System.out.println("  Placa: " + osItem.getVeiculo().getPlaca());
                            }
                        }

                        break;

                    case 2:


                        System.out.print("ID: ");
                        os.setId(input.nextInt());
                        input.nextLine();

                        System.out.print("Problema: ");
                        os.setProblema(input.nextLine());

                        System.out.print("Diagnóstico: ");
                        os.setDiagnostico(input.nextLine());

                        System.out.print("Status: ");
                        os.setStatus(input.nextLine());

                        System.out.print("Data saída: ");
                        os.setDataSaida(input.nextLine());

                        System.out.print("Valor total: ");
                        os.setValorTotal(Double.parseDouble(input.nextLine().replace(",", ".")));

                        dao.atualizar(os);

                        System.out.println("OS atualizada com sucesso!");
                        break;

                    case 3:

                        System.out.print("ID: ");
                        os.setId(input.nextInt());
                        input.nextLine();

                        System.out.print("Tem certeza que deseja deletar? (s/n): ");
                        String confirm = input.nextLine();

                        if (confirm.equalsIgnoreCase("s")) {
                            dao.deletar(os.getId());
                            System.out.println("OS deletada com sucesso!");
                        } else {
                            System.out.println("Operação cancelada.");
                        }
                        break;

                    case 4:
                        System.out.println("Gravando...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }

            } while (opcao != 4);

        } catch (Exception e) {
            System.err.println("\n[ERRO]: Ocorreu um problema durante a execução:");
            e.printStackTrace();
        } finally {

            input.close();
        }
    }
}