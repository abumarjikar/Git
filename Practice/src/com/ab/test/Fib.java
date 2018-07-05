package com.ab.test;

import java.util.Scanner;

public class Fib {

	public static void main(String[] args) {
		int n = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter No: ");
		String no = sc.next();
		n = Integer.valueOf(no);

		int f = 0;
		for (int i = 0; i <= n; i++) {
			f = f + i;
			System.out.print(f+" ");
		}
		sc.close();
	}
}
