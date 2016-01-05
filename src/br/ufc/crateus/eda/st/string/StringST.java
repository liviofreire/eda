package br.ufc.crateus.eda.st.string;

import java.util.LinkedList;
import java.util.List;

public class StringST<V> {
	
	private static final int R = 256;
	private Node root; 
	
	private static class Node {
		Object value;
		Node[] next = new Node[R];
	}
	
	public void put(String key, V value) {
		root = put(root, key, value, 0);
	}
	
	private Node put(Node r, String key, V value, int i) {
		if (r == null) r = new Node();
		if (i == key.length()) {
			r.value = value;
		}
		else {
			char c = key.charAt(i);
			r.next[c] = put(r.next[c], key, value, i + 1);
		}
		return r;
	}
	
	@SuppressWarnings("unchecked")
	public V get(String key) {
		Node node = get(root, key, 0);
		return (node != null)? (V) node.value : null;
	}
	
	private Node get(Node r, String key, int i) {
		if (r == null) return null;
		if (i == key.length()) return r;
		char c = key.charAt(i);
		return get(r.next[c], key, i + 1);
	}
	
	public void delete(String key) {
		root = delete(root, key, 0);
	}
	
	private Node delete(Node r, String key, int i) {
		if (r == null) return null;
		if (i == key.length()) {
			r.value = null;
		}
		else {
			char c = key.charAt(i);
			r.next[c] = delete(r.next[c], key, i + 1);
		}
		
		if (r.value != null) return r;
		for (char c = 0; c < R; c++) {
			if (r.next[c] != null) return r;
		}
		return null;
	}
	
	Iterable<String> keys() {
		return keysWithPrefix("");
	}
	
	Iterable<String> keysWithPrefix(String prefix) {
		Node node = get(root, prefix, 0);
		List<String> queue = new LinkedList<String>();
		collect(node, prefix, queue);
		return queue;
	}
	
	private void collect(Node node, String prefix, List<String> queue) {
		if (node == null) return;
		if (node.value != null) queue.add(prefix);
		for (char c = 0; c < R; c++) {
			collect(node.next[c], prefix + c, queue);
		}
	}
}
