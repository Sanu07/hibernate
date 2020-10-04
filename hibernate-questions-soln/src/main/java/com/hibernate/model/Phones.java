package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PHONES")
public class Phones {
	@Id
	@Column(name = "PHONE_ID")
	private long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "COLOUR")
	private String colour;
	
	@ManyToOne
	@JoinColumn(name = "BRAND_ID")
	private PhoneBrand phoneBrand;
	
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
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public PhoneBrand getPhoneBrand() {
		return phoneBrand;
	}
	public void setPhoneBrand(PhoneBrand phoneBrand) {
		this.phoneBrand = phoneBrand;
	}
	
}
