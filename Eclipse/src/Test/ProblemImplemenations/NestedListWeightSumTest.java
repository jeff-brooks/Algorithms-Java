package Test.ProblemImplemenations;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import ProblemImplementations.NestedListWeightSum.*;

class NestedListWeightSumTest {

	@Test
	void test1() {
		List<NestedInteger> niList = new ArrayList<NestedInteger>();
		var v1 = new NestedInteger();
		v1.add(new NestedInteger(1));
		v1.add(new NestedInteger(1));
		niList.add(v1);
		
		niList.add(new NestedInteger(2));
		
		var v2 = new NestedInteger();
		v2.add(new NestedInteger(1));
		v2.add(new NestedInteger(1));
		niList.add(v2);
		
		var value = new Solution().depthSumInverse(niList);
		
		assertEquals(8, value);
	}
	
	@Test
	void test2() {
		List<NestedInteger> niList = new ArrayList<NestedInteger>();
		var v1 = new NestedInteger(1);
		niList.add(v1);
		
		var v2 = new NestedInteger();
		v2.add(new NestedInteger(4));
		
		var v3 = new NestedInteger();
		v3.add(new NestedInteger(6));
		
		v2.add(v3);
		
		niList.add(v2);
		
		var value = new Solution().depthSumInverse(niList);
		
		assertEquals(17, value);
	}
}
