package com.bwjf.createpdf.constant;

import com.bwjf.createpdf.entity.Porper;
import com.bwjf.createpdf.service.XMLDomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;

public class FilePathConstant {
	
	/**
	 * 日志文件 输出路径
	 */
	public static final String LogFilePath = "E:/onLineData/";
	
	/**
	 * 创建PDF相关路径 
	 */
	public static final String PdfFilePath = "E:/PDFFile/";

	/**
	 * 签名pdf路径
	 */
	public static final String qmPdfFilePath = "E:/PDFFile/qmpdfFile/";
//	public static final String CertFilePath = "E:/PDFFile/";

	//签章密码
	public static String password = "111111";
	//创建的临时pdf路径
	public static String temPath = "E:/PDFFileTest/PDFtemplate/";
	//最终签名后的pdf路径
	public static String endPath = "E:/PDFFileTest/pdfFile/";
	//发票二维码路径
	public static String ewmPath = "E:/PDFFileTest/ewnFile/";
	//清单发票路径
	public static String qdmbPath = "E:"+ File.separator+"PDFFileTest"+ File.separator + "qd(1).pdf";

}
