import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Comprovante {
    public static void gerarComprovanteDevolucao(Cliente cliente, Livro livro) {
    String nomeArquivo = "Comprovante_Devolucao_" + livro.getTitulo().replaceAll(" ", "_") + "_" + cliente.getNome().replaceAll(" ", "_") + ".txt";

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
        writer.write("Comprovante de Devolução");
        writer.newLine();
        writer.write("========================");
        writer.newLine();
        writer.write("Cliente: " + cliente.getNome());
        writer.newLine();
        writer.write("Livro Devolvido: " + livro.getTitulo());
        writer.newLine();
        writer.write("========================");
        writer.newLine();
        writer.write("Data: " + java.time.LocalDate.now());
        writer.newLine();
        writer.write("Obrigado por utilizar nossos serviços!");
        System.out.println("Comprovante de devolução gerado: " + nomeArquivo);
    } catch (IOException e) {
        System.err.println("Erro ao gerar o comprovante de devolução: " + e.getMessage());
    }
}
}