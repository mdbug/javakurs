package laha10;

public class GeradeR2Test {
	public static void main(String[] args){
		Punkt p1 = new Punkt(new double[] {1.,3.});
		Punkt p2 = new Punkt(new double[] {2.,5.});
		VektorRn v1 = new VektorRn(new double[] {1.,2.});
		
		Hyperebene gerade1 = new GeradeR2(p1, p2);
		Hyperebene gerade2 = new GeradeR2(v1, p1);
		
		System.out.println("Normalenvektor Gerade1: "+gerade1.getNormalenvektor());
		System.out.println("Normalenform Gerade1: "+gerade1.getNormalform());
		System.out.println();
		System.out.println("Normalenvektor Gerade2: "+gerade2.getNormalenvektor());
		System.out.println("Normalenform Gerade2: "+gerade2.getNormalform());
		
	}
}
