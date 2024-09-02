// You may not change or erase any of the lines and comments 
// in this file. You may only add lines in the designated 
// area.

import java.util.Scanner;

public class Task5 {

	public static void main(String[] args) {
		//i Ordered of the first two numbers according to the given example then i put
		// the last number by comparing it with the first two numbers!
		// ----------------- "A": write your code BELOW this line only --------
		Scanner myScanner = new Scanner(System.in);
		int a = myScanner.nextInt();
		int b = myScanner.nextInt();
		int c = myScanner.nextInt();
		if (a > b) {
			int temp = b;
			b = a;
			a = temp;
		}
		if (c < a) {
			System.out.println(c);
			System.out.println(a);
			System.out.println(b);
		} else if (a < c & c < b) {
			System.out.println(a);
			System.out.println(c);
			System.out.println(b);
		} else {
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
		} // ----------------- "B" write your code ABOVE this line only ---------

	} // end of main
} // end of class Task5
