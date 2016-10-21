package blatt01;

public class Gesamtstand {
	private String team;
	private int punkte;
	private int tore;
	private int gegentore;
	
	public Gesamtstand(String team, int punkte, int tore, int gegentore) {
		this.team = team;
		this.punkte = punkte;
		this.tore = tore;
		this.gegentore = gegentore;
	}
	
	public String toString() {
		return String.format("%-25s %d:%d  %2d", team, tore, gegentore, punkte);
	}
}
