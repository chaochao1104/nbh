package com.nbh.domain.entity.demo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nbh.domain.entity.BaseEntityHavingId;


@Entity
@Table(name = "PERSON")
public class Person implements BaseEntityHavingId {
	
	private Long id;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	private String description;

	private Date birthDate;

	private Double weight;
	
	private Boolean isMale;

	@Column(name = "description", length=65535)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "birth_date")
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "weight")
	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	@Column(name = "is_male")
	public Boolean getIsMale() {
		return isMale;
	}

	public void setIsMale(Boolean isMale) {
		this.isMale = isMale;
	}

}
