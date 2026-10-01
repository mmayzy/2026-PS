public class TesteBiblioteca {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        Livro livro = new Livro(
            "Dom Casmurro",
            "Machado de Assis",
            1899
        );

        Livro outroLivro = new Livro(
            "Capitaes da Areia",
            "Jorge Amado",
            1937
        );

        Leitor pedro = new Leitor(
            "Pedro Alves",
            "2026010",
            1
        );

        Leitor ana = new Leitor(
            "Ana Lima",
            "2026011",
            2
        );

        System.out.println(
            "Cadastra Pedro: "
            + biblioteca.cadastrarLeitor(pedro)
        );

        System.out.println(
            "Cadastra Ana: "
            + biblioteca.cadastrarLeitor(ana)
        );

        System.out.println(
            "Mesma matricula de novo: "
            + biblioteca.cadastrarLeitor(
                new Leitor("Outra Ana", "2026011", 2)
            )
        );

        biblioteca.cadastrarLivro(livro);
        biblioteca.cadastrarLivro(outroLivro);

        System.out.println("--- Emprestimos ---");

        System.out.println(
            "Pedro pega Dom Casmurro: "
            + biblioteca.emprestar("Dom Casmurro", "2026010")
        );

        System.out.println(
            "Ana tenta pegar Dom Casmurro: "
            + biblioteca.emprestar("Dom Casmurro", "2026011")
        );

        System.out.println(
            "Pedro tenta pegar outro livro: "
            + biblioteca.emprestar(
                "Capitaes da Areia",
                "2026010"
            )
        );

        System.out.println(
            "Livro inexistente: "
            + biblioteca.emprestar(
                "Livro que nao existe",
                "2026011"
            )
        );

        System.out.println(
            "Devolucao: "
            + biblioteca.devolver("Dom Casmurro")
        );

        System.out.println(
            "Segunda devolucao: "
            + biblioteca.devolver("Dom Casmurro")
        );

        System.out.println(
            "Ana pega Dom Casmurro: "
            + biblioteca.emprestar(
                "Dom Casmurro",
                "2026011"
            )
        );

        System.out.println(
            "Ana pega Capitaes da Areia: "
            + biblioteca.emprestar(
                "Capitaes da Areia",
                "2026011"
            )
        );

        System.out.println("--- Emprestimos ---");
        biblioteca.listarEmprestimos();

        System.out.println("--- Livros com a matricula 2026011 ---");
        biblioteca.listarLivrosDoLeitor("2026011");

        System.out.println("--- Acervo ---");
        biblioteca.listarAcervo();
    }
}