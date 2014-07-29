package com.nbh.domain.entity.profile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nbh.domain.entity.BaseEntityHavingId;

@Entity
@Table(name = "PROF_USER")
public class User implements BaseEntityHavingId {

	private Long id;
	
	//uuid from weixin
	private String openId;
	
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

	@Column(name = "open_id")
	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
}
