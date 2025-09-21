package org.mql.spring.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Formateurs")
public class Formateur {
	@Id
	private int id;
	private String name;
	private int tel;
	private String email;
	
	
	public Formateur() {
		// TODO Auto-generated constructor stub
	}
	

	public Formateur(int id, String name, int tel, String email) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Formateur [id=" + id + ", name=" + name + ", tel=" + tel + ", email=" + email + "]";
	}
	
	
	

}
