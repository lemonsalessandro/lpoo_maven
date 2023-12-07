package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.participante;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class ParticipanteController {
    private static ParticipanteService participanteService;

    public ParticipanteController(ParticipanteService ParticipanteService){
        ParticipanteController.participanteService = ParticipanteService;
    }

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.print("\n\"-------  MENU PARTICIPANTE -------\"");
            System.out.print(
                    """
    
                        1. Inserir Participante
                        2. Atualizar Participante
                        3. Excluir Participante
                        4. Listar todos Participantes
                        5. Buscar por ID
                        6. Buscar por nome
                        7. Buscar por email
                        0. Sair:\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> insert();
                case 2 -> update();
                case 3 -> delete();
                case 4 -> select();
                case 5 -> selectParticipanteByID();
                case 6 -> selectParticipanteByNome();
                case 7 -> selectParticipanteByEmail();
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
    }

    private static void insert(){
        Participante participante = new Participante();
        System.out.println("\n++++++ Cadastro de Participante ++++++");
        System.out.print("Nome do participante: ");
        participante.setNome(input.nextLine());
        System.out.print("Email do participante: ");
        participante.setEmail(input.nextLine());
        System.out.print("Login do participante: ");
        participante.setLogin(input.nextLine());
        System.out.print("Senha do participante");
        participante.setSenha(input.nextLine());
        System.out.print("Telefone do participante: ");
        participante.setTelefone(input.nextLine());
//        System.out.print("Endereço do participante: ");
//        participante.setEndereco(input.nextLine());
        System.out.println("Participante cadastrado!" + participanteService.insert(participante));
    }

    private static void update() {
        System.out.println("\n++++++ Alterar partiripante ++++++");
        Participante participante;
        int opcao = 0;
        do {
            System.out.print("\nDigite o ID do participante (Zero p/sair): ");
            long codigo = input.nextLong();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else {
                participante = participanteService.getParticipanteByID(codigo);
                if (participante == null) {
                    System.out.println("ID inválido.");
                } else {
                    System.out.println("Nome: " + participante.getNome());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite o novo nome do participante: ");
                        participante.setNome(input.nextLine());
                    }






                    opcao = 1;
                }
            }
        } while (opcao != 0);
    }


    private static void delete() {
        System.out.println("\n++++++ Excluir participante ++++++");
        Participante participante;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código do participante (Zero p/sair): ");
            long codigo = input.nextLong();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else if(codigo > 0){
                participante = participanteService.getParticipanteByID(codigo);
                if (participante == null) {
                    System.out.println("ID inválido.");
                } else {
                    System.out.println(participante);
                    System.out.print("Excluir este participante? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        input.nextLine();
                        participanteService.delete(participante.getId());
                        System.out.println("Participante excluído com sucesso: " + participante);
                    }
                }
            } else {
                System.out.println("Código inválido!!!");
            }
        } while (opcao != 0);
    }


    private static void select() {
        System.out.println("\nLista de participantes cadastrados:\n" + participanteService.getParticipantes());
    }

    private static void selectParticipanteByID() {
        System.out.print("\nDigite o ID do participante: ");
        Participante participante = participanteService.getParticipanteByID(input.nextLong());
        input.nextLine();
        if (participante != null) {
            System.out.println(participante);
        } else {
            System.out.println("ID não encontrado.");
        }
    }

    private static void selectParticipanteByNome() {
        System.out.print("Digite o nome do participante: ");
        String nome = input.next();
        System.out.println("Chave de pesquisa: " + nome);
        List<Participante> participantes = participanteService.getParticipanteByNome(nome + "%");

        if (participantes.isEmpty()) {
            System.out.println("Não há registros correspondentes para: " + nome);
        } else {
            System.out.println(participantes);
        }
    }

    private static void selectParticipanteByEmail() {
        System.out.print("Digite o email do participante: ");
        String email = input.next();
        System.out.println("Chave de pesquisa: " + email);
        List<Participante> participantes = participanteService.getParticipanteByEmail(email + "%");
        if (participantes.isEmpty()) {
            System.out.println("Não há registros correspondentes para: " + email);
        } else {
            System.out.println(participantes);
        }
    }
}
