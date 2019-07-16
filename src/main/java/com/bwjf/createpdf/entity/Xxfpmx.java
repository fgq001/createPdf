package com.bwjf.createpdf.entity;

import com.bwjf.createpdf.utils.NumberUtil;

public class Xxfpmx extends Entity
{
	private String fphxz;
	private String spmc;
	private String spsm;
	private String ggxh;
	private String dw;
	private String spsl;
	private String dj;
	private String je;
	private String sl;
	private String se;
	private String hsbz;
	private String spbm;
	private String zxbm;
	private String yhzcbs;
	private String lslbs;
	private String zzstsgl;
	
	
	
	
	
	
	public String getSpsm() {
		return spsm;
	}
	public void setSpsm(String spsm) {
		this.spsm = spsm;
	}
	public String getSpmc() {
		return spmc;
	}
	public void setSpmc(String spmc) {
		this.spmc = spmc;
	}
	public String getGgxh() {
		return ggxh;
	}
	public void setGgxh(String ggxh) {
		this.ggxh = ggxh;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public String getSpsl() {
		return spsl;
	}
	public void setSpsl(String spsl) {
		this.spsl = spsl;
	}
	public String getHsbz() {
		return hsbz;
	}
	public void setHsbz(String hsbz) {
		this.hsbz = hsbz;
	}
	public String getSpbm() {
		return spbm;
	}
	public void setSpbm(String spbm) {
		this.spbm = spbm;
	}
private long id;
  private String fpid;
  private String hwmc;
  private String jldw;
  private String gg;
  private String tax;
  private long sfhs;
  private String basSpbmBm;
  private String traMxid;
  private long commodityId;
  private int commodityNum;
  private String khmc;
  private String sh;
  private String dz;
  private String yhzh;
  private String skr;
  private String fhr;
  private String bz;
  private long qdbz;
  private long spId;

  public String getTraMxid()
  {
    return this.traMxid;
  }
  public void setTraMxid(String traMxid) {
    this.traMxid = traMxid;
  }
  public String getZxbm() {
    return this.zxbm;
  }
  public void setZxbm(String zxbm) {
    this.zxbm = zxbm;
  }
  public String getYhzcbs() {
    return this.yhzcbs;
  }
  public void setYhzcbs(String yhzcbs) {
    this.yhzcbs = yhzcbs;
  }
  public String getLslbs() {
    return this.lslbs;
  }
  public void setLslbs(String lslbs) {
    this.lslbs = lslbs;
  }
  public String getZzstsgl() {
    return this.zzstsgl;
  }
  public void setZzstsgl(String zzstsgl) {
    this.zzstsgl = zzstsgl;
  }
  public String getBasSpbmBm() {
    return this.basSpbmBm;
  }
  public void setBasSpbmBm(String basSpbmBm) {
    this.basSpbmBm = basSpbmBm;
  }
  public long getSfhs() {
    return this.sfhs;
  }
  public void setSfhs(long sfhs) {
    this.sfhs = sfhs;
  }
  public String getKhmc() {
    return this.khmc;
  }
  public void setKhmc(String khmc) {
    this.khmc = khmc;
  }
  public String getSh() {
    return this.sh;
  }
  public void setSh(String sh) {
    this.sh = sh;
  }
  public String getDz() {
    return this.dz;
  }
  public void setDz(String dz) {
    this.dz = dz;
  }
  public String getYhzh() {
    return this.yhzh;
  }
  public void setYhzh(String yhzh) {
    this.yhzh = yhzh;
  }

  public long getSpId()
  {
    return this.spId;
  }
  public void setSpId(long spId) {
    this.spId = spId;
  }
  public long getQdbz() {
    return this.qdbz;
  }
  public void setQdbz(long qdbz) {
    this.qdbz = qdbz;
  }
  public String getSkr() {
    return this.skr;
  }
  public void setSkr(String skr) {
    this.skr = skr;
  }
  public String getFhr() {
    return this.fhr;
  }
  public void setFhr(String fhr) {
    this.fhr = fhr;
  }
  public String getBz() {
    return this.bz;
  }
  public void setBz(String bz) {
    this.bz = bz;
  }

  public String getFphxz() {
	return fphxz;
}
public void setFphxz(String fphxz) {
	this.fphxz = fphxz;
}
public long getCommodityId() {
    return this.commodityId;
  }
  public void setCommodityId(long commodityId) {
    this.commodityId = commodityId;
  }

  public int getCommodityNum() {
    return this.commodityNum;
  }
  public void setCommodityNum(int commodityNum) {
    this.commodityNum = commodityNum;
  }
  public long getId() {
    return this.id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public String getDj() {
    return this.dj != null ? this.dj : "";
  }
  public void setDj(String dj) {
    dj = NumberUtil.oracleNumberFormat(dj);
    this.dj = dj;
  }
  public String getFpid() {
    return this.fpid;
  }
  public void setFpid(String fpid) {
    this.fpid = fpid;
  }
  public String getGg() {
    return this.gg != null ? this.gg : "";
  }
  public void setGg(String gg) {
    this.gg = gg;
  }
  public String getHwmc() {
    return this.hwmc != null ? this.hwmc : "";
  }
  public void setHwmc(String hwmc) {
    this.hwmc = hwmc;
  }
  public String getJe() {
    return this.je != null ? this.je : "";
  }
  public void setJe(String je) {
    je = NumberUtil.oracleNumberFormat(je);
    this.je = je;
  }
  public String getJldw() {
    return this.jldw != null ? this.jldw : "";
  }
  public void setJldw(String jldw) {
    this.jldw = jldw;
  }

  public String getSe() {
    return this.se != null ? this.se : "";
  }
  public void setSe(String se) {
    se = NumberUtil.oracleNumberFormat(se);
    this.se = se;
  }
  public String getSl() {
    return this.sl != null ? this.sl : "";
  }
  public void setSl(String sl) {
    sl = NumberUtil.oracleNumberFormat(sl);
    this.sl = sl;
  }
  public String getTax() {
    return this.tax != null ? this.tax : "";
  }
  public void setTax(String tax) {
    tax = NumberUtil.oracleNumberFormat(tax);
    this.tax = tax;
  }
}