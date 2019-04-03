package com.resh.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {

	private  DataSource dataSource;

	public StudentDbUtil(DataSource theDataSource) {
		
		dataSource = theDataSource;
	}
	
	public List<Student> getStudents() throws Exception{
		 List<Student> students = new ArrayList<>();
		 Connection conn = null;
		 Statement st = null;
		 ResultSet rs = null;
		 
		 try {
			 
			 conn = dataSource.getConnection();
			 String sql = "select * from student order by last_name";
			 st = conn.createStatement();
			 
			 rs = st.executeQuery(sql);
			 while(rs.next()) {
				 int id = rs.getInt("id");
				 String firstName = rs.getString("first_name");
				 String lastName = rs.getString("last_name");
				 String email = rs.getString("email");
				 
				 Student tempStudent = new Student(id,firstName,lastName,email);
                 students.add(tempStudent);
			 }
			 return students;
			 
			 
		 }
		 finally {
			 close(conn,st,rs);
		 }
		 
		 
	}
	private   void close(Connection conn,Statement st, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public   void addStudent(Student theStudent) throws SQLException {
	Connection conn = null;
		 PreparedStatement st = null;
		 ResultSet rs = null;

		 try {
			 conn = dataSource.getConnection();
			 String sql = "insert into student "+"(first_name,last_name,email)"+"values(?,?,?)";
			 st = conn.prepareStatement(sql);
			 st.setString(1, theStudent.getFirstName());
			 st.setString(2, theStudent.getLastName());
			 st.setString(3, theStudent.getEmail());
			 st.execute();
		 }
		 finally {
			 close(conn,st,rs);
		 } 
	
}
	public Student getStudent(String theStudentId) throws Exception {
		
		Student theStudent=null;
		Connection conn = null;
		 PreparedStatement st = null;
		 ResultSet rs = null;
		 int studentId;
		 try {
			 studentId=Integer.parseInt(theStudentId);
			 conn = dataSource.getConnection();
			 String sql="select * from student where id=?";
			 st=conn.prepareStatement(sql);
			 st.setInt(1,studentId);
			 rs=st.executeQuery();
			 if(rs.next()) {
				 String firstName=rs.getString("first_name");
				 String lastName=rs.getString("last_name");
				 String email=rs.getString("email");
				 theStudent=new Student(studentId,firstName,lastName,email);
				 

			 }
			 else {
				 throw new Exception("student not found");
				 
			 }
			 return theStudent;
		 }
			 finally {
				 close(conn,st,rs);
				 
			 }
		 }

	public void updateStudent(Student theStudent) throws Exception {
		Connection conn = null;
		 PreparedStatement st = null;
		 try {
			 conn=dataSource.getConnection();
			 String sql="update student "+"set first_name=?,last_name=?,email=? "+"where id=?";
			 st = conn.prepareStatement(sql);
			 st.setString(1,theStudent.getFirstName());
			 st.setString(2,theStudent.getLastName());
			 st.setString(3,theStudent.getEmail());
			 st.setInt(4,theStudent.getId());
			 st.execute();

		 }
		finally {
			close(conn,st,null);
		}
	}

	public void deleteStudent(int id) throws Exception {
		
		Connection conn = null;
		 PreparedStatement st = null;
		 try {
			 conn=dataSource.getConnection();
			 String sql="delete from student where id=?";
			 st = conn.prepareStatement(sql);
			 st.setInt(1,id);
			 st.execute();
			 


	
	
	
	}
		 finally {
			 close(conn,st,null);
		 }
		
	}

	public List<Course> getCourses() throws SQLException {

		 List<Course> courses = new ArrayList<>();
		 Connection conn = null;
		 Statement st = null;
		 ResultSet rs = null;
		 
		 try {
			 
			 conn = dataSource.getConnection();
			 String sql = "select * from course";
			 st = conn.createStatement();
			 
			 rs = st.executeQuery(sql);
			 while(rs.next()) {
				 int id=rs.getInt("id");
				 String title = rs.getString("title");
				 String instructor = rs.getString("instructor");
				 
				 
				 Course tempCourse = new Course(id,title,instructor);
                 courses.add(tempCourse);
			 }
			 return courses;
			 
			 
		 }
		 finally {
			 close(conn,st,rs);
		 }
		 
	}

	public void addCourse(Course theCourse) throws SQLException {
		Connection conn = null;
		 PreparedStatement st = null;
		 ResultSet rs = null;

		 try {
			 conn = dataSource.getConnection();
			 String sql = "insert into course "+"(title,instructor)"+"values(?,?)";
			 st = conn.prepareStatement(sql);
			 st.setString(1, theCourse.getTitle());
			 st.setString(2, theCourse.getInstructor());
			 st.execute();
		 }
		 finally {
			 close(conn,st,rs);
		 } 
	}

	public void deleteCourse(int id) throws SQLException {
		
		Connection conn = null;
		 PreparedStatement st = null;
		 try {
			 conn=dataSource.getConnection();
			 String sql="delete from course where id=?";
			 st = conn.prepareStatement(sql);
			 st.setInt(1,id);
			 st.execute();
			 


	
	
	
	}
		 finally {
			 close(conn,st,null);
		 }
		
	}

	public Course getCourse(String theCourseId) throws Exception {
		Course theCourse=null;
		Connection conn = null;
		 PreparedStatement st = null;
		 ResultSet rs = null;
		 int courseId;
		 try {
			 courseId=Integer.parseInt(theCourseId);
			 conn = dataSource.getConnection();
			 String sql="select * from course where id=?";
			 st=conn.prepareStatement(sql);
			 st.setInt(1,courseId);
			 rs=st.executeQuery();
			 if(rs.next()) {
				 String title=rs.getString("title");
				 String instructor=rs.getString("instructor");
				 theCourse=new Course(courseId,title,instructor);
				 

			 }
			 else {
				 throw new Exception("Course not found");
				 
			 }
			 return theCourse;
		 }
			 finally {
				 close(conn,st,rs);
				 
			 }
		
	}

	public void updateCourse(Course theCourse) throws SQLException {
		Connection conn = null;
		 PreparedStatement st = null;
		 try {
			 conn=dataSource.getConnection();
			 String sql="update course "+"set title=?,instructor=? "+"where id=?";
			 st = conn.prepareStatement(sql);
			 st.setString(1,theCourse.getTitle());
			 st.setString(2,theCourse.getInstructor());
			 st.setInt(3,theCourse.getId());
			 st.execute();

		 }
		finally {
			close(conn,st,null);
		}
		
	}

	public List<Student> getCourseStudent(int id) throws SQLException {
		List<Student> students = new ArrayList<>();
		
		 Connection conn = null;
		 Statement st = null;
		 PreparedStatement std = null;

		 ResultSet rs = null;
		 
		 try {

			 conn = dataSource.getConnection();
			 String sql = "select * from student"+" where id in "+"(select student_id from course_student "+"where course_id=? ) ";
			 std=conn.prepareStatement(sql);
			 std.setInt(1,id);
			 rs = std.executeQuery();
			 while(rs.next()) {
				 int theid = rs.getInt("id");
				 String firstName = rs.getString("first_name");
				 String lastName = rs.getString("last_name");
				 String email = rs.getString("email");
				 
				 Student tempStudent = new Student(theid,firstName,lastName,email);
                students.add(tempStudent);
			 }
			 return students;
			 
			 
		 }
		 finally {
			 close(conn,st,rs);
		 }
		 
		
	}

	public void deleteStudentCourse(int id) throws SQLException {
		Connection conn = null;
		 PreparedStatement st = null;
		 try {
			 conn=dataSource.getConnection();
			 String sql="delete from course_student where student_id=?";
			 st = conn.prepareStatement(sql);
			 st.setInt(1,id);
			 st.execute();
			 


	
	
	
	}
		 finally {
			 close(conn,st,null);
		 }
		
	}

	public List<Student> getCourseStudent() throws SQLException {
		 List<Student> students = new ArrayList<>();
		 Connection conn = null;
		 Statement st = null;
		 ResultSet rs = null;
		 
		 try {
			 
			 conn = dataSource.getConnection();
			 String sql = "select * from student"+" where id in "+"(select student_id from course_student)";
			 st = conn.createStatement();
			 
			 rs = st.executeQuery(sql);
			 while(rs.next()) {
				 int id = rs.getInt("id");
				 String firstName = rs.getString("first_name");
				 String lastName = rs.getString("last_name");
				 String email = rs.getString("email");
				 
				 Student tempStudent = new Student(id,firstName,lastName,email);
                 students.add(tempStudent);
			 }
			 return students;
			 
			 
		 }
		 finally {
			 close(conn,st,rs);
		 }
		
	}

	

	public List<Course> getCourses(int theId) throws Exception {
		List<Course> courses = new ArrayList<>();
		
		 Connection conn = null;
		 Statement st = null;
		 PreparedStatement std = null;

		 ResultSet rs = null;
		 
		 try {

			 conn = dataSource.getConnection();
			 String sql = "select * from course"+" where id in "+"(select course_id from course_student "+"where student_id=? ) ";
			 std=conn.prepareStatement(sql);
			 std.setInt(1,theId);
			 rs = std.executeQuery();
			 while(rs.next()) {
				 int theid = rs.getInt("id");
				 String title = rs.getString("title");
				 String instructor = rs.getString("instructor");
				 
				 
				 Course tempCourse = new Course(theid,title,instructor);
               courses.add(tempCourse);
			 }
			 return courses;
	}
		 finally {
				close(conn,st,null);
			}

	}

	public CourseStudent getDetails(int theId,int Id) throws Exception {
		
		CourseStudent theStudent=null;
		Connection conn = null;
		 PreparedStatement st = null;
		 ResultSet rs = null;
		
		 try {
			 
			 conn = dataSource.getConnection();
			 String sql="select * from course_student where student_id=? and course_id=?";
			 st=conn.prepareStatement(sql);
			 st.setInt(1,theId);
			 st.setInt(2,Id);
			 rs=st.executeQuery();
			 if(rs.next()) {
				 int marks=rs.getInt("marks");
				 int attendance=rs.getInt("attendance");
				 theStudent=new CourseStudent(Id,theId,marks,attendance);
				 

			 }
			 else {
				 throw new Exception("student not found");
				 
			 }
			 return theStudent;
		 }
			 finally {
				 close(conn,st,rs);
				 
			 }
	}

	public void updateDetail(CourseStudent theStudent) throws SQLException {
		Connection conn = null;
		 PreparedStatement st = null;
		 try {
			 conn=dataSource.getConnection();
			 String sql="update course_student "+"set marks=?,attendance=? "+"where course_id=? and student_id=?";
			 st = conn.prepareStatement(sql);
			 st.setInt(1,theStudent.getMarks());
			 st.setInt(2,theStudent.getAttendance());
			 st.setInt(3,theStudent.getCourse_id());
			 st.setInt(4,theStudent.getStudent_id());
			 st.execute();

		 }
		finally {
			close(conn,st,null);
		}
		
	}
	 public List<Student> searchStudents(String theSearchName)  throws Exception {
	        List<Student> students = new ArrayList<>();
	        
	        Connection myConn = null;
	        PreparedStatement myStmt = null;
	        ResultSet myRs = null;
	        
	        try {
	            
	            myConn = dataSource.getConnection();
	            
	           
	            if (theSearchName != null && theSearchName.trim().length() > 0) {
	                String sql = "select * from student where lower(first_name) like ? or lower(last_name) like ?";
	                myStmt = myConn.prepareStatement(sql);
	                String theSearchNameLike = "%" + theSearchName.toLowerCase() + "%";
	                myStmt.setString(1, theSearchNameLike);
	                myStmt.setString(2, theSearchNameLike);
	                
	            } else {
	                String sql = "select * from student order by last_name";
	                myStmt = myConn.prepareStatement(sql);
	            }
	            
	            myRs = myStmt.executeQuery();
	            
	            while (myRs.next()) {
	                
	                int id = myRs.getInt("id");
	                String firstName = myRs.getString("first_name");
	                String lastName = myRs.getString("last_name");
	                String email = myRs.getString("email");
	                
	                Student tempStudent = new Student(id, firstName, lastName, email);
	                
	                students.add(tempStudent);            
	            }
	            
	            return students;
	        }
	        finally {
	            close(myConn, myStmt, myRs);
	        }
	    }

	public List<Course> searchCourses(String theSearchName) throws Exception {
		List<Course> courses = new ArrayList<>();
        
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        
        try {
            
            myConn = dataSource.getConnection();
            
           
            if (theSearchName != null && theSearchName.trim().length() > 0) {
                String sql = "select * from course where lower(title) like ? ";
                myStmt = myConn.prepareStatement(sql);
                String theSearchNameLike = "%" + theSearchName.toLowerCase() + "%";
                myStmt.setString(1, theSearchNameLike);
                
            } else {
                String sql = "select * from course";
                myStmt = myConn.prepareStatement(sql);
            }
            
            myRs = myStmt.executeQuery();
            
            while (myRs.next()) {
                
                int id = myRs.getInt("id");
                String title = myRs.getString("title");
                String instructor = myRs.getString("instructor");
                
                
                Course tempCourse = new Course(id, title, instructor);
                
                courses.add(tempCourse);            
            }
            
            return courses;
        }
        finally {
            close(myConn, myStmt, myRs);
        }
	}

	public void register(int theId, int id) throws Exception {
		 
		Connection conn = null;
		PreparedStatement st = null;
        ResultSet rs = null;
        try {
            
            conn = dataSource.getConnection();
            String sql="insert into course_student(course_id,student_id) values(?,?)";
            st=conn.prepareStatement(sql);
			 st.setInt(1,theId);
			 st.setInt(2,id);
			 st.executeUpdate();
        }
        
			 finally {
				 close(conn,st,rs);
				 
			 }
	}
	
}

