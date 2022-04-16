package DataStructures.Tree;

public class BinarySearchTree<t extends KeyedItem<kt>, kt extends Comparable<? super kt>> extends AbstractBinaryTree<t> {
	
	public BinarySearchTree() {}
	
	public BinarySearchTree(t rootItem) {
		super(rootItem);
	}
	
	public void setRootItem(t newItem) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	public void insert(t newItem) {
		root = insertItem(root, newItem);
	}
	
	public t retrieve(kt searchKey) {
		return retrieveItem(root, searchKey);
	}
	
	public void delete(kt searchKey) throws RuntimeException {
		root = deleteItem(root, searchKey);
	}
	
	public void delete(t item) throws RuntimeException {
		root = deleteItem(root, item.getKey());
	}
	
	protected TreeNode<t> insertItem(TreeNode<t> tNode, t newItem){
		TreeNode<t> newSubtree;
		
		if(tNode == null) {
			tNode = new TreeNode<t>(newItem, null, null);
			return tNode;
		}
		
		t nodeItem = tNode.getItem();
		
		if(newItem.getKey().compareTo(nodeItem.getKey()) < 0) {
			newSubtree = insertItem(tNode.getLeft(), newItem);
			tNode.setLeft(newSubtree);
			return tNode;
		}
		
		newSubtree = insertItem(tNode.getRight(), newItem);
		tNode.setRight(newSubtree);
		return tNode;
	}
	
	protected t retrieveItem(TreeNode<t> tNode, kt searchKey) {
		if(tNode == null) {
			return null;
		}
		
		t nodeItem = tNode.getItem();
		if(searchKey.compareTo(nodeItem.getKey()) == 0) {
			return tNode.getItem();
		}
		
		if(searchKey.compareTo(nodeItem.getKey()) < 0 ) {
			return retrieveItem(tNode.getLeft(), searchKey);
		}
		
		return retrieveItem(tNode.getRight(), searchKey);
	}
	
	protected TreeNode<t> deleteItem(TreeNode<t> tNode, kt searchKey){
		TreeNode<t> newSubtree;
		
		if(tNode == null) {
			throw new RuntimeException("item not found");
		}
		
		t nodeItem = tNode.getItem();
		if(searchKey.compareTo(nodeItem.getKey()) == 0) {
			tNode = deleteNode(tNode);
			return tNode;
		}
		if(searchKey.compareTo(nodeItem.getKey()) < 0) {
			newSubtree = deleteItem(tNode.getLeft(), searchKey);
			tNode.setLeft(newSubtree);
			return tNode;
		}
		
		newSubtree = deleteItem(tNode.getRight(), searchKey);
		tNode.setRight(newSubtree);
		return tNode;
	}
	
	protected TreeNode<t> deleteNode(TreeNode<t> tNode){
		//test for leaf
		if( (tNode.getLeft() == null) && (tNode.getRight() == null)) {
			return null;
		}
		
		//test for no left child
		if(tNode.getLeft() == null) {
			return tNode.getRight();
		}
		
		//test for no right child
		if(tNode.getRight() ==  null) {
			return tNode.getLeft();
		}
		
		//there are two children - retrieve and delete inorder successor
		t replacementItem = findLeftmost(tNode.getRight());
		tNode.setItem(replacementItem);
		tNode.setRight(deleteLeftmost(tNode.getRight()));
		return tNode;
	}
	
	protected t findLeftmost(TreeNode<t> tNode) {
		if(tNode.getLeft() == null) {
			return tNode.getItem();
		}
		return findLeftmost(tNode.getLeft());
	}
	
	protected TreeNode<t> deleteLeftmost(TreeNode<t> tNode){
		if(tNode.getLeft() == null) {
			return tNode.getRight();
		}
		
		tNode.setLeft(deleteLeftmost(tNode.getLeft()));
		return tNode;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
