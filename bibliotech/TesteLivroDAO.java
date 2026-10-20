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
            // Limpa registros de execucoes anteriores do mesmo teste.
            int idAnterior = buscarId(tituloTeste);
            if (idAnterior != -1) {
                dao.excluirLivro(idAnterior);
            }

            int idAtualizadoAnterior = buscarId(tituloAtualizado);
            if (idAtualizadoAnterior != -1) {
                dao.excluirLivro(idAtualizadoAnterior);
            }

            boolean adicionado = dao.adicionarLivro(
                tituloTeste,
                "Autor de Teste",
                2026
            );
            System.out.println("Adicionar livro: " + adicionado);

            int idLivro = buscarId(tituloTeste);

            boolean atualizado = idLivro != -1
                && dao.atualizarLivro(
                    idLivro,
                    tituloAtualizado,
                    "Autor de Teste",
                    2026
                );
            System.out.println("Atualizar livro: " + atualizado);

            int idAtualizado = buscarId(tituloAtualizado);

            boolean excluido = idAtualizado != -1
                && dao.excluirLivro(idAtualizado);
            System.out.println("Excluir livro: " + excluido);

            System.out.println("\nLivros restantes:");

            try (Connection conexao = Conexao.conectar();
                 PreparedStatement stmt = conexao.prepareStatement(
                     "SELECT * FROM livros");
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    System.out.println(
                        rs.getInt("id") + " - " +
                        rs.getString("titulo") + " - " +
                        rs.getString("autor") + " - " +
                        rs.getInt("ano")
                    );
                }
            }

        } catch (Exception e) {
            System.out.println("Erro no teste: " + e.getMessage());
        }
    }
}