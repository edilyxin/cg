package com.rc.util.page;

public class PageBean {
	
	public static final int PAGE_SIZE =10;
	 
	private int totalResults;  //总记录数
	
	private int pageSize; //每页显示的记录数
	
	private int currentPage = 1; // 当前页默认为1
	
	public PageBean(){
		
	}
	public PageBean(int totalResults, int pageSize) {
		super();
		this.totalResults = totalResults;
		this.pageSize = pageSize;
	}
	
	//是否有下一页
	public boolean hasNextPage(){
		return currentPage < this.getTotalPages();
	}
	
	//是否有上一页
	public boolean hasPreviousPage(){
		return currentPage > 1;
	}
	
	//得到总记录数
	public int getTotalResults(){
		return this.totalResults;
	}
	
	//得到当前页
	public int getCurrentPage(){
		return this.currentPage;
	}
	//设置当前页
	public void setCurrentPage(int currentPage){
		this.currentPage = currentPage;
	}
	
	//获得每页显示记录数
	public int getPageSize(){
		return this.pageSize;
	}
	
	//设置每页显示记录数
	public void setPageSize(int pageSize){
		this.pageSize = pageSize;
	}
	
	
	//得到开始显示记录行
	public int getStartResult(){
		return (this.currentPage - 1) * pageSize;
	}
	
	//计算总的页数
	public int getTotalPages(){
		return (int)Math.ceil(totalResults / (double)pageSize);
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}
	
	public String getPageSQLA(){
		StringBuffer sb = new StringBuffer();
		sb.append("select * from  (select a.*,rownum rn from ( ");
		return sb.toString();
	}
	
	public String getPageSQLB(){
		StringBuffer sb = new StringBuffer();
		sb.append(" )a ")
		.append(" where rownum <=").append(this.getCurrentPage()*this.getPageSize())
		.append(" ) where rn >= ").append((this.getCurrentPage()-1)*this.getPageSize()+1);	
		return sb.toString();
	}
	
	
}
