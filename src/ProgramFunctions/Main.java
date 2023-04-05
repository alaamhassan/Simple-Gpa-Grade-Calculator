package ProgramFunctions;

public class Main {

	public static void main(String[] args) {
<<<<<<< HEAD
//		// TODO Auto-generated method stub
//         
//		StudentGradeGenerator g =new StudentGradeGenerator();
//		
//		g.ParseInput("C:\\Users\\win10\\Downloads\\testing-csvfile\\csv.txt");
//		
//		System.out.println(g.getError());
//		
//		System.out.println(g.getParsedInput());
//		
=======

		StudentGradeGenerator g =new StudentGradeGenerator();
		
		g.ParseInput("C:\\Users\\hp\\Desktop\\csv.txt");
		g.gradeAndGPACalculator(g.getStudentsInfo());
		g.writeToOutputFile(g.getStudentsInfo(), g.getSubjectName(), g.getFullMark());
		
		if (g.getError() != null) {
			System.out.println(g.getError());
		}
		
		//System.out.println(g.getParsedInput());
		
>>>>>>> main
	}

}
