import java.util.ArrayList;

public class Aula29 {

    // exercício 1
    static double calcularMedia(double[] notas) {
        double soma = 0;

        for (double nota : notas) {
            soma += nota;
        }

        return soma / notas.length;
    }

    // exercício 2
    static int contarAprovados(double[] notas) {
        int aprovados = 0;

        for (double nota : notas) {
            if (nota >= 6.0) {
                aprovados++;
            }
        }

        return aprovados;
    }

    // exercício 3
    static void adicionarProduto(ArrayList<String> lista, String nome) {
        lista.add(nome);
    }

    static void listarProdutos(ArrayList<String> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + " - " + lista.get(i));
        }
    }

    // exercício 4
    static int maiorValor(int[] valores) {
        int maior = valores[0];

        for (int valor : valores) {
            if (valor > maior) {
                maior = valor;
            }
        }

        return maior;
    }

    static int maiorValor(int a, int b) {
        if (a > b) {
            return a;
        }

        return b;
    }

    // exerciicio 5
    static void exibirBoletim(double[] notas) {
        double media = calcularMedia(notas);
        int aprovados = contarAprovados(notas);

        System.out.println("Média: " + media);
        System.out.println("Aprovados: " + aprovados);

        if (media >= 6.0) {
            System.out.println("Situação: APROVADA");
        } else {
            System.out.println("Situação: EM RECUPERAÇÃO");
        }
    }

    // desafio
    static int contarAcimaDaMedia(double[] notas) {
        double media = calcularMedia(notas);
        int contador = 0;

        for (double nota : notas) {
            if (nota > media) {
                contador++;
            }
        }

        return contador;
    }

    public static void main(String[] args) {

        // exercício 1
        double[] notas1 = {7.0, 8.0, 9.0};
        System.out.println(calcularMedia(notas1));

        // exercício 2
        double[] notas2 = {7.0, 4.0, 9.0, 6.0};
        System.out.println(contarAprovados(notas2));

        // exercicio 3
        ArrayList<String> lista = new ArrayList<>();

        adicionarProduto(lista, "Pizza");
        adicionarProduto(lista, "Suco");

        listarProdutos(lista);

        // exercício 4
        System.out.println(maiorValor(new int[]{3, 9, 5}));
        System.out.println(maiorValor(12, 7));

        // exercício 5
        double[] notas3 = {7.0, 5.0, 9.0, 6.0};
        exibirBoletim(notas3);

        //desafio
        System.out.println("Acima da média: " + contarAcimaDaMedia(notas3));
    }
}