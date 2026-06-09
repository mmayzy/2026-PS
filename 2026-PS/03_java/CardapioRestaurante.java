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
            System.out.println("         CAFÉ DO DRÁCULA - CARDÁPIO DA NOITE");
            System.out.println("=====================================================");
            System.out.println("1 - Cafés Tradicionais");
            System.out.println("2 - Banco de Sangue & Elixires");
            System.out.println("3 - Confeitaria das Trevas");
            System.out.println("4 - CONFERIR CARRINHO / FINALIZAR");
            System.out.println("=====================================================");

            System.out.print("Escolha uma categoria: ");
            int categoria = entrada.nextInt();

            String itemEscolhido = "";
            double precoUnitario = 0.0;
            boolean opcaoValida = false; 

            switch (categoria) {
                case 1: // SUBMENU: CAFÉS
                    System.out.println("\n--- CAFÉS TRADICIONAIS ---");
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

                case 2: // SUBMENU: BEBIDAS (Mais sangues adicionados)
                    System.out.println("\n--- BANCO DE SANGUE & ELIXIRES ---");
                    System.out.println("1 - Sangue Tipo O- (Universal) .... R$ 15,00");
                    System.out.println("2 - Sangue Tipo A+ ................ R$ 12,50");
                    System.out.println("3 - Sangue Tipo B- ................ R$ 14,00");
                    System.out.println("4 - Ácido Sulfúrico Cítrico ....... R$ 9,50");
                    System.out.println("5 - Infusão de Arsênio (Quente) ... R$ 8,50");
                    System.out.print("Escolha seu tipo sanguíneo ou elixir: ");
                    int opcaoBebida = entrada.nextInt();

                    switch (opcaoBebida) {
                        case 1: itemEscolhido = "Sangue Tipo O- (Universal)"; precoUnitario = 15.00; opcaoValida = true; break;
                        case 2: itemEscolhido = "Sangue Tipo A+"; precoUnitario = 12.50; opcaoValida = true; break;
                        case 3: itemEscolhido = "Sangue Tipo B-"; precoUnitario = 14.00; opcaoValida = true; break;
                        case 4: itemEscolhido = "Ácido Sulfúrico Cítrico"; precoUnitario = 9.50; opcaoValida = true; break;
                        case 5: itemEscolhido = "Infusão de Arsênio"; precoUnitario = 8.50; opcaoValida = true; break;
                        default: System.out.println("[Erro] Opção de bebida inválida."); break;
                    }
                    break;

                case 3: // SUBMENU: BOLOS (Cianureto removido)
                    System.out.println("\n--- CONFEITARIA DAS TREVAS ---");
                    System.out.println("1 - Torta de Morcego das Cavernas .. R$ 14,00");
                    System.out.println("2 - Bolo de Múmia do Século XIV .... R$ 16,50");
                    System.out.println("3 - Pavê de Cinzas de Vampiro ...... R$ 11,00");
                    System.out.print("Escolha sua relíquia açucarada: ");
                    int opcaoBolo = entrada.nextInt();

                    switch (opcaoBolo) {
                        case 1: itemEscolhido = "Torta de Morcego"; precoUnitario = 14.00; opcaoValida = true; break;
                        case 2: itemEscolhido = "Bolo de Múmia Séc. XIV"; precoUnitario = 16.50; opcaoValida = true; break;
                        case 3: itemEscolhido = "Pavê de Cinzas de Vampiro"; precoUnitario = 11.00; opcaoValida = true; break;
                        default: System.out.println("[Erro] Opção de doce inválida."); break;
                    }
                    break;

                case 4: // CONFERIR CARRINHO / REVISÃO DO PEDIDO
                    if (itensCarrinho.isEmpty()) {
                        System.out.println("\n Seu carrinho está vazio! Adicione itens antes de avançar.");
                    } else {
                        boolean noMenuRevisao = true;
                        while (noMenuRevisao) {
                            double subtotalGeral = 0.0;
                            System.out.println("\n=====================================================");
                            System.out.println("             CARRINHO DE COMPRAS ATUAL               ");
                            System.out.println("=====================================================");
                            
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
                                noMenuRevisao = false; 
                            } else if (opcaoRevisao == 2) {
                                System.out.print("Digite o número do item que deseja remover: ");
                                int indiceRemover = entrada.nextInt();
                                
                                if (indiceRemover >= 1 && indiceRemover <= itensCarrinho.size()) {
                                    int indexReal = indiceRemover - 1; 
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
                                continuarComprando = false; 
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

            // LÓGICA DE ADICIONAR OU ACUMULAR NO CARRINHO
            if (opcaoValida) {
                System.out.printf("Você selecionou: %s (R$ %.2f)%n", itemEscolhido, precoUnitario);
                System.out.print("Digite a quantidade desejada: ");
                int quantidade = entrada.nextInt();

                if (quantidade <= 0) {
                    System.out.println("[Erro] Quantidade inválida! Item descartado.");
                } else {
                    // Verifica se o item já existe no carrinho para apenas somar a quantidade
                    int indexExistente = itensCarrinho.indexOf(itemEscolhido);
                    
                    if (indexExistente != -1) {
                        // Se já existir, pega a quantidade antiga e soma com a nova
                        int qtdAntiga = qtdsCarrinho.get(indexExistente);
                        qtdsCarrinho.set(indexExistente, qtdAntiga + quantidade);
                        System.out.println("✔ Quantidade atualizada no carrinho!");
                    } else {
                        // Se for um item novo, adiciona normalmente nas listas
                        itensCarrinho.add(itemEscolhido);
                        qtdsCarrinho.add(quantidade);
                        precosCarrinho.add(precoUnitario);
                        System.out.println("✔ Item adicionado ao carrinho!");
                    }
                }
            }
        }

        // --- CALCULO FINAL E EMISSÃO DA NOTA ---
        double valorTotalGeral = 0.0;
        System.out.println("\n=====================================================");
        System.out.println("            RESUMO DO PEDIDO - CAFÉ DO DRÁCULA       ");
        System.out.println("=====================================================");
        for (int i = 0; i < itensCarrinho.size(); i++) {
            double valorItem = precosCarrinho.get(i) * qtdsCarrinho.get(i);
            valorTotalGeral += valorItem;
            System.out.printf("- %s x%d: R$ %.2f%n", itensCarrinho.get(i), qtdsCarrinho.get(i), valorItem);
        }
        System.out.println("-----------------------------------------------------");
        System.out.printf("VALOR TOTAL DO BANQUETE: R$ %.2f%n", valorTotalGeral);
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
        System.out.println("             CONTA FECHADA COM SUCESSO!              ");
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
        System.out.println(" Agradecemos a preferência mortal!");
        System.out.println(" Por favor, aguarde o seu banquete ser preparado.");
        System.out.println("=====================================================");

        entrada.close();
    }
}