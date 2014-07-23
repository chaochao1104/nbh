package com.nbh.domain.entity;

public interface BaseEntityWithId extends BaseEntity {
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
