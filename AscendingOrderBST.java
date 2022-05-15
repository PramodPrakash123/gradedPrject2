package com.greatlerning.treeinorder;

public class AscendingOrderBST {
	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	public static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static void skewedTree(Node root, int order) {
		if (root == null) {
			return;
		}

		if (order > 0) {
			skewedTree(root.right, order);
		} else {
			skewedTree(root.left, order);
		}

		Node rightNode = root.right;
		Node leftNode = root.left;
		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}
		if (order > 0) {
			skewedTree(leftNode, order);
		} else {
			skewedTree(rightNode, order);
		}

	}

	static void traverseRightSkewed(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		traverseRightSkewed(root.right);
	}

	public static void main(String[] args) {
		AscendingOrderBST obj = new AscendingOrderBST();
		obj.node = new Node(50);
		obj.node.left = new Node(30);
		obj.node.right = new Node(60);
		obj.node.left.left = new Node(10);
		obj.node.right.left = new Node(55);
		int order = 0;
		skewedTree(node, order);
		traverseRightSkewed(headNode);
	}

}
