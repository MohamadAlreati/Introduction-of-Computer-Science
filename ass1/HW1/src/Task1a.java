import java.util.Scanner;

public class Task1a {
	public static void main(String[] args) {

		String s1 = "abcba";
		String s2 = "abkvcba";
		String s3 = "12345";
		System.out.println(makePalindrome(s2)); // “abcba”
		System.out.println(makePalindrome(s3)); // “1”
	}

	public static String makePalindrome(String str) {
		if (isPalinsdrome(str))
			return str;

		String maxAns = "";
		String ans;
		for (int i = 0; i < str.length(); i++) {
			ans = makePalindrome(str.substring(0, i) + str.substring(i + 1));
			if (ans.length() > maxAns.length())
				maxAns = ans;
		}
		return maxAns;
	}

	public static boolean isPalinsdrome(String str) {
		for (int i = 0; i < str.length() / 2; i++)
			if (str.charAt(i) != str.charAt(str.length() - 1 - i))
				return false;
		return true;
	}

}
