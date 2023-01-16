package one_to_many_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import antlr.collections.List;
import one_to_many_uni.dto.Company;
import one_to_many_uni.dto.Employee;

public class CompanyCrud {
public EntityManager getEntityManager() {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager =entityManagerFactory.createEntityManager();
	return entityManager;
}
public void saveCompany(Company company) {
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	java.util.List<Employee> employees=company.getList();
	for(Employee employee: employees) {
		entityManager.persist(employee);
	}
	entityManager.persist(company);
	
	entityTransaction.commit();
}
public void updateCompany(int id,Company company) {
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityManager.find(Company.class, id);
	
	if(company!=null) {
	entityTransaction.begin();
	company.setcId(id);
	company.setList(company.getList());
	entityManager.merge(company);
	entityTransaction.commit();
	}
}
public void deleteCompany(int id) {
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Company company=entityManager.find(Company.class, id);
	company.setcId(id);
	if(company!=null) {
	entityTransaction.begin();
	entityManager.remove(company);
	entityManager.remove(company.getList());
	entityTransaction.commit();
}
	
}
public Company getCompany(int id) {
	EntityManager entityManager=getEntityManager();
	Company company=entityManager.find(Company.class, id);
	return company;
}
public java.util.List<Company> getAll(){
	EntityManager entityManager=getEntityManager();
	Query query=entityManager.createQuery("select e from Company e");
	java.util.List<Company> list=query.getResultList();
	return list;
}
	
}

