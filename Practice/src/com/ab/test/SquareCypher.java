package com.ab.test;

import java.util.Scanner;

public class SquareCypher {

	char[][] _arr = { 
			{ 'a', 'b', 'c', 'd', 'e' },
			{ 'f', 'g', 'h', 'i', 'j' }, 
			{ 'k', 'l', 'm', 'n', 'o' },
			{ 'p', 'r', 's', 't', 'u' }, 
			{ 'v', 'w', 'x', 'y', 'z' } 
			};
	
	char[][] _key_top_right = new char[5][5];/*{
			{'k','e','y','w','o'},
			{'r','d','a','b','c'},
			{'f','g','h','i','j'},
			{'l','m','n','p','q'},
			{'s','t','u','v','x'}
			};*/
	
	char[][] _key_bottom_left = new char[5][5];/* = {
			{'w','o','r','d','k'},
			{'e','y','a','b','c'},
			{'f','g','h','i','j'},
			{'l','m','n','p','q'},
			{'s','t','u','v','z'}
			};*/

	// digraph

	// AC

	// first letter -> row same as first char and same column as of second char of key
	// second letter -> row same as 
	
	private String encrypt(String inputString) {
		inputString = inputString.replace(" ", "").trim().toLowerCase();
		if (!(inputString.length() % 2 == 0)) {
			inputString = inputString.concat("x");
		}
		char[] chars = inputString.toCharArray();
		StringBuilder cypherStringBuilder = new StringBuilder();

		for (int i = 0; i < chars.length; i = i + 2) {
			char firstChar = chars[i];
			char secondChar = chars[i + 1];

			int fx = -1;
			int fy = -1;
			int sx = -1;
			int sy = -1;
			int[] cordsFirst = getCharPosition(firstChar);
			int[] cordsSecond = getCharPosition(secondChar);
			fx = cordsFirst[0];
			fy = cordsFirst[1];
			sx = cordsSecond[0];
			sy = cordsSecond[1];

			char firstCypherChar = getCharAt(fx, sy, true, false);
			char secondCypherChar = getCharAt(sx, fy, false, true);
			cypherStringBuilder.append(firstCypherChar).append(secondCypherChar);
		}

		return cypherStringBuilder.toString();
	}
	
	private String decrypt(String inputString) {
		inputString = inputString.replace(" ", "").trim().toLowerCase();
		if (!(inputString.length() % 2 == 0)) {
			inputString = inputString.concat("x");
		}
		char[] chars = inputString.toCharArray();
		StringBuilder cypherStringBuilder = new StringBuilder();

		for (int i = 0; i < chars.length; i = i + 2) {
			char firstChar = chars[i];
			char secondChar = chars[i + 1];

			int fx = -1;
			int fy = -1;
			int sx = -1;
			int sy = -1;
			int[] cordsFirst = getCharPositionDe(firstChar, true);
			int[] cordsSecond = getCharPositionDe(secondChar, false);
			fx = cordsFirst[0];
			fy = cordsFirst[1];
			sx = cordsSecond[0];
			sy = cordsSecond[1];

			char firstCypherChar = getCharAtDe(fx, sy);
			char secondCypherChar = getCharAtDe(sx, fy);
			cypherStringBuilder.append(firstCypherChar).append(secondCypherChar);
		}

		return cypherStringBuilder.toString();
	}
	
	private char getCharAt(int x, int y, boolean isTopRight, boolean isBottomLeft) {
		char c = ' ';
		if (isTopRight) {
			c = _key_top_right[x][y];
		} else if (isBottomLeft) {
			c = _key_bottom_left[x][y];
		}

		return c;
	}
	
	private char getCharAtDe(int x, int y) {

		return _arr[x][y];
	}
	
	private int[] getCharPosition(char character) {
		boolean isBreak = false;
		int[] cordinates = new int[2];
		for (int xA = 0; xA < _arr.length; xA++) {
			char[] yAs = _arr[xA];

			for (int yA = 0; yA < yAs.length; yA++) {
				if (character == yAs[yA]) {
					cordinates[0] = xA;
					cordinates[1] = yA;
					
					isBreak = true;
					break;
				}
			}
			if (isBreak)
				break;
		}
		return cordinates;
	}
	
	private int[] getCharPositionDe(char character, boolean useTopRight) {
		char[][] arr = useTopRight?_key_top_right:_key_bottom_left;
		boolean isBreak = false;
		int[] cordinates = new int[2];
		for (int xA = 0; xA < arr.length; xA++) {
			char[] yAs = arr[xA];

			for (int yA = 0; yA < yAs.length; yA++) {
				if (character == yAs[yA]) {
					cordinates[0] = xA;
					cordinates[1] = yA;
					
					isBreak = true;
					break;
				}
			}
			if (isBreak)
				break;
		}
		return cordinates;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("========= Four Square Cypher =========");
		System.out.println("Enter Top Right Key:- ");
		String topRightKeyString = sc.nextLine().toLowerCase();
		
		System.out.println("Enter Bottom Left Key:- ");
		String bottomLeftKeyString = sc.nextLine().toLowerCase();
		SquareCypher cypher = new SquareCypher();
		cypher.fillKeyArray(topRightKeyString, true); 
		cypher.fillKeyArray(bottomLeftKeyString, false);
		System.out.println("Enter Input String:- ");
		String inputString = sc.nextLine();
		
		String encryptedText = cypher.encrypt(inputString);
		System.out.println("Encrypted Text: " + encryptedText);
		String decryptedText = cypher.decrypt(encryptedText);
		System.out.println("Decrypted Text: " + decryptedText);

	}

	private void fillKeyArray(String keyString, boolean isTopRight) {
		char[][] arr = isTopRight ? _key_top_right : _key_bottom_left;

		int i = 0;
		for (int x = 0; x < arr.length; x++)
			for (int y = 0; y < arr[x].length; y++) {
				char c = keyString.charAt(i);
				arr[x][y] = c;
				i++;
			}
	}

}

