package DataStructures.PriorityQueue;

import java.util.Comparator;

public class PriorityQueue<t> {
	private Heap<t> h;
	
	public PriorityQueue() {
		h = new Heap<t>();
	}
	
	public PriorityQueue(Comparator<? super t> comparator) {
		h = new Heap<t>(comparator);
	}

	public boolean isEmpty() {
		return h.isEmpty();
	}
	
	public void insert(t newItem) throws RuntimeException {
		try {
			h.insert(newItem);
		}
		catch (RuntimeException ex) {
			throw ex;
		}
	}
	
	public t delete() {
		return h.delete();
	}
}
