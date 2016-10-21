package blatt01z;

public class VectorRnTest {

	public static void main(String[] args) {
		VectorRn a = new VectorRn(1,2,3,4);
		VectorRn b = new VectorRn(5,6,7,8);
		VectorRn c = new VectorRn(1,2);
		double d = 3;
		
		try {
			System.out.print("a + b = ");
			System.out.println( a.add(b).toString());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.print("a + c = ");
			System.out.println( a.add(c).toString());

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}	
		try {
			System.out.print("d * a = ");
			System.out.println( a.mult(d).toString());

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}	
	}
}
