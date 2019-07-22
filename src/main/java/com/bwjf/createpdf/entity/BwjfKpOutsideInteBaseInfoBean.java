package com.bwjf.createpdf.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <p>
 * Title: 获取发票相关信息接口
 * </p>
 * <p>
 * Description: KP_OUTSIDE_INTE_BASEINFO
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @date 2018年13月5日 下午3:54:07
 * @版本 V 1.0
 */
public class BwjfKpOutsideInteBaseInfoBean implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	/**
	 * 发票代码
	 */
	private String koibFpdm;
	/**
	 * 发票号码
	 */
	private String koibFphm;
	/**
	 * 发票类型代码
	 */
	private String KoibFplxdm;
	/**
	 * 发票状态
	 */
	private String koibFpzt;
	/**
	 * 上传标志
	 */
	private String koibScbz;
	/**
	 * 开票日期
	 */
	private String koibKprq;
	/**
	 * 税控服务器编号
	 */
	private String koibJqbh;
	/**
	 * 税控码（4行，每行28个字符）
	 */
	private String koibSkm;

	/**
	 * 税控盘编号
	 */
	private String koibSkpBh;

	/**
	 * 是否删除(0:使用 1:删除)
	 */
	private String koibDel;
	/**
	 * 创建日期
	 */
	/* @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss") */
	private Date koibCreatetime;
	/**
	 * 数据源
	 */
	private String koibDatasource;
	/**
	 * 销售方id
	 */
	private Integer koibXsfId;
	/**
	 * 购方id
	 */
	private Integer koibGmfId;
	/**
	 * 业务单据号
	 */
	private String koibOrderno;
	/**
	 * 校验码
	 */
	private String koibJym;
	/**
	 * 版本号
	 */
	private String koibBbh;
	/**
	 * 税收编码版本号，参数“13.0”，具体值请询问提供商
	 */
	private String koibBmbbbh;
	/**
	 * 征税方式 0：普通征税 1: 减按计增 2：差额征税
	 */
	private String koibZsfs;
	/**
	 * 商品信息表id
	 */
	private Integer koibFyxmId;
	/**
	 * 综合税率
	 */
	private String koibZhsl;
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
	/**
	 * 备注
	 */
	private String koibBz;
	/**
	 * 收款人
	 */
	private String koibSkr;
	/**
	 * 复核人
	 */
	private String koibFhr;
	/**
	 * 开票人
	 */
	private String koibKpr;
	/**
	 * 取票码
	 */
	private String koibQpm;
	/**
	 * 发送方邮箱地址
	 */
	private String koibSender;
	/**
	 * 发送方邮箱地址
	 */
	private String koibEmail;
	/**
	 * 备用字段1
	 */
	private String koibField1;
	/**
	 * 备用字段2
	 */
	private String koibField2;
	/**
	 * 备用字段3
	 */
	private String koibField3;
	/**
	 * 备用字段4
	 */
	private String koibField4;

	/**
	 * 税控盘编号
	 */
	private String koibSkpbh;
	/**
	 * 发票请求流水号
	 */
	private String koibFpqqlsh;
	/**
	 * 开票类型(0-蓝字发票；1-红字发票)
	 */
	private String koibKplx;
	/**
	 * 特殊票种标识
	 */
	private String koibTspz;

	/**
	 * 开票状态(0:未开票 1:已开票)
	 */
	private String koibKpstatus;
	
	/**
	 * 扣除额
	 */
	private String koibKce;

	
	/**
	 * 纳税人识别号，可以关联销方，也可以关联购方 
	 */
	private String nsrsbh;
	
	/**
	 * 原发票号码
	 */
	private String koibYfphm;
	/**
	 * 原发票代码
	 */
	private String koibYfpdm;
	
	/**
	 * 是否创建pdf证书(0:未创建 1:已创建)
	 */
	private String koibPdfStatus;

	/**
	 *是否上传到税控服务器(0:未上传 1:已上传)
	 */
	private String koibUploadStatus;


	public String getKoibYfphm() {
		return koibYfphm;
	}

	public void setKoibYfphm(String koibYfphm) {
		this.koibYfphm = koibYfphm;
	}

	public String getKoibYfpdm() {
		return koibYfpdm;
	}

	public void setKoibYfpdm(String koibYfpdm) {
		this.koibYfpdm = koibYfpdm;
	}

	public String getNsrsbh() {
		return nsrsbh;
	}

	public void setNsrsbh(String nsrsbh) {
		this.nsrsbh = nsrsbh;
	}

	public String getKoibKce() {
		return koibKce;
	}

	public void setKoibKce(String koibKce) {
		this.koibKce = koibKce;
	}
	

	public String getKoibSkpbh() {
		return koibSkpbh;
	}

	public void setKoibSkpbh(String koibSkpbh) {
		this.koibSkpbh = koibSkpbh;
	}

	public String getKoibFpqqlsh() {
		return koibFpqqlsh;
	}

	public void setKoibFpqqlsh(String koibFpqqlsh) {
		this.koibFpqqlsh = koibFpqqlsh;
	}

	public String getKoibKplx() {
		return koibKplx;
	}

	public void setKoibKplx(String koibKplx) {
		this.koibKplx = koibKplx;
	}

	public String getKoibTspz() {
		return koibTspz;
	}

	public void setKoibTspz(String koibTspz) {
		this.koibTspz = koibTspz;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKoibFpdm() {
		return koibFpdm;
	}

	public void setKoibFpdm(String koibFpdm) {
		this.koibFpdm = koibFpdm;
	}

	public String getKoibFphm() {
		return koibFphm;
	}

	public void setKoibFphm(String koibFphm) {
		this.koibFphm = koibFphm;
	}

	public String getKoibFpzt() {
		return koibFpzt;
	}

	public void setKoibFpzt(String koibFpzt) {
		this.koibFpzt = koibFpzt;
	}

	public String getKoibScbz() {
		return koibScbz;
	}

	public void setKoibScbz(String koibScbz) {
		this.koibScbz = koibScbz;
	}

	public String getKoibKprq() {
		return koibKprq;
	}

	public void setKoibKprq(String koibKprq) {
		this.koibKprq = koibKprq;
	}

	public String getKoibJqbh() {
		return koibJqbh;
	}

	public void setKoibJqbh(String koibJqbh) {
		this.koibJqbh = koibJqbh;
	}

	public String getKoibSkm() {
		return koibSkm;
	}

	public void setKoibSkm(String koibSkm) {
		this.koibSkm = koibSkm;
	}

	public String getKoibDel() {
		return koibDel;
	}

	public void setKoibDel(String koibDel) {
		this.koibDel = koibDel;
	}

	public Date getKoibCreatetime() {
		return koibCreatetime;
	}

	public void setKoibCreatetime(Date koibCreatetime) {
		this.koibCreatetime = koibCreatetime;
	}

	public String getKoibDatasource() {
		return koibDatasource;
	}

	public void setKoibDatasource(String koibDatasource) {
		this.koibDatasource = koibDatasource;
	}

	public Integer getKoibXsfId() {
		return koibXsfId;
	}

	public void setKoibXsfId(Integer koibXsfId) {
		this.koibXsfId = koibXsfId;
	}

	public Integer getKoibGmfId() {
		return koibGmfId;
	}

	public void setKoibGmfId(Integer koibGmfId) {
		this.koibGmfId = koibGmfId;
	}

	public String getKoibOrderno() {
		return koibOrderno;
	}

	public void setKoibOrderno(String koibOrderno) {
		this.koibOrderno = koibOrderno;
	}

	public String getKoibJym() {
		return koibJym;
	}

	public void setKoibJym(String koibJym) {
		this.koibJym = koibJym;
	}

	public String getKoibBbh() {
		return koibBbh;
	}

	public void setKoibBbh(String koibBbh) {
		this.koibBbh = koibBbh;
	}


	public String getKoibZsfs() {
		return koibZsfs;
	}

	public void setKoibZsfs(String koibZsfs) {
		this.koibZsfs = koibZsfs;
	}

	public Integer getKoibFyxmId() {
		return koibFyxmId;
	}

	public void setKoibFyxmId(Integer koibFyxmId) {
		this.koibFyxmId = koibFyxmId;
	}

	public String getKoibZhsl() {
		return koibZhsl;
	}

	public void setKoibZhsl(String koibZhsl) {
		this.koibZhsl = koibZhsl;
	}

	public String getKoibHjje() {
		return koibHjje;
	}

	public void setKoibHjje(String koibHjje) {
		this.koibHjje = koibHjje;
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

	public String getKoibBz() {
		return koibBz;
	}

	public String getKoibSkpBh() {
		return koibSkpBh;
	}

	public void setKoibSkpBh(String koibSkpBh) {
		this.koibSkpBh = koibSkpBh;
	}

	public void setKoibBz(String koibBz) {
		this.koibBz = koibBz;
	}

	public String getKoibSkr() {
		return koibSkr;
	}

	public void setKoibSkr(String koibSkr) {
		this.koibSkr = koibSkr;
	}

	public String getKoibFhr() {
		return koibFhr;
	}

	public void setKoibFhr(String koibFhr) {
		this.koibFhr = koibFhr;
	}

	public String getKoibKpr() {
		return koibKpr;
	}

	public void setKoibKpr(String koibKpr) {
		this.koibKpr = koibKpr;
	}

	public String getKoibQpm() {
		return koibQpm;
	}

	public void setKoibQpm(String koibQpm) {
		this.koibQpm = koibQpm;
	}

	public String getKoibSender() {
		return koibSender;
	}

	public void setKoibSender(String koibSender) {
		this.koibSender = koibSender;
	}

	public String getKoibEmail() {
		return koibEmail;
	}

	public void setKoibEmail(String koibEmail) {
		this.koibEmail = koibEmail;
	}

	public String getKoibField1() {
		return koibField1;
	}

	public void setKoibField1(String koibField1) {
		this.koibField1 = koibField1;
	}

	public String getKoibField2() {
		return koibField2;
	}

	public void setKoibField2(String koibField2) {
		this.koibField2 = koibField2;
	}

	public String getKoibField3() {
		return koibField3;
	}

	public void setKoibField3(String koibField3) {
		this.koibField3 = koibField3;
	}

	public String getKoibField4() {
		return koibField4;
	}

	public void setKoibField4(String koibField4) {
		this.koibField4 = koibField4;
	}

	public String getKoibFplxdm() {
		return KoibFplxdm;
	}

	public void setKoibFplxdm(String koibFplxdm) {
		KoibFplxdm = koibFplxdm;
	}

	public String getKoibBmbbbh() {
		return koibBmbbbh;
	}

	public void setKoibBmbbbh(String koibBmbbbh) {
		this.koibBmbbbh = koibBmbbbh;
	}

	public String getKoibKpstatus() {
		return koibKpstatus;
	}

	public void setKoibKpstatus(String koibKpstatus) {
		this.koibKpstatus = koibKpstatus;
	}

	public String getKoibPdfStatus() {
		return koibPdfStatus;
	}

	public void setKoibPdfStatus(String koibPdfStatus) {
		this.koibPdfStatus = koibPdfStatus;
	}

	public String getKoibUploadStatus() {
		return koibUploadStatus;
	}

	public void setKoibUploadStatus(String koibUploadStatus) {
		this.koibUploadStatus = koibUploadStatus;
	}

	public BwjfKpOutsideInteBaseInfoBean(Integer id) {
		this.id = id;
	}

	public BwjfKpOutsideInteBaseInfoBean() {
	}
}
