package com.stevens.spring_mvc_validation_jsr303.model;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.stevens.spring_mvc_validation_jsr303.validator.Phone;

public class Customer {

	@NotEmpty
	@Size(min = 2, max = 50)
	private String name;

	@NotNull
	@Min(18)
	@Max(100)
	private int age;

	@NotNull
	private Gender gender;

	@NotNull
	@Past
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date birthday;

	@Email
	@NotEmpty
	private String email;

	@Phone
	private String phone;

	public enum Gender {
		MALE, FEMALE
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
