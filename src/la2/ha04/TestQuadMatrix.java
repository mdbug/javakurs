package la2.ha04;

/**
 * Test der Klasse QuadMatrix
 */
public class TestQuadMatrix {
    public static void main(String[] args) {
        QuadMatrix a = new QuadMatrix(new double[][]{{1, 2, 3}, {1, 1, 2}, {3, 2, 2}});
        QuadMatrix b = new QuadMatrix(new double[][]{{2, -1, 1}, {1, -2, 0}, {0, 3, 1}});

        System.out.printf("%25s | %-50s\n", "Eingabe", "Ausgabe");
        System.out.print("--------------------------+---------------------------------------------------\n");
        System.out.printf("%25s | %-50s\n", "Bestimmung der Dimension", a.getDim());
        System.out.printf("%25s | %-50s\n", "Addiere B zu A", a.addiere(b));
        System.out.printf("%25s | %-50s\n", "Multipliziere A mit 5", a.multipliziere(5));
    }
}