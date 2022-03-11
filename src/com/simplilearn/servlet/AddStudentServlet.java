package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.entity.PhoneNumber;
import com.simplilearn.entity.Student;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/add-student")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("add-student.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Read data
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");

		String phone1 = request.getParameter("phone_1");
		String type1 = request.getParameter("types1");

		String phone2 = request.getParameter("phone_2");
		String type2 = request.getParameter("types2");

		String phone3 = request.getParameter("phone_3");
		String type3 = request.getParameter("types3");

		Student student = new Student();
		student.setFname(fname);
		student.setLname(lname);
		List<PhoneNumber> phones = new ArrayList<>();
		PhoneNumber ph1 = new PhoneNumber();
		ph1.setPhoneType(type1);
		ph1.setPhoneNumber(phone1);
		ph1.setStudent(student);
		phones.add(ph1);

		PhoneNumber ph2 = new PhoneNumber();
		ph2.setPhoneType(type2);
		ph2.setPhoneNumber(phone2);
		ph2.setStudent(student);
		phones.add(ph2);

		PhoneNumber ph3 = new PhoneNumber();
		ph3.setPhoneType(type3);
		ph3.setPhoneNumber(phone3);
		ph3.setStudent(student);
		phones.add(ph3);

		student.setPhoneNumbers(phones);

		// Save data in db
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.save(student);
		tx.commit();

		// Print respnse
		PrintWriter out = response.getWriter();
		out.println("<html><body><h4>Student saved successfully!</h4></body></html>");

	}

}
