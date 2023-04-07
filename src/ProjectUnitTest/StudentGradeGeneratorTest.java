package ProjectUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.BeforeEach;

import ProgramFunctions.StudentGradeGenerator;

import org.junit.jupiter.api.Test;

class StudentGradeGeneratorTest {

	/* Parse Input test */

	@Test
	void TestParseInput() {

		int iterator = 0;
//		Vector<StudentGradeGenerator.StudentInfo> expectedParseInputFunctionVectorOutput = 
//				new Vector<StudentGradeGenerator.StudentInfo>()
//		 {
//						new StudentGradeGenerator.StudentInfo("alaa mohamed","18017512",5,5,20,60),
//						new StudentGradeGenerator.StudentInfo("Maram Nabil","18017513",10,10,20,60)
//						
//		 };
		String path = new java.io.File("").getAbsolutePath();
		String[] InputFilePaths = new String[] { path + "\\ParseInput_FilesTest\\correctInput.txt",
				path + "\\ParseInput_FilesTest\\Line1Not3Values.txt",
				path + "\\ParseInput_FilesTest\\Line2Not6Values.txt",
				path + "\\ParseInput_FilesTest\\InvalidFilePath.txt" };

		boolean[] ParseInputExpectedReturn = new boolean[] { true, false, false, false };
		String[] ParseInputExpectedErrorSet = new String[] { "", 
				"First Line should contain exactly three values!",
				"Line Number (2) should contain exactly six values!",
				"Input path dosn't exist!" };
		
        
		for (var InputPath : InputFilePaths) {
			boolean actual = StudentGradeGenerator.ParseInput(InputPath);
			assertEquals(ParseInputExpectedReturn[iterator], actual,
					String.format("InputFilePath::%s => Error in::Returning in ParseInput Function", InputPath));
			assertEquals(ParseInputExpectedErrorSet[iterator],StudentGradeGenerator.getError(),
					String.format("InputFilePath::%s =>Error in::Error set in ParseInput Function", InputPath));
			iterator++;
		}

	}

	/* Mark validation test */
	@Test
	void TestOralMark() {
		int expectedIndex = 0;

		String[] MarkInputs = new String[] { "d10", "-10", "0", "5", "10", "15" };
		int[] exepected = new int[] { -1, -1, 0, 5, 10, -1 };

		String[] OralMarkExpectedErrorSet = new String[] {
				"Line (0): Oral Mark must be of type int!",
				"Line (0): Oral Mark must be a value between 0 and 10!",
				"",
				"",
				"",
				"Line (0): Oral Mark must be a value between 0 and 10!" };

		for (var mark : MarkInputs) {
			int actual = StudentGradeGenerator.ValidateMark("Oral Mark", mark, 10,4363532);
			assertEquals(exepected[expectedIndex], actual,
					String.format("mark::%s => Returning Error in validating Oral Mark Function", mark));
			assertEquals(OralMarkExpectedErrorSet[expectedIndex],StudentGradeGenerator.getError(), 
					String.format("mark::%s =>Error in::Error set in Oral Mark Function", mark));
			expectedIndex++;
		}

	}

      @Test 
      void TestMidtermMark() { 
      int expectedIndex = 0; 
      
      String[] MarkInputs =new String[] { "d20", "-10", "0", "15", "20", "25" };
      int[] exepected = new int[] { -1, -1, 0, 15, 20, -1 };
	 
	  String[] MidtermMarkExpectedErrorSet =new String[]{
	  "Line (0): Midterm Mark must be of type int!",
	  "Line (0): Midterm Mark must be a value between 0 and 20!", "", "", "",
	  "Line (0): Midterm Mark must be a value between 0 and 20!" };
	  
	  
	  for (var mark : MarkInputs) { int actual =
	  StudentGradeGenerator.ValidateMark("Midterm Mark", mark, 20,4363532);
	  assertEquals(exepected[expectedIndex], actual,String.
	  format("mark::%s => Returning Error in validating Midterm Mark Function",mark
	  ));
	  assertEquals(MidtermMarkExpectedErrorSet[
	  expectedIndex++],StudentGradeGenerator.getError(),String.
	  format("mark::%s =>Error in::Error set in Midterm Mark Function",mark)); 
	  }
	  
	  }
	 

	@Test
	void TestFinalMark() {
		int expectedIndex = 0;
		String[] MarkInputs = new String[] { "d20", "-10", "0", "55", "60", "70" };
		int[] exepected = new int[] { -1, -1, 0, 55, 60, -1 };

		String[] FinalMarkExpectedErrorSet = new String[] { "Line (0): Final Mark must be of type int!",
				"Line (0): Final Mark must be a value between 0 and 60!", "", "", "",
				"Line (0): Final Mark must be a value between 0 and 60!" };

		for (var mark : MarkInputs) {
			int actual = StudentGradeGenerator.ValidateMark("Final Mark", mark, 60,4363532);
			assertEquals(exepected[expectedIndex], actual,
					String.format("mark::%s => Returning Error in validating Final Mark Function", mark));
			assertEquals(FinalMarkExpectedErrorSet[expectedIndex],StudentGradeGenerator.getError(), String
					.format("mark::%s,index::%d =>Error in::Error set in Final Mark Function", mark, expectedIndex));
			expectedIndex++;
		}

	}
}