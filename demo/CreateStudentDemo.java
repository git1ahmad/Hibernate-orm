package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create a sessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try{
			//create a student object 
			System.out.println("creating a  new student object... ...");
			Student tempstudent = new Student("ahmad","wall","ahmadninf@gmail.com");
			
			//begin a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student");
			session.save(tempstudent);
			
			//create a commit 
			session.getTransaction().commit();
			System.out.println("done");
			
			
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			factory.close();
		}
		
		
	}

}
