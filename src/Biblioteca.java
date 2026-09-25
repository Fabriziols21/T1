import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Libro> libros;
    private List<Estudiante> estudiantes;
    private List<Prestamo> prestamos;

    private int siguienteIdPrestamo;

    public Biblioteca() {
        libros = new ArrayList<>();
        estudiantes = new ArrayList<>();
        prestamos = new ArrayList<>();
        siguienteIdPrestamo = 1;
    }

    public void registrarLibro(Libro libro) {

        if (buscarLibro(libro.getCodigo()) != null) {
            System.out.println("Ya existe un libro con ese código.");
            return;
        }

        libros.add(libro);

        System.out.println("Libro registrado correctamente.");
    }

    public Libro buscarLibro(String codigo) {

        for (Libro libro : libros) {

            if (libro.getCodigo().equalsIgnoreCase(codigo)) {
                return libro;
            }
        }

        return null;
    }

    public void mostrarLibros() {

        if (libros.isEmpty()) {
            System.out.println("No existen libros registrados.");
            return;
        }

        System.out.println("\n========== LIBROS ==========");

        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    public void mostrarLibrosDisponibles() {

        boolean encontrado = false;

        System.out.println("\n===== LIBROS DISPONIBLES =====");

        for (Libro libro : libros) {

            if (libro.isDisponible()) {
                System.out.println(libro);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay libros disponibles.");
        }
    }

    public void registrarEstudiante(Estudiante estudiante) {

        if (buscarEstudiante(estudiante.getCodigoEstudiante()) != null) {
            System.out.println("Ya existe un estudiante con ese código.");
            return;
        }

        estudiantes.add(estudiante);

        System.out.println("Estudiante registrado correctamente.");
    }

    public Estudiante buscarEstudiante(String codigo) {

        for (Estudiante estudiante : estudiantes) {

            if (estudiante.getCodigoEstudiante().equalsIgnoreCase(codigo)) {
                return estudiante;
            }
        }

        return null;
    }

    public void mostrarEstudiantes() {

        if (estudiantes.isEmpty()) {
            System.out.println("No existen estudiantes registrados.");
            return;
        }

        System.out.println("\n======= ESTUDIANTES =======");

        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }
    }

    public void realizarPrestamo(String codigoLibro, String codigoEstudiante) {

        Libro libro = buscarLibro(codigoLibro);
        Estudiante estudiante = buscarEstudiante(codigoEstudiante);

        if (libro == null) {
            System.out.println("El libro no existe.");
            return;
        }

       
        if (estudiante == null) {
            System.out.println("El estudiante no existe.");
            return;
        }

        if (!libro.verificarDisponibilidad()) {
            System.out.println("El libro no está disponible.");
            return;
        }

        if (!estudiante.puedeSolicitar()) {
            System.out.println(
                    "El estudiante alcanzó el máximo de "
                    + estudiante.getMaxPrestamos()
                    + " préstamos permitidos."
            );
            return;
        }

        if (libro.getTipoPrestamo().equalsIgnoreCase("CONSULTA")) {

            System.out.println(
                    "Este libro es de CONSULTA y no puede salir de la biblioteca."
            );

            return;
        }

        Prestamo prestamo = new Prestamo(
                siguienteIdPrestamo,
                libro,
                estudiante
        );

        siguienteIdPrestamo++;

      
        libro.marcarPrestado();

        
        prestamos.add(prestamo);
        estudiante.agregarPrestamo(prestamo);

        System.out.println("\nPréstamo realizado correctamente.");
        System.out.println("ID del préstamo: " + prestamo.getIdPrestamo());
        System.out.println("Libro: " + libro.getTitulo());
        System.out.println("Estudiante: "
                + estudiante.getNombre() + " "
                + estudiante.getApellido());
        System.out.println("Fecha: " + prestamo.getFechaPrestamo());
    }
    public void registrarDevolucion(int idPrestamo) {

        Prestamo prestamo = buscarPrestamo(idPrestamo);

        if (prestamo == null) {
            System.out.println("No existe un préstamo con ese ID.");
            return;
        }

        if (!prestamo.estaActivo()) {
            System.out.println("Este préstamo ya fue devuelto.");
            return;
        }

        prestamo.registrarDevolucion();

        System.out.println("\nDevolución registrada correctamente.");
        System.out.println("Libro: " + prestamo.getLibro().getTitulo());
        System.out.println("Fecha de devolución: "
                + prestamo.getFechaDevolucion());
    }

    public Prestamo buscarPrestamo(int idPrestamo) {

        for (Prestamo prestamo : prestamos) {

            if (prestamo.getIdPrestamo() == idPrestamo) {
                return prestamo;
            }
        }

        return null;
    }

    public void mostrarPrestamos() {

        if (prestamos.isEmpty()) {
            System.out.println("No existen préstamos registrados.");
            return;
        }

        System.out.println("\n========== PRÉSTAMOS ==========");

        for (Prestamo prestamo : prestamos) {
            System.out.println(prestamo);
        }
    }

    public void mostrarPrestamosActivos() {

        boolean encontrado = false;

        System.out.println("\n===== PRÉSTAMOS ACTIVOS =====");

        for (Prestamo prestamo : prestamos) {

            if (prestamo.estaActivo()) {
                System.out.println(prestamo);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No existen préstamos activos.");
        }
    }
}