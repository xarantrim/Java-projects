package project_sxoleio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class NewCourse extends JFrame {

	private JPanel contentPane;
	private JTextField text_lessons;
	private JTextField text_lesson_code;
	private static JLabel txt_lessons;
	private static JLabel txt_lesson_code;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCourse frame = new NewCourse();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_lessons = new JLabel("Lesson");
		lbl_lessons.setBounds(75, 29, 86, 14);
		contentPane.add(lbl_lessons);
		
		JLabel lbl_lesson_code = new JLabel("Lesson Code");
		lbl_lesson_code.setBounds(75, 54, 86, 14);
		contentPane.add(lbl_lesson_code);
		
		text_lessons = new JTextField();
		text_lessons.setBounds(218, 26, 86, 20);
		contentPane.add(text_lessons);
		text_lessons.setColumns(10);
		
		text_lesson_code = new JTextField();
		text_lesson_code.setBounds(218, 54, 86, 20);
		contentPane.add(text_lesson_code);
		text_lesson_code.setColumns(10);
		
		JButton btn_save = new JButton("Add Course");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Course course = new Course();
				
				course.setLessons(text_lessons.getText());
				course.setLesson_code(text_lesson_code.getText());
				
				try {
					course.save();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_save.setBounds(158, 134, 146, 23);
		contentPane.add(btn_save);
	}
	

	private static void clear() {
		txt_lessons.setText("");
		txt_lesson_code.setText("");
	}

}
