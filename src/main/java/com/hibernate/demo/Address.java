package com.hibernate.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address {

	@Id
	@Column(name = "address_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "street", nullable = false)
	private String name;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	@Column(name = "pin_code", nullable = false)
	private int pinCode;
	
	@OneToOne(mappedBy = "address")
	private Person person;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(long id, String name, String city, int pinCode, Person person) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.pinCode = pinCode;
		this.person = person;
	}

	public Address(String name, String city, int pinCode, Person person) {
		super();
		this.name = name;
		this.city = city;
		this.pinCode = pinCode;
		this.person = person;
	}

	public Address(String name, String city, int pinCode) {
		super();
		this.name = name;
		this.city = city;
		this.pinCode = pinCode;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", city=" + city + ", pinCode=" + pinCode +  "]";
	}
	
	
	
}
