package BlackBoxTest;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ProgramFunctions.StudentGradeGenerator;
import ProgramFunctions.StudentGradeGenerator.StudentInfo;

class BlackBox {
	/***************************************************
	 * Boundary Value Analysis
	 ***************************************************/
	private static StudentInfo s1;
	private static Vector<StudentInfo> StudentsInfo;
	@BeforeEach
	void Initialization() {
		StudentsInfo=new Vector<>() ;
		s1 = new StudentInfo();
		}
	/****************************************************
	 * InValid Test Case for A+ [97,100] 
	 * just below the minimum value
	 ***************************************************/
	@Test
	void test_Boundaries_1() {
		

		/************************************************
		 * update student 1 info to be total marks=96
		 ************************************************
		 */
		s1.OralMark=10;
		s1.MidtermExamMark=20;
		s1.FinalExamMark=60;
		s1.StudentActivitiesMark=6;

		
		StudentsInfo.add(s1);
	

		StudentGradeGenerator.SetVectorStudentInfo(StudentsInfo);
		StudentsInfo=StudentGradeGenerator.gradeAndGPACalculator();
	

		assertEquals("A+",s1.Grade,"FALSE GRADE in Boundries testCase");
		assertEquals(4,s1.GPA,"FALSE GPA in Boundries testCase");
	}
	
	/****************************************************
	 * Valid Test Case for A+ [97,100]
	 * The minimum value
	 ***************************************************/
	@Test
	void test_Boundaries_2() {
		

		/************************************************
		 * update student 1 info to be total marks=97
		 ************************************************
		 */
		s1.OralMark=10;
		s1.MidtermExamMark=20;
		s1.FinalExamMark=60;
		s1.StudentActivitiesMark=7;

		
		StudentsInfo.add(s1);
	

		StudentGradeGenerator.SetVectorStudentInfo(StudentsInfo);
		StudentsInfo=StudentGradeGenerator.gradeAndGPACalculator();
	

		assertEquals("A+",s1.Grade,"FALSE GRADE in Boundries testCase");
		assertEquals(4,s1.GPA,"FALSE GPA in Boundries testCase");
	}
	/****************************************************
	 * Valid Test Case for A+ [97,100] 
	 * The maximum value
	 ***************************************************/
	@Test
	void test_Boundaries_3() {
		

		/************************************************
		 * update student 1 info to be total marks=100
		 ************************************************
		 */
		s1.OralMark=10;
		s1.MidtermExamMark=20;
		s1.FinalExamMark=60;
		s1.StudentActivitiesMark=10;

		
		StudentsInfo.add(s1);
	

		StudentGradeGenerator.SetVectorStudentInfo(StudentsInfo);
		StudentsInfo=StudentGradeGenerator.gradeAndGPACalculator();
	

		assertEquals("A+",s1.Grade,"FALSE GRADE in Boundries testCase");
		assertEquals(4,s1.GPA,"FALSE GPA in Boundries testCase");
	}
	/****************************************************
	 * InValid Test Case for A+ [97,100] 
	 * just above the maximum value
	 ***************************************************/
	@Test
	void test_Boundaries_4() {
		

		/************************************************
		 * update student 1 info to be total marks=101
		 ************************************************
		 */
		s1.OralMark=10;
		s1.MidtermExamMark=20;
		s1.FinalExamMark=61;
		s1.StudentActivitiesMark=10;

		
		StudentsInfo.add(s1);
	

		StudentGradeGenerator.SetVectorStudentInfo(StudentsInfo);
		StudentsInfo=StudentGradeGenerator.gradeAndGPACalculator();
	

		assertEquals("A+",s1.Grade,"FALSE GRADE in Boundries testCase");
		assertEquals(4,s1.GPA,"FALSE GPA in Boundries testCase");
	}
	
	/****************************************************
	 * InValid Test Case for A [93,97[ 
	 * just below the minimum value
	 ***************************************************/
	@Test
	void test_Boundaries_5() {
		

		/************************************************
		 * update student 1 info to be total marks=93
		 ************************************************
		 */
		s1.OralMark=10;
		s1.MidtermExamMark=20;
		s1.FinalExamMark=56;
		s1.StudentActivitiesMark=6;

		
		StudentsInfo.add(s1);
	

		StudentGradeGenerator.SetVectorStudentInfo(StudentsInfo);
		StudentsInfo=StudentGradeGenerator.gradeAndGPACalculator();
	

		assertEquals("A",s1.Grade,"FALSE GRADE in Boundries testCase");
		assertEquals(4,s1.GPA,"FALSE GPA in Boundries testCase");
	}
	
