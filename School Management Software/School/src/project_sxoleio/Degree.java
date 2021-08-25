package project_sxoleio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Degree {
	
	private int id;
	private String grades;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGrades() {
		return grades;
	}
	public void setGrades(String grades) {
		this.grades = grades;
	}


	public void save() throws SQLException {
		try {
			Connection connection = SQLUtil.getConnection();
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	
			String sql = "INSERT INTO degrees (grades) VALUES ('"+this.grades+"')";
			System.out.println(sql);
			
			statement.execute(sql);
			
			
			statement.close();
	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}