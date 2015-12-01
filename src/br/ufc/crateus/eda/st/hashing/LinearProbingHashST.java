package br.ufc.crateus.eda.st.hashing;

public class LinearProbingHashST<K, V> {
	private int length;
	@SuppressWarnings("unchecked")
	private K[] keys = (K[]) new Object[length];
	@SuppressWarnings("unchecked")
	private V[] values = (V[]) new Object[length];
	private int size = 0;
	
	public LinearProbingHashST(int length) {
		this.length = length;
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
}
