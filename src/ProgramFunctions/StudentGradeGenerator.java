package ProgramFunctions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.String;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Vector;
import java.util.regex.Pattern;

//import org.apache.commons.lang3.StringUtils;

//import StudentGradeGenerator.StudentInfo;

public class StudentGradeGenerator {

	/*variable to store the student info's which starts
	 *from line 2 
	 * StudentInfo is a class which contains the six values of each
	 * student ( StudentName,StudentNumber,StudentActivitiesMark,
	 * OralMark,MidtermExamMark,FinalExamMark.)	
	 */
	private static Vector<StudentInfo> StudentsInfo;
	/*the error variable is used to store the error 
	 *raised by any function. which is used later to in the gui
	 *to display it to the user.
	 */
	private static String _error="";
	/*the ErrorlineNumber is used to display the 
	 * line of the error.
	 * it's first initalized to zero, then in the 
	 * InputParse function the variable is increased for every
	 * line being parsed by one. 
	 */
	private static int ErrorlineNumber=0;
	/*the three variables (SubjectName,SubjectCode,FullMark)
	 * is used for storing the values of the first line
	 * of each file. which will be used later to generate the 
	 * output file.
	 */
	private static String SubjectName,SubjectCode;
	private static int FullMark;

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
		public StudentInfo() {};
	}

    /*variable to store the path of the output generated file
	* which is used later to display it to the user through the
	*  Gui.
	*/
	private static Path outputFilePath;


	/********************************Functions*****************************************/
	
	public static Path  getOutputFilePath() {
		return outputFilePath;
	}
	public static String getError(){
		return _error;
	}
	public static String getSubjectName(){
		return SubjectName;
	}
	public static String getSubjectCode(){
		return SubjectCode;
	}
	public static int getFullMark(){
		return FullMark;
	}
	public static Vector<StudentInfo> getVectorStudentInfo()
	{
		return StudentsInfo;
	}
 
	
	/*isTesting is just a random number to ensure that the function will
	 * not be used unless in testing (type of security)
	 */
	public static void InitializeAllVariables(int isTesting)
	{
		/*this function is only used for testing, 
		 * as the variable are static, so they save the changes
		 * which happen for every method call.
		 * so before testing any test case, all the variables will be
		 * initialized.
		 */
		if(isTesting==4363532)
		{
			StudentsInfo =new Vector<StudentInfo>();
	        ErrorlineNumber=0;
	        _error=""; 
	    	SubjectName="";
	    	SubjectCode="";
	    	FullMark=0;
		}
		
	}
	public static Boolean ParseInput(String inputFilePath)
	{
		try {

			BufferedReader bufferedReader =new BufferedReader (new FileReader(inputFilePath));


			String StudentRecord =null;

			/*initialize the Student'sInfo,ErrorlineNumber,_error*/
			/*The initialization was done here.
			 *so that for every time the user input a file, when the parseInput 
			 *function is execuated, the three variable will be cleared an re-initialized
             for a new file read.
			 */
			StudentsInfo =new Vector<StudentInfo>();
            ErrorlineNumber=0;
            _error="";

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
					if((SubjectName=SubjectName_Checker(firstLine[0]))=="") return false;
					if((SubjectCode=SubjectCode_Checker(firstLine[1].trim()))=="")return false;
					/*note: the input should not be converted to int
					 * this is used just for testing.
					 * The validation functions should take a string value.
					 * validate it, if it correct return the converted int value.
					 * else: raise an error and return -1 (the return false to cause that the 
					 * InputParse function to not proceed and return) .
					 */
					if((FullMark=FullMark_Checker(firstLine[2].trim()))==-1)return false;        
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
						studentInfo.StudentName=StudentRecords[0];
						studentInfo.StudentNumber=StudentRecords[1].trim();
						//if((validateStudentName(studentInfo.StudentName))==-1)return false;
						if (validateStudentName(studentInfo.StudentName) == "") return false;
						if((validateStudentNumber(studentInfo.StudentNumber))==-1)return false;
						/* note: the input should not be converted to int.
						 * This is used just for testing
						 * the validation functions should take a string value.
						 * validate it, if it correct return the converted int value.
						 * other cause an error and exit (still thinking about a better way).
						 */
						if((studentInfo.StudentActivitiesMark=ValidateMark("Student Activities Mark", StudentRecords[2].trim(), 10,0))==-1)return false;
						if((studentInfo.OralMark=ValidateMark("Oral Mark",StudentRecords[3].trim(),10,0))==-1)return  false;
						if((studentInfo.MidtermExamMark=ValidateMark("Midterm Exam Mark",StudentRecords[4].trim(),20,0))==-1)return false;
						if((studentInfo.FinalExamMark=ValidateMark("Final Exam Mark",StudentRecords[5].trim(),60,0))==-1)return false;
					}
					else 
					{
						_error="Line Number ("+ErrorlineNumber+") should contain exactly six values!";
						return false;
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

	/******************************Input Validation Functions*******************************/

	/*1-function to check  subject_name must be Alphabetic characters and Spaces. the name should not 
	start with space*/
	public static String SubjectName_Checker(String s) {
		 boolean result = s.matches("\\S[ A-Za-z]+$");
		 if (result)
			 return s;
		 _error=" Line Number ("+ErrorlineNumber+") The subject's name must only contain Alphabetic characters and Spaces and must not start with space.";
		 return "";
	}

	/*2-function to check subject code must be 6-7 Alphanumeric characters. The first 3 are Alphabetic 
followed by 3 numeric characters. The sevens should be s if exists*/
	public static String SubjectCode_Checker(String s) {
		 boolean result = s.matches("[A-Za-z]{3}[0-9]{3}s?");
		 if (result)
			 return s;
		 _error=" Line Number ("+ErrorlineNumber+")  The subject's code must be 6-7 Alphanumeric characters. The first 3 are Alphabetic\n"
		 		+ "followed by 3 numeric characters. The sevens should be s if exists. ";
		 return "";
	}

	/*3-function to check full mark=100The sevens should be s if exists*/
	public static int FullMark_Checker(String s) {
		 boolean result = s.matches("100");
		 if (result)
			 return Integer.parseInt(s);
		 _error=" Line Number ("+ErrorlineNumber+") Full Mark is a numeric number of the value: 100 ";
		 return -1;
		 
	}
	
	/*function to validate if the mark is:
	 * 1) of type int.
	 * 2) value between 0 and a maximum mark.
	 */
	
	/*isTesting is just a random number to ensure that the function will
	 * not be used unless in testing (type of security)
	 */
	public static int ValidateMark(String MarkName,String mark,int MaxMark,int isTesting)
	{
		try {
    		
			/*if the function was used in testing development,
			 * the variable will be re-initialized, to not use 
			 * any previous value which is stored in the variables 
			 * (as the variables are static, so they preserve the value 
			 * every time a function change them).
			 */
    		if(isTesting==4363532)
			{
    			_error="";
    		    ErrorlineNumber=0;
			}
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

			_error ="Line ("+ErrorlineNumber+"): "+MarkName +" must be a value between 0 and "+ MaxMark +"!";
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

	public static String validateStudentName(String s) {
		 //boolean result = s.matches("\\S[ A-Za-z]+$");
		boolean result = s.matches("([A-Za-z]+[ ]*)+");
		 if (result)
			 return s;
		 _error=" Line Number ("+ErrorlineNumber+") Student name must only contain Alphabetic characters and Spaces and must not start with space.";
		 return "";
	}
	
	public static int validateStudentNumber(String studentNumber) {
		if (studentNumber.equals("")) {
			_error = "Line (" + ErrorlineNumber + "): Empty Student Number.";
			return -1;
		} else if (studentNumber.length() != 8) {
			_error = "Line (" + ErrorlineNumber + "): " + studentNumber + " must be 8 characters.";
			return -1;
		} else if (!Pattern.matches("[0-9]{7}[0-9a-zA-Z]", studentNumber)) {
			_error = "Line (" + ErrorlineNumber + "): " + studentNumber + " is not a valid Student Number! It must include 8 numbers, or 7 numbers and a character at the end.";
			return -1;
		}
		else {
			return 0;
		}
	}
	
	/*****************************************CALCULATOR***********************************/

	public static void gradeAndGPACalculator() {

		try {
				
			int total_marks=0;
			Iterator i = StudentsInfo.iterator();
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

				StudentsInfo.set(counter,s);
				counter++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	/**************************Function to write to output file***********************/
	public static  Boolean writeToOutputFile() {
		
		try {
			FileWriter writer = new FileWriter("output.txt");
//			writer.write("Subject Name: " + SubjectName);
//			writer.write("\t\t Max Mark: " + FullMark + "\n");
//			writer.write("__________________________________________________________\n");
//			writer.write("Student name      | Student number      | GPA      | Grade");
			writer.write("Subject Name: " + SubjectName);
			writer.write("\t\t Max Mark: " + FullMark + "\n");
			writer.write("Student name   Student number   GPA   Grade");
			/*if (studentsInfo.size() == 0) {
				_error = "No Students Info to show!";
				writer.close();
				return false;
			}*/
			for (int i = 0; i < StudentsInfo.size(); i++) {
//				writer.write("\n");
//				writer.write("__________________________________________________________");
//				writer.write("\n");
//				writer.write(StringUtils.rightPad(StudentsInfo.get(i).StudentName,18," ")+"| ");
//				writer.write(StringUtils.rightPad(StudentsInfo.get(i).StudentNumber,20," ") + "| ");
//				writer.write(StringUtils.rightPad(String.valueOf(StudentsInfo.get(i).GPA),9," ")+"| ");
//				writer.write(String.valueOf(StudentsInfo.get(i).Grade));
				writer.write("\n");
				writer.write(StudentsInfo.get(i).StudentName + "    ");
				writer.write(StudentsInfo.get(i).StudentNumber + "    ");
				writer.write(String.valueOf(StudentsInfo.get(i).GPA) + "    ");
				writer.write(String.valueOf(StudentsInfo.get(i).Grade));
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Path path = Paths.get("output.txt");
		outputFilePath = path.toAbsolutePath();
		return true;
	}
	
	
	/***************************************************************************************/
}