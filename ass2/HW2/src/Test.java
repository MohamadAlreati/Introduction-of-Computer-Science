
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class Test {

	/*
	 * This is the final version of the test updated with a couple more example
	 * mostly for 3.5 also this test has been updated to be able to run task 1.1 and
	 * 1.2 without any helper functions enjoy
	 *
	 * if you need any assistance you know who to call :)
	 */

	public static void main(String[] args) {
		 //runAllTests();
		// testPartA();
		// testPartB();
		// testPartC();
		 testPartD();
		
	    //testQ1E1();
		 //testQ1E2();
		// testQ1E3();
		// testQ1E4();
		 
		// testQ2E1();
		// testQ2E2();
		//testQ2E3();
		 
		// testQ3E1();
		 //testQ3E2();
		 //testQ3E3();
		// testQ3E4();
		// testQ3E5();
		 
		// testQ4E1();
		// testQ4E2();
		// testQ4E3();
	}

	public static void runAllTests() {
		testPartA();
		testPartB();
		testPartC();
		testPartD();
	}

	public static void testPartA() {
		System.out.println("Testing 1.1:");
		testQ1E1();
		System.out.println("Testing 1.2:");
		testQ1E2();
		System.out.println("Testing 1.3:");
		testQ1E3();
		System.out.println("Testing 1.4:");
		testQ1E4();
	}

	public static void testPartB() {
		System.out.println("Testing 2.1:");
		testQ2E1();
		System.out.println("Testing 2.2:");
		testQ2E2();
		System.out.println("Testing 2.3:");
		testQ2E3();
	}

	public static void testPartC() {
		System.out.println("Testing 3.1:");
		testQ3E1();
		System.out.println("Testing 3.2:");
		testQ3E2();
		System.out.println("Testing 3.3:");
		testQ3E3();
		System.out.println("Testing 3.4:");
		testQ3E4();
		System.out.println("Testing 3.5:");
		testQ3E5();
	}

	public static void testPartD() {
		System.out.println("Testing 4.1:");
		testQ4E1();
		System.out.println("Testing 4.2:");
		testQ4E2();
		System.out.println("Testing 4.3:");
		testQ4E3();
	}

	private static PrintStream tempOut;
	private static InputStream tempIn;
	static ByteArrayOutputStream byteArrOut = new ByteArrayOutputStream();
	static PrintStream ps = new PrintStream(byteArrOut);

	private static void saveDefaultIO() {
		tempOut = System.out;
		tempIn = System.in;
	}

	private static void restoreDefaultIO() {
		System.setOut(tempOut);
		System.setIn(tempIn);
	}

	private static void setStreams(String input) {

		System.setOut(ps);

		ByteArrayInputStream byteArrIn = new ByteArrayInputStream(input.getBytes());

		System.setIn(byteArrIn);
	}

	public static void testQ1E1() {
		String[] wrongInputs = { "-10 1 1 1 1 1 1 1 1 1 1", "3 2 -1 5" };
		String[] inputs = { "5 1 10 4 0 100", "0", "2 1000 4", "4 1 3 5 7" };
		int[][] expectedOutputs = { { 1, 10, 4, 0, 100 }, {}, { 1000, 4 }, { 1, 3, 5, 7 } };

		boolean passed = true;

		for (String wrongInput : wrongInputs) {
			saveDefaultIO();
			setStreams(wrongInput);
			try {
				int[] ans = Task1.init();
				restoreDefaultIO();
				System.out.println("Failed on input: [" + wrongInput + "]");
				System.out.println("Expected: java.lang.IllegalArgumentException but got " + Arrays.toString(ans));
			} catch (Exception e) {
				restoreDefaultIO();
				if (!e.getClass().getCanonicalName().equals("java.lang.IllegalArgumentException")) {
					passed = false;
					System.out.println("Failed on input: [" + wrongInput + "]");
					System.out.println(
							"Expected: java.lang.IllegalArgumentException but got " + e.getClass().getCanonicalName());
				}
			}
		}

		for (int i = 0; i < inputs.length; i++) {
			saveDefaultIO();
			setStreams(inputs[i]);
			try {
				int[] ans = Task1.init();
				restoreDefaultIO();
				if (!Arrays.equals(ans, expectedOutputs[i])) {
					System.out.println("Failed on input: [" + inputs[i] + "]");
					System.out.println(
							"Expected output: " + Arrays.toString(expectedOutputs[i]) + " but got [" + inputs[i] + "]");
				}
			} catch (Exception e) {
				restoreDefaultIO();
				passed = false;
				System.out.println("Failed on input: [" + inputs[i] + "]");
				System.out.println("Expected output: " + Arrays.toString(expectedOutputs[i]) + " but got "
						+ e.getClass().getCanonicalName());
			}

			restoreDefaultIO();
		}

		if (passed) {
			System.out.println("Passed All Tests");
		}
	}

	public static void testQ1E2() {

		int[][] wrongInputs1 = { { 26, 6, 2000 }, { 26, 6, 2000 }, { 6, 2000 } };
		String[] wrongInputs2 = { "-5", "-1", "7" };
		int[][] inputs1 = { { 0, 1, 1, 1, 2, 1, 2 }, { 1, 2, 3, 3, 4, 4, 4, 5, 5, 5, 5 },
				{ 8, 8, 6, 9, 5, 7, 8, 10, 7, 5, 9 } };
		int[] inputs2 = { 3, 5, 10 };
		int[][] expectedOutputs = { { 1, 4, 2, 0 }, { 0, 1, 1, 2, 3, 4 }, { 0, 0, 0, 0, 0, 2, 1, 2, 3, 2, 1 } };

		boolean passed = true;
		for (int i = 0; i < wrongInputs2.length; i++) {
			try {
				saveDefaultIO();
				setStreams(wrongInputs2[i]);
				int[] ans = Task1.histogramCreate(wrongInputs1[i]);
				restoreDefaultIO();
				System.out.println(
						"Failed on input: " + Arrays.toString(wrongInputs1[i]) + " and m is: " + wrongInputs2[i]);
				System.out.println("Expected: java.lang.IllegalArgumentException but got " + Arrays.toString(ans));
			} catch (Exception e) {
				restoreDefaultIO();
				if (!e.getClass().getCanonicalName().equals("java.lang.IllegalArgumentException")) {
					passed = false;
					System.out.println(
							"Failed on input: " + Arrays.toString(wrongInputs1[i]) + " and m is: " + wrongInputs2[i]);
					System.out.println(
							"Expected: java.lang.IllegalArgumentException but got " + e.getClass().getCanonicalName());
				}
			}
		}

		for (int i = 0; i < inputs1.length; i++) {
			saveDefaultIO();
			setStreams(inputs2[i] + "");
			int[] ans = Task1.histogramCreate(inputs1[i]);
			restoreDefaultIO();
			if (!Arrays.equals(ans, expectedOutputs[i])) {
				passed = false;
				System.out.println("Failed on input: " + Arrays.toString(inputs1[i]) + " and m is: " + inputs2[i]);
				System.out.println(
						"Expected output: " + Arrays.toString(expectedOutputs[i]) + " but got " + Arrays.toString(ans));
			}
		}

		if (passed)
			System.out.println("Passed All Tests");
	}

	public static void testQ1E3() {
		int[] histogram1 = { 3, 6, 2, 9, 3, 7, 9, 8, 5, 1 };
		int[] histogram2 = { 1, 1, 1, 1, 1 };
		int[] histogram3 = { 1, 2, 3, 4, 5 };
		int[] histogram4 = { 5, 4, 3, 2, 1 };
		int[] histogram5 = { 1, 4, 2, 0 };
		int[] histogram6 = { 1, 5, 5, 5, 2, 3, 3, 10, 10, 10, 3, 3, 3 };
		int[][] inputs = { histogram1, histogram2, histogram3, histogram4, histogram5, histogram6,
				{ 0, 0, 0, 0, 0, 2, 1, 2, 3, 2, 1 } };
		int[] expectedOutputs = { 3, 0, 4, 0, 1, 7, 8 };
		boolean passed = true;
		int temp;
		for (int i = 0; i < inputs.length; i++) {
			temp = Task1.getMostCommonGrade(inputs[i]);
			if (temp != expectedOutputs[i]) {
				passed = false;
				System.out.println("Failed on input: " + Arrays.toString(inputs[i]) + " in Q1E3");
				System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + temp);
			}
		}
		if (passed) {
			System.out.println("Passed all tests");
		}
	}

	public static void testQ1E4() {
		int[] histogram1 = { 3, 6, 2, 9, 3, 7, 9, 8, 5, 1 };
		int[] histogram2 = { 1, 1, 1, 1, 1 };
		int[] histogram3 = { 1, 2, 3, 4, 5 };
		int[] histogram4 = { 5, 4, 3, 2, 1 };
		int[] histogram5 = { 1, 4, 2, 0 };
		int[] histogram6 = { 100, 5, 5, 5, 9, 3, 3, 10, 10, 10, 3, 3, 3 };
		int[][] inputs = { histogram1, histogram2, histogram3, histogram4, histogram5, histogram6,
				{ 3, 4, 4, 5, 5, 10, 13, 12, 7, 0, 1 } };
		int[] expectedOutputs = { 9, 0, 0, 4, 3, 5, 9 };
		boolean passed = true;
		int temp;
		for (int i = 0; i < inputs.length; i++) {
			temp = Task1.getLeastCommonGrade(inputs[i]);
			if (temp != expectedOutputs[i]) {
				passed = false;
				System.out.println("Failed on input: " + Arrays.toString(inputs[i]) + " in Q1E3");
				System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + temp);
			}
		}
		if (passed) {
			System.out.println("Passed all tests");
		}
	}

	public static void testQ2E1() {
		int[] friends1 = { 3, 5, 8, 2, 7 };
		int[] friends2 = { 4, 6, 1, 9, 0 };
		int[] friends3 = { -1, -4, 6, 2, -8 };
		int[][] inputs = { friends1, friends2, friends3 };
		int[] inputs2 = { 5, 8, 4, 10, -1, -8, 3 };
		boolean[][] outputs = { { true, true, false, false, false, false, true },
				{ false, false, true, false, false, false, false }, { false, false, false, false, true, true, false } };
		boolean passed = true;
		boolean result;
		for (int i = 0; i < inputs.length; i++) {
			for (int j = 0; j < inputs2.length; j++) {
				result = Task2.hasFriend(inputs[i], inputs2[j]);
				passed = (result == outputs[i][j]);
				if (!passed) {
					System.out.println("Failed on input: " + Arrays.toString(inputs[i]) + " , " + inputs2[j]);
					System.out.println("Expected output: " + outputs[i][j] + " but got " + result);
				}
			}
		}

		int[][] collageInputs = { { 3, 4, 4, 5, 5, 10, 13, 12, 7, 0, 1 }, { 3, 4, 4, 5, 5, 10, 13, 12, 7, 0, 1 } };
		int[] collageInputs2 = { 13, 6 };
		boolean[] expected = { true, false };
		for (int i = 0; i < collageInputs2.length; i++) {
			result = Task2.hasFriend(collageInputs[i], collageInputs2[i]);
			passed = (result == expected[i]);
			if (!passed) {
				System.out.println("Failed on input: " + Arrays.toString(collageInputs[i]) + " , " + collageInputs2[i]);
				System.out.println("Expected output: " + expected[i] + " but got " + result);
			}
		}

		if (passed)
			System.out.println("Passed All Tests");

	}

	public static void testQ2E2() {

		int[][][] inputs = { null, { { 1, 2 }, { 0 }, null, { 3 } }, { { 2 }, { 3 }, { 0 } },
				{ { 1, 2 }, { 0, 3 }, { 0 }, { 1 }, null }, { { 1, 2 }, { 0, 3 }, { 0 } },
				{ { 1, 2 }, { 0, -1 }, { 0 } }, { { 1, 2 }, { 0, 3 }, { 0 }, { 1 }, {} },
				{ { 1, 2 }, { 3 }, { 0 }, { 1 } }, { {}, {}, {} }, { { 2 }, { 1 }, { 0 } },
				{ { 2, 1 }, { 0, 3 }, { 0 }, { 1 } }, { { 2, 1 }, { 0, 3 }, { 0, 2 }, { 1 } } };
		boolean[] outputs = { false, false, false, false, false, false, true, false, true, false, true, false };
		Boolean result;
		boolean passed = true;
		for (int i = 0; i < inputs.length; i++) {
			try {
				result = Task2.isLegalFriendsList(inputs[i]);
				if (!result.equals(outputs[i])) {
					passed = false;
					System.out.println("Failed on input: " + Arrays.deepToString(inputs[i]) + " in Q2E2a");
					System.out.println("Expected output: " + outputs[i] + " But output was: " + result);
				}

			} catch (Exception e) {
				passed = false;
				System.out.println("Failed on input: " + Arrays.deepToString(inputs[i]) + " in Q2E2a");
				System.out.println(
						"Expected output: " + outputs[i] + " But output was: " + e.getClass().getCanonicalName());
			}
		}

		if (passed)
			System.out.println("Passed All Tests");
	}

	public static void testQ2E3() {
		boolean[][][] inputs = { null// false
				, { { false, true }, null }// false
				, { { false, true, false }, { false, false, false }, null, { true, false, true } }// false
				, { { false, true, true }, { true, false } },
				{ { false, true, true }, { true, false, true }, { true, true } }// false
				, { { false, true, true }, { true, false, true }, { true, true, true } }// false
				, { { false, true, true }, { true, false, true }, { false, true, false } }// false
				, { { false, true, false }, { true, false, true }, { false, true, false } }// true
				, { { false, true, true }, { true, false, true }, { true, true, false } },
				{ { false, true, true }, { true, false, false }, { true, false, false } },
				{ { false, true, true }, { true, false, false }, { true, true, false } } };// true

		boolean[] expectedOutputs = { false, false, false, false, false, false, false, true, true, true, false };

		boolean output;
		boolean passed = true;
		for (int i = 0; i < inputs.length; i++) {
			output = Task2.isLegalFriendsMatrix(inputs[i]);
			if (output != expectedOutputs[i]) {
				passed = false;
				System.out.println("Failed on input: " + Arrays.deepToString(inputs[i]));
				System.out.println("Expected: " + expectedOutputs[i] + " but got: " + output);
			}
		}

		if (passed)
			System.out.println("Passed All Tests");

	}

	public static void testQ3E1() {
		double[][] ZERO = { { 0 } };

		double[][][] wrongInputs = { null, { { 0, 0 }, { 0, 0 } }, { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } },
				{ { 1, 2, 3 }, { 1, 2, 3 }, null }, { { 1, 2 }, { 1, 2 }, { 1, 2, 3 } }, { { 1, 2, 3 } } };

		double[][][] wrongInputsCopy = { null, { { 0, 0 }, { 0, 0 } }, { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } },
				{ { 1, 2, 3 }, { 1, 2, 3 }, null }, { { 1, 2 }, { 1, 2 }, { 1, 2, 3 } }, { { 1, 2, 3 } } };

		double[][][] inputs1 = { { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } },
				{ { -1, -2, -3 }, { -4, -5, -6 }, { -7, -8, -9 } }, { { 1.5, 2.5 }, { 3.9, 0.2 } },
				{ { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, { { 1, 2, 3 }, { 4, 5, 6 } }, { { 0 } },
				{ { 2, 6 }, { 0, 6 }, { 0, 2000 } }, { { 2, 2, 1 }, { 3, 1, 1 } }, { { 2, 2, 1 }, { 3, 1, 1 } } };
		double[][][] inputs2 = { { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } },
				{ { -9, -8, -7 }, { -6, -5, -4 }, { -3, -2, -1 } }, { { 2.5, 1.5 }, { 0.1, 5.3 } },
				{ { -1, -2, -3 }, { -4, -5, -6 }, { -7, -8, -9 } }, { { 9, 8, 7 }, { 6, 5, 4 } },
				{ { 2, 6 }, { 0, 6 }, { 0, 2000 } }, { { 0 } }, { { -1, 4, 3 }, { 2, 0, 1 } },
				{ { 2, 4 }, { 0, 1 }, { 3, 3 } } };

		double[][][] inputs1Copy = Arrays.copyOf(inputs1, inputs1.length);// {{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, {{-1,
																			// -2, -3}, {-4, -5, -6}, {-7, -8, -9}},
																			// {{1.5, 2.5}, {3.9, 0.2}}, {{1, 2, 3}, {4,
																			// 5, 6}, {7, 8, 9}}, {{1, 2, 3}, {4, 5,
																			// 6}}, {{0}}, {{2, 6}, {0, 6}, {0, 2000}}};
		double[][][] inputs2Copy = Arrays.copyOf(inputs2, inputs2.length);// {{{9, 8, 7}, {6, 5, 4}, {3, 2, 1}}, {{-9,
																			// -8, -7}, {-6, -5, -4}, {-3, -2, -1}},
																			// {{2.5, 1.5}, {0.1, 5.3}}, {{-1, -2, -3},
																			// {-4, -5, -6}, {-7, -8, -9}}, {{9, 8, 7},
																			// {6, 5, 4}}, {{2, 6}, {0, 6}, {0, 2000}},
																			// {{0}}};

		double[][][] expectedOutputs = { { { 10, 10, 10 }, { 10, 10, 10 }, { 10, 10, 10 } },
				{ { -10, -10, -10 }, { -10, -10, -10 }, { -10, -10, -10 } }, { { 4.0, 4.0 }, { 4.0, 5.5 } }, ZERO,
				{ { 10, 10, 10 }, { 10, 10, 10 } }, { { 2, 6 }, { 0, 6 }, { 0, 2000 } },
				{ { 2, 6 }, { 0, 6 }, { 0, 2000 } }, { { 1, 6, 4 }, { 5, 1, 2 } }, ZERO };

		double[][] dummyMat = { { 1, 2, 3, 4 } };
		double[][] output;

		boolean passed = true;
		for (double[][] wrongInput : wrongInputs) {
			try {
				output = Task3.matrixSum(wrongInput, dummyMat);
				if (!Arrays.deepEquals(output, ZERO)) {
					passed = false;
					System.out.println("Failed on input: " + Arrays.deepToString(wrongInput));
					System.out.println(
							"Expected: " + Arrays.deepToString(ZERO) + " but got: " + Arrays.deepToString(output));
				}
			} catch (Exception e) {
				passed = false;
				System.out.println("Failed on input: " + Arrays.deepToString(wrongInput));
				System.out.println(
						"Expected: " + Arrays.deepToString(ZERO) + " but got: " + e.getClass().getCanonicalName());
			}
		}

		for (int i = 0; i < wrongInputs.length; i++) {
			if (!Arrays.deepEquals(wrongInputs[i], wrongInputsCopy[i])) {
				passed = false;
				System.out.println("input: " + Arrays.deepToString(wrongInputsCopy[i]) + " was changed to: "
						+ Arrays.deepToString(wrongInputs[i]));
			}
		}

		for (int i = 0; i < inputs1.length; i++) {
			try {
				output = Task3.matrixSum(inputs1[i], inputs2[i]);
				if (!Arrays.deepEquals(output, expectedOutputs[i])) {
					passed = false;
					System.out.println("Failed on input: MatA = " + Arrays.deepToString(inputs1[i]) + " MatB = "
							+ Arrays.deepToString(inputs2[i]));
					System.out.println("Expected: " + Arrays.deepToString(expectedOutputs[i]) + " but got: "
							+ Arrays.deepToString(output));
				}
			} catch (Exception e) {
				passed = false;
				System.out.println("Failed on input: MatA = " + Arrays.deepToString(inputs1[i]) + " MatB = "
						+ Arrays.deepToString(inputs2[i]));
				System.out.println(
						"Expected: " + Arrays.deepToString(ZERO) + " but got: " + e.getClass().getCanonicalName());
			}
		}

		for (int i = 0; i < inputs1.length; i++) {
			if (!Arrays.deepEquals(inputs1[i], inputs1Copy[i])) {
				passed = false;
				System.out.println("input: " + Arrays.deepToString(inputs1Copy[i]) + " was changed to: "
						+ Arrays.deepToString(inputs1[i]));
			}
		}

		for (int i = 0; i < inputs2.length; i++) {
			if (!Arrays.deepEquals(inputs2[i], inputs2Copy[i])) {
				passed = false;
				System.out.println("input: " + Arrays.deepToString(inputs2Copy[i]) + " was changed to: "
						+ Arrays.deepToString(inputs2[i]));
			}
		}

		if (passed) {
			System.out.println("Passed All Tests");
		}

	}

	public static void testQ3E2() {
		double[][] ZERO = { { 0 } };

		double[][][] wrongInputs = { null, { { 0, 0 }, { 0, 0 } }, { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } },
				{ { 1, 2, 3 }, { 1, 2, 3 }, null }, { { 1, 2 }, { 1, 2 }, { 1, 2, 3 } }, { { 1, 2, 3 } } };

		double[][][] wrongInputsCopy = { null, { { 0, 0 }, { 0, 0 } }, { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } },
				{ { 1, 2, 3 }, { 1, 2, 3 }, null }, { { 1, 2 }, { 1, 2 }, { 1, 2, 3 } }, { { 1, 2, 3 } } };

		double[][] dummyMat = { { 1, 2, 3, 4 } };
		double[][] output;

		boolean passed = true;
		for (double[][] wrongInput : wrongInputs) {
			try {
				output = Task3.matrixSum(wrongInput, dummyMat);
				if (!Arrays.deepEquals(output, ZERO)) {
					passed = false;
					System.out.println("Failed on input: " + Arrays.deepToString(wrongInput));
					System.out.println(
							"Expected: " + Arrays.deepToString(ZERO) + " but got: " + Arrays.deepToString(output));
				}
			} catch (Exception e) {
				passed = false;
				System.out.println("Failed on input: " + Arrays.deepToString(wrongInput));
				System.out.println(
						"Expected: " + Arrays.deepToString(ZERO) + " but got: " + e.getClass().getCanonicalName());
			}
		}

		for (int i = 0; i < wrongInputs.length; i++) {
			if (!Arrays.deepEquals(wrongInputs[i], wrongInputsCopy[i])) {
				passed = false;
				System.out.println("input: " + Arrays.deepToString(wrongInputsCopy[i]) + " was changed to: "
						+ Arrays.deepToString(wrongInputs[i]));
			}
		}

		double[][][] inputs1 = { { { 0 } }, { { 1, 2 }, { 3, 4 } }, { { 1, 2 }, { 3, 4 } },
				{ { 2, 6, 4 }, { 1, 9, 7 } }, { { 26, 0, 6 }, { 0, 0, 0 }, { 0, 0, 2000 } }, { { 1, 0 }, { 0, 0 } },
				{ { 1, 0, 2 }, { 2, 2, 3 } }, { { 1, 0, 2 }, { 2, 2, 3 } } };
		double[][][] inputs2 = { { { 1, 0 }, { 0, 1 } }, { { 1, 0 }, { 0, 1 } }, { { 5, 6 }, { 7, 8 } },
				{ { 3, 2 }, { 4, 10 }, { 11, 8 } }, { { 0 } }, { { 0, 0 }, { 0, 1 } }, { { 2, 4 }, { 0, 1 }, { 3, 3 } },
				{ { 2, 0, 1 }, { 3, 2, 5 } } };

		double[][][] inputs1Copy = { { { 0 } }, { { 1, 2 }, { 3, 4 } }, { { 1, 2 }, { 3, 4 } },
				{ { 2, 6, 4 }, { 1, 9, 7 } }, { { 26, 0, 6 }, { 0, 0, 0 }, { 0, 0, 2000 } }, { { 1, 0 }, { 0, 0 } },
				{ { 1, 0, 2 }, { 2, 2, 3 } }, { { 1, 0, 2 }, { 2, 2, 3 } } };
		double[][][] inputs2Copy = { { { 1, 0 }, { 0, 1 } }, { { 1, 0 }, { 0, 1 } }, { { 5, 6 }, { 7, 8 } },
				{ { 3, 2 }, { 4, 10 }, { 11, 8 } }, { { 0 } }, { { 0, 0 }, { 0, 1 } }, { { 2, 4 }, { 0, 1 }, { 3, 3 } },
				{ { 2, 0, 1 }, { 3, 2, 5 } } };

		double[][][] expectedOutputs = { ZERO, { { 1, 2 }, { 3, 4 } }, { { 19, 22 }, { 43, 50 } },
				{ { 74, 96 }, { 116, 148 } }, ZERO, ZERO, { { 8, 10 }, { 13, 19 } }, ZERO };

		for (int i = 0; i < inputs1.length; i++) {
			try {
				output = Task3.matrixMul(inputs1[i], inputs2[i]);
				if (!Arrays.deepEquals(output, expectedOutputs[i])) {
					passed = false;
					System.out.println("Failed on input: MatA = " + Arrays.deepToString(inputs1[i]) + " MatB = "
							+ Arrays.deepToString(inputs2[i]));
					System.out.println("Expected: " + Arrays.deepToString(expectedOutputs[i]) + " but got: "
							+ Arrays.deepToString(output));
				}
			} catch (Exception e) {
				passed = false;
				System.out.println("Failed on input: MatA = " + Arrays.deepToString(inputs1[i]) + " MatB = "
						+ Arrays.deepToString(inputs2[i]));
				System.out.println(
						"Expected: " + Arrays.deepToString(ZERO) + " but got: " + e.getClass().getCanonicalName());
			}

		}

		for (int i = 0; i < inputs1.length; i++) {
			if (!Arrays.deepEquals(inputs1[i], inputs1Copy[i])) {
				passed = false;
				System.out.println("input: " + Arrays.deepToString(inputs1Copy[i]) + " was changed to: "
						+ Arrays.deepToString(inputs1[i]));
			}
		}

		for (int i = 0; i < inputs2.length; i++) {
			if (!Arrays.deepEquals(inputs2[i], inputs2Copy[i])) {
				passed = false;
				System.out.println("input: " + Arrays.deepToString(inputs2Copy[i]) + " was changed to: "
						+ Arrays.deepToString(inputs2[i]));
			}
		}

		if (passed) {
			System.out.println("Passed All Tests");
		}

	}

	public static void testQ3E3() {
		double[][] ZERO = { { 0 } };

		double[][][] wrongInputs = { null, { { 0, 0 }, { 0, 0 } }, { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } },
				{ { 1, 2, 3 }, { 1, 2, 3 }, null }, { { 1, 2 }, { 1, 2 }, { 1, 2, 3 } } };

		double[][][] wrongInputsCopy = { null, { { 0, 0 }, { 0, 0 } }, { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } },
				{ { 1, 2, 3 }, { 1, 2, 3 }, null }, { { 1, 2 }, { 1, 2 }, { 1, 2, 3 } } };

		double[][] output;

		boolean passed = true;
		for (double[][] wrongInput : wrongInputs) {
			try {
				output = Task3.matrixMulScalar(wrongInput, 1);
				if (!Arrays.deepEquals(output, ZERO)) {
					passed = false;
					System.out.println("Failed on input: " + Arrays.deepToString(wrongInput));
					System.out.println(
							"Expected: " + Arrays.deepToString(ZERO) + " but got: " + Arrays.deepToString(output));
				}
			} catch (Exception e) {
				passed = false;
				System.out.println("Failed on input: " + Arrays.deepToString(wrongInput));
				System.out.println(
						"Expected: " + Arrays.deepToString(ZERO) + " but got: " + e.getClass().getCanonicalName());
			}
		}

		for (int i = 0; i < wrongInputs.length; i++) {
			if (!Arrays.deepEquals(wrongInputs[i], wrongInputsCopy[i])) {
				passed = false;
				System.out.println("input: " + Arrays.deepToString(wrongInputsCopy[i]) + " was changed to: "
						+ Arrays.deepToString(wrongInputs[i]));
			}
		}

		double[][][] inputs1 = { { { 0 } }, { { 1, 0 }, { 0, 1 } }, { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } },
				{ { -3.2, 1.7, 0.9, 2.5 }, { 4.6, 0.1, -1.8, -2.4 }, { 0.3, -2.2, 3.7, 1.1 } },
				{ { 2.0, -0.6, 4.1 }, { -1.8, -3.5, 2.9 }, { -0.9, 0.2, -2.7 }, { 5.4, -1.1, 1.8 } },
				{ { 6, 0, 2 }, { 2, 2, 4 } } };

		double[][][] inputs1Copy = { { { 0 } }, { { 1, 0 }, { 0, 1 } }, { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } },
				{ { -3.2, 1.7, 0.9, 2.5 }, { 4.6, 0.1, -1.8, -2.4 }, { 0.3, -2.2, 3.7, 1.1 } },
				{ { 2.0, -0.6, 4.1 }, { -1.8, -3.5, 2.9 }, { -0.9, 0.2, -2.7 }, { 5.4, -1.1, 1.8 } },
				{ { 6, 0, 2 }, { 2, 2, 4 } } };

		double[] inputs2 = { 1, 2, -1.5, 3, 0, 1.5 };

		double[][][] expectedOutputs = { ZERO, { { 2, 0 }, { 0, 2 } },
				{ { -1.5, 0, 0 }, { 0, -1.5, 0 }, { 0, 0, -1.5 } },
				{ { -9.6, 5.1, 2.7, 7.5 }, { 13.8, 0.3, -5.4, -7.2 }, { 0.9, -6.6, 11.1, 3.3 } }, ZERO,
				{ { 9, 0, 3 }, { 3, 3, 6 } } };

		for (int i = 0; i < inputs1.length; i++) {
			output = Task3.matrixMulScalar(inputs1[i], inputs2[i]);
			rounding(output);
			if (!Arrays.deepEquals(output, expectedOutputs[i])) {
				passed = false;
				System.out
						.println("Failed on input: " + Arrays.deepToString(inputs1[i]) + " and scalar: " + inputs2[i]);
				System.out.println("Expected: " + Arrays.deepToString(expectedOutputs[i]) + " but got: "
						+ Arrays.deepToString(output));
			}
		}

		for (int i = 0; i < inputs1.length; i++) {
			if (!Arrays.deepEquals(inputs1[i], inputs1Copy[i])) {
				passed = false;
				System.out.println("inputs is being changed");
			}
		}

		if (passed) {
			System.out.println("Passed All Tests");
		}
	}

	public static void testQ3E4() {

		double[][] ZERO = { { 0 } };

		double[][][] wrongInputs = { null, { { 0, 0 }, { 0, 0 } }, { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } },
				{ { 1, 2, 3 }, { 1, 2, 3 }, null }, { { 1, 2 }, { 1, 2 }, { 1, 2, 3 } } };

		double[][][] wrongInputsCopy = { null, { { 0, 0 }, { 0, 0 } }, { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } },
				{ { 1, 2, 3 }, { 1, 2, 3 }, null }, { { 1, 2 }, { 1, 2 }, { 1, 2, 3 } } };

		double[][] output;

		boolean passed = true;
		for (double[][] wrongInput : wrongInputs) {
			try {
				output = Task3.matrixTranspose(wrongInput);
				if (!Arrays.deepEquals(output, ZERO)) {
					passed = false;
					System.out.println("Failed on input: " + Arrays.deepToString(wrongInput));
					System.out.println(
							"Expected: " + Arrays.deepToString(ZERO) + " but got: " + Arrays.deepToString(output));
				}
			} catch (Exception e) {
				passed = false;
				System.out.println("Failed on input: " + Arrays.deepToString(wrongInput));
				System.out.println(
						"Expected: " + Arrays.deepToString(ZERO) + " but got: " + e.getClass().getCanonicalName());
			}
		}

		for (int i = 0; i < wrongInputs.length; i++) {
			if (!Arrays.deepEquals(wrongInputs[i], wrongInputsCopy[i])) {
				passed = false;
				System.out.println("input: " + Arrays.deepToString(wrongInputsCopy[i]) + " was changed to: "
						+ Arrays.deepToString(wrongInputs[i]));
			}
		}

		double[][][] inputs = { { { 0 } }, { { 1, 0 }, { 0, 1 } }, { { 1, 2, 3 }, { 4, 5, 6 } },
				{ { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, { { 6, 0, 2 }, { 2, 2, 4 } } };
		double[][][] inputsCopy = { { { 0 } }, { { 1, 0 }, { 0, 1 } }, { { 1, 2, 3 }, { 4, 5, 6 } },
				{ { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, { { 6, 0, 2 }, { 2, 2, 4 } } };
		double[][][] expectedOutputs = { { { 0 } }, { { 1, 0 }, { 0, 1 } }, { { 1, 4 }, { 2, 5 }, { 3, 6 } },
				{ { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } }, { { 6, 2 }, { 0, 2 }, { 2, 4 } } };

		for (int i = 0; i < inputs.length; i++) {
			output = Task3.matrixTranspose(inputs[i]);
			if (!Arrays.deepEquals(expectedOutputs[i], output)) {
				passed = false;
				System.out.println("Failed on input: " + Arrays.deepToString(inputs[i]));
				System.out.println("Expected: " + Arrays.deepToString(expectedOutputs[i]) + " but got: "
						+ Arrays.deepToString(output));
			}
		}

		for (int i = 0; i < inputs.length; i++) {
			if (!Arrays.deepEquals(inputs[i], inputsCopy[i])) {
				passed = false;
				System.out.println("inputs values are being changed");
			}
		}

		if (passed)
			System.out.println("Passed All Tests");

	}

	public static void testQ3E5() {
		double[][] ZERO = { { 0 } };

		double[][] matA = { { 1, 0, 2 }, { 2, 2, 3 } };
		double[][] matB = { { 2, 0, 4 }, { 6, 2, 2 } };
		double[][] matC = { { 0, 0, 1 }, { 2, 2, 2 } };
		double[][] matD = { { 2, 4, 0 }, { 1, 3, 3 } };
		double[][] matE = { { 2, 4 }, { 0, 1 }, { 3, 3 } };

		double[][][] wrongInput1 = null;// checking null
		double[][][] wrongInput2 = {};// checking empty array
		double[][][] wrongInput3 = { { { 26 } }, { { 6 } }, { { 2000 } } };// incorrect number of matrices
		double[][][] wrongInput4 = { { { 26 } }, null, { { 6 } }, { { 2000 } } };// null value
		double[][][] wrongInput5 = { { { 2 } }, { { 6 } }, { { 6 } }, { { 2000 } }, { { 1 } } };// incorrect number of
																								// matrices
		double[][][] wrongInput6 = { { { 1 }, { 26 } }, { { 1 }, null }, { { 1 }, { 6 } }, { { 1 }, { 2000 } } };// null
		double[][][] wrongInput7 = { { { 26 } }, {}, { { 6 } }, { { 2000 } } };// empty array
		double[][][] wrongInput8 = { { { 26, 0, 0 }, { 0, 6, 0 } }, { { 26, 0, 0 }, { 0, 6, 0 } },
				{ { 26, 0 }, { 0, 6 }, { 0, 2000 } }, { { 26, 0, 0 }, { 0, 6, 0 } } };// not the correct sizes for them
		double[][][] wrongInput9 = { { { 1, 2 }, { 1, 2 }, { 1, 2, 3 } }, { { 26, 0, 0 }, { 0, 6, 0 }, { 0, 0, 2000 } },
				{ { 26, 0, 0 }, { 0, 6, 0 }, { 0, 0, 2000 } }, { { 26, 0, 0 }, { 0, 6, 0 }, { 0, 0, 2000 } } };// incorrect
																												// matrix
																												// build
		double[][][] wrongInput10 = { { { 26, 0, 0 }, { 0, 6, 0 }, { 0, 0, 2000 } },
				{ { 1, 2 }, { 1, 2 }, { 1, 2, 3 } }, { { 26, 0, 0 }, { 0, 6, 0 }, { 0, 0, 2000 } },
				{ { 26, 0, 0 }, { 0, 6, 0 }, { 0, 0, 2000 } } };// incorrect matrix build
		double[][][] wrongInput11 = { { { 26, 0, 0 }, { 0, 6, 0 }, { 0, 0, 2000 } },
				{ { 26, 0, 0 }, { 0, 6, 0 }, { 0, 0, 2000 } }, { { 1, 2 }, { 1, 2 }, { 1, 2, 3 } },
				{ { 26, 0, 0 }, { 0, 6, 0 }, { 0, 0, 2000 } } };// incorrect matrix build
		double[][][] wrongInput12 = { { { 26, 0, 0 }, { 0, 6, 0 }, { 0, 0, 2000 } },
				{ { 26, 0, 0 }, { 0, 6, 0 }, { 0, 0, 2000 } }, { { 26, 0, 0 }, { 0, 6, 0 }, { 0, 0, 2000 } },
				{ { 1, 2 }, { 1, 2 }, { 1, 2, 3 } } };// incorrect matrix build
		double[][][] wrongInput13 = { { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } },
				{ { 26, 0, 0 }, { 0, 6, 0 }, { 0, 0, 2000 } }, { { 26, 0, 0 }, { 0, 6, 0 }, { 0, 0, 2000 } },
				{ { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } } };// wrong zero matrix
		double[][][] wrongInput14 = { { { 26, 0, 0 }, { 0, 6, 0 }, { 0, 0, 2000 } },
				{ { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, { { 26, 0, 0 }, { 0, 6, 0 }, { 0, 0, 2000 } },
				{ { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } } };// wrong zero matrix
		double[][][] wrongInput15 = { { { 26, 0, 0 }, { 0, 6, 0 }, { 0, 0, 2000 } },
				{ { 26, 0, 0 }, { 0, 6, 0 }, { 0, 0, 2000 } }, { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } },
				{ { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } } };// wrong zero matrix
		double[][][] wrongInput16 = { { { 26, 0, 0 }, { 0, 6, 0 }, { 0, 0, 2000 } },
				{ { 26, 0, 0 }, { 0, 6, 0 }, { 0, 0, 2000 } }, { { 26, 0, 0 }, { 0, 6, 0 }, { 0, 0, 2000 } },
				{ { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } } };// wrong zero matrix
		double[][][] wrongInput17 = { { { 26, 0, 0 }, { 0, 6, 0 } }, { { 26, 0, 0 }, { 0, 6, 0 } },
				{ { 26, 0, 0 }, { 0, 6, 0 } }, { { 26, 0 }, { 0, 6 }, { 0, 2000 } } };// not the correct sizes for them
		double[][][] wrongInput18 = { { { 26, 0, 0 }, { 0, 6, 0 } }, { { 26, 0 }, { 0, 6 }, { 0, 2000 } },
				{ { 26, 0, 0 }, { 0, 6, 0 } }, { { 26, 0, 0 }, { 0, 6, 0 } } };// not the correct sizes for them
		double[][][] wrongInput19 = { { { 26, 0 }, { 0, 6 }, { 0, 2000 } }, { { 26, 0, 0 }, { 0, 6, 0 } },
				{ { 26, 0, 0 }, { 0, 6, 0 } }, { { 26, 0, 0 }, { 0, 6, 0 } } };// not the correct sizes for them
		double[][][] wrongInput20 = { matA, matE, matC, matD };// cannot be summed
		double[][][] wrongInput21 = { matE, matA, matC, matD };// cannot be summed
		double[][][] wrongInput22 = { matA, matC, matE, matD };// cannot be summed
		double[][][] wrongInput23 = { matA, matB, matC, matE };// cannot be multiplied

		double[][][][] wrongInputs1 = { wrongInput1, wrongInput2, wrongInput3, wrongInput4, wrongInput5, wrongInput6,
				wrongInput7, wrongInput8, wrongInput9, wrongInput10, wrongInput11, wrongInput12, wrongInput13,
				wrongInput14, wrongInput15, wrongInput16, wrongInput17, wrongInput18, wrongInput19, wrongInput20,
				wrongInput21, wrongInput22, wrongInput23 };
		double[] dummyScalars = { 1, 1, 1 };
		double[][] output;

		boolean passed = true;
		for (int i = 0; i < wrongInputs1.length; i++) {
			output = Task3.linearCalc(wrongInputs1[i], dummyScalars);
			if (!Arrays.deepEquals(output, ZERO)) {
				passed = false;
				System.out.println("Failed on input: " + Arrays.deepToString(wrongInputs1[i]) + " with scalars: "
						+ Arrays.toString(dummyScalars));
				System.out
						.println("Expected: " + Arrays.deepToString(ZERO) + " but got: " + Arrays.deepToString(output));
			}
		}

		double[][][] dummyMatrices = { { { 1 } }, { { 1 } }, { { 1 } }, { { 1 } } };
		double[][] wrongInputs2 = { null, {}, { 1, 2 }, { 1, 2, 3, 4 } };
		for (int i = 0; i < wrongInputs2.length; i++) {
			output = Task3.linearCalc(dummyMatrices, wrongInputs2[i]);
			if (!Arrays.deepEquals(output, ZERO)) {
				passed = false;
				System.out.println("Failed on input: " + Arrays.deepToString(dummyMatrices) + " with scalars: "
						+ Arrays.toString(wrongInputs2[i]));
				System.out
						.println("Expected: " + Arrays.deepToString(ZERO) + " but got: " + Arrays.deepToString(output));
			}
		}

		double[][][] input1 = new double[][][] { { { 1, 2 }, { 3, 4 } }, // A
				{ { 5, 6 }, { 7, 8 } }, // B
				{ { 9, 10 }, { 11, 12 } }, // C
				{ { 13, 14 }, { 15, 16 } } // D
		};
		double[][][] input2 = new double[][][] { { { 0 } }, // A
				{ { 5, 6 }, { 7, 8 } }, // B
				{ { 9, 10 }, { 11, 12 } }, // C
				{ { 13, 14 }, { 15, 16 } } // D
		};
		double[][][] input3 = new double[][][] { { { 1, 2 }, { 3, 4 } }, // A
				{ { 0 } }, // B
				{ { 9, 10 }, { 11, 12 } }, // C
				{ { 13, 14 }, { 15, 16 } } // D
		};
		double[][][] input4 = new double[][][] { { { 1, 2 }, { 3, 4 } }, // A
				{ { 5, 6 }, { 7, 8 } }, // B
				{ { 0 } }, // C
				{ { 13, 14 }, { 15, 16 } } // D
		};
		double[][][] input5 = new double[][][] { { { 1, 2 }, { 3, 4 } }, // A
				{ { 5, 6 }, { 7, 8 } }, // B
				{ { 9, 10 }, { 11, 12 } }, // C
				{ { 0 } } // D
		};
		double[][][] input6 = new double[][][] { { { 1, 2 }, { 3, 4 } }, // A
				{ { 5, 6 }, { 7, 8 } }, // B
				{ { -4.25, -5.5 }, { -6.75, -8 } }, // C
				{ { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 } } // D
		};

		double[][][] input7 = { matA, matB, matC, matD };

		double[][][] input8 = { matD };

		double[][][] input9 = { matA, matD };

		double[][][][] matrixInputs = { input1, input2, input3, input4, input5, input6, input7, input8, input9 };

		double[][] scalarInputs = { { 2, 3, 4 }, { 2, 3, 4 }, { 2, 3, 4 }, { 2, 3, 4 }, { 2, 3, 4 }, { 2, 3, 4 },
				{ 2, 3, 4 }, {}, { 1 } };

		double[][][] input1Copy = Arrays.copyOf(input1, input1.length);
		double[][][] input2Copy = Arrays.copyOf(input2, input2.length);
		double[][][] input3Copy = Arrays.copyOf(input3, input3.length);
		double[][][] input4Copy = Arrays.copyOf(input4, input4.length);
		double[][][] input5Copy = Arrays.copyOf(input5, input5.length);
		double[][][] input6Copy = Arrays.copyOf(input6, input6.length);
		double[][][] input7Copy = Arrays.copyOf(input7, input7.length);
		double[][][] input8Copy = Arrays.copyOf(input8, input8.length);
		double[][][] input9Copy = Arrays.copyOf(input9, input9.length);

		double[][][][] inputsCopy = { input1Copy, input2Copy, input3Copy, input4Copy, input5Copy, input6Copy,
				input7Copy, input8Copy, input9Copy };

		double[] scalars = new double[] { 2, 3, 4 };

		double[][][] expectedOutputs = { { { 1557, 1787 }, { 2043, 2345 } }, { { 1475, 1693 }, { 1853, 2127 } },
				{ { 1110, 1274 }, { 1434, 1646 } }, { { 529, 607 }, { 799, 917 } }, ZERO, ZERO,
				{ { 16, 68 }, { 132, 144 } }, { { 2, 1 }, { 4, 3 }, { 0, 3 } }, { { 2, 7 }, { 12, 17 } } };
		for (int i = 0; i < matrixInputs.length; i++) {
			output = Task3.linearCalc(matrixInputs[i], scalarInputs[i]);
			if (!Arrays.deepEquals(output, expectedOutputs[i])) {
				passed = false;
				System.out.println("Failed on input: " + Arrays.deepToString(matrixInputs[i]) + " with scalars: "
						+ Arrays.toString(scalarInputs[i]));
				System.out.println("Expected: " + Arrays.deepToString(expectedOutputs[i]) + " but got: "
						+ Arrays.deepToString(output));
			}
		}

		for (int i = 0; i < matrixInputs.length; i++) {
			if (!Arrays.deepEquals(matrixInputs[i], inputsCopy[i])) {
				passed = false;
				System.out.println("input is being changes");
			}
		}
		double[] scalarsCopy = { 2, 3, 4 };
		if (!Arrays.equals(scalars, scalarsCopy)) {
			System.out.println("scalars are being changed");
		}

		if (passed)
			System.out.println("Passed All Tests");

	}

	public static void testQ4E1() {
		boolean passed = true;
		int[][] inputs = { { 1, 2 }, { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2, 3 }, { -1, -2, 3 }, { -1, 2, 3 },
				{ 1, -2, -3 }, { 1, 2, -3 }, { -1, -2, -3 }, { -1, 2, -3 }, { 1, -2, -3 }, { 1, 2, 3, 4 },
				{ -1, -2, 3, 4 }, { -1, 2, 3, 4 }, { 1, -2, -3, 4 }, { 1, 2, -3, 4 }, { -1, -2, -3, 4 },
				{ -1, 2, -3, 4 }, { 1, -2, -3, 4 }, { 1, 2, 3, -4 }, { -1, -2, 3, -4 }, { -1, 2, 3, -4 },
				{ 1, -2, -3, -4 }, { 1, 2, -3, -4 }, { -1, -2, -3, -4 }, { -1, 2, -3, -4 }, { 1, -2, -3, -4 } };
		for (int[] lits : inputs) {
			int n = lits.length;
			boolean[] assignmnet = new boolean[n + 1];
			int possibleValues = (int) Math.pow(2, n);
			for (int i = 0; i < possibleValues && passed; i++) {
				for (int j = 0; j < n; j++) {
					boolean value = ((i >> j) & 1) == 1;
					assignmnet[j + 1] = value;
				}
				// Do something with the boolArray for each possible value
				int numOfTrue = countTrue(assignmnet, lits);
				boolean value = evaluate(Task4.atLeastOne(lits), assignmnet);
				if ((numOfTrue < 1 && value) || (numOfTrue >= 1 && !value)) {
					passed = false;
					System.out.println("Failed on input: " + Arrays.toString(lits) + " with assignment: "
							+ Arrays.toString(assignmnet));
					System.out.println("Expected output: " + (!value) + " but got: " + value);
				}

			}
			if (!passed)
				break;
		}
		if (passed)
			System.out.println("Passed All Tests");
	}

	public static void testQ4E2() {
		boolean passed = true;
		int[][] inputs = { { 1, 2 }, { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2, 3 }, { -1, -2, 3 }, { -1, 2, 3 },
				{ 1, -2, -3 }, { 1, 2, -3 }, { -1, -2, -3 }, { -1, 2, -3 }, { 1, -2, -3 }, { 1, 2, 3, 4 },
				{ -1, -2, 3, 4 }, { -1, 2, 3, 4 }, { 1, -2, -3, 4 }, { 1, 2, -3, 4 }, { -1, -2, -3, 4 },
				{ -1, 2, -3, 4 }, { 1, -2, -3, 4 }, { 1, 2, 3, -4 }, { -1, -2, 3, -4 }, { -1, 2, 3, -4 },
				{ 1, -2, -3, -4 }, { 1, 2, -3, -4 }, { -1, -2, -3, -4 }, { -1, 2, -3, -4 }, { 1, -2, -3, -4 } };
		for (int[] lits : inputs) {
			int n = lits.length;
			boolean[] assignmnet = new boolean[n + 1];
			int possibleValues = (int) Math.pow(2, n);
			for (int i = 0; i < possibleValues && passed; i++) {
				for (int j = 0; j < n; j++) {
					boolean value = ((i >> j) & 1) == 1;
					assignmnet[j + 1] = value;
				}
				// Do something with the boolArray for each possible value
				int numOfTrue = countTrue(assignmnet, lits);
				boolean value = evaluate(Task4.atMostOne(lits), assignmnet);
				if ((numOfTrue > 1 && value) || (numOfTrue <= 1 && !value)) {
					passed = false;
					System.out.println("Failed on input: " + Arrays.toString(lits) + " with assignment: "
							+ Arrays.toString(assignmnet));
					System.out.println("Expected output: " + (!value) + " but got: " + value);
				}

			}
			if (!passed)
				break;
		}
		if (passed)
			System.out.println("Passed All Tests");
	}

	public static void testQ4E3() {
		boolean passed = true;
		int[][] inputs = { { 1, 2 }, { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2, 3 }, { -1, -2, 3 }, { -1, 2, 3 },
				{ 1, -2, -3 }, { 1, 2, -3 }, { -1, -2, -3 }, { -1, 2, -3 }, { 1, -2, -3 }, { 1, 2, 3, 4 },
				{ -1, -2, 3, 4 }, { -1, 2, 3, 4 }, { 1, -2, -3, 4 }, { 1, 2, -3, 4 }, { -1, -2, -3, 4 },
				{ -1, 2, -3, 4 }, { 1, -2, -3, 4 }, { 1, 2, 3, -4 }, { -1, -2, 3, -4 }, { -1, 2, 3, -4 },
				{ 1, -2, -3, -4 }, { 1, 2, -3, -4 }, { -1, -2, -3, -4 }, { -1, 2, -3, -4 }, { 1, -2, -3, -4 } };
		for (int[] lits : inputs) {
			int n = lits.length;
			boolean[] assignmnet = new boolean[n + 1];
			int possibleValues = (int) Math.pow(2, n);
			for (int i = 0; i < possibleValues && passed; i++) {
				for (int j = 0; j < n; j++) {
					boolean value = ((i >> j) & 1) == 1;
					assignmnet[j + 1] = value;
				}
				// Do something with the boolArray for each possible value
				int numOfTrue = countTrue(assignmnet, lits);
				boolean value = evaluate(Task4.exactlyOne(lits), assignmnet);
				if ((numOfTrue == 1 && !value) || (numOfTrue != 1 && value)) {
					passed = false;
					System.out.println("Failed on input: " + Arrays.toString(lits) + " with assignment: "
							+ Arrays.toString(assignmnet));
					System.out.println("Expected output: " + (!value) + " but got: " + value);
				}

			}
			if (!passed)
				break;
		}
		if (passed)
			System.out.println("Passed All Tests");
	}

	public static boolean evaluate(int[][] cnf, boolean[] assign) {
		boolean flag = true;
		for (int i = 0; i < cnf.length && flag; i++) {
			flag = false;
			for (int j = 0; j < cnf[i].length && !flag; j++) {
				int literal = cnf[i][j];
				if (literal > 0)
					flag = assign[literal];
				else
					flag = !assign[-literal];
			}
		}
		return flag;
	}

	public static int countTrue(boolean[] arr, int[] lits) {
		int count = 0;
		for (int i = 0; i < lits.length; i++) {
			if ((arr[i + 1] && lits[i] > 0) || (lits[i] < 0 && !arr[i + 1]))
				count++;
		}
		return count;
	}

	public static void rounding(double[][] array) {
		for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = Math.round(array[i][j] * 100) / 100.0;
			}
	}

	public static String makeInput(int[] arr) {
		String ans = "";
		for (int i = 0; i < arr.length; i++)
			ans = ans + arr[i] + '\n';
		return ans;
	}

}
