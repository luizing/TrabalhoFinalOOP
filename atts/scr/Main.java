public class Main {

    public static void main(String[] args) {
        // 
        Cliente cliente = new Cliente();
        Estoque estoque = new Estoque();
        Funcionario funcionario = new Funcionario();
        Livro livro = new Livro();

        // 
        cliente.comprarLivro(livro);
        estoque.adicionarLivro(livro);
        funcionario.registrarVenda(cliente, livro);
        // 
    }
}