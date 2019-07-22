package com.bwjf.createpdf.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * CA证书表
 * 主要针对不同的服务器区分开来
 * @author zht
 * @email 437401261@qq.com
 * @date 2019-05-21 16:33:21
 */
public class KpCacersubInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/****/
	private String id;
	/**文件路径**/
	private String kcsiFileAddr;
	/**客户表id**/
	private String koibId;
	/**证书导入日期**/
	private Date kcsiCreatetime;
	/**证书生效日期**/
	private Date kcsiBegintime;
	/**证书到期日期**/
	private Date kcsiEndtime;
	/**证书类型(1 CA证书 0签章 2合同)**/
	private String kcsiType;
	/**证书里边的纳税人识别号**/
	private String kcsiNsrsbh;
	/**是否删除(0:使用 1:删除)**/
	private String kcsiDel;
	/**文件流**/
	private String kcsiStream;
	/**设备编号**/
	private String deviceCode;

	/**客户名称**/
	private String vName;
	
	/**客户税号**/
	private String vnuitedCode;
	
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
	public String getKcsiFileAddr() {
		return kcsiFileAddr;
	}
	public void setKcsiFileAddr(String kcsiFileAddr) {
		this.kcsiFileAddr = kcsiFileAddr;
	}
	public String getKoibId() {
		return koibId;
	}
	public void setKoibId(String koibId) {
		this.koibId = koibId;
	}
	public Date getKcsiCreatetime() {
		return kcsiCreatetime;
	}
	public void setKcsiCreatetime(Date kcsiCreatetime) {
		this.kcsiCreatetime = kcsiCreatetime;
	}
	public Date getKcsiBegintime() {
		return kcsiBegintime;
	}
	public void setKcsiBegintime(Date kcsiBegintime) {
		this.kcsiBegintime = kcsiBegintime;
	}
	public Date getKcsiEndtime() {
		return kcsiEndtime;
	}
	public void setKcsiEndtime(Date kcsiEndtime) {
		this.kcsiEndtime = kcsiEndtime;
	}
	public String getKcsiType() {
		return kcsiType;
	}
	public void setKcsiType(String kcsiType) {
		this.kcsiType = kcsiType;
	}
	public String getKcsiNsrsbh() {
		return kcsiNsrsbh;
	}
	public void setKcsiNsrsbh(String kcsiNsrsbh) {
		this.kcsiNsrsbh = kcsiNsrsbh;
	}
	public String getKcsiDel() {
		return kcsiDel;
	}
	public void setKcsiDel(String kcsiDel) {
		this.kcsiDel = kcsiDel;
	}
	
	public String getKcsiStream() {
		return kcsiStream;
	}
	public void setKcsiStream(String kcsiStream) {
		this.kcsiStream = kcsiStream;
	}
	
	public String getDeviceCode() {
		return deviceCode;
	}
	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
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
	
	
}
