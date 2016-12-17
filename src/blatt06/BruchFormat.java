package blatt06;

/**
 * Created by micha on 17.11.2016.
 */
@FunctionalInterface
public interface BruchFormat {
    String bruchToString(int zaehler, int nenner);
}