package com.rency.dpf.beans;

import java.io.Serializable;
import java.util.List;

public class URLFilter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3791619591679343746L;
	
	@SuppressWarnings("rawtypes")
	private List filter;

	@SuppressWarnings("rawtypes")
	public List getFilter() {
		return filter;
	}

	@SuppressWarnings("rawtypes")
	public void setFilter(List filter) {
		this.filter = filter;
	}

}