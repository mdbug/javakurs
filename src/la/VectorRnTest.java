package la;

public class VectorRnTest {

    public static void main(String[] args) {
        VectorRn a = new VectorRn(1, 2, 3, 4);
        VectorRn b = new VectorRn(5, 6, 7, 8);
        VectorRn c = new VectorRn(1, 2);
        VectorRn d = new VectorRn(15, 18, 21, 24);
        VectorRn e = new VectorRn(5, 2);
        VectorRn f = new VectorRn(-2, 5);
        double t = 3;
        
        final int TESTFAELLE = 12;
        for (int i = 0; i < TESTFAELLE ; i++) {
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
                    System.out.print("t * a  = ");
                    System.out.println(a.mult(t).toString());
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
                case 6:
                    System.out.print("a || b = ");
                    System.out.println(a.isParallel(b));
                    break;
                case 7:
                    System.out.print("a || c = ");
                    System.out.println(a.isParallel(c));
                    break;
                case 8:
                    System.out.print("b || d = ");
                    System.out.println(b.isParallel(d));
                    break;
                case 9:
                    System.out.print("<(a,b) = ");
                    System.out.println(VectorRn.getWinkel(a, b));
                    break;
                case 10:
                    System.out.print("<(e,f) = ");
                    System.out.println(VectorRn.getWinkel(e, f));
                    break;
                case 11:
                    System.out.print("Projektion von e auf f = ");
                    System.out.println(VectorRn.projiziereV1AufV2(e, f));
                    break;
                }
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
