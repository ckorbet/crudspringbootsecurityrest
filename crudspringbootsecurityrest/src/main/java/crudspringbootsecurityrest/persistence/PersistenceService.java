package crudspringbootsecurityrest.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import crudspringbootsecurityrest.model.Department;
import crudspringbootsecurityrest.model.Employee;

@Repository
public class PersistenceService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void createEmployee(final Employee employee) {
		entityManager.persist(employee);
	}
	
	public void createDepartment(final Department department) {
		entityManager.persist(department);
	}
	
	public Employee getEmployeeById(final String empId) {
		return entityManager.find(Employee.class, empId);
	}
	
	public Department getDepartmentById(final Long depId) {
		return entityManager.find(Department.class, depId);
	}
	
}
