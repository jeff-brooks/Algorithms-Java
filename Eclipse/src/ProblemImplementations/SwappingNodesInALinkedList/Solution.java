package ProblemImplementations.SwappingNodesInALinkedList;

import java.util.ArrayList;

import DataStructures.Node.*;

public class Solution {
	public static ListNode swapNodes(ListNode head, int k) {
		if(head == null) {
			return head;
		}
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		while(head != null) {
			arrayList.add(head.val);
			head = head.next;
		}
		
		if(k > arrayList.size()) {
			throw new RuntimeException("k is greater than the size of the list");
		}
		
		int moveUpToIndex = arrayList.size() - k;
		Integer temp = arrayList.get(moveUpToIndex);
		arrayList.set(moveUpToIndex,  arrayList.get(k - 1));
		arrayList.set(k - 1, temp);
		
		head = new ListNode();
		var pointer = head;
		
		for(int i = 0; i < arrayList.size(); i++) {
			pointer.val = arrayList.get(i);
			if(i < arrayList.size() - 1) {
				pointer.next = new ListNode(arrayList.get(i + 1));
				pointer = pointer.next;
			}
		}
		
		return head;
	}
}
