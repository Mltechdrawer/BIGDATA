// O(n)

public class LinearTime {
    public static void main(String[] args) {
        int n = 2000000; // Input size
        long startTime = System.nanoTime(); // Start time
        
        for (int i = 0; i < n; i++) { // O(n)
            // Just iterating, no output to avoid clutter
        }
        
        long endTime = System.nanoTime(); // End time
        System.out.println("Execution time (ns): " + (endTime - startTime));
    }
}

