package blatt05;

public class Datum {
    public static final int[] monatslaengen = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    public static final String[] wochentage = { "Mo", "Di", "Mi", "Do", "Fr", "Sa", "So" };
    private int tag, monat, jahr;

    public static int getMonatslaenge(int monat, int jahr) {
        if (monat == 2 && isSchaltjahr(jahr))
            return 29;
        return monatslaengen[monat-1];
    }

    public static boolean isSchaltjahr(int jahr) {
        if (jahr%100 == 0 && jahr%400 != 0)
            return false;
        else
            return (jahr % 4 == 0);
    }

    public boolean equals(Datum a) {
        return (a.tag == this.tag && a.monat == this.monat && a.jahr == this.jahr);
    }

    public boolean isGleicherTag(Datum a) {
        return (a.tag == this.tag && a.monat == this.monat);
    }

    public String toString() {
        return String.format("%2d.%2d.%4d", tag, monat, jahr);
    }

    public Datum(int tag, int monat, int jahr) {
        if (jahr < 1800 || jahr > 2100)
            throw new DateOutOfRangeException();
        if (tag < 1 || monat < 1 || tag > getMonatslaenge(monat, jahr) )
            throw new InvalidDateException();
            
        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
    }

    public Datum(int tag, int jahr) {
        if (jahr < 1800 || jahr > 2100)
            throw new DateOutOfRangeException();
        if (tag < 1) 
            throw new InvalidDateException();

        monat = 1;
        while(monat <= 12 && tag > getMonatslaenge(monat, jahr)) {
            tag -= getMonatslaenge(monat, jahr);
            monat++;
        }
        if (monat > 12)
            throw new InvalidDateException();

        this.tag = tag;
        this.jahr = jahr;
    }

    public Datum morgen() {
        int tagMorgen = this.tag + 1;
        int monatMorgen = this.monat;
        int jahrMorgen = this.jahr;
        if (tagMorgen > getMonatslaenge(this.monat, this.jahr)) {
            tagMorgen = 1;
            monatMorgen++;
        }
        if (monatMorgen > 12) {
            monatMorgen = 1;
            jahrMorgen++;
        }
        return new Datum(tagMorgen, monatMorgen, jahrMorgen);
    }

    public Datum gestern() {
        int tagGestern = this.tag - 1;
        int monatGestern = this.monat;
        int jahrGestern = this.jahr;
        if (tagGestern < 1) {
            monatGestern--;
            if (monatGestern < 1) {
                monatGestern = 12;
                jahrGestern--;
            }
            tagGestern = getMonatslaenge(monatGestern, jahrGestern);
        }
        return new Datum(tagGestern, monatGestern, jahrGestern);
    }

    public String getWochentag() {
        int[] monate = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        int j = jahr;
        j -= monat < 3 ? 1 : 0;

        return wochentage[(j + (j / 4) - (j / 100) + (j / 400) + monate[monat - 1] + tag - 1) % 7];
    }
    
    public static void main(String[] args) {
        Datum d1 = new Datum(10, 11, 2016);
        System.out.println(d1);
        System.out.println(d1.getWochentag());
        Datum d2 = new Datum(60, 1960);
        System.out.println(d2);
        System.out.println(d2.getWochentag());
        Datum d3 = new Datum(366, 2000);
        System.out.println(d3);
        System.out.println(d3.getWochentag());
        Datum d4 = new Datum(9, 11, 1989);
        System.out.println(d4);
        System.out.println(d4.getWochentag());
    }
}
