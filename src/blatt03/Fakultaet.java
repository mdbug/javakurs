package blatt03;

import java.math.BigInteger;

public class Fakultaet {
    public static int berechneFakultaetInteger(int i) {
        return (i==0) ? 1 : berechneFakultaetInteger(i-1)*i;
    }

    public static long berechneFakultaetLong(int i) {
        return (i==0) ? 1 : berechneFakultaetLong(i-1)*i;
    }
    
    public static BigInteger berechneFakultaetBigInteger(int n) {
        return (n==0) ? BigInteger.ONE : BigInteger.valueOf(n).multiply(berechneFakultaetBigInteger(n-1));
    }

    public static void test(int n) {
        System.out.println("berechneFakultaetInteger(" + n + ") = " + berechneFakultaetInteger(n));
        System.out.println("berechneFakultaetLong   (" + n + ") = " + berechneFakultaetLong(n));
        System.out.println("berechneFakultaetBigInt (" + n + ") = " + berechneFakultaetBigInteger(n));
        System.out.println();
    }
    
     public static int getMaxIntFak() {
        int result = 1;
        for (int i=1;; i++) {
            try {
                result = Math.multiplyExact(result, i);
            } catch (ArithmeticException e) {
                return i-1;
            }
        }
    }  

    public static int getMaxLongFak() {
        long result = 1;
        for (int i=1;; i++) {
            try {
                result = Math.multiplyExact(result, i);
            } catch (ArithmeticException e) {
                return i-1;
            }
        }
    }  
    
    public static void main(String[] args) {
        test(5);
        test(10);
        test(20);
        test(50);
        test(100);
        test(1000);
        System.out.println(getMaxIntFak());
        System.out.println(getMaxLongFak());
    }
}
