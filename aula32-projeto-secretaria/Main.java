/*
 * Disciplina: 2026-PS
 * Estudante : Mayara
 * Data      : 2026.08.13
 * Projeto   : aula32-projeto-secretaria
 * Arquivo   : Main.java
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ArrayList<Aluno> lista = new ArrayList<Aluno>();

        while (true) {

            System.out.println("=========================================");
            System.out.println("       SECRETARIA DA MAYARA");
            System.out.println("=========================================");
            System.out.println("[1] Cadastrar aluno");
            System.out.println("[2] Listar alunos");
            System.out.println("[3] Buscar aluno");
            System.out.println("[4] Atualizar aluno");
            System.out.println("[5] Remover aluno");
            System.out.println("[6] Relatório");
            System.out.println("[0] Sair");
            System.out.print("Sua escolha: ");

            String opcao = teclado.nextLine().trim();

            if (opcao.equals("0")) {
                System.out.println("Secretaria fechada. Ate a proxima!");
                break;

            } else if (opcao.equals("1")) {
                cadastrar(lista, teclado);

            } else if (opcao.equals("2")) {
                listar(lista);

            } else if (opcao.equals("3")) {
                buscarAluno(lista, teclado);

            } else if (opcao.equals("4")) {
                atualizar(lista, teclado);

            } else if (opcao.equals("5")) {
                remover(lista, teclado);

            } else if (opcao.equals("6")) {
                relatorio(lista);

            } else {
                System.out.println("Opcao invalida!");
            }
        }

        teclado.close();
    }

    // CADASTRAR
    static void cadastrar(ArrayList<Aluno> lista, Scanner teclado) {

        String nome;

        while (true) {
            System.out.print("Nome: ");
            nome = teclado.nextLine().trim();

            if (!nome.isEmpty()) {
                break;
            }

            System.out.println("O nome nao pode ficar vazio!");
        }

        String matricula;

        while (true) {
            System.out.print("Matricula: ");
            matricula = teclado.nextLine().trim();

            if (matricula.isEmpty()) {
                System.out.println("A matricula nao pode ficar vazia!");

            } else if (buscarPorMatricula(lista, matricula) != null) {
                System.out.println("Essa matricula ja esta cadastrada!");

            } else {
                break;
            }
        }

        String curso;

        while (true) {
            System.out.print("Curso: ");
            curso = teclado.nextLine().trim();

            if (!curso.isEmpty()) {
                break;
            }

            System.out.println("O curso nao pode ficar vazio!");
        }

        String email;

        while (true) {
            System.out.print("Email: ");
            email = teclado.nextLine().trim();

            if (!email.isEmpty()) {
                break;
            }

            System.out.println("O email nao pode ficar vazio!");
        }

        Aluno novo = new Aluno(nome, matricula, curso, email);
        lista.add(novo);

        System.out.println("Ficha de " + novo.getNome() + " arquivada!");
    }

    // LISTAR
    static void listar(ArrayList<Aluno> lista) {

        if (lista.size() == 0) {
            System.out.println("Nenhuma ficha no gaveteiro ainda.");
            return;
        }

        System.out.println("--- FICHAS NO GAVETEIRO ---");

        for (Aluno a : lista) {
            System.out.println(a);
        }
    }

    // BUSCA REUTILIZAVEL
    static Aluno buscarPorMatricula(ArrayList<Aluno> lista, String matricula) {

        for (Aluno a : lista) {

            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }

        return null;
    }

    // BUSCAR PELO MENU
    static void buscarAluno(ArrayList<Aluno> lista, Scanner teclado) {

        System.out.print("Digite a matricula: ");
        String matricula = teclado.nextLine().trim();

        Aluno encontrado = buscarPorMatricula(lista, matricula);

        if (encontrado == null) {
            System.out.println("Aluno nao encontrado!");
        } else {
            System.out.println("Aluno encontrado:");
            System.out.println(encontrado);
        }
    }

    // ATUALIZAR
    static void atualizar(ArrayList<Aluno> lista, Scanner teclado) {

        System.out.print("Matricula do aluno que deseja atualizar: ");
        String matricula = teclado.nextLine().trim();

        Aluno encontrado = buscarPorMatricula(lista, matricula);

        if (encontrado == null) {
            System.out.println("Aluno nao encontrado!");
            return;
        }

        System.out.println("Aluno encontrado: " + encontrado);

        System.out.print("Novo nome: ");
        String novoNome = teclado.nextLine().trim();

        if (!novoNome.isEmpty()) {
            encontrado.setNome(novoNome);
        }

        System.out.print("Novo curso: ");
        String novoCurso = teclado.nextLine().trim();

        if (!novoCurso.isEmpty()) {
            encontrado.setCurso(novoCurso);
        }

        System.out.print("Novo email: ");
        String novoEmail = teclado.nextLine().trim();

        if (!novoEmail.isEmpty()) {
            encontrado.setEmail(novoEmail);
        }

        System.out.println("Ficha atualizada com sucesso!");
    }

    // REMOVER
    static void remover(ArrayList<Aluno> lista, Scanner teclado) {

        System.out.print("Matricula do aluno que deseja remover: ");
        String matricula = teclado.nextLine().trim();

        Aluno encontrado = buscarPorMatricula(lista, matricula);

        if (encontrado == null) {
            System.out.println("Aluno nao encontrado!");
            return;
        }

        System.out.println("Aluno encontrado: " + encontrado);

        System.out.print("Tem certeza que deseja remover? (S/N): ");
        String confirmacao = teclado.nextLine().trim();

        if (confirmacao.equalsIgnoreCase("S")) {
            lista.remove(encontrado);
            System.out.println("Ficha removida com sucesso!");
        } else {
            System.out.println("Remocao cancelada.");
        }
    }

    // RELATORIO
    static void relatorio(ArrayList<Aluno> lista) {

        System.out.println("=========================================");
        System.out.println("           RELATORIO DA SECRETARIA");
        System.out.println("=========================================");

        System.out.println("Total de fichas: " + lista.size());

        if (lista.size() == 0) {
            return;
        }

        ArrayList<String> cursos = new ArrayList<String>();
        ArrayList<Integer> quantidades = new ArrayList<Integer>();

        for (Aluno a : lista) {

            int posicao = cursos.indexOf(a.getCurso());

            if (posicao == -1) {
                cursos.add(a.getCurso());
                quantidades.add(1);
            } else {
                quantidades.set(posicao, quantidades.get(posicao) + 1);
            }
        }

        System.out.println("--- QUANTIDADE POR CURSO ---");

        for (int i = 0; i < cursos.size(); i++) {
            System.out.println(cursos.get(i) + ": " + quantidades.get(i));
        }
    }
}