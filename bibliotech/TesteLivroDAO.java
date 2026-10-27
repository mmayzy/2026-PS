import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TesteLivroDAO {

    private static int buscarId(String titulo) throws Exception {
        String sql = "SELECT id FROM livros WHERE titulo = ?";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, titulo);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        LivroDAO dao = new LivroDAO();

        String tituloTeste = "Livro de Teste BiblioTech";
        String tituloAtualizado = "Livro de Teste BiblioTech Atualizado";

        try {
            // Limpa registros de testes anteriores.
            int idAnterior = buscarId(tituloTeste);
            if (idAnterior != -1) {
                dao.excluirLivro(idAnterior);
            }

            int idAtualizadoAnterior = buscarId(tituloAtualizado);
            if (idAtualizadoAnterior != -1) {
                dao.excluirLivro(idAtualizadoAnterior);
            }

            // Teste de inserção.
            boolean adicionado = dao.adicionarLivro(
                tituloTeste,
                "Autor de Teste",
                2026
            );

            System.out.println("Adicionar livro: " + adicionado);

            // Teste de atualização.
            int idLivro = buscarId(tituloTeste);

            boolean atualizado = idLivro != -1
                && dao.atualizarLivro(
                    idLivro,
                    tituloAtualizado,
                    "Autor de Teste",
                    2026
                );

            System.out.println("Atualizar livro: " + atualizado);

            // Teste de exclusão.
            int idAtualizado = buscarId(tituloAtualizado);

            boolean excluido = idAtualizado != -1
                && dao.excluirLivro(idAtualizado);

            System.out.println("Excluir livro: " + excluido);

            // Testes com identificador inexistente.
            boolean atualizouInexistente = dao.atualizarLivro(
                999999,
                "Livro Inexistente",
                "Autor Desconhecido",
                2026
            );

            boolean excluiuInexistente = dao.excluirLivro(999999);

            System.out.println(
                "Atualizacao de inexistente: " + atualizouInexistente
            );

            System.out.println(
                "Exclusao de inexistente: " + excluiuInexistente
            );

            // Teste de listarLivros().
            System.out.println("\nTeste de listarLivros():");

            for (Livro livro : dao.listarLivros()) {
                System.out.println(livro);
            }

            // Teste de buscarLivroPorId().
            int idConsulta = 4;

            if (idConsulta != -1) {
                Livro livroEncontrado = dao.buscarLivroPorId(idConsulta);

                System.out.println("\nTeste de buscarLivroPorId():");
                System.out.println(livroEncontrado);
            } else {
                System.out.println(
                    "\nDom Casmurro não encontrado; teste por ID não executado."
                );
            }

            // Teste de busca por identificador inexistente.
            Livro inexistente = dao.buscarLivroPorId(999999);

            System.out.println(
                "\nBusca por ID inexistente: " + inexistente
            );

        } catch (Exception e) {
            System.out.println("Erro no teste: " + e.getMessage());
            e.printStackTrace();
        }
    }
}