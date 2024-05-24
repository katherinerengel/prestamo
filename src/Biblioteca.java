import java.util.ArrayList;

public class Biblioteca {
    //Array para guardar la información pero no la persiste
    ArrayList<Usuario> usuarios = new ArrayList<>(); //entre <la clase del elemento> y luego el nombre de la variable
    ArrayList<Libro> libros = new ArrayList<>();
    ArrayList<Prestamo> prestamos = new ArrayList<>();

    //Los métodos que no retornan valor son de tipo void

    public void AltaUsuario(String dni, String nombre, String apellido){ //El tipo de dato tiene que ser igual tipo al que se le dio en la clase.
        Usuario nuevoUsuario = new Usuario(dni, nombre, apellido); //Instanciar el constructor de la clase
        usuarios.add(nuevoUsuario); //Agregar el usuario creado en la lista o arreglo de los usuarios
        System.out.println("Usuario registrado con éxito.");
    }

    public void BajaUsuario(Usuario usuarioEliminado){
        usuarios.remove(usuarioEliminado);
        System.out.println("Usuario eliminado con éxito."); //Elimina el usuario creado en la lista o arreglo de los usuarios
    }

    public Usuario BuscarUsuario(String dni){
        Usuario buscado = new Usuario();
        for (Usuario us : usuarios) {
            if (us.getDni().equals(dni) ) {
                buscado = us;
            }
        }

        return buscado;
    }

    public void AltaLibro(String titulo, String categoria){ //no se agrega la opcion prestado porque va por default
        Libro nuevoLibro = new Libro(titulo, categoria, false);
        libros.add(nuevoLibro);
        System.out.println("Libro registrado con éxito.");
    }

    public void BajaLibro(Libro libroEliminado){
        //Como no se puede eliminar algo prestado, debo primero tomar una decisión
        if (!libroEliminado.getPrestado()) { //El símbolo ! niega la respuesta, es decir si es verdadero, me devuelve falso y viceversa
            //EL prestado viene de la clase libro
            libros.remove(libroEliminado);
            System.out.println("Libro eliminado con éxito.");
        } else {
            System.out.println("No se pueden eliminar los libros prestados.");
        }

    }

    public Libro BuscarLibro(String titulo){
        Libro buscado = new Libro();
        for (Libro li : libros) {
            if (li.getTitulo().equals(titulo)) {
                buscado = li;
            }
        }

        return buscado;
    }

    public void PrestamoLibro(Usuario usuarioAprestar, Libro libroAprestar){
        if (!libroAprestar.getPrestado()) { 
            Prestamo nuevPrestamo = new Prestamo(usuarioAprestar, libroAprestar);
            prestamos.add(nuevPrestamo);
            libroAprestar.setPrestado(true); //Para reescribir el valor que por defecto viene falso.
            System.out.println("Libro prestado con éxito.");
        } else {
            System.out.println("No se puede prestar el libro, ya esta prestado.");
        }
    }

    private ArrayList<Libro> ListadoLibrosDisponibles() { //El método () no recibe parametro ya que no lo requiere para filtrar los libros.
        //En el ArrayList va Libro porque es el tipo de arreglo que se va a utilizar
        ArrayList<Libro> librosNoPrestados = new ArrayList<>(); //Para poder capturar los valores que se van a filtrar en e for each
        for (Libro it : libros) { //Libros será lista existente que el va a recorrer, donde se dan de alta los libros.
            if (!it.getPrestado()) {
                librosNoPrestados.add(it);
            }
        }
        return librosNoPrestados;
    }

    private ArrayList<String> ListadoCategoriasLibros() {
        ArrayList<String> listaCategoria = new ArrayList<>();
        for (Libro it : libros) { //Libros será lista existente que el va a recorrer, donde se dan de alta los libros.
            if (!listaCategoria.contains(it.getCategoria())) {
                listaCategoria.add(it.getCategoria());
            }
        }
        return listaCategoria;
    }

    public void LibrosDisponibles() { //decimo primero
        ArrayList<Libro> listadoDisponible = ListadoLibrosDisponibles();
        ArrayList<String> listadoCategoria = ListadoCategoriasLibros();
        for (String lc : listadoCategoria) {
            for (Libro it : listadoDisponible) {
                if(it.getCategoria() == lc){
                    System.out.println("Título: " + it.getTitulo());
                    System.out.println("Categoria: " + it.getCategoria());

                }
            }
            
        }
    }

    public void ListaLibrosPrestadosUsuario(String dni) {
        Usuario bUsuario = BuscarUsuario(dni);
        System.out.println("Usuario:  " + bUsuario.getNombre() + " " + bUsuario.getApellido());
        for (Prestamo pt : prestamos) {
            if(pt.getUsuario().getDni().equals(dni)) {
                System.out.println(" Título: " + pt.getLibro().getTitulo());
                System.out.println(" Categoria: " + pt.getLibro().getCategoria());
            }
        }
    }

}
