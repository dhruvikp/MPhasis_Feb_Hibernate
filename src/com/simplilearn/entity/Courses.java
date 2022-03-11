package com.simplilearn.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.mysql.cj.Query.CancelStatus;

@Entity
@Table(name = "courses_11032022")
public class Courses {

	@Id
	@GeneratedValue
	@Column(name = "curse_id")
	private long courseId;

	@Column(name = "course_name")
	private String courseName;

	@Column(name = "course_type")
	private String courseType;
	
	@ManyToMany(mappedBy="courses", cascade = CascadeType.ALL)
	private List<Student> students;

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	

}
