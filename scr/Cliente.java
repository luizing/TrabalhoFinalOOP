import java.util.*;

public class Cliente {
    private String nome;
    private int idade;
    private int id;
    private List<Livro> livros;
    private double valorTotal;

    public Cliente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.livros = new ArrayList<>();
        this.valorTotal = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public double getValorTotal() {
        return valorTotal;
    }

}