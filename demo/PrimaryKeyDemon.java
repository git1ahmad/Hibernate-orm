package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemon {

	public static void main(String[] args) {
		//create a sessionFactory
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
				
				//create a session
				Session session = factory.getCurrentSession();
				
				try{
					//create a student object 
					System.out.println("creating   new student objects... ...");
					Student tempstudent1 = new Student("ahmad","wall","ahmadninf@gmail.com");
					Student tempstudent2 = new Student("sumon","eee","sumoninf@gmail.com");
					Student tempstudent3 = new Student("mustahid","ppp","mustahidninf@gmail.com");
					
					//begin a transaction
					session.beginTransaction();
					
					//save the student objects
					System.out.println("Saving the students...:");
					session.save(tempstudent1);
					session.save(tempstudent2);
					session.save(tempstudent3);
					
					//create a commit 
					session.getTransaction().commit();
					System.out.println("Done");
					
					
				}catch (Exception e){
					e.printStackTrace();
				}finally {
					factory.close();
				}

	}

}
