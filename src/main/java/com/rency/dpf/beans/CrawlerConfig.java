package com.rency.dpf.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="t_crawler_config")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class CrawlerConfig implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3791619591679343746L;
	
	private String crawlerId;
	private String crawlerName;
	private String crawlerDesc;
	private String remoteAddr;
	private String remotePort;
	private int poolSize;
	private boolean status;
	private String initAddr;
	private Date createTime;
	
	public CrawlerConfig(){
		this.createTime = new Date();
	}
	
	@Id
	public String getCrawlerId() {
		return crawlerId;
	}

	public void setCrawlerId(String crawlerId) {
		this.crawlerId = crawlerId;
	}

	public String getCrawlerName() {
		return crawlerName;
	}

	public void setCrawlerName(String crawlerName) {
		this.crawlerName = crawlerName;
	}

	public String getCrawlerDesc() {
		return crawlerDesc;
	}

	public void setCrawlerDesc(String crawlerDesc) {
		this.crawlerDesc = crawlerDesc;
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public String getRemotePort() {
		return remotePort;
	}

	public void setRemotePort(String remotePort) {
		this.remotePort = remotePort;
	}

	public int getPoolSize() {
		return poolSize;
	}

	public void setPoolSize(int poolSize) {
		this.poolSize = poolSize;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getInitAddr() {
		return initAddr;
	}

	public void setInitAddr(String initAddr) {
		this.initAddr = initAddr;
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
		return "{crawlerId:"+crawlerId+", crawlerName:"+crawlerName+", crawlerDesc:"+crawlerDesc+", remoteAddr:"+remoteAddr+", remotePort:"+remotePort+", poolSize:"+poolSize+", status:"+status+", initAddr:"+initAddr+", createTime:"+createTime+"}";
	}
	
}