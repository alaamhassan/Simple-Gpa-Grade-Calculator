package ProgramFunctions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;
import java.util.Iterator;
import java.util.Vector;

//import StudentGradeGenerator.StudentInfo;

public class StudentGradeGenerator {

	/*variable to store the student info's which starts
	 *from line 2 
	 * StudentInfo is a class which contains the six values of each
	 * student ( StudentName,StudentNumber,StudentActivitiesMark,
	 * OralMark,MidtermExamMark,FinalExamMark.)	
	 */
	private Vector<StudentInfo> StudentsInfo;
	/*the error variable is used to store the error 
	 *raised by any function. which is used later to in the gui
	 *to display it to the user.
	 */
	private String _error;
	/*the ErrorlineNumber is used to display the 
	 * line of the error.
	 * it's first initalized to zero, then in the 
	 * InputParse function the variable is increased for every
	 * line being parsed by one. 
	 */
	private int ErrorlineNumber=0;
	/*the three variables (SubjectName,SubjectCode,FullMark)
	 * is used for storing the values of the first line
	 * of each file. which will be used later to generate the 
	 * output file.
	 */
	private String SubjectName,SubjectCode;
	private int FullMark;

	/*the class studentInfo was used to store 
	 * the six values ( StudentName,StudentNumber,StudentActivitiesMark,
	 * OralMark,MidtermExamMark,FinalExamMark.) for each student and
	 * store it in a vector.
	 */

	public static class StudentInfo
	{
		public String StudentName;
		public String StudentNumber;
		public int StudentActivitiesMark;
		public int OralMark;
		public int MidtermExamMark;
		public int FinalExamMark;
		public String Grade;
		public float GPA; 
		public StudentInfo(String Name,String ID,int Activities,int Oral, int Midterm ,int FinalExam) {
			StudentName=Name;
			StudentNumber=ID;
			StudentActivitiesMark=Activities;
			OralMark=Oral;
			MidtermExamMark=Midterm;
			FinalExamMark=FinalExam;
		}
		public StudentInfo(){}
	}

	public Boolean ParseInput(String inputFilePath)
	{
		try {

			BufferedReader bufferedReader =new BufferedReader (new FileReader(inputFilePath));

			String StudentRecord =null;

			/*initialize the Student'sInfo with a vector of capacity 10*/
			/*The initialization was done here.
			 *to avoid initializing the variable and waste memory in case the
			 *input file was invalid (an exception occurred).
			 */
			StudentsInfo =new Vector<StudentInfo>();

			/*Read only The first line in the file*/ 
			if((StudentRecord= bufferedReader.readLine()) !=null)
			{
				/* Increment the ErrorlineNumber to 1 for the first line.*/
				ErrorlineNumber++;

				/*separate the first line by commas.Then parse the values
				 * into subjectName,subjectName,FullMark.
				 * The parse happens After checking if the input is correct
				 * according to requirement. 
				 * => Mariam walled functions will be executed here.
				 */
				String [] firstLine =StudentRecord.split(",");

				/*first we will check if the first line contains exactly 3 values.
				 *if it is: the values will be check and parsed
				 *else: an error will be raised and the function will return with 
				 *a value of false.
				 */
				if(firstLine.length==3)
				{
					/*instead of passing the firstline[] directly it should be
					 * validated by a validation function (Mariam waleed)
					 * if the value was correct according to the program 
					 * constrains: the value will be returned as it is.
					 * else: the function will rise an error and will return 
					 * an empty string (the return false to cause that the InputParse
					 * function to not proceed and return)
					 */
					if((SubjectName=firstLine[0])=="") return false;
					if((SubjectCode=firstLine[1])=="")return false;
					/*note: the input should not be converted to int
					 * this is used just for testing.
					 * The validation functions should take a string value.
					 * validate it, if it correct return the converted int value.
					 * else: raise an error and return -1 (the return false to cause that the 
					 * InputParse function to not proceed and return) .
					 */
					if((FullMark=Integer.parseInt(firstLine[2]))==-1)return false;        
				}
				else
				{
					_error="First Line should contain exactly three values!";
					return false;			
				}

				/*Read the rest of the file*/
				while((StudentRecord= bufferedReader.readLine()) !=null)
				{
					/* Increment the ErrorlineNumber every iteration 
					 * to detect the line number if an error occurred.
					 */
					ErrorlineNumber++;

					/*separate every line by commas
					 *into StudentName,StudentNumber,StudentActivitiesMark,
					 *OralMark,MidtermExamMark,FinalExamMark.
					 */			

					String[] StudentRecords =StudentRecord.split(",");

					/*for each iteration a new studentInfo object will be created.
					 * The objects will be stored in a list representing all the student's
					 * info. Which will be used after in both the GpaAndGrade calculator functions
					 * and output the Student grades file.
					 */
					StudentInfo studentInfo =new StudentInfo();

					/* check if the current line contains exactly 6 parameter,
					 * if not throw an error and break.
					 */
					if(StudentRecords.length ==6)
					{

						/*instead of passing the StudentRecords[] directly it should be
						 * validated by a validation function (Maram,Alaa)
						 * if the value was correct according to the program 
						 * constrains: the value will be returned as it is.
						 * else: the function will rise an error and will return 
						 * an empty string (the return false to cause that the InputParse
						 * function to not proceed and return)
						 * => Maram,Alaa functions will be executed here.
						 */
						if((studentInfo.StudentName=StudentRecords[0])=="")return false;
						if((studentInfo.StudentNumber=StudentRecords[1])=="")return false;
						/* note: the input should not be converted to int.
						 * This is used just for testing
						 * the validation functions should take a string value.
						 * validate it, if it correct return the converted int value.
						 * other cause an error and exit (still thinking about a better way).
						 */
						if((studentInfo.StudentActivitiesMark=Integer.parseInt(StudentRecords[2]))==-1)return false;
						if((studentInfo.OralMark=ValidateMark("oralMark",StudentRecords[3],10))==-1)return  false;
						if((studentInfo.MidtermExamMark=ValidateMark("MidtermExamMark",StudentRecords[4],20))==-1)return false;
						if((studentInfo.FinalExamMark=ValidateMark("FinalExamMark",StudentRecords[5],60))==-1)return false;
					}
					else 
					{
						_error=" Line Number ("+ErrorlineNumber+") should contain exactly six values!";
						break;
					}			 		

					/*if the code reached here then that's mean the parse 
					 *of the current line was successfully done.
					 *Add the studentInfo record to the StudentsInfo list
					 */

					StudentsInfo.add(studentInfo);
				}


			}


			/*if the code reached here that means that the input was parsed
			 * correctly and was correct according to the requirement
			 */
			return true;

		} 
		catch (IOException e) {
			_error="Input path dosn't exist!";
			return false;
		}


	}

	public String getError()
	{
		return _error;
	}

	public String getParsedInput()
	{
		return SubjectName;
	}



	/*function to validate if the mark is:
	 * 1) of type int.
	 * 2) value between 0 and a maximum mark.
	 */
	public int ValidateMark(String MarkName,String mark,int MaxMark)
	{
		try {
			/*parse the string number in case of :
			 * success: this means that mark is of type int
			 * (then the value will be checked if it's between 0 & MaxMark).
			 * fail: an exception will occur. 
			 */
			int Mark =Integer.parseInt(mark);

			/*check if the mark between 0 & MaxMark:
			 * if it's : the value is correct and will be returned.
			 * else: an error will be raised and the function will return with value -1.
			 */
			if(Mark>=0 && Mark<=MaxMark) return Mark;

			_error ="Line ("+ErrorlineNumber+"): "+MarkName +" must value between 0 and "+ MaxMark +"!";
			return -1;

		}
		catch(Exception e)
		{
			/*if we reached here then that's means the mark wasn't of type int.
			 * first raise an error then return with value -1.
			 */
			_error ="Line ("+ErrorlineNumber+"): "+MarkName+" must be of type int!";
			return -1;
		}
	}
	/*****************************************CALCULATOR***********************************/

	public static Vector gradeAndGPACalculator(Vector<StudentInfo> students) {

		try {
			int total_marks=0;
			Iterator i = students.iterator();
			int counter=0;
			while (i.hasNext()) {

				StudentInfo s=(StudentInfo)i.next();
				total_marks=s.OralMark+s.StudentActivitiesMark+s.MidtermExamMark+s.FinalExamMark;
				if((97<= total_marks) &&(total_marks<= 100)) {
					s.GPA=4;
					s.Grade="A+";
				}
				else if((93<= total_marks) &&(total_marks< 97) ){
					s.GPA=4;
					s.Grade="A";
				}
				else if((89<= total_marks) &&(total_marks< 93)) {
					s.GPA=(float)3.7;
					s.Grade="A-";
				}
				else if((84<= total_marks) &&(total_marks< 89)) {
					s.GPA=(float)3.3;
					s.Grade="B+";
				}
				else if((80<= total_marks )&&(total_marks< 84)) {
					s.GPA=3;
					s.Grade="B";
				}
				else if((76<= total_marks )&&(total_marks< 80) ){
					s.GPA=(float)2.7;
					s.Grade="B-";
				}
				else if((73<= total_marks) &&(total_marks< 76)) {
					s.GPA=(float)2.3;
					s.Grade="C+";
				}
				else if((70<= total_marks) &&(total_marks< 73)) {
					s.GPA=2;
					s.Grade="C";
				}
				else if((67<= total_marks) &&(total_marks< 70)) {
					s.GPA=(float)1.7;
					s.Grade="C-";
				}
				else if((64<= total_marks) &&(total_marks< 67)) {
					s.GPA=(float)1.3;
					s.Grade="D+";
				}
				else if((60<= total_marks) &&(total_marks< 64)) {
					s.GPA=1;
					s.Grade="D";

				}
				else if(60>total_marks ) {
					s.GPA=0;
					s.Grade="F";
				}
				else {

					//System.out.println("INVALID INPUTS");
				}

				students.set(counter,s);
				counter++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		return students;

	}

}





