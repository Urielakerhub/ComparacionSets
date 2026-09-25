# Práctica: HashSet vs. TreeSet en Java Collections Framework

## 1. Propósito

`HashSet` y `TreeSet` implementan la interfaz `Set<E>` del Java
Collections Framework. Ambas almacenan elementos sin duplicados, pero
utilizan estructuras internas diferentes y ofrecen distintas
características de ordenamiento y desempeño.

El propósito es que experimenten con ambas
implementaciones y determinen qué criterios permiten decidir cuál
utilizar.

Al finalizar,  podrás utilizar `Set`, distinguir `HashSet` y
`TreeSet`, comprobar su comportamiento ante duplicados, comparar el
orden de iteración, realizar operaciones de conjuntos, analizar
complejidad y justificar la selección de una implementación.

## 2. Situación problema

Una universidad registra tecnologías que dominan sus estudiantes:

``` text
Java
Python
JavaScript
Java
SQL
Python
Git
Java
Docker
SQL
```

Se requiere almacenar las tecnologías sin duplicados y, en algunas
situaciones, mostrarlas ordenadas alfabéticamente.

## 3. Preparación en IntelliJ IDEA

Crear:

``` text
ComparacionSets/
└── src/
    ├── EjemploHashSet.java
    ├── EjemploTreeSet.java
    ├── ComparacionSets.java
    ├── OperacionesSet.java
    └── BenchmarkSets.java
```

## 4. Introducción a Set

Un `Set` representa una colección sin elementos duplicados.

``` text
Java
Python
Java
SQL
Python
       │
       ▼
      Set
       │
       ▼
Java
Python
SQL
```

**Pregunta:** ¿En qué situaciones sería importante garantizar que un
elemento aparezca una sola vez?

## 5. Trabajar con HashSet

``` java
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

        System.out.println(tecnologias);
    }
}
```

Analice cuántos elementos se intentaron agregar, cuántos permanecen y
qué ocurre con los duplicados. Observe también que `HashSet` no
garantiza el orden de iteración.

## 6. Resultado de add()

``` java
boolean agregado = tecnologias.add("Java");
System.out.println("¿Se agregó Java? " + agregado);

boolean agregado2 = tecnologias.add("Kotlin");
System.out.println("¿Se agregó Kotlin? " + agregado2);
```

Si el elemento no pertenece al conjunto, `add()` devuelve `true`; si ya
existe, devuelve `false`.

**Pregunta:** ¿Cómo puede utilizarse este resultado para detectar
registros duplicados?

## 7. Operaciones fundamentales

``` java
tecnologias.contains("Java");
tecnologias.contains("C++");
tecnologias.remove("Git");
tecnologias.size();
tecnologias.isEmpty();
tecnologias.clear();
```

Para recorrer:

``` java
for (String tecnologia : tecnologias) {
    System.out.println(tecnologia);
}
```

`Set` no es una colección indexada, por lo que no existe una operación
conceptual equivalente a `get(0)`.

## 8. Trabajar con TreeSet

``` java
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

        for (String tecnologia : tecnologias) {
            System.out.println(tecnologia);
        }
    }
}
```

`TreeSet` mantiene los elementos según su orden natural o según un
`Comparator`.

## 9. Comparación estructural

`HashSet` utiliza una estructura basada en hashing y prioriza
operaciones eficientes de pertenencia, inserción y eliminación sin
mantener orden.

`TreeSet` mantiene una estructura de árbol ordenada, lo que permite
conservar una relación de orden entre los elementos.

Complete como hipótesis:

  |Característica |                  `HashSet`  | `TreeSet`|
  |----------------|---------------------------|-----------
  |Permite duplicados|no|no
 | Mantiene orden de inserción |no|no
  |Mantiene elementos ordenados |no|si
  |Búsqueda eficiente|si|si
  |Estructura conceptual |Hash table|Árbol ordenado
  |Requiere elementos comparables  |no|si

## 10. Complejidad temporal

 | Operación |           `HashSet`|   `TreeSet`|
 |--------------|--------------|-----------|
| `add()`|          O(1) promedio |   O(log n)|
|  `contains()`|     O(1) promedio|    O(log n)|
|  `remove()` |      O(1) promedio |   O(log n)|
|  recorrido  |               O(n) |       O(n)|

`HashSet` favorece operaciones rápidas promedio sin mantener orden.
`TreeSet` mantiene orden a cambio de operaciones O(log n).

## 11. Programar contra Set

``` java
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ComparacionSets {
    public static void main(String[] args) {
        probarSet("HashSet", new HashSet<>());
        probarSet("TreeSet", new TreeSet<>());
    }

    private static void probarSet(String nombre, Set<String> conjunto) {
        conjunto.add("Python");
        conjunto.add("Java");
        conjunto.add("SQL");
        conjunto.add("Docker");
        conjunto.add("Java");
        conjunto.add("Git");

        System.out.println(nombre);
        System.out.println(conjunto);
        System.out.println("Contiene Java: " + conjunto.contains("Java"));
        System.out.println("Tamaño: " + conjunto.size());
    }
}
```

