package Test.SlidingWindowMedian;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import ProblemImplementations.SlidingWindowMedian.*;

class SlidingWindowMedianTest {

	@Test
	void test() {
		int[] a = new int[] {1, 3, -1, -3, 5, 3, 6, 7};
		double[] expected = new double[] {1.0, -1.0, -1.0, 3.0, 5.0, 6.0};
		
		var ret = Soln0.medianSlidingWindow(a, 3);
		assertArrayEquals(expected, ret);
		
		a = new int[] {1,2,3,4,2,3,1,4,2};
		expected = new double[] {2.0, 3.0, 3.0, 3.0, 2.0, 3.0, 2.0};
		
		ret = Soln0.medianSlidingWindow(a, 3);
		assertArrayEquals(expected, ret);
		
		a = new int[] {1,2,3,4};
		expected = new double[] {2.5};
		
		ret = Soln0.medianSlidingWindow(a, 4);
		assertArrayEquals(expected, ret);
	}

}
