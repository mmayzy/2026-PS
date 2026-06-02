import java.util.Scanner;

public class CardapioRestaurante {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("=====================================================");
        System.out.println("     CARDÁPIO ELETRÔNICO - CAFÉ SOL NASCENTE");
        System.out.println("=====================================================");
        System.out.println("1 - Capuccino ..........    R$ 8,00");
        System.out.println("2 - Espresso  ..........    R$ 9,00");
        System.out.println("3 - Americano ..........    R$ 3,00");
        System.out.println("4 - Latte     ..........    R$ 5,00");
        System.out.println("5 - Chá       ..........    R$ 5,00");
        System.out.println("6 - Suco      ..........    R$ 8,00");
        System.out.println("=====================================================");

        System.out.print("Escolha uma opção: ");
        int opcao = entrada.nextInt();

        
        String itemEscolhido = "";
        double precoUnitario = 0.0;
        boolean opcaoValida = true;

       
        switch (opcao) {
            case 1:
                itemEscolhido = "Capuccino";
                precoUnitario = 8.00;
                break;
            case 2:
                itemEscolhido = "Espresso";
                precoUnitario = 9.00;
                break;
            case 3:
                itemEscolhido = "Americano";
                precoUnitario = 3.00;
                break;
            case 4:
                itemEscolhido = "Latte";
                precoUnitario = 5.00;
                break;
            case 5:
                itemEscolhido = "Chá";
                precoUnitario = 5.00;
                break;
            case 6:
                itemEscolhido = "Suco";
                precoUnitario = 8.00;
                break;
            default:
                System.out.println("Não temos essa opção no cardápio.");
                opcaoValida = false; 
                break;
        }

       
        if (opcaoValida) {
            System.out.print("Digite a quantidade desejada: ");
            int quantidade = entrada.nextInt();

            if (quantidade <= 0) {
                System.out.println("Quantidade inválida! Seu pedido foi cancelado.");
            } else {
                
                double valorTotal = precoUnitario * quantidade;

                
                System.out.println("\n=====================================================");
                System.out.println("           NOTA FISCAL - CAFÉ SOL NASCENTE                 ");
                System.out.println("=====================================================");
                System.out.printf("Item:           %s%n", itemEscolhido);
                System.out.printf("Preço Unitário: R$ %.2f%n", precoUnitario);
                System.out.printf("Quantidade:     %d%n", quantidade);
                System.out.println("-----------------------------------------------------");
                System.out.printf("VALOR TOTAL:    R$ %.2f%n", valorTotal);
                System.out.println("=====================================================");
            }
        }

        entrada.close();
    }
}