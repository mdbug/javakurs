package laha10;

public class AbstrakteEbene {
	/**
	 * Ein beliebiger Punkt auf der abstrakten Ebene
	 */
	Punkt p;
	/**
	 * die Richtungsvektoren auf der Ebene
	 */
	VektorRn[] r;
	
	/**
	 * Default-Konstruktor
	 */
	AbstrakteEbene () {}
	
	public AbstrakteEbene (Punkt p, VektorRn [] r) {
		int dim = p.getVektorRn().getElements().length;
		for (int i = 0; i < r.length; i++) {
			if (r[i].getElements().length != dim) {
				throw new RuntimeException("Die Dimensionen stimmen nicht �berein"); 
			}
		}
		// An dieser Stelle m�sste noch eine �berpr�fung auf Lineare Unabh�ngigkeit der Richtungsvektoren erfolgen.
		// Da der Begriff in der Vorlesung noch nicht erkl�rt wurde und die �berpr�fung halbwegs aufwendig ist, 
		// wird an dieser Stelle darauf verzichtet.
		// Stattdessen bleiben wir bei der folgenden Light-Variante der �berpr�fung
		if (r.length > dim) {
			throw new RuntimeException ("Es kann nicht mehr Basisvektoren geben als Dimensionen.");
		}
		if (r.length == 0) {
			throw new RuntimeException ("Es wird mindestens ein Basisvektor ben�tigt.");
		}
		this.p = p;
		this.r = r;
	}
	
	/**
	 * gibt einen Ortsvektor der Hyperebene zur�ck
	 * 
	 * @return Ortsvektor
	 */
	public Punkt getOrtsvektor () {
		return p;
	}
	
	/**
	 * gibt bei einer n-dimensionalen Hyperebene n - 1 linear unabh�ngige Richtungsvektoren zur�ck 
	 * 
	 * @return Array der n-1 Richtungsvektoren
	 */
	public VektorRn [] getRichtungsvektoren () {
		return r;
	}
	
	/**
	 * gibt eine Parameterdarstellung 
	 * (p_1, ..., p_n) + k_1 * (r_1, ..., r_n) + ... + k_{n-1} * (s_1, ..., s_n) 
	 * der Hyperebene auf der Konsole aus  
	 */
	public void printParametergleichung () {
		System.out.print(p.toString());
		for (int i = 0; i < r.length; i++) {
			System.out.print(" + k_" + (i+1) + " * " + r[i].toString());
		}
	}
}
