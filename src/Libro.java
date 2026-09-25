public class Libro {

    private String codigo;
    private String titulo;
    private String autor;
    private boolean disponible;
    private String tipoPrestamo;

    public Libro(String codigo, String titulo, String autor, String tipoPrestamo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.tipoPrestamo = tipoPrestamo;
        this.disponible = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public String getTipoPrestamo() {
        return tipoPrestamo;
    }

    public boolean verificarDisponibilidad() {
        return disponible;
    }

    public void marcarPrestado() {
        disponible = false;
    }

    public void marcarDisponible() {
        disponible = true;
    }

    @Override
    public String toString() {
        return "Código: " + codigo
                + " | Título: " + titulo
                + " | Autor: " + autor
                + " | Tipo: " + tipoPrestamo
                + " | Disponible: " + (disponible ? "Sí" : "No");
    }
}