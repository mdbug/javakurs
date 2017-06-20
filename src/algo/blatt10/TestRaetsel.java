package algo.blatt10;

import java.util.Scanner;

public class TestRaetsel {
    public static String[] RICHTUNGEN = {"Oben", "Unten", "Links", "Rechts"};
    public static void main(String[] args) {
        Raetsel raetsel = new Raetsel("raetsel.txt");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Bitte zu suchende Vorlesung eingeben (x für Ende): ");
            String name = scanner.nextLine();
            if (name.equals("x")) {
                System.exit(0);
            }
            int[] result = raetsel.suche(name);
            if (result != null) {
                System.out.printf("Position des 1. Buchstaben: Zeile %d, Spalte %d\n", result[0], result[1]);
                String richtung = RICHTUNGEN[result[2]];
                System.out.printf("Richtung %s\n", richtung);
            } else {
                System.out.println("Nur Chuck Norris hält Vorlesungen die es nicht gibt");
            }
        }
    }
}
