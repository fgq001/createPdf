package com.bwjf.createpdf.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user000 on 2018/7/25.
 */
public class TcaCertpathBean extends BaseBean implements Serializable {
    /** id. */
    private Integer id ;
    /** 客户ID */
    private Integer ca_id ;
    /** 路径 */
    private String vpath  ;
    /** 状态 */
    private String istatus;
    /** 备注 */
    private String vmemo ;
    /** 文件类型：1证书 2图片 **/
    private String ifiletype;
    /**  到期时间 **/
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date tEndTime;

    /**
     * 纳税识别人编号
     */
    private String vunitedcode;

    /**
     * 客户名称
     */
    private String vname;

    public String getVunitedcode() {
        return vunitedcode;
    }

    public void setVunitedcode(String vunitedcode) {
        this.vunitedcode = vunitedcode;
    }

    public String gettEndTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String tEndTime ="";
        if(tcreatedtime != null){
            tEndTime = sdf.format(tcreatedtime);
        }
        return tEndTime;
    }

    public void settEndTime(Date tEndTime) {
        this.tEndTime = tEndTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCa_id() {
        return ca_id;
    }

    public void setCa_id(Integer ca_id) {
        this.ca_id = ca_id;
    }

    public String getVpath() {
        return vpath;
    }

    public void setVpath(String vpath) {
        this.vpath = vpath;
    }

    public String getIstatus() {
        return istatus;
    }

    public void setIstatus(String istatus) {
        this.istatus = istatus;
    }

    public String getVmemo() {
        return vmemo;
    }

    public void setVmemo(String vmemo) {
        this.vmemo = vmemo;
    }

    public String getIfiletype() {
        return ifiletype;
    }

    public void setIfiletype(String ifiletype) {
        this.ifiletype = ifiletype;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }
}
