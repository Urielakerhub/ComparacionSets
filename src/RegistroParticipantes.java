import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class RegistroParticipantes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Para usar HashSet:
        Set<String> estudiantes = new HashSet<>();

        // Para la segunda implementación, cambia solamente la línea anterior por:
        // Set<String> estudiantes = new TreeSet<>();

        String[] registrosIniciales = {
            "A0032", "A0015", "A0081", "A0032", "A0021",
            "A0015", "A0105", "A0007", "A0081", "A0044"
        };

        for (String id : registrosIniciales) {
            estudiantes.add(id);
        }

        int opcion;

        do {
            System.out.println("\n=== REGISTRO DE PARTICIPANTES ===");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Buscar estudiante");
            System.out.println("3. Eliminar estudiante");
            System.out.println("4. Mostrar estudiantes");
            System.out.println("5. Mostrar número de estudiantes");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Ingrese un número válido: ");
                scanner.next();
            }

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID del estudiante: ");
                    String nuevo = scanner.nextLine().trim().toUpperCase();

                    if (estudiantes.add(nuevo)) {
                        System.out.println("Estudiante registrado correctamente.");
                    } else {
                        System.out.println("El estudiante ya existía.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese ID a buscar: ");
                    String buscar = scanner.nextLine().trim().toUpperCase();

                    if (estudiantes.contains(buscar)) {
                        System.out.println("El estudiante está registrado.");
                    } else {
                        System.out.println("El estudiante no está registrado.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese ID a eliminar: ");
                    String eliminar = scanner.nextLine().trim().toUpperCase();

                    if (estudiantes.remove(eliminar)) {
                        System.out.println("Estudiante eliminado.");
                    } else {
                        System.out.println("El estudiante no existía.");
                    }
                    break;

                case 4:
                    System.out.println("Estudiantes:");
                    for (String estudiante : estudiantes) {
                        System.out.println(estudiante);
                    }
                    break;

                case 5:
                    System.out.println("Número de estudiantes: " + estudiantes.size());
                    break;

                case 6:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}
