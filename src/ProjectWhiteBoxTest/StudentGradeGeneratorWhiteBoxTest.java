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

}
