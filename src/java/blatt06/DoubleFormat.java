package java.blatt06;

/**
 * Created by micha on 17.11.2016.
 */
public class DoubleFormat implements BruchFormat {
    @Override
    public String bruchToString(int zaehler, int nenner) {
        return String.valueOf(((double)zaehler) / nenner);
    }
}
