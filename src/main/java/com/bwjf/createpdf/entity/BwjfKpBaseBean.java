package com.bwjf.createpdf.entity;


public class BwjfKpBaseBean {

	/**
	 * 分页(起始页)
	 */
	private String startPage;

	/**
	 * 分页(结束页)
	 */
	private String endPage;

	
	private String tableName;// 表名

	
	//临时存储 日期
	private String tbcreateTime;
	
	
	
	public String getTbcreateTime() {
		return tbcreateTime;
	}

	public void setTbcreateTime(String tbcreateTime) {
		this.tbcreateTime = tbcreateTime;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getStartPage() {
		return startPage;
	}

	public void setStartPage(String startPage) {
		this.startPage = startPage;
	}

	public String getEndPage() {
		return endPage;
	}

	public void setEndPage(String endPage) {
		this.endPage = endPage;
	}

}
