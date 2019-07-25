package com.bwjf.createpdf.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 邮箱推送信息表
 *
 * @author cuixuejun
 * @email 799106876@qq.com
 * @date 2019-07-02 14:51:24
 */
public class BwjfKpOutsideInteMailinfoBean implements Serializable {
    private static final long serialVersionUID = 1L;

    /****/
    private String id;
    /**发票表ID**/
    private String koibId;
    /**发票请求流水号(客户传递过来的)**/
    private String koibFpqqlsh;
    /**推送的邮箱地址**/
    private String mailAddress;
    /**推送的次数**/
    private String pushCount;
    /**推送状态(0:待推送 1:成功 -1:失败 )**/
    private String pushStatus;
    /**推送日期**/
    private Date pushDate;
    /**创建日期**/
    private Date createTime;

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
     * 设置：发票表ID
     */
    public void setKoibId(String koibId) {
        this.koibId = koibId;
    }
    /**
     * 获取：发票表ID
     */
    public String getKoibId() {
        return koibId;
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
     * 设置：推送的邮箱地址
     */
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
    /**
     * 获取：推送的邮箱地址
     */
    public String getMailAddress() {
        return mailAddress;
    }
    /**
     * 设置：推送的次数
     */
    public void setPushCount(String pushCount) {
        this.pushCount = pushCount;
    }
    /**
     * 获取：推送的次数
     */
    public String getPushCount() {
        return pushCount;
    }
    /**
     * 设置：推送状态(0:成功 1:失败)
     */
    public void setPushStatus(String pushStatus) {
        this.pushStatus = pushStatus;
    }
    /**
     * 获取：推送状态(0:成功 1:失败)
     */
    public String getPushStatus() {
        return pushStatus;
    }
    /**
     * 设置：推送日期
     */
    public void setPushDate(Date pushDate) {
        this.pushDate = pushDate;
    }
    /**
     * 获取：推送日期
     */
    public Date getPushDate() {
        return pushDate;
    }
    /**
     * 设置：创建日期
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
     * 获取：创建日期
     */
    public Date getCreateTime() {
        return createTime;
    }
}