package blatt06;

import java.util.Locale;

/**
 * Created by micha on 17.11.2016.
 */
public class BenutzerFormat implements BruchFormat {
    private String format;
    private Locale locale;

    public BenutzerFormat(String format) {
        this.locale = Locale.GERMAN;
        this.format = format;
    }

    public BenutzerFormat(String format, Locale locale) {
        this.format = format;
        this.locale = locale;
    }

    @Override
    public String bruchToString(int zaehler, int nenner) {
        return String.format(format, ((double) zaehler) / nenner);
    }
}
