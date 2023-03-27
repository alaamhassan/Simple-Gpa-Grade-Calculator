package ProgramFunctions;

public class Main {

	public static void main(String[] args) {

		StudentGradeGenerator g =new StudentGradeGenerator();
		
		g.ParseInput("C:\\Users\\hp\\Desktop\\csv.txt");
		g.gradeAndGPACalculator(g.getStudentsInfo());
		g.writeToOutputFile(g.getStudentsInfo(), g.getSubjectName(), g.getFullMark());
		
		if (g.getError() != null) {
			System.out.println(g.getError());
		}
		
		//System.out.println(g.getParsedInput());
		
	}

}
