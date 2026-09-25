import java.time.LocalDate;

public class Prestamo {

    private int idPrestamo;
    private Libro libro;
    private Estudiante estudiante;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private String estado;

    public Prestamo(int idPrestamo, Libro libro, Estudiante estudiante) {
        this.idPrestamo = idPrestamo;
        this.libro = libro;
        this.estudiante = estudiante;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = null;
        this.estado = "ACTIVO";
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public Libro getLibro() {
        return libro;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public String getEstado() {
        return estado;
    }

    public boolean estaActivo() {
        return estado.equals("ACTIVO");
    }

    public void registrarDevolucion() {

        if (estado.equals("DEVUELTO")) {
            System.out.println("Este préstamo ya fue devuelto.");
            return;
        }

        fechaDevolucion = LocalDate.now();
        estado = "DEVUELTO";

        libro.marcarDisponible();
    }

    @Override
    public String toString() {

        String fechaDev = fechaDevolucion == null
                ? "Pendiente"
                : fechaDevolucion.toString();

        return "ID: " + idPrestamo
                + " | Libro: " + libro.getTitulo()
                + " | Estudiante: " + estudiante.getNombre() + " " + estudiante.getApellido()
                + " | Fecha préstamo: " + fechaPrestamo
                + " | Fecha devolución: " + fechaDev
                + " | Estado: " + estado;
    }
}