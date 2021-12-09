package com.student.request;

import com.student.entity.Person;

public class PersonProduct {
	private Person person;

	public PersonProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonProduct(Person person) {
		super();
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
