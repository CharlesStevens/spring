package com.swastik.spring_jpa2.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long emp_id;

	@Column(name = "emp_name")
	String emp_name;

	@Column(name = "department")
	String department;

	@Column(name = "salary")
	Long salary;

	@Column(name = "location")
	String location;

	// @OneToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name = "address_id")
	// Address address101; FOREIGN KEY ASSOCIATION

	// @OneToOne(cascade = CascadeType.ALL)
	// @JoinTable(name = "employee_address", joinColumns = {
	// @JoinColumn(name = "employee_id", referencedColumnName = "emp_id") },
	// inverseJoinColumns = {
	// @JoinColumn(name = "address_id", referencedColumnName = "id") })
	// Address address101; TABLE FOR STORING THE MAPPING.

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	Address address101; // SAME PRIMARY KEY

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_emp_id")
	List<Certification> certifications;

	// @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "employee_techstack", joinColumns = @JoinColumn(name = "employee_emp_id", referencedColumnName = "emp_id"), inverseJoinColumns = @JoinColumn(name = "techstack_stack_id", referencedColumnName = "stack_id"))
	Set<TechStack> techStacks = new HashSet<>();

	public Employee() {

	}

	public Employee(String emp_name, String department, long salary, String location, Address address,
			List<Certification> certifications) {
		this.emp_name = emp_name;
		this.department = department;
		this.salary = salary;
		this.location = location;
		this.address101 = address;
		this.certifications = certifications;
	}

	public Set<TechStack> getTechStacks() {
		return techStacks;
	}

	// public void addTechStacks(TechStack techStack) {
	// techStack.addEmployees(this);
	// techStacks.add(techStack);
	// }

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Address getAddress101() {
		return address101;
	}

	public void setAddress101(Address address) {
		this.address101 = address;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}

	public List<Certification> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<Certification> certifications) {
		this.certifications = certifications;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", department=" + department + ", salary="
				+ salary + ", location=" + location + ", address101=" + address101 + ", certifications="
				+ certifications + ", techStacks=" + techStacks + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((emp_name == null) ? 0 : emp_name.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
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
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (emp_name == null) {
			if (other.emp_name != null)
				return false;
		} else if (!emp_name.equals(other.emp_name))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		return true;
	}

}
