public class MatrixPower {
    public static void main(String[] args) {
        // Define the transition matrix T
        double[][] T = {
            {0, 1.0/5, 0, 0, 0, 0},
            {0, 0, 1.0/2, 1.0/2, 1.0/2, 1.0/2},
            {0, 1.0/5, 0, 0, 1.0/2, 0},
            {0, 1.0/5, 0, 0, 0, 1.0/2},
            {0, 1.0/5, 1.0/2, 0, 0, 0},
            {0, 1.0/5, 0, 1.0/2, 0, 0}
        };

        int n = 100; // Number of times to raise the matrix
        double[][] result = matrixPower(T, n);

        // Print the resulting matrix T^n
        System.out.println("Matrix T^" + n + ":");
        printMatrix(result);
    }

    // Method to raise the matrix T to the power n
    public static double[][] matrixPower(double[][] matrix, int power) {
        int size = matrix.length;
        double[][] result = new double[size][size];

        // Initialize result as the identity matrix
        for (int i = 0; i < size; i++) {
            result[i][i] = 1.0;
        }

        // Multiply the matrix by itself n times
        double[][] temp = matrix;
        for (int p = 0; p < power; p++) {
            result = multiplyMatrices(result, temp);
        }

        return result;
    }

    // Method to multiply two matrices
    public static double[][] multiplyMatrices(double[][] A, double[][] B) {
        int size = A.length;
        double[][] result = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = 0;
                for (int k = 0; k < size; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }

    // Method to print a matrix
    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.printf("%-10.6f ", val);
            }
            System.out.println();
        }
    }
}
