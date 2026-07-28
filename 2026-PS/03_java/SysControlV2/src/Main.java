public class Main {

    public static void main(String[] args) {

        // Teste 1 - Criar objetos validos
        Produto p1 = new Produto(11, "Mouse Ma", 120.00, 11);
        Produto p2 = new Produto(2, "Teclado", 180.00, 8);
        Produto p3 = new Produto(3, "Monitor", 950.00, 5);

        System.out.println("=== TESTE 1 ===");
        System.out.println("Produtos criados com sucesso!");

        // Teste 2 - Nome vazio
        System.out.println("\n=== TESTE 2 ===");
        p1.setNome("");

        // Teste 3 - Preço negativo
        System.out.println("\n=== TESTE 3 ===");
        p2.setPreco(-50);

        // Teste 4 - Comportamento permitido
        System.out.println("\n=== TESTE 4 ===");
        p1.adicionarEstoque(5);
        System.out.println("Estoque atualizado: " + p1.getQuantidade());

        // Teste 5 - Comportamento impossível
        System.out.println("\n=== TESTE 5 ===");
        boolean removido = p3.removerEstoque(20);

        if (!removido) {
            System.out.println("Não foi possível remover essa quantidade.");
        }

        // Estado final dos produtos
        System.out.println("\n===== ESTADO FINAL =====");

        System.out.println("\nProduto 1");
        System.out.println("Código: " + p1.getCodigo());
        System.out.println("Nome: " + p1.getNome());
        System.out.println("Preço: R$ " + p1.getPreco());
        System.out.println("Quantidade: " + p1.getQuantidade());
        System.out.println("Valor em estoque: R$ " + p1.calcularValorEmEstoque());

        System.out.println("\nProduto 2");
        System.out.println("Código: " + p2.getCodigo());
        System.out.println("Nome: " + p2.getNome());
        System.out.println("Preço: R$ " + p2.getPreco());
        System.out.println("Quantidade: " + p2.getQuantidade());
        System.out.println("Valor em estoque: R$ " + p2.calcularValorEmEstoque());

        System.out.println("\nProduto 3");
        System.out.println("Código: " + p3.getCodigo());
        System.out.println("Nome: " + p3.getNome());
        System.out.println("Preço: R$ " + p3.getPreco());
        System.out.println("Quantidade: " + p3.getQuantidade());
        System.out.println("Valor em estoque: R$ " + p3.calcularValorEmEstoque());

        // Resumo dos produtos
        System.out.println("\n===== RESUMO DOS PRODUTOS =====");
        System.out.println(p1.resumo());
        System.out.println(p2.resumo());
        System.out.println(p3.resumo());

    }
}