package cadastrar;

import DAO.ViagemDAO;
import entity.Viagem;

import java.util.Scanner;

public class CrudViagens {
    public static void main(String[] args) {
        try {
            ViagemDAO viagemx = new ViagemDAO();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Nova Viagem");
            System.out.println("2 - Visualizar Viagens Cadastradas");
            System.out.println("3 - Atualizar Viagem");
            System.out.println("4 - Deletar Viagem");
            System.out.println("5 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    scanner.nextLine();
                    Viagem criarViagem = new Viagem();
                    System.out.println("Digite o id do Cliente: ");
                    int idDoCliente = scanner.nextInt();
                    scanner.nextLine();
                    criarViagem.setId_cliente(idDoCliente);

                    System.out.println("Digite o id da passagem: ");
                    int idDaPassagem = scanner.nextInt();
                    scanner.nextLine();
                    criarViagem.setId_passagem(idDaPassagem);

                    new ViagemDAO().cadastrarViagem(criarViagem);
                    scanner.close();
                    System.out.println("Viagem cadastrada com Sucesso! ");
                    break;
                case 2:
                    for(Viagem lista : viagemx.listarViagens()) {
                        System.out.println("-------------------- ");
                        System.out.println("id: "+lista.getId());
                        System.out.println("Cidade: "+lista.getId_cliente());
                        System.out.println("Preço: "+lista.getId_passagem());
                    }
                    scanner.close();
                    break;
                case 3:
                    Viagem viagemModificada = new Viagem();
                    System.out.println("Digite o ID do cliente que deseja modificar: ");
                    int idModificadoCliente = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("digite o ID da Passagem que deseja modificar: ");
                    int idModificadoPassagem = scanner.nextInt();
                    scanner.nextLine();
                    viagemModificada.setId_cliente(idModificadoCliente);
                    viagemModificada.setId_passagem(idModificadoPassagem);

                    viagemx.modificarViagem(viagemModificada);
                    scanner.close();
                    System.out.println("Viagem Alterada Com Sucesso! ");
                    break;
                case 4:
                    System.out.println("Digite o id do Viagem que deseja deletar.");
                    int idDeletarViagem = scanner.nextInt();
                    scanner.nextLine();
                    viagemx.deletarViagem(idDeletarViagem);
                    scanner.close();
                    System.out.println("Viagem Deletada Com Sucesso! ");
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
