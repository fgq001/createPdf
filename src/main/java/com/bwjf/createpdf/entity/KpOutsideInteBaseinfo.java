package com.bwjf.createpdf.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author cuixuejun
 * @email 799106876@qq.com
 * @date 2019-04-19 11:13:07
 */
public class KpOutsideInteBaseinfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/****/
	private String id;
	/**发票代码**/
	private String koibFpdm;
	/**发票类型代码**/
	private String koibFplxdm;
	/**发票号码**/
	private String koibFphm;
	/**发票状态**/
	private String koibFpzt;
	/**上传标志**/
	private String koibScbz;
	/**开票日期**/
	private String koibKprq;
	/**税控服务器编号**/
	private String koibJqbh;
	/**税控码（4行，每行28个字符）**/
	private String koibSkm;
	/**是否删除(0:使用 1:删除)**/
	private String koibDel;
	/**创建日期**/
	private Date koibCreatetime;
	/**数据源**/
	private String koibDatasource;
	/**销售方id**/
	private String koibXsfId;
	/**购方id**/
	private String koibGmfId;
	/**业务单据号**/
	private String koibOrderno;
	/**校验码**/
	private String koibJym;
	/**版本号**/
	private String koibBbh;
	/**税收编码版本号，参数“13.0”，具体值请询问提供商**/
	private String koibBmbbbh;
	/**征税方式 0：普通征税 1: 减按计增 2：差额征税**/
	private String koibZsfs;
	/**商品数量**/
	private String kpxmsl;
	/**商品信息表id**/
	private String koibFyxmId;
	/**综合税率**/
	private String koibZhsl;
	/**合计金额**/
	private String koibHjje;
	/**合计税额**/
	private String koibHjse;
	/**价税合计**/
	private String koibJshj;
	/**备注**/
	private String koibBz;
	/**收款人**/
	private String koibSkr;
	/**复核人**/
	private String koibFhr;
	/**开票人**/
	private String koibKpr;
	/**取票码**/
	private String koibQpm;
	/**发送方(1:nebula方 2:本地)**/
	private String koibSender;
	/**发送方邮箱地址**/
	private String koibEmail;
	/**备用字段1**/
	private String koibField1;
	/**备用字段2**/
	private String koibField2;
	/**备用字段3**/
	private String koibField3;
	/**备用字段4**/
	private String koibField4;
	/**税控盘编号**/
	private String koibSkpbh;
	/**发票请求流水号(客户传递过来的)**/
	private String koibFpqqlsh;
	/**开票类型(0-蓝字发票；1-红字发票)**/
	private String koibKplx;
	/**特殊票种标识**/
	private String koibTspz;
	/**开票状态(0:未开票 1:已开票)**/
	private String koibKpstatus;
	/**扣除额**/
	private String koibKce;
	/**原发票号码(开具红字发票需要填写)**/
	private String koibYfphm;
	/**原发票代码(开具红字发票需要填写)**/
	private String koibYfpdm;
	//是否创建pdf证书(0:未创建 1:已创建)
	private String koibPdfstatus;
	//文件路径(pdf或者二维码)
	private String koifFileAddr;
	/**
	 *是否上传到税控服务器(0:未上传 1:已上传)
	 */
	private String koibUploadStatus;

	/**
	 * 发票抬头类型(1:个人 2:企业 3:非企业性单位 4:接口开票)
	 */
	private String koibHeadtype;

	/**
	 * 纳税人识别号，可以关联销方，也可以关联购方
	 */
	private String nsrsbh;

	/**
	 * 客户名称，可以关联销方，也可以关联购方
	 */
	private String name;

	/**
	 * 销售方名称
	 */
	private String xsfName;
	/**
	 * 销售方税号
	 */
	private String xsfNsrsbh;
	/**
	 * 销售方税号
	 */
	private String xsfNsrsbhList;
	/**
	 * 购买方名称
	 */
	private String gmfName;
	/**
	 * 购买方税号
	 */
	private String gmfNsrsbh;

	/**
	 * 用户ID
	 */
	private String userId;


	/**起始日期**/
	private Date koibStarttime;
	/**结束日期**/
	private Date koibEndtime;

	/**客户类型（0：销售方  1：购方）**/
	private String koibType;

