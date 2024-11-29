public class Livro {
    private int id;
    private String titulo;

    // Construtor
    public Livro(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "ID: " + id + " - Título: " + titulo;
    }
}