Analice por qué el método puede trabajar con ambas implementaciones.

## 12. Operaciones matemáticas de conjuntos

### Unión

``` java
Set<String> union = new HashSet<>(grupoA);
union.addAll(grupoB);
```

### Intersección

``` java
Set<String> interseccion = new HashSet<>(grupoA);
interseccion.retainAll(grupoB);
```

### Diferencia

``` java
Set<String> diferencia = new HashSet<>(grupoA);
diferencia.removeAll(grupoB);
```

``` text
addAll()       → unión
retainAll()    → intersección
removeAll()    → diferencia
```

## 13. Operaciones adicionales de TreeSet

``` java
TreeSet<Integer> calificaciones = new TreeSet<>();

calificaciones.add(65);
calificaciones.add(70);
calificaciones.add(75);
calificaciones.add(80);
calificaciones.add(85);
calificaciones.add(90);
calificaciones.add(95);

System.out.println("Mínimo: " + calificaciones.first());
System.out.println("Máximo: " + calificaciones.last());
```

### Navegación

``` java
calificaciones.lower(80);
calificaciones.higher(80);
calificaciones.floor(82);
calificaciones.ceiling(82);
```

Interpretación:

``` text
lower(80)    → mayor elemento < 80
higher(80)   → menor elemento > 80
floor(82)    → mayor elemento <= 82
ceiling(82)  → menor elemento >= 82
```

### Rangos

``` java
calificaciones.subSet(70, true, 90, true);
```

Investigue también `headSet()` y `tailSet()`.

## 14. Orden personalizado

``` java
TreeSet<String> tecnologias =
    new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
```

o:

``` java
TreeSet<String> tecnologias =
    new TreeSet<>(Comparator.reverseOrder());
```

**Pregunta:** ¿Qué ventaja proporciona definir el criterio de
ordenamiento directamente en la colección?

## 15. Experimento de desempeño

Crear `BenchmarkSets.java`:

``` java
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class BenchmarkSets {
    private static final int N = 1_000_000;

    public static void main(String[] args) {
        probar("HashSet", new HashSet<>());
        probar("TreeSet", new TreeSet<>());
    }

    private static void probar(String nombre, Set<Integer> conjunto) {
        long inicio = System.nanoTime();

        for (int i = 0; i < N; i++) {
            conjunto.add(i);
        }

        long fin = System.nanoTime();

        System.out.printf(
            "%s - inserción: %.3f ms%n",
            nombre,
            (fin - inicio) / 1_000_000.0
        );
    }
}
```

Ejecute al menos tres veces:

 | Ejecución|     HashSet|   TreeSet|
|-----------|---------|---------|
|  1     |  121.433 ms   |137.165 ms|           
 | 2     |  80.850 ms  |115.413 ms|            
|  3     | 74.319 ms |121.195 ms|              
 | Promedio |   92.201 ms    | 124.591 ms |     

Después mida búsquedas mediante `contains()` y eliminaciones. Compare
los resultados con las complejidades esperadas. Los tiempos con
`System.nanoTime()` son exploratorios y no constituyen un benchmark
riguroso de la JVM.

Resultados de `contains()`:

| Ejecución | HashSet | TreeSet |
|-----------|---------|---------|
| 1 | 34.452 ms | 57.553 ms |
| 2 | 43.398 ms | 62.465 ms |
| 3 | 19.405 ms | 49.434 ms |
| Promedio | 32.418 ms | 56.484 ms |

Resultados de `remove()`:

| Ejecución | HashSet | TreeSet |
|-----------|---------|---------|
| 1 | 24.598 ms | 89.989 ms |
| 2 | 59.645 ms | 90.520 ms |
| 3 | 19.518 ms | 71.111 ms |
| Promedio | 34.587 ms | 83.873 ms |

## 16. Actividad integradora: Sistema de registro de participantes

Desarrolle `RegistroParticipantes.java` para administrar identificadores
de estudiantes:

``` text
A0032
A0015
A0081
A0032
A0021
A0015
A0105
A0007
A0081
A0044
```

El sistema deberá permitir:

``` text
1. Registrar estudiante
2. Buscar estudiante
3. Eliminar estudiante
4. Mostrar estudiantes
5. Mostrar número de estudiantes
6. Salir
```

No deberá permitir duplicados.

### Primera implementación

``` java
Set<String> estudiantes = new HashSet<>();
```

Utilice el valor retornado por `add()` para informar si el estudiante
fue registrado o ya existía.

### Segunda implementación

Cambie únicamente:

``` java
new HashSet<>()
```

por:

``` java
new TreeSet<>()
```

Compare el comportamiento funcional y el orden de presentación.

**Pregunta central:** Si ambos impiden duplicados, ¿qué requisito
funcional justificaría utilizar `TreeSet`?

