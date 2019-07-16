package com.bwjf.createpdf.entity;

import com.bwjf.createpdf.utils.NumberUtil;

import java.math.BigDecimal;
import java.util.List;



public class Xxfp extends Entity
{
	private String kplx;	//kplx为 0-蓝字发票；1-红字发票
	private String fpdm;
	private String fphm;
	private String fpzt;
	private String scbz;
	private String kprq;
	private String jqbh;
	private String skm;
	private String jym;
	private String bbh;
	private String xhdwsbh;
	private String xhdwmc;
	private String xhdwdzdh;
	private String xhdwyhzh;
	private String ghdwsbh;
	private String ghdwmc;
	private String ghdwdzdh;
	private String ghdwyhzh;
	private String bmbbbh;
	private String zsfs;
	
	private String bz;
	private String skr;
	private String fhr;
	private String kpr;
	
	private String hjje;
	private String hjse;
	private String jshj;
	private byte[] ewm;
	private String qzurl;
	
	
	
	
	
	
	
	public String getQzurl() {
		return qzurl;
	}
	public void setQzurl(String qzurl) {
		this.qzurl = qzurl;
	}
	public String getScbz() {
		return scbz;
	}
	public void setScbz(String scbz) {
		this.scbz = scbz;
	}
	public String getBbh() {
		return bbh;
	}
	public void setBbh(String bbh) {
		this.bbh = bbh;
	}
	public String getXhdwsbh() {
		return xhdwsbh;
	}
	public void setXhdwsbh(String xhdwsbh) {
		this.xhdwsbh = xhdwsbh;
	}
	public String getXhdwmc() {
		return xhdwmc;
	}
	public void setXhdwmc(String xhdwmc) {
		this.xhdwmc = xhdwmc;
	}
	public String getXhdwdzdh() {
		return xhdwdzdh;
	}
	public void setXhdwdzdh(String xhdwdzdh) {
		this.xhdwdzdh = xhdwdzdh;
	}
	public String getXhdwyhzh() {
		return xhdwyhzh;
	}
	public void setXhdwyhzh(String xhdwyhzh) {
		this.xhdwyhzh = xhdwyhzh;
	}
	public String getBmbbbh() {
		return bmbbbh;
	}
	public void setBmbbbh(String bmbbbh) {
		this.bmbbbh = bmbbbh;
	}
	public String getGhdwyhzh() {
		return ghdwyhzh;
	}
	public void setGhdwyhzh(String ghdwyhzh) {
		this.ghdwyhzh = ghdwyhzh;
	}
	public String getGhdwdzdh() {
		return ghdwdzdh;
	}
	public void setGhdwdzdh(String ghdwdzdh) {
		this.ghdwdzdh = ghdwdzdh;
	}
	public String getGhdwsbh() {
		return ghdwsbh;
	}
	public void setGhdwsbh(String ghdwsbh) {
		this.ghdwsbh = ghdwsbh;
	}
	public String getGhdwmc() {
		return ghdwmc;
	}
	public void setGhdwmc(String ghdwmc) {
		this.ghdwmc = ghdwmc;
	}
private String id;
  private String khmc;
  private String sh;
  private String dz;
  private String yhzh;
  private String djr;
  private String djsj;
  private String kpjh;
  private String swjgmc;
  private String xfId;
  private String xfsh;
  private String xfmc;
  private String xfdz;
  private String xfyhzh;
  private String fpdmhm;
  private String kpsj;
  private String skpbh;
  private String zyspmc;
  private String spsm;
  private String qdbz;
  private String ssyf;
  private String yfpdm;
  private String yfphm;
  private String zfrq;
  private String zfr;
  private String qmcs;
  private String qmz;
  private String ykfsje;
  private String fplx;
  private String fsFpdm;
  private String fsFphm;
  private String fplxcx;
  private String djsjStart;
  private String djsjEnd;
  private String fphm2;
  private String sj;
  private String fpqqlsh;
  private String pdfurl;
  private String ewmurl;
  private double jshj1;
  private double hjse1;
  private long sc;
  private String gfyx;
  private String caId;
  private String caCode;
  private String depId;
  private String depCode;
  private String traRecordId;
  List<Xxfpmx> xxfpmx;
  private int ztl;
  private String fpid;
  private String kprqStart;
  private String kprqEnd;
  private double hjje_sum;
  private double jshj_sum;
  private int count_cx;
  private String ewmPath;
  private String pdfPath;
  private String jpgUrl;
  private String kpfs;
  private String taxServer;
  private String returncode;
  private String returnmsg;
  private boolean isSuccess = false;
  private String openId;
  private String sqbz;
  private String csbz;
  private String sl;
  private BigDecimal zdid;
  private String ckYfpid;
  private String ympdbj;
  private String chbz;
  private String eMail;
  private String bmbBbh;
  private String kce;
  private int pfxType;
  private int signType;
  private String msg;
  private int sumsc;
  private List<Xxfpmx> mxlist;
  private String fpmv;

