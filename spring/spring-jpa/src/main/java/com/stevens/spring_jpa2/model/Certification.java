package com.stevens.spring_jpa2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "certification")
public class Certification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long cert_id;

	@Column(name = "cert_name")
	String cert_name;

	@Column(name = "cert_type")
	String cert_type;

	@ManyToOne
	Employee employee;

	public Certification() {

	}

	public Certification(String cert_name, String cert_type) {
		this.cert_name = cert_name;
		this.cert_type = cert_type;
	}

	public Long getCert_id() {
		return cert_id;
	}

	public void setCert_id(Long cert_id) {
		this.cert_id = cert_id;
	}

	public String getCert_name() {
		return cert_name;
	}

	public void setCert_name(String cert_name) {
		this.cert_name = cert_name;
	}

	public String getCert_type() {
		return cert_type;
	}

	public void setCert_type(String cert_type) {
		this.cert_type = cert_type;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Certification [cert_id=" + cert_id + ", cert_name=" + cert_name + ", cert_type=" + cert_type + "]";
	}

}
