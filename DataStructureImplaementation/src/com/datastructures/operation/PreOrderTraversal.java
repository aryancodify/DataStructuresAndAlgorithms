package com.datastructures.operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.datastructures.impl.Node;

public class PreOrderTraversal {
	private static List<Node> preOrderTraversal(Node root, List<Node> nodes) {

		if (root == null) {
			return nodes;
		}
		nodes.add(root);
		nodes = preOrderTraversal(root.getLeft(), nodes);
		nodes = preOrderTraversal(root.getRight(), nodes);
		return nodes;

	}

	private static List<Node> preOrderIterative(Node root) {
		List<Node> nodes = new ArrayList<>();
		Stack<Node> nodeStack = new Stack<>();
		nodeStack.push(root);
		while (!nodeStack.empty()) {
			root = nodeStack.pop();
			nodes.add(root);
			if (root.getRight() != null) {
				nodeStack.push(root.getRight());
			}
			if (root.getLeft() != null) {
				nodeStack.push(root.getLeft());
			}
		}
		return nodes;

	}

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
		List<Node> nodes = new ArrayList<>();
		// nodes = preOrderTraversal(n1, nodes);
		// nodes.stream().forEach(n -> System.out.println(n.getValue()));
		preOrderIterative(n1).stream().forEach(n -> System.out.println(n.getValue()));
	}
}
