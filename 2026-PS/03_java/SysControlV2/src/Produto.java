public class Produto {

    // Atributos
    private int codigo;
    private String nome;
    private double preco;
    private int quantidade;

    // Construtor
    public Produto(int codigo, String nome, double preco, int quantidade) {
        this.codigo = codigo;
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
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

    // Adiciona produtos ao estoque
    public void adicionarEstoque(int quantidade) {
        if (quantidade > 0) {
            this.quantidade += quantidade;
        } else {
            System.out.println("Erro: a quantidade deve ser maior que zero.");
        }
    }

    // Remove produtos do estoque
    public boolean removerEstoque(int quantidade) {
        if (quantidade > 0 && quantidade <= this.quantidade) {
            this.quantidade -= quantidade;
            return true;
        } else {
            System.out.println("Erro: estoque insuficiente.");
            return false;
        }
    }

    // Calcula o valor total em estoque
    public double calcularValorEmEstoque() {
        return preco * quantidade;
    }

}