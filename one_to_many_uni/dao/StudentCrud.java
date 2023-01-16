package one_to_many_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_many_uni.dto.School;
import one_to_many_uni.dto.Student;

public class StudentCrud {
	
		public EntityManager getEntity() {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	return entityManagerFactory.createEntityManager();
	}
		public void saveStudent(Student student) {
			EntityManager entityManager=getEntity();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(student);
			entityTransaction.commit();
		}
		public void updateStudent(int id,Student student) {
			EntityManager entityManager=getEntity();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityManager.find(Student.class, id);
			if(student!=null) {
			entityTransaction.begin();
			student.setId(id);
			entityManager.merge(student);
			entityTransaction.commit();
			
		}
	}
		public void deleteStudent(int id,Student student) {
			EntityManager entityManager=getEntity();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityManager.find(Student.class, id);
			if(student!=null) {
				entityTransaction.begin();
				student.setId(id);
				entityManager.remove(student);
				entityTransaction.commit();
			}
		}
		public Student getById(int id) {
			EntityManager entityManager=getEntity();
			Student student=entityManager.find(Student.class, id);
			return  student ;
		}
		public List<Student> getAll() {
			EntityManager entityManager=getEntity();
			Query query=entityManager.createQuery("select e from School e");
			List<Student> list=query.getResultList();
			return list;
			
		}
	}