## 17. Ampliación: consultas por rango

La universidad solicita mostrar los estudiantes cuyo identificador se
encuentre entre `A0020` y `A0080`.

Utilice `subSet()` con `TreeSet` y analice cómo este nuevo requisito
modifica la decisión entre ambas implementaciones.

## 18. Tabla comparativa final


 | Característica   |       `HashSet`   |            `TreeSet`|
 | -----------------------|-----------------------|-----------------------|
 | Implementa `Set`|        Sí |                     Sí|
 | Permite duplicados |     No    |                  No|
 | Mantiene orden de inserción|      No |                     No|
 |  Mantiene orden natural|  No    |            Sí   |                                     
 | Estructura conceptual|   Hash table |              Árbol ordenado| 
|  `add()`     |            O(1) promedio  |         O(log n) |
|  `contains()` |           O(1) promedio  |         O(log n) |
| `remove()` |             O(1) promedio  |         O(log n)|
|  Elemento mínimo/máximo|  No directamente |        `first()` / `last()`|
|  Navegación      |        No |                     Sí|
| Consultas por rango |     No directamente |         Sí|
|  Orden personalizado |    No como característica del Set | Sí, mediante `Comparator`|
| Uso típico    |          Pertenencia/unicidad  |  Unicidad + orden|
 
## 19. Criterios de selección

Cuando interesa principalmente comprobar pertenencia y no se requiere
mantener orden, `HashSet` suele ajustarse al patrón de operaciones.

Cuando se requieren elementos únicos y además orden, mínimo/máximo,
navegación o consultas por rango, las capacidades de `TreeSet` son
relevantes.

La decisión debe partir de los requisitos y operaciones predominantes.

## 20. Preguntas de análisis

1.  ¿Qué característica fundamental define a `Set`?

Respuesta: No permite elementos duplicados.
2.  ¿Permite `HashSet` elementos duplicados?

Respuesta: No.
3.  ¿Permite `TreeSet` elementos duplicados?

Respuesta: No.
4.  ¿Qué devuelve `add()` cuando el elemento ya existe?

Respuesta: `false`.
5.  ¿Por qué `HashSet` no garantiza un orden de iteración?

Respuesta: Porque usa hashing y no mantiene un orden.
6.  ¿Qué tipo de orden mantiene `TreeSet`?

Respuesta: Orden natural o por `Comparator`.
7.  ¿Cuál es la complejidad promedio de `HashSet.contains()`?

Respuesta: O(1) promedio.
8.  ¿Cuál es la complejidad de `TreeSet.contains()`?

Respuesta: O(log n).
9.  ¿Por qué `TreeSet` tiene un costo adicional respecto a `HashSet`?

Respuesta: Porque mantiene los elementos ordenados.
10. ¿Qué ventaja proporciona `TreeSet.first()`?

Respuesta: Obtiene el elemento mínimo.
11. ¿Qué diferencia existe entre `lower()` y `floor()`?

Respuesta: `lower()` es menor estricto; `floor()` es menor o igual.
12. ¿Qué diferencia existe entre `higher()` y `ceiling()`?

Respuesta: `higher()` es mayor estricto; `ceiling()` es mayor o igual.
13. ¿Para qué sirve `subSet()`?

Respuesta: Para obtener un rango de elementos.
14. ¿Qué papel desempeña un `Comparator` en `TreeSet`?

Respuesta: Define el criterio de ordenamiento.
15. ¿Cómo se implementa una unión utilizando `Set`?

Respuesta: Con `addAll()`.
16. ¿Cómo se implementa una intersección?

Respuesta: Con `retainAll()`.
17. ¿Cómo se implementa una diferencia?

Respuesta: Con `removeAll()`.
18. ¿En qué escenario utilizaría `HashSet`?

Respuesta: Cuando se necesita unicidad y búsquedas rápidas sin orden.
19. ¿En qué escenario utilizaría `TreeSet`?

Respuesta: Cuando se necesita unicidad y elementos ordenados.
20. ¿Por qué es conveniente declarar `Set<String>` en lugar de
    `HashSet<String>` cuando solo se necesitan operaciones de `Set`?

Respuesta: Porque permite usar distintas implementaciones de `Set`.

## 21. Entregables

``` text
ComparacionSets/
├── README.md
└── src/
    ├── EjemploHashSet.java
    ├── EjemploTreeSet.java
    ├── ComparacionSets.java
    ├── OperacionesSet.java
    ├── BenchmarkSets.java
    └── RegistroParticipantes.java
```

En `README.md` incluir:

-   explicación de diferencias entre `HashSet` y `TreeSet`;
-   tabla de resultados experimentales;
-   ejemplos de unión, intersección y diferencia;
-   evidencia de eliminación de duplicados;
-   evidencia del orden producido por `TreeSet`;
-   respuestas a las preguntas de análisis;
-   conclusión sobre la elección de la colección
