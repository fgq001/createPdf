package com.bwjf.createpdf.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * <p>
 * Title: 商品相关信息表
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 *
 * @date 2018年12月7日 上午10:06:05
 * @版本 V 1.0
 */
public class BwjfKpOutsideInteFyxmBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	// 发票主表ID
	private String koibId;
	// 发票行性质 0正常行、1折扣行、2被折扣行
	private String koifFphxz;
	// 商品名称
	private String koifSpmc;
	// 商品税目
	private String koifSpsm;
	// 规格型号(折扣行请不要传)
	private String koifGgxh;
	// 计量单位(折扣行请不要传)
	private String koifDw;
	// 商品数量
	private String koifSpsl;
	// 商品条数
	private String kpxmsl;
	// 商品单价
	private String koifDj;
	// 商品金额
	private String koifJe;
	// 商品税率
	private String koifSl;
	// 商品税额
	private String koifSe;
	// 含税标志
	private String koifHsbz;
	// 商品编码
	private String koifSpbm;
	// 自行编码(一般不建议使用自行编码)
	private String koifZxbm;
	// 优惠政策标识 0：不使用，1：使用
	private String koifYhzcbs;
	// 零税率标识 空：非零税率， 1：免税，2：不征收，3普通零税率
	private String koifLslbs;
	// 增值税特殊管理-如果yhzcbs为1时，此项必填，具体信息取《商品和服务税收分类与编码》中的增值税特殊管理列。(值为中文)
	private String koifZzstsgl;
	private String koifDel;
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date koifCreatetime;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKoibId() {
		return koibId;
	}
	public void setKoibId(String koibId) {
		this.koibId = koibId;
	}
	public String getKoifFphxz() {
		return koifFphxz;
	}
	public void setKoifFphxz(String koifFphxz) {
		this.koifFphxz = koifFphxz;
	}
	public String getKoifSpmc() {
		return koifSpmc;
	}
	public void setKoifSpmc(String koifSpmc) {
		this.koifSpmc = koifSpmc;
	}
	public String getKoifSpsm() {
		return koifSpsm;
	}
	public void setKoifSpsm(String koifSpsm) {
		this.koifSpsm = koifSpsm;
	}
	public String getKoifGgxh() {
		return koifGgxh;
	}
	public void setKoifGgxh(String koifGgxh) {
		this.koifGgxh = koifGgxh;
	}
	public String getKoifDw() {
		return koifDw;
	}
	public void setKoifDw(String koifDw) {
		this.koifDw = koifDw;
	}
	public String getKoifSpsl() {
		return koifSpsl;
	}
	public void setKoifSpsl(String koifSpsl) {
		this.koifSpsl = koifSpsl;
	}
	public String getKoifDj() {
		return koifDj;
	}
	public void setKoifDj(String koifDj) {
		this.koifDj = koifDj;
	}
	public String getKoifJe() {
		return koifJe;
	}
	public void setKoifJe(String koifJe) {
		this.koifJe = koifJe;
	}
	public String getKoifSl() {
		return koifSl;
	}
	public void setKoifSl(String koifSl) {
		this.koifSl = koifSl;
	}
	public String getKoifSe() {
		return koifSe;
	}
	public void setKoifSe(String koifSe) {
		this.koifSe = koifSe;
	}
	public String getKoifHsbz() {
		return koifHsbz;
	}
	public void setKoifHsbz(String koifHsbz) {
		this.koifHsbz = koifHsbz;
	}
	public String getKoifSpbm() {
		return koifSpbm;
	}
	public void setKoifSpbm(String koifSpbm) {
		this.koifSpbm = koifSpbm;
	}
	public String getKoifZxbm() {
		return koifZxbm;
	}
	public void setKoifZxbm(String koifZxbm) {
		this.koifZxbm = koifZxbm;
	}
	public String getKoifYhzcbs() {
		return koifYhzcbs;
	}
	public void setKoifYhzcbs(String koifYhzcbs) {
		this.koifYhzcbs = koifYhzcbs;
	}
	public String getKoifLslbs() {
		return koifLslbs;
	}
	public void setKoifLslbs(String koifLslbs) {
		this.koifLslbs = koifLslbs;
	}
	public String getKoifZzstsgl() {
		return koifZzstsgl;
	}
	public void setKoifZzstsgl(String koifZzstsgl) {
		this.koifZzstsgl = koifZzstsgl;
	}
	public String getKoifDel() {
		return koifDel;
	}
	public void setKoifDel(String koifDel) {
		this.koifDel = koifDel;
	}
	public Date getKoifCreatetime() {
		return koifCreatetime;
	}
	public void setKoifCreatetime(Date koifCreatetime) {
		this.koifCreatetime = koifCreatetime;
	}

	public String getKpxmsl() {
		return kpxmsl;
	}

	public void setKpxmsl(String kpxmsl) {
		this.kpxmsl = kpxmsl;
	}

	@Override
	public String toString() {
		return "BwjfKpOutsideInteFyxm [id=" + id + ", koibId=" + koibId
				+ ", koifFphxz=" + koifFphxz + ", koifSpmc=" + koifSpmc
				+ ", koifSpsm=" + koifSpsm + ", koifGgxh=" + koifGgxh
				+ ", koifDw=" + koifDw + ", koifSpsl=" + koifSpsl + ", koifDj="
				+ koifDj + ", koifJe=" + koifJe + ", koifSl=" + koifSl
				+ ", koifSe=" + koifSe + ", koifHsbz=" + koifHsbz
				+ ", koifSpbm=" + koifSpbm + ", koifZxbm=" + koifZxbm
				+ ", koifYhzcbs=" + koifYhzcbs + ", koifLslbs=" + koifLslbs
				+ ", koifZzstsgl=" + koifZzstsgl + ", koifDel=" + koifDel
				+ ", koifCreatetime=" + koifCreatetime + "]";
	}




}
