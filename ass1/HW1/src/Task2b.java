import java.util.Scanner;

public class Task2b {

	public static void main(String[] args) {
		//test if the number even or not helps to decide the appropriate expression!
		// ----------------- write your code BELOW this line only --------
		Scanner myScanner = new Scanner(System.in);
		int n = myScanner.nextInt();
		int k = myScanner.nextInt();
		if ((0 < n & 0 < k)) {
			if (n % 2 == 0)
				System.out.println(n+" " + "="+" " + k+" " + "*"+" "+ (n/k));
			else
				System.out.println(n +" " +"=" +" " + k +" "+ "*"+" " + (n / k) +" "+ "+" +" "+ (n % k));
		} else {
			System.out.println("Error!!!");
		}
		// ----------------- write your code ABOVE this line only ---------

	}
}
