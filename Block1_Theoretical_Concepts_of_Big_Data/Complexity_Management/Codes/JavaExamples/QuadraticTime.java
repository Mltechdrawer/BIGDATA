// O (n^2)

public class QuadraticTime {
    public static void main(String[] args) {
        int n = 1000; // Input size
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * n);
        }
        
        long startTime = System.nanoTime(); // Start time
        
        // Bubble Sort - O(n^2) complexity
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        
        long endTime = System.nanoTime(); // End time
        System.out.println("Execution time (ns): " + (endTime - startTime));
    }
}

