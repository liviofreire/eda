package br.ufc.crateus.eda.st.ordered;


public class BinarySearchTree<K extends Comparable<K>, V> extends OrderedBinaryTree<K, V> {

	@Override
	public void put(K key, V value) {
		put(root, key, value);
	}
	
	private Node put(Node r, K key, V value) {
		if (r == null) return new Node(key, value, 1);
		int cmp = key.compareTo(r.key);
		if (cmp < 0) r.left = put(r.left, key, value);
		else if (cmp > 0) r.right = put(r.right, key, value);
		else r.value = value;
		r.count = size(r.left) + size(r.right) + 1;
		
		return r;
	}

	@Override
	public void delete(K key) {
		root = delete(root, key);
	}
	
	private Node delete(Node r, K key) {
		if (r == null) return null;
		int cmp = key.compareTo(r.key);
		if (cmp < 0) r.left = delete(r.left, key);
		else if (cmp > 0) r.right = delete(r.right, key);
		else {
			if (r.left == null) return r.right;
			if (r.right == null) return r.left;
			Node tmp = r;
			r = min(r.right);
			r.left = tmp.left;
			r.right = deleteMin(tmp.right);
		}
		r.count = size(r.left) + size(r.right) + 1;
		return r;
	}


	@Override
	public void deleteMax() {
		root = deleteMax(root);
	}
	
	private Node deleteMax(Node r) {
		if (r.right == null) return r.left;
		r.right = deleteMax(r.right);
		r.count = size(r.left) + size(r.right) + 1;
		return r;
	}

	
	@Override
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node r) {
		if (r.left == null) return r.right;
		r.left = deleteMax(r.left);
		r.count = size(r.left) + size(r.right) + 1;
		return r;
	}

}
