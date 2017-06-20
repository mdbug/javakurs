package algo.blatt10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Raetsel {
    public static final int OBEN = 0;
    public static final int UNTEN = 1;
    public static final int LINKS = 2;
    public static final int RECHTS = 3;

    private ArrayList<ArrayList<Character>> feld = new ArrayList<>();

    public Raetsel(String dateiname) {
        File file = new File(dateiname);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                ArrayList<Character> row = new ArrayList<>();
                String line = scanner.nextLine();
                String[] cc = line.split(" ");
                for (String c : cc) {
                    row.add(c.charAt(0));
                }
                feld.add(row);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int[] suche(String name) {
        name = name.toUpperCase();
        for (int i = 0; i < feld.size(); ++i) {
            for (int j = 0; j < feld.get(i).size(); ++j) {
                if (feld.get(i).get(j) == name.charAt(0)) {
                    if (search(name, i, j, 0, -1)) {
                        return new int[] {i + 1, j + 1, LINKS};
                    }
                    if (search(name, i, j, 0, 1)) {
                        return new int[] {i + 1, j + 1, RECHTS};
                    }
                    if (search(name, i, j, -1, 0)) {
                        return new int[] {i + 1, j + 1, OBEN};
                    }
                    if (search(name, i, j, 1, 0)) {
                        return new int[] {i + 1, j + 1, UNTEN};
                    }
                }
            }
        }
        return null;
    }

    public boolean search(String name, int i, int j, int di, int dj) {
        int ie = i + (name.length() - 1) * di;
        int je = j + (name.length() - 1) * dj;
        if (ie < 0 || ie > feld.size() - 1 || je < 0 || je > feld.size() - 1) {
            return false;
        }
        for (int k = 0; k < name.length(); ++k, i += di, j += dj) {
            if (feld.get(i).get(j) != name.charAt(k)) {
                return false;
            }
        }
        return true;
    }
}
