package la2.ha04;

import java.util.Random;
import java.util.Scanner;

/**
 * Test der Klasse QuadMatrix
 */
public class TestQuadMatrix {
    public static void main(String[] args) {
//        QuadMatrix a = new QuadMatrix(new double[][]{{1, 2, 3}, {1, 1, 2}, {3, 2, 2}});
//        QuadMatrix b = new QuadMatrix(new double[][]{{2, -1, 1}, {1, -2, 0}, {0, 3, 1}});
//
//        System.out.printf("%25s | %-50s\n", "Eingabe", "Ausgabe");
//        System.out.print("--------------------------+---------------------------------------------------\n");
//        System.out.printf("%25s | %-50s\n", "Bestimmung der Dimension", a.getDim());
//        System.out.printf("%25s | %-50s\n", "Addiere B zu A", a.addiere(b));
//        System.out.printf("%25s | %-50s\n", "Multipliziere A mit 5", a.multipliziere(5));

//        QuadMatrix c = new QuadMatrix(new double[][]{{5, -3, 4}, {-1, 2, 0}, {-6, 3, 1}});
//        System.out.println(c.detLaplace());
//        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Dimension: ");
        String input = scanner.nextLine();
        int n = Integer.parseInt(input);

        Random rng = new Random();
        System.out.printf(" n | Rechenzeit\n");
        System.out.printf("---+-------------\n");
        double[][] arr = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = rng.nextInt(7) - 3;
            }
        }
        QuadMatrix m = new QuadMatrix(arr);
        long t0, t1, t2;
        double det;
        t0 = System.nanoTime();
        det = m.detLaplace();
        t1 = System.nanoTime();
        System.out.printf("%2d | %.2e ms\n", n, (t1 - t0) * 1e-6);

//        test();
    }

    private static void test() {
        Random rng = new Random();
        System.out.printf(" n | Rechenzeit\n");
        System.out.printf("---+-------------\n");
        for (int n = 1; n <= 20; n++) {
            long time = 0;
            int count = 0;
            while(time < 1e9) {
                double[][] a = new double[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        a[i][j] = rng.nextInt(7) - 3;
                    }
                }
                QuadMatrix m = new QuadMatrix(a);
                long t0, t1;
                double det;
                t0 = System.nanoTime();
                det = m.detLaplace();
                t1 = System.nanoTime();
                time += t1 - t0;
                count++;
            }
            System.out.printf("%2d | %.2e ms\n", n, (time / count) * 1e-6);
        }
    }
}