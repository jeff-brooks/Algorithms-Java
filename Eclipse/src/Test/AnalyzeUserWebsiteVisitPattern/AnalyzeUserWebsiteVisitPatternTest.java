package Test.AnalyzeUserWebsiteVisitPattern;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ProblemImplementations.AnalyzeUserWebsiteVisitPattern.*;

class AnalyzeUserWebsiteVisitPatternTest {

	@Test
	void test() {
		String[] user = new String[] {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
		int[] time = new int[] {1,2,3,4,5,6,7,8,9,10};
		String[] site = new String[] {"home","about","career","home","cart","maps","home","home","about","career"};
		
		var soln = new Soln1();
		List<String> result;
		List<String> expected;
//		result = soln.mostVisitedPattern(user, time, site);
//		
//		expected = new ArrayList<String>();
//		expected.add("home");
//		expected.add("about");
//		expected.add("career");
//		assertArrayEquals(expected.toArray(), result.toArray());
//		
//		user = new String[] {"ua","ua","ua","ub","ub","ub"};
//		time = new int[] {1,2,3,4,5,6};
//		site = new String[] {"a","b","a","a","b","c"};
//		
//		result = soln.mostVisitedPattern(user, time, site);
//		
//		expected = new ArrayList<String>();
//		expected.add("a");
//		expected.add("b");
//		expected.add("a");
//		assertArrayEquals(expected.toArray(), result.toArray());
//		
//		user = new String[] {"dowg","dowg","dowg"};
//		time = new int[] {158931262,562600350,148438945};
//		site = new String[] {"y","loedo","y"};
//		
//		result = soln.mostVisitedPattern(user, time, site);
//		
//		expected = new ArrayList<String>();
//		expected.add("y");
//		expected.add("y");
//		expected.add("loedo");
//		assertArrayEquals(expected.toArray(), result.toArray());
		
		user = new String[] {"h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"};
		time = new int[] {527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,926837079,317455832,411747930};
		site = new String[] {"hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw"};
		
		result = soln.mostVisitedPattern(user, time, site);
		
		expected = new ArrayList<String>();
		expected.add("hibympufi");
		expected.add("hibympufi");
		expected.add("yljmntrclw");
		assertArrayEquals(expected.toArray(), result.toArray());
	}

}
