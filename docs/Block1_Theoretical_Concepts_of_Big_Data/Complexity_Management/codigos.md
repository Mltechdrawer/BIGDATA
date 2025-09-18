# Ejemplos 

## Velocidad de ejecución

### Python

```python
import random
from time import *

n = 1024

A = [[random.random() for _ in range(n)] for _ in range(n)]
B = [[random.random() for _ in range(n)] for _ in range(n)]
C = [[0 for _ in range(n)] for _ in range(n)]

start = time()
for i in range(n):
    for j in range(n):
        for k in range(n):
            C[i][j] += A[i][k] * B[k][j]

end = time()

print("%.6f" % (end - start))

# Python. Runing time aroud: 409 seconds with 1024x1024 matrices
```
---
## Java

```java
import java.util.Random;

public class Matrix {

    static int n = 1024;
    static double[][] a = new double[n][n];
    static double[][] b = new double[n][n];
    static double[][] c = new double[n][n];

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = random.nextDouble();
                b[i][j] = random.nextDouble();
                c[i][j] = 0;
            }
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        long stop = System.currentTimeMillis();

        System.out.println((stop - start) * 1e-3);
    }
}

// Java. Runing time aroud: 7.76 seconds with 1024x1024 matrices
```
---
## Rust

```rust
use std::time::SystemTime;
use rand::Rng;

fn main() {
    let n: usize = 1024;
    let mut a: Vec<Vec<f64>> = vec![vec![0.0_f64; n]; n];
    let mut b: Vec<Vec<f64>> = vec![vec![0.0_f64; n]; n];
    let mut c: Vec<Vec<f64>> = vec![vec![0.0_f64; n]; n];

    let mut rng = rand::thread_rng();
    for i in 0..n {
        for j in 0..n {
            a[i][j] = rng.gen::<f64>();
            b[i][j] = rng.gen::<f64>();
        }
    }

    let start: SystemTime = SystemTime::now();
    for i in 0..n {
        for j in 0..n {
            for k in 0..n {
                c[i][j] += a[i][k] * b[k][j];
            }
        }
    }
    let elapsed: Result<std::time::Duration, std::time::SystemTimeError> = start.elapsed();

    println!("Elapsed: {:.2?}", elapsed);
}

// Rust. Runing time aroud: 7.91 seconds with 1024x1024 matrices
```
---
## C

```C
#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>

#define n 1024
double a[n][n];
double b[n][n];
double c[n][n];

struct timeval start, stop;

int main() {
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            a[i][j] = (double) rand() / RAND_MAX;
            b[i][j] = (double) rand() / RAND_MAX;
            c[i][j] = 0;
        }
    }

    gettimeofday(&start, NULL);
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            for (int k = 0; k < n; ++k) {
                c[i][j] += a[i][k] * b[k][j];
            }
        }
    }
    gettimeofday(&stop, NULL);

    double diff = stop.tv_sec - start.tv_sec
                + 1e-6 * (stop.tv_usec - start.tv_usec);
    printf("%0.6f\n", diff);

    return 0;
}
/* C. Runing time aroud: 0.677867 seconds with 1024x1024 matrices
```
---