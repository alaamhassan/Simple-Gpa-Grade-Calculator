package ProjectUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Vector;

import org.junit.jupiter.api.BeforeEach;

import ProgramFunctions.StudentGradeGenerator;

import org.junit.jupiter.api.Test;

class StudentGradeGeneratorTest {

	/*this function in only used to compare between two
	 * studentInfo objects,
	 * if they are equal return true
	 * else return false
	 * as java dosn't support equal overloading operator (as far as I know.)
	 * this function is used.
	 */
	private String isTheTwoStudentInfoEqual(StudentGradeGenerator.StudentInfo expectedStudentInfo,
			StudentGradeGenerator.StudentInfo actualStudentInfo)
	{

        	if(!expectedStudentInfo.StudentName.equals(actualStudentInfo.StudentName))
        	{
        		return "StudentName";
        	}
        	if(!expectedStudentInfo.StudentNumber.equals(actualStudentInfo.StudentNumber))
        	{
        		return "StudentNumber";
        	}
        	if(expectedStudentInfo.StudentActivitiesMark!=actualStudentInfo.StudentActivitiesMark)
        	{
        		return "StudentActivitiesMark";
        	}
        	if(expectedStudentInfo.OralMark!=actualStudentInfo.OralMark)
        	{
        		return "OralMark";
        	}
        	if(expectedStudentInfo.MidtermExamMark!=actualStudentInfo.MidtermExamMark)
        	{
        		return "MidtermExamMark";
        	}
        	if(expectedStudentInfo.FinalExamMark!=actualStudentInfo.FinalExamMark)
        	{
        		return "FinalExamMark";
        	}
        	
            return "";
            
	}
	
	
	
	
	/* Parse Input test */
	@BeforeEach
	void InitializingCommonVariablesBeforeAnyTesting()
	{
		StudentGradeGenerator.InitializeAllVariables(4363532);
	}
	
	@Test 
	void isParseInputParsingCorrectlyTest()
	{
		int iterator=0;
		String WrongAttribute="";
		String InputFilepath = new java.io.File("").getAbsolutePath()+"\\ParseInput_FilesTest\\correctInput.txt";
		StudentGradeGenerator.ParseInput(InputFilepath);
		Vector<StudentGradeGenerator.StudentInfo> actualParseInputFunctionVectorOutput =StudentGradeGenerator.getVectorStudentInfo();
		
		Vector<StudentGradeGenerator.StudentInfo> expectedParseInputFunctionVectorOutput = 
				new Vector<StudentGradeGenerator.StudentInfo>
		 (
				 Arrays.asList(
					new StudentGradeGenerator.StudentInfo("alaa mohamed","18017512",5,5,20,60),
					new StudentGradeGenerator.StudentInfo("Maram Nabil","18017513",10,10,20,60)	 			 
	                )					
		 );
		
		String expectedSubjectName="SOFTWARE Testing",expectedSubjectCode="CSE123s";
		int expectedFullMark=100; 
		
		
		assertEquals(expectedSubjectName,StudentGradeGenerator.getSubjectName() ,
				String.format("InputFilePath::%s => Error in::Parsing SubjectName in ParseInput Function", InputFilepath));
		
		assertEquals(expectedSubjectCode,StudentGradeGenerator.getSubjectCode(),
				String.format("InputFilePath::%s => Error in::Parsing SubjectCode in ParseInput Function", InputFilepath));
		
		assertEquals(expectedFullMark,StudentGradeGenerator.getFullMark(),
				String.format("InputFilePath::%s => Error in::Parsing FullMark in ParseInput Function", InputFilepath));
		
		
		assertTrue(actualParseInputFunctionVectorOutput.size()==expectedParseInputFunctionVectorOutput.size(),
				String.format("InputFilePath::%s => Error in::Parsing studentInfor in ParseInput Function, the two vectors is not with"
						+ "the same size.", InputFilepath));
		
		for(var studentInfo: actualParseInputFunctionVectorOutput)
		{
			WrongAttribute=isTheTwoStudentInfoEqual(studentInfo,expectedParseInputFunctionVectorOutput.elementAt(iterator++));
			assertEquals("",WrongAttribute,
					String.format("InputFilePath::%s => Error in::Parsing in ParseInput Function, %s attribute in line (%d) didn't parse"
							+ " correctly", InputFilepath,WrongAttribute,iterator));

		}

	}
	
	
	@Test
	void isParseInputValidatingCorrectlyTest() {

		int iterator = 0;

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
	void isOralMarkValidatingCorrectlyTest() {
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
      void isMidtermMarkValidatingCorrectlyTest() { 
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
	void isFinalMarkValidatingCorrectlyTest() {
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
	
	
	@Test
	void test_white_space_initial() {
		String expected ="";
		String actual =StudentGradeGenerator.SubjectName_Checker(" mathmatecis");
		if(actual!=expected) {
			fail("no white space allowed at beginning");
		}
		
	}
	@Test
	void test_onlyAlphabets() {
		String expected ="";
		String actual =StudentGradeGenerator.SubjectName_Checker("mathmatecis33andphysics");
		if(actual!=expected) {
			fail("only alphabets & spaces");
		}
		
	}
	
	@Test
	void test_white_spaces_allowed() {
		String expected ="mathmatecis and physics";
		String actual =StudentGradeGenerator.SubjectName_Checker("mathmatecis and physics");
		if(actual!=expected) {
			fail("no white space allowed at beginning");
		}
		
	}
	
	/* Student Name test */
	@Test
	void testStudentName() {
		String[] studentNames = new String[] {"Maram nabil", " Alaa Mohamed", "1Eman", "Mariam_Ezzat", "MAYAR", "Menna5", "  ", ""}; 
		String studentNameTest = studentNames[0];
		
		assertNotEquals("", StudentGradeGenerator.validateStudentName(studentNameTest), String.format("Student Name Error! \"" + studentNameTest + "\" is an invalid student name."));
	}
	
	/* Student Number test */
	@Test
	void testStudentNumber() {
		String[] studentNumbers = new String[] {"18037464", "45687", "174862447", "123456gg", "", " 47", "1234756j", "e"};
		String studentNumberTest = studentNumbers[0];
		
		assertEquals(0, StudentGradeGenerator.validateStudentNumber(studentNumberTest), String.format("Student Number Error! \"" + studentNumberTest + "\" is an invalid student number."));
	}
	
	/* Student activities mark test */
	@Test
	void testStudentActivitiesMark() {
		String[] studentActivitiesMarks = new String[] {"0", "10", "12", "4", "-7", "9", "", " "};
		String studentActivitiesMarkTest = studentActivitiesMarks[0];
		assertNotEquals(-1, StudentGradeGenerator.ValidateMark("Student Activities Mark", studentActivitiesMarkTest, 10, 0), String.format("Student Activities Mark Error! \"" + studentActivitiesMarkTest + "\" is an invalid student activities mark."));
	}
}
