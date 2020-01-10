package com.bwjf.createpdf.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 电票文件信息相关表
 * 
 * @author cuixuejun
 * @email 799106876@qq.com
 * @date 2019-06-27 09:06:07
 */
public class KpFileInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/****/
	private String id;
	/**文件路径**/
	private String KOIF_FILE_ADDR;
	/**文件有效期**/
	private String koifYxq;
	/**文件类型(1:pdf 2:二维码)**/
	private String KOIF_TYPE;
	/**上传日期**/
	private Date koifCreatetime;
	/**是否删除(0:使用 1:删除)**/
	private String koifDel;
	/**发票表主键ID**/
	private String KOIB_ID;
	/**备注(二维码长度)**/
	private String koifVemo;
	/**文件二进制流**/
	private byte[]  koifFileStream;
	/**创建日期**/
	private Date createTime;
	/**更新日期**/
	private Date updateTime;
	/**创建者**/
	private String createUser;
	/**更新者**/
	private String updateUser;
	/**更新者**/
	private String state;

	private String limitNum;


	public String getLimitNum() {
		return limitNum;
	}

	public void setLimitNum(String limitNum) {
		this.limitNum = limitNum;
	}

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

	public String getKOIF_FILE_ADDR() {
		return KOIF_FILE_ADDR;
	}

	public void setKOIF_FILE_ADDR(String KOIF_FILE_ADDR) {
		this.KOIF_FILE_ADDR = KOIF_FILE_ADDR;
	}

	/**
	 * 设置：文件有效期
	 */
	public void setKoifYxq(String koifYxq) {
		this.koifYxq = koifYxq;
	}
	/**
	 * 获取：文件有效期
	 */
	public String getKoifYxq() {
		return koifYxq;
	}

	public String getKOIF_TYPE() {
		return KOIF_TYPE;
	}

	public void setKOIF_TYPE(String KOIF_TYPE) {
		this.KOIF_TYPE = KOIF_TYPE;
	}

	public String getKOIB_ID() {
		return KOIB_ID;
	}

	public void setKOIB_ID(String KOIB_ID) {
		this.KOIB_ID = KOIB_ID;
	}

	/**
	 * 设置：上传日期
	 */
	public void setKoifCreatetime(Date koifCreatetime) {
		this.koifCreatetime = koifCreatetime;
	}
	/**
	 * 获取：上传日期
	 */
	public Date getKoifCreatetime() {
		return koifCreatetime;
	}
	/**
	 * 设置：是否删除(0:使用 1:删除)
	 */
	public void setKoifDel(String koifDel) {
		this.koifDel = koifDel;
	}
	/**
	 * 获取：是否删除(0:使用 1:删除)
	 */
	public String getKoifDel() {
		return koifDel;
	}

	/**
	 * 设置：备注(二维码长度)
	 */
	public void setKoifVemo(String koifVemo) {
		this.koifVemo = koifVemo;
	}
	/**
	 * 获取：备注(二维码长度)
	 */
	public String getKoifVemo() {
		return koifVemo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public byte[] getKoifFileStream() {
		return koifFileStream;
	}

	public void setKoifFileStream(byte[] koifFileStream) {
		this.koifFileStream = koifFileStream;
	}
}
