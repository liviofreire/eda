package br.ufc.crateus.eda.st.hashing;

public class SeparateChainingHashST<K, V> {
	private static final int M = 97;
	Node[] st = new Node[M];
	
	private static class Node {
		Node(Object key, Object value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
		Object key;
		Object value;
		Node next;
	}
	
	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	@SuppressWarnings("unchecked")
	public V get(K key) {
		int i = hash(key);
		
//		Node x;
//		for (x = st[i]; x != null && !x.key.equals(key); x = x.next);
//		return (V) x.value;
		
		for (Node x = st[i]; x != null; x = x.next) {
			if (x.key.equals(key)) return (V) x.value;
		}
		return null;
	}
	
	public void put(K key, V value) {
		int i = hash(key);
		for (Node x = st[i]; x != null; x = x.next) {
			if (x.key.equals(key)) {
				x.value = value;
				return;
			}
		}
		st[i] = new Node(key, value, st[i]);
	}
}