//	==========================非DBA字段===============================
	/**专票**/
	private String zpdzfp;
	/**普票**/
	private String ppdzfp;
	/**卷票**/
	private String jpdzfp;
	/**电票**/
	private String dpdzfp;
	/**电票数量**/
	private int kpCount;


	public String getKpxmsl() {
		return kpxmsl;
	}

	public void setKpxmsl(String kpxmsl) {
		this.kpxmsl = kpxmsl;
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
	/**
	 * 设置：发票代码
	 */
	public void setKoibFpdm(String koibFpdm) {
		this.koibFpdm = koibFpdm;
	}
	/**
	 * 获取：发票代码
	 */
	public String getKoibFpdm() {
		return koibFpdm;
	}
	/**
	 * 设置：发票类型代码
	 */
	public void setKoibFplxdm(String koibFplxdm) {
		this.koibFplxdm = koibFplxdm;
	}
	/**
	 * 获取：发票类型代码
	 */
	public String getKoibFplxdm() {
		return koibFplxdm;
	}
	/**
	 * 设置：发票号码
	 */
	public void setKoibFphm(String koibFphm) {
		this.koibFphm = koibFphm;
	}
	/**
	 * 获取：发票号码
	 */
	public String getKoibFphm() {
		return koibFphm;
	}
	/**
	 * 设置：发票状态
	 */
	public void setKoibFpzt(String koibFpzt) {
		this.koibFpzt = koibFpzt;
	}
	/**
	 * 获取：发票状态
	 */
	public String getKoibFpzt() {
		return koibFpzt;
	}
	/**
	 * 设置：上传标志
	 */
	public void setKoibScbz(String koibScbz) {
		this.koibScbz = koibScbz;
	}
	/**
	 * 获取：上传标志
	 */
	public String getKoibScbz() {
		return koibScbz;
	}
	/**
	 * 设置：开票日期
	 */
	public void setKoibKprq(String koibKprq) {
		this.koibKprq = koibKprq;
	}
	/**
	 * 获取：开票日期
	 */
	public String getKoibKprq() {
		return koibKprq;
	}
	/**
	 * 设置：税控服务器编号
	 */
	public void setKoibJqbh(String koibJqbh) {
		this.koibJqbh = koibJqbh;
	}
	/**
	 * 获取：税控服务器编号
	 */
	public String getKoibJqbh() {
		return koibJqbh;
	}
	/**
	 * 设置：税控码（4行，每行28个字符）
	 */
	public void setKoibSkm(String koibSkm) {
		this.koibSkm = koibSkm;
	}
	/**
	 * 获取：税控码（4行，每行28个字符）
	 */
	public String getKoibSkm() {
		return koibSkm;
	}
	/**
	 * 设置：是否删除(0:使用 1:删除)
	 */
	public void setKoibDel(String koibDel) {
		this.koibDel = koibDel;
	}
	/**
	 * 获取：是否删除(0:使用 1:删除)
	 */
	public String getKoibDel() {
		return koibDel;
	}
	/**
	 * 设置：创建日期
	 */
	public void setKoibCreatetime(Date koibCreatetime) {
		this.koibCreatetime = koibCreatetime;
	}
	/**
	 * 获取：创建日期
	 */
	public Date getKoibCreatetime() {
		return koibCreatetime;
	}
	/**
	 * 设置：数据源
	 */
	public void setKoibDatasource(String koibDatasource) {
		this.koibDatasource = koibDatasource;
	}
	/**
	 * 获取：数据源
	 */
	public String getKoibDatasource() {
		return koibDatasource;
	}
	/**
	 * 设置：销售方id
	 */
	public void setKoibXsfId(String koibXsfId) {
		this.koibXsfId = koibXsfId;
	}
	/**
	 * 获取：销售方id
	 */
	public String getKoibXsfId() {
		return koibXsfId;
	}
	/**
	 * 设置：购方id
	 */
	public void setKoibGmfId(String koibGmfId) {
		this.koibGmfId = koibGmfId;
	}
	/**
	 * 获取：购方id
	 */
	public String getKoibGmfId() {
		return koibGmfId;
	}
	/**
	 * 设置：业务单据号
	 */
	public void setKoibOrderno(String koibOrderno) {
		this.koibOrderno = koibOrderno;
	}
	/**
	 * 获取：业务单据号
	 */
	public String getKoibOrderno() {
		return koibOrderno;
	}
	/**
	 * 设置：校验码
	 */
	public void setKoibJym(String koibJym) {
		this.koibJym = koibJym;
	}
	/**
	 * 获取：校验码
	 */
	public String getKoibJym() {
		return koibJym;
	}
	/**
	 * 设置：版本号
	 */
	public void setKoibBbh(String koibBbh) {
		this.koibBbh = koibBbh;
	}
	/**
	 * 获取：版本号
	 */
	public String getKoibBbh() {
		return koibBbh;
	}
	/**
	 * 设置：税收编码版本号，参数“13.0”，具体值请询问提供商
	 */
	public void setKoibBmbbbh(String koibBmbbbh) {
		this.koibBmbbbh = koibBmbbbh;
	}
	/**
	 * 获取：税收编码版本号，参数“13.0”，具体值请询问提供商
	 */
	public String getKoibBmbbbh() {
		return koibBmbbbh;
	}
	/**
	 * 设置：征税方式 0：普通征税 1: 减按计增 2：差额征税
	 */
	public void setKoibZsfs(String koibZsfs) {
		this.koibZsfs = koibZsfs;
	}
	/**
	 * 获取：征税方式 0：普通征税 1: 减按计增 2：差额征税
	 */
	public String getKoibZsfs() {
		return koibZsfs;
	}
	/**
	 * 设置：商品信息表id
	 */
	public void setKoibFyxmId(String koibFyxmId) {
		this.koibFyxmId = koibFyxmId;
	}
	/**
	 * 获取：商品信息表id
	 */
	public String getKoibFyxmId() {
		return koibFyxmId;
	}
	/**
	 * 设置：综合税率
	 */
	public void setKoibZhsl(String koibZhsl) {
		this.koibZhsl = koibZhsl;
	}
	/**
	 * 获取：综合税率
	 */
	public String getKoibZhsl() {
		return koibZhsl;
	}
	/**
	 * 设置：合计金额
	 */
	public void setKoibHjje(String koibHjje) {
		this.koibHjje = koibHjje;
	}
	/**
	 * 获取：合计金额
	 */
	public String getKoibHjje() {
		return koibHjje;
	}
	/**
	 * 设置：合计税额
	 */
	public void setKoibHjse(String koibHjse) {
		this.koibHjse = koibHjse;
	}
	/**
	 * 获取：合计税额
	 */
	public String getKoibHjse() {
		return koibHjse;
	}
	/**
	 * 设置：价税合计
	 */
	public void setKoibJshj(String koibJshj) {
		this.koibJshj = koibJshj;
	}
	/**
	 * 获取：价税合计
	 */
	public String getKoibJshj() {
		return koibJshj;
	}
	/**
	 * 设置：备注
	 */
	public void setKoibBz(String koibBz) {
		this.koibBz = koibBz;
	}
	/**
	 * 获取：备注
	 */
	public String getKoibBz() {
		return koibBz;
	}
	/**
	 * 设置：收款人
	 */
	public void setKoibSkr(String koibSkr) {
		this.koibSkr = koibSkr;
	}
	/**
	 * 获取：收款人
	 */
	public String getKoibSkr() {
		return koibSkr;
	}
	/**
	 * 设置：复核人
	 */
	public void setKoibFhr(String koibFhr) {
		this.koibFhr = koibFhr;
	}
	/**
	 * 获取：复核人
	 */
	public String getKoibFhr() {
		return koibFhr;
	}
	/**
	 * 设置：开票人
	 */
	public void setKoibKpr(String koibKpr) {
		this.koibKpr = koibKpr;
	}
	/**
	 * 获取：开票人
	 */
	public String getKoibKpr() {
		return koibKpr;
	}
	/**
	 * 设置：取票码
	 */
	public void setKoibQpm(String koibQpm) {
		this.koibQpm = koibQpm;
	}
	/**
	 * 获取：取票码
	 */
	public String getKoibQpm() {
		return koibQpm;
	}
	/**
	 * 设置：发送方(1:nebula方 2:本地)
	 */
	public void setKoibSender(String koibSender) {
		this.koibSender = koibSender;
	}
	/**
	 * 获取：发送方(1:nebula方 2:本地)
	 */
	public String getKoibSender() {
		return koibSender;
	}
	/**
	 * 设置：发送方邮箱地址
	 */
	public void setKoibEmail(String koibEmail) {
		this.koibEmail = koibEmail;
	}
	/**
	 * 获取：发送方邮箱地址
	 */
	public String getKoibEmail() {
		return koibEmail;
	}
	/**
	 * 设置：备用字段1
	 */
	public void setKoibField1(String koibField1) {
		this.koibField1 = koibField1;
	}
	/**
	 * 获取：备用字段1
	 */
	public String getKoibField1() {
		return koibField1;
	}
	/**
	 * 设置：备用字段2
	 */
	public void setKoibField2(String koibField2) {
		this.koibField2 = koibField2;
	}
	/**
	 * 获取：备用字段2
	 */
	public String getKoibField2() {
		return koibField2;
	}
	/**
	 * 设置：备用字段3
	 */
	public void setKoibField3(String koibField3) {
		this.koibField3 = koibField3;
	}
	/**
	 * 获取：备用字段3
	 */
	public String getKoibField3() {
		return koibField3;
	}
	/**
	 * 设置：备用字段4
	 */
	public void setKoibField4(String koibField4) {
		this.koibField4 = koibField4;
	}
	/**
	 * 获取：备用字段4
	 */
	public String getKoibField4() {
		return koibField4;
	}
	/**
	 * 设置：税控盘编号
	 */
	public void setKoibSkpbh(String koibSkpbh) {
		this.koibSkpbh = koibSkpbh;
	}
	/**
	 * 获取：税控盘编号
	 */
	public String getKoibSkpbh() {
		return koibSkpbh;
	}
	/**
	 * 设置：发票请求流水号(客户传递过来的)
	 */
	public void setKoibFpqqlsh(String koibFpqqlsh) {
		this.koibFpqqlsh = koibFpqqlsh;
	}
	/**
	 * 获取：发票请求流水号(客户传递过来的)
	 */
	public String getKoibFpqqlsh() {
		return koibFpqqlsh;
	}
	/**
	 * 设置：开票类型(0-蓝字发票；1-红字发票)
	 */
	public void setKoibKplx(String koibKplx) {
		this.koibKplx = koibKplx;
	}
	/**
	 * 获取：开票类型(0-蓝字发票；1-红字发票)
	 */
	public String getKoibKplx() {
		return koibKplx;
	}
	/**
	 * 设置：特殊票种标识
	 */
	public void setKoibTspz(String koibTspz) {
		this.koibTspz = koibTspz;
	}
	/**
	 * 获取：特殊票种标识
	 */
	public String getKoibTspz() {
		return koibTspz;
	}
	/**
	 * 设置：开票状态(0:未开票 1:已开票)
	 */
	public void setKoibKpstatus(String koibKpstatus) {
		this.koibKpstatus = koibKpstatus;
	}
	/**
	 * 获取：开票状态(0:未开票 1:已开票)
	 */
	public String getKoibKpstatus() {
		return koibKpstatus;
	}
	/**
	 * 设置：扣除额
	 */
	public void setKoibKce(String koibKce) {
		this.koibKce = koibKce;
	}
	/**
	 * 获取：扣除额
	 */
	public String getKoibKce() {
		return koibKce;
	}
	/**
	 * 设置：原发票号码(开具红字发票需要填写)
	 */
	public void setKoibYfphm(String koibYfphm) {
		this.koibYfphm = koibYfphm;
	}
	/**
	 * 获取：原发票号码(开具红字发票需要填写)
	 */
	public String getKoibYfphm() {
		return koibYfphm;
	}
	/**
	 * 设置：原发票代码(开具红字发票需要填写)
	 */
	public void setKoibYfpdm(String koibYfpdm) {
		this.koibYfpdm = koibYfpdm;
	}
	/**
	 * 获取：原发票代码(开具红字发票需要填写)
	 */
	public String getKoibYfpdm() {
		return koibYfpdm;
	}

	public String getKoibPdfstatus() {
		return koibPdfstatus;
	}

	public void setKoibPdfstatus(String koibPdfstatus) {
		this.koibPdfstatus = koibPdfstatus;
	}

	public String getNsrsbh() {
		return nsrsbh;
	}

	public void setNsrsbh(String nsrsbh) {
		this.nsrsbh = nsrsbh;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKoifFileAddr() {
		return koifFileAddr;
	}

	public void setKoifFileAddr(String koifFileAddr) {
		this.koifFileAddr = koifFileAddr;
	}

	public String getXsfName() {
		return xsfName;
	}

	public void setXsfName(String xsfName) {
		this.xsfName = xsfName;
	}

	public String getXsfNsrsbh() {
		return xsfNsrsbh;
	}

	public void setXsfNsrsbh(String xsfNsrsbh) {
		this.xsfNsrsbh = xsfNsrsbh;
	}

	public String getGmfName() {
		return gmfName;
	}

	public void setGmfName(String gmfName) {
		this.gmfName = gmfName;
	}

	public String getGmfNsrsbh() {
		return gmfNsrsbh;
	}

	public void setGmfNsrsbh(String gmfNsrsbh) {
		this.gmfNsrsbh = gmfNsrsbh;
	}

	public String getXsfNsrsbhList() {
		return xsfNsrsbhList;
	}

	public void setXsfNsrsbhList(String xsfNsrsbhList) {
		this.xsfNsrsbhList = xsfNsrsbhList;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getKoibStarttime() {
		return koibStarttime;
	}

	public void setKoibStarttime(Date koibStarttime) {
		this.koibStarttime = koibStarttime;
	}

	public Date getKoibEndtime() {
		return koibEndtime;
	}

	public void setKoibEndtime(Date koibEndtime) {
		this.koibEndtime = koibEndtime;
	}

	public String getKoibType() {
		return koibType;
	}

	public void setKoibType(String koibType) {
		this.koibType = koibType;
	}

	public String getZpdzfp() {
		return zpdzfp;
	}

	public void setZpdzfp(String zpdzfp) {
		this.zpdzfp = zpdzfp;
	}

	public String getPpdzfp() {
		return ppdzfp;
	}

	public void setPpdzfp(String ppdzfp) {
		this.ppdzfp = ppdzfp;
	}

	public String getJpdzfp() {
		return jpdzfp;
	}

	public void setJpdzfp(String jpdzfp) {
		this.jpdzfp = jpdzfp;
	}

	public String getDpdzfp() {
		return dpdzfp;
	}

	public void setDpdzfp(String dpdzfp) {
		this.dpdzfp = dpdzfp;
	}

	public int getKpCount() {
		return kpCount;
	}

	public void setKpCount(int kpCount) {
		this.kpCount = kpCount;
	}

	public String getKoibUploadStatus() {
		return koibUploadStatus;
	}

	public void setKoibUploadStatus(String koibUploadStatus) {
		this.koibUploadStatus = koibUploadStatus;
	}

	public String getKoibHeadtype() {
		return koibHeadtype;
	}

	public void setKoibHeadtype(String koibHeadtype) {
		this.koibHeadtype = koibHeadtype;
	}
}
