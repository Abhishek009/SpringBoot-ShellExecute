package com.api.model;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/*
– @Entity annotation indicates that the class is a persistent Java class.
– @Table annotation provides the table that maps this entity.
– @Id annotation is for the primary key.
– @GeneratedValue annotation is used to define generation strategy for the primary key. GenerationType.AUTO means Auto Increment field.
– @Column annotation is used to define the column in database that maps annotated field.
*/

@Entity
@Table(name = "users")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
    private String lastName;
	@Column(name = "email")
    private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
	@Override
	public String toString() {
		return " Details [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
    
}
