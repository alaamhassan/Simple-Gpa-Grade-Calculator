package Frames;
/*********************Libraries***************************/
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import java.util.ArrayList;
import java.util.Scanner;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Label;
import ProgramFunctions.StudentGradeGenerator;
public class Frame_1 {

	private JFrame frmCdssvb;
	//protected String fileContent = "";
	//StudentGradeGenerator studentGrades = new StudentGradeGenerator();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Frame_1 window = new Frame_1();
					window.frmCdssvb.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame_1() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCdssvb = new JFrame();
		frmCdssvb.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
		frmCdssvb.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Mayar El-Mallah\\OneDrive\\Pictures\\Screenshots\\unnamed.png"));
		frmCdssvb.setTitle("GPA Calculator");
		frmCdssvb.setBounds(100, 100, 429, 244);
		frmCdssvb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Label_1
		JLabel lblNewLabel = new JLabel("Select File:");
		lblNewLabel.setFont(new Font("Sitka Small", Font.PLAIN, 11));
		lblNewLabel.setLabelFor(frmCdssvb);
		
		//Label_2 to write the path of the selected file
		JLabel lblNewLabel_2 = new JLabel("No file is selected");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		/*************Browse Files Button_1*****************/
		JButton btnNewButton_1 = new JButton("Browse Files");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileContent = "";
				if(e.getSource()== btnNewButton_1) {
					//Select the file
					JFileChooser fileChooser = new JFileChooser();
					//Open the file
					int response = fileChooser.showOpenDialog(null);
					if(response == JFileChooser.APPROVE_OPTION) {
						lblNewLabel_2.setText(fileChooser.getSelectedFile().getAbsolutePath());
						/*File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
		                //Scan the file to read it
						try (Scanner scan = new Scanner(file)) {
							while(scan.hasNextLine()) {
								fileContent = fileContent.concat(scan.nextLine() + "\n");
								}
							}
							
						catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.out.println(fileContent);
						*/
						StudentGradeGenerator.ParseInput(fileChooser.getSelectedFile().getAbsolutePath());
						//Error Message
						if (StudentGradeGenerator.getError() != "")
						JOptionPane.showMessageDialog(btnNewButton_1,StudentGradeGenerator.getError(),"Error Message", JOptionPane.PLAIN_MESSAGE);			
							
								
					}
					else
						lblNewLabel_2.setText("The user cancelled the operation");
				}
			}
		});
		
		
		/****************Calculate Button_2************/
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setToolTipText("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentGradeGenerator.gradeAndGPACalculator();
				StudentGradeGenerator.writeToOutputFile();
				Path FilePath =StudentGradeGenerator.getOutputFilePath();
				//Path Visualization
				JOptionPane.showMessageDialog(btnNewButton,FilePath,"The Path Message", JOptionPane.PLAIN_MESSAGE);
				
				
				//The Output String
				//String fileContent = "mayar,mohamed \nMariam,Ezzat";
				
				/*try {
					//Convert from string to a file
					//FileWriter	writer = new FileWriter("output.csv");
					//writer.write(fileContent);
					writer.close();
					
					//The output
					Path path = Paths.get("output.txt");
					System.out.println("The Output File's Path: "+path.toAbsolutePath());
					System.out.println("The File's Content: ");
					
					//Read the File
					BufferedReader reader = new BufferedReader(new FileReader("output.csv"));
					String line;
				    while ((line = reader.readLine()) != null)
				    {
				      System.out.println(line);
				    }
				
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				
			}
		});
		
		
		
		/***************Quit Button_3*********************/
		JButton btnNewButton_2 = new JButton("Quit");
		btnNewButton_2.addActionListener((event) -> System.exit(0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(frmCdssvb.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(69)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
							.addGap(90)
							.addGap(6))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(336, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		frmCdssvb.getContentPane().setLayout(groupLayout);
	}
}