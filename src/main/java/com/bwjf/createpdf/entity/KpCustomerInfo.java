package com.bwjf.createpdf.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author cuixuejun
 * @email 799106876@qq.com
 * @date 2019-11-06 15:14:19
 */
public class KpCustomerInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/****/
	private String id;
	/**纳税识别人编号**/
	private String kciNrsbrbh;
	/**纳税识别人名称**/
	private String kciName;
	/**银行账号**/
	private String kciYhzh;
	/**地址电话**/
	private String kciDzdh;
	/**是否使用(0:使用 1:禁用)**/
	private String kciDel;
	/**创建日期**/
	private Date kciCreatetime;
	/**客户类型（0：销售方  1：购方）**/
	private String kciType;
	/**发票主表ID**/
	private String koibId;

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：纳税识别人编号
	 */
	public void setKciNrsbrbh(String kciNrsbrbh) {
		this.kciNrsbrbh = kciNrsbrbh;
	}
	/**
	 * 获取：纳税识别人编号
	 */
	public String getKciNrsbrbh() {
		return kciNrsbrbh;
	}
	/**
	 * 设置：纳税识别人名称
	 */
	public void setKciName(String kciName) {
		this.kciName = kciName;
	}
	/**
	 * 获取：纳税识别人名称
	 */
	public String getKciName() {
		return kciName;
	}
	/**
	 * 设置：银行账号
	 */
	public void setKciYhzh(String kciYhzh) {
		this.kciYhzh = kciYhzh;
	}
	/**
	 * 获取：银行账号
	 */
	public String getKciYhzh() {
		return kciYhzh;
	}
	/**
	 * 设置：地址电话
	 */
	public void setKciDzdh(String kciDzdh) {
		this.kciDzdh = kciDzdh;
	}
	/**
	 * 获取：地址电话
	 */
	public String getKciDzdh() {
		return kciDzdh;
	}
	/**
	 * 设置：是否使用(0:使用 1:禁用)
	 */
	public void setKciDel(String kciDel) {
		this.kciDel = kciDel;
	}
	/**
	 * 获取：是否使用(0:使用 1:禁用)
	 */
	public String getKciDel() {
		return kciDel;
	}
	/**
	 * 设置：创建日期
	 */
	public void setKciCreatetime(Date kciCreatetime) {
		this.kciCreatetime = kciCreatetime;
	}
	/**
	 * 获取：创建日期
	 */
	public Date getKciCreatetime() {
		return kciCreatetime;
	}
	/**
	 * 设置：客户类型（0：销售方  1：购方）
	 */
	public void setKciType(String kciType) {
		this.kciType = kciType;
	}
	/**
	 * 获取：客户类型（0：销售方  1：购方）
	 */
	public String getKciType() {
		return kciType;
	}
	/**
	 * 设置：发票主表ID
	 */
	public void setKoibId(String koibId) {
		this.koibId = koibId;
	}
	/**
	 * 获取：发票主表ID
	 */
	public String getKoibId() {
		return koibId;
	}
}
