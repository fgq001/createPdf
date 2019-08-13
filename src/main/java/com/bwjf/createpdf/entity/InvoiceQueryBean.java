package com.bwjf.createpdf.entity;

import java.io.Serializable;

public class InvoiceQueryBean extends BwjfKpBaseBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	/**
	 * 发票取票码 
	 */
	private String koibQpm;
	/**
	 * 发票号码
	 */
	private String koibFphm;
	/**
	 * 发票代码
	 */
	private String koibFpdm;
	/**
	 * 购方税号
	 */
	private String gfSh;
	/**
	 * 购方公司名称
	 */
	private String gfMc;
	/**
	 * 购方地址电话
	 */
	private String gfdz;
	/**
	 * 销方税号
	 */
	private String xfSh;
	/**
	 * 销方公司名称
	 */
	private String xfMc;
	
	/**
	 * 销方地址电话
	 */
	private String xfdz;
	/**
	 * 单据号
	 */
	private String koibOrderno;
	/**
	 * 开票日期
	 */
	private String koibKprq;
	/**
	 * 合计金额
	 */
	private String koibHjje;
	/**
	 * 合计税额
	 */
	private String koibHjse;
	/**
	 * 价税合计
	 */
	private String koibJshj;
	
	private int page;
	
	private int limit;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKoibQpm() {
		return koibQpm;
	}

	public void setKoibQpm(String koibQpm) {
		this.koibQpm = koibQpm;
	}

	public String getKoibFphm() {
		return koibFphm;
	}

	public void setKoibFphm(String koibFphm) {
		this.koibFphm = koibFphm;
	}

	public String getKoibFpdm() {
		return koibFpdm;
	}

	public void setKoibFpdm(String koibFpdm) {
		this.koibFpdm = koibFpdm;
	}

	public String getGfSh() {
		return gfSh;
	}

	public void setGfSh(String gfSh) {
		this.gfSh = gfSh;
	}

	public String getGfMc() {
		return gfMc;
	}

	public void setGfMc(String gfMc) {
		this.gfMc = gfMc;
	}

	public String getXfSh() {
		return xfSh;
	}

	public void setXfSh(String xfSh) {
		this.xfSh = xfSh;
	}

	public String getXfMc() {
		return xfMc;
	}

	public void setXfMc(String xfMc) {
		this.xfMc = xfMc;
	}

	public String getKoibOrderno() {
		return koibOrderno;
	}

	public void setKoibOrderno(String koibOrderno) {
		this.koibOrderno = koibOrderno;
	}

	public String getKoibHjje() {
		return koibHjje;
	}

	public void setKoibHjje(String koibHjje) {
		this.koibHjje = koibHjje;
	}

	public String getKoibKprq() {
		return koibKprq;
	}

	public void setKoibKprq(String koibKprq) {
		this.koibKprq = koibKprq;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getGfdz() {
		return gfdz;
	}

	public void setGfdz(String gfdz) {
		this.gfdz = gfdz;
	}

	public String getXfdz() {
		return xfdz;
	}

	public void setXfdz(String xfdz) {
		this.xfdz = xfdz;
	}

	public String getKoibHjse() {
		return koibHjse;
	}

	public void setKoibHjse(String koibHjse) {
		this.koibHjse = koibHjse;
	}

	public String getKoibJshj() {
		return koibJshj;
	}

	public void setKoibJshj(String koibJshj) {
		this.koibJshj = koibJshj;
	}
	
	
}