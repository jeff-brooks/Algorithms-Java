package Test.ProblemImplemenations;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import DataStructures.Node.*;
import ProblemImplementations.SwappingNodesInALinkedList.*;

class SwappingNodesInALinkedListTest {

	@Test
	void test() {
		ListNode n5 = new ListNode(5);
		ListNode n4 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n2 = new ListNode(2);
		ListNode n1 = new ListNode(1);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		ListNode e5 = new ListNode(5);
		ListNode e4 = new ListNode(4);
		ListNode e3 = new ListNode(3);
		ListNode e2 = new ListNode(2);
		ListNode e1 = new ListNode(1);
		
		e1.next = e4;
		e4.next = e3;
		e3.next = e2;
		e2.next = e5;
		
		var t = Solution.swapNodes(n1,  2);
		
		assertEquals(e1.val, t.val);
		assertEquals(e1.next.val, t.next.val);
		assertEquals(e1.next.next.val, t.next.next.val);
		assertEquals(e1.next.next.next.val, t.next.next.next.val);
		assertEquals(e1.next.next.next.next.val, t.next.next.next.next.val);
		assertNull(t.next.next.next.next.next);
		
		n1 = new ListNode(100);
		n2 = new ListNode(90);
		
		n1.next = n2;
		
		e1 = new ListNode(90);
		e2 = new ListNode(100);
		
		e1.next = e2;
		
		t = Solution.swapNodes(n1,  2);
		
		assertEquals(e1.val, t.val);
		assertEquals(e1.next.val, t.next.val);
		assertNull(t.next.next);
		
		n1 = new ListNode(1);
		
		e1 = new ListNode(1);
		
		t = Solution.swapNodes(n1,  1);
		
		assertEquals(e1.val, t.val);
		assertNull(t.next);
	}

}
