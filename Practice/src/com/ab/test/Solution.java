package com.ab.test;


public class Solution {

	public static void main(String[] args) {
		int[][] ar = {{1,2,3},{4,5,6},{7,8,9}};
		
		//cal sum of 1st diag 
		int sumfdg = 0;
		int sumsdg = 0;
		
		for (int i = 0; i <ar.length; i++) {
			sumfdg = sumfdg + ar[i][i];
		}
		
		for (int i = ar.length -1 ; i >=0; i--) {
			sumsdg = sumsdg + ar[i][(ar.length -1) - i];
		}
		
		System.out.println(Math.subtractExact(sumfdg, sumsdg));
	}
}
