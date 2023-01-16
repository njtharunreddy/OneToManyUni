package one_to_many_uni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one_to_many_uni.dao.SchoolCrud;
import one_to_many_uni.dto.School;
import one_to_many_uni.dto.Student;

public class SchoolMain {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Student student=new Student();
		student.setId(1);
		student.setName("Manoj");
		student.setAddress("Bangalore");
		student.setAge(14);
		
		Student student1=new Student();
		student1.setId(2);
		student1.setName("Akhil");
		student1.setAddress("Bangalore");
		student1.setAge(13);
		
		Student student2=new Student();
		student2.setId(3);
		student2.setName("Manvanth");
		student2.setAddress("Bangalore");
		student2.setAge(12);
        
		
		School school=new School();
		school.setSid(1);
		school.setSchoolName("SVN");
		school.setSchoolAddress("Nagawara");
		
		List<Student> list=new ArrayList<Student>();
		list.add(student);
		list.add(student1);
		list.add(student2);
	
		entityTransaction.begin();
		for(Student s:list) {
	
		entityManager.persist(s);
		}
		entityTransaction.commit();
	}

}
