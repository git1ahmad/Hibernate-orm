package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			
			//delete the student
			//System.out.println("Deleting the student... .."+myStudent);
			//session.delete(myStudent);
			
		    //delete student id 2
			System.out.println("Deleting student id 2");
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			
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
