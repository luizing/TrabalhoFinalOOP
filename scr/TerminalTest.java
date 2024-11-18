import java.util.*;

public class TerminalTest {

    




    // Tela Cliente
    public static void clienteScreen(){
        Scanner teclado = new Scanner(System.in);
        // Login
        
        System.out.println("Tela cliente");

        // Selecionar opcao
        System.out.println("Qual opcao?\n0 = Alugar livro");
        int opcao = teclado.nextInt();
    
        while (opcao != 0 && opcao != 1){
            System.out.println("Digite uma opcao valida\n0 = Alugar livro\n");
            opcao = teclado.nextInt();
        }

        // Alugar Livro
        if (opcao == 0){
            Estoque.exibirLivros();
            System.out.println("Qual o id do livro desejado?");
            int livroAlugado = teclado.nextInt();
            // Checar se livroAlugado está disponivel no estoque(erro cc)
            // Diminuir livroAlugado do estoque
            // Adicionar livroAlugado aos adquiridos pelo cliente
        }

        // Verificar Livros Alugados
        if (opcao == 1){
            // Exibir livros em posse do cliente
        }

        // Devolver livro
        if (opcao == 2) {
            // Exibir livros em posse do cliente
            System.out.println("Qual o id do livro a ser devolvido?\n");
            int livroDevolver = teclado.nextInt();
            // Remover livro de Posse do cliente
            // Adicionar livro ao estoque
            // "Tela de pagamento"
        }




        teclado.close();
    }









    public static void funcionarioScreen(){
        System.out.println("Tela funcionario");
    }



    public static void main(String[] args) {
        // inicializacoes
        Scanner teclado = new Scanner(System.in);
        
        // Entrar como Cliente ou Funcionário
        System.out.println("Como deseja fazer login?\n0 = Cliente 1 = Funcionario");
        int loginType = teclado.nextInt();
    
        while (loginType != 0 && loginType != 1){
            System.out.println("Digite uma opcao valida\n0 = Cliente 1 = Funcionario\n");
            loginType = teclado.nextInt();
        }
    
        if (loginType == 0) {
            clienteScreen();
        }
        else if (loginType == 1) {
            funcionarioScreen();
        }

        teclado.close();


    }
}
