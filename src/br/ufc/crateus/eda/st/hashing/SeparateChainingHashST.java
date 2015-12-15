package br.ufc.crateus.eda.st.hashing;

import br.ufc.crateus.eda.st.ST;

public class SeparateChainingHashST<K, V> implements ST<K, V> {
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
	
	public SeparateChainingHashST(ST<K, V> st) {
		addAll(st);
	}
	
	public void addAll(ST<K, V> st) {
		for (K key : st.keys())
			put(key, st.get(key));
	}
	
	public void retainsAll(ST<K, V> st) {
		for (K key : st.keys())
			if (!this.contains(key)) delete(key);
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

	@Override
	public void delete(K key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(K key) {
		return get(key) != null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterable<K> keys() {
		// TODO Auto-generated method stub
		return null;
	}
}
