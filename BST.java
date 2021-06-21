package Mmn14;

class Node {
	int data;
	Node left, right;
	public Node(int data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

public class BST {
	private Node root;
	
	public boolean contains(int x) {
		return contains(root, x);
	}

	private boolean contains(Node n, int x) {
		if(n == null) return false;
		Matala14.comp6++;
		if(n.data == x) return true;
		Matala14.comp6++;
		if(n.data > x) return contains(n.left, x);
		else return contains(n.right, x);
	}

	public void add(int x) {
		root = add(root, x);
	}

	private Node add(Node n, int x) {
		if(n == null) return new Node(x, null, null);
		Matala14.comp6++;
		if(n.data > x) n.left = add(n.left, x);
		else n.right = add(n.right, x);
		return n;
	}
}
