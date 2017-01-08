package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//create a sessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try{
			//create a student object 
			System.out.println("creating a  new student object... ...");
			Student tempstudent = new Student("daffy","duck","dafy@gmail.com");
					
			//begin a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student");
			System.out.println(tempstudent);
			session.save(tempstudent);
						
			//create a commit transaction
			session.getTransaction().commit();
			
			//My new code
			//Find out students primary key 
			System.out.println("Saved Student.GeneratedId:"+tempstudent.getId());
		
			
			//Now get a new Session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on id:primary Key
			System.out.println("\n Getting Student with id:"+tempstudent.getId());
			Student myStudent = session.get(Student.class, tempstudent.getId());
			
			System.out.println("Get Complete :"+myStudent);
			
			//commit the transaction
			session.getTransaction().commit();
		
			System.out.println("Done!!");
			
			
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			factory.close();
		}
		
		
	}

}
