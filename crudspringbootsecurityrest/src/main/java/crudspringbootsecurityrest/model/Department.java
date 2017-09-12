package crudspringbootsecurityrest.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="DEPARTMENT")
@Table(name = "DEPARTMENT")
public class Department {
	
	@Id
	@Column(name="DEP_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="DEP_NAME")
	private String name;
	@Column(name="EMP_ID")
	@OneToMany(mappedBy="department", cascade = CascadeType.ALL, targetEntity=crudspringbootsecurityrest.model.Employee.class, fetch=FetchType.LAZY)
	private Set<Employee> employees;
	
	public Department() {
		// Default constructor
	}
	
	public Department(final Long id) {
		super();
		this.id = id;
	}
	
	public Department(final String name) {
		super();
		this.name = name;
	}
	
	public Department(final String name, final Set<Employee> employees) {
		super();
		this.name = name;
		this.employees = employees;
	}
	
	public Department(final Long id, final String name, final Set<Employee> employees) {
		this(name, employees);		
		this.id = id;
	}

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final Set<Employee> getEmployees() {
		return employees;
	}

	public final void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new StringBuilder("Department [id=").append(id)
		.append(", name=").append(name)
		.append("]")
		.toString();
	}
}