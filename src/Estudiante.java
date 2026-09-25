import java.util.ArrayList;
import java.util.List;

public class Estudiante {

    private String codigoEstudiante;
    private String nombre;
    private String apellido;
    private int maxPrestamos;
    private List<Prestamo> prestamos;

    public Estudiante(String codigoEstudiante, String nombre, String apellido, int maxPrestamos) {
        this.codigoEstudiante = codigoEstudiante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.maxPrestamos = maxPrestamos;
        this.prestamos = new ArrayList<>();
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getMaxPrestamos() {
        return maxPrestamos;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public boolean puedeSolicitar() {
        return contarPrestamosActivos() < maxPrestamos;
    }

    public int contarPrestamosActivos() {
        int contador = 0;

        for (Prestamo prestamo : prestamos) {
            if (prestamo.estaActivo()) {
                contador++;
            }
        }

        return contador;
    }

    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public void mostrarPrestamos() {

        if (prestamos.isEmpty()) {
            System.out.println("El estudiante no tiene préstamos registrados.");
            return;
        }

        System.out.println("\n--- PRÉSTAMOS DE " + nombre + " " + apellido + " ---");

        for (Prestamo prestamo : prestamos) {
            System.out.println(prestamo);
        }
    }

    @Override
    public String toString() {
        return "Código: " + codigoEstudiante
                + " | Nombre: " + nombre + " " + apellido
                + " | Préstamos activos: " + contarPrestamosActivos()
                + "/" + maxPrestamos;
    }
}