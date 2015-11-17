package br.ufc.crateus.eda.st.btree;

public class Page<K extends Comparable<K>> {
	private boolean botton;

	public Page(boolean botton) {
		this.botton = botton;
	}
	
	void close() {
		
	}
	
	void insert(K key) {
		
	}
	
	void enter(Page<K> p) {
		
	}
	
	boolean isExternal() {
		return botton;
	}
	
	boolean holds(K key) {
		return false;
	}
	
	Page<K> next(K key) {
		return null;
	}
	
	boolean hasOverflowed() {
		return false;
	}
	
	Page<K> split() {
		return null;
	}
	
	Iterable<K> keys() {
		return null;
	}
}
