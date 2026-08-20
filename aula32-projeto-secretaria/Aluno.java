/*
 * Disciplina: 2026-PS
 * Estudante : Mayara 
 * Data      : 2026.08.13
 * Projeto   : aula32-projeto-secretaria
 * Arquivo   : Aluno.java
 */

/*
 * A CLASSE E O MOLDE DA FICHA.
 *
 * Ela nao guarda os dados de ninguem: descreve o que TODA ficha de aluno
 * tem (nome, matricula, curso) e o que ela sabe fazer. Cada "new Aluno(...)"
 * poe uma ficha nova a partir deste molde.
 *
 * Regra de Java: o arquivo tem o mesmo nome da classe publica - Aluno.java.
 */

public class Aluno {

    private String nome;
    private String matricula;
    private String curso;
    private String email;

    public Aluno(String nome, String matricula, String curso, String email) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return matricula + " | " + nome + " | " + curso + " | " + email;
    }
}