package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven;

import br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.item_leilao.ItemLeilaoController;
import br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.lance.LanceController;
import br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.leilao.LeilaoController;
import br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.participante.ParticipanteController;

import java.util.Scanner;

public class HomeController {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;
        do {
            System.out.print("\n-------  Home -------\n");
            System.out.print(
                    """
                        1. Manter Participante
                        2. Manter Leilão
                        3. Manter Itens
                        4. Manter Lance
                        0. Sair\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> ParticipanteController.main(null);
                case 2 -> LeilaoController.main(null);
                case 3 -> ItemLeilaoController.main(null);
                case 4 -> LanceController.main(null);
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while(opcao != 0) ;
        System.out.println("\n\n!!!!!!!! Fim da aplicação !!!!!!!!");
        input.close();
    }
}
