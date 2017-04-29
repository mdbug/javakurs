package java.blatt06;

/**
 * Created by micha on 17.11.2016.
 */
public class DreizeilenFormat implements BruchFormat {

    @Override
    public String bruchToString(int zaehler, int nenner) {
        StringBuilder sb = new StringBuilder();
        String z = String.valueOf(Math.abs(zaehler));
        String n = String.valueOf(Math.abs(nenner));
        boolean negative = zaehler < 0;
        int length = Math.max(z.length(), n.length());
        if (negative)
            sb.append("  ");
        //Zaehler
        for (int i = 0; i < length - z.length(); i++) {
            sb.append(" ");
        }
        sb.append(z);
        sb.append("\n");
        //Vorzeichen
        if (negative)
            sb.append("- ");
        //Bruchstrich
        for (int i = 0; i < length; i++) {
            sb.append("–");
        }
        sb.append("\n");
        //Nenner
        if (negative)
            sb.append("  ");
        for (int i = 0; i < length - n.length(); i++) {
            sb.append(" ");
        }
        sb.append(n);
        return sb.toString();
    }
}
