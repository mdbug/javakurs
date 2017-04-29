package java.blatt11;

/**
 * Created by micha on 22.12.2016.
 */
public class Rekursion {

    public static long fakultaet (int n) {
        return n == 0 ? 1 : n * fakultaet(n-1);
    }

    public static long fibonacci (int n) {
        return n <= 2 ? 1 : fibonacci(n-1) + fibonacci(n-2);
    }

    public static int summe (int anfang, int ende) {
        return anfang > ende ? 0 : anfang + summe(anfang+1, ende);
    }

    public static int ggt (int a, int b) {
        if (a == b)
            return a;
        else if (a > b)
            return ggt(a-b, b);
        else
            return ggt(a, b-a);
    }

    public static int getPascalWert (int i, int j) {
        if (j > i)
            return 0;
        else if (j == 0 || j == i)
            return 1;
        else
           return getPascalWert(i-1, j) + getPascalWert(i-1, j-1);
    }

    public static void rekursiveAusgabe (int n) {
        System.out.println(n % 10);
        if (n > 0)
            rekursiveAusgabe(n / 10);
    }

    public static void rekursiveAusgabe2 (int n) {
        if (n > 0)
            rekursiveAusgabe(n / 10);
        System.out.println(n % 10);
    }

    public static String umkehren (String s) {
        if (s.length() < 2)
            return s;
        return umkehren (s.substring(1)) + s.charAt(0);
    }

    public static int primeCombos (int n) {
        if (n <= 3)
            return 1;
        int combos = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime(i)) {
                combos += primeCombos(n - i);
            }
        }
        return combos;
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i < Math.sqrt(n); ++i) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(umkehren("Hallo"));
        System.out.println(primeCombos(10));
    }
}
