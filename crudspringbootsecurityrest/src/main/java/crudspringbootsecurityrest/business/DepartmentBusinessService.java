package crudspringbootsecurityrest.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import crudspringbootsecurityrest.model.Department;
import crudspringbootsecurityrest.persistence.PersistenceService;

@Service
@Transactional
public class DepartmentBusinessService {

	@Autowired
	private PersistenceService persistenceService;
	
	public Department createDepartment(final String name) {
		final Department department = new Department(name);
		persistenceService.createDepartment(department);
		return department;
	}
	
	public Department getDepartmentById(final String depId) {
		return persistenceService.getDepartmentById(Long.valueOf(depId));
	}
}
