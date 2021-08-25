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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class NewStudent extends JFrame {

	private JPanel contentPane;
	private JTextField text_firstname;
	private JTextField text_lastname;
	private JTextField text_registration_number;
	private static JLabel txt_firstname;
	private static JLabel txt_lastname;
	private static JLabel txt_registration_number;
	private JTextField textField;





	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewStudent frame = new NewStudent();
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
	public NewStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_firstname = new JLabel("First Name");
		lbl_firstname.setBounds(75, 11, 132, 14);
		contentPane.add(lbl_firstname);
		
		JLabel lbl_lastname = new JLabel("Last Name");
		lbl_lastname.setBounds(75, 36, 132, 14);
		contentPane.add(lbl_lastname);
		
		JLabel lbl_registration_number = new JLabel("registration_number");
		lbl_registration_number.setBounds(75, 61, 132, 14);
		contentPane.add(lbl_registration_number);
		
		text_firstname = new JTextField();
		text_firstname.setBounds(257, 8, 127, 20);
		contentPane.add(text_firstname);
		text_firstname.setColumns(10);
		
		text_lastname = new JTextField();
		text_lastname.setBounds(257, 33, 127, 20);
		contentPane.add(text_lastname);
		text_lastname.setColumns(10);
		
		text_registration_number = new JTextField();
		text_registration_number.setBounds(257, 58, 127, 20);
		contentPane.add(text_registration_number);
		text_registration_number.setColumns(10);
		
		JButton btn_save = new JButton("Create Student");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Student student = new Student();
					
					student.setFirstname(text_firstname.getText());
					student.setLastname(text_firstname.getText());
					student.setRegistration_Number(text_registration_number.getText());
					
					try {
						student.save();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				
			}
		});
		btn_save.setBounds(163, 165, 171, 23);
		contentPane.add(btn_save);
		
		JButton btn_clear = new JButton("Clear");
		btn_clear.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		btn_clear.setBounds(206, 199, 89, 23);
		contentPane.add(btn_clear);
		
		
	}
	
	private void clear() {
		txt_firstname.setText("");
		txt_lastname.setText("");
		txt_registration_number.setText("");
	}
}
