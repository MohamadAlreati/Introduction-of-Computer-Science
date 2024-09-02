import java.util.Scanner;

public class Task3 {

	public static void main(String[] args) {
	     //The last for loop integer present the stars number in each row!
		//i added additional print(outside of the stars for) to avoid printing space at the end in each row!
		// ----------------- write your code BELOW this line only --------
		Scanner myScanner = new Scanner(System.in);
		int N = myScanner.nextInt();
		for (int n = N; n > 0; n--) {
			for (int i = 0; i < n-1 ; i++) {
				System.out.print(" ");
			}
			for (int x = N - n ; x > 0; x--) {
				System.out.print("* ");
			}
			System.out.print("*");
			System.out.println("");
		}
		// ----------------- write your code ABOVE this line only ---------
	}
}
