public class Produto {

    // Atributos
    private int codigo;
    private String nome;
    private double preco;
    private int quantidade;

    // Construtor principal
    public Produto(int codigo, String nome, double preco, int quantidade) {
        this.codigo = codigo;
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
    }

    // Construtor alternativo (Desafio 1)
    public Produto(String nome, double preco) {
        this.codigo = 0;
        setNome(nome);
        setPreco(preco);
        setQuantidade(0);
    }

    // Getters
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // Setters com validação
    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        } else {
            System.out.println("Erro: o nome não pode ser vazio.");
        }
    }

    public void setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
        } else {
            System.out.println("Erro: o preço não pode ser negativo.");
        }
    }

    public void setQuantidade(int quantidade) {
        if (quantidade >= 0) {
            this.quantidade = quantidade;
        } else {
            System.out.println("Erro: a quantidade não pode ser negativa.");
        }
    }

    // Métodos de comportamento
    public void adicionarEstoque(int quantidade) {
        if (quantidade > 0) {
            this.quantidade += quantidade;
        } else {
            System.out.println("Erro: a quantidade deve ser maior que zero.");
        }
    }

    public boolean removerEstoque(int quantidade) {
        if (quantidade > 0 && quantidade <= this.quantidade) {
            this.quantidade -= quantidade;
            return true;
        } else {
            System.out.println("Erro: estoque insuficiente.");
            return false;
        }
    }

    public double calcularValorEmEstoque() {
        return preco * quantidade;
    }

    // Método resumo (Desafio 2)
    public String resumo() {
        return "Código: " + codigo +
               " | Nome: " + nome +
               " | Preço: R$ " + preco +
               " | Quantidade: " + quantidade;
    }

}