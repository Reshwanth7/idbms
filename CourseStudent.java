package com.resh.jdbc;

public class CourseStudent {
private int course_id;
private int student_id;
private int marks;
private int attendance;


public CourseStudent(int course_id, int marks, int attendance) {
	
	this.course_id = course_id;
	this.marks = marks;
	this.attendance = attendance;
}
public CourseStudent(int course_id, int student_id, int marks, int attendance) {
	
	this.course_id = course_id;
	this.student_id = student_id;
	this.marks = marks;
	this.attendance = attendance;
}
public int getMarks() {
	return marks;
}
public void setMarks(int marks) {
	this.marks = marks;
}
public int getAttendance() {
	return attendance;
}
public void setAttendance(int attendance) {
	this.attendance = attendance;
}
public CourseStudent() {
	
}
public CourseStudent(int course_id, int student_id) {
	
	this.course_id = course_id;
	this.student_id = student_id;
}
public int getCourse_id() {
	return course_id;
}
public void setCourse_id(int course_id) {
	this.course_id = course_id;
}
public int getStudent_id() {
	return student_id;
}
public void setStudent_id(int student_id) {
	this.student_id = student_id;
}
@Override
public String toString() {
	return "CourseStudent [course_id=" + course_id + ", student_id=" + student_id + ", marks=" + marks + ", attendance="
			+ attendance + "]";
}

}
