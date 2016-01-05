package br.ufc.crateus.eda.st.string;

public class TST<V> {
	private Node root;

	private class Node {
		char c;
		V value;
		Node left, mid, right;
	}
	
	public V get(String key) {
		Node node = get(root, key, 0);
		return (node != null)? node.value : null;
	}
	
	private Node get(Node node, String key, int i) {
		if (node == null) return null;
		char c = key.charAt(i);
		if (c < node.c) get(node.left, key, i);
		else if (c > node.c) get(node.right, key, i);
		else if (i == key.length() - 1) return node;
		return get(node.mid, key, i + 1);
	}
	
	public void put(String key, V value) {
		root = put(root, key, value, 0);
	}
	
	private Node put(Node node, String key, V value, int i) {
		char c = key.charAt(i);
		if (node == null) {
			node = new Node();
			node.c = c;
		}
		if (c < node.c) node.left = put(node.left, key, value,  i);
		else if (c > node.c) node.right = put(node.right, key, value,  i);
		else if (i == key.length() - 1) node.value = value;
		else node.mid = put(node.mid, key, value, i + 1);
		return node;
	}
	
	public static void main(String[] args) {
		System.out.println("".length());
	}
}
