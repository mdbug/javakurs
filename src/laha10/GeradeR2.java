package laha10;

/**
 * Created by BO on 16.12.2016.
 */
public class GeradeR2 extends AbstrakteEbene implements Hyperebene{


    public GeradeR2 (Punkt p1, Punkt p2) {
        super(p1, new VektorRn[]{p1.getVektorRn().mult(-1).add(p2.getVektorRn())});
    }

    public GeradeR2 (VektorRn n, Punkt p) {
        super(p, new VektorRn[]{n});
    }

    @Override
    public VektorRn getNormalenvektor() {
        VektorRn richtungsvektor = getRichtungsvektoren()[0];
        VektorRn normalenvektor = new VektorRn(2);
        normalenvektor.setElement(0, richtungsvektor.getElement(1));
        normalenvektor.setElement(1, -richtungsvektor.getElement(0));
        return normalenvektor;
    }

    @Override
    public String getNormalform() {
        double[] n = getNormalenvektor().getElements();
        double np = VektorRn.scalarProd(getNormalenvektor(), getOrtsvektor().getVektorRn());
        return String.format("%.2fx %c %.2fy = %.2f", n[0], n[1] < 0 ? '-' : '+', Math.abs(n[1]), np);
    }
}
