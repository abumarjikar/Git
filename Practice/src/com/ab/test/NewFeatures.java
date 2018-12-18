package com.ab.test;

import java.util.HashMap;
import java.util.Map;

public class NewFeatures {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < 10; i++) {
			map.put(i, i);
		}

		System.out.println(map);
		
		map.replaceAll((key, value) -> value * value);
		
		System.out.println(map);
		map.forEach((k,v)->{
			v = v * v;
		});
		
		System.out.println(map);
	}
}
