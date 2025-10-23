# Lectures – Monitoring and Performance Engineering - Code examples

## Code Simplification -- Don't do it

```java

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DemoDontDoItBad {
    public static int sumEven(int[] data) {
        // Convertir a lista (innecesario)
        List<Integer> asList = Arrays.stream(data).boxed().collect(Collectors.toList());

        // Ordenar todo el array (no afecta a la suma)
        Arrays.sort(data);

        // Calcular una suma total que nunca se usa
        int unusedTotal = 0;
        for (int x : data) {
            unusedTotal += x; // <-- resultado no utilizado
        }

        // Lo único que queremos: sumar pares (pero ya hemos hecho trabajo inútil arriba)
        int evenSum = 0;
        for (int x : data) {
            if (x % 2 == 0) {
                evenSum += x;
            }
        }
        return evenSum;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 7, 8, 4, 3};
        System.out.println(sumEven(nums)); // 14
    }
}
```

```java
public class DemoDontDoItGood {
    public static int sumEven(int[] data) {
        int evenSum = 0;
        for (int x : data) {
            if ((x & 1) == 0) { // equivalente a x % 2 == 0, más barato
                evenSum += x;
            }
        }
        return evenSum;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 7, 8, 4, 3};
        System.out.println(sumEven(nums)); // 14
    }
}
```

## Problem Simplification 

```java
public class DemoDoItAgainBad {

    // Implementación ineficiente: recalcula todo una y otra vez
    public static long fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("F(40) = " + fibonacci(40));
        System.out.println("Tiempo: " + (System.currentTimeMillis() - start) + " ms");
    }
}
```

```java
import java.util.HashMap;
import java.util.Map;

public class DemoDoItAgainGood {

    private static final Map<Integer, Long> memo = new HashMap<>();

    public static long fibonacci(int n) {
        if (n <= 1) return (long) n;

        // Si ya lo calculamos antes, lo devolvemos directamente
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Calculamos solo si es nuevo
        long result = fibonacci(n - 1) + fibonacci(n - 2);
        memo.put(n, result); // Guardamos el resultado
        return result;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("F(40) = " + fibonacci(40));
        System.out.println("Tiempo: " + (System.currentTimeMillis() - start) + " ms");
    }
}
```

## Relentless Suspicion

```java
public class DemoDoItLessBad {
    public static int countLetter(String text, char target) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {  // correcto
            // cada vez creamos una subcadena innecesaria
            String letter = text.substring(i, i + 1);
            if (letter.charAt(0) == target) {
                count++;
            }

            // Comprobación redundante en cada iteración
            if (i == text.length() - 1) {
                System.out.println("Fin del bucle.");  // inútil dentro del bucle
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String phrase = "banana";
        System.out.println("Cantidad de 'a': " + countLetter(phrase, 'a'));
    }
}
```

```java
public class DemoDoItLessGood {
    public static int countLetter(String text, char target) {
        int count = 0;
        int len = text.length(); // calculado una sola vez

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == target) {
                count++;
            }
        }

        System.out.println("Fin del bucle."); // fuera del bucle
        return count;
    }

    public static void main(String[] args) {
        String phrase = "banana";
        System.out.println("Cantidad de 'a': " + countLetter(phrase, 'a'));
    }
}
```

## Early Binding

```java
public class DemoDoItBetterBad {
    // Busca linealmente: O(n)
    public static boolean containsLinear(int[] sorted, int target) {
        for (int x : sorted) {
            if (x == target) return true;
            // Incluso pudiendo cortar si x > target, no lo hacemos
        }
        return false;
    }

    public static void main(String[] args) {
        int[] data = {1, 4, 7, 9, 12, 15, 21, 34, 55, 89}; // ya ordenado
        System.out.println(containsLinear(data, 21)); // true
        System.out.println(containsLinear(data, 22)); // false
    }
}
```

```java
import java.util.Arrays;

public class DemoDoItBetterGood {
    // Implementación manual: O(log n)
    public static boolean containsBinary(int[] sorted, int target) {
        int lo = 0, hi = sorted.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >>> 1); // evita overflow
            if (sorted[mid] == target) return true;
            if (sorted[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }

    // Alternativa con la librería estándar
    public static boolean containsWithJdk(int[] sorted, int target) {
        return Arrays.binarySearch(sorted, target) >= 0;
    }

    public static void main(String[] args) {
        int[] data = {1, 4, 7, 9, 12, 15, 21, 34, 55, 89};
        System.out.println(containsBinary(data, 21));   // true
        System.out.println(containsBinary(data, 22));   // false

        System.out.println(containsWithJdk(data, 21));  // true
        System.out.println(containsWithJdk(data, 22));  // false
    }
}
```