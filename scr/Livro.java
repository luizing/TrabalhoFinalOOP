public class Livro {
    public static int ultimoId = 0;

    private int id;
    private String titulo;

    // Construtor
    public Livro(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Livro(String titulo) {
        this.id = gerarIdUnico();
        this.titulo = titulo;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    private static int gerarIdUnico() {
        ultimoId++; 
        return ultimoId;
    }

    @Override
    public String toString() {
        return "ID: " + id + " - Título: " + titulo;
    }
}
