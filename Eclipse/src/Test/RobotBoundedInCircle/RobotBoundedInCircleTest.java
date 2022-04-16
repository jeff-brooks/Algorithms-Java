package Test.RobotBoundedInCircle;

import static org.junit.jupiter.api.Assertions.*;

import ProblemImplemenations.RobotBoundedInCircle.*;

import org.junit.jupiter.api.Test;

class RobotBoundedInCircleTest {

	@Test
	void test() {
		String[] sTrue = {"GGLLGG", "GL"};
		String[] sFalse = {"GG"};
		
		for(int i = 0; i < sTrue.length; i++) {
			assertTrue(Soln0.isRobotBounded(sTrue[i]));
		}
		for(int j = 0; j < sFalse.length; j++) {
			assertFalse(Soln0.isRobotBounded(sFalse[j]));
		}
	}
}
