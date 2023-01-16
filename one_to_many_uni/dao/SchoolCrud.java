package one_to_many_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_many_uni.dto.School;
import one_to_many_uni.dto.Student;

public class SchoolCrud {
	public EntityManager getEntity() {
EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
return entityManagerFactory.createEntityManager();
}
	public void saveSchool(School school) {
		EntityManager entityManager=getEntity();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		List<Student> list=school.getList();
		for(Student student:list) {
			entityManager.persist(student);	
		}
		entityManager.persist(school);
		
		entityTransaction.commit();
	}
	public void updateSchool(int id,School school) {
		EntityManager entityManager=getEntity();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityManager.find(School.class, id);
		if(school!=null) {
		entityTransaction.begin();
		school.setSid(id);
		school.setList(school.getList());
		entityManager.merge(school);
		entityTransaction.commit();
		
	}
}
	public void deleteSchool(int id,School school) {
		EntityManager entityManager=getEntity();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityManager.find(School.class, id);
		if(school!=null) {
			entityTransaction.begin();
			school.setSid(id);
			entityManager.remove(school.getList());
			entityManager.remove(school);
			entityTransaction.commit();
		}
	}
	public School getById(int id) {
		EntityManager entityManager=getEntity();
		School school=entityManager.find(School.class, id);
		return school;
	}
	public List<School> getAll() {
		EntityManager entityManager=getEntity();
		Query query=entityManager.createQuery("select e from School e");
		List<School> list=query.getResultList();
		return list;
		
	}
}
