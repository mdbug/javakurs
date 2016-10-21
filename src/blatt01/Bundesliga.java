package blatt01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bundesliga {
	final int NUMBER_OF_TEAMS = 18;
	private ArrayList<String> teams = new ArrayList<>(NUMBER_OF_TEAMS);
	private String[][] results = new String[NUMBER_OF_TEAMS][NUMBER_OF_TEAMS];

	public Bundesliga(String file) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(file), "UTF-8");
		for(int i=0; i<NUMBER_OF_TEAMS && scan.hasNextLine(); i++) {
			String s = scan.nextLine();
			s.trim();
			String team = s.split("(\\d:\\d|---)", 2)[0];
			teams.add(team.trim());
			String r = s.substring(team.length()).trim();
			results[i] = r.split("\\s+");
		}
		//System.out.println(teams);
		scan.close();
	}
	
	public String[] getTeams() {
		return teams.toArray(new String[NUMBER_OF_TEAMS]);
	}
	
	public String getResult(String heim, String gast) {
		int h = teams.indexOf(heim);
		int g = teams.indexOf(gast);
		if (h == -1 || g == -1)
			throw new IllegalArgumentException("Team existiert nicht");
		return results[h][g];
	}
	
	public Gesamtstand getGesamtstand(String mannschaft) {
		int t = teams.indexOf(mannschaft);
		if (t == -1 ) {
			IllegalArgumentException up = new IllegalArgumentException("Team existiert nicht");
			throw up; //h3h3
		}
		int toreSumme = 0;
		int gegentoreSumme = 0;
		int punkteSumme = 0;
		//Heimspiele
		for (int i = 0; i < results[t].length; i++) {
			if (i == t)
				continue;
			String[] ergebnis = results[t][i].split(":");
			int tore = Integer.parseInt(ergebnis[0]);
			int gegentore = Integer.parseInt(ergebnis[1]);
			int punkte = 0;
			if (tore > gegentore) {
				punkte = 3;
			} else if (tore == gegentore) {
				punkte = 1;
			}
			toreSumme += tore;
			gegentoreSumme += gegentore;
			punkteSumme += punkte;
		}
		//Auswaertsspiele
		for (int i = 0; i < results.length; i++) {
			if (i == t)
				continue;
			String[] ergebnis = results[i][t].split(":");
			int gegentore = Integer.parseInt(ergebnis[0]);
			int tore = Integer.parseInt(ergebnis[1]);
			int punkte = 0;
			if (tore > gegentore) {
				punkte = 3;
			} else if (tore == gegentore) {
				punkte = 1;
			}
			toreSumme += tore;
			gegentoreSumme += gegentore;
			punkteSumme += punkte;
		}
		return new Gesamtstand(mannschaft, punkteSumme, toreSumme, gegentoreSumme);
	}
	
	
	public static void main(String[] args) {
		try {
			Bundesliga bundesliga = new Bundesliga("bundesliga1314.txt");
			System.out.println(bundesliga.getResult("FC Bayern München", "Bayer 04 Leverkusen"));
			System.out.println(bundesliga.getResult("VfB Stuttgart", "Werder Bremen"));
			String[] t = bundesliga.getTeams();
			for(String tt : t ) {
				System.out.println(bundesliga.getGesamtstand(tt));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
