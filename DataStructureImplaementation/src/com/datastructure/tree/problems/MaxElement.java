package com.datastructure.tree.problems;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.datastructures.impl.Node;

public class MaxElement {
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		n1.setLeft(n2);
		n1.setRight(n3);
		n2.setLeft(n4);
		n2.setRight(n5);
		n3.setLeft(n6);
		n3.setRight(n7);
		// List<Node> nodes = new ArrayList<>();
		// inOrderTraversal(n1, nodes).stream().forEach(n -> System.out.println(n.getValue()));
		// (n1).stream().forEach(n -> System.out.println(n.getValue()));
		System.out.println(maxElementRecursive(n1, n1).getValue());
	}

	private static Node maxElementIterative(Node root) {
		Queue<Node> nodeQueue = new LinkedBlockingQueue<Node>();
		int max = (int) root.getValue();
		Node maxNode = root;
		nodeQueue.add(root);
		while (!nodeQueue.isEmpty()) {
			Node temp = nodeQueue.poll();
			if ((int) temp.getValue() > max) {
				max = (int) temp.getValue();
				maxNode = temp;
			}
			if (temp.getLeft() != null) {
				nodeQueue.add(temp.getLeft());
			}
			if (temp.getRight() != null) {
				nodeQueue.add(temp.getRight());
			}
		}
		return maxNode;
	}

	private static Node maxElementRecursive(Node n1, Node maxNode) {
		if (n1 == null) {
			return maxNode;
		}
		Node leftMax = maxElementRecursive(n1.getLeft(), getMax(n1, maxNode));
		Node rightMax = maxElementRecursive(n1.getRight(), getMax(n1, maxNode));
		return getMax(getMax(n1, leftMax), rightMax);

	}

	private static Node getMax(Node n1, Node n2) {
		return (int) n1.getValue() > (int) n2.getValue() ? n1 : n2;
	}
}
