package com.ab.test;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyFormat {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double payment = scanner.nextDouble();
		scanner.close();

		if (0 <= payment && payment <= Math.pow(10, 9)) {
			NumberFormat nm = null;
			Locale l = new Locale(Locale.US.getLanguage(), Locale.US.getCountry());
			nm = NumberFormat.getCurrencyInstance(l);
			String us = nm.format(payment);
			l = new Locale(Locale.US.getLanguage(), "IN");
			nm = NumberFormat.getCurrencyInstance(l);
			String india = nm.format(payment);
			l = new Locale(Locale.CHINA.getLanguage(), Locale.CHINA.getCountry());
			nm = NumberFormat.getCurrencyInstance(l);
			String china = nm.format(payment);
			l = new Locale(Locale.FRANCE.getLanguage(), Locale.FRANCE.getCountry());
			nm = NumberFormat.getCurrencyInstance(l);
			String france = nm.format(payment);

			System.out.println("US: " + us);
			System.out.println("India: " + india);
			System.out.println("China: " + china);
			System.out.println("France: " + france);
		}
	}
}
