package com.ab.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CleaningBot {
	static int botc, botr, princ, prinr = 0;
	
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

	static void next_move(int r, int c, char[][] grid) {
		int pr = 0, pc = 0;

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
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		botr = sc.nextInt();
		botc = sc.nextInt();
		
		
		char[][] grid = new char[5][5];

		int ai = 0;
		while (ai < 5) {
			String line = sc.next();
			char[] linesplits = line.toCharArray();
			for (int j = 0; j < linesplits.length; j++) {
				grid[ai][j] = linesplits[j];
			}
			ai++;
		}
		
		// find dirt first
		List<Integer[]> dirtList = new ArrayList<Integer[]>();

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (grid[i][j] == 'd') {
					Integer[] ar = { i, j };
					dirtList.add(ar);
				}
			}
		}
		
		for(int i = 0 ; i < dirtList.size(); i++) {
			Integer[] arr = dirtList.get(i);
			prinr = arr[0];
			princ = arr[1];
			
			while (!(botc == princ && botr == prinr)) {
				next_move(botr, botc, grid);
			}
			if ((botc == princ && botr == prinr))
				System.out.println("CLEAN");
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
}
