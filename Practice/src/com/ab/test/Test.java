/**
 * 
 */
package com.ab.test;

/**
 * @author Abhishek
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("This is Test For Git...");

		String testString = "This is Test For Git...";
		char[] charArray = testString.toCharArray();
		StringBuilder sb = new StringBuilder();
		if (charArray != null && charArray.length > 0) {

			for (char ch : charArray) {
				int ascii = (int) ch;
				if (ascii >= 65 && ascii < 97)
					ascii += 32;
				sb.append((char) ascii);
			}
		}
		System.out.println(sb.toString());
	}

}
