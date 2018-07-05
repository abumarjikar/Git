package com.ab.test;

import java.util.Calendar;
import java.util.Scanner;

public class DateUtil {

	public static String getDay(String sday, String smonth, String syear) {
		int day = Integer.valueOf(sday);
		int month = Integer.valueOf(smonth);
		int year = Integer.valueOf(syear);

		if (2000 < year && year < 3000) {
			Calendar c = Calendar.getInstance();
			c.set(year, month - 1, day);

			System.out.println(c.toString());
			String[] strDays = new String[] { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY",
					"SATURDAY" };
			int dayOfweek = c.getTime().getDay();
			return strDays[dayOfweek];
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		/*
		 * Scanner in = new Scanner(System.in); String month = in.next(); String
		 * day = in.next(); String year = in.next();
		 */

		System.out.println(getDay("25", "12", "2059"));
	}
}
