package com.lv.lesson21;

public class TestBinaryTree {
	/**
	 * 对二叉树进行测试
	 *
	 */
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		int[] datas = { 55, 33, 44, 88, 66, 99 };
		for (int i : datas) {
			tree.add(i);
		}
		// 打印二叉树总的数据
		tree.traverse(tree.getRoot());
		System.out.println(tree.height());
		// 测试删除
		tree.remove(33);
		tree.traverse(tree.getRoot());
		// 测试更新
		tree.update(44, 77);
		System.out.println();
		tree.traverse(tree.getRoot());
	}
}
