public class Estoque {

    // Matriz representando o estoque de livros
    // O estoque está representao estático no código, mas pode ser implementado em um csv ou outra estrutura de dados.
    private static int[][] estoque = {
        {0, 1, 2}, 
        {3, 0, 4}, 
        {0, 5, 0}
    };

    // Exibir a matriz de estoque
    public static void exibirEstoque() {
        System.out.println("Matriz do Estoque (Prateleiras):");
        for (int prateleira = 0; prateleira < estoque.length; prateleira++) {
            for (int posicao = 0; posicao < estoque[prateleira].length; posicao++) {
                if (estoque[prateleira][posicao] == 0) {
                    System.out.print("[ ] "); // Slot vazio
                } else {
                    System.out.print("[" + estoque[prateleira][posicao] + "] "); // ID do livro
                }
            }
            System.out.println();
        }
    }

    // Verificar se um livro está disponível
    public static boolean verificarDisponibilidade(int idLivro) {
        for (int prateleira = 0; prateleira < estoque.length; prateleira++) {
            for (int posicao = 0; posicao < estoque[prateleira].length; posicao++) {
                if (estoque[prateleira][posicao] == idLivro) {
                    return true;
                }
            }
        }
        return false;
    }

    // Alugar um livro (remove o livro da matriz)
    public static boolean alugarLivro(int idLivro) {
        for (int i = 0; i < estoque.length; i++) {
            for (int j = 0; j < estoque[i].length; j++) {
                if (estoque[i][j] == idLivro) {
                    estoque[i][j] = 0; // Remove o livro
                    return true;
                }
            }
        }
        return false; // Livro não encontrado
    }

    // Devolver um livro (adiciona o livro em um slot vazio)
    public static boolean devolverLivro(int idLivro) {
        for (int i = 0; i < estoque.length; i++) {
            for (int j = 0; j < estoque[i].length; j++) {
                if (estoque[i][j] == 0) {
                    estoque[i][j] = idLivro; // Adiciona o livro ao slot vazio
                    return true;
                }
            }
        }
        return false; // Sem espaço disponível
    }
}
