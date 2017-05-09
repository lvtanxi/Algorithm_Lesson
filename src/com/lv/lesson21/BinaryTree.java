package com.lv.lesson21;

/**
 * 二叉树的增，删，改，查
 *
 * @author Administrator
 *
 */
public class BinaryTree {
	// 定义一个节点的数据结构()
	private class Node {
		Node parent;// 父节点
		Node left; // 左儿子
		Node right; // 右儿子
		Object data; // 任意类型的数据
		public Node(Object data) {
			this.data = data;
		}
	}
	private Node root;// 定义一个根节点
	/**
	 * <一>.二叉树的添加功能
	 *
	 * @param data
	 *            data： 为要添加的数据
	 */
	public void add(Object data) {
		// 首先判断是否包含该数据
		if (contains(data)) {
			// 如果包含
			return;
		}
		// 1.把要添加的数据放到节点中
		Node node = new Node(data);
		node.data=data;
		// 2.把节点链接到二叉树中
		// 是否有根节点
		if (root == null) {
			root = node;// 把该节点保存到根节点中去
		} else {
			// 如果跟节点不为空
			// 找父节点，比较字节与父节点的值，如果比父节点小放左边，如果比父节点大放右边
			// 从根节点开始查找
			Node parent = findParent(data, root);
			// 设置新增节点的父节点为查找到的节点
			node.parent = parent;
			// 把新增加的节点放在找到的父节点的左边还是右边还需要判断与父节点的大小
			if (compare(data, parent.data)) {
				// 如果比父节点大，放在父节点的右边
				parent.right = node;
			} else {
				parent.left = node;
			}
		}
	}
	/**
	 *
	 * @param data
	 *            传递的数据
	 * @param currentNode
	 *            从哪个节点开始查找 return ：返回的是父节点的值
	 */
	private Node findParent(Object data, Node currentNode) {
		// 从哪个节点开始查找
		Node temp = currentNode;
		Node parent = currentNode;
		while (temp != null) {
			// 把临时的节点复制给父节点
			parent = temp;
			// 比较待添加的数据和父节点的大小
			if (compare(data, temp.data)) {
				// 如果待添加的节点大于当前节点的话
				temp = temp.right;
			} else {
				// 小于当前的节点
				temp = temp.left;
			}
		}
		return parent;
	}
	/**
	 *
	 * @param o1
	 *            第一个值
	 * @param o2
	 *            第二个值
	 * @return 如果o1 > o2 返回结果为true，否则返回为false
	 */
	public boolean compare(Object o1, Object o2) {
		boolean res = false;
		// 判断o1有没有实现比较器
		if (o1 instanceof Comparable) {
			Comparable c1 = (Comparable) o1;
			Comparable c2 = (Comparable) o2;
			if (c1.compareTo(c2) > 0) {
				res = true;
			} else {
				// 默认值就是true
			}
		} else {
			// 没有实现比较器
			res = o1.toString().compareTo(o2.toString()) > 0 ? true : false;
		}
		return res;
	}
	/**
	 * <二>、二叉树的删除操作
	 *
	 * @param data：传入要删除的数据
	 */
	public void remove(Object data) {
		// 1.查找数据是否存在
		Node temp = find(data);
		// 2.如果存在：找到数据节点
		if (temp != null) {
			// 存在
			// 3.删除节点（1，待删除的节点为 根节点 和 非根节点）
			// 1.删除的节点是根节点：
			if (temp == root) {
				// 11.没有儿子
				if (temp.left == null && temp.right == null) {
					root = null;
				} else if (temp.right == null) {
					// 12.只有左儿子
					root = root.left;
					root.parent = null;
				} else if (temp.left == null) {
					// 13.只有右儿子
					root = root.right;
					root.parent = null;
				} else {
					// 14.两个儿子都有
					// 我们这里保留左儿子（也可以保留右儿子）
					Node left = getLeft(temp);
					root = left;
					root.parent = null;
				}
			} else {
				// 2.删除的节点是非根节点
				// 21.没有儿子(叶子节点)
				if (temp.left == null && temp.right == null) {
					if (compare(temp.data, temp.parent.data)) {
						// 在父节点的右边，右叶子节点
						temp.parent.right = null;
					} else {
						temp.parent.left = null;
					}
				} else if (temp.right == null) {
					// 22.只有左儿子
					if (compare(temp.data, temp.parent.data)) {
						// 删除的节点在父节点的右边
						temp.parent.right = temp.left;
						temp.left.parent = temp.parent;
					} else {
						// 在父节点左边
						temp.parent.left = temp.left;
						temp.left.parent = temp.parent;
					}
				} else if (temp.left == null) {
					// 23 只有右儿子
					if (compare(temp.data, temp.parent.data)) {
						// 在父节点右边
						temp.parent.right = temp.right;
						temp.right.parent = temp.parent;
					} else {
						// 在父节点左边
						temp.parent.left = temp.right;
						temp.right.parent = temp.parent;
					}
				} else {
					// 24.两个儿子都有
					Node left = getLeft(temp);
					// 上面还有父节点（爷爷节点）
					if (compare(left.data, temp.parent.data)) {
						// 比爷爷节点大
						temp.parent.right = left;
						left.parent = temp.parent;
					} else {
						// 比爷爷节点小
						temp.parent.left = left;
						left.parent = temp.parent;
					}
				}
			}
		}
	}
	/**
	 * <四> 更新数据
	 *
	 * @param oldData
	 *            老数据
	 * @param newData
	 *            新数据
	 */
	public void update(Object oldData, Object newData) {
		remove(oldData);
		add(newData);
	}
	/**
	 *
	 * @param node:
	 *            要删除的节点
	 * @return 返回的是左儿子节点
	 */
	private Node getLeft(Node node) {
		// 保留左儿子
		Node left = node.left;
		// 处理右节点
		// 寻找右节点的新的爹(从左节点开始找)
		Node rightNewParrent = findParent(node.right.data, left);
		rightNewParrent.right = node.right;
		node.right.parent = rightNewParrent;
		return left;
	}
	/**
	 * <三>、二叉树的查询 操作
	 *
	 * @param data
	 *            传入的数据
	 * @return 返回该数据的节点
	 */
	private Node find(Object data) {
		// 从跟节点开始查找
		Node temp = root;
		while (temp != null) {
			// 判断数据
			if (data.equals(temp.data) && data.hashCode() == temp.data.hashCode()) {
				// 找到了数据
				break;
			} else if (compare(data, temp.data)) {
				// 如果查找的数据比临时的数据大的话，从右边找
				temp = temp.right;
			} else {
				temp = temp.left;
			}
		}
		return temp;
	}
	/**
	 * 判断跟节点是否为空
	 *
	 * @return 返回根节点是否为空
	 */
	public boolean isEmpty() {
		return root == null;
	}
	// 树的高度
	public int height() {
		return height(root);
	}
	/**
	 * 计算二叉树节点的高度
	 *
	 * @param subTree
	 *            节点
	 * @return 节点高度
	 */
	private int height(Node subTree) {
		if (subTree == null)
			return 0;// 递归结束：空树高度为0
		else {
			int i = height(subTree.left);
			int j = height(subTree.right);
			return (i < j) ? (j + 1) : (i + 1);
		}
	}
	// 返回双亲结点
	public Node parent(Node element) {
		return (root == null || root == element) ? null : parent(root, element);
	}
	public Node parent(Node subTree, Node element) {
		if (subTree == null)
			return null;
		if (subTree.left == element || subTree.right == element)
			// 返回父结点地址
			return subTree;
		Node p;
		// 现在左子树中找，如果左子树中没有找到，才到右子树去找
		if ((p = parent(subTree.left, element)) != null)
			// 递归在左子树中搜索
			return p;
		else
			// 递归在右子树中搜索
			return parent(subTree.right, element);
	}
	/**
	 * 计算节点大小
	 *
	 * @param subTree
	 *            节点
	 * @return 节点大小
	 */
	private int size(Node subTree) {
		if (subTree == null) {
			return 0;
		} else {
			return 1 + size(subTree.left) + size(subTree.right);
		}
	}
	/**
	 * @param data
	 * @return 是否包含该数据
	 */
	public boolean contains(Object data) {
		return null != find(data);
	}
	// 在释放某个结点时，该结点的左右子树都已经释放，
	// 所以应该采用后续遍历，当访问某个结点时将该结点的存储空间释放
	public void destroy(Node subTree) {
		// 删除根为subTree的子树
		if (subTree != null) {
			// 删除左子树
			destroy(subTree.left);
			// 删除右子树
			destroy(subTree.right);
			// 删除根结点
			subTree = null;
		}
	}
	/**
	 * 递归打印数据
	 */
	public void traverse(Node subTree) {
		visted(subTree);
		if (subTree != null) {
			traverse(subTree.left);
			traverse(subTree.right);
		}
	}
	public Node getRoot() {
		return root;
	}
	// 前序遍历
	public void preOrder(Node subTree) {
		if (subTree != null) {
			visted(subTree);
			preOrder(subTree.left);
			preOrder(subTree.right);
		}
	}
	// 中序遍历
	public void inOrder(Node subTree) {
		if (subTree != null) {
			inOrder(subTree.left);
			visted(subTree);
			inOrder(subTree.right);
		}
	}
	// 后续遍历
	public void postOrder(Node subTree) {
		if (subTree != null) {
			postOrder(subTree.left);
			postOrder(subTree.right);
			visted(subTree);
		}
	}
	public void visted(Node subTree) {
		if(null!=subTree)
			System.out.println("--data:" + subTree.data);;
	}
}