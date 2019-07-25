package com.bwjf.createpdf.rabbitmq.message;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author cuixuejun
 * @email 799106876@qq.com
 * @date 2019-05-17 09:40:01
 */
public class SysExceptionlogMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**主键**/
	private String id;
	/**异常信息**/
	private String exceptionInfo;
	/**创建时间**/
	private Date creteTime;
	/**异常请求的url**/
	private String requestUrl;
	/**异常请求的参数**/
	private String requestParam;
	/**异常来源(1:全局异常 2:方法异常)**/
	private String exceptionDatasource;
	/**发生异常的类**/
	private String exceptionClass;
	/**发生异常的方法**/
	private String exceptionMethod;
	/** 异常的服务器 **/
	private String exceprionServer;
	
	
	/**
	 * 设置：主键
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：异常信息
	 */
	public void setExceptionInfo(String exceptionInfo) {
		this.exceptionInfo = exceptionInfo;
	}
	/**
	 * 获取：异常信息
	 */
	public String getExceptionInfo() {
		return exceptionInfo;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreteTime(Date creteTime) {
		this.creteTime = creteTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreteTime() {
		return creteTime;
	}
	public String getRequestUrl() {
		return requestUrl;
	}
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	public String getRequestParam() {
		return requestParam;
	}
	public void setRequestParam(String requestParam) {
		this.requestParam = requestParam;
	}
	public String getExceptionDatasource() {
		return exceptionDatasource;
	}
	public void setExceptionDatasource(String exceptionDatasource) {
		this.exceptionDatasource = exceptionDatasource;
	}
	public String getExceptionClass() {
		return exceptionClass;
	}
	public void setExceptionClass(String exceptionClass) {
		this.exceptionClass = exceptionClass;
	}
	public String getExceptionMethod() {
		return exceptionMethod;
	}
	public void setExceptionMethod(String exceptionMethod) {
		this.exceptionMethod = exceptionMethod;
	}

	public String getExceprionServer() {
		return exceprionServer;
	}

	public void setExceprionServer(String exceprionServer) {
		this.exceprionServer = exceprionServer;
	}
}
