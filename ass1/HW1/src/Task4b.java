import java.util.Scanner;

public class Task4b {

	public static void main(String[] args) {
		/*
		 * the if condition present the given mathematical expression but in some
		 * changes by using Multiplication and division!
		 */
		// ----------------- write your code BELOW this line only --------
		Scanner myScanner = new Scanner(System.in);
		int a = myScanner.nextInt();
		int b = myScanner.nextInt();
		int c = myScanner.nextInt();
		int d = myScanner.nextInt();
		int e = myScanner.nextInt();
		int f = myScanner.nextInt();
		if ((a * d * f) + (c * b * f) + (e * b * d) == (b * d * f)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		} // ----------------- write your code ABOVE this line only ---------

	}
}
