package crudspringbootsecurityrest.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import crudspringbootsecurityrest.model.Department;
import crudspringbootsecurityrest.model.Employee;
import crudspringbootsecurityrest.persistence.PersistenceService;

@Service
@Transactional
public class EmployeeBusinessService {

	@Autowired
	private PersistenceService persistenceService;
	
	public Employee createEmployee(final String name, final String lastName, final boolean active) {
		final Employee employee = new Employee(name, lastName, active);
		persistenceService.createEmployee(employee);
		return employee;
	}
	
	public Employee createEmployee(final String name, final String lastName, final boolean active, final String empId) {
		final Employee employee = new Employee(name, lastName, active, new Department(Long.valueOf(empId)));
		persistenceService.createEmployee(employee);
		return employee;
	}
	
	public Employee getEmployeeById(final String empId) {
		return persistenceService.getEmployeeById(empId);
	}
}
