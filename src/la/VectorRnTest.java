package la;

public class VectorRnTest {

    public static void main(String[] args) {
        VectorRn a = new VectorRn(1, 2, 3, 4);
        VectorRn b = new VectorRn(5, 6, 7, 8);
        VectorRn c = new VectorRn(1, 2);
        double d = 3;

        for (int i = 0; i < 6; i++) {
            try {
                switch (i) {
                case 0:
                    System.out.print("a + b  = ");
                    System.out.println(a.add(b).toString());
                    break;
                case 1:
                    System.out.print("a + c  = ");
                    System.out.println(a.add(c).toString());
                    break;
                case 2:
                    System.out.print("d * a  = ");
                    System.out.println(a.mult(d).toString());
                    break;
                case 3:
                    System.out.print("<a, b> = ");
                    System.out.println(VectorRn.scalarProd(a, b));
                    break;
                case 4:
                    System.out.print("<a, c> = ");
                    System.out.println(VectorRn.scalarProd(a, c));
                    break;
                case 5:
                    System.out.print("||a||  = ");
                    System.out.println(a.getNorm());
                    break;
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