  public String getSqbz()
  {
    return this.sqbz;
  }
  public void setSqbz(String sqbz) {
    this.sqbz = sqbz;
  }
  public String getCsbz() {
    return this.csbz;
  }
  public void setCsbz(String csbz) {
    this.csbz = csbz;
  }
  public String getOpenId() {
    return this.openId;
  }
  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public String getYmpdbj()
  {
    return this.ympdbj;
  }
  public void setYmpdbj(String ympdbj) {
    this.ympdbj = ympdbj;
  }
  public String getCkYfpid() {
    return this.ckYfpid;
  }
  public void setCkYfpid(String ckYfpid) {
    this.ckYfpid = ckYfpid;
  }
  public BigDecimal getZdid() {
    return this.zdid;
  }
  public void setZdid(BigDecimal zdid) {
    this.zdid = zdid;
  }

  public String geteMail()
  {
    return this.eMail;
  }
  public void seteMail(String eMail) {
    this.eMail = eMail;
  }
  public String getChbz() {
    return this.chbz;
  }
  public void setChbz(String chbz) {
    this.chbz = chbz;
  }

  public String getBmbBbh()
  {
    return this.bmbBbh;
  }
  public void setBmbBbh(String bmbBbh) {
    this.bmbBbh = bmbBbh;
  }
  public String getZsfs() {
    return this.zsfs;
  }
  public void setZsfs(String zsfs) {
    this.zsfs = zsfs;
  }
  public String getKce() {
    return this.kce;
  }
  public void setKce(String kce) {
    this.kce = kce;
  }
  public String getFpid() {
    return this.fpid;
  }
  public void setFpid(String fpid) {
    this.fpid = fpid;
  }
  public int getZtl() {
    return this.ztl;
  }
  public void setZtl(int ztl) {
    this.ztl = ztl;
  }

  public String getMsg()
  {
    return this.msg;
  }
  public void setMsg(String msg) {
    this.msg = msg;
  }
  public List<Xxfpmx> getXxfpmx() {
    return this.xxfpmx;
  }
  public void setXxfpmx(List<Xxfpmx> xxfpmx) {
    this.xxfpmx = xxfpmx;
  }
  public long getSc() {
    return this.sc;
  }
  public void setSc(long sc) {
    this.sc = sc;
  }

  public String getGfyx() {
    return this.gfyx;
  }
  public void setGfyx(String gfyx) {
    this.gfyx = gfyx;
  }
  public String getEwmurl() {
    return this.ewmurl;
  }
  public void setEwmurl(String ewmurl) {
    this.ewmurl = ewmurl;
  }
  public String getFpqqlsh() {
    return this.fpqqlsh;
  }
  public void setFpqqlsh(String fpqqlsh) {
    this.fpqqlsh = fpqqlsh;
  }
  public String getPdfurl() {
    return this.pdfurl;
  }
  public void setPdfurl(String pdfurl) {
    this.pdfurl = pdfurl;
  }
  public String getSj() {
    return this.sj;
  }
  public void setSj(String sj) {
    this.sj = sj;
  }
  public double getJshj1() {
    return this.jshj1;
  }
  public void setJshj1(double jshj1) {
    this.jshj1 = jshj1;
  }
  public double getHjse1() {
    return this.hjse1;
  }
  public void setHjse1(double hjse1) {
    this.hjse1 = hjse1;
  }

