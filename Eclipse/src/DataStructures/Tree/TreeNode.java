package DataStructures.Tree;

public class TreeNode<T> {
	private T item;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;
	
	public TreeNode(T newItem) {
		item = newItem;
		leftChild = null;
		rightChild = null;
	}
	
	public TreeNode(T newItem, TreeNode<T> left, TreeNode<T> right) {
		item = newItem;
		leftChild = left;
		rightChild = right;
	}
	
	public T getItem() {
		return item;
	}
	
	public void setItem(T newItem) {
		item = newItem;
	}
	
	public TreeNode<T> getLeft() {
		return leftChild;
	}
	
	public void setLeft(TreeNode<T> newLeft) {
		leftChild = newLeft;
	}
	
	public TreeNode<T> getRight() {
		return rightChild;
	}
	
	public void setRight(TreeNode<T> newRight) {
		rightChild = newRight;
	}
	
	
}
