package java.blatt12;

/**
 * Created by micha on 05.01.2017.
 */
public class IEEE {
    static final int BIAS = 127;

    public static String FloatToIEEE (float eingabe) {
        char vorzeichen = eingabe < 0 ? '1' : '0';
        int exponent = BIAS;
        double mantisse = eingabe;
        while (mantisse < 1) {
            mantisse *= 2;
            exponent--;
        }
        while (mantisse >= 2) {
            mantisse /= 2;
            exponent++;
        }
        mantisse *= Math.pow(2, 23);

        StringBuilder sb = new StringBuilder();
        sb.append(vorzeichen);
        String exponentString = Integer.toBinaryString(exponent);

        sb.append(leftpad(exponentString, '0', 8));
        sb.append(Integer.toBinaryString((int)mantisse));

        // 1 vor dem Komma entfernen
        sb.deleteCharAt(9);
        // Trennzeichen
        sb.insert(1, '/').insert(10, '/');
        return sb.toString();

    }

    public static float IEEEToFloat(String eingabe) {
        if (eingabe.length() != 32)
            throw new IllegalArgumentException();

        int vorzeichen = Integer.parseInt(eingabe.substring(0, 1), 2) == 1 ? -1 : 1;
        int exponent = Integer.parseInt(eingabe.substring(1, 9), 2) - BIAS;
        double mantisse = Integer.parseInt(eingabe.substring(9), 2) * Math.pow(2, -23);

        return (float) (vorzeichen * (1 + mantisse) * Math.pow(2, exponent));
    }

    private static String leftpad(String s, char c, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length - s.length(); ++i) {
            sb.append(c);
        }
        sb.append(s);
        return sb.toString();
    }

    public static void main (String[] args) {
        System.out.println(IEEEToFloat("01000010000010010101110000101001"));
        System.out.println(FloatToIEEE(34.34f));
        System.out.println("0/10000100/00010010101110000101001");
    }
}
