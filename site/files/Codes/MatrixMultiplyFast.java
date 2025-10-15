import java.util.Random;

public class MatrixMultiplyFast {
    // ikj loop order (more cache-friendly for B's columns)
    public static double[][] multiply(double[][] a, double[][] b) {
        int n = a.length;
        double[][] c = new double[n][n];
        long start = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                double aik = a[i][k];
                for (int j = 0; j < n; j++) {
                    c[i][j] += aik * b[k][j];
                }
            }
        }

        long stop = System.currentTimeMillis();
        System.out.printf("Running time %.2f seconds with %dx%d matrices (ikj order)%n",
                (stop - start) / 1000.0, n, n);
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
        long seed = 42L;

        System.out.println("Generating random matrices A and B...");
        double[][] a = randomMatrix(n, seed);
        double[][] b = randomMatrix(n, seed + 1);

        double[][] c = multiply(a, b);

        // simple checksum so the JIT doesn't dead-code-eliminate work
        double checksum = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                checksum += c[i][j];
            }
        }
        System.out.printf("Checksum: %.6f%n", checksum);
    }
}
