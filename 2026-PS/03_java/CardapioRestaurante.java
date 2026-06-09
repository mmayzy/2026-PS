import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CardapioRestaurante {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Random random = new Random();

        // Listas dinâmicas para gerenciar o carrinho de compras
        ArrayList<String> itensCarrinho = new ArrayList<>();
        ArrayList<Integer> qtdsCarrinho = new ArrayList<>();
        ArrayList<Double> precosCarrinho = new ArrayList<>();

        boolean continuarComprando = true;

        while (continuarComprando) {
            System.out.println("\n=====================================================");
            System.out.println("     CARDÁPIO ELETRÔNICO - CAFÉ CREPÚSCULO");
            System.out.println("=====================================================");
            System.out.println("1 - Cafés");
            System.out.println("2 - Outras bebidas");
            System.out.println("3 - Bolos");
            System.out.println("4 - CONFERIR CARRINHO / FINALIZAR");
            System.out.println("=====================================================");

            System.out.print("Escolha uma categoria: ");
            int categoria = entrada.nextInt();

            String itemEscolhido = "";
            double precoUnitario = 0.0;
            boolean opcaoValida = false; 

            switch (categoria) {
                case 1: // SUBMENU: CAFÉS
                    System.out.println("\n--- CAFÉS ---");
                    System.out.println("1 - Espresso .......... R$ 6,00");
                    System.out.println("2 - Capuccino ......... R$ 9,00");
                    System.out.println("3 - Latte ............. R$ 10,00");
                    System.out.println("4 - Americano ......... R$ 5,00");
                    System.out.print("Escolha o café: ");
                    int opcaoCafe = entrada.nextInt();
                    
                    switch (opcaoCafe) {
                        case 1: itemEscolhido = "Espresso"; precoUnitario = 6.00; opcaoValida = true; break;
                        case 2: itemEscolhido = "Capuccino"; precoUnitario = 9.00; opcaoValida = true; break;
                        case 3: itemEscolhido = "Latte"; precoUnitario = 10.00; opcaoValida = true; break;
                        case 4: itemEscolhido = "Americano"; precoUnitario = 5.00; opcaoValida = true; break;
                        default: System.out.println("[Erro] Opção de café inválida."); break;
                    }
                    break;

                case 2: // SUBMENU: BEBIDAS
                    System.out.println("\n--- BEBIDAS E SUCOS ---");
                    System.out.println("1 - Suco de Laranja ... R$ 8,00");
                    System.out.println("2 - Chá Gelado ........ R$ 7,00");
                    System.out.println("3 - Limonada .......... R$ 9,00");
                    System.out.println("4 - Chá Quente ........ R$ 7,00");
                    System.out.print("Escolha a bebida: ");
                    int opcaoBebida = entrada.nextInt();

                    switch (opcaoBebida) {
                        case 1: itemEscolhido = "Suco de Laranja"; precoUnitario = 8.00; opcaoValida = true; break;
                        case 2: itemEscolhido = "Chá Gelado"; precoUnitario = 7.00; opcaoValida = true; break;
                        case 3: itemEscolhido = "Limonada"; precoUnitario = 9.00; opcaoValida = true; break;
                        case 4: itemEscolhido = "Chá Quente"; precoUnitario = 7.00; opcaoValida = true; break;
                        default: System.out.println("[Erro] Opção de bebida inválida."); break;
                    }
                    break;

                case 3: // SUBMENU: BOLOS
                    System.out.println("\n--- BOLOS ---");
                    System.out.println("1 - Bolo de Chocolate . R$ 8,50");
                    System.out.println("2 - Bolo de Morango ... R$ 7,50");
                    System.out.println("3 - Bolo de Abacaxi ... R$ 9,00");
                    System.out.println("4 - Torta de Amora .... R$ 8,00");
                    System.out.print("Escolha o sabor: ");
                    int opcaoBolo = entrada.nextInt();

                    switch (opcaoBolo) {
                        case 1: itemEscolhido = "Bolo de Chocolate"; precoUnitario = 8.50; opcaoValida = true; break;
                        case 2: itemEscolhido = "Bolo de Morango"; precoUnitario = 7.50; opcaoValida = true; break;
                        case 3: itemEscolhido = "Bolo de Abacaxi"; precoUnitario = 9.00; opcaoValida = true; break;
                        case 4: itemEscolhido = "Torta de Amora"; precoUnitario = 8.00; opcaoValida = true; break;
                        default: System.out.println("[Erro] Sabor de bolo inválido."); break;
                    }
                    break;

                case 4: // CONFERIR CARRINHO / REVISÃO DO PEDIDO
                    if (itensCarrinho.isEmpty()) {
                        System.out.println("\n Seu carrinho está vazio! Adicione itens antes de avançar.");
                    } else {
                        // Menu intermediário de gerenciamento de carrinho
                        boolean noMenuRevisao = true;
                        while (noMenuRevisao) {
                            double subtotalGeral = 0.0;
                            System.out.println("\n=====================================================");
                            System.out.println("             CARRINHO DE COMPRAS ATUAL               ");
                            System.out.println("=====================================================");
                            
                            // Mostra os itens numerados de 1 até o tamanho final da lista
                            for (int i = 0; i < itensCarrinho.size(); i++) {
                                double valorItem = precosCarrinho.get(i) * qtdsCarrinho.get(i);
                                subtotalGeral += valorItem;
                                System.out.printf("%d. %s x%d: R$ %.2f (Unidade: R$ %.2f)%n", 
                                        (i + 1), itensCarrinho.get(i), qtdsCarrinho.get(i), valorItem, precosCarrinho.get(i));
                            }
                            System.out.println("-----------------------------------------------------");
                            System.out.printf("SUBTOTAL ATUAL: R$ %.2f%n", subtotalGeral);
                            System.out.println("=====================================================");
                            System.out.println("1 - Adicionar mais itens (Voltar ao cardápio)");
                            System.out.println("2 - Remover algum item do carrinho");
                            System.out.println("3 - Ir para o Pagamento (Fechar pedido)");
                            System.out.println("=====================================================");
                            System.out.print("Escolha uma opção: ");
                            int opcaoRevisao = entrada.nextInt();

                            if (opcaoRevisao == 1) {
                                noMenuRevisao = false; // Sai desse menu e volta pro while do cardápio principal
                            } else if (opcaoRevisao == 2) {
                                System.out.print("Digite o número do item que deseja remover: ");
                                int indiceRemover = entrada.nextInt();
                                
                                // Valida se o número do item digitado existe na lista
                                if (indiceRemover >= 1 && indiceRemover <= itensCarrinho.size()) {
                                    int indexReal = indiceRemover - 1; // Ajusta porque listas começam em 0
                                    System.out.printf("✔ %s foi removido do seu carrinho.%n", itensCarrinho.get(indexReal));
                                    itensCarrinho.remove(indexReal);
                                    qtdsCarrinho.remove(indexReal);
                                    precosCarrinho.remove(indexReal);
                                    
                                    if (itensCarrinho.isEmpty()) {
                                        System.out.println("[Aviso] Seu carrinho esvaziou! Voltando ao cardápio principal.");
                                        noMenuRevisao = false;
                                    }
                                } else {
                                    System.out.println("[Erro] Número inválido! Nenhum item removido.");
                                }
                            } else if (opcaoRevisao == 3) {
                                noMenuRevisao = false;
                                continuarComprando = false; // Quebra o loop principal para ir ao pagamento definitivo
                            } else {
                                System.out.println("[Erro] Opção inválida.");
                            }
                        }
                    }
                    break;

                default:
                    System.out.println("\nCategoria inexistente. Tente novamente.");
                    break;
            }

            // Adiciona itens selecionados nas listas correspondentes
            if (opcaoValida) {
                System.out.printf("Você selecionou: %s (R$ %.2f)%n", itemEscolhido, precoUnitario);
                System.out.print("Digite a quantidade desejada: ");
                int quantidade = entrada.nextInt();

                if (quantidade <= 0) {
                    System.out.println("[Erro] Quantidade inválida! Item descartado.");
                } else {
                    itensCarrinho.add(itemEscolhido);
                    qtdsCarrinho.add(quantidade);
                    precosCarrinho.add(precoUnitario);
                    System.out.println("✔ Item adicionado ao carrinho!");
                }
            }
        }

        // --- CALCULO FINAL E EMISSÃO DA NOTA ---
        double valorTotalGeral = 0.0;
        System.out.println("\n=====================================================");
        System.out.println("          RESUMO DO PEDIDO - CREPÚSCULO     ");
        System.out.println("=====================================================");
        for (int i = 0; i < itensCarrinho.size(); i++) {
            double valorItem = precosCarrinho.get(i) * qtdsCarrinho.get(i);
            valorTotalGeral += valorItem;
            System.out.printf("- %s x%d: R$ %.2f%n", itensCarrinho.get(i), qtdsCarrinho.get(i), valorItem);
        }
        System.out.println("-----------------------------------------------------");
        System.out.printf("VALOR TOTAL: R$ %.2f%n", valorTotalGeral);
        System.out.println("=====================================================");

        // --- SISTEMA DE FORMA DE PAGAMENTO ---
        int formaPagamento = 0;
        while (formaPagamento < 1 || formaPagamento > 3) {
            System.out.println("\nEscolha a forma de pagamento:");
            System.out.println("1 - Dinheiro");
            System.out.println("2 - Cartão");
            System.out.println("3 - PIX");
            System.out.print("Opção: ");
            formaPagamento = entrada.nextInt();

            if (formaPagamento < 1 || formaPagamento > 3) {
                System.out.println("[Erro] Opção inválida.");
            }
        }

        // --- VALOR PAGO EM CASO DE DINHEIRO (TROCO) ---
        double valorPago = valorTotalGeral;
        double troco = 0.0;
        String textoPagamento = "";

        switch (formaPagamento) {
            case 1:
                textoPagamento = "Dinheiro";
                valorPago = 0.0;
                while (valorPago < valorTotalGeral) {
                    System.out.print("Digite o valor recebido em dinheiro: R$ ");
                    valorPago = entrada.nextDouble();
                    if (valorPago < valorTotalGeral) {
                        System.out.println("[Erro] O valor entregue é menor do que o total da conta.");
                    }
                }
                troco = valorPago - valorTotalGeral;
                break;
            case 2: textoPagamento = "Cartão"; break;
            case 3: textoPagamento = "PIX"; break;
        }

        int numeroPedido = random.nextInt(500) + 1;

        // --- IMPRESSÃO COMPLETA DO RECIBO ---
        System.out.println("\n=====================================================");
        System.out.println("             PEDIDO CONFIRMADO COM SUCESSO!          ");
        System.out.println("=====================================================");
        System.out.printf("Forma de Pagamento:  %s%n", textoPagamento);
        System.out.printf("VALOR TOTAL:         R$ %.2f%n", valorTotalGeral);
        System.out.printf("VALOR RECEBIDO:      R$ %.2f%n", valorPago);
        if (formaPagamento == 1) {
            System.out.printf("TROCO:               R$ %.2f%n", troco);
        }
        System.out.println("-----------------------------------------------------");
        System.out.printf("SEU NÚMERO DE PEDIDO É: #%03d%n", numeroPedido);
        System.out.println("-----------------------------------------------------");
        System.out.println(" Agradecemos a preferência!");
        System.out.println(" Por favor, aguarde a chamada do seu número no painel.");
        System.out.println("=====================================================");

        entrada.close();
    }
}