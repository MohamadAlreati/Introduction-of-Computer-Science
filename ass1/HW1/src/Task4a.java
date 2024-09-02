import java.util.Scanner;

public class Task4a {

	public static void main(String[] args) {
		// saving GCD number of the first two numbers a and b, then take the result 
		//and do GCD with c!

		// ----------------- write your code BELOW this line only --------
		Scanner myScanner = new Scanner(System.in);
		int a = myScanner.nextInt();
		int b = myScanner.nextInt();
		int c = myScanner.nextInt();
		int i = a;
		while (!((a % i == 0) && (b % i == 0))) {
			i = i - 1;
		}
		int j = b-a;
		
		while (!((i % j == 0) && (c % j == 0))) {
			j = j - 1;
		}
		System.out.println(i);
		// ----------------- write your code ABOVE this line only ---------

	}
}
