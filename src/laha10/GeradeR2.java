package laha10;


/**
 * Die Klasse stellt Geraden im R^2 dar
 */
public class GeradeR2 extends AbstrakteEbene implements Hyperebene{

    /**
     * Erzeugt eine Gerade anhand der Vorgabe zweier Punkte
     * @param p1 Punkt1
     * @param p2 Punkt2
     */
    public GeradeR2 (Punkt p1, Punkt p2) {
        if (p1.getVektorRn().getElements().length != 2 || p2.getVektorRn().getElements().length != 2)
            throw new RuntimeException("Die Dimension beider Punkte muss 2 sein");

        this.p = p1;
        this.r = new VektorRn[]{p1.getVektorRn().mult(-1).add(p2.getVektorRn())};
    }

    /**
     * Erzeugt eine Gerade anhand der Vorgabe eines Punktes und eines Normalenvektors
     * @param n Normalenvektor
     * @param p Punkt
     */
    public GeradeR2 (VektorRn n, Punkt p) {
        if (p.getVektorRn().getElements().length != 2 || n.getElements().length != 2)
            throw new RuntimeException("Die Dimensionen muessen 2 sein");

        double[] richtungsvektor = new double[2];
        richtungsvektor[0] = n.getElement(1);
        richtungsvektor[1] = -n.getElement(0);
        this.p = p;
        this.r = new VektorRn[] {new VektorRn(richtungsvektor)};
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VektorRn getNormalenvektor() {
        VektorRn richtungsvektor = getRichtungsvektoren()[0];
        VektorRn normalenvektor = new VektorRn(2);
        normalenvektor.setElement(0, richtungsvektor.getElement(1));
        normalenvektor.setElement(1, -richtungsvektor.getElement(0));
        return normalenvektor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getNormalform() {
        double[] n = getNormalenvektor().getElements();
        double np = VektorRn.scalarProd(getNormalenvektor(), getOrtsvektor().getVektorRn());
        return String.format("%.2fx %c %.2fy = %.2f", n[0], n[1] < 0 ? '-' : '+', Math.abs(n[1]), np);
    }
}
