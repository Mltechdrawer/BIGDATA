// O(2^n)

public class ExponentialTime {
    public static void main(String[] args) {
        int n = 30; // You might need to start with a smaller n due to exponential growth
        long startTime = System.nanoTime(); // Start time
        
        System.out.println("Fibonacci(" + n + ") = " + fibonacci(n)); // O(2^n)
        
        long endTime = System.nanoTime(); // End time
        System.out.println("Execution time (ns): " + (endTime - startTime));
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

