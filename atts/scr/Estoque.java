import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Estoque {
    private List<Livro> livros;
    static String path = "Estoque.csv";

    

    public Estoque() {
        livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void removerLivro(Livro livro) {
        livros.remove(livro);
    }

    public Livro encontrarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public static void exibirLivros(){
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                // Divida a linha pelo separador vírgula
                String[] campos = linha.split(",");
                
                // Imprime os campos
                for (String campo : campos) {
                    System.out.print(campo + " ");
                }
                System.out.println();  // Nova linha após cada linha do CSV
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}