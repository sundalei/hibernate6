package com.shengsiyuan.hibernate;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
	private static SessionFactory sessionFactory;

	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
			sessionFactory = configuration.buildSessionFactory(registry);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		/*
		Student student = new Student();
		student.setName("wangwu");
		
		Course course = new Course();
		course.setName("economic");
		
		student.setCourses(new HashSet<Course>());
		course.setStudents(new HashSet<Student>());
		
		student.getCourses().add(course);
		course.getStudents().add(student);
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
			session.save(student);
			
			tx.commit();
		} catch(Exception ex) {
			if(null != tx) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			if(null != session) {
				session.close();
			}
		}
		*/
		
		/*
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
			Student student = session.get(Student.class, "297e364c540aee7401540aee76240000");
			Set<Course> set = student.getCourses();
			for(Iterator<Course> iter = set.iterator(); iter.hasNext();) {
				Course course = iter.next();
				System.out.println(course.getName());
			}
			
			tx.commit();
		} catch(Exception ex) {
			if(null != tx) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			if(null != session) {
				session.close();
			}
		}
		*/
		
		/*
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
			Student student = session.get(Student.class, "297e364c540aee7401540aee76240000");
			Course course = session.get(Course.class, "297e364c540af65701540af659930001");
			
			student.getCourses().add(course);
			course.getStudents().add(student);
			
			tx.commit();
		} catch(Exception ex) {
			if(null != tx) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			if(null != session) {
				session.close();
			}
			sessionFactory.close();
		}
		*/
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
			Student student = session.get(Student.class, "297e364c540aee7401540aee76240000");
			Course course = session.get(Course.class, "297e364c540af65701540af659930001");
			
			student.getCourses().remove(course);
			
			tx.commit();
		} catch(Exception ex) {
			if(null != tx) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			if(null != session) {
				session.close();
			}
			sessionFactory.close();
		}
		
	}
}
