package DataStructures.Tree;

public class BinaryTree<T> extends AbstractBinaryTree<T> {
	
	public BinaryTree() {}
	
	public BinaryTree(T rootItem) {
		super(rootItem);
	}
	
	public BinaryTree(T rootItem, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		root = new TreeNode<T>(rootItem, null, null);
		attachLeftSubtree(leftTree);
		attachRightSubtree(rightTree);
	}
	
	protected BinaryTree(TreeNode<T> rootNode) {
		root = rootNode;
	}
	
	public void setRootItem(T newItem) {
		if(root != null) {
			root.setItem(newItem);
		}
		else {
			root = new TreeNode<T>(newItem, null, null);
		}
	}
	
	public void attachLeft(T newItem) {
		if(!isEmpty() && root.getLeft() == null) {
			root.setLeft(new TreeNode<T>(newItem, null, null));
		}
	}
	
	public void attachRight(T newItem) {
		if(!isEmpty() && root.getRight() == null) {
			root.setRight(new TreeNode<T>(newItem, null, null));
		}
	}
	
	public void attachLeftSubtree(BinaryTree<T> leftTree) throws RuntimeException {
		if(isEmpty()) {
			throw new RuntimeException("Empty tree");
		}
		if(root.getLeft() != null) {
			throw new RuntimeException("Cannot overwrite left subtree");
		}
		root.setLeft(leftTree.root);
		leftTree.makeEmpty();
	}
	
	public void attachRightSubtree(BinaryTree<T> rightTree) throws RuntimeException{
		if(isEmpty()) {
			throw new RuntimeException("Empty tree");
		}
		if(root.getRight() != null) {
			throw new RuntimeException("Cannot overwrite right subtree");
		}
		root.setRight(rightTree.root);
		rightTree.makeEmpty();
	}
	
	public BinaryTree<T> detachLeftSubtree() throws RuntimeException {
		if(isEmpty()) {
			throw new RuntimeException("Empty tree");
		}
		BinaryTree<T> leftTree = new BinaryTree<T>(root.getLeft());
		root.setLeft(null);
		return leftTree;
	}
	
	public BinaryTree<T> detachRightSubtree() throws RuntimeException {
		if(isEmpty()) {
			throw new RuntimeException("Empty tree");
		}
		var rightTree = new BinaryTree<T>(root.getRight());
		root.setRight(null);
		return rightTree;
	}
}
