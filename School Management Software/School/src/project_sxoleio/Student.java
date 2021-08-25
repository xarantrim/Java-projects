package project_sxoleio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Student {
	
	private int id;
	private String firstname;
	private String lastname;
	private String registration_number;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getRegistration_Number() {
		return registration_number;
	}

	public void setRegistration_Number(String registration_Number) {
		registration_number = registration_Number;
	}

	public Student() {
		
	}
	
	public Student(String firstname, String lastname, String registration_number) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.registration_number = registration_number;
	}
	
    public void save() throws SQLException {
    	try {
			Connection connection = SQLUtil.getConnection();
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			String sql = "INSERT INTO students (firstname, lastname, registration_number) VALUES ('"+this.firstname+"', '"+this.lastname+"', '"+this.registration_number+"')";
			System.out.println(sql);
			
			statement.execute(sql);
			
			
			statement.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }

	public static ArrayList<Student> getAllStudents() throws SQLException {
		// TODO Auto-generated method stub
		
		ArrayList<Student> students = new ArrayList<Student>();
				
				Connection connection = SQLUtil.getConnection();
				Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				
				String sql = "SELECT * FROM students";
				
				ResultSet resultSet = statement.executeQuery(sql);
				
				resultSet.first();
				
				while (!resultSet.isAfterLast()) {
					Student student = new Student(resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getString("registration_number"));

					students.add(student);
					resultSet.next();
				}
				
				return students;
		
	}
	
	
}