	/****************************************************
	 * Valid Test Case for A [93,97[
	 * The minimum value
	 ***************************************************/
	@Test
	void test_Boundaries_6() {
		

		/************************************************
		 * update student 1 info to be total marks=93
		 ************************************************
		 */
		s1.OralMark=10;
		s1.MidtermExamMark=20;
		s1.FinalExamMark=56;
		s1.StudentActivitiesMark=7;

		
		StudentsInfo.add(s1);
	

		StudentGradeGenerator.SetVectorStudentInfo(StudentsInfo);
		StudentsInfo=StudentGradeGenerator.gradeAndGPACalculator();
	

		assertEquals("A",s1.Grade,"FALSE GRADE in Boundries testCase");
		assertEquals(4,s1.GPA,"FALSE GPA in Boundries testCase");
	}
	/****************************************************
	 * Valid Test Case for A [93,97[ 
	 * The maximum value
	 ***************************************************/
	@Test
	void test_Boundaries_7() {
		

		/************************************************
		 * update student 1 info to be total marks=96
		 ************************************************
		 */
		s1.OralMark=8;
		s1.MidtermExamMark=18;
		s1.FinalExamMark=60;
		s1.StudentActivitiesMark=10;

		
		StudentsInfo.add(s1);
	

		StudentGradeGenerator.SetVectorStudentInfo(StudentsInfo);
		StudentsInfo=StudentGradeGenerator.gradeAndGPACalculator();
	

		assertEquals("A",s1.Grade,"FALSE GRADE in Boundries testCase");
		assertEquals(4,s1.GPA,"FALSE GPA in Boundries testCase");
	}
	/****************************************************
	 * InValid Test Case for A [93,97[ 
	 * just above the maximum value
	 ***************************************************/
	@Test
	void test_Boundaries_8() {
		

		/************************************************
		 * update student 1 info to be total marks=98
		 ************************************************
		 */
		s1.OralMark=20;
		s1.MidtermExamMark=10;
		s1.FinalExamMark=57;
		s1.StudentActivitiesMark=10;

		
		StudentsInfo.add(s1);
	

		StudentGradeGenerator.SetVectorStudentInfo(StudentsInfo);
		StudentsInfo=StudentGradeGenerator.gradeAndGPACalculator();
	

		assertEquals("A",s1.Grade,"FALSE GRADE in Boundries testCase");
		assertEquals(4,s1.GPA,"FALSE GPA in Boundries testCase");
	}
	
	/****************************************************
	 * Valid Test Case for F <60 
	 *The maximum value
	 ***************************************************/
	@Test
	void test_Boundaries_9() {
		

		/************************************************
		 * update student 1 info to be total marks=59
		 ************************************************
		 */
		s1.OralMark=5;
		s1.MidtermExamMark=10;
		s1.FinalExamMark=38;
		s1.StudentActivitiesMark=6;

		
		StudentsInfo.add(s1);
	

		StudentGradeGenerator.SetVectorStudentInfo(StudentsInfo);
		StudentsInfo=StudentGradeGenerator.gradeAndGPACalculator();
	

		assertEquals("F",s1.Grade,"FALSE GRADE in Boundries testCase");
		assertEquals(0,s1.GPA,"FALSE GPA in Boundries testCase");
	}
	
	/****************************************************
	 * Invalid Test Case for for F <60 
	 * just above the maximum value
	 ***************************************************/
	@Test
	void test_Boundaries_10() {
		

		/************************************************
		 * update student 1 info to be total marks=97
		 ************************************************
		 */
		s1.OralMark=5;
		s1.MidtermExamMark=10;
		s1.FinalExamMark=38;
		s1.StudentActivitiesMark=7;

		
		StudentsInfo.add(s1);
	

		StudentGradeGenerator.SetVectorStudentInfo(StudentsInfo);
		StudentsInfo=StudentGradeGenerator.gradeAndGPACalculator();
	

		assertEquals("F",s1.Grade,"FALSE GRADE in Boundries testCase");
		assertEquals(0,s1.GPA,"FALSE GPA in Boundries testCase");
	}
	
	/*********************************************************
	 * Partitioning test cases on Student number 
	 * length of 8 characters. It should start with numbers and might End with only one
     * Alphabetic character
     * Test Case #1: Starts with number and 8 characters and ends with alphabetic char (Valid)
     * Test Case #2: Starts with number and 8 characters and ends with a number (valid)
     * Test Case #3: Starts with number and 6 characters (Invalid)
     * Test Case #4: Starts with number and 10 characters (Invalid)
     * Test Case #5: It doesn't starts with a number  (Invalid)
	 **********************************************************/
	@Test
	void testStudentNumber_Partition_1() {
		String studentNumberTest = "1803746Q";
		
		assertEquals(0, StudentGradeGenerator.validateStudentNumber(studentNumberTest), String.format("Student Number Error! \"" + studentNumberTest + "\" is an invalid student number."));
	
}
	@Test
	void testStudentNumber_Partition_2() {
		String studentNumberTest = "45687482";
		
		assertEquals(0, StudentGradeGenerator.validateStudentNumber(studentNumberTest), String.format("Student Number Error! \"" + studentNumberTest + "\" is an invalid student number."));
	
}
	@Test
	void testStudentNumber_Partition_3() {
		String studentNumberTest = "174862";
		
		assertEquals(-1, StudentGradeGenerator.validateStudentNumber(studentNumberTest), String.format("Student Number Error! \"" + studentNumberTest + "\" is an invalid student number."));
	
}
	
	@Test
	void testStudentNumber_Partition_4() {
		String studentNumberTest = "1235678951";
		
		assertEquals(-1, StudentGradeGenerator.validateStudentNumber(studentNumberTest), String.format("Student Number Error! \"" + studentNumberTest + "\" is an invalid student number."));
		
}
	@Test
	void testStudentNumber_Partition_5() {		
		String studentNumberTest = "@4532456";
		
		assertEquals(-1, StudentGradeGenerator.validateStudentNumber(studentNumberTest), String.format("Student Number Error! \"" + studentNumberTest + "\" is an invalid student number."));
	
}
/************************************************
 * Partitioning of Student Name Validation Function	
 * Test Case #1:Numbers and special characters (Invalid)
 * Test Case #2:Characters (Valid)
 * Test Case #3:Spaces (Invalid)
 * Test Case #4:Characters and Spaces and starts with alphabetic character (Valid)
 *************************************************/
	@Test
	void StudentName_Partition_1() {	
		String studentNameTest = "2424@423";
		
		assertEquals("", StudentGradeGenerator.validateStudentName(studentNameTest), String.format("Student Name Error! \"" + studentNameTest + "\" is an invalid student name."));
	}
	@Test
	void StudentName_Partition_2() {	
		String studentNameTest = "Mayar";
		
		assertNotEquals("", StudentGradeGenerator.validateStudentName(studentNameTest), String.format("Student Name Error! \"" + studentNameTest + "\" is an invalid student name."));
	}
	@Test
	void StudentName_Partition_3() {	
		String studentNameTest = "     ";
		
		assertEquals("", StudentGradeGenerator.validateStudentName(studentNameTest), String.format("Student Name Error! \"" + studentNameTest + "\" is an invalid student name."));
	}
	@Test
	void StudentName_Partition_4() {	
		String studentNameTest = "Mayar Mohamed";
		
		assertNotEquals("", StudentGradeGenerator.validateStudentName(studentNameTest), String.format("Student Name Error! \"" + studentNameTest + "\" is an invalid student name."));
	}
	
	/********************************************************
	 * Check Final Exam Mark using Boundary Testing from [0,60]
	 * Test Case #1: Mark =-1
	 * Test Case #2: Mark =0
	 * Test Case #3: Mark =15
	 * Test Case #4: Mark =60
	 * Test Case #5: Mark =61
	 **********************************************************/
	@Test
	void isFinalMarkValidatingCorrectlyTest_Bound_1() {
		int expected = -1;
		String mark = "-1";
		int actual = StudentGradeGenerator.ValidateMark("Final Mark", mark, 60,4363532);
		assertEquals(expected, actual, String.format("mark::%s => Returning Error in validating Final Mark Function", mark));

}
	@Test
	void isFinalMarkValidatingCorrectlyTest_Bound2() {
		int expected = 0;
		String mark = "0";
		int actual = StudentGradeGenerator.ValidateMark("Final Mark", mark, 60,4363532);
		assertEquals(expected, actual, String.format("mark::%s => Returning Error in validating Final Mark Function", mark));

}
	@Test
	void isFinalMarkValidatingCorrectlyTest_Bound3() {
		int expected = 15;
		String mark = "15";
		int actual = StudentGradeGenerator.ValidateMark("Final Mark", mark, 60,4363532);
		assertEquals(expected, actual, String.format("mark::%s => Returning Error in validating Final Mark Function", mark));

}
	@Test
	void isFinalMarkValidatingCorrectlyTest_Bound4() {
		int expected = 60;
		String mark = "60";
		int actual = StudentGradeGenerator.ValidateMark("Final Mark", mark, 60,4363532);
		assertEquals(expected, actual, String.format("mark::%s => Returning Error in validating Final Mark Function", mark));

}
	@Test
	void isFinalMarkValidatingCorrectlyTest_Bound5() {
		int expected = -1;
		String mark = "61";
		int actual = StudentGradeGenerator.ValidateMark("Final Mark", mark, 60,4363532);
		assertEquals(expected, actual, String.format("mark::%s => Returning Error in validating Final Mark Function", mark));

}
	
	
/***************************************
 * Decision Test Case of FullMarkChecker
 ***************************************/
	@Test
	void DecisionCase_FullMarkChechker_1() {
		String mark= "100";
		int actual = StudentGradeGenerator.FullMark_Checker(mark);	
		int expected = 100;
		assertEquals(expected, actual, "The Full Mark isn't 100");
	}
	@Test
	void DecisionCase_FullMarkChechker_2() {
		String mark= "70";
		int actual = StudentGradeGenerator.FullMark_Checker(mark);	
		int expected = -1;
		assertEquals(expected, actual, "The Full Mark isn't 100");
	}
	


/************************************************
 * Partitioning of Subject Name Validation Function	
 * Test Case #1:Numbers and special characters (Invalid)
 * Test Case #2:Characters (Valid)
 * Test Case #3:Spaces (Invalid)
 * Test Case #4:Characters and Spaces and starts with alphabetic character (Valid)
 *************************************************/
	@Test
	void SubjectName_Partition_1() {	
		String subjectNameTest = "2424@423";
		
		assertEquals("", StudentGradeGenerator.SubjectName_Checker(subjectNameTest), String.format("Subject Name Error! \"" + subjectNameTest + "\" is an invalid subject name."));
	}
	@Test
	void SubjectName_Partition_2() {	
		String subjectNameTest = "Testing";
		
		assertNotEquals("", StudentGradeGenerator.SubjectName_Checker(subjectNameTest), String.format("Subject Name Error! \"" + subjectNameTest + "\" is an invalid subject name."));
	}
	@Test
	void SubjectName_Partition_3() {	
		String subjectNameTest = "     ";
		
		assertEquals("", StudentGradeGenerator.SubjectName_Checker(subjectNameTest), String.format("Subject Name Error! \"" + subjectNameTest + "\" is an invalid subject name."));
	}
	@Test
	void SubjectName_Partition_4() {	
		String subjectNameTest = "Software Testing";
		
		assertNotEquals("", StudentGradeGenerator.SubjectName_Checker(subjectNameTest), String.format("Subject Name Error! \"" + subjectNameTest + "\" is an invalid subject name."));
	}
	
