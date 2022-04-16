package Test.ReorderDataInLogFiles;

import static org.junit.jupiter.api.Assertions.*;
import ProblemImplementations.ReorderDataInLogFiles.*;

import org.junit.jupiter.api.Test;

class ReorderDataInLogFilesTest {

	@Test
	void test() {
		String[] input = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
		String[] expected = {"let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"};
		
		assertArrayEquals(expected, Soln0.reorderLogFiles(input));
		
		String[] i1 = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
		String[] e1 = {"g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"};
		
		assertArrayEquals(e1,  Soln0.reorderLogFiles(i1));
		
		String[] i2 = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
		String[] e2 = {"a2 act car","g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"};
		
		assertArrayEquals(e2,  Soln0.reorderLogFiles(i2));
	}

}
