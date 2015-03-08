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
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="t_user")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2490131735444147727L;

	private String guid;
	private String username;
	private String password;
	private String email;
	private String mobilePhone;
	private UserType userType;
	private Date lastLogin;
	private String loginIP;
	private boolean online;
	private Date createTime;
	
	public User(){
		this.createTime = new Date();
	}
	
	@Id
	@GeneratedValue(generator="guid")
	@GenericGenerator(name="guid",strategy="guid")
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	@ManyToOne
	@JoinColumn(name="userType")
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getLoginIP() {
		return loginIP;
	}
	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}
	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
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
		return "{guid:"+guid+", username:"+username+", email:"+email+", mobilePhone:"+mobilePhone+", userType:"+userType+", lastLogin:"+lastLogin+", loginIP:"+loginIP+", online:"+online+", createTime:"+createTime+"}";
	}
}