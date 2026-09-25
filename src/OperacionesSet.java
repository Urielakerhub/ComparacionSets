import java.util.HashSet;
import java.util.Set;

public class OperacionesSet {
    public static void main(String[] args) {
        Set<String> grupoA = new HashSet<>();
        grupoA.add("Java");
        grupoA.add("Python");
        grupoA.add("SQL");
        grupoA.add("Git");

        Set<String> grupoB = new HashSet<>();
        grupoB.add("Python");
        grupoB.add("JavaScript");
        grupoB.add("SQL");
        grupoB.add("Docker");

        System.out.println("=== Operaciones de conjuntos ===");
        System.out.println("Grupo A: " + grupoA);
        System.out.println("Grupo B: " + grupoB);

        Set<String> union = new HashSet<>(grupoA);
        union.addAll(grupoB);

        Set<String> interseccion = new HashSet<>(grupoA);
        interseccion.retainAll(grupoB);

        Set<String> diferencia = new HashSet<>(grupoA);
        diferencia.removeAll(grupoB);

        System.out.println("Unión: " + union);
        System.out.println("Intersección: " + interseccion);
        System.out.println("Diferencia A - B: " + diferencia);

        System.out.println("\nMétodos utilizados:");
        System.out.println("addAll() -> unión");
        System.out.println("retainAll() -> intersección");
        System.out.println("removeAll() -> diferencia");
    }
}
