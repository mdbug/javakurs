package java.blatt04;

public class Binaerzahl2 {
    
    private String s;
    private int max;
    private static Binaerzahl2 ONE = new Binaerzahl2(1,1);
    
    public Binaerzahl2(int zahl, int maxStellen) {
        if (zahl < 0 || zahl >= (1 << maxStellen)) {
            throw new ArithmeticException();
        }
        StringBuilder sb = new StringBuilder();
        do {
            sb.insert(0, zahl % 2);
            zahl /= 2;
        } while (zahl > 0);
        s = sb.toString();
        max = maxStellen;
    }
   
    private int toInt() {
        int sum = 0;
        for (int i=0; i<s.length(); i++) {
           sum += Integer.parseInt("" + s.charAt(s.length()-1-i)) << i ;
        }
        return sum;
    }

    public String toString() {
        return s; //+ " (" + toInt() + ")";
    }
    
    public void add(Binaerzahl2 zahl2) {
        StringBuilder sb = new StringBuilder();
        int uebertrag = 0;
        char c1, c2;
        for (int i = 0; i < max; i++) {
            int stelle1 = s.length()-1-i;
            int stelle2 = zahl2.s.length()-1-i;
            if (stelle1 > -1) {
                c1 = s.charAt(stelle1);
                c1 -= '0';
            } else {
                c1 = 0;
            }
            if (stelle2 > -1) {
                c2 = zahl2.s.charAt(stelle2);
                c2 -= '0';
            } else {
                c2 = 0;
            }
            int x = (c1 + c2 + uebertrag) % 2;
            uebertrag = (c1 + c2 + uebertrag) == x ? 0 : 1;
            sb.insert(0, x);
        }
        if (uebertrag > 0) {
            throw new ArithmeticException();
        }
        s = sb.toString();
    }
    
    private void leftpad() {
        for (int i=0; i < max - s.length(); i++) {
            s = "0" + s;
        }
    }
    
    public void zweierkomplement() {
        leftpad();
        s = s.replace('0', 'e');
        s = s.replace('1', '0');
        s = s.replace('e', '1');
        add(ONE);
    }

    public static void main(String[] args) {
        int zahl1 = 284;
        int zahl2 = 51;
        Binaerzahl2 bz1 = new Binaerzahl2(zahl1, 9);
        Binaerzahl2 bz2 = new Binaerzahl2(zahl2, 7);
        bz1.add(bz2);
        System.out.println(bz1);
        bz1.zweierkomplement();
        System.out.println(bz1);
    }


}
