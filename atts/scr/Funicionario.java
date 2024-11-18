public class Funcionario implements Pessoa {
    private String nome;
    private String cpf;
    private String matricula;
    private double salario;
    private double bonus;

    public Funcionario(String nome, String cpf, String matricula, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.salario = salario;
        this.bonus = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", matricula='" + matricula + '\'' +
                ", salario=" + salario +
                '}';
    }

    public double getBonificacao() { // Para cada livro alugado, recebe +10 de bonificacao
        this.bonus += 10
    }

    public double getSalarioCompleto() {
        return this.salario + this.bonus;
    }

    public void addEstoque(Livro livro){
        this.estoque.adicionarLivro(livro);
    }


    
}