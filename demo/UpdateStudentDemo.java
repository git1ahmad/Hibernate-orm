package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create a  sessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try{
			//create a student object 
			int studentId=1;
			
			
			//Now get a new Session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on id:primary Key
			System.out.println("\n Getting Student with id:"+studentId);
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating Students");
			myStudent.setFirstName("Scooby"); //save to memory
			
			//commit the transaction
			session.getTransaction().commit(); //save to database 
		
			System.out.println("Done!!");
			
			
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			factory.close();
		}
		
		
	}

}
