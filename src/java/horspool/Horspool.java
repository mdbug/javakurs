package java.horspool;

public class Horspool {
    // Die Groesse des Alphabets
    int SIZE = 256;
    int[] table = new int[SIZE];

    public int horspool(String source, String pattern) {
        // Sprungtabelle initialisieren
        for (int i = 0; i < SIZE; i++) {
            table[i] = -1;
        }
        for (int i = 0; i < pattern.length() - 1; i++) {
            table[pattern.charAt(i)] = i;
        }
        int i = 0;
        while (i <= source.length() - pattern.length()) {
            int j = pattern.length() - 1;
            while (j >= 0 && pattern.charAt(j) == source.charAt(i + j))
                j--;
            if (j < 0)
                return i;
            i += pattern.length() - 1;
            i -= table[source.charAt(i)];
        }
        return -1;
    }

    public static void main(String[] args) {
        Horspool matcher = new Horspool();
        
        //Erzeuge einen 100 Millionen Zeichen langen String mit zufälligen Buchstaben
        StringBuilder sb = new StringBuilder();
        int STRINGSIZE = 100000000; //100 Millionen
        for (int i = 0; i < STRINGSIZE; i++) {
            sb.append((char) (Math.random() * 255));
        }
        
        String pattern = "lsdasdfsaldkjowejlskdnasdfwerfivmehdkgjla";
        sb.insert((int)(Math.random()*STRINGSIZE), pattern);
        String s = sb.toString();
        
        long t;
        System.out.println("Starte suche mit Horspool-Algorithmus");
        t = System.nanoTime();
        int pos = matcher.horspool(s, pattern);
        t = System.nanoTime() - t;
        t *= 1e-6;
        System.out.println("Position: " +pos);
        System.out.println("(" + t + " ms)");
        System.out.println("Starte suche mit Javas s.indexOf(p) nach");
        t = System.nanoTime();
        s.indexOf(pattern);
        t = System.nanoTime() - t;
        t *= 1e-6;
        System.out.println("Position: " +pos);
        System.out.println("(" + t + " ms)");
    }
}
