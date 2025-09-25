import java.util.Arrays;

public class LinearithmicTime {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            // random integer between 0 and 99,999
            arr[i] = (int) (Math.random() * 100000);
        }
        
        long startTime = System.nanoTime(); // Start time
        
        Arrays.sort(arr); // O(n log n) operation
        
        long endTime = System.nanoTime(); // End time
        System.out.println("Execution time (ns): " + (endTime - startTime));
    }
}

