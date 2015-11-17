package br.ufc.crateus.eda.st;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class STLinkedList<K, V> implements ST<K, V> {
	List<Entry<K, V>> entries = new LinkedList<>();

	@Override
	public void put(K key, V value) {
		if (value == null) 
			delete(key);
		else {
			Entry<K, V> entry = getEntry(key);
			if (entry != null) {
				entry.setValue(value);
			}
			else {
				Entry<K, V> e = new STEntry<K, V>(key, value);
				entries.add(e);
			}
		}
	}

	private Entry<K, V> getEntry(K key) {
		for (Entry<K, V> e : entries) {
			if (e.getKey().equals(key))
				return e;
		}
		return null;
	}

	@Override
	public V get(K key) {
		Entry<K, V> entry = getEntry(key);
		if (entry != null)
			return entry.getValue();
		return null;
	}

	@Override
	public void delete(K key) {
		Entry<K, V> entry = getEntry(key);
		if (entry != null)
			entries.remove(entry);
	}

	@Override
	public boolean contains(K key) {
		return get(key) != null;
	}

	@Override
	public boolean isEmpty() {
		return entries.isEmpty();
	}

	@Override
	public int size() {
		return entries.size();
	}

	@Override
	public Iterable<K> keys() {
		List<K> keys = new ArrayList<>();
		for (Entry<K, V> e : entries) {
			keys.add(e.getKey());
		}
		return keys;
	}
}