  public int getSumsc()
  {
    return this.sumsc;
  }
  public void setSumsc(int sumsc) {
    this.sumsc = sumsc;
  }
  public String getFphm2() {
    return this.fphm2;
  }
  public void setFphm2(String fphm2) {
    this.fphm2 = fphm2;
  }
  public String getDjsjStart() {
    return this.djsjStart;
  }
  public void setDjsjStart(String djsjStart) {
    this.djsjStart = djsjStart;
  }
  public String getDjsjEnd() {
    return this.djsjEnd;
  }
  public void setDjsjEnd(String djsjEnd) {
    this.djsjEnd = djsjEnd;
  }
  public String getFplxcx() {
    return this.fplxcx;
  }
  public void setFplxcx(String fplxcx) {
    this.fplxcx = fplxcx;
  }

  public String getFplx() {
	return fplx;
}
public void setFplx(String fplx) {
	this.fplx = fplx;
}
public String getFsFpdm() {
    return this.fsFpdm;
  }
  public void setFsFpdm(String fsFpdm) {
    this.fsFpdm = fsFpdm;
  }

  public String getFsFphm()
  {
    return this.fsFphm;
  }
  public void setFsFphm(String fsFphm) {
    this.fsFphm = fsFphm;
  }
  public String getFpzt() {
    return this.fpzt;
  }
  public void setFpzt(String fpzt) {
    this.fpzt = fpzt;
  }
  public String getKpsj() {
    return this.kpsj;
  }
  public void setKpsj(String kpsj) {
    this.kpsj = kpsj;
  }

  public String getSkpbh() {
    return this.skpbh;
  }
  public void setSkpbh(String skpbh) {
    this.skpbh = skpbh;
  }
  public String getHjje() {
    return this.hjje;
  }
  public void setHjje(String hjje) {
    hjje = NumberUtil.oracleNumberFormat(hjje);
    this.hjje = hjje;
  }
  public String getHjse() {
    return this.hjse;
  }
  public void setHjse(String hjse) {
    hjse = NumberUtil.oracleNumberFormat(hjse);
    this.hjse = hjse;
  }
  public String getJshj() {
    return this.jshj;
  }
  public void setJshj(String jshj) {
    jshj = NumberUtil.oracleNumberFormat(jshj);
    this.jshj = jshj;
  }
  public String getKpr() {
    return this.kpr;
  }
  public void setKpr(String kpr) {
    this.kpr = kpr;
  }
  public String getZyspmc() {
    return this.zyspmc;
  }
  public void setZyspmc(String zyspmc) {
    this.zyspmc = zyspmc;
  }
  public String getSpsm() {
    return this.spsm;
  }
  public void setSpsm(String spsm) {
    this.spsm = spsm;
  }
  public String getQdbz() {
    return this.qdbz;
  }
  public void setQdbz(String qdbz) {
    this.qdbz = qdbz;
  }
  public String getSsyf() {
    return this.ssyf;
  }
  public void setSsyf(String ssyf) {
    this.ssyf = ssyf;
  }
  public String getYfpdm() {
    return this.yfpdm;
  }
  public void setYfpdm(String yfpdm) {
    this.yfpdm = yfpdm;
  }
  public String getYfphm() {
    return this.yfphm;
  }
  public void setYfphm(String yfphm) {
    this.yfphm = yfphm;
  }
  public String getZfrq() {
    return this.zfrq;
  }
  public void setZfrq(String zfrq) {
    this.zfrq = zfrq;
  }
  public String getZfr() {
    return this.zfr;
  }
  public void setZfr(String zfr) {
    this.zfr = zfr;
  }
  public String getQmcs() {
    return this.qmcs;
  }
  public void setQmcs(String qmcs) {
    this.qmcs = qmcs;
  }
  public String getQmz() {
    return this.qmz;
  }
  public void setQmz(String qmz) {
    this.qmz = qmz;
  }
  public String getYkfsje() {
    return this.ykfsje;
  }
  public void setYkfsje(String ykfsje) {
    this.ykfsje = ykfsje;
  }
  public String getKprqStart() {
    return this.kprqStart;
  }
  public void setKprqStart(String kprqStart) {
    this.kprqStart = kprqStart;
  }
  public String getKprqEnd() {
    return this.kprqEnd;
  }
  public void setKprqEnd(String kprqEnd) {
    this.kprqEnd = kprqEnd;
  }
  public double getHjje_sum() {
    return this.hjje_sum;
  }
  public void setHjje_sum(double hjje_sum) {
    this.hjje_sum = hjje_sum;
  }
  public double getJshj_sum() {
    return this.jshj_sum;
  }
  public void setJshj_sum(double jshj_sum) {
    this.jshj_sum = jshj_sum;
  }
  public int getCount_cx() {
    return this.count_cx;
  }
  public void setCount_cx(int count_cx) {
    this.count_cx = count_cx;
  }
  public String getFpdmhm() {
    return this.fpdmhm;
  }
  public void setFpdmhm(String fpdmhm) {
    this.fpdmhm = fpdmhm;
  }
  public String getSkm() {
    return this.skm;
  }
  public void setSkm(String skm) {
    this.skm = skm;
  }
  public String getJym() {
    return this.jym;
  }
  public void setJym(String jym) {
    this.jym = jym;
  }
  public String getXfId() {
    return this.xfId;
  }
  public void setXfId(String xfId) {
    this.xfId = xfId;
  }

