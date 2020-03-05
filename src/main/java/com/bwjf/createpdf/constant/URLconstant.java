package com.bwjf.createpdf.constant;

/**
 * url地址常量
 */
public class URLconstant {

    /**
     * 发票365官网
     */
//    public static final String Fp365Url = "https://www.fp365.com.cn/InvoiceWebsite/tomobileStaticMainPage";
    public static final String Fp365Url = "https://www.fp365.com.cn/InvoiceWebsite/toInvoiceMain";
//    public static final String Fp365Url = "https://localhost:8097/InvoiceWebsite/toInvoiceMain";
    /**
     * 发票365手机端
     */
//    public static final String Fp365MobileUrl = "https://www.fp365.com.cn:8888/mobile/tomobileStaticMainPage";
    public static final String Fp365MobileUrl = "https://www.fp365.com.cn:8888/InvoiceWebsite/toInvoiceMain";
//    public static final String Fp365MobileUrl = "https://localhost:8097/InvoiceWebsite/toInvoiceMain";

    //public static final String downLoadUrl = "http://222.190.111.164:8091/";

    //注册码url
//	public static final String NebulaUrl = "http://202.102.62.251:6015/AC/";
    public static final String NebulaUrl = "http://192.168.30.70:8085/AC";
    //税控服务器接口(本地)
//	public static final String SKSERVER_URL = "http://127.0.0.1:8092";
//	public static final String CAURl = "http://202.102.62.250:7019";



//------------------------------正式服-------------------------------
    //CA证书Url
	public static final String CAURl = "http://192.168.30.33:8091";
    //税控服务器接口
    //正式服
	public static final String SKSERVER_URL = "http://192.168.30.36:8092";
    //生成PDF 服务器地址
	public static final String PDFSERVER_URL = "http://192.168.30.33:8095/pdf/createPdf";
    //到发票待开页面
    public static final String INVOICEOPENPAGE_URL = "https://www.fp365.com.cn:8888/toOpenInvoice";
    //发票邮箱内容的取票url
    public static final String FPEMAILCONSTANT_URL = "https://www.fp365.com.cn:8888/getInvoice";
    //陈总接口返回数据url
    public static final String downLoadUrl = "https://www.fp365.com.cn:8888";

    /**
     * 百旺开票
     */
//    public static final String BWKP_PRODUCT_URL = "https://www.fp365.com.cn:8888/ticketOpen/invoiceBuildPdfInte";

//    public static final String BWKP_PRODUCT_URL = "http://192.168.30.31:8093/ticketOpen/invoiceBuildPdfInte";
    public static final String BWKP_PRODUCT_URL = "http://192.168.30.10:8093/ticketOpen/invoiceBuildPdfInte";


    //到发票待开页面
//	public static final String INVOICEOPENPAGE_URL = "http://127.0.0.1:8093/toOpenInvoice";
    //正式服
//	public static final String INVOICEOPENPAGE_URL = "http://202.102.62.228:8888/toOpenInvoice";
//	public static final String INVOICEOPENPAGE_URL = "http://192.168.30.37:8888/toOpenInvoice";

    //solr服务地址
    //public static String SOLRURL = "http://localhost:8085/solr/customerinfo/";
    public static String SOLRURL = "http://192.168.30.33:8085/solr/customerinfo/";


    //------------------------------测试服-------------------------------
    //税控服务器
//    public static final String SKSERVER_URL = "http://192.168.30.10:8092";
    //pdf服务器
//    public static final String PDFSERVER_URL = "http://192.168.30.20:8095//pdf/createPdf";
    //CA证书Url
//    public static final String CAURl = "http://192.168.30.20:8091";
    //到发票待开页面
//    public static final String INVOICEOPENPAGE_URL = "http://127.0.0.1:8093/toOpenInvoice";
//    public static final String INVOICEOPENPAGE_URL = "http://www.jsbwjf.com.cn:8093/toOpenInvoice";
    //发票邮箱内容url(获取发票PDF接口的url)
    //陈总接口返回数据url
//    public static final String downLoadUrl = "http://www.jsbwjf.com.cn:8093";

//    public static final String FPEMAILCONSTANT_URL = "http://www.jsbwjf.com.cn:8093/getInvoice";
}
