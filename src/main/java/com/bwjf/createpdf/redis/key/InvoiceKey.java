package com.bwjf.createpdf.redis.key;

/**
 * 发票相关key
 */
public class InvoiceKey extends BasePrefix{


    public InvoiceKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    /**
     * 发票主表
     */
    public static InvoiceKey koibKey = new InvoiceKey(60, "koib");
    /**
     * 电票商品相关信息表
     */
    public static InvoiceKey koifKey = new InvoiceKey(60, "koif");
    /**
     * 发票表子表
     */
    public static InvoiceKey koisKey = new InvoiceKey(60, "kois");
    /**
     * 开票结果信息表
     */
    public static InvoiceKey kriKey = new InvoiceKey(60, "kri");
    /**
     * 客户信息表
     */
    public static InvoiceKey kcustomerKey = new InvoiceKey(60, "kcustomerKey");
    /**
     * CA证书子表
     */
    public static InvoiceKey kcsiKey = new InvoiceKey(60, "kcsi");
    /**
     * 电票文件信息相关表
     */
    public static InvoiceKey kfiKey = new InvoiceKey(60, "kfiEwmKey");

    /**
     *  电票二维码信息
     */
    public static InvoiceKey kfiEwmKey = new InvoiceKey(60, "kfiEwmKey");




}
