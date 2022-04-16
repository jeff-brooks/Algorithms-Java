package Test.Tree;

import static org.junit.jupiter.api.Assertions.*;
import DataStructures.Tree.*;
import org.junit.jupiter.api.Test;

class TreeIteratorTest {
	
	/*
	 * 			60
	 * 		   /  \
	 * 		  20  70
	 * 		 /  \
	 *      10  40
	 *         /  \
 	 * 		  30  50
	 */
	@Test
	void test() {
		var tree1 = new BinaryTree<Integer>();
		tree1.setRootItem(40);
		tree1.attachLeft(30);
		tree1.attachRight(50);
		
		var tree2 = new BinaryTree<Integer>();
		tree2.setRootItem(20);
		tree2.attachLeft(10);
		tree2.attachRightSubtree(tree1);
		
		
		var tree3 = new BinaryTree<Integer>(70);
		
		var binTree = new BinaryTree<Integer>(60, tree2, tree3);
		
		var iterator = new TreeIterator<Integer>(binTree);
		iterator.setInorder();
		
		assertEquals(10,  iterator.next());
		assertEquals(20,  iterator.next());
		assertEquals(30,  iterator.next());
		assertEquals(40,  iterator.next());
		assertEquals(50,  iterator.next());
		assertEquals(60,  iterator.next());
		assertEquals(70,  iterator.next());
		
		iterator.setPostOrder();
		
		assertEquals(10,  iterator.next());
		assertEquals(30,  iterator.next());
		assertEquals(50,  iterator.next());
		assertEquals(40,  iterator.next());
		assertEquals(20,  iterator.next());
		assertEquals(70,  iterator.next());
		assertEquals(60,  iterator.next());
		
		iterator.setPreorder();
		
		assertEquals(60,  iterator.next());
		assertEquals(20,  iterator.next());
		assertEquals(10,  iterator.next());
		assertEquals(40,  iterator.next());
		assertEquals(30,  iterator.next());
		assertEquals(50,  iterator.next());
		assertEquals(70,  iterator.next());
		
		//fail("Not yet implemented");
	}

}
