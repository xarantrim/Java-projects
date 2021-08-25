package project_sxoleio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Course {
	
	private int id;
	private String lessons;
	private String lesson_code;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getLessons() {
		return lessons;
	}



	public void setLessons(String lessons) {
		this.lessons = lessons;
	}



	public String getLesson_code() {
		return lesson_code;
	}



	public void setLesson_code(String lesson_code) {
		this.lesson_code = lesson_code;
	}



	public Course() {
		
	}
	
	public Course(String lessons, String lesson_code) {
		this.lessons = lessons;
		this.lesson_code = lesson_code;
	}
	
	public void save() throws SQLException {
    	try {
			Connection connection = SQLUtil.getConnection();
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			String sql = "INSERT INTO courses (lessons, lesson_code) VALUES ('"+this.lessons+"', '"+this.lesson_code+"')";
			System.out.println(sql);
			
			statement.execute(sql);
			
			
			statement.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }



	public static ArrayList<Course> getAllCourses() throws SQLException {
		// TODO Auto-generated method stub
		
		ArrayList<Course> courses = new ArrayList<Course>();
				
				Connection connection = SQLUtil.getConnection();
				Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				
				String sql = "SELECT * FROM courses";
				
				ResultSet resultSet = statement.executeQuery(sql);
				
				resultSet.first();
				
				while (!resultSet.isAfterLast()) {
					Course course = new Course(resultSet.getString("lessons"), resultSet.getString("lesson_code"));

					courses.add(course);
					resultSet.next();
				}
				
				return courses;
		
	}
}
