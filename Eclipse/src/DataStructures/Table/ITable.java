package DataStructures.Table;

import DataStructures.Tree.KeyedItem;

public interface ITable<t extends KeyedItem<kt>, kt extends Comparable <? super kt>> {
	public boolean isEmpty();
	public int length();
	public void insert(t newItem);
	public boolean delete(kt key);
	public KeyedItem<kt> retrieve(kt key);
}
