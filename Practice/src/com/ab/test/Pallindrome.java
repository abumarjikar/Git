package com.ab.test;

public class Pallindrome {

	public static void main(String[] args) {
		String s = "ABC";

		String reverse = "";
		for (int i = s.length() - 1; i >= 0; i--)
			reverse = reverse + s.charAt(i);

		if (reverse.equalsIgnoreCase(s))
			System.out.println("Pallindrome...");
		else
			System.out.println("Not Pallindrome...");
	}
}
