package ProjectWhiteBoxTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ProgramFunctions.StudentGradeGenerator;

class StudentGradeGeneratorWhiteBoxTest {

	/* Parse Input test */
	@BeforeEach
	void InitializingCommonVariablesBeforeAnyTesting()
	{
		StudentGradeGenerator.InitializeAllVariables(4363532);
	}


	//Condition Coverage
	@Test
	void FullMarkCheckerConditionCoverage() {

		int actual=0;
		int i=0; 
		String[] MarksInput = new String[] {"100","90"};
		int[] expected = new int[] {100,-1};

		for (var mark:MarksInput)
		{
			actual =StudentGradeGenerator.FullMark_Checker(mark);
			assertEquals(expected[i],actual,"SubjectName::Error");
			i++;
		}

	}

	//Statement Coverage
	/* Student Name test */
	@Test
	void testStudentName() {
		String[] actualStudentNames = new String[] {"Maram nabil", " Alaa Mohamed"}; 
		String[] expected = new String[] {"Maram nabil", ""};

		int i = 0;
		String actual;

		for (var name:actualStudentNames) {
			actual = StudentGradeGenerator.validateStudentName(name);
			assertEquals(expected[i], actual, String.format("Student Name Error! \"" + name + "\" is an invalid student name."));
			i++;
		}
	}

	//Branch & Decision Coverage
	@Test
	void isFinalMarkValidatingCorrectlyTest() {
		int expectedIndex = 0;
		String[] MarkInputs = new String[] { "d20", "-10", "0", "55", "60", "70" };
		int[] expected = new int[] { -1, -1, 0, 55, 60, -1 };

		String[] FinalMarkExpectedErrorSet = new String[] { "Line (0): Final Mark must be of type int!",
				"Line (0): Final Mark must be a value between 0 and 60!", "", "", "",
		"Line (0): Final Mark must be a value between 0 and 60!" };

		// check for isTesting variable
		assertEquals(32, StudentGradeGenerator.ValidateMark("Final Mark", "32", 60,1),
				String.format("mark::%s => Returning Error in validating Final Mark Function", "32"));

		// check for valid and invalid input mark values
		for (var mark : MarkInputs) {
			int actual = StudentGradeGenerator.ValidateMark("Final Mark", mark, 60,4363532);
			assertEquals(expected[expectedIndex], actual,
					String.format("mark::%s => Returning Error in validating Final Mark Function", mark));
			assertEquals(FinalMarkExpectedErrorSet[expectedIndex],StudentGradeGenerator.getError(), String
					.format("mark::%s,index::%d =>Error in::Error set in Final Mark Function", mark, expectedIndex));
			expectedIndex++;
		}
	}
	
	//Basis Path Coverage
	/* Student Number test */
	@Test
	void testStudentNumber() {
		String[] studentNumbers = new String[] {"18037464", "45687", "123456gg", ""};
		int[] expected = new int[] {0, -1, -1, -1};
		
		int i = 0;
		int actual;

		for (var number:studentNumbers) {
			actual = StudentGradeGenerator.validateStudentNumber(number);
			assertEquals(expected[i], actual, String.format("Student Number Error! \"" + number + "\" is an invalid student number."));
			i++;
		}
	}
	
	
	
}
