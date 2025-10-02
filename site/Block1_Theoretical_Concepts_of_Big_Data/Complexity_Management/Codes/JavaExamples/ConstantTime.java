// O(1)

public class ConstantTime {
    public static void main(String[] args) {
        int n = 100;  // This can be any large number
        long startTime = System.nanoTime(); // Start time
        
        System.out.println("Hello, World!"); // O(1) operation
        
        long endTime = System.nanoTime(); // End time
        System.out.println("Execution time (ns): " + (endTime - startTime));
    }
}

