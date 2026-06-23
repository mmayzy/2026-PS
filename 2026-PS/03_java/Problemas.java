public class Problemas {

    // Problema 1 - Calculadora de Desconto
    static double calcularDesconto(double valor, double percentual) {
        return valor - (valor * percentual / 100);
    }

    // Problema 2 - Verificador de Maior Valor
    static int maiorNumero(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // Problema 3 - Sistema de Frete
    static double calcularFrete(double peso) {
        if (peso <= 1) {
            return 10.0;
        } else if (peso <= 5) {
            return 20.0;
        } else {
            return 35.0;
        }
    }

    // Problema 4 - Sobrecarga de Soma
    static int somar(int a, int b) {
        return a + b;
    }

    static double somar(double a, double b) {
        return a + b;
    }

    // Problema 5 - Sistema de Cardápio com Sobrecarga
    static void exibirProduto(String nome) {
        System.out.println("Produto: " + nome);
    }

    static void exibirProduto(String nome, double preco) {
        System.out.println("Produto: " + nome);
        System.out.println("Preço: R$ " + preco);
    }

    public static void main(String[] args) {

        // Problema 1
        System.out.println("=== Calculadora de Desconto ===");
        System.out.println(calcularDesconto(100, 10));
        System.out.println(calcularDesconto(250, 20));
        System.out.println(calcularDesconto(500, 15));

        // Problema 2
        System.out.println("\n=== Maior Número ===");
        System.out.println(maiorNumero(10, 20));
        System.out.println(maiorNumero(50, 5));
        System.out.println(maiorNumero(30, 30));

        // Problema 3
        System.out.println("\n=== Sistema de Frete ===");
        System.out.println(calcularFrete(0.5));
        System.out.println(calcularFrete(3));
        System.out.println(calcularFrete(8));

        // Problema 4
        System.out.println("\n=== Sobrecarga de Soma ===");
        System.out.println(somar(5, 3));
        System.out.println(somar(2.5, 3.5));
        System.out.println(somar(100, 50));

        // Problema 5
        System.out.println("\n=== Cardápio ===");
        exibirProduto("Refrigerante");
        exibirProduto("Pizza", 39.90);
        exibirProduto("Hambúrguer", 22.50);
    }
}