import java.util.Scanner;

public class Task2a {

	public static void main(String[] args) {
        //note:number smaller than zero the answer is 1 according to my solution!
		//we assume that the number is bigger than 0.  
		// ----------------- write your code BELOW this line only --------
		Scanner myScanner = new Scanner(System.in);
		int n = myScanner.nextInt();
		int ans = 1;
		for (int i = 1; i <= n; i++) {
			ans = ans * i;
		}
		System.out.println(ans);
		// ----------------- write your code ABOVE this line only ---------

	}
}
