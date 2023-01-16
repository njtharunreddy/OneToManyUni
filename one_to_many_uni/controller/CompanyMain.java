package one_to_many_uni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one_to_many_uni.dao.CompanyCrud;
import one_to_many_uni.dto.Company;
import one_to_many_uni.dto.Employee;

public class CompanyMain {
	public static void main(String[] args) {
		Employee e1 = new Employee();
		e1.setName("Tharun NJ");
		e1.setAddress("BAngalore");
		e1.setPhone(89939892);

		Employee e2 = new Employee();
		e2.setName("Mahesh");
		e2.setAddress("Chennai");
		e2.setPhone(89934567);

		Employee e3 = new Employee();
		e3.setName("Raju");
		e3.setAddress("Hyderabad");
		e3.setPhone(887676464);

		Company company = new Company();
		company.setcName("TY");
		company.setcGst("abc345");

		List<Employee> list = new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);

		company.setList(list);
		

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
        CompanyCrud companyCrud=new CompanyCrud();
		
		Company company1 = new Company();
		company1.setcName("TY");
		company1.setcGst("abc34");
		entityTransaction.begin();
		entityManager.persist(e1);
		entityManager.persist(e2);
		entityManager.persist(e3);
		entityManager.persist(company);
        companyCrud.updateCompany(2, company);
        entityTransaction.commit();
		

	}
}
