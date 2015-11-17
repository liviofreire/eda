package br.ufc.crateus.eda.st.ordered;

public abstract class OrderedBinaryTree<K extends Comparable<K>, V> implements OrderedST<K, V> {
	protected Node root = null;
	
	protected class Node {
		K key;
		V value;
		Node left;
		Node right;
		int count;
		public Node(K key, V value, int count) {
			this.key = key;
			this.value = value;
			this.count = count;
		}
	}
		
	@Override
	public V get(K key) {
		Node r = root;
		while (r != null) {
			int cmp = key.compareTo(r.key);
			if (cmp < 0) r = r.left;
			else if (cmp > 0) r = r.right;
			else return r.value;
		}
		return null;
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return size(root);
	}
	
	protected int size(Node node) {
		return (node != null)? node.count : 0;
	}

	@Override
	public Iterable<K> keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public K min() {
		Node min = min(root);
		return (min != null)? min.key : null;
	}
	
	protected Node min(Node r) {
		if (r == null) return null;
		Node tmp = min(r.left);
		return (tmp != null)? tmp : r;  
	}

	@Override
	public K max() {
		Node max = max(root);
		return (max != null)? max.key : null;
	}
	
	private Node max(Node r) {
		if (r == null) return null;
		Node tmp = max(r.right);
		return (tmp != null)? tmp : r;  
	}

	@Override
	public K floor(K key) {
		Node tmp = floor(root, key);
		return (tmp != null)? tmp.key : null;
	}
	
	private Node floor(Node r, K key) {
		if (r == null) return null;
		int cmp = key.compareTo(r.key);
		if (cmp == 0) return r;
		if (cmp < 0) return floor(r.left, key);
		Node tmp = floor(r.right, key);
		return (tmp == null)? r : tmp; 
	}

	@Override
	public K ceiling(K key) {
		Node tmp = ceiling(root, key);
		return (tmp != null)? tmp.key : null;
	}
	
	private Node ceiling(Node r, K key) {
		if (r == null) return null;
		int cmp = key.compareTo(r.key);
		if (cmp == 0) return r;
		if (cmp > 0) return ceiling(r.right, key);
		Node tmp = ceiling(r.left, key);
		return (tmp == null)? r : tmp; 
	}

	@Override
	public int rank(K key) {
		return rank(root, key);
	}
	
	private int rank(Node r, K key) {
		if (r == null) return 0;
		int cmp = key.compareTo(r.key);
		if (cmp == 0) return size(r.left);
		if (cmp < 0) return rank(r.left, key);
		return 1 + size(r.left) + rank(r.right, key);
	}

	@Override
	public int size(K lo, K hi) {
		// TODO Auto-generated method stub
		return rank(hi) - rank(lo);
	}

	@Override
	public Iterable<K> keys(K lo, K hi) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public K select(int k) {
		// TODO Auto-generated method stub
		return null;
	}
}
