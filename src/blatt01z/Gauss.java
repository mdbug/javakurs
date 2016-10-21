package blatt01z;

import java.util.Arrays;

public class Gauss {

	public static double[] gauss(double[][] A, double[] b) {
		double[][] mat = new double[A.length][A[0].length+1];
		for (int i=0; i<A.length; i++) {
			System.arraycopy(A[i], 0, mat[i], 0, A[i].length);
			mat[i][mat[i].length-1] = b[i];
		}
		
		for (int i=0; i<mat.length; i++) {
			//Suche ab Zeile i das groesste Element in Spalte i
			int max = 0;
			for (int j=i; j<mat.length; j++) {
				if (mat[j][i] > mat[max][i]) {
					max = i;
				}
			}
			tauscheZeilen(mat, i, max);
			for (int j=i+1; j<mat.length; j++) {
				if (mat[i][i] == 0)
					throw new ArithmeticException();
				double faktor = mat[j][i]/mat[i][i];
				for (int k = 0; k<mat[i].length; k++) {
					mat[j][k] -= (mat[i][k] * faktor);
				}
			}
		}
		System.out.println(Arrays.deepToString(mat));
		double[] result = new double[mat.length];
		for (int i = mat.length-1; i>=0; i--) {
			double sum = mat[i][mat[i].length-1];
			
			for (int j=i+1; j<mat[i].length-1; j++) {
				sum -= mat[i][j]*result[j];
			}
			result[i] = sum / mat[i][i];
		}
		return result;
		
	}
	
	public static void tauscheZeilen(double[][] A, int i1, int i2) {
		double[] tmp = A[i1].clone();
		A[i1] = A[i2];
		A[i2] = tmp;
	}
	
	public static void main(String[] args) {
		double[][] A = {
				{4, 1},
				{2, 1},
				{0, 0}};
		double[] b = {10, 6, 5};
		double[] result = gauss(A, b);
		System.out.println(Arrays.toString(result));
	}
}