  public String getKprq()
  {
    return this.kprq != null ? this.kprq : "";
  }
  public void setKprq(String kprq) {
    this.kprq = kprq;
  }
  public String getBz() {
    return this.bz != null ? this.bz : "";
  }
  public void setBz(String bz) {
    this.bz = bz;
  }
  public String getDz() {
    return this.dz != null ? this.dz : "";
  }
  public void setDz(String dz) {
    this.dz = dz;
  }
  public String getKhmc() {
    return this.khmc != null ? this.khmc : "";
  }
  public void setKhmc(String khmc) {
    this.khmc = khmc;
  }
  public String getSh() {
    return this.sh != null ? this.sh : "";
  }
  public void setSh(String sh) {
    this.sh = sh;
  }
  public String getYhzh() {
    return this.yhzh != null ? this.yhzh : "";
  }
  public void setYhzh(String yhzh) {
    this.yhzh = yhzh;
  }
  public String getDjr() {
    return this.djr;
  }
  public void setDjr(String djr) {
    this.djr = djr;
  }
  public String getDjsj() {
    return this.djsj;
  }
  public void setDjsj(String djsj) {
    this.djsj = djsj;
  }

  public String getFphm() {
    String hm = this.fphm != null ? this.fphm : "";
    if (!hm.equals("")) {
      int len = hm.length();
      for (int i = 0; i < 8 - len; i++) {
        hm = "0" + hm;
      }
    }
    return hm;
  }
  public void setFphm(String fphm) {
    this.fphm = fphm;
  }
  public String getId() {
    return this.id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public List<Xxfpmx> getMxlist() {
    return this.mxlist;
  }
  public void setMxlist(List<Xxfpmx> mxlist) {
    this.mxlist = mxlist;
  }
  public String getFpdm() {
    return this.fpdm != null ? this.fpdm : "";
  }
  public void setFpdm(String fpdm) {
    this.fpdm = fpdm;
  }
  public String getKpjh() {
    return this.kpjh != null ? this.kpjh : "0";
  }
  public void setKpjh(String kpjh) {
    this.kpjh = kpjh;
  }

  public String getKplx() {
	return kplx;
}
public void setKplx(String kplx) {
	this.kplx = kplx;
}
public String getFhr() {
    return this.fhr != null ? this.fhr : "";
  }
  public void setFhr(String fhr) {
    this.fhr = fhr;
  }
  public String getSkr() {
    return this.skr != null ? this.skr : "";
  }
  public void setSkr(String skr) {
    this.skr = skr;
  }
  public String getSwjgmc() {
    return this.swjgmc != null ? this.swjgmc : "";
  }
  public void setSwjgmc(String swjgmc) {
    this.swjgmc = swjgmc;
  }
  public String getXfdz() {
    return this.xfdz;
  }
  public void setXfdz(String xfdz) {
    this.xfdz = xfdz;
  }
  public String getXfmc() {
    return this.xfmc;
  }
  public void setXfmc(String xfmc) {
    this.xfmc = xfmc;
  }
  public String getXfsh() {
    return this.xfsh;
  }
  public void setXfsh(String xfsh) {
    this.xfsh = xfsh;
  }
  public String getXfyhzh() {
    return this.xfyhzh;
  }
  public void setXfyhzh(String xfyhzh) {
    this.xfyhzh = xfyhzh;
  }
  public String getJqbh() {
    return this.jqbh;
  }
  public void setJqbh(String jqbh) {
    this.jqbh = jqbh;
  }

  public String getFpmv()
  {
    return this.fpmv;
  }
  public void setFpmv(String fpmv) {
    this.fpmv = fpmv;
  }
  public byte[] getEwm() {
    return this.ewm;
  }
  public void setEwm(byte[] ewm) {
    this.ewm = ewm;
  }
  public String getEwmPath() {
    return this.ewmPath;
  }
  public void setEwmPath(String ewmPath) {
    this.ewmPath = ewmPath;
  }
  public String getPdfPath() {
    return this.pdfPath;
  }
  public void setPdfPath(String pdfPath) {
    this.pdfPath = pdfPath;
  }
  public String getJpgUrl() {
    return this.jpgUrl;
  }
  public void setJpgUrl(String jpgUrl) {
    this.jpgUrl = jpgUrl;
  }
  public String getReturncode() {
    return this.returncode;
  }
  public void setReturncode(String returncode) {
    this.returncode = returncode;
  }
  public String getReturnmsg() {
    return this.returnmsg;
  }
  public void setReturnmsg(String returnmsg) {
    this.returnmsg = returnmsg;
  }
  public boolean isSuccess() {
    return this.isSuccess;
  }
  public void setSuccess(boolean isSuccess) {
    this.isSuccess = isSuccess;
  }
  public String getKpfs() {
    return this.kpfs;
  }
  public void setKpfs(String kpfs) {
    this.kpfs = kpfs;
  }
  public String getTaxServer() {
    return this.taxServer;
  }
  public void setTaxServer(String taxServer) {
    this.taxServer = taxServer;
  }
  public String getCaId() {
    return this.caId;
  }
  public void setCaId(String caId) {
    this.caId = caId;
  }
  public String getCaCode() {
    return this.caCode;
  }
  public void setCaCode(String caCode) {
    this.caCode = caCode;
  }
  public String getDepId() {
    return this.depId;
  }
  public void setDepId(String depId) {
    this.depId = depId;
  }
  public String getDepCode() {
    return this.depCode;
  }
  public void setDepCode(String depCode) {
    this.depCode = depCode;
  }
  public String getTraRecordId() {
    return this.traRecordId;
  }
  public void setTraRecordId(String traRecordId) {
    this.traRecordId = traRecordId;
  }
  public int getPfxType() {
    return this.pfxType;
  }
  public void setPfxType(int pfxType) {
    this.pfxType = pfxType;
  }
  public int getSignType() {
    return this.signType;
  }
  public void setSignType(int signType) {
    this.signType = signType;
  }
  public String getSl() {
    return this.sl;
  }
  public void setSl(String sl) {
    this.sl = sl;
  }
}