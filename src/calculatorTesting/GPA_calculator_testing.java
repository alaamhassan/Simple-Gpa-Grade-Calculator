package calculatorTesting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.Vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ProgramFunctions.StudentGradeGenerator;
import ProgramFunctions.StudentGradeGenerator.StudentInfo;
class GPA_calculator_testing {
	@Test
	void test_positive () {
		StudentInfo s1 ,s2,s3;
		Vector<StudentInfo> expected=new Vector<>() ;
		Vector<StudentInfo> StudentsInfo=new Vector<>() ;
		s1 = new StudentInfo();
		s2 = new StudentInfo();
		s3 = new StudentInfo();

		/************************************************
		 * update student 1 info to be total marks=95
		 ************************************************
		 */
		s1.OralMark=5;
		s1.MidtermExamMark=5;
		s1.FinalExamMark=80;
		s1.StudentActivitiesMark=5;

		/************************************************
		 * update student 2 info to be total marks=85
		 ************************************************
		 */
		s2.OralMark=5;
		s2.MidtermExamMark=10;
		s2.FinalExamMark=60;
		s2.StudentActivitiesMark=10;

		/************************************************
		 * update student 3 info to be total marks=81
		 ************************************************
		 */
		s3.OralMark=1;
		s3.MidtermExamMark=5;
		s3.FinalExamMark=70;
		s3.StudentActivitiesMark=5;

		StudentInfo s1_ex =new StudentInfo(s1.StudentName,s1.StudentNumber,s1.StudentActivitiesMark,s1.OralMark,s1.MidtermExamMark,s1.FinalExamMark) ;
		StudentInfo s2_ex = new StudentInfo(s2.StudentName,s2.StudentNumber,s2.StudentActivitiesMark,s2.OralMark,s2.MidtermExamMark,s2.FinalExamMark) ;
		StudentInfo s3_ex=new StudentInfo(s3.StudentName,s3.StudentNumber,s3.StudentActivitiesMark,s3.OralMark,s3.MidtermExamMark,s3.FinalExamMark) ;
		/************************************************
		 * set expected Grade and GPAs for each student 
		 ************************************************
		 */
		StudentsInfo.add(s1);
		StudentsInfo.add(s2);
		StudentsInfo.add(s3); 
		s1_ex.GPA=4;
		s1_ex.Grade="A";


		s2_ex.GPA=(float) 3.3;
		s2_ex.Grade="B+";


		s3_ex.GPA=3;
		s3_ex.Grade="B";
		expected.add(s1_ex);
		expected.add(s2_ex);
		expected.add(s3_ex);

		StudentGradeGenerator.SetVectorStudentInfo(StudentsInfo);
		StudentsInfo=StudentGradeGenerator.gradeAndGPACalculator();
		Iterator z =StudentsInfo.iterator();
		Iterator z_exp =expected.iterator();
		while (z.hasNext()) {
			StudentInfo x=(StudentInfo)z.next();
			StudentInfo y=(StudentInfo)z_exp.next();

			assertEquals(y.Grade,x.Grade,"FALSE GRADE in test Positive ");
			assertEquals(y.GPA,x.GPA,"FALSE GPA in test Positive ");
		}

	}
	@Test
	void test_negative () {
		StudentInfo s1 ,s2,s3;
		Vector<StudentInfo> expected=new Vector<>() ;
		Vector<StudentInfo> StudentsInfo=new Vector<>() ;
		s1 = new StudentInfo();
		s2 = new StudentInfo();
		s3 = new StudentInfo();

		/************************************************
		 * update student 1 info to be total marks=95
		 ************************************************
		 */
		s1.OralMark=5;
		s1.MidtermExamMark=5;
		s1.FinalExamMark=80;
		s1.StudentActivitiesMark=5;

		/************************************************
		 * update student 2 info to be total marks=85
		 ************************************************
		 */
		s2.OralMark=5;
		s2.MidtermExamMark=10;
		s2.FinalExamMark=60;
		s2.StudentActivitiesMark=10;

		/************************************************
		 * update student 3 info to be total marks=81
		 ************************************************
		 */
		s3.OralMark=1;
		s3.MidtermExamMark=5;
		s3.FinalExamMark=70;
		s3.StudentActivitiesMark=5;

		StudentInfo s1_ex =new StudentInfo(s1.StudentName,s1.StudentNumber,s1.StudentActivitiesMark,s1.OralMark,s1.MidtermExamMark,s1.FinalExamMark) ;
		StudentInfo s2_ex = new StudentInfo(s2.StudentName,s2.StudentNumber,s2.StudentActivitiesMark,s2.OralMark,s2.MidtermExamMark,s2.FinalExamMark) ;
		StudentInfo s3_ex=new StudentInfo(s3.StudentName,s3.StudentNumber,s3.StudentActivitiesMark,s3.OralMark,s3.MidtermExamMark,s3.FinalExamMark) ;
		/************************************************
		 * set expected Grade and GPAs for each student 
		 ************************************************
		 */
		StudentsInfo.add(s1);
		StudentsInfo.add(s2);
		StudentsInfo.add(s3); 
		s1_ex.GPA=4;
		s1_ex.Grade="C";


		s2_ex.GPA=(float) 3.3;
		s2_ex.Grade="F";


		s3_ex.GPA=3;
		s3_ex.Grade="D";
		expected.add(s1_ex);
		expected.add(s2_ex);
		expected.add(s3_ex);

		StudentGradeGenerator.SetVectorStudentInfo(StudentsInfo);
		StudentsInfo=StudentGradeGenerator.gradeAndGPACalculator();
		Iterator z =StudentsInfo.iterator();
		Iterator z_exp =expected.iterator();
		while (z.hasNext()) {
			StudentInfo x=(StudentInfo)z.next();
			StudentInfo y=(StudentInfo)z_exp.next();

			assertEquals(y.Grade,x.Grade,"FALSE GRADE in negative testCase ");
			assertEquals(y.GPA,x.GPA,"FALSE GPA in negative testCase ");
		}

	}
	@Test
	void test_Boundaries() {
		StudentInfo s1 ,s2,s3;
		Vector<StudentInfo> expected=new Vector<>() ;
		Vector<StudentInfo> StudentsInfo=new Vector<>() ;
		s1 = new StudentInfo();
		s2 = new StudentInfo();
		s3 = new StudentInfo();

		/************************************************
		 * update student 1 info to be total marks=97
		 ************************************************
		 */
		s1.OralMark=20;
		s1.MidtermExamMark=10;
		s1.FinalExamMark=60;
		s1.StudentActivitiesMark=7;

		/************************************************
		 * update student 2 info to be total marks=89
		 ************************************************
		 */
		s2.OralMark=20;
		s2.MidtermExamMark=4;
		s2.FinalExamMark=60;
		s2.StudentActivitiesMark=5;

		/************************************************
		 * update student 3 info to be total marks=64
		 ************************************************
		 */
		s3.OralMark=1;
		s3.MidtermExamMark=3;
		s3.FinalExamMark=60;
		s3.StudentActivitiesMark=0;
		StudentsInfo.add(s1);
		StudentsInfo.add(s2);
		StudentsInfo.add(s3);
		
		StudentInfo s1_ex =new StudentInfo(s1.StudentName,s1.StudentNumber,s1.StudentActivitiesMark,s1.OralMark,s1.MidtermExamMark,s1.FinalExamMark) ;
		StudentInfo s2_ex = new StudentInfo(s2.StudentName,s2.StudentNumber,s2.StudentActivitiesMark,s2.OralMark,s2.MidtermExamMark,s2.FinalExamMark) ;
		StudentInfo s3_ex=new StudentInfo(s3.StudentName,s3.StudentNumber,s3.StudentActivitiesMark,s3.OralMark,s3.MidtermExamMark,s3.FinalExamMark) ;

		/************************************************
		 * set expected Grade and GPAs for each student 
		 ************************************************
		 */
		s1_ex.GPA=4;
		s1_ex.Grade="A+";


		s2_ex.GPA=(float) 3.7;
		s2_ex.Grade="A-";


		s3_ex.GPA=(float)1.3;
		s3_ex.Grade="D+";
		expected.add(s1_ex);
		expected.add(s2_ex);
		expected.add(s3_ex);

		StudentGradeGenerator.SetVectorStudentInfo(StudentsInfo);
		StudentsInfo=StudentGradeGenerator.gradeAndGPACalculator();
		Iterator<StudentInfo> z =StudentsInfo.iterator();
		Iterator<StudentInfo> z_exp =expected.iterator();
		while (z.hasNext()) {
			StudentInfo x=(StudentInfo)z.next();
			StudentInfo y=(StudentInfo)z_exp.next();

			assertEquals(x.Grade,y.Grade,"FALSE GRADE in Boundries testCase");
			assertEquals(x.GPA,y.GPA,"FALSE GPA in Boundries testCase");
		}

	}
	


}
