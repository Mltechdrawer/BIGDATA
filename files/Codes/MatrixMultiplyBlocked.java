import java.util.Random;

public class MatrixMultiplyBlocked {
    // Blocked matrix multiplication to improve cache reuse
    public static double[][] multiply(double[][] a, double[][] b, int blockSize) {
        int n = a.length;
        double[][] c = new double[n][n];

        long start = System.currentTimeMillis();

        for (int kk = 0; kk < n; kk += blockSize) {
            for (int jj = 0; jj < n; jj += blockSize) {
                for (int i = 0; i < n; i++) {
                    for (int j = jj; j < Math.min(jj + blockSize, n); j++) {
                        double sum = c[i][j];
                        for (int k = kk; k < Math.min(kk + blockSize, n); k++) {
                            sum += a[i][k] * b[k][j];
                        }
                        c[i][j] = sum;
                    }
                }
            }
        }

        long stop = System.currentTimeMillis();
        System.out.printf("Running time %.2f seconds with %dx%d matrices (blocked, blockSize=%d)%n",
                (stop - start) / 1000.0, n, n, blockSize);

        return c;
    }

    private static double[][] randomMatrix(int n, long seed) {
        Random rnd = new Random(seed);
        double[][] m = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = rnd.nextDouble();
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int n = (args.length > 0) ? Integer.parseInt(args[0]) : 1024;
        int blockSize = (args.length > 1) ? Integer.parseInt(args[1]) : 32;
        long seed = 42L;

        System.out.println("Generating random matrices A and B...");
        double[][] a = randomMatrix(n, seed);
        double[][] b = randomMatrix(n, seed + 1);

        double[][] c = multiply(a, b, blockSize);

        // Simple checksum to prevent optimization
        double checksum = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                checksum += c[i][j];
            }
        }
        System.out.printf("Checksum: %.6f%n", checksum);
    }
}
