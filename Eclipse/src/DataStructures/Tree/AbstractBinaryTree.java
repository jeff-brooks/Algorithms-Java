package DataStructures.Tree;

public abstract class AbstractBinaryTree<T> {
	protected TreeNode<T> root;
	
	public AbstractBinaryTree() {
		root = null;
	}
	
	public AbstractBinaryTree(T rootItem) {
		root = new TreeNode<T>(rootItem, null, null);
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void makeEmpty() {
		root = null;
	}
	
	public T getRootItem() throws RuntimeException {
		if(root == null) {
			throw new RuntimeException("Empty tree");
		}
		return root.getItem();
	}
	
	public abstract void setRootItem(T newItem);
}
