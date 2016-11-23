package kodierung;

/**
 * Created by micha on 23.11.2016.
 */
public class Kodierung {
    private static String index = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    public static String kodieren(String text) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            int c1 = text.charAt(i); i++;
            int c2 = text.charAt(i); i++;
            int c3 = text.charAt(i); i++;

            int k1 = (c1 & 0xFF) >> 2;
            int k2 = ((c1 & 0x3) << 4) | ((c2 & 0xF0) >> 4);
            int k3 = ((c2 & 0xF) << 2) | ((c3 & 0xC0) >> 6);
            int k4 = (c3 & 0x3F);

            sb.append(index.charAt(k1));
            sb.append(index.charAt(k2));
            sb.append(index.charAt(k3));
            sb.append(index.charAt(k4));
        }
        return sb.toString();
    }
    public static String dekodieren(String code) {
        return null;
    }


    public static void main(String[] args) {
        System.out.println(kodieren("Wie"));
    }
}
