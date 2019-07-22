package com.bwjf.createpdf.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 发票pdf模板表
 * 
 * @author cuixuejun
 * @email 799106876@qq.com
 * @date 2019-04-19 16:12:59
 */
public class TcrmPdftemplateBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**id**/
	private String id;
	/**编码**/
	private String vcode;
	/**地区**/
	private String vregionname;
	/**路径**/
	private String vpath;
	/****/
	private String vpdffile;
	/**状态**/
	private String istatus;
	/**备注**/
	private String vmemo;
	/**创建日期**/
	private Date createTime;
	/**创建人**/
	private String createUser;
	/**修改日期**/
	private Date updateTime;
	/**修改人**/
	private String updateUser;

	/**客户名称**/
	private String vName;
	
	/**客户税号**/
	private String vnuitedCode;
	
	/**pdf文件流**/
	private String pdfstream;
	
	
	/**
	 * 设置：id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：编码
	 */
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	/**
	 * 获取：编码
	 */
	public String getVcode() {
		return vcode;
	}
	/**
	 * 设置：地区
	 */
	public void setVregionname(String vregionname) {
		this.vregionname = vregionname;
	}
	/**
	 * 获取：地区
	 */
	public String getVregionname() {
		return vregionname;
	}
	/**
	 * 设置：路径
	 */
	public void setVpath(String vpath) {
		this.vpath = vpath;
	}
	/**
	 * 获取：路径
	 */
	public String getVpath() {
		return vpath;
	}
	/**
	 * 设置：
	 */
	public void setVpdffile(String vpdffile) {
		this.vpdffile = vpdffile;
	}
	/**
	 * 获取：
	 */
	public String getVpdffile() {
		return vpdffile;
	}
	/**
	 * 设置：状态
	 */
	public void setIstatus(String istatus) {
		this.istatus = istatus;
	}
	/**
	 * 获取：状态
	 */
	public String getIstatus() {
		return istatus;
	}
	/**
	 * 设置：备注
	 */
	public void setVmemo(String vmemo) {
		this.vmemo = vmemo;
	}
	/**
	 * 获取：备注
	 */
	public String getVmemo() {
		return vmemo;
	}
	/**
	 * 设置：创建日期
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建日期
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：修改日期
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改日期
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：修改人
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：修改人
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public String getVnuitedCode() {
		return vnuitedCode;
	}
	public void setVnuitedCode(String vnuitedCode) {
		this.vnuitedCode = vnuitedCode;
	}
	public String getPdfstream() {
		return pdfstream;
	}
	public void setPdfstream(String pdfstream) {
		this.pdfstream = pdfstream;
	}
	
	
	
}
