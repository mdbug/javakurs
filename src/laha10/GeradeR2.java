package laha10;

/**
 * Created by BO on 16.12.2016.
 */
public class GeradeR2 extends AbstrakteEbene implements Hyperebene{


    public GeradeR2 (Punkt p1, Punkt p2) {

        VektorRn richtungsvektor = p1.getVektorRn().mult(-1).add(p2.getVektorRn());
        super(p1, new VektorRn[]{richtungsvektor});
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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n.length; ++i) {
            sb.append(n[i] + "x_" + (i+1));
            if (i < n.length-1)
                sb.append(" + ");
        }
        sb.append(" = ");
        sb.append(VektorRn.scalarProd(getNormalenvektor(), getOrtsvektor().getVektorRn()));
        return sb.toString();
    }
}
