package ProjectIntegrationTest;


import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.TemporaryFolder;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import ProgramFunctions.StudentGradeGenerator;

class IntegrationTesting {
	private static StudentGradeGenerator Gen;

	@BeforeEach
	void objectInitialization() {
		Gen = new StudentGradeGenerator();
		StudentGradeGenerator.InitializeAllVariables(4363532);
		}
	@Test
	//To check the content of the file of WriteToOutputFile()
	public void testWriteToOutputFile() throws IOException {
		
		StudentGradeGenerator.StudentInfo  Student_1 = new StudentGradeGenerator.StudentInfo();
		StudentGradeGenerator.StudentInfo  Student_2 = new StudentGradeGenerator.StudentInfo();

		// set up test data
	    StudentGradeGenerator.SubjectName = "Test Subject";
	    StudentGradeGenerator.FullMark = 100;
	    
	    Student_1.StudentName = "Alice";
	    Student_1.StudentNumber ="1808551";
	    Student_1.GPA = (float)3.2;
	    Student_1.Grade = "B";
	    		
	    Student_2.StudentName = "Mayar";
	    Student_2.StudentNumber ="1807351";
	    Student_2.GPA = (float)2.2;
	    Student_2.Grade = "A";
	    
	    
	    StudentGradeGenerator.StudentsInfo.add(Student_1);
	    StudentGradeGenerator.StudentsInfo.add(Student_2);

	    // call the function
	    boolean result = Gen.writeToOutputFile();

	    // assert the result is true, indicating successful file write
	    assertTrue(result);

	    // read the contents of the output file
	    Path output = Gen.getOutputFilePath();
	    List<String> lines = Files.readAllLines(output);

	    // check that the file contents match the expected output
	    assertEquals("Subject Name: Test Subject\t\t Max Mark: 100", lines.get(0));
	    assertEquals("Student name   Student number   GPA   Grade", lines.get(1));
	    assertEquals("Alice          1808551          3.2    B", lines.get(2));
	    assertEquals("Mayar          1807351          2.2    A", lines.get(3));
	}
	@Test 
	//To check the extension of the file at WriteToOutputFile()
	public void testWriteToOutputFileFormat() {
		Gen.writeToOutputFile();

		// Get the file extension of the output file 
		Path output = Gen.getOutputFilePath();

		// Assert that the file extension is "txt" 
		assertTrue(output.getFileName().toString().endsWith(".txt"));
		}
	
	
}
