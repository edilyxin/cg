/*
 * @(#)Page.java 1.0 2013-3-14
 * Copyright (C) Beijing Youbang Jiatong Electrinic Technology Co.,Ltd. All rights reserved. 
 *
 */
package com.rc.util;

import java.io.Serializable;
import java.util.List;

/**
 * 分页模型通用类
 * @author Administrator
 * @version 1.0, 2013-3-14 上午10:20:48
 */
public class Page implements Serializable{
	//总记录数
	private int totalProperty;
	
	//第几页
	private int pageProperty;
	
	private int totalPages;
	//分页结果
	private List root;
	
	//开始页码
	private int start;
	
	//每页多少
	private int limit;
	
	//成功与否
	private boolean isSuccess;
	
	//查询条件
	private Object objCondition;
	
	//排序条件
	private String ordName1;
	private String ordType1;
	/**
	 * 
	 */
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getOrdName1() {
		return ordName1;
	}

	public void setOrdName1(String ordName1) {
		this.ordName1 = ordName1;
	}

	public String getOrdType1() {
		return ordType1;
	}

	public void setOrdType1(String ordType1) {
		this.ordType1 = ordType1;
	}

	public int getTotalProperty() {
		return totalProperty;
	}

	public void setTotalProperty(int totalProperty) {
		this.totalProperty = totalProperty;
	}

	public int getPageProperty() {
		return pageProperty;
	}

	public void setPageProperty(int pageProperty) {
		this.pageProperty = pageProperty;
	}

	public int getTotalPages() {
		return (int)Math.ceil(totalProperty / (double)limit);
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List getRoot() {
		return root;
	}

	public void setRoot(List root) {
		this.root = root;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Object getObjCondition() {
		return objCondition;
	}

	public void setObjCondition(Object objCondition) {
		this.objCondition = objCondition;
	}
	
}
