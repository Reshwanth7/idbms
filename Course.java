package com.resh.jdbc;

public class Course {
	private int id;
	private String title;
	private String instructor;
	public Course(String title, String instructor) {
		
		this.title = title;
		this.instructor = instructor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", Instructor=" + instructor + "]";
	}
	public Course(int id, String title, String instructor) {
	
		this.id = id;
		this.title = title;
		this.instructor = instructor;
	}
	

}
