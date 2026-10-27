
import java.util.Scanner;

public class TesteBuscarLivro {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        LivroDAO dao = new LivroDAO();

        System.out.println("=== BUSCAR LIVRO ===");

        int id = -1;

        while (id != 0) {
            System.out.print("\nInforme o ID (0 para sair): ");

            if (!entrada.hasNextInt()) {
                System.out.println("Digite um número inteiro válido.");
                entrada.next();
                continue;
            }

            id = entrada.nextInt();

            if (id == 0) {
                System.out.println("Programa encerrado.");
            } else if (id < 0) {
                System.out.println("O ID deve ser positivo.");
            } else {
                Livro livro = dao.buscarLivroPorId(id);

                if (livro != null) {
                    System.out.println("Livro encontrado:");
                    System.out.println(livro);
                } else {
                    System.out.println("Livro não encontrado.");
                }
            }
        }

        entrada.close();
    }
}
