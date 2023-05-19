package ProjectDataFlowTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ProgramFunctions.StudentGradeGenerator;

class StudentGradeGeneratorDataFlowTest {

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

	//All_Define_Use
	@Test
	void SubjectNameDefineUseTest() {
		String expected ="mathmatecis and physics";
		String actual =StudentGradeGenerator.SubjectName_Checker("mathmatecis and physics");
		
		assertEquals(expected,actual,"SubjectName::Error");
	}
	
	//All_Use
	@Test
	void testSubjectCode() {
		String[] subjectCodes = new String[] {"CSE411s", "123ECE"};
		String[] expected = new String[] {"CSE411s", ""};
		
		int i = 0;
		String actual;

		for (var code:subjectCodes) {
			actual = StudentGradeGenerator.SubjectCode_Checker(code);
			assertEquals(expected[i], actual, String.format("Student Number Error! \"" + code + "\" is an invalid student number."));
			i++;
		}
	}
}
