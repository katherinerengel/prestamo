public class Libro {
    private String titulo;
    private String categoria;
    private boolean prestado;
    
    public Libro(){};

    public Libro(String titulo, String categoria, boolean prestado) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.prestado = prestado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean getPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    
}
