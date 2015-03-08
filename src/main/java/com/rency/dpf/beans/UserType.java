package com.rency.dpf.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="t_user_type")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class UserType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3791619591679343746L;
	
	private int typeId;
	private String typeName;
	private Date createTime;
	
	public UserType(){
		this.createTime = new Date();
	}
	
	@Id
	@GeneratedValue
	public int getTypeId() {
		return typeId;
	}
	
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
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
		return "{typeId:"+typeId+", typeName:"+typeName+", createTime:"+createTime+"}";
	}
	
}