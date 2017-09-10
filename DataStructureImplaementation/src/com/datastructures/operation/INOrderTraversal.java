package com.datastructures.operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

import com.datastructures.impl.Node;

public class INOrderTraversal {

	private static List<Node> inOrderTraversal(Node root, List<Node> nodes) {

		if (root == null) {
			return new ArrayList<>();
		}
		nodes = inOrderTraversal(root.getLeft(), nodes);
		nodes.add(root);
		nodes.addAll(inOrderTraversal(root.getRight(), nodes));
		return nodes;

	}

	private static List<Node> inOrderIterative(Node root) {
		List<Node> nodes = new ArrayList<>();
		Stack<Node> nodeStack = new Stack<>();
		Node startNode = root;
		while (true) {
			if (startNode != null) {
				nodeStack.push(startNode);
				startNode = startNode.getLeft();
			} else {
				if (nodeStack.empty()) {
					break;
				}
				startNode = nodeStack.pop();
				nodes.add(startNode);
				startNode = startNode.getRight();
			}
		}
		return nodes;

	}

	private static List<Node> postOrderIterative(Node root) {
		List<Node> nodes = new ArrayList<>();
		Stack<Node> nodeStack = new Stack<>();
		Stack<Node> preNodeStack = new Stack<>();
		preNodeStack.push(root);
		while (!preNodeStack.isEmpty()) {
			root = preNodeStack.pop();
			nodeStack.push(root);
			if (root.getLeft() != null) {
				preNodeStack.push(root.getLeft());
			}
			if (root.getRight() != null) {
				preNodeStack.push(root.getRight());
			}
		}
		IntStream.range(0, nodeStack.size()).forEach(i -> nodes.add(nodeStack.pop()));
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
		// inOrderTraversal(n1, nodes).stream().forEach(n -> System.out.println(n.getValue()));
		// (n1).stream().forEach(n -> System.out.println(n.getValue()));
		postOrderIterative(n1).stream().forEach(n -> System.out.println(n.getValue()));
	}
}
/*
 * 1 2 3 4 5 6 7
 */
