package com.ab.test;

import java.util.Scanner;

public class JavaLoop {
	public static void maina(String[] args) {
		System.out.println(Math.pow(2, 1));
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		int a, b, n;
		for (int i = 0; i < q; i++) {
			a = in.nextInt();
			b = in.nextInt();
			n = in.nextInt();
			if (q >= 0 && q <= 500) {
				if ((a >= 0 && a <= 50) && (b >= 0 && b <= 50)) {
					if (n >= 1 && n <= 15) {

						for (int con = 0; con < n; con++) {
							int calculation = 0;
							for (int qon = 0; qon <= con; qon++) {
								calculation = calculation + ((((int) Math.pow(2, qon)) * b));
							}
							System.out.print((a + calculation) + " ");
						}
					}
				}
			}
			System.out.println();
		}

		in.close();
	}
}
