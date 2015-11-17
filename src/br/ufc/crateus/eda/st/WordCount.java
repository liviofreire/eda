package br.ufc.crateus.eda.st;

import java.util.Scanner;

public class WordCount {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ST<String, Integer> map = new STLinkedList<>();
		
		while (input.hasNext()) {
			String str = input.next();
			if (!map.contains(str)) map.put(str, 1);
			else map.put(str, map.get(str) + 1);
		}
		input.close();
		
		String max = "";
		map.put(max, 0);
		
		for (String key : map.keys()) 
			if (map.get(key) > map.get(max))
				max = key;
		System.out.println(max + "= " + map.get(max));
	}
}
