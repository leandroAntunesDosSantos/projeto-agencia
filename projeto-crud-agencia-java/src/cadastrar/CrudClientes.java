package cadastrar;

import DAO.ClienteDAO;
import entity.Cliente;


import java.util.Scanner;

public class CrudClientes {
    public static void main(String[] args) {
        try {
            ClienteDAO clientex = new ClienteDAO();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Visualizar Clientes Cadastrados");
            System.out.println("3 - Atualizar Cadastro Cliente");
            System.out.println("4 - Deletar Cliente");
            System.out.println("5 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    scanner.nextLine();
                    Cliente cadastrarCliente = new Cliente();
                    System.out.println("Digite o nome do Cliente: ");
                    String nomeCliente = scanner.nextLine();
                    cadastrarCliente.setNome(nomeCliente);

                    System.out.println("Digite o email do cliente: ");
                    String email = scanner.nextLine();
                    cadastrarCliente.setEmail(email);

                    System.out.println("Digite o telefone do cliente: ");
                    String telefone = scanner.nextLine();
                    cadastrarCliente.setTelefone(telefone);

                    System.out.println("Digite o endereço do Cliente: ");
                    String endereco = scanner.nextLine();
                    cadastrarCliente.setEndereco(endereco);

                    System.out.println("Digite Uma Senha: ");
                    String senha = scanner.nextLine();
                    cadastrarCliente.setSenha(senha);

                    new ClienteDAO().cadastrarCliente(cadastrarCliente);
                    scanner.close();
                    System.out.println("Cadastro Criada com Sucesso! ");
                    break;
                case 2:
                    for(Cliente lista : clientex.listarClientes()) {
                        System.out.println("-------------------- ");
                        System.out.println("id: "+lista.getId());
                        System.out.println("Nome: "+lista.getNome());
                        System.out.println("Email: "+lista.getEmail());
                        System.out.println("Telefone: "+lista.getTelefone());
                        System.out.println("Endereço: "+lista.getEndereco());
                        System.out.println("Senha: "+lista.getSenha());
                    }
                    scanner.close();
                    break;
                case 3:
                    Cliente clienteModificado = new Cliente();
                    System.out.println("Digite o ID que deseja modificar: ");
                    int idModificado = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("digite o nome do cliente a ser modificado: ");
                    String nomeNovo = scanner.nextLine();

                    System.out.println("Digite o email a ser modificado: ");
                    String emailNovo = scanner.nextLine();

                    System.out.println("Digite o telefone a ser modificado: ");
                    String telefoneNovo = scanner.nextLine();

                    System.out.println("Digite o endereço a ser modificado:");
                    String enderecoNovo = scanner.nextLine();

                    System.out.println("Digite a senha a ser modificada:");
                    String senhaNovo = scanner.nextLine();

                    clienteModificado.setId(idModificado);
                    clienteModificado.setNome(nomeNovo);
                    clienteModificado.setEmail(emailNovo);
                    clienteModificado.setTelefone(telefoneNovo);
                    clienteModificado.setEndereco(enderecoNovo);
                    clienteModificado.setSenha(senhaNovo);

                    clientex.modificarClientes(clienteModificado);
                    scanner.close();
                    System.out.println("Alteraçoes Concluidas Com Sucesso! ");
                    break;
                case 4:
                    System.out.println("Digite o id do cliente que você quer deletar.");
                    int idDeletar = scanner.nextInt();
                    scanner.nextLine();
                    clientex.deletarClientes(idDeletar);
                    scanner.close();
                    System.out.println("cliente Deletado do Registro Com Sucesso! ");
                    break;
                case 5:
                    System.out.println("Você saiu do programa!");
                    scanner.close();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
