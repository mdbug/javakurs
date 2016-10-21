package blatt00;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class MessreiheTest {

	public static void main(String[] args) {
		try {
			Messreihe messreihe = new Messreihe("Messwerte.txt");
			System.out.println("Maximalwert: " +messreihe.getMax());
			System.out.println("Minimalwert: " +messreihe.getMin());
			System.out.println("Einheitliche Werte: " +messreihe.isEinheitlich());
			System.out.println("Anzahl Werte groesser als 50: " +messreihe.zaehleGroessere(50));
			System.out.println("Index Maximalwert: " +messreihe.getMaxIndex());
			System.out.println("Wertebereich: " +Arrays.toString(messreihe.getBereich()));
			
			messreihe.speichereInfo("info.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Datei konnte nicht gefunden werden");
		} catch (ArithmeticException e) {
			System.out.println("Anzahl Messwerte war zu gross/klein");
		}
	}

}
