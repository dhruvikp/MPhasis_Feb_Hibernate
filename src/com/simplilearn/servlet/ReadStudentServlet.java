package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.entity.Student;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class ReadStudentServlet
 */
@WebServlet("/read-student")
public class ReadStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadStudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		SessionFactory sf = HibernateUtil.buildSessionFactory();

		Session session = sf.openSession();

		List<Student> students = session.createQuery(" from Student").list();

		out.println("<h1> Student List:- </h1>");
		out.println("<style> table,td,th { border:2px solid green; padding:10px;} </style>");
		out.println("<table> <tr>");
		out.print("<th> Student ID </th>");
		out.print("<th> FirstName </th>");

		out.print("<th> LastName </th>");
		out.print("<th> PhoneNumbers</th>");
		out.print("<th> Courses</th>");
		
		out.print("<th> Address</th>");
		
		out.print("</tr>");

		for (Student student : students) {
			out.print("<tr>");
			out.print("<td>"+student.getStudent_id()+"</td>");
			out.print("<td>"+student.getFname()+"</td>");
			out.print("<td>"+student.getLname()+"</td>");
			out.print("<td>"+student.getPhoneNumbers()+"</td>");
			out.print("<td>"+student.getCourses()+"</td>");
			out.print("<td>"+student.getAddress()+"</td>");
			out.print("</tr>");
		}
		out.print("</table></body></html>");
		session.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
