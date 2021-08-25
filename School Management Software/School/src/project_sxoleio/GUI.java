package project_sxoleio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.Button;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI {

	private JFrame frame;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1197, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btn_newstudent = new JButton("Create New Student");
		btn_newstudent.setBounds(403, 11, 356, 30);
		btn_newstudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			NewStudent newStudent = new NewStudent();
			newStudent.show(true);
		}{
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btn_newstudent);
		
		JButton btn_newcourse = new JButton("Add New Course");
		btn_newcourse.setBounds(403, 80, 356, 23);
		btn_newcourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				NewCourse newCourse = new NewCourse();
				newCourse.show(true);
			
			}
		});
		frame.getContentPane().add(btn_newcourse);
		
	
		
		
		Student[] studentsArray;
		Course[] coursesArray;
		try {
			ArrayList<Student> students = Student.getAllStudents();
			studentsArray = new Student[students.size()];
			
			for (int i=0; i<students.size(); i++) {
				studentsArray[i] = students.get(i);
			}
			
			ArrayList<Course> courses = Course.getAllCourses();
			coursesArray = new Course[courses.size()];
			
			for(int i=0; i<courses.size(); i++) {
				coursesArray[i] = courses.get(i);
			}
					
			
			
			JList<?> list_forstudents = new JList<Object>(studentsArray);
			list_forstudents.setBounds(769, 85, 402, 302);
			frame.getContentPane().add(list_forstudents);
			
			JList<?> list_forcourses = new JList<Object>(coursesArray);
			list_forcourses.setBounds(10, 11, 383, 376);
			frame.getContentPane().add(list_forcourses);
			
			JButton btn_add_degree = new JButton("Add Degree");
			btn_add_degree.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					NewDegree newDegree = new NewDegree();
					newDegree.show(true);
				
				}
				
			});
			btn_add_degree.setBounds(403, 157, 356, 23);
			frame.getContentPane().add(btn_add_degree);
			
			JLabel lbl_degree_message = new JLabel("Please select a Student and a Course and click below");
			lbl_degree_message.setBounds(413, 114, 346, 32);
			frame.getContentPane().add(lbl_degree_message);
			
			JLabel lbl_list_of_grades = new JLabel("Select a Student and click below to see the grades");
			lbl_list_of_grades.setBounds(424, 249, 335, 23);
			frame.getContentPane().add(lbl_list_of_grades);
			
			JButton btn_list_of_grades = new JButton("A list of student grades");
			btn_list_of_grades.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StudentGradeList studentGradeList = new StudentGradeList();
					studentGradeList.show(true);
				}
			});
			btn_list_of_grades.setBounds(403, 284, 356, 23);
			frame.getContentPane().add(btn_list_of_grades);
			
			JLabel lbl_search = new JLabel("Search Student");
			lbl_search.setBounds(947, 12, 86, 14);
			frame.getContentPane().add(lbl_search);
			
			textField = new JTextField();
			textField.setText("");
			textField.setBounds(947, 36, 86, 20);
			frame.getContentPane().add(textField);
			textField.setColumns(10);
			
		
		
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void addDegree() {
		
	}
}
