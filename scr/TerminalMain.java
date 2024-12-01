import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TerminalMain {
// Constantes
static String dbPath = "DB.csv";
static String caminhoEstoque = "Estoque.csv";
static String divisorLinha = "=======================";
private static List<Cliente> clientes = new ArrayList<>();

    
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

    public static Cliente buscarClientePorNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null; // Cliente não encontrado
    }

    private static boolean adicionarClienteSeNaoExistir(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getNome().equals(cliente.getNome())) {
                return false; 
            }
        }
        clientes.add(cliente);
        return true; 
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
                teclado.nextLine();
                Livro devolvido = usuario.idToLivro(devolverLivro);
                if (devolvido != null) {
                    usuario.devolverLivro(devolvido);

                }else{
                    System.out.println("Livro não encontrado");
                }
                break;
            case 4:
                System.out.println(divisorLinha);
                Estoque.exibirEstoque();
                break;
            case 0:
                System.out.println("Saindo da tela de cliente...");
                loop = false;
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
    }

    // Tela para funcionários
    public static void funcionarioScreen(Scanner teclado) {
        boolean loop = true;
        while (loop) {
            System.out.println(divisorLinha);
            System.out.println("Tela funcionário");
            System.out.println("Qual opção?\n1 = Visualizar estoque\n2 = Adicionar livro ao estoque\n3 = Remover livro do estoque\n4 = Verifica livros alugados\n5 = Exibir clientes\n0 = Voltar para tela de login");
            
            int opcao = teclado.nextInt();
            teclado.nextLine(); // Limpa o buffer
        
            switch (opcao) {
                case 1:
                    System.out.println(divisorLinha);
                    Estoque.exibirEstoque();
                    break;
                case 2: 
                    System.out.println(divisorLinha);
                    System.out.println("Digite o ID do novo livro:");
                    int id = teclado.nextInt();
                    teclado.nextLine(); 
                    System.out.println("Digite o título do novo livro:");
                    String titulo = teclado.nextLine();
                    Livro novoLivro = new Livro(id, titulo);
                    if (Estoque.adicionarLivro(novoLivro)) {
                        System.out.println("Livro adicionado com sucesso!");
                    } else {
                        System.out.println("Erro: Não foi possível adicionar o livro ao estoque.");
                    }
                    break;
                case 3: 
                    System.out.println(divisorLinha);
                    Estoque.listarLivrosDisponiveis();
                    System.out.println("Digite o ID do livro que deseja remover:");
                    int idRemover = teclado.nextInt();
                    teclado.nextLine(); 
                    if (Estoque.removerLivro(idRemover)) {
                        System.out.println("Livro removido com sucesso!");
                    } else {
                        System.out.println("Erro: Livro não encontrado no estoque.");
                    }
                    break;
                case 4: 
                    System.out.println(divisorLinha);
                    Estoque.exibirLivrosAlugados(clientes); 
                    break;
                case 5:
                    System.out.println(divisorLinha);
                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                        return;
                    }
                    System.out.println("Clientes cadastrados:");
                    for (Cliente cliente : clientes) {
                        System.out.println("- " + cliente.getNome());
                    }
                    break;
                case 0: // Sair
                    System.out.println("Saindo da tela de funcionário...");
                    loop = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                }
        }
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
                if (buscarClientePorNome(login) != null){
                    clienteScreen(teclado,buscarClientePorNome(login));
                } else {
                    Cliente usuario = new Cliente(login);
                    adicionarClienteSeNaoExistir(usuario);
                    clienteScreen(teclado,buscarClientePorNome(login));
                }

            } else if ("f".equals(tipoUsuario)) {
                funcionarioScreen(teclado);

            } else {
                System.out.println("Login ou senha inválidos.");
            }
        }

        teclado.close();
    }
}