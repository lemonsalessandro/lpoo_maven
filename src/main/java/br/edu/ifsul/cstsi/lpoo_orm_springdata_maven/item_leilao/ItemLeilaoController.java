package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.item_leilao;


import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class ItemLeilaoController {

    private static ItemLeilaoService ItemLeilaoService;
    private static final Scanner input = new Scanner(System.in);


    //Injeção de dependência
    public ItemLeilaoController(ItemLeilaoService ItemLeilaoService) {
        ItemLeilaoController.ItemLeilaoService = ItemLeilaoService;
    }

    public static void main(String[] args) {

        int opcao;
        do {
            System.out.print("\n\"-------  MENU ITENS -------\"");
            System.out.print(
                    """
                            \n1. Inserir novo participante
                            2. Atualizar um participante
                            3. Excluir um participante
                            4. Listar todos os clientes
                            5. Buscar participante pelo ID
                            6. Buscar participantes pelo nome
                            7. Buscar clientes por UF
                            0. Sair\s""");

            opcao = input.nextInt();
            input.nextLine();

            System.out.println(opcao);
        }while (opcao != 0);
    }
}
