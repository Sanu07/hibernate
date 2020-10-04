package com.hibernate.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PHONES_BRAND")
public class PhoneBrand {
	@Id
	@Column(name = "BRAND_ID")
	private long id;
	
	@Column(name = "BRAND_NAME")
	private String name;
	
	@OneToMany(mappedBy = "phoneBrand", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	/*
	@JoinTable(
	name = "PHONES_BRAND_RELATION",
	joinColumns = @JoinColumn(name = "PHONE_ID"), 
	inverseJoinColumns = @JoinColumn(name = "BRAND_ID"))
	*/
	private List<Phones> phones;

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

	public List<Phones> getPhones() {
		return phones;
	}

	public void setPhones(List<Phones> phones) {
		this.phones = phones;
	}

	@Override
	public String toString() {
		return "PhoneBrand [id=" + id + ", name=" + name + ", phones=" + phones + "]";
	}

}
