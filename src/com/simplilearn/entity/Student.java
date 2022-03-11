package com.simplilearn.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student_11032022")
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "student_id")
	private long student_id;

	@Column(name = "student_fname")
	private String fname;

	@Column(name = "student_lname")
	private String lname;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<PhoneNumber> phoneNumbers;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_course_link", joinColumns = { @JoinColumn(name = "student_id") }, inverseJoinColumns = {
			@JoinColumn(name = "course_id") })
	private List<Courses> courses;
	
	@Embedded
	private Address address;

	

	public String getCourses() {

		StringBuilder sb = new StringBuilder();
		if (courses != null) {
			for (Courses course : courses) {
				sb.append(course.getCourseName() + ",");
			}
		}
		return sb.toString();

	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}

	public long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhoneNumbers() {
		StringBuilder sb = new StringBuilder();
		if (phoneNumbers != null) {
			for (PhoneNumber phoneNumber : phoneNumbers) {
				sb.append(phoneNumber.getPhoneNumber() + ",");
			}
		}
		return sb.toString();
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
}
