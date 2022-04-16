package DataStructures.Table;

import DataStructures.Tree.BinarySearchTree;
import DataStructures.Tree.KeyedItem;
import DataStructures.Table.ITable;

public class BinarySearchTable<t extends KeyedItem<kt>
	, kt extends Comparable<? super kt>> implements ITable<t, kt>
{
	protected BinarySearchTree<t, kt> bst;
	protected int size;
	
	public BinarySearchTable() {
		bst = new BinarySearchTree<t, kt>();
		size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int length() {
		return size;
	}
	
	public void insert(t newItem) throws RuntimeException{
		if(bst.retrieve(newItem.getKey()) == null) {
			bst.insert(newItem);
			size++;
			return;
		}
		
		throw new RuntimeException("Key already exists in collection");
	}
	
	public t retrieve(kt key) {
		return bst.retrieve(key);
	}
	
	public boolean delete(kt key) {
		try {
			bst.delete(key);
		}
		catch(RuntimeException ex) {
			return false;
		}
		size--;
		return true;
	}
}






























