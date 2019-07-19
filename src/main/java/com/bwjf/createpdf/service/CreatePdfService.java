package com.bwjf.createpdf.service;

import com.bwjf.createpdf.entity.Xxfp;
import com.bwjf.createpdf.entity.Xxfpmx;
import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 2019/7/16.
 */

//	//pfx文件路径
//	static  String pfx = "E:\\PDFFileTest\\1.pfx";
//	//开票的xml内容
//	static String xmlContent;
//	//税控设备编号
//	static String strJQBH;
//	//印章地址
//	static  String gif = "E:\\PDFFileTest\\1.gif";
//	//pdf模板地址
//	static String tmpPath = "E:\\PDFFileTest\\Jiangsu(2).pdf";
//	//创建的临时pdf路径
//	static String temPath = ("E:\\PDFFileTest" + File.separator + CommonUtils.getUUID() + ".pdf");
//	//最终签名后的pdf路径
//	static String endPath = "E:\\PDFFileTest" + File.separator + randomTime + ".pdf";
//	//签章密码
//	static  String password = "111111";

public interface CreatePdfService {


    boolean createPdf(String tmpPath,String temPath,String endPath, Xxfp xxfp,List<Xxfpmx> xxfpmxList, String pfx, String gif, String password) ;

    void createFp(String tmpPath, String temPath, String endPath, Xxfp xxfp, List<Xxfpmx> mxlist, String pfx, String gif, String password) throws IOException, DocumentException;

    boolean isQdfp(Xxfp xxfp, List<Xxfpmx> mxlist);

    String handleTempalteSpfp(Xxfp xxfp, List<Xxfpmx> xxfpmx,String tmpPath, String temPath);

    void handleTempalteNew(String tempPdf, String temPath, int pages);

    void createCommonSpTest(String tmpPath, String tempPdf1, Xxfp xxfp, List<Xxfpmx> mxlist,String gif) throws IOException, DocumentException;
}
