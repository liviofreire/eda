package br.ufc.crateus.eda.test;

import br.ufc.crateus.eda.st.ST;
import br.ufc.crateus.eda.st.hashing.LinearProbingHashST;

public class Test {
	public static void main(String[] args) {
		ST<String, Integer> tree = new LinearProbingHashST<>();
		tree.put("azul", 1);
		tree.put("vermelho", 2);
		tree.put("amarelo", 3);
		
		System.out.println(tree.get("vermelho"));
	}
}
