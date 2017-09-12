package crudspringbootsecurityrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="EMPLOYEE")
@Table(name = "EMPLOYEE")
public class Employee {
	
	@Id
	@Column(name="EMP_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="EMP_NAME")
	private String name;
	@Column(name="EMP_LASTNAME")
	private String lastName;
	@Column(name="EMPL_ACTIVE")
	private boolean active;
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="DEP_ID")
	private Department department;	
	
	public Employee() {
		// Default constructor
	}
	
	public Employee(final String name, final String lastName, final boolean active) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.active = active;
	}
	
	public Employee(final String name, final String lastName, final boolean active, final Department department) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.active = active;
		this.department = department;
	}

	public Employee(final Long id, final String name, final String lastName, final boolean active, final Department department) {
		this(name, lastName, active, department);
		this.id = id;		
	}

	public final Long getId() {
		return id;
	}

	public final void setId(final Long id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(final String name) {
		this.name = name;
	}

	public final String getLastName() {
		return lastName;
	}

	public final void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public final boolean isActive() {
		return active;
	}

	public final void setActive(final boolean active) {
		this.active = active;
	}

	public final Department getDepartment() {
		return department;
	}
	
	public final void setDepartment(final Department department) {
		this.department = department;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
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
		Employee other = (Employee) obj;
		if (active != other.active)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
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
		final StringBuilder res = 
				new StringBuilder("Employee [id=").append(id)
		.append(", name=").append(name)
		.append(", lastName=").append(lastName)
		.append(", active=").append(active);
		if(department!=null) {
			res.append(", Department=").append(department.toString());
		}		
		res.append("]");
		return res.toString();
	}
}