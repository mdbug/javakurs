package java.blatt06;

/**
 * Created by micha on 17.11.2016.
 */
public class SchraegstrichFormat implements BruchFormat {
    @Override
    public String bruchToString(int zaehler, int nenner) {
        return zaehler + "/" + nenner;
    }
}
