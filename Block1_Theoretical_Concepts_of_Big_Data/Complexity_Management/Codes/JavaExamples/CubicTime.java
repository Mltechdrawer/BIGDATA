// O(n^3)

public class CubicTime {
    public static void main(String[] args) {
        int n = 100; // Matrix size (n x n)
        int[][] matrixA = new int[n][n];
        int[][] matrixB = new int[n][n];
        int[][] result = new int[n][n];

        // Fill matrices with random values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixA[i][j] = (int) (Math.random() * 100);
                matrixB[i][j] = (int) (Math.random() * 100);
            }
        }

        long startTime = System.nanoTime(); // Start time

        // Matrix multiplication - O(n^3)
        for (int i = 0; i < n; i++) {          // O(n)
            for (int j = 0; j < n; j++) {      // O(n)
                for (int k = 0; k < n; k++) {  // O(n)
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        long endTime = System.nanoTime(); // End time
        System.out.println("Execution time (ns): " + (endTime - startTime));
    }
}

