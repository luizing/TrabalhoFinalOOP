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

        

}