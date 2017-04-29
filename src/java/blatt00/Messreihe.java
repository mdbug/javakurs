package java.blatt00;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Messreihe {
	private double[] daten;
	
	public Messreihe(double[] liste) {
		daten = liste.clone();
	}
	
	public Messreihe(String dateiname) throws FileNotFoundException{
		File file = new File(dateiname);
		Scanner scan = new Scanner(file);
		int i = 0;
		int size = -1;
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			double x = 0;
			try {
				x = Double.parseDouble(line);
			} catch (NumberFormatException e) {
				if (line.matches("^\\s*$") || line.startsWith("%")) { // Leerzeile oder Kommentar
					continue;
				} else {
					System.out.println(line);
					throw new IllegalArgumentException("Falsches Datenformat");
				}
			}
			if(size == -1) {
				size = (int) x;
				daten = new double[size];
			} else if(i >= size) {
				throw new ArithmeticException("Mehr als " + size + " Messwerte");
			} else {
				daten[i] = x;
				i++;
			}
		}
		if (i!= size) {
			throw new ArithmeticException("Nicht genau " + size + " Messwerte");
		}
		scan.close();
	}
	
	public double getMax() {
		double max = Double.MIN_VALUE;
		for(double x : daten) {
			max = Math.max(x, max);
		}
		return max;
	}

	public double getMin() {
		double min = Double.MAX_VALUE;
		for(double x : daten) {
			min = Math.min(x, min);
		}
		return min;
	}
	
	public boolean isEinheitlich() {
		double a = daten[0];
		for (int i = 1; i<daten.length; i++) {
			if (a != daten[i])
				return false;
		}
		return true;
	}
	
	public int zaehleGroessere(double lim) {
		int n = 0;
		for (double x : daten) {
			if(x > lim) {
				n++;
			}
		}
		return n;
	}
	
	public int getMaxIndex() {
		double max = getMax();
		for (int i=0; i < daten.length; i++) {
			if (max == daten[i]) {
				return i;
			}
		}
		return -1; //Kann nicht passieren
	}

	public double[] getBereich() {
		double[] bereich = new double[2];
		bereich[0] = getMin();
		bereich[1] = getMax();
		return bereich;
	}
	
	public int getAnzahl() {
		return daten.length;
	}
	
	public double getMittelwert() {
		double sum = 0;
		for (double x : daten) {
			sum +=x;
		}
		return sum/getAnzahl();
	}
	
	public void speichereInfo(String dateiname) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(dateiname);
		pw.printf(Locale.GERMAN, "Dateiname: %s\n", dateiname);
		pw.printf(Locale.GERMAN, "Anzahl der Daten: %d\n", getAnzahl());
		pw.printf(Locale.GERMAN, "Mittelwert: %f\n", getMittelwert());
		pw.printf(Locale.GERMAN, "Datenbereich: %f - %f\n", getMin(), getMax());
		for (int i=0; i < daten.length; i++) {
			pw.printf(Locale.GERMAN, "%f", daten[i]);
			if (i<daten.length-1) {
				pw.print("\n");
			}
		}
		pw.close();
	}
}
