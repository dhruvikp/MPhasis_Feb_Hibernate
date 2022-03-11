package com.simplilearn.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.entity.Courses;
import com.simplilearn.entity.EProduct;
import com.simplilearn.entity.PhoneNumber;
import com.simplilearn.entity.Student;

public class HibernateUtil {

	static SessionFactory sessionFactory;

	public static SessionFactory buildSessionFactory() {

		if (sessionFactory == null) {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			cfg.addAnnotatedClass(EProduct.class);
			cfg.addAnnotatedClass(PhoneNumber.class);
			cfg.addAnnotatedClass(Student.class);
			cfg.addAnnotatedClass(Courses.class);

			sessionFactory = cfg.buildSessionFactory();
		}
		return sessionFactory;
	}
}
