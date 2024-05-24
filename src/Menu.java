import java.util.Scanner;

public class Menu {
    
    public static void MenuPrincipal() { //Es static por que metodo main es estatico y no se va a instanciar ese menu
        Biblioteca biblioteca = new Biblioteca(); //esto es instanciar
        Scanner inputScanner = new Scanner(System.in);

        boolean salir = false;
        while (!salir) { //No olvidar que para que pueda entrar debe estar negado
            System.out.println("*******************************");
            System.out.println("******* MENU PRINCIPAL ********");
            System.out.println("*******************************");
            System.out.println("1. Alta de Usuario");
            System.out.println("2. Baja de Usuario");
            System.out.println("3. Alta de Libro");
            System.out.println("4. Baja de Libro");
            System.out.println("5. Préstamo de Libro");
            System.out.println("6. Libros Disponibles");
            System.out.println("7. Libros Prestados por Usuario");
            System.out.println("8. Salir");

            System.out.print("Elije una opción: "); //sin el ln para me escriba al lado
            int opcion = inputScanner.nextInt();
            inputScanner.nextLine();

            switch (opcion) { //el valor que se va a evaluar
                case 1: //Alta de usuario
                    System.out.print("Ingrese su dni: ");
                    String dni = inputScanner.nextLine();
                    System.out.print("Ingrese su nombre: ");
                    String nombre = inputScanner.nextLine();
                    System.out.print("Ingrese su apellido: ");
                    String apellido = inputScanner.nextLine();
                    biblioteca.AltaUsuario(dni, nombre, apellido);
                    break;
                case 2: //Baja de usuario
                    System.out.print("Ingrese su dni: ");
                    String dniBuscar = inputScanner.nextLine();    
                    Usuario usuarioBuscado = biblioteca.BuscarUsuario(dniBuscar);
                    biblioteca.BajaUsuario(usuarioBuscado);
                    break;
                case 3: //Alta de libro
                    System.out.print("Ingrese el titulo del libro: ");
                    String titulo = inputScanner.nextLine();
                    System.out.print("Ingrese la categoria del libro: ");
                    String categoria = inputScanner.nextLine();
                    biblioteca.AltaLibro(titulo, categoria);
                    break;
                case 4: //Baja de libro
                    System.out.print("Ingrese el título del libro: ");
                    String buscarTitulo = inputScanner.nextLine();    
                    Libro libroBuscado = biblioteca.BuscarLibro(buscarTitulo);
                    biblioteca.BajaLibro(libroBuscado);
                    break;
                case 5: // Prestamo de libro
                    System.out.print("Ingrese su dni: ");
                    String dniBuscar2 = inputScanner.nextLine();    
                    Usuario usuarioBuscado2 = biblioteca.BuscarUsuario(dniBuscar2);
                    System.out.print("Ingrese el título del libro: ");
                    String buscarTitulo2 = inputScanner.nextLine();    
                    Libro libroBuscado2 = biblioteca.BuscarLibro(buscarTitulo2);
                    biblioteca.PrestamoLibro(usuarioBuscado2, libroBuscado2);
                    break; 
                case 6: //Libros Disponibles
                    biblioteca.LibrosDisponibles();
                    break;
                case 7://Libros Prestados por Usuarios
                    System.out.print("Ingrese su dni: ");
                    String dniBuscar3 = inputScanner.nextLine(); 
                    biblioteca.ListaLibrosPrestadosUsuario(dniBuscar3);
                    break; 

                default:
                    salir = true;
                    break;
            }
        }

        inputScanner.close();
    }
    
}
