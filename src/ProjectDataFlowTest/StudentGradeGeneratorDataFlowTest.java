package ProjectDataFlowTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ProgramFunctions.StudentGradeGenerator;

class StudentGradeGeneratorDataFlowTest {

	/* Parse Input test */
	@BeforeEach
	void InitializingCommonVariablesBeforeAnyTesting()
	{
		StudentGradeGenerator.InitializeAllVariables(4363532);
	}
	
	
	@Test
	void isParseInputValidatingCorrectlyTest() {

		String path = new java.io.File("").getAbsolutePath();
		
		String InputPath=path + "\\ParseInput_FilesTest\\correctInput.txt";
	    
		boolean actual = StudentGradeGenerator.ParseInput(InputPath);
		assertEquals(true, actual,
				String.format("InputFilePath::%s => Error in::Returning in ParseInput Function", InputPath));
		assertEquals("",StudentGradeGenerator.getError(),
				String.format("InputFilePath::%s =>Error in::Error set in ParseInput Function", InputPath));
	
	}
	


}
