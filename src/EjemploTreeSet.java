import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSet {
    public static void main(String[] args) {
        Set<String> tecnologias = new TreeSet<>();

        tecnologias.add("Java");
        tecnologias.add("Python");
        tecnologias.add("JavaScript");
        tecnologias.add("Java");
        tecnologias.add("SQL");
        tecnologias.add("Git");
        tecnologias.add("Docker");

        System.out.println("=== TreeSet ===");
        System.out.println("Tecnologías ordenadas: " + tecnologias);
        System.out.println("Cantidad final: " + tecnologias.size());

        System.out.println("\nRecorrido ordenado:");
        for (String tecnologia : tecnologias) {
            System.out.println(tecnologia);
        }

        TreeSet<Integer> calificaciones = new TreeSet<>();
        calificaciones.add(65);
        calificaciones.add(70);
        calificaciones.add(75);
        calificaciones.add(80);
        calificaciones.add(85);
        calificaciones.add(90);
        calificaciones.add(95);

        System.out.println("\n=== Navegación TreeSet ===");
        System.out.println("Calificaciones: " + calificaciones);
        System.out.println("Mínimo: " + calificaciones.first());
        System.out.println("Máximo: " + calificaciones.last());
        System.out.println("lower(80): " + calificaciones.lower(80));
        System.out.println("higher(80): " + calificaciones.higher(80));
        System.out.println("floor(82): " + calificaciones.floor(82));
        System.out.println("ceiling(82): " + calificaciones.ceiling(82));
        System.out.println("subSet(70, true, 90, true): "
                + calificaciones.subSet(70, true, 90, true));

        TreeSet<String> ordenIgnorandoMayusculas =
                new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        ordenIgnorandoMayusculas.add("java");
        ordenIgnorandoMayusculas.add("Python");
        ordenIgnorandoMayusculas.add("DOCKER");

        System.out.println("\nOrden con Comparator CASE_INSENSITIVE_ORDER: "
                + ordenIgnorandoMayusculas);

        TreeSet<String> ordenInverso =
                new TreeSet<>(java.util.Comparator.reverseOrder());
        ordenInverso.add("Java");
        ordenInverso.add("Python");
        ordenInverso.add("SQL");
        ordenInverso.add("Git");

        System.out.println("Orden inverso: " + ordenInverso);
    }
}
