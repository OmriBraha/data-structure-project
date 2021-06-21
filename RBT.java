package Mmn14;

class RBNode {
	boolean color;
	int data;
	RBNode left, right, parent;
	public RBNode(boolean color, int data, RBNode left, RBNode right, RBNode parent) {
		this.color = color;
		this.data = data;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
	@Override
	public String toString() {
		return "Data: " + data + ", parent = " + parent;
	}
}

public class RBT {
	private static final boolean RED = false;
	private static final boolean BLACK = true;
	private RBNode root;
	
	public boolean contains(int x) {
		return contains(root, x);
	}

	private boolean contains(RBNode n, int x) {
		if(n == null) return false;
		Matala14.comp7++;
		if(n.data == x) return true;
		Matala14.comp7++;
		if(n.data > x) return contains(n.left, x);
		else return contains(n.right, x);
	}

	public void add(int x) {
		root = add(root, x);
		root.color = BLACK;
	}

	private RBNode add(RBNode n, int x) {
		if(n == null) return new RBNode(RED, x, null, null, null);
		Matala14.comp7++;
		if(n.data > x) {
			n.left = add(n.left, x);
			n.left.parent = n;
		}
		else {
			n.right = add(n.right, x);
			n.right.parent = n;
		}
		return fixNode(n);
	}

	private RBNode fixNode(RBNode n) {
		if(n == null) return null;
		if(color(n) == RED) {
			if(n == root) {
				n.color = BLACK;
			}
			else {
				if(color(n.parent.left) == RED && color(n.parent.right) == RED) {
					n.parent.left.color = BLACK;
					n.parent.right.color = BLACK;
					n.parent.color = RED;
					//fixNode(n.parent.parent);
				}
				else {
					if(color(n.left) == RED && n.parent.left == n) return rotateRight(n.parent);
					else if(color(n.right) == RED && n.parent.right == n) return rotateLeft(n.parent);
					else if(color(n.left) == RED && n.parent.right == n) {
						n = rotateRight(n);
						return rotateLeft(n.parent);
					}
					else if(color(n.right) == RED && n.parent.left == n) {
						n = rotateLeft(n);
						return rotateRight(n.parent);
					}
				}
			}
			
		}
		return n;
	}

	private RBNode rotateRight(RBNode n) {
		RBNode m = n.left;
		m.parent = n.parent; n.parent = m;
		n.left = m.right; m.right = n;
		m.color = n.color;
		n.color = RED;
		return m;
	}

	private RBNode rotateLeft(RBNode n) {
		RBNode m = n.right;
		m.parent = n.parent; n.parent = m;
		n.right = m.left; m.left = n;
		m.color = n.color;
		n.color = RED;
		return m;
	}

	private boolean color(RBNode n) {
		return n == null ? BLACK : n.color;
	}
}
