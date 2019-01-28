package com.ab.test;

import java.util.Scanner;

public class BotPrincess {
	static int botc, botr, princ, prinr = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ai = 0;
		char[][] grid = new char[n][n];

		while (ai < n) {
			String line = sc.next();
			char[] linesplits = line.toCharArray();
			for (int j = 0; j < linesplits.length; j++) {
				char c = linesplits[j];
				if (c == 'p') {
					prinr = ai;
					princ = j;
				} else if (c == 'm') {
					botr = ai;
					botc = j;
				}
				grid[ai][j] = linesplits[j];
			}
			ai++;
		}
		if (n >= 3 && n < 100) {

			while (!(botc == princ && botr == prinr)) {
				rescuePricess(grid);
			}
		}
	}

	private static void rescuePricess(char[][] grid) {
		// find diff x of both
		int colDiff = princ - botc;
		int rowDiff = prinr - botr;

		if (colDiff != 0) {// UP DOWN
			// process x
			// if x diff in -ve then bot position -1 and else +1
			if (colDiff > 0) {
				botc = botc + 1;
				System.out.println("RIGHT");
			} else {
				botc = botc - 1;
				System.out.println("LEFT");
			}
		} else if (rowDiff != 0) {// RIGHT LEFT
			// process y
			// if y diff in -ve then bot position -1 and else +1
			if (rowDiff > 0) {
				botr = botr + 1;
				System.out.println("DOWN");
			} else {
				botr = botr - 1;
				System.out.println("UP");
			}
		}
	}

	private static void setPosition(char c, int x, int y, char[][] grid) {
		grid[x][y] = c;
	}

	static void nextMove(int n, int r, int c, String[] grid) {
		char[][] grid1 = new char[n][n];
		int pr = 0, pc = 0;
		for (int i = 0; i < n; i++) {
			char[] lineSplits = grid[i].toCharArray();
			for (int j = 0; j < lineSplits.length; j++) {
				char ch = lineSplits[j];
				if (ch == 'p') {
					pr = i;
					pc = j;
				}
				grid1[i][j] = ch;
			}
		}
		int colDiff = pc - c;
		int rowDiff = pr - r;

		if (colDiff != 0) {// UP DOWN
			// process x
			// if x diff in -ve then bot position -1 and else +1
			if (colDiff > 0) {
				botc = botc + 1;
				System.out.println("RIGHT");
			} else {
				botc = botc - 1;
				System.out.println("LEFT");
			}
		} else if (rowDiff != 0) {// RIGHT LEFT
			// process y
			// if y diff in -ve then bot position -1 and else +1
			if (rowDiff > 0) {
				botr = botr + 1;
				System.out.println("DOWN");
			} else {
				botr = botr - 1;
				System.out.println("UP");
			}
		}

	}

	public static void maina(String[] args) {
		Scanner in = new Scanner(System.in);
		int n, r, c;
		n = in.nextInt();
		r = in.nextInt();
		c = in.nextInt();
		String grid[] = new String[n];

		for (int i = 0; i < n; i++) {
			grid[i] = in.next();
		}

		nextMove(n, r, c, grid);

	}
}
