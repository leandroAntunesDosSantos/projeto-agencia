package cadastrar;

import DAO.PassagemDAO;
import entity.Passagem;
import java.util.Scanner;

public class CrudPassagens {
    public static void main(String[] args) throws Exception {
        try {
            PassagemDAO passagemx = new PassagemDAO();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Criar Passagem");
            System.out.println("2 - Visualizar Passagens Disponiveis");
            System.out.println("3 - Atualizar Passagem");
            System.out.println("4 - Deletar Passagem");
            System.out.println("5 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    scanner.nextLine();
                    Passagem criarPassagem = new Passagem();
                    System.out.println("Digite o nome da cidade: ");
                    String cidade = scanner.nextLine();
                    criarPassagem.setCidade(cidade);

                    System.out.println("Digite o preço da passagem: ");
                    int preco = scanner.nextInt();
                    scanner.nextLine();
                    criarPassagem.setPreco(preco);
                    new PassagemDAO().cadastrarPassagem(criarPassagem);
                    scanner.close();
                    System.out.println("Passagem Criada com Sucesso! ");
                    break;
                case 2:
                    for(Passagem lista : passagemx.listarPassagens()) {
                        System.out.println("-------------------- ");
                        System.out.println("id: "+lista.getId());
                        System.out.println("Cidade: "+lista.getCidade());
                        System.out.println("Preço: "+lista.getPreco());
                    }
                    scanner.close();
                    break;
                case 3:
                     Passagem passagemModificada = new Passagem();
                    System.out.println("Digite o ID que deseja modificar: ");
                    int idModificado = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("digite o nome da cidade a ser modificada: ");
                    String cidadeNova = scanner.nextLine();
                    System.out.println("Digite o preco da passagem: ");
                    int precoNovo = scanner.nextInt();
                    scanner.nextLine();
                    passagemModificada.setCidade(cidadeNova);
                    passagemModificada.setPreco(precoNovo);
                    passagemModificada.setId(idModificado);

                    passagemx.modificar(passagemModificada);
                    scanner.close();
                    System.out.println("Passagem Modificada Com Sucesso! ");
                    break;
                case 4:
                    System.out.println("Digite o id do cliente que você quer deletar.");
                    int idDeletar = scanner.nextInt();
                    scanner.nextLine();
                    passagemx.deletar(idDeletar);
                    scanner.close();
                    System.out.println("Passagem Deletada Com Sucesso! ");
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
