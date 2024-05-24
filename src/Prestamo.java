import java.util.Date;

public class Prestamo {
    private Usuario usuario;
    private Libro libro;
    private Date fecha;
    
    public Prestamo(Usuario usuario, Libro libro) { //método
        this.usuario = usuario;
        this.libro = libro;
        this.fecha = new Date(); //Para asignar la fecha y hora actual.
    }

    //Solo los getters, ya que no recibira datos, sino solo mostrará información.
    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public Date getFecha() {
        return fecha;
    }
    
    
}
