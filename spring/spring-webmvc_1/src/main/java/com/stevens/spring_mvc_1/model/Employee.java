package com.stevens.spring_mvc_1.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
public class Employee {

	int emp_id;
	String emp_name;
	long emp_salary;

	public Employee() {
	}

	public Employee(int emp_id, String emp_name, long emp_salary) {
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_salary = emp_salary;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public long getEmp_salary() {
		return emp_salary;
	}

	public void setEmp_salary(long emp_salary) {
		this.emp_salary = emp_salary;
	}

}
