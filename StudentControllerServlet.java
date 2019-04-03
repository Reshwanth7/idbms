package com.resh.jdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDbUtil studentDbUtil;
	@Resource(name="jdbc/student_course_tracker")
	private DataSource dataSource;
	
	public void init() throws ServletException {
	
		
		try {
			studentDbUtil = new StudentDbUtil(dataSource);
			}
		catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			String theCommand= request.getParameter("command");
			if(theCommand == null) {
				theCommand = "LISTCOURSES";
				
			}
			switch(theCommand) {
			case "LIST":
				listStudents(request,response);
				break;
			case "ADD":
				addStudent(request,response);
				break;
			case "LOAD":
				loadStudent(request,response);
				break;
			case "UPDATE":
				updateStudent(request,response);
				break;
			case "DELETE":
				 deleteStudent(request,response);
				 break;
			case "LISTCOURSES":
				listCourses(request,response);
				break;
			case "ADDCOURSE":
				addCourses(request,response);
				break;
			case "LOADCOURSE":
				loadCourses(request,response);
				break;
			case "DELETECOURSE":
				deleteCourses(request,response);
				break;
			case "UPDATECOURSE":
				updateCourse(request,response);
				break;
			case "LISTSTUDENTCOURSE":
				listStudentCourse(request,response);
				break;
			case "DELETESTUDENTCOURSE":
				deleteStudentCourse(request,response);
				break;
			
			case "COURSE":
				coursedetail(request,response);
				break;
			case "DETAILS":
				detail(request,response);
				break;
			case "UPDATEDETAIL":
				updatedetail(request,response);
				break;
			case "VIEW":
				view(request,response);
				break;
			case "SEARCH":
                searchStudents(request, response);
                break;
			case "SEARCHCOURSE":
                searchCourses(request, response);
                break;
			case "REGISTER":
				list(request,response);
				break;
			case "REGISTERSTUDENT":
				register(request,response);
				break;
			case "REGISTERC":
				listc(request,response);
				break;
			case "REGISTERCOURSE":
				register(request,response);
				break;
				default:
				listCourses(request,response);
				
			}
		}
		catch(Exception e) {
			throw new ServletException(e);
			
			
		}
	}


	private void listc(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
		int theId=Integer.parseInt(request.getParameter("studentId"));
		List<Course> courses = studentDbUtil.getCourses();
		request.setAttribute("Course_List",courses);
		request.setAttribute("studentId",theId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/registercourse-form.jsp");
		dispatcher.forward(request,response);
	}


	private void register(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException, SQLException {
		int theId=Integer.parseInt(request.getParameter("courseId"));
		int Id=Integer.parseInt(request.getParameter("studentId"));
		studentDbUtil.register(theId,Id);
		listStudentCourse(request,response);

	}


	private void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int theId=Integer.parseInt(request.getParameter("courseId"));
		List<Student> students = studentDbUtil.getStudents();
		request.setAttribute("Student_List",students);
		request.setAttribute("courseId",theId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/register-form.jsp");
		dispatcher.forward(request,response);
	}


	private void searchCourses(HttpServletRequest request, HttpServletResponse response) throws Exception, Exception {
		String theSearchName = request.getParameter("theSearchName");
        List<Course> courses = studentDbUtil.searchCourses(theSearchName);
        request.setAttribute("Course_List", courses);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-courses.jsp");
        dispatcher.forward(request, response);
	}


	private void searchStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String theSearchName = request.getParameter("theSearchName");
        List<Student> students = studentDbUtil.searchStudents(theSearchName);
        request.setAttribute("Student_List", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-student.jsp");
        dispatcher.forward(request, response);
    }


	private void view(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int theId=Integer.parseInt(request.getParameter("studentId"));
		int Id=Integer.parseInt(request.getParameter("courseId"));
		CourseStudent student = studentDbUtil.getDetails(theId,Id);
		request.setAttribute("Details",student);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Detailcourse-form.jsp");
		dispatcher.forward(request, response);
	}


	private void updatedetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int theId=Integer.parseInt(request.getParameter("courseId"));
		int Id=Integer.parseInt(request.getParameter("studentId"));
		int marks=Integer.parseInt(request.getParameter("marks"));
		int attendance=Integer.parseInt(request.getParameter("attendance"));
		CourseStudent theStudent = new CourseStudent(theId,Id,marks,attendance);
		studentDbUtil.updateDetail(theStudent);
		listStudentCourse(request,response);
	}


	private void detail(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
		int theId=Integer.parseInt(request.getParameter("studentId"));
		int Id=Integer.parseInt(request.getParameter("courseId"));
		CourseStudent student = studentDbUtil.getDetails(theId,Id);
		request.setAttribute("Details",student);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-Detailstudent-form.jsp");
		dispatcher.forward(request, response);
		

	}


	private void coursedetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int theId=Integer.parseInt(request.getParameter("studentId"));
		List<Course> course = studentDbUtil.getCourses(theId);
		request.setAttribute("Course_List",course);
		request.setAttribute("thestudent",theId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-coursesstudent.jsp");
		dispatcher.forward(request,response);
	}


	


	private void deleteStudentCourse(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("studentId"));
		studentDbUtil.deleteStudentCourse(id);
		listStudentCourses(request,response);
	}


	

	private void listStudentCourses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<Student> theStudents = studentDbUtil.getCourseStudent();
		request.setAttribute("Student_List",theStudents);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-studentCourse.jsp");
		dispatcher.forward(request,response);
	}


	private void listStudentCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int theId=Integer.parseInt(request.getParameter("courseId"));
		List<Student> theStudents = studentDbUtil.getCourseStudent(theId);
		request.setAttribute("Student_List",theStudents);
		request.setAttribute("theCourse",theId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-studentCourse.jsp");
		dispatcher.forward(request,response);
	}


	private void updateCourse(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id=Integer.parseInt(request.getParameter("courseId"));
		String title=request.getParameter("title");
		String instructor=request.getParameter("instructor");
		Course theCourse = new Course(id,title,instructor);
		studentDbUtil.updateCourse(theCourse);
		listCourses(request,response);
	}


	private void deleteCourses(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, Exception {
		int id=Integer.parseInt(request.getParameter("courseId"));
		studentDbUtil.deleteCourse(id);
		listCourses(request,response);
		
	}


	private void loadCourses(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String theCourseId=request.getParameter("courseId");
		Course theCourse=studentDbUtil.getCourse(theCourseId);
		request.setAttribute("The_Course",theCourse);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-course-form.jsp");
		dispatcher.forward(request, response);
		
	}


	private void addCourses(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String title=request.getParameter("title");
		String instructor=request.getParameter("instructor");
		
		Course theCourse = new Course(title,instructor);
		studentDbUtil.addCourse(theCourse);
		listCourses(request,response);
	}


	private void listCourses(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Course> courses = studentDbUtil.getCourses();
		request.setAttribute("Course_List",courses);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-courses.jsp");
		dispatcher.forward(request,response);
	}


	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int id=Integer.parseInt(request.getParameter("studentId"));
		studentDbUtil.deleteStudent(id);
		listStudents(request,response);
	}


	private void addStudent(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		
		Student theStudent = new Student(firstName,lastName,email);
		studentDbUtil.addStudent(theStudent);
		listStudents(request,response);
		

	}
private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
	List<Student> students = studentDbUtil.getStudents();
	request.setAttribute("Student_List",students);
	RequestDispatcher dispatcher = request.getRequestDispatcher("/list-student.jsp");
	dispatcher.forward(request,response);
	
}
private void loadStudent(HttpServletRequest request,HttpServletResponse response) throws Exception {
	String theStudentId=request.getParameter("studentId");
	Student theStudent=studentDbUtil.getStudent(theStudentId);
	request.setAttribute("The_Student",theStudent);
	RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student-form.jsp");
	dispatcher.forward(request, response);
	
}
private void updateStudent(HttpServletRequest request,HttpServletResponse response) throws Exception {
int id=Integer.parseInt(request.getParameter("studentId"));
String firstName=request.getParameter("firstName");
String lastName=request.getParameter("lastName");
String email=request.getParameter("email");
Student theStudent = new Student(id,firstName,lastName,email);
studentDbUtil.updateStudent(theStudent);
listStudents(request,response);


}
}