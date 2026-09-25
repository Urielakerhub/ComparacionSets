import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class BenchmarkSets {
    private static final int N = 1_000_000;
    private static final int REPETICIONES = 3;

    public static void main(String[] args) {
        System.out.println("=== BENCHMARK HashSet vs TreeSet ===");
        System.out.println("Elementos: " + N);
        System.out.println("Repeticiones: " + REPETICIONES);
        System.out.println();

        double[] insercionHash = new double[REPETICIONES];
        double[] insercionTree = new double[REPETICIONES];
        double[] busquedaHash = new double[REPETICIONES];
        double[] busquedaTree = new double[REPETICIONES];
        double[] eliminacionHash = new double[REPETICIONES];
        double[] eliminacionTree = new double[REPETICIONES];

        for (int r = 0; r < REPETICIONES; r++) {
            System.gc();

            Set<Integer> hash = new HashSet<>();
            long inicio = System.nanoTime();
            for (int i = 0; i < N; i++) {
                hash.add(i);
            }
            long fin = System.nanoTime();
            insercionHash[r] = (fin - inicio) / 1_000_000.0;

            inicio = System.nanoTime();
            for (int i = 0; i < N; i++) {
                hash.contains(i);
            }
            fin = System.nanoTime();
            busquedaHash[r] = (fin - inicio) / 1_000_000.0;

            inicio = System.nanoTime();
            for (int i = 0; i < N; i++) {
                hash.remove(i);
            }
            fin = System.nanoTime();
            eliminacionHash[r] = (fin - inicio) / 1_000_000.0;

            System.gc();

            Set<Integer> tree = new TreeSet<>();
            inicio = System.nanoTime();
            for (int i = 0; i < N; i++) {
                tree.add(i);
            }
            fin = System.nanoTime();
            insercionTree[r] = (fin - inicio) / 1_000_000.0;

            inicio = System.nanoTime();
            for (int i = 0; i < N; i++) {
                tree.contains(i);
            }
            fin = System.nanoTime();
            busquedaTree[r] = (fin - inicio) / 1_000_000.0;

            inicio = System.nanoTime();
            for (int i = 0; i < N; i++) {
                tree.remove(i);
            }
            fin = System.nanoTime();
            eliminacionTree[r] = (fin - inicio) / 1_000_000.0;

            System.out.printf(
                "Ejecución %d -> HashSet: add %.3f ms | contains %.3f ms | remove %.3f ms%n",
                r + 1, insercionHash[r], busquedaHash[r], eliminacionHash[r]
            );
            System.out.printf(
                "             TreeSet: add %.3f ms | contains %.3f ms | remove %.3f ms%n",
                insercionTree[r], busquedaTree[r], eliminacionTree[r]
            );
        }

        System.out.println("\n=== PROMEDIOS ===");
        System.out.printf("HashSet -> add: %.3f ms | contains: %.3f ms | remove: %.3f ms%n",
                promedio(insercionHash), promedio(busquedaHash), promedio(eliminacionHash));
        System.out.printf("TreeSet -> add: %.3f ms | contains: %.3f ms | remove: %.3f ms%n",
                promedio(insercionTree), promedio(busquedaTree), promedio(eliminacionTree));

        System.out.println("\nNota: System.nanoTime() produce una medición exploratoria.");
        System.out.println("No constituye un benchmark riguroso de la JVM.");
    }

    private static double promedio(double[] valores) {
        double suma = 0;
        for (double valor : valores) {
            suma += valor;
        }
        return suma / valores.length;
    }
}
