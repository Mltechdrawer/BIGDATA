import java.util.Random;

public class StrassenMatrixMultiplication {
    private static final int THRESHOLD = 64; // switch to standard multiplication for small sizes

    public static double[][] multiply(double[][] A, double[][] B) {
        int n = A.length;
        double[][] C = new double[n][n];

        if (n <= THRESHOLD) {
            // Standard matrix multiplication for small matrices
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
            return C;
        }

        int newSize = n / 2;
        double[][] A11 = new double[newSize][newSize];
        double[][] A12 = new double[newSize][newSize];
        double[][] A21 = new double[newSize][newSize];
        double[][] A22 = new double[newSize][newSize];
        double[][] B11 = new double[newSize][newSize];
        double[][] B12 = new double[newSize][newSize];
        double[][] B21 = new double[newSize][newSize];
        double[][] B22 = new double[newSize][newSize];

        split(A, A11, 0, 0);
        split(A, A12, 0, newSize);
        split(A, A21, newSize, 0);
        split(A, A22, newSize, newSize);

        split(B, B11, 0, 0);
        split(B, B12, 0, newSize);
        split(B, B21, newSize, 0);
        split(B, B22, newSize, newSize);

        double[][] M1 = multiply(add(A11, A22), add(B11, B22));
        double[][] M2 = multiply(add(A21, A22), B11);
        double[][] M3 = multiply(A11, subtract(B12, B22));
        double[][] M4 = multiply(A22, subtract(B21, B11));
        double[][] M5 = multiply(add(A11, A12), B22);
        double[][] M6 = multiply(subtract(A21, A11), add(B11, B12));
        double[][] M7 = multiply(subtract(A12, A22), add(B21, B22));

        double[][] C11 = add(subtract(add(M1, M4), M5), M7);
        double[][] C12 = add(M3, M5);
        double[][] C21 = add(M2, M4);
        double[][] C22 = add(subtract(add(M1, M3), M2), M6);

        join(C11, C, 0, 0);
        join(C12, C, 0, newSize);
        join(C21, C, newSize, 0);
        join(C22, C, newSize, newSize);

        return C;
    }

    private static double[][] add(double[][] A, double[][] B) {
        int n = A.length;
        double[][] result = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                result[i][j] = A[i][j] + B[i][j];
        return result;
    }

    private static double[][] subtract(double[][] A, double[][] B) {
        int n = A.length;
        double[][] result = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                result[i][j] = A[i][j] - B[i][j];
        return result;
    }

    private static void split(double[][] P, double[][] C, int iB, int jB) {
        int n = C.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = P[i + iB][j + jB];
    }

    private static void join(double[][] C, double[][] P, int iB, int jB) {
        int n = C.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                P[i + iB][j + jB] = C[i][j];
    }

    private static double[][] randomMatrix(int n, long seed) {
        Random rnd = new Random(seed);
        double[][] m = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                m[i][j] = rnd.nextDouble();
        return m;
    }

    public static void main(String[] args) {
        int n = (args.length > 0) ? Integer.parseInt(args[0]) : 512;
        long seed = 42L;

        System.out.println("Generating random matrices A and B...");
        double[][] A = randomMatrix(n, seed);
        double[][] B = randomMatrix(n, seed + 1);

        long start = System.currentTimeMillis();
        double[][] C = multiply(A, B);
        long stop = System.currentTimeMillis();

        double checksum = 0.0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                checksum += C[i][j];

        System.out.printf("Running time %.2f seconds with %dx%d matrices (Strassen)%n", 
                (stop - start) / 1000.0, n, n);
        System.out.printf("Checksum: %.6f%n", checksum);
    }
}
