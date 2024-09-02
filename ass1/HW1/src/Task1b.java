import java.util.Scanner;

public class Task1b {

	public static void main(String[] args) {
		//each for presenting a number Ascendingly(a<b<c)
		//,the previous number decide what is the next one using for statement .
		// ----------------- write your code BELOW this line only --------
		Scanner myScanner = new Scanner(System.in);
		int n = myScanner.nextInt();
		for(int a=1;a<n;a++) {
			for(int b=a+1;b<n;b++) {
				for(int c=b+1;c<=n;c++) {
					if(a * a + b* b == c * c) {
						System.out.println(a+" "+b+" "+c);
					}
						
					
				}
				
			}
			
		}

		// ----------------- write your code ABOVE this line only ---------

	}
}
