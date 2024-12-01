import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Estoque {

    private static Livro[][] estoque; // Matriz de objetos Livro

    // Inicializa o estoque a partir de um arquivo CSV
    public static void carregarEstoque(String caminhoCSV, int linhas, int colunas) {
        estoque = new Livro[linhas][colunas];

        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoCSV))) {
            String linha;
            int id = 0;

            while ((linha = reader.readLine()) != null) {
                String[] valores = linha.split(",");
                if (valores.length == 2) {
                    int livroId = Integer.parseInt(valores[0].trim());
                    String titulo = valores[1].trim();
                    Livro livro = new Livro(livroId, titulo);

                    // Popula a matriz (linhas e colunas automaticamente)
                    int linhaIdx = id / colunas;
                    int colunaIdx = id % colunas;
                    if (linhaIdx < linhas) {
                        estoque[linhaIdx][colunaIdx] = livro;
                    }
                    id++;
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar o estoque: " + e.getMessage());
        }
    }

    // Exibe a matriz do estoque
    public static void exibirEstoque() {
        System.out.println("Matriz do Estoque (Prateleiras):");
        for (int i = 0; i < estoque.length; i++) {
            for (int j = 0; j < estoque[i].length; j++) {
                Livro livro = estoque[i][j];
                if (livro == null) {
                    System.out.print("[ ] "); // Slot vazio
                } else {
                    System.out.print("[" + livro.getTitulo() + "] ");
                }
            }
            System.out.println();
        }
    }

    // Exibe a lista de livros disponíveis
    public static void listarLivrosDisponiveis() {
        System.out.println("Livros disponíveis no estoque:");
        boolean disponivel = false;

        for (int i = 0; i < estoque.length; i++) {
            for (int j = 0; j < estoque[i].length; j++) {
                Livro livro = estoque[i][j];
                if (livro != null) {
                    disponivel = true;
                    System.out.println(livro);
                }
            }
        }

        if (!disponivel) {
            System.out.println("Nenhum livro disponível no estoque.");
        }
    }

    // Alugar um livro (remove o livro da matriz)
    public static boolean alugarLivro(int idLivro) {
        for (int i = 0; i < estoque.length; i++) {
            for (int j = 0; j < estoque[i].length; j++) {
                Livro livro = estoque[i][j];
                if (livro != null && livro.getId() == idLivro) {
                    estoque[i][j] = null; // Remove o livro
                    return true;
                }
            }
        }
        return false; // Livro não encontrado
    }

    // Devolver um livro (adiciona o livro em um slot vazio)
    public static boolean devolverLivro(Livro livro) {
        for (int i = 0; i < estoque.length; i++) {
            for (int j = 0; j < estoque[i].length; j++) {
                if (estoque[i][j] == null) {
                    estoque[i][j] = livro; // Adiciona o livro ao slot vazio
                    return true;
                }
            }
        }
        return false; // Sem espaço disponível
    }

    public static Livro buscarLivroPorId(int idLivro) {
        for (int i = 0; i < estoque.length; i++) {
            for (int j = 0; j < estoque[i].length; j++) {
                Livro livro = estoque[i][j];
                if (livro != null && livro.getId() == idLivro) {
                    return livro; // Retorna o livro encontrado
                }
            }
        }
        return null; // ID não encontrado
    }

    public static boolean adicionarLivro(Livro livro) {
        for (int i = 0; i < estoque.length; i++) {
            for (int j = 0; j < estoque[i].length; j++) {
                if (estoque[i][j] == null) { // Encontra uma posição vazia
                    estoque[i][j] = livro;
                    return true;
                }
            }
        }
        return false; // Estoque cheio
    }

    public static boolean removerLivro(int id) {
        for (int i = 0; i < estoque.length; i++) {
            for (int j = 0; j < estoque[i].length; j++) {
                if (estoque[i][j] != null && estoque[i][j].getId() == id) {
                    estoque[i][j] = null; // Remove o livro
                    return true;
                }
            }
        }
        return false; // Livro não encontrado
    }

    public static void exibirLivrosAlugados(List<Cliente> clientes) {
    System.out.println("Livros alugados:");
    if (clientes.isEmpty()) {
        System.out.println("Nenhum cliente encontrado.");
    }else{
    for (Cliente cliente : clientes) {
        List<Livro> livros = cliente.getLivros();
        if (!livros.isEmpty()) {
            System.out.println("Cliente: " + cliente.getNome());
            for (Livro livro : livros) {
                System.out.println("  " + livro);
            }
            System.out.println("Didiva: " + cliente.getValorTotal() + "$");
        }
    }
}
}

    
    
}
