// O (log n)

import java.util.Arrays;

public class LogarithmicTime {
    public static void main(String[] args) {
        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int target = 999999;
        
        long startTime = System.nanoTime(); // Start time
        
        int index = Arrays.binarySearch(arr, target); // O(log n) operation
        
        long endTime = System.nanoTime(); // End time
        System.out.println("Element found at index: " + index);
        System.out.println("Execution time (ns): " + (endTime - startTime));
    }
}
