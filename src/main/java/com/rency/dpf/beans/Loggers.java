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
@Table(name="t_loggers")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Loggers implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3791619591679343746L;
	
	private int id;
	private User user;
	private String clientIP;
	private String action;
	private String param;
	private String useTime;
	private String browser;
	private int logType;
	private String logTypeDesc;
	private Date createTime;
	
	public Loggers(){
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

	@ManyToOne
	@JoinColumn(name="user")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getClientIP() {
		return clientIP;
	}

	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getUseTime() {
		return useTime;
	}

	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public int getLogType() {
		return logType;
	}

	public void setLogType(int logType) {
		this.logType = logType;
	}
	
	public String getLogTypeDesc() {
		return logTypeDesc;
	}

	public void setLogTypeDesc(String logTypeDesc) {
		this.logTypeDesc = logTypeDesc;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss:SSS")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Override
	public String toString(){
		return "{id:"+id+", user:"+user+", clientIP:"+clientIP+", action:"+action+", param:"+param+", useTime:"+useTime+", browser:"+browser+", logType:"+logType+", logTypeDesc:"+logTypeDesc+", createTime:"+createTime+"}";
	}
	
}