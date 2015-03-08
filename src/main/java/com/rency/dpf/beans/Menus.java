package com.rency.dpf.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.rency.utils.tools.Utils;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="t_menus")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Menus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7476817547443556184L;

	private String resId;
	
	private String resName;
	
	private String parentResId;
	
	private String parentResName;
	
	private UserType userType;
	
	private String href;
	
	private int priority;
	
	private boolean isLeaf;
	
	private String description;
	
	private Date createTime;
	
	public Menus(){
		this.resId = Utils.generateId(23);
		this.createTime = new Date();
		
	}

	@Id
	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getParentResId() {
		return parentResId;
	}

	public void setParentResId(String parentResId) {
		this.parentResId = parentResId;
	}

	public String getParentResName() {
		return parentResName;
	}

	public void setParentResName(String parentResName) {
		this.parentResName = parentResName;
	}

	@ManyToOne
	@JoinColumn(name="userType")
	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		
		return "{resId:"+resId+", resName:"+resName+", parentResId:"+parentResId+", parentResName:"+parentResName+", userType:"+userType+", href:"+href+", priority:"+priority+", isLeaf:"+isLeaf+", description:"+description+", createTime:"+createTime+"}";
		
	}
	
}