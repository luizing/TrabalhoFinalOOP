import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TerminalTest {
static String dbPath = "DB.csv";
static String divisorLinha = "=======================";
static String caminhoEstoque = "Estoque.csv";

//Valor estático de 20$ para o aluguel de qualquer livro

    // Valida o login e retorna o tipo de usuário
    public static String validarLogin(String login, String senha) {
        try (BufferedReader reader = new BufferedReader(new FileReader(dbPath))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] valores = linha.split(",");
                if (valores.length == 3) {
                    String csvLogin = valores[0].trim();
                    String csvSenha = valores[1].trim();
                    String csvTipoUsuario = valores[2].trim();
                    if (csvLogin.equals(login) && csvSenha.equals(senha)) {
                        return csvTipoUsuario;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }
        return null; // Credenciais inválidas
    }

    // Tela para clientes
    public static void clienteScreen(Scanner teclado,Cliente usuario) {
        boolean loop = true;
    
        while (loop) {

        System.out.println(divisorLinha);
        System.out.println("Tela cliente");
        System.out.println("Qual opção?\n1 = Alugar livro\n2 = Verificar informacoes\n3 = Devolver livro\n4 = Mostrar onde estão os livros na prateleira\n0 = Voltar para tela de login");
        int opcao = teclado.nextInt();
        teclado.nextLine(); // Limpa buffer do teclado

        switch (opcao) {
            case 1:
                System.out.println(divisorLinha);
                Estoque.listarLivrosDisponiveis();
                
                System.out.println("Digite o Id do livro desejado: ");
                int idAlugar = teclado.nextInt();
                
                Livro alugado = Estoque.buscarLivroPorId(idAlugar);
                if (Estoque.alugarLivro(idAlugar)){
                    usuario.alugarLivro(alugado);
                }else{
                    System.out.println("Id de livro não encontrado!");
                }
                
                break;

            case 2:
                System.out.println(divisorLinha);
                usuario.exibirInfos();
                break;
            case 3:
                System.out.println(divisorLinha);
                usuario.exibirInfos();
                System.out.println("Digite o id do livro que deseja devolver: ");
                int devolverLivro = teclado.nextInt();

                break;
            case 4:
                System.out.println(divisorLinha);
                Estoque.exibirEstoque();
                break;
            case 0:
                loop = false;
                break;
            default:
                System.out.println("Opção inválida. Retornando ao menu.");
        }
    }
    }

    // Tela para funcionários
    public static void funcionarioScreen(Scanner teclado) {
        System.out.println("Tela funcionário");
        // Implementar lógica para funcionários
    }

    // Método principal
    public static void main(String[] args) {

        Estoque.carregarEstoque(caminhoEstoque,10, 10);

        Scanner teclado = new Scanner(System.in);
        boolean loop = true; // Loop tela de login

        while (loop) {
            System.out.println(divisorLinha);
            System.out.println("Login: ");
            String login = teclado.nextLine();
            System.out.println("Senha: ");
            String senha = teclado.nextLine();

            // Valida o login e executa a tela correspondente
            String tipoUsuario = validarLogin(login, senha);

            if ("c".equals(tipoUsuario)) {
                Cliente usuario = new Cliente(login);
                clienteScreen(teclado,usuario);
            } else if ("f".equals(tipoUsuario)) {
                loop = false;
                funcionarioScreen(teclado);
            } else {
                System.out.println("Login ou senha inválidos.");
            }
        }

        teclado.close();
    }
}
