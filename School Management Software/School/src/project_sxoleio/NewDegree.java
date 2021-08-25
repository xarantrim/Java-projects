package project_sxoleio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class NewDegree extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField text_degree;
	private JTextField text_add_degree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewDegree frame = new NewDegree();
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
	public NewDegree() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		text_degree = new JTextField();
		text_degree.setBounds(176, 53, 86, 20);
		contentPane.add(text_degree);
		text_degree.setColumns(10);
		
		JLabel lbl_degree = new JLabel("The Degree is:");
		lbl_degree.setBounds(62, 56, 86, 14);
		contentPane.add(lbl_degree);
		
		JLabel lbl_add_degree = new JLabel("or Add Degree");
		lbl_add_degree.setBounds(62, 147, 86, 14);
		contentPane.add(lbl_add_degree);
		
		text_add_degree = new JTextField();
		text_add_degree.setBounds(176, 144, 86, 20);
		contentPane.add(text_add_degree);
		text_add_degree.setColumns(10);
		
		JButton btn_save = new JButton("Save Degree");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Degree degree = new Degree();
				
				degree.setGrades(text_add_degree.getText());
				
				try {
					degree.save();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btn_save.setBounds(160, 175, 117, 23);
		contentPane.add(btn_save);
	}
}
