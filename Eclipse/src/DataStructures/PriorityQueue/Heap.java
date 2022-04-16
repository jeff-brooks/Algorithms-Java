package DataStructures.PriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;

public class Heap<t> {
	private ArrayList<t> items;
	private Comparator<? super t> comparator;
	
	public Heap() {
		items = new ArrayList<t>();
	}
	
	public Heap(Comparator<? super t> comparator) {
		this();
		this.comparator = comparator;
	}
	
	public boolean isEmpty() {
		return items.isEmpty();
	}
	
	public void insert(t newItem) {
		if(!items.add(newItem)) {
			throw new RuntimeException("insert failed");
		}
		
		int indexNewItem = items.size() - 1;
		int indexParent = (indexNewItem - 1) / 2;
		while((indexParent >= 0 ) && (compareItems(items.get(indexNewItem), items.get(indexParent))) < 0) {
			t temp = items.get(indexParent);
			items.set(indexParent,  items.get(indexNewItem));
			items.set(indexNewItem,  temp);
			
			indexNewItem = indexParent;
			indexParent = (indexNewItem - 1) / 2;
		}
	}
	
	public t delete() {
		
		if(isEmpty()) {
			return null;
		}
		
		t rootItem = items.get(0);
		int lastIndex = items.size() - 1;
		items.set(0,  items.get(lastIndex));
		items.remove(lastIndex);
		heapRebuild(0);
		
		return rootItem;
	}
	
	protected void heapRebuild(int root) {
		int childIndex = 2 * root + 1;
		if( childIndex < items.size()) {
			int rightChildIndex = childIndex + 1;
			
			if((rightChildIndex < items.size()) &&
					(compareItems(items.get(rightChildIndex), items.get(childIndex))) < 0) {
				childIndex = rightChildIndex;
			}
			
			if(compareItems(items.get(root), items.get(childIndex)) > 0) {
				t temp = items.get(root);
				items.set(root,  items.get(childIndex));
				items.set(childIndex,  temp);
				heapRebuild(childIndex);
			}
		}
	}
	
	private int compareItems(t item1, t item2) {
		if(comparator == null) {
			return ((Comparable<t>) item1).compareTo(item2);
		}
		return comparator.compare(item1, item2);
	}
}






