	/*********************************************************
	 * Partitioning test cases on Subject Code 
	 * length of 6-7 characters. It must be 6-7 Alphanumeric characters. The first 3 are Alphabetic
       followed by 3 numeric characters. The sevens should be s if exists.

     * Test Case #1: Starts with 3 Alphabetic Characters followed by 3 numeric characters(Valid)
     * Test Case #2: Starts with 3 Characters followed by 3 numeric characters and ends with s(valid)
     * Test Case #3: 6 Alphabetic characters (Invalid)
     * Test Case #4: 6 numeric characters (Invalid)
     * Test Case #5: 3 Alphabetic characters then 2 numeric characters  (Invalid)
     * Test Case #6: 6 Special characters and spaces  (Invalid)
	 **********************************************************/
	@Test
	void SubjectCode_Partition_1() {	
		String subjectCodeTest = "cse123";
		String expected ="cse123" ;
		
		assertEquals(expected, StudentGradeGenerator.SubjectCode_Checker(subjectCodeTest), String.format("Subject Code Error! \"" + subjectCodeTest + "\" is an invalid subject code."));
	}
	@Test
	void SubjectCode_Partition_2() {	
		String subjectCodeTest = "cse212s";
		String expected ="cse212s" ;
		
		assertEquals(expected, StudentGradeGenerator.SubjectCode_Checker(subjectCodeTest), String.format("Subject Code Error! \"" + subjectCodeTest + "\" is an invalid subject code."));
	}
	@Test
	void SubjectCode_Partition_3() {	
		String subjectCodeTest = "csecse";
		String expected ="" ;
		
		assertEquals(expected, StudentGradeGenerator.SubjectCode_Checker(subjectCodeTest), String.format("Subject Code Error! \"" + subjectCodeTest + "\" is an invalid subject code."));
	}
	@Test
	void SubjectCode_Partition_4() {	
		String subjectCodeTest = "123456";
		String expected = "";
		assertEquals(expected, StudentGradeGenerator.SubjectCode_Checker(subjectCodeTest), String.format("Subject Code Error! \"" + subjectCodeTest + "\" is an invalid subject code."));
	}
	@Test
	void SubjectCode_Partition_5() {	
		String subjectCodeTest = "cse56";
		String expected = "";
		assertEquals(expected, StudentGradeGenerator.SubjectCode_Checker(subjectCodeTest), String.format("Subject Code Error! \"" + subjectCodeTest + "\" is an invalid subject code."));
	}
	@Test
	void SubjectCode_Partition_6() {	
		String subjectCodeTest = "@#$  $";
		String expected = "";
		assertEquals(expected, StudentGradeGenerator.SubjectCode_Checker(subjectCodeTest), String.format("Subject Code Error! \"" + subjectCodeTest + "\" is an invalid subject code."));
	}
	}