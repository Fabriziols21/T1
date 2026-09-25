import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {

        cargarDatosIniciales();

        int opcion;

        do {

            mostrarMenu();

            System.out.print("Seleccione una opción: ");

            try {

                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {

                    case 1:
                        registrarLibro();
                        break;

                    case 2:
                        registrarEstudiante();
                        break;

                    case 3:
                        biblioteca.mostrarLibros();
                        break;

                    case 4:
                        biblioteca.mostrarLibrosDisponibles();
                        break;

                    case 5:
                        realizarPrestamo();
                        break;

                    case 6:
                        registrarDevolucion();
                        break;

                    case 7:
                        biblioteca.mostrarPrestamos();
                        break;

                    case 8:
                        biblioteca.mostrarPrestamosActivos();
                        break;

                    case 9:
                        biblioteca.mostrarEstudiantes();
                        break;

                    case 0:
                        System.out.println("\nSaliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción no válida.");

                }

            } catch (NumberFormatException e) {

                System.out.println("Debe ingresar un número válido.");
                opcion = -1;
            }

            if (opcion != 0) {

                System.out.println("\nPresione ENTER para continuar...");
                scanner.nextLine();
            }

        } while (opcion != 0);

        scanner.close();
    }


    private static void mostrarMenu() {

        System.out.println("\n==========================================");
        System.out.println("       SISTEMA DE BIBLIOTECA");
        System.out.println("==========================================");
        System.out.println("1. Registrar libro");
        System.out.println("2. Registrar estudiante");
        System.out.println("3. Mostrar todos los libros");
        System.out.println("4. Mostrar libros disponibles");
        System.out.println("5. Realizar préstamo");
        System.out.println("6. Registrar devolución");
        System.out.println("7. Mostrar todos los préstamos");
        System.out.println("8. Mostrar préstamos activos");
        System.out.println("9. Mostrar estudiantes");
        System.out.println("0. Salir");
        System.out.println("==========================================");
    }


    private static void registrarLibro() {

        System.out.println("\n===== REGISTRAR LIBRO =====");

        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.println("\nTipos de préstamo:");
        System.out.println("1. NORMAL");
        System.out.println("2. CONSULTA");

        System.out.print("Seleccione el tipo: ");
        int tipo = Integer.parseInt(scanner.nextLine());

        String tipoPrestamo;

        if (tipo == 2) {
            tipoPrestamo = "CONSULTA";
        } else {
            tipoPrestamo = "NORMAL";
        }

        Libro libro = new Libro(
                codigo,
                titulo,
                autor,
                tipoPrestamo
        );

        biblioteca.registrarLibro(libro);
    }
    private static void registrarEstudiante() {

        System.out.println("\n===== REGISTRAR ESTUDIANTE =====");

        System.out.print("Código del estudiante: ");
        String codigo = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Máximo de préstamos permitidos: ");
        int maxPrestamos = Integer.parseInt(scanner.nextLine());

        Estudiante estudiante = new Estudiante(
                codigo,
                nombre,
                apellido,
                maxPrestamos
        );

        biblioteca.registrarEstudiante(estudiante);
    }

    private static void realizarPrestamo() {

        System.out.println("\n===== REALIZAR PRÉSTAMO =====");

        System.out.print("Código del libro: ");
        String codigoLibro = scanner.nextLine();

        System.out.print("Código del estudiante: ");
        String codigoEstudiante = scanner.nextLine();

        biblioteca.realizarPrestamo(
                codigoLibro,
                codigoEstudiante
        );
    }
    private static void registrarDevolucion() {

        System.out.println("\n===== REGISTRAR DEVOLUCIÓN =====");

        System.out.print("ID del préstamo: ");

        int idPrestamo = Integer.parseInt(scanner.nextLine());

        biblioteca.registrarDevolucion(idPrestamo);
    }

    private static void cargarDatosIniciales() {

        Libro libro1 = new Libro(
                "L001",
                "Programación en Java",
                "James Gosling",
                "NORMAL"
        );

        Libro libro2 = new Libro(
                "L002",
                "Fundamentos de Comunicación",
                "Jesús Martín-Barbero",
                "NORMAL"
        );

        Libro libro3 = new Libro(
                "L003",
                "Diccionario Universitario",
                "Editorial Universitaria",
                "CONSULTA"
        );

        biblioteca.registrarLibro(libro1);
        biblioteca.registrarLibro(libro2);
        biblioteca.registrarLibro(libro3);

        Estudiante estudiante1 = new Estudiante(
                "E001",
                "Fabrizio",
                "Lingan",
                3
        );

        Estudiante estudiante2 = new Estudiante(
                "E002",
                "Carlos",
                "García",
                3
        );

        biblioteca.registrarEstudiante(estudiante1);
        biblioteca.registrarEstudiante(estudiante2);

        System.out.println("\nDatos iniciales cargados correctamente.");
    }
}