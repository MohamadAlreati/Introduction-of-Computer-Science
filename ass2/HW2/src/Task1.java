import java.util.Scanner;

public class Task1 {

	/*
	 * Task1.1
	 */
	/* Store the received numbers in 1d Array */
	public static int[] init() {
		Scanner Scanner = new Scanner(System.in);
		int n = Scanner.nextInt();
		if (n < 0)
			throw new IllegalArgumentException("The number must be larger than 0");
		int Array[] = new int[n];
		for (int i = 0; i < n; i++) {
			int x = Scanner.nextInt();
			if (x < 0)
				throw new IllegalArgumentException("wrong input!-please inter only positve number");
			Array[i] = x;
		}
		return Array;

	}

	/*
	 * Task1.2
	 */
	public static int[] histogramCreate(int[] grades) {
		Scanner Scanner = new Scanner(System.in);
		int m = Scanner.nextInt();
		if(m<0)
			throw new IllegalArgumentException("wrong input!-please inter only positve number");
		int Histogram[] = new int[m + 1];// java will assign the default value 0 to each element!
		for (int i = 0; i < grades.length; i++) {
			int v = grades[i];
			if (v < 0 | m < v)
				throw new IllegalArgumentException("The grade isn't in the range[0,m]");
			Histogram[v] = Histogram[v] + 1;
		}
		return Histogram;
	}

	/*
	 * Task1.3
	 */
	// the first loop is useless!put i choose 0 and not 1 to include the
	// single element Array in solution. 
	public static int getMostCommonGrade(int[] histogram) {
		int MaxIndex = 0; // assuming that the most Common Grade is 0!
		for (int i = 0; i < histogram.length; i++) {
			if (histogram[MaxIndex] < histogram[i])
				MaxIndex = i;
		}
		return MaxIndex;
	}

	/*
	 * Task1.4
	 */
	public static int getLeastCommonGrade(int[] histogram) {
		int MinIndex = 0;// assuming that the the first index contain the least common grade!
		for (int i = 0; i < histogram.length; i++) {
			if (histogram[MinIndex] > histogram[i])
				MinIndex = i;
		}
		return MinIndex;
	}

}
