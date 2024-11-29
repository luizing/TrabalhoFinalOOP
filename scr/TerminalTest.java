import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TerminalTest {
static String dbPath = "DB.csv";
static String divisorLinha = "=======================";

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
    public static void clienteScreen(Scanner teclado) {
        System.out.println(divisorLinha);
        System.out.println("Tela cliente");
        System.out.println("Qual opção?\n0 = Alugar livro\n1 = Verificar livros alugados\n2 = Devolver livro");
        int opcao = teclado.nextInt();
        teclado.nextLine(); // Limpa buffer do teclado

        switch (opcao) {
            case 0:
                System.out.println(divisorLinha);
                System.out.println("Alugar livro");
                // Exibir lista de Livros e Ids
                // Selecionar Id
                System.out.println("Digite o Id do livro desejado: ");
                int idAlugar = teclado.nextInt();
                Estoque.alugarLivro(idAlugar);  
                break;
            case 1:
                System.out.println("Exibindo livros alugados pelo cliente...");
                // Implementar lógica para exibir livros alugados
                break;
            case 2:
                System.out.println("Exibindo livros para devolução...");
                // Implementar lógica para devolver livro
                break;
            default:
                System.out.println("Opção inválida. Retornando ao menu.");
        }
    }

    // Tela para funcionários
    public static void funcionarioScreen(Scanner teclado) {
        System.out.println("Tela funcionário");
        // Implementar lógica para funcionários
    }

    // Método principal
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean loop = true; // Loop tela de login

        while (loop) {
            System.out.println("Login: ");
            String login = teclado.nextLine();
            System.out.println("Senha: ");
            String senha = teclado.nextLine();

            // Valida o login e executa a tela correspondente
            String tipoUsuario = validarLogin(login, senha);

            if ("c".equals(tipoUsuario)) {
                loop = false;
                clienteScreen(teclado);
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
