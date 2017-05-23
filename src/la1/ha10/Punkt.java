package la1.ha10;

public class Punkt {
	/**
	 * Ortsvektor zum Punkt
	 */
	private VektorRn ortsvektor;
	
	/**
	 * Konstruktor eines Punktes zu einem gegenenen Ortsvektor 
	 * @param v Ortsvektor
	 */
	public Punkt (VektorRn v) {
		this.ortsvektor = v;
	}
	
	/**
	 * Konstruktor eines Punktes zu einem gegebenen Ortsvektor in FOrm eines double-Arrays
	 * @param elemente double-Array der Komponenten des Ortsvektors
	 */
	public Punkt (double [] elemente) {
		this.ortsvektor = new VektorRn(elemente);
	}
	
	/**
	 * Getter des Ortsvektors
	 * @return Ortsvektor
	 */
	public VektorRn getVektorRn () {
		return this.ortsvektor;
	}
}
