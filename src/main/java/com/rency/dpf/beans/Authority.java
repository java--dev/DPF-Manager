package com.rency.dpf.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="t_authority")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Authority implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7476817547443556184L;

	private int id;
	
	private String resources;
	
	private String description;
	
	private UserType userType;
	
	private Date createTime;

	public Authority(){
		
		this.createTime = new Date();
		
	}
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResources() {
		return resources;
	}

	public void setResources(String resources) {
		this.resources = resources;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	@JoinColumn(name="userType")
	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Override
	public String toString(){
		
		return "{id:"+id+", resources:"+resources+", description:"+description+", userType:"+userType+", createTime:"+createTime+"}";
		
	}
	
}