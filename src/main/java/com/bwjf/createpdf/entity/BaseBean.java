package com.bwjf.createpdf.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user000 on 2018/7/25.
 */
public class BaseBean {
    /** 创建日期. */
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    protected Date tcreatedtime;
    /** 创建人. */
    protected String vcreatedby;
    /** 修改日期. */
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    protected Date tmodifiedtime;
    /** 修改人. */
    protected String vmodifiedby;

    /**
     * 分页(起始页)
     */
    private String startPage;

    /**
     * 分页(结束页)
     */
    private String endPage;

    public void setStartPage(String startPage) {
        this.startPage = startPage;
    }

    public void setEndPage(String endPage) {
        this.endPage = endPage;
    }

    public String getStartPage() {
        return startPage;
    }

    public String getEndPage() {
        return endPage;
    }

    public String getTcreatedtime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String createTime ="";
        if(tcreatedtime != null){
            createTime = sdf.format(tcreatedtime);
        }
        return createTime;
    }

    public String getTmodifiedtime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String modifiTime ="";
        if(tmodifiedtime != null){
            modifiTime = sdf.format(tmodifiedtime);
        }

        return modifiTime;
    }

    public void setTcreatedtime(Date tcreatedtime) {
        this.tcreatedtime = tcreatedtime;
    }

    public void setTmodifiedtime(Date tmodifiedtime) {
        this.tmodifiedtime = tmodifiedtime;
    }

    public String getVcreatedby() {
        return vcreatedby;
    }

    public void setVcreatedby(String vcreatedby) {
        this.vcreatedby = vcreatedby;
    }



    public String getVmodifiedby() {
        return vmodifiedby;
    }

    public void setVmodifiedby(String vmodifiedby) {
        this.vmodifiedby = vmodifiedby;
    }
}
