package com.datastructures.impl;

import com.datastructures.Tree;

public class BinaryIndexedTree implements Tree {

	private int[] bitArray;

	public BinaryIndexedTree(int[] inputArray) {
		this.bitArray = create(inputArray);
	}

	private int[] create(int[] inputArray) {
		this.bitArray = new int[inputArray.length + 1];
		for (int i = 0; i < inputArray.length; i++) {
			update(i + 1, inputArray[i]);
		}
		return bitArray;
	}

	public long getSum(int index) {
		int sumIdx = index + 1;
		int sum = 0;
		while (sumIdx > 0) {
			sum = sum + this.bitArray[sumIdx];
			sumIdx = parent(sumIdx);
		}
		return sum;
	}

	private static int next(int index) {
		return (index & -index) + index;
	}

	private static int parent(int index) {
		return index - (index & -index);
	}

	public void update(int index, int mod) {
		int next = index;
		while (next < this.bitArray.length) {
			this.bitArray[next] = this.bitArray[next] + mod;
			next = next(next);
		}
	}

	public int[] getBitArray() {
		return bitArray;
	}

	public void setBitArray(int[] bitArray) {
		this.bitArray = bitArray;
	}

	/*
	 * public static void main(String[] args) { int[] arr = new int[4]; arr[0] = 1; arr[1] = 2; arr[2] = 3; arr[3] = 4;
	 * BinaryIndexedTree bit = new BinaryIndexedTree(arr); System.out.println(bit.getSum(2)); }
	 */
}
