package DataStructures.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeIterator<t> implements java.util.Iterator<t> {
	private AbstractBinaryTree<t> binTree;
	private TreeNode<t> currentNode;
	private Queue<TreeNode<t>> queue;
	
	public TreeIterator(AbstractBinaryTree<t> bTree) {
		binTree = bTree;
		currentNode = null;
		queue = new LinkedList<TreeNode<t>>();
	}
	
	public boolean hasNext() {
		return !queue.isEmpty();
	}
	
	public t next() throws java.util.NoSuchElementException {
		currentNode = queue.remove();
		return currentNode.getItem();
	}
	
	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	public void setPreorder() {
		queue.clear();
		preorder(binTree.root);
	}
	
	public void setInorder() {
		queue.clear();
		inorder(binTree.root);
	}
	
	public void setPostOrder() {
		queue.clear();
		postorder(binTree.root);
	}
	
	private void preorder(TreeNode<t> treeNode) {
		if(treeNode != null) {
			queue.add(treeNode);
			preorder(treeNode.getLeft());
			preorder(treeNode.getRight());
		}
	}
	
	private void inorder(TreeNode<t> treeNode) {
		if(treeNode != null) {
			inorder(treeNode.getLeft());
			queue.add(treeNode);
			inorder(treeNode.getRight());
		}
	}
	
	private void postorder(TreeNode<t> treeNode) {
		if(treeNode != null) {
			postorder(treeNode.getLeft());
			postorder(treeNode.getRight());
			queue.add(treeNode);
		}
	}
}
