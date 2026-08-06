public class Main {

    public static void main(String[] args) {

        int[] numeros = {8, 3, 10, 5, 12};

        System.out.println("Soma: " + FuncoesArray.calculaSoma(numeros));
        System.out.println("Média: " + FuncoesArray.calculaMedia(numeros));
        System.out.println("Menor: " + FuncoesArray.menorValor(numeros));
        System.out.println("Maior: " + FuncoesArray.maiorValor(numeros));
        System.out.println("Acima de 6: " + FuncoesArray.contarAcima(numeros, 6));

    }

}