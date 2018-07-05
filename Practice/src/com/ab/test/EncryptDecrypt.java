package com.ab.test;

public class EncryptDecrypt {

	public static void main(String[] args) {
		int i, j, n = 100;
		for (i = 0; i < n; i++) {
			for (j = 0; j <= i; j++){
				System.out.print("+");
			}
			System.out.print("  ");
			for (j = 0; j < (n - i); j++){
				System.out.print("+");
			}
			System.out.println();
		}
	}
}
