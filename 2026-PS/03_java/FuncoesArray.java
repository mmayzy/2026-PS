public class FuncoesArray {

    // ============================
    // INÍCIO DA FUNÇÃO calculaSoma
    // ============================

    static int calculaSoma(int[] numeros) {

        int soma = 0;

        for (int n : numeros) {
            soma += n;
        }

        return soma;
    }

    // =========================
    // FIM DA FUNÇÃO calculaSoma
    // =========================



    // ==============================
    // INÍCIO DA FUNÇÃO calculaMedia
    // ==============================

    static int calculaMedia(int[] numeros) {

        int soma = 0;

        for (int n : numeros) {
            soma += n;
        }

        return soma / numeros.length;
    }

    // ===========================
    // FIM DA FUNÇÃO calculaMedia
    // ===========================



    // =============================
    // INÍCIO DA FUNÇÃO menorValor
    // =============================

    static int menorValor(int[] numeros) {

        int menor = numeros[0];

        for (int n : numeros) {

            if (n < menor) {
                menor = n;
            }

        }

        return menor;
    }

    // ==========================
    // FIM DA FUNÇÃO menorValor
    // ==========================



    // =============================
    // INÍCIO DA FUNÇÃO maiorValor
    // =============================

    static int maiorValor(int[] numeros) {

        int maior = numeros[0];

        for (int n : numeros) {

            if (n > maior) {
                maior = n;
            }

        }

        return maior;
    }

    // ==========================
    // FIM DA FUNÇÃO maiorValor
    // ==========================



    // ==============================
    // INÍCIO DA FUNÇÃO contarAcima
    // ==============================

    static int contarAcima(int[] numeros, int limite) {

        int contador = 0;

        for (int n : numeros) {

            if (n > limite) {
                contador++;
            }

        }

        return contador;
    }

    // ===========================
    // FIM DA FUNÇÃO contarAcima
    // ===========================

}