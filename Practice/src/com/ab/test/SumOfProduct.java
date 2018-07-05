package com.ab.test;

import java.util.Scanner;

public class SumOfProduct {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter No: ");
		int number = sc.nextInt();

		int product = 1;
		int sum = 0;
		for (int i = 1; i <= number; i++) {
			product *= product * i;
		}
		int div = 1;
		int mod;

		System.out.println("Product Of Numbers: " + product);
		while (div != 0) {
			div = product / 10;
			mod = product % 10;
			sum = sum + mod;
			product = div;
		}
		System.out.println("Sum Is: " + sum);

		sc.close();
	}
}
