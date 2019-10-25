package com.bwjf.createpdf.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <p>Title: 发票文件信息相关表</p>
 * <p>Description: KP_FILE_INFO</p>
 * <p>Company: </p>
 * @date 2018年13月5日 下午3:54:07
 * @版本 V 1.0
 */
public class BwjfKpFileBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 文件路径
	 */
	private String koifFileAddr;
	/**
	 * 文件有效期
	 */
	private String koifYxq;
	/**
	 * 文件类型(1:pdf 2:二维码)
	 */
	private String koifType;
	/**
	 * 上传日期
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date koifCreatetime;
	
	/**
	 * 主键ID
	 */
	private String koibId;
	
	//文件流
	private byte[] koifFilestream;


	//KOIF_VEMO
	/**
	 * 备注
	 */
	private String koifVemo;
	private String addr;
	public String getKoibId() {
		return koibId;
	}
	public void setKoibId(String koibId) {
		this.koibId = koibId;
	}
	/**
	 * 是否删除(0:使用 1:删除)
	 */
	private String koifDel;

	/**
	 * 取票码
	 */
	private String koibQpm;
	/**
	 * 发票请求流水号
	 */
	private String koibFpqqlsh;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKoifFileAddr() {
		return koifFileAddr;
	}
	public void setKoifFileAddr(String koifFileAddr) {
		this.koifFileAddr = koifFileAddr;
	}
	
	public String getKoifYxq() {
		return koifYxq;
	}
	public void setKoifYxq(String koifYxq) {
		this.koifYxq = koifYxq;
	}
	public String getKoifType() {
		return koifType;
	}
	public void setKoifType(String koifType) {
		this.koifType = koifType;
	}
	
	public Date getKoifCreatetime() {
		return koifCreatetime;
	}
	public void setKoifCreatetime(Date koifCreatetime) {
		this.koifCreatetime = koifCreatetime;
	}
	public String getKoifDel() {
		return koifDel;
	}
	public void setKoifDel(String koifDel) {
		this.koifDel = koifDel;
	}
	public String getKoifVemo() {
		return koifVemo;
	}
	public void setKoifVemo(String koifVemo) {
		this.koifVemo = koifVemo;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public byte[] getKoifFilestream() {
		return koifFilestream;
	}

	public void setKoifFilestream(byte[] koifFilestream) {
		this.koifFilestream = koifFilestream;
	}

	public String getKoibQpm() {
		return koibQpm;
	}

	public void setKoibQpm(String koibQpm) {
		this.koibQpm = koibQpm;
	}

	public String getKoibFpqqlsh() {
		return koibFpqqlsh;
	}

	public void setKoibFpqqlsh(String koibFpqqlsh) {
		this.koibFpqqlsh = koibFpqqlsh;
	}
}
