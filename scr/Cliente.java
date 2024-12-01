import java.util.*;

public class Cliente {
    private String nome;
    private static List<Livro> livros;
    private static double valorTotal;
        
            public Cliente(String nome) {
                this.nome = nome;
                Cliente.livros = new ArrayList<>();
                Cliente.valorTotal = 0;
            }
        
            public String getNome() {
                return nome;
            }
        
            public void setNome(String nome) {
                this.nome = nome;
            }
        
            public List<Livro> getLivros() {
                return livros;
            }
        
            public void setLivros(List<Livro> livros) {
                Cliente.livros = livros;
            }
        
            public double getValorTotal() {
                return valorTotal;
            }

            public void setValorTotal(double valor){
                Cliente.valorTotal = valor;
            }
        
            public void alugarLivro(Livro livro){
                livros.add(livro);
                valorTotal += 20;
    }

        public void exibirInfos(){
            if (livros.isEmpty()) {
                System.out.println("Você não possui livros alugados.");
            } else {
                System.out.println("Livros atualmente alugados:");
                for (Livro livro : livros) {
                    System.out.println(livro);
                }
            }
            System.out.println("Você tem uma dívida pentende de " + this.getValorTotal() + " reais.");
        }


        public Livro idToLivro(int id){
            for (Livro livro : livros) {
                if (livro.getId() == id) {
                    return livro; // Retorna o livro encontrado
                }
            }
            return null; // Retorna null se o livro não for encontrado
        }

        public boolean devolverLivro(Livro livro) {
            if (livros.contains(livro)) {
                livros.remove(livro);
                if (Estoque.devolverLivro(livro)) {
                    setValorTotal(getValorTotal() - 20);
                    System.out.println("Livro devolvido com sucesso: " + livro);
                    return true;
                } else {
                    // Caso o estoque esteja cheio ou outro problema ocorra
                    livros.add(livro); // Reverte a remoção em caso de falha no estoque
                    System.out.println("Erro ao devolver o livro ao estoque.");
                }
            } else {
                System.out.println("Você não possui este livro: " + livro);
            }
            return false;
        }

        
        

}