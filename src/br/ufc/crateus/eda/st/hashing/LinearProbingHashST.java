package br.ufc.crateus.eda.st.hashing;

import br.ufc.crateus.eda.st.ST;

public class LinearProbingHashST<K, V> implements ST<K, V> {
	private int length;
	private K[] keys;
	private V[] values;
	private int size = 0;
	
	@SuppressWarnings("unchecked")
	public LinearProbingHashST(int length) {
		this.length = length;
		this.keys = (K[]) new Object[length];
		this.values = (V[]) new Object[length];
	}
	
	public LinearProbingHashST(ST<K, V> st) {
		super();
		for (K key : st.keys()) 
			put(key, st.get(key));
	}
	
	public LinearProbingHashST() {
		this(97);
	}

	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % length;
	}
	
	public V get(K key) {
		for (int i = hash(key); keys[i] != null; i = (i + 1) % length) 
			if (key.equals(keys[i])) return values[i];
		return null;
	}
	
	public void put(K key, V value) {
		if ((double) size / length > 0.5) resize(2 * length);
		
		int i;
		for (i = hash(key); keys[i] != null && !keys[i].equals(key); i = (i + 1) % length);
		if (keys[i] == null) {
			keys[i] = key;
			size++;
		}
		values[i] = value;
	}
	
	private void resize(int length) {
		LinearProbingHashST<K, V> hash = new LinearProbingHashST<>(length);
		for (int i = 0; i < length; i++) 
			if (keys[i] != null) hash.put(keys[i], values[i]);
		this.length = length;
		keys = hash.keys;
		values = hash.values;
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
