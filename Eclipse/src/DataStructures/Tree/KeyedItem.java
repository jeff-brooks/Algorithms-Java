package DataStructures.Tree;

public abstract class KeyedItem<kt extends Comparable<?super kt>> {
	private kt searchKey;
	
	public KeyedItem(kt key) {
		searchKey = key;
	}
	
	public kt getKey() {
		return searchKey;
	}
}
