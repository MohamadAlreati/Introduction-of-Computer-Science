
public class Task3 {
	/*
	 * /helping functions! Testing if the given array presenting legal Matrix!(if
	 * all the rows in matrix have the same length)!
	 */
	public static boolean IsMatrix(double[][] Matrix, int n) {// n present length of each row
		for (int i = 0; i < Matrix.length; i++) {
			if (n != Matrix[i].length)
				return false;
		}
		return true;
	}

// -------------------------------------------------------------------------------------------------
	/*
	 * Task3.1
	 */
	public static double[][] matrixSum(double[][] A, double[][] B) {
		/*
		 * giving the helping fun above information from two different arrays to make
		 * sure that they have the same size!
		 */
		if (A.length != B.length | !IsMatrix(A, B[0].length) | !IsMatrix(B, A[0].length)) {
				double Zero[][] = { { 0 } };
				return Zero;
		}
		if9
		double output[][] = new double[A.length][A[0].length];
		 /* saving the output in the first Array!(reduce the space in the memory -_- */
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				output[i][j] = A[i][j] + B[i][j];
			}
		}
		return A;
	}

	/*
	 * Task3.2
	 */
	public static double[][] matrixMul(double[][] A, double[][] B) {
		/* number of A colu!=number of B rows */
		if (!IsMatrix(A, A[0].length) | !IsMatrix(B, B[0].length) | A[0].length != B.length) {
			double Zero[][] = { { 0 } };
			return Zero;
		}
		double C[][] = new double[A.length][B[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B[0].length; j++) {
				for (int k = 0; k < A[0].length; k++) {
					C[i][j] = C[i][j] + (A[i][k] * B[k][j]);/* help from w3school web site */
				}
			}
		}
		return C;
	}

	/*
	 * Task3.3
	 */
	public static double[][] matrixMulScalar(double[][] A, double alpha) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				A[i][j] = A[i][j] * alpha;
			}
		}
		return A;
	}

	/*
	 * Task3.4
	 */ /*
		 * First i switch the column size with the row size in new matrix then i added
		 * the element to the new Matrix!
		 */
	public static double[][] matrixTranspose(double[][] A) {
		if (!IsMatrix(A, A[0].length)) {
			throw new IllegalArgumentException("The given Array is not matrix!");
		}
		double[][] TranMatrix = new double[A[0].length][A.length];
		for (int i = 0; i < TranMatrix.length; i++) {
			for (int j = 0; j < TranMatrix[i].length; j++) {
				TranMatrix[i][j] = A[j][i];
			}
		}
		return TranMatrix;
	}

	/*
	 * Task3.5
	 */
	/*
	 * Assuming that all the 2d arrays is legal Matrix that have the same size of
	 * column and rows! ,i did not know what to explain in this short code...
	 */
	public static double[][] linearCalc(double[][][] matrices, double[] scalars) {
		double[][] M = new double[matrices[0].length][matrices[0][0].length];
		for (int i = 0; i < matrices.length - 1; i++) {
			M = matrixSum(M, matrixMulScalar(matrices[i], scalars[i]));// sum 
		}
		return matrixMul(M, matrixTranspose(matrices[matrices.length - 1]));//Multiply the last transposed Matrix!
	}

}
