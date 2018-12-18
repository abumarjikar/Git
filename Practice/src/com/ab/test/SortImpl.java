package com.ab.test;

public class SortImpl {

	public static void main(String[] args) {
		int[] arr = new int[] { 125, 1, 5, 7, 30, 4, 90 };

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		for (int a : arr) {
			System.out.print(a+" ");
		}
	}
}
