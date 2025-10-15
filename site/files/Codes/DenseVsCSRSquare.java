import java.util.Random;

/**
 * Squares a sparse matrix in two ways and compares times:
 * 1) Dense: A (dense 512x512 with ~25% density) multiplied by itself -> C_dense = A * A
 * 2) Sparse: Convert A to CSR as B, then multiply B * B using CSR×CSR -> C_sparse (dense output)
 *
 * Prints timings, speedup, and numeric agreement (checksum and max abs diff).
 */
public class DenseVsCSRSquare {

    static class CSR {
        final int n;
        final double[] val;
        final int[] col;
        final int[] rowPtr;
        CSR(int n, double[] val, int[] col, int[] rowPtr) {
            this.n = n;
            this.val = val;
            this.col = col;
            this.rowPtr = rowPtr;
        }
    }

    public static void main(String[] args) {
        int n = 512;
        double density = 0.25; // 25% non-zeros

        if (args.length >= 1) n = Integer.parseInt(args[0]);
        if (args.length >= 2) density = Double.parseDouble(args[1]);

        long seed = 42L;
        System.out.printf("Generating A (n=%d, density=%.2f)...%n", n, density);
        double[][] A = generateRandomSparseAsDense(n, density, seed);

        // Warmup JIT
        warmup(A);

        // Dense square: A * A (ijk optimized as ikj)
        long t0 = System.nanoTime();
        double[][] C_dense = multiplyDense(A, A);
        long t1 = System.nanoTime();

        // Build CSR B from A
        CSR B = buildCSR(A);

        // Sparse square: B * B using CSR×CSR (accumulate into dense output)
        long t2 = System.nanoTime();
        double[][] C_sparse = multiplyCSR_CSR_toDense(B, B);
        long t3 = System.nanoTime();

        double secDense = (t1 - t0) / 1e9;
        double secSparse = (t3 - t2) / 1e9;

        double chkDense = checksum(C_dense);
        double chkSparse = checksum(C_sparse);
        double maxDiff = maxAbsDiff(C_dense, C_sparse);

        System.out.printf("Dense (A*A)   time: %.3f s%n", secDense);
        System.out.printf("Sparse (B*B)  time: %.3f s%n", secSparse);
        System.out.printf("Speedup (dense/sparse): %.2fx%n", secDense / secSparse);
        System.out.printf("Checksum dense : %.6f%n", chkDense);
        System.out.printf("Checksum sparse: %.6f%n", chkSparse);
        System.out.printf("Max |dense - sparse|: %.3e%n", maxDiff);
    }

    // ---------- Generation ----------
    static double[][] generateRandomSparseAsDense(int n, double density, long seed) {
        Random rnd = new Random(seed);
        double[][] a = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rnd.nextDouble() < density) {
                    a[i][j] = rnd.nextDouble();
                } else {
                    a[i][j] = 0.0;
                }
            }
        }
        return a;
    }

    // ---------- Dense multiply (ikj order) ----------
    static double[][] multiplyDense(double[][] A, double[][] B) {
        int n = A.length;
        double[][] C = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                double aik = A[i][k];
                if (aik == 0.0) continue; // small skip
                double[] Bk = B[k];
                double[] Ci = C[i];
                for (int j = 0; j < n; j++) {
                    Ci[j] += aik * Bk[j];
                }
            }
        }
        return C;
    }

    // ---------- CSR build ----------
    static CSR buildCSR(double[][] A) {
        int n = A.length;
        int nnz = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0.0) nnz++;
            }
        }
        double[] val = new double[nnz];
        int[] col = new int[nnz];
        int[] rowPtr = new int[n + 1];

        int p = 0;
        for (int i = 0; i < n; i++) {
            rowPtr[i] = p;
            for (int j = 0; j < n; j++) {
                double v = A[i][j];
                if (v != 0.0) {
                    val[p] = v;
                    col[p] = j;
                    p++;
                }
            }
        }
        rowPtr[n] = p;
        return new CSR(n, val, col, rowPtr);
    }

    // ---------- CSR × CSR -> dense ----------
    static double[][] multiplyCSR_CSR_toDense(CSR A, CSR B) {
        int n = A.n;
        double[][] C = new double[n][n];

        for (int i = 0; i < n; i++) {
            int aStart = A.rowPtr[i];
            int aEnd = A.rowPtr[i + 1];
            double[] Ci = C[i];

            for (int ap = aStart; ap < aEnd; ap++) {
                int k = A.col[ap];      // column index in A, row index in B
                double aik = A.val[ap];

                int bStart = B.rowPtr[k];
                int bEnd = B.rowPtr[k + 1];

                for (int bp = bStart; bp < bEnd; bp++) {
                    int j = B.col[bp];
                    Ci[j] += aik * B.val[bp];
                }
            }
        }
        return C;
    }

    // ---------- Utilities ----------
    static void warmup(double[][] A) {
        // do a tiny op to warm up JIT
        multiplyDense(A, A);
    }

    static double checksum(double[][] M) {
        int n = M.length;
        double s = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s += M[i][j];
            }
        }
        return s;
    }

    static double maxAbsDiff(double[][] X, double[][] Y) {
        int n = X.length;
        double m = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double d = Math.abs(X[i][j] - Y[i][j]);
                if (d > m) m = d;
            }
        }
        return m;
    }
}
