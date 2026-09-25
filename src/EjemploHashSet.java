import java.util.HashSet;
import java.util.Set;

public class EjemploHashSet {
    public static void main(String[] args) {
        Set<String> tecnologias = new HashSet<>();

        tecnologias.add("Java");
        tecnologias.add("Python");
        tecnologias.add("JavaScript");
        tecnologias.add("Java");
        tecnologias.add("SQL");
        tecnologias.add("Python");
        tecnologias.add("Git");
        tecnologias.add("Docker");

        System.out.println("=== HashSet ===");
        System.out.println("Tecnologías: " + tecnologias);
        System.out.println("Cantidad final: " + tecnologias.size());
        System.out.println("Los duplicados no se almacenan y HashSet no garantiza orden.");

        boolean agregado = tecnologias.add("Java");
        System.out.println("¿Se agregó Java? " + agregado);

        boolean agregado2 = tecnologias.add("Kotlin");
        System.out.println("¿Se agregó Kotlin? " + agregado2);

        System.out.println("\nOperaciones:");
        System.out.println("Contiene Java: " + tecnologias.contains("Java"));
        System.out.println("Contiene C++: " + tecnologias.contains("C++"));
        System.out.println("Se eliminó Git: " + tecnologias.remove("Git"));
        System.out.println("Tamaño: " + tecnologias.size());
        System.out.println("¿Está vacío? " + tecnologias.isEmpty());

        System.out.println("\nRecorrido:");
        for (String tecnologia : tecnologias) {
            System.out.println(tecnologia);
        }
    }
}
