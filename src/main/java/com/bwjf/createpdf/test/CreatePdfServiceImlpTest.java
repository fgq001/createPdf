package com.bwjf.createpdf.test;

import com.bwjf.createpdf.constant.FilePathConstant;
import com.bwjf.createpdf.entity.Xxfp;
import com.bwjf.createpdf.entity.Xxfpmx;
import com.bwjf.createpdf.utils.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author admin 生成单票与单张清单票 清单容纳最多30条数据
 *
 */
public class CreatePdfServiceImlpTest {
	// private static Logger logger = Logger.getLogger(PdfUtil.class);
	// static String qdmbPath = FileOperation.getAbsoPath("template" +
	// File.separator + "fp" + File.separator + "qd.pdf");


	// static String qdmbPath = ("E:\\PDFFileTest" + File.separator +
	// "Jiangsu.pdf");

	// public static BasSpbmDao getBasSpbmDao() {
	// WebApplicationContext context =
	// ContextLoader.getCurrentWebApplicationContext();
	// BasSpbmDao basSpbmDao = (BasSpbmDao)context.getBean("basSpbmDao");
	// return basSpbmDao;
	// }


	public static boolean createPdf(String tmpPath, String tempPdf1, String ewmPth, String qygzUrl, Xxfp xxfp,
			List<Xxfpmx> xxfpmx, boolean isQz) {
		boolean bo = true;
		try {
			File nf = new File(tempPdf1);
			if (!nf.getParentFile().exists()) {
				nf.getParentFile().mkdirs();
			}
			if (nf.exists()) {
				nf.delete();
			}

			createFp(tmpPath, tempPdf1, xxfp, xxfpmx, ewmPth, qygzUrl, isQz);
			// createSpfp(pdfTemp, expPath, xxfp, mxlist, qygzUrl);
		} catch (FileNotFoundException e) {
			bo = false;
			 System.err.print("发票pdf(带签章)生成失败,发票代码：" + xxfp.getFpdm() + ",发票号码：" +
			 xxfp.getFphm());
		} catch (DocumentException e) {
			bo = false;
			System.err.print("发票pdf(带签章)生成失败,发票代码：" + xxfp.getFpdm() + ",发票号码：" +
			 xxfp.getFphm());
		} catch (IOException e) {
			bo = false;
			System.err.print("发票pdf(带签章)生成失败,发票代码：" + xxfp.getFpdm() + ",发票号码：" +
			 xxfp.getFphm());
		}
		return bo;
	}


	private static void createFp(String tmpPath, String tempPdf1, Xxfp xxfp, List<Xxfpmx> mxlist, String ewmPth,
			String qygzUrl, boolean isQz) throws IOException, DocumentException {
		// 读模板PDF路径
		PdfReader reader = new PdfReader(tmpPath);
		// 创建临时生成PDF路径
		String pdfTemp = tempPdf1;	//临时PDF
		String pdfEnd = expPath1;	//最终PDF
//		pdfTemp = tempPdf1;
//		String pdfTemp = "";
//		String pdfTemp1 = expPath1;
//		pdfTemp = tempPdf1;


		new File(pdfTemp).getParentFile().mkdirs();
		FileOutputStream tempFile = new FileOutputStream(pdfTemp);
		PdfStamper stamp = new PdfStamper(reader, tempFile);
		stamp.setFormFlattening(true);
		
		stamp.close();
		reader.close();
		tempFile.close();
		
		pdfTemp = handleTempalteSpfp(xxfp, mxlist, pdfTemp);
		createCommonSpTest(pdfTemp, tempPdf1, xxfp, mxlist);
		SignPDF.sign(pfx, tempPdf1, pdfEnd, gif, password);
		
	}

	/**
	 * 判断商品数量是否超过8条
	 * 
	 * @param xxfp
	 * @param mxlist
	 * @return
	 */
	private static boolean isQdfp(Xxfp xxfp, List<Xxfpmx> mxlist) {
		return (xxfp != null) && (mxlist != null) && (mxlist.size() > 8);
	}


	//		移动到 NumberUtil
	private static String Tostr(String str) {
//		String str = "dsfdsafdsafdsafas";
		// 字符串长度
		int strlenth = str.length();
		// 需要加空格数量
		int blankcount = 0;
		// 判断字符串长度
		if (strlenth <= 5) {
			blankcount = 0;
		} else {
			blankcount = strlenth % 5 > 0 ? strlenth / 5 : str.length() / 5 - 1; // 需要加空格数量
		}
		// 插入空格
		if (blankcount > 0) {
			for (int i = 0; i < blankcount; i++) {
				str = str.substring(0, (i + 1) * 5 + i) + " " + str.substring((i + 1) * 5 + i, strlenth + i);
			}
		} else {
			System.out.println("输入的字符串不多于4位，不需要添加空格");
		}
		System.out.println(str);
		return str;
	}
	
	
	/**
	 * 生成发票清单与单张发票 第一张 共有部分
	 * 
	 * @param tmpPath
//	 * @param expPath
	 * @param xxfp
	 * @param mxlist
	 * @throws IOException
	 * @throws DocumentException
	 */
	private static void createCommonSpTest(String tmpPath, String tempPdf1, Xxfp xxfp, List<Xxfpmx> mxlist)
			throws IOException, DocumentException {
		
		PdfReader reader = new PdfReader(tmpPath);
		FileOutputStream tempFile = new FileOutputStream(tempPdf1);
		PdfStamper stamp = new PdfStamper(reader, tempFile);
		
		int count = mxlist == null ? 0 : mxlist.size();
		
		//宋体
        BaseFont bfChineseST = BaseFont.createFont("src/main/resources/font/simsun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

//		font.getCalculatedBaseFont(true).getWidthPoint(text, font.getCalculatedSize());
        Font fontST12 = new Font(bfChineseST,12.0F);
        Font fontST11 = new Font(bfChineseST,11.0F);
        Font fontST10 = new Font(bfChineseST,10.0F);
        Font fontST9 = new Font(bfChineseST,9.0F);
        Font fontST8 = new Font(bfChineseST,8.0F);
        Font fontST7 = new Font(bfChineseST,7.0F);
        Font fontST6 = new Font(bfChineseST,6.0F);
        Font fontST5 = new Font(bfChineseST,5.0F);
        //黑体
        BaseFont bfChineseHT = BaseFont.createFont("src/main/resources/font/SIMHEI.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font fontHT10 = new Font(bfChineseHT,10.0F);
        Font fontHT14 = new Font(bfChineseHT,14.0F);

//		DocumentFont dd = new DocumentFont();
//		BaseFont ee = new DocumentFont(dd).getWidth("dfsd");
//		BaseFont.getWidthPoint（String text，float fontSize）
//		DocumentFont dd = new DocumentFont().getWidth("");
//		dd.getWidth("");
//		Type3Font ff = new Type3Font();


        //Courier New 数字
        Font courier12 = FontFactory.getFont(BaseFont.COURIER, BaseFont.WINANSI, 12.0F);
        Font courier11 = FontFactory.getFont(BaseFont.COURIER, BaseFont.WINANSI, 11.0F);
		Font courier10 = FontFactory.getFont(BaseFont.COURIER, BaseFont.WINANSI, 10.0F);
		Font courier8 = FontFactory.getFont(BaseFont.COURIER, BaseFont.WINANSI, 8.0F);
		
		int pages = count / 30 + (count % 30 == 0 ? 0 : 1);
		int PDFPages = reader.getNumberOfPages();

		System.out.println("count:  " + count + "   pages:   " + pages + "   PDFPages:  " + PDFPages);
		// 生成第一页共有内容
		PdfContentByte over1 = stamp.getOverContent(1);
		//判断是否正负发票
		if(xxfp.getKplx().equals("1")) {
			TextAlign.setSimpleTextLeft("销项负数", 97.0F, 323.0F, 185.0F, 343.0F, fontHT14, over1);
		}
		//判断是否是收购发票
		if(xxfp.getTspz().equals("02")) {
			TextAlign.setSimpleTextLeft("收购", 97.0F, 345.0F, 185.0F, 359.0F, fontST12, over1);
		}
		
//		setSimpleText(xxfp.getFpdm(), 477.0F, 372.0F, 700.0F, 382.0F, font, over1);
//		setSimpleText(xxfp.getFphm(), 477.0F, 352.0F, 700.0F, 364.0F, font, over1);
//		TextAlign.setSimpleTextLeft(xxfp.getFpdm(), 465.0F, 359.0F, 580.0F, 379.0F, courier10, over1);
		TextAlign.setSimpleTextLeft(xxfp.getFpdm(), 475.0F, 372.0F, 585.0F, 381.0F, courier10, over1);
		TextAlign.setSimpleTextLeft(xxfp.getFphm(), 475.0F, 343.5F, 585.0F, 363.5F, courier10, over1);
		String kprq = xxfp.getKprq().substring(0, 4) + "  " + xxfp.getKprq().substring(4, 6) + "  "
				+ xxfp.getKprq().substring(6, 8);
		TextAlign.setSimpleTextLeft(kprq, 476.0F, 334.0F, 585.0F, 346.0F, courier10, over1);
		TextAlign.setSimpleTextLeft(CreatePdfServiceImlpTest.Tostr(xxfp.getJym()), 475.0F, 319.5F, 585.0F, 329.5F, courier8, over1);
		TextAlign.setSimpleTextLeft(xxfp.getJqbh(), 74.0F, 308.0F, 220.0F, 328.0F, courier11, over1);


		
		String skm1 = xxfp.getSkm().substring(0, 28);
		String skm2 = xxfp.getSkm().substring(28, 56);
		String skm3 = xxfp.getSkm().substring(56, 84);
		String skm4 = xxfp.getSkm().substring(84);

		float lineTop1 = 12.5F;
		TextAlign.setSimpleTextLeft(skm1, 373.0F, 304 - lineTop1 * 1, 585.0F, 316 - lineTop1 * 1, courier12, over1);
		TextAlign.setSimpleTextLeft(skm2, 373.0F, 304 - lineTop1 * 2, 585.0F, 316 - lineTop1 * 2, courier12, over1);
		TextAlign.setSimpleTextLeft(skm3, 373.0F, 304 - lineTop1 * 3, 585.0F, 316 - lineTop1 * 3, courier12, over1);
		TextAlign.setSimpleTextLeft(skm4, 373.0F, 304 - lineTop1 * 4, 585.0F, 316 - lineTop1 * 4, courier12, over1);

//		if(xxfp.getGhdwmc().length()>27){
//			TextAlign.setSimpleTextLeft(xxfp.getGhdwmc(), 107.0F, 287.5F, 324.0F, 307.5F, fontST6, over1);
//		}
		//判断是否是收购发票
		if(xxfp.getTspz().equals("02")) {
//			TextAlign.setSimpleTextLeft(xxfp.getXhdwmc(), 107.0F, 287.5F, 332.0F, 307.5F, fontST8, over1);
			if (NumberUtil.StrCount(xxfp.getXhdwmc())<226.0F){
				TextAlign.setSimpleTextLeft(xxfp.getXhdwmc(), 107.0F, 287.5F, 332.0F, 307.5F, fontST8, over1);
			}else{
				TextAlign.setSimpleTextLeft1(xxfp.getXhdwmc(), 107.0F, 287.5F, 332.0F, 307.5F, fontST7, over1);
			}

//			TextAlign.setSimpleTextLeft(xxfp.getXhdwsbh(), 107.0F, 272.5F, 332.0F, 292.5F, fontST8, over1);
			if (NumberUtil.StrCount(xxfp.getXhdwsbh())<226.0F){
				TextAlign.setSimpleTextLeft(xxfp.getXhdwsbh(), 107.0F, 272.5F, 332.0F, 292.5F, fontST8, over1);
			}else{
				TextAlign.setSimpleTextLeft1(xxfp.getXhdwsbh(), 107.0F, 272.5F, 332.0F, 292.5F, fontST7, over1);
			}

//			TextAlign.setSimpleTextLeft(xxfp.getXhdwdzdh(), 107.0F, 255.5F, 332.0F, 277.5F, fontST8, over1);
			if (NumberUtil.StrCount(xxfp.getXhdwdzdh())<226.0F){
				TextAlign.setSimpleTextLeft(xxfp.getXhdwdzdh(), 107.0F, 255.5F, 332.0F, 277.5F, fontST8, over1);
			}else{
				TextAlign.setSimpleTextLeft1(xxfp.getXhdwdzdh(), 107.0F, 255.5F, 332.0F, 277.5F, fontST7, over1);
			}

//			TextAlign.setSimpleTextLeft1(xxfp.getXhdwyhzh(), 107.0F, 242.0F, 332.0F, 262.0F, fontST8, over1);
			if (NumberUtil.StrCount(xxfp.getXhdwyhzh())<226.0F){
				TextAlign.setSimpleTextLeft(xxfp.getXhdwyhzh(), 107.0F, 242.0F, 332.0F, 262.0F, fontST8, over1);
			}else{
				TextAlign.setSimpleTextLeft1(xxfp.getXhdwyhzh(), 107.0F, 242.0F, 332.0F, 262.0F, fontST7, over1);
			}

//			TextAlign.setSimpleTextLeft(xxfp.getGhdwmc(), 107.0F, 83.5F, 332.0F, 103.5F, fontST8, over1);//+3
			if (NumberUtil.StrCount(xxfp.getGhdwmc())<226.0F){
				TextAlign.setSimpleTextLeft(xxfp.getGhdwmc(), 107.0F, 79.5F, 332.0F, 99.5F, fontST8, over1);//+3
			}else{
				TextAlign.setSimpleTextLeft1(xxfp.getGhdwmc(), 107.0F, 79.5F, 332.0F, 99.5F, fontST7, over1);//+3
			}

//			TextAlign.setSimpleTextLeft1(xxfp.getGhdwsbh(), 107.0F, 69.5F, 332.0F, 89.5F, fontST8, over1);
			if (NumberUtil.StrCount(xxfp.getGhdwsbh())<226.0F){
				TextAlign.setSimpleTextLeft(xxfp.getGhdwsbh(), 107.0F, 65.5F, 332.0F, 85.5F, fontST8, over1);
			}else{
				TextAlign.setSimpleTextLeft1(xxfp.getGhdwsbh(), 107.0F, 65.5F, 332.0F, 85.5F, fontST7, over1);
			}

//			TextAlign.setSimpleTextLeft(xxfp.getGhdwdzdh(), 107.0F, 55.5F, 332.0F, 75.5F, fontST8, over1);
			if (NumberUtil.StrCount(xxfp.getGhdwdzdh())<226.0F){
				TextAlign.setSimpleTextLeft(xxfp.getGhdwdzdh(), 107.0F, 51.5F, 332.0F, 71.5F, fontST8, over1);
			}else{
				TextAlign.setSimpleTextLeft1(xxfp.getGhdwdzdh(), 107.0F, 51.5F, 332.0F, 71.5F, fontST7, over1);
			}

//			TextAlign.setSimpleTextLeft(xxfp.getGhdwyhzh(), 107.0F, 42.5F, 332.0F, 62.5F, fontST8, over1);
			if (NumberUtil.StrCount(xxfp.getGhdwyhzh())<226.0F){
				TextAlign.setSimpleTextLeft(xxfp.getGhdwyhzh(), 107.0F, 38.5F, 332.0F, 58.5F, fontST8, over1);
			}else{
				TextAlign.setSimpleTextLeft1(xxfp.getGhdwyhzh(), 107.0F, 38.5F, 332.0F, 58.5F, fontST7, over1);
			}


		} else {
			// 	常规发票
			//	矩形长为	225.0F

			if (NumberUtil.StrCount(xxfp.getGhdwmc())<226.0F){
				TextAlign.setSimpleTextLeft(xxfp.getGhdwmc(), 107.0F, 287.5F, 332.0F, 307.5F, fontST8, over1);
			}else{
				TextAlign.setSimpleTextLeft1(xxfp.getGhdwmc(), 107.0F, 287.5F, 332.0F, 307.5F, fontST7, over1);
			}

//			TextAlign.setSimpleTextLeft(xxfp.getGhdwsbh(), 107.0F, 272.5F, 332.0F, 292.5F, fontST8, over1);
			if (NumberUtil.StrCount(xxfp.getGhdwsbh())<226.0F){
				TextAlign.setSimpleTextLeft(xxfp.getGhdwsbh(), 107.0F, 272.5F, 332.0F, 292.5F, fontST8, over1);
			}else{
				TextAlign.setSimpleTextLeft1(xxfp.getGhdwsbh(), 107.0F, 272.5F, 332.0F, 292.5F, fontST7, over1);
			}

//			TextAlign.setSimpleTextLeft(xxfp.getGhdwdzdh(), 107.0F, 255.5F, 332.0F, 277.5F, fontST8, over1);
			if (NumberUtil.StrCount(xxfp.getGhdwdzdh())<226.0F){
				TextAlign.setSimpleTextLeft(xxfp.getGhdwdzdh(), 107.0F, 255.5F, 332.0F, 277.5F, fontST8, over1);
			}else{
				TextAlign.setSimpleTextLeft1(xxfp.getGhdwdzdh(), 107.0F, 255.5F, 332.0F, 277.5F, fontST7, over1);
			}

//			TextAlign.setSimpleTextLeft(xxfp.getGhdwyhzh(), 107.0F, 242.0F, 332.0F, 262.0F, fontST8, over1);
			if (NumberUtil.StrCount(xxfp.getGhdwyhzh())<226.0F){
				TextAlign.setSimpleTextLeft(xxfp.getGhdwyhzh(), 107.0F, 242.0F, 332.0F, 262.0F, fontST8, over1);
			}else{
				TextAlign.setSimpleTextLeft1(xxfp.getGhdwyhzh(), 107.0F, 242.0F, 332.0F, 262.0F, fontST7, over1);
			}

//			TextAlign.setSimpleTextLeft(xxfp.getXhdwmc(), 107.0F, 83.5F, 332.0F, 103.5F, fontST8, over1);//+3
			if (NumberUtil.StrCount(xxfp.getXhdwmc())<226.0F){
//				TextAlign.setSimpleTextLeft(xxfp.getXhdwmc(), 107.0F, 83.5F, 332.0F, 103.5F, fontST8, over1);//+3
				TextAlign.setSimpleTextLeft(xxfp.getXhdwmc(), 107.0F, 79.0F, 332.0F, 99.0F, fontST8, over1);//-4.5
			}else{
				TextAlign.setSimpleTextLeft1(xxfp.getXhdwmc(), 107.0F, 79.0F, 332.0F, 99.0F, fontST7, over1);//+3
			}

//			TextAlign.setSimpleTextLeft(xxfp.getXhdwsbh(), 107.0F, 69.5F, 332.0F, 89.5F, fontST8, over1);
			if (NumberUtil.StrCount(xxfp.getXhdwsbh())<226.0F){
				TextAlign.setSimpleTextLeft(xxfp.getXhdwsbh(), 107.0F, 65.0F, 332.0F, 85.0F, fontST8, over1);
			}else{
				TextAlign.setSimpleTextLeft1(xxfp.getXhdwsbh(), 107.0F, 65.0F, 332.0F, 85.0F, fontST7, over1);
			}

//			TextAlign.setSimpleTextLeft(xxfp.getXhdwdzdh(), 107.0F, 55.5F, 332.0F, 75.5F, fontST8, over1);
			if (NumberUtil.StrCount(xxfp.getXhdwdzdh())<226.0F){
				TextAlign.setSimpleTextLeft(xxfp.getXhdwdzdh(), 107.0F, 51.0F, 332.0F, 71.0F, fontST8, over1);
			}else{
				TextAlign.setSimpleTextLeft1(xxfp.getXhdwdzdh(), 107.0F, 51.0F, 332.0F, 71.0F, fontST7, over1);
			}

//			TextAlign.setSimpleTextLeft(xxfp.getXhdwyhzh(), 107.0F, 42.5F, 332.0F, 62.5F, fontST8, over1);
			if (NumberUtil.StrCount(xxfp.getXhdwyhzh())<226.0F){
				TextAlign.setSimpleTextLeft(xxfp.getXhdwyhzh(), 107.0F, 38.0F, 332.0F, 58.0F, fontST8, over1);
			}else{
				TextAlign.setSimpleTextLeft1(xxfp.getXhdwyhzh(), 107.0F, 38.0F, 332.0F, 58.0F, fontST7, over1);
			}


		}

		TextAlign.setSimpleTextLeft(xxfp.getSkr(), 66.0F, 18.0F, 148.0F, 38.0F, fontST9, over1);//+3
		TextAlign.setSimpleTextLeft(xxfp.getFhr(), 215.0F, 18.0F, 295.0F, 38.0F, fontST9, over1);
		TextAlign.setSimpleTextLeft(xxfp.getKpr(), 347.0F, 18.0F, 425.0F, 38.0F, fontST9, over1);

		if(xxfp.getKplx().equals("1")) {
			String bz = "对应正数发票代码:"+xxfp.getFpdm()+"号码:"+xxfp.getFphm()+"\r\n";
			TextAlign.setSimpleTextLeft(bz+xxfp.getBz(), 365.0F, 50.0F, 583.0F, 100.0F, fontST9, over1);
		}else {
			TextAlign.setSimpleTextLeft(xxfp.getBz(), 365.0F, 50.0F, 583.0F, 100.0F, fontST9, over1);
		}

		

		// if (qygzUrl != null) {
		// Image img1 = Image.getInstance(qygzUrl);
		// img1.setAlignment(1);
		// img1.scaleAbsolute(128.0F, 90.0F);
		//
		// img1.setAbsolutePosition(30.0F, 10.0F);
		// over.addImage(img1);
		// }

		if ((xxfp.getEwm() != null) && (!"".equals(xxfp.getEwm()))) {
			over1 = over1 == null ? stamp.getOverContent(1) : over1;

			Img2Base64Util.GenerateImage(xxfp.getEwm().trim(), ewmPath);
			System.out.println("Create EWM == success");

			Image qrcodeImage = Image.getInstance(ewmPath);
			qrcodeImage.setAlignment(1);
			qrcodeImage.scaleAbsolute(50.0F, 50.0F);
			qrcodeImage.setAbsolutePosition(30.0F, 334.0F);
			over1.addImage(qrcodeImage);

		}


			for (int k = 0; (k < pages) && (k + 1 <= PDFPages); k++) {
				PdfContentByte over = stamp.getOverContent(1);
				// 生成单张发票
//			if(xxfp.getKplx().equals("0")) {
				if (!isQdfp(xxfp, mxlist)) {
					//零税率标识 合计税额
					int lslbsHjse = 0;
					double hjje = 0.00D;
					double hjse = 0.00D;
					DecimalFormat myformat = new DecimalFormat("#####0.00");

					int lineTop = 12;
					for (int i = 0; i < 10; i++) {
						int c_rownum = k * 10 + i;
						if (count <= c_rownum) {
							break;
						}
						Xxfpmx mx = (Xxfpmx) mxlist.get(c_rownum);
//						setSimpleText(Integer.toString(i + 1), 25.0F, 215 - i * lineTop, 58.0F, 235 - i * lineTop, font,
//								over);

						//矩形长度 142.0F
//						TextAlign.setSimpleTextLeft(mx.getSpmc(), 25.0F, 215 - i * lineTop, 167.0F, 235 - i * lineTop, fontST7, over);

						if (NumberUtil.StrCount(mx.getSpmc())<142.0F){
							TextAlign.setSimpleTextLeft(mx.getSpmc(), 27.0F, 215 - i * lineTop, 167.0F, 235 - i * lineTop, fontST7, over);
						}else{
							TextAlign.setSimpleTextLeft2(mx.getSpmc(), 27.0F, 215 - i * lineTop, 167.0F, 235 - i * lineTop, fontST6, over);
						}


						if(mx.getFphxz().equals("1")){
						} else {
//							TextAlign.setSimpleTextLeft(mx.getGgxh(), 176.0F, 215 - i * lineTop, 220.0F, 235 - i * lineTop, fontST7, over);
							if (NumberUtil.StrCount(mx.getGgxh())<44.0F){
								TextAlign.setSimpleTextLeft(mx.getGgxh(), 176.0F, 215 - i * lineTop, 220.0F, 235 - i * lineTop, fontST7, over);
							}else{
								TextAlign.setSimpleTextLeft1(mx.getGgxh(), 176.0F, 215 - i * lineTop , 220.0F, 235 - i * lineTop, fontST5, over);
							}
						}

						if(mx.getFphxz().equals("1")){
						} else {
							TextAlign.setSimpleTextRigth(mx.getDw(), 212.0F, 215 - i * lineTop, 252.0F, 235 - i * lineTop, fontST7, over);

						}

						if(mx.getFphxz().equals("1")){
						} else {
							TextAlign.setSimpleTextRigth(mx.getSpsl(), 252.0F, 215 - i * lineTop, 319.0F, 235 - i * lineTop, fontST7, over);
						}
						TextAlign.setSimpleTextRigth(mx.getDj(), 317.0F, 215 - i * lineTop,
								389.0F, 235 - i * lineTop, fontST7, over);

						TextAlign.setSimpleTextRigth(NumberUtil.formatToNumber(new BigDecimal(mx.getJe())), 387.0F, 215 - i * lineTop,
								476.0F, 235 - i * lineTop, fontST7, over);

						//判断是否是收购发票
						if(xxfp.getTspz().equals("02")) {
							TextAlign.setSimpleTextRigth("免税", 469.0F, 215 - i * lineTop, 500.0F, 235 - i * lineTop, fontST7, over);
						} else {
							//零税率标识 	1:免税 2：不征税 3：普通零税率 0%
							String slv = null;
							if (mx.getLslbs().equals("1")) {
								slv = "免税";
								TextAlign.setSimpleTextRigth(slv, 475.0F, 215 - i * lineTop, 502.0F, 235 - i * lineTop, fontST5, over);
							} else if(mx.getLslbs().equals("2")){
								slv = "不征税";
								TextAlign.setSimpleTextRigth(slv, 475.0F, 215 - i * lineTop, 502.0F, 235 - i * lineTop, fontST5, over);
							} else {
								// 空代表正常税率
								slv = (Double.parseDouble(mx.getSl()) * 100.0D + "%").replace(".0", "");
								TextAlign.setSimpleTextRigth(slv, 475.0F, 215 - i * lineTop, 502.0F, 235 - i * lineTop, fontST7, over);

							}
						}

						//判断是否是收购发票
						if(xxfp.getTspz().equals("02")) {
							TextAlign.setSimpleTextRigth("***", 493.0F, 215 - i * lineTop,
									590.0F, 235 - i * lineTop, fontST7, over);
						} else{
							if (mx.getLslbs().equals("1")) {
								TextAlign.setSimpleTextRigth("***", 493.0F, 215 - i * lineTop,
										590.0F, 235 - i * lineTop, fontST7, over);
							} else if(mx.getLslbs().equals("2")){
								TextAlign.setSimpleTextRigth("***", 493.0F, 215 - i * lineTop,
										590.0F, 235 - i * lineTop, fontST7, over);
							} else {
								// 空代表正常税率
								TextAlign.setSimpleTextRigth(NumberUtil.formatToNumber(new BigDecimal(mx.getSe())), 493.0F, 215 - i * lineTop,
										590.0F, 235 - i * lineTop, fontST7, over);
							}
//							TextAlign.setSimpleTextRigth(NumberUtil.formatToNumber(new BigDecimal(mx.getSe())), 493.0F, 215 - i * lineTop,
//								590.0F, 235 - i * lineTop, fontST7, over);
						}

						hjse += Double.parseDouble(mx.getSe());
						hjje += Double.parseDouble(mx.getJe());

						if (mx.getLslbs().equals("1")) {
							lslbsHjse ++;
						} else if(mx.getLslbs().equals("2")){
							lslbsHjse ++;
						} else {
							// 空代表正常税率
//							lslbsHjse = 0;
						}
//						lslbsHjse++;
					}

					TextAlign.setSimpleTextRigth("￥" + myformat.format(hjje), 387.0F, 114, 476.0F, 138, fontST8, over);
					//判断是否是收购发票
					if(xxfp.getTspz().equals("02")) {
						TextAlign.setSimpleTextRigth("***", 493.0F, 114, 590.0F, 138, fontST8, over);
					} else{
						if (lslbsHjse != 0) {
							TextAlign.setSimpleTextRigth("***", 493.0F, 114, 590.0F, 138, fontST8, over);
						} else {
							TextAlign.setSimpleTextRigth("￥" + myformat.format(hjse), 493.0F, 114, 590.0F, 138, fontST8, over);
						}
					}

					String jshj = myformat.format(hjse + hjje);
					String jsdx = NumberToCN.number2CNMontrayUnit(jshj);
					TextAlign.setSimpleTextLeft(jsdx, 192.0F, 110.5F, 420.0F, 118.5F, fontST10, over);
					TextAlign.setSimpleTextRigth("￥" + jshj, 493.0F, 110.5F, 590.0F, 118.5F, fontHT10, over);
				}
			}

			
			
				
			
			// 生成带有清单发票
			// count: 30 pages: 1 PDFPages: 2
			// count: 31 pages: 2 PDFPages: 3
			
				
			
			if (isQdfp(xxfp, mxlist)) {

				//零税率标识 合计税额
				int lslbsHjsenQd = 0;
				double hjje1 = 0.00D;
				double hjse1 = 0.00D;
				DecimalFormat myformat = new DecimalFormat("#####0.00");
				//判断是否正负发票  
				if(xxfp.getKplx().equals("0")) {
				for (int j = 0; (j < pages) && (j + 1 <= PDFPages); j++) {
					// 循环打印 6处
					PdfContentByte over2 = stamp.getOverContent(j + 2);
					// 第二页以后每页的内容
					TextAlign.setSimpleTextLeft(xxfp.getGhdwmc(), 95.0F, 697.5F, 300.0F, 717.5F, fontST9, over2);
					TextAlign.setSimpleTextLeft(xxfp.getXhdwmc(), 95.0F, 674.5F, 300.0F, 694.5F, fontST9, over2);
					TextAlign.setSimpleTextLeft(xxfp.getFpdm(), 170.0F, 651.5F, 255.0F, 671.5F, fontST11, over2);
					TextAlign.setSimpleTextLeft(xxfp.getFphm(), 290.0F, 651.5F, 345.0F, 671.5F, fontST11, over2);
//					if(xxfp.getKplx().equals("1")) {
//						String bz = "对应正数发票代码:"+xxfp.getFpdm()+"号码:"+xxfp.getFphm()+"\r\n";
//						TextAlign.setSimpleTextLeft(bz+xxfp.getBz(), 52.0F, 151.0F, 596.0F, 181.0F, fontST8, over2);
//					}else {
						TextAlign.setSimpleTextLeft(xxfp.getBz(), 52.0F, 151.0F, 596.0F, 181.0F, fontST8, over2);
//					}
					String qdKprq = xxfp.getKprq().substring(0, 4) + "   " + xxfp.getKprq().substring(4, 6) + "   "
							+ xxfp.getKprq().substring(6, 8);
					TextAlign.setSimpleTextLeft(qdKprq, 445.0F, 123.0F, 600.0F, 134.0F, fontST8, over2);
					// 第几页，共几页
					TextAlign.setSimpleTextCenter(Integer.toString(pages), 462.0F, 651.5F, 472.0F, 671.5F, fontST11, over2);
					TextAlign.setSimpleTextCenter(Integer.toString(j + 1), 520.0F, 651.5F, 540.0F, 671.5F, fontST11, over2);

					if ((gif != null) && (!"".equals(gif))) {
						//签章图片
						Image image = Image.getInstance(gif);
						image.setAlignment(1);
						image.scaleAbsolute(108.0F, 75.0F);
						image.setAbsolutePosition(85.0F, 74.0F);
						over2.addImage(image);
					}
					
					int a = (j + 1) * 30 - 30;
					int b = (j + 1) * 30;

					double hjje = 0.00D;
					double hjse = 0.00D;

					int lineTop = 14;
					for (int i = a; i < b; i++) {
						int c_rownum = i;
						if (count <= c_rownum) {
							break;
						}
						Xxfpmx mx = (Xxfpmx) mxlist.get(c_rownum);

						TextAlign.setSimpleTextCenter(Integer.toString(i + 1), 34.0F, 605 - (i - j * 30) * lineTop, 45.0F,
								625 - (i - j * 30) * lineTop, fontST8, over2);

						//	fontST8 = 144.0		fontST7 = 168.0

						if (NumberUtil.StrCount(mx.getSpmc())<145.0F){
							TextAlign.setSimpleTextLeft1(mx.getSpmc(), 58.0F, 605 - (i - j * 30) * lineTop, 208.0F,
									625 - (i - j * 30) * lineTop, fontST8, over2);
						}else{
							TextAlign.setSimpleTextLeft1(mx.getSpmc(), 58.0F, 605 - (i - j * 30) * lineTop, 208.0F,
									625 - (i - j * 30) * lineTop, fontST7, over2);
						}

						if(mx.getFphxz().equals("1")){
							//空
						} else {
//							TextAlign.setSimpleTextLeft(mx.getGgxh(), 210.0F, 605 - (i - j * 30) * lineTop, 260.0F,
//									625 - (i - j * 30) * lineTop, fontST8, over2);

							if (NumberUtil.StrCount(mx.getGgxh())<44.0F){
								TextAlign.setSimpleTextLeft(mx.getGgxh(), 210.0F, 605 - (i - j * 30) * lineTop, 260.0F,
										625 - (i - j * 30) * lineTop, fontST8, over2);
							}else{
//								TextAlign.setSimpleTextLeft1(mx.getGgxh(), 176.0F, 215 - i * lineTop , 220.0F, 235 - i * lineTop, fontST5, over2);
								TextAlign.setSimpleTextLeft1(mx.getGgxh(), 210.0F, 605 - (i - j * 30) * lineTop, 260.0F,
										625 - (i - j * 30) * lineTop, fontST6, over2);
							}
						}

						if(mx.getFphxz().equals("1")){
							//空
						} else {
							TextAlign.setSimpleTextRigth(mx.getDw(), 261.0F, 605 - (i - j * 30) * lineTop, 289.0F,
									625 - (i - j * 30) * lineTop, fontST8, over2);
						}

						if(mx.getFphxz().equals("1")){
							//空
						} else {
							TextAlign.setSimpleTextRigth(mx.getSpsl(), 291.0F, 605 - (i - j * 30) * lineTop, 346.0F,
									625 - (i - j * 30) * lineTop, fontST8, over2);
						}

						if(mx.getFphxz().equals("1")){
							//空
						} else {
							TextAlign.setSimpleTextRigth(mx.getDj(), 351.0F,
								605 - (i - j * 30) * lineTop, 403.0F, 625 - (i - j * 30) * lineTop, fontST8, over2);
						}

						TextAlign.setSimpleTextRigth(NumberUtil.formatToNumber(new BigDecimal(mx.getJe())), 407.0F,
								605 - (i - j * 30) * lineTop, 470.0F, 625 - (i - j * 30) * lineTop, fontST8, over2);


						//判断是否是收购发票
						if(xxfp.getTspz().equals("02")) {
//							TextAlign.setSimpleTextRigth("免税", 469.0F, 215 - i * lineTop, 500.0F, 235 - i * lineTop, fontST7, over2);
							TextAlign.setSimpleTextRigth("免税", 474.0F, 605 - (i - j * 30) * lineTop, 495.0F, 625 - (i - j * 30) * lineTop,
									fontST8, over2);
						} else {
							//零税率标识 	1:免税 2：不征税 3：普通零税率 0%
							String slv = null;
							if (mx.getLslbs().equals("1")) {
								slv = "免税";
								TextAlign.setSimpleTextRigth(slv, 474.0F, 605 - (i - j * 30) * lineTop, 495.0F, 625 - (i - j * 30) * lineTop,
										fontST8, over2);
							} else if(mx.getLslbs().equals("2")){
								slv = "不征税";
								TextAlign.setSimpleTextRigth(slv, 474.0F, 605 - (i - j * 30) * lineTop, 495.0F, 625 - (i - j * 30) * lineTop,
										fontST8, over2);
							} else {
								// 空代表正常税率
								slv = (Double.parseDouble(mx.getSl()) * 100.0D + "%").replace(".0", "");
								TextAlign.setSimpleTextRigth(slv, 474.0F, 605 - (i - j * 30) * lineTop, 495.0F, 625 - (i - j * 30) * lineTop,
										fontST8, over2);

							}
						}

//						String slv = (Double.parseDouble(mx.getSl()) * 100.0D + "%").replace(".0", "");
//						TextAlign.setSimpleTextRigth(slv, 474.0F, 605 - (i - j * 30) * lineTop, 495.0F, 625 - (i - j * 30) * lineTop,
//								fontST8, over2);

						//判断是否是收购发票
						if(xxfp.getTspz().equals("02")) {
							TextAlign.setSimpleTextRigth("***", 498.0F,
									605 - (i - j * 30) * lineTop, 565.0F, 625 - (i - j * 30) * lineTop, fontST8, over2);
						} else{
							if (mx.getLslbs().equals("1")) {
								TextAlign.setSimpleTextRigth("***", 498.0F,
										605 - (i - j * 30) * lineTop, 565.0F, 625 - (i - j * 30) * lineTop, fontST8, over2);
							} else if(mx.getLslbs().equals("2")){
								TextAlign.setSimpleTextRigth("***", 498.0F,
										605 - (i - j * 30) * lineTop, 565.0F, 625 - (i - j * 30) * lineTop, fontST8, over2);
							} else {
								// 空代表正常税率
								TextAlign.setSimpleTextRigth(NumberUtil.formatToNumber(new BigDecimal(mx.getSe())), 498.0F,
										605 - (i - j * 30) * lineTop, 565.0F, 625 - (i - j * 30) * lineTop, fontST8, over2);
							}
//							TextAlign.setSimpleTextRigth(NumberUtil.formatToNumber(new BigDecimal(mx.getSe())), 498.0F,
//								605 - (i - j * 30) * lineTop, 565.0F, 625 - (i - j * 30) * lineTop, fontST8, over2);
						}

						hjse += Double.parseDouble(mx.getSe());
						hjje += Double.parseDouble(mx.getJe());
						if (mx.getLslbs().equals("1")) {
							lslbsHjsenQd ++;
						} else if(mx.getLslbs().equals("2")){
							lslbsHjsenQd ++;
						} else {
							// 空代表正常税率
//							lslbsHjsenQd = 0;
						}
//						lslbsHjsenQd++;
					}

					TextAlign.setSimpleTextRigth("￥" + myformat.format(hjje), 407.0F, 186.0F, 470.0F, 206.0F, fontST10, over2);
					TextAlign.setSimpleTextRigth("￥" + myformat.format(hjje), 407.0F, 175.0F, 470.0F, 195.0F, fontST10, over2);
//					TextAlign.setSimpleTextRigth("￥" + myformat.format(hjse), 498.0F, 186.0F, 565.0F, 206.0F, fontST10, over2);
//					TextAlign.setSimpleTextRigth("￥" + myformat.format(hjse), 498.0F, 175.0F, 565.0F, 195.0F, fontST10, over2);

					//判断是否是收购发票
					if(xxfp.getTspz().equals("02")) {
						TextAlign.setSimpleTextRigth("***", 498.0F, 186.0F, 565.0F, 206.0F, fontST10, over2);
					} else{
						if (lslbsHjsenQd != 0) {
							TextAlign.setSimpleTextRigth("***", 498.0F, 186.0F, 565.0F, 206.0F, fontST10, over2);
							TextAlign.setSimpleTextRigth("***", 498.0F, 175.0F, 565.0F, 195.0F, fontST10, over2);
						} else {
							TextAlign.setSimpleTextRigth("￥" + myformat.format(hjse), 498.0F, 186.0F, 565.0F, 206.0F, fontST10, over2);
							TextAlign.setSimpleTextRigth("￥" + myformat.format(hjse), 498.0F, 175.0F, 565.0F, 195.0F, fontST10, over2);
						}
					}

					hjje1 += hjje;
					hjse1 += hjse;
				}
				// 第一页内容
				PdfContentByte over = stamp.getOverContent(1);
				TextAlign.setSimpleTextLeft("（详见销货清单）", 45.0F, 215.0F, 206.0F, 235.0F, fontST7, over);
				TextAlign.setSimpleTextRigth(myformat.format(hjje1), 385.0F, 215, 466.0F, 235, fontST7, over);
				TextAlign.setSimpleTextRigth(myformat.format(hjse1), 493.0F, 215, 575.0F, 235, fontST7, over);

				TextAlign.setSimpleTextRigth("￥" + myformat.format(hjje1), 385.0F, 114, 466.0F, 138.0F, fontST8, over);
				TextAlign.setSimpleTextRigth("￥" + myformat.format(hjse1), 493.0F, 114, 575.0F, 138.0F, fontST8, over);

				String jshj = myformat.format(hjse1 + hjje1);
				String jsdx = NumberToCN.number2CNMontrayUnit(jshj);
				TextAlign.setSimpleTextLeft(jsdx, 192.0F, 108.5F, 420.0F, 121.5F, fontST10, over);
				TextAlign.setSimpleTextRigth("￥" + jshj, 470.0F, 106.5F, 575.0F, 121.5F, fontHT10, over);
				}else {
					double hjje = 0.00D;
					double hjse = 0.00D;
					for (int j = 0; (j < pages) && (j + 1 <= PDFPages); j++) {
						int a = (j + 1) * 30 - 30;
						int b = (j + 1) * 30;
						for (int i = a; i < b; i++) {
							int c_rownum = i;
							if (count <= c_rownum) {
								break;
							}
							Xxfpmx mx = (Xxfpmx) mxlist.get(c_rownum);
							hjse += Double.parseDouble(mx.getSe());
							hjje += Double.parseDouble(mx.getJe());
						}
						hjje1 += hjje;
						hjse1 += hjse;
					}
					
					PdfContentByte over = stamp.getOverContent(1);
					TextAlign.setSimpleTextLeft("（详见销货清单）", 45.0F, 215.0F, 206.0F, 235.0F, fontST7, over);
					TextAlign.setSimpleTextRigth(myformat.format(-hjje1), 385.0F, 215, 466.0F, 235, fontST7, over);
					TextAlign.setSimpleTextRigth(myformat.format(-hjse1), 493.0F, 215, 575.0F, 235, fontST7, over);
					
					TextAlign.setSimpleTextRigth("￥" + myformat.format(-hjje1), 385.0F, 114, 466.0F, 138.0F, fontST8, over);
					TextAlign.setSimpleTextRigth("￥" + myformat.format(-hjse1), 493.0F, 114, 575.0F, 138.0F, fontST8, over);
					
					String jshj = myformat.format(-hjse1 + (-hjje1));
					String jsdx = NumberToCN.number2CNMontrayUnit(jshj);
					TextAlign.setSimpleTextLeft(jsdx, 192.0F, 108.5F, 420.0F, 121.5F, fontST10, over);
					TextAlign.setSimpleTextRigth("￥" + jshj, 470.0F, 106.5F, 575.0F, 121.5F, fontHT10, over);
				}
			}
		stamp.close();
		reader.close();
		tempFile.close();
	}

	/**
	 * @param xxfp
	 *            商品发票
	 * @param xxfpmx
	 *            商品明细发票
	 * @param fpmbPath
	 *            创建临时生成PDF路径
	 * @return
	 * @throws IOException
	 */
	private static String handleTempalteSpfp(Xxfp xxfp, List<Xxfpmx> xxfpmx, String fpmbPath) {
		
			if (!isQdfp(xxfp, xxfpmx)) {
				int pages = 0;
//				String tempPdf = ("E:\\PDFFileTest\\Jiangsu.pdf");
				String tempPdf = tmpPath;
				CreatePdfServiceImlpTest.handleTempalteNew(tempPdf, fpmbPath, pages);
				return tempPdf;
			} else {
				//判断是否正负发票  
				if(xxfp.getKplx().equals("0")) {
					int count = xxfpmx == null ? 0 : xxfpmx.size();
					int pages = count / 30 + (count % 30 == 0 ? 0 : 1);
					// String tempPdf = ("E:\\PDFFileTest" + File.separator + CommonUtils.getUUID()
					// + ".pdf");
//					String tempPdf = ("E:\\PDFFileTest" + File.separator + "Jiangsu.pdf");
					String tempPdf = tmpPath;

					CreatePdfServiceImlpTest.handleTempalteNew(tempPdf, fpmbPath, pages);
					return tempPdf;
				}else {
					int pages = 0;
//					String tempPdf = ("E:\\PDFFileTest\\Jiangsu.pdf");
					String tempPdf = tmpPath;
					CreatePdfServiceImlpTest.handleTempalteNew(tempPdf, fpmbPath, pages);
					return tempPdf;
				}
				
			}
		
	}

	/**
	 * @param tempPdf
	 *            模板PDF路径
	 * @param fpmbPath
	 *            输出PDF路径
	 * @param pages
	 *            页面张数
	 */
	private static void handleTempalteNew(String tempPdf, String fpmbPath, int pages) {
		File file = new File(tempPdf);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try {
			FileOutputStream os = new FileOutputStream(file);
			PdfReader pdfReader = null;
			pdfReader = new PdfReader(fpmbPath);
			Document document = new Document(pdfReader.getPageSize(1));
			PdfCopy copy = new PdfCopy(document, os);
			document.open();
			for (int i = 0; i < pages + 1; i++) {
				PdfReader reader = null;
				if (i == 0)
					reader = new PdfReader(fpmbPath);
				else {
					reader = new PdfReader(qdmbPath);
				}
				document.newPage();
				PdfImportedPage page = copy.getImportedPage(reader, 1);
				copy.addPage(page);
				reader.close();
			}
			document.close();
			pdfReader.close();
			os.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	static long randomTime = System.currentTimeMillis();
	static String qdmbPath = ("E:\\PDFFileTest" + File.separator + "qd(1).pdf");
	static  String password = "111111";
	static  String pfx = "E:\\PDFFileTest\\1.pfx";
	static  String gif = "E:\\PDFFileTest\\1.gif";
	static String tempPdf1 = ("E:\\PDFFileTest" + File.separator + CommonUtils.getUUID()
			+ ".pdf");
	static String expPath1 = "E:\\aaaa" + File.separator + randomTime + ".pdf";

	static String ewmPath = "E:\\aaaa" + File.separator + randomTime + "发票.jpg";
	static String tmpPath = "E:\\aaaa\\Jiangsu.pdf";

	public static void main(String[] args) throws IOException, DocumentException {

//		long randomTime = System.currentTimeMillis();
		// String tempPdf = ("E:\\PDFFileTest" + File.separator + CommonUtils.getUUID()
		// + ".pdf");
//		String expPath = "E:\\PDFFileTest" + File.separator + randomTime + ".pdf";
//		String expPath = tempPdf1;
//		String expPath = "E:\\PDFFileTest" + File.separator +  "h30.pdf";

		Xxfp fp = new Xxfp();
		// Ticket ticket = new Ticket();
		
		fp.setKplx("0");	//0:为正票  1:为负票
		fp.setTspz("00");	//“00”不是  “01”农产品销售   “02”农产品收购   “06”抵扣通行费
		fp.setFpdm("150003529999");
		fp.setFphm("95715993");
		fp.setKprq("20161125105100");
		fp.setJqbh("499111004317");
		fp.setJym("15790161104984466735");
		fp.setSkm(
				"039<*9//9-684*</22*>5042493-*21468>37716><46+>797<47234>--/665**<*4>*9/24/37-+<<959</146826-<50134791945-3890247");
//		fp.setGhdwmc("中国人寿保险股份有限公司无锡市分公司中国人寿保险股份有限公司无锡市分公司");
		fp.setGhdwmc("中国人寿保险股份有限公司无锡市分公司中国人寿保险股份有是有限公司有限公司保险");
//		fp.setGhdwsbh("9132020083600110X7");
		fp.setGhdwsbh("中国人寿保险股份有限公司无锡市分公司中国人寿保险股份有是有限公司有限公司保险");
		fp.setGhdwdzdh("无锡梁青路4号  0510-87905747");
		fp.setGhdwyhzh("中国工商银行无锡市分行营业部  1103020209200541791");

		fp.setXhdwmc("江苏百旺金赋信息科技有限公司");
		fp.setXhdwsbh("91320106598035469W");
		fp.setXhdwdzdh("城市区人民中路188号飞驰新天地广场2幢1801室0515");
		fp.setXhdwyhzh("中国建设银行迎宾支行32050173513609916688");

		fp.setKpr("开票人张三");
		fp.setSkr("收款人张三");
		fp.setFhr("复核人张三");
		fp.setBz("上海绿岛-多层-10栋-66单元-802;系统服务费,面积142.77,单价2.0000,20200101-20200331;物业管理费,面积142.77,单价2.8000,20200101-2020");

		List mxlist = new ArrayList();
		Xxfpmx mx = new Xxfpmx();
		mx.setFphxz("0");	// 发票行性质 0正常行、1折扣行、2被折扣行
//		mx.setSpmc("阿裕食品桂花园子克阿裕食品桂花阿裕食品桂花园子200");
		mx.setSpmc("税控盘1");
		mx.setSpsm("");
		mx.setGgxh("MA-B12-IF-044-B12-IF ");
		mx.setDw("袋");
		mx.setSpsl("1");
		mx.setDj("1300.01");
		mx.setJe("100.01");
		mx.setSl("0");
		mx.setSe("17");
		mx.setHsbz("");
		mx.setSpbm("1070304060000000000");
		mx.setZxbm("");
		mx.setYhzcbs("");
		mx.setLslbs("");
		mx.setZzstsgl("");
		mxlist.add(mx);

		mx = new Xxfpmx();
		mx.setFphxz("0");	// 发票行性质 0正常行、1折扣行、2被折扣行
		mx.setSpmc("税控盘2");
		mx.setSpsm("");
		mx.setGgxh("MA-B12-IF-044-B12-IF");
		mx.setDw("盒盒");
		mx.setSpsl("111");
		mx.setDj("201");
		mx.setJe("201");
		mx.setSl("0");
		mx.setSe("0");
		mx.setHsbz("");
		mx.setSpbm("1070304060000000001");
		mx.setZxbm("");
		mx.setYhzcbs("");
		mx.setLslbs("");
		mx.setZzstsgl("");
		mxlist.add(mx);

		mx = new Xxfpmx();
		mx.setFphxz("0");	// 发票行性质 0正常行、1折扣行、2被折扣行
		mx.setSpmc("税控盘3");
		mx.setSpsm("食品桂花花");
		mx.setGgxh("MA-B12-IF-044-B12-IF");
		mx.setDw("盒");
		mx.setSpsl("99");
		mx.setDj("-10");
		mx.setJe("-10");
		mx.setSl("0");
		mx.setSe("0");
		mx.setHsbz("");
		mx.setSpbm("1070304060000000002");
		mx.setZxbm("");
		mx.setYhzcbs("");
		mx.setLslbs("");
		mx.setZzstsgl("");
		mxlist.add(mx);


//		mx = new Xxfpmx();
//		mx.setFphxz("1");
//		mx.setSpmc("税控盘2");	// 发票行性质 0正常行、1折扣行、2被折扣行 
//		mx.setSpsm("");
//		mx.setGgxh(" ");
//		mx.setDw(" ");
//		mx.setSpsl(" ");
//		mx.setDj(" ");
//		mx.setJe("-100");
//		mx.setSl("0.15");
//		mx.setSe("1.50");
//		mx.setHsbz("");
//		mx.setSpbm("1070304060000000001");
//		mx.setZxbm("");
//		mx.setYhzcbs("");
//		mx.setLslbs("");
//		mx.setZzstsgl("");
//		mxlist.add(mx);

		mx = new Xxfpmx();
		mx.setFphxz("0");
		mx.setSpmc("税控盘4税控盘4税控盘4");
		mx.setSpsm("");
		mx.setGgxh("花花");
		mx.setDw("盒盒盒");
		mx.setSpsl("1111");
		mx.setDj("2001");
		mx.setJe("2001");
		mx.setSl("0.17");
		mx.setSe("3411");
		mx.setHsbz("");
		mx.setSpbm("1070304060000000003");
		mx.setZxbm("");
		mx.setYhzcbs("");
		mx.setLslbs("");
		mx.setZzstsgl("");
		mxlist.add(mx);

		mx = new Xxfpmx();
		mx.setFphxz("0");
		mx.setSpmc("税控盘5税控盘5税控盘5");
		mx.setSpsm("");
		mx.setGgxh("花花花花");
		mx.setDw("盒盒盒");
		mx.setSpsl("11111");
		mx.setDj("20011.3");
		mx.setJe("20011.3");
		mx.setSl("0.17");
		mx.setSe("31114.1");
		mx.setHsbz("");
		mx.setSpbm("1070304060000000003");
		mx.setZxbm("");
		mx.setYhzcbs("");
		mx.setLslbs("");
		mx.setZzstsgl("");
//		mxlist.add(mx);
//		mxlist.add(mx);
//		mxlist.add(mx);
//		mxlist.add(mx); // 8
		// =======================================
		mxlist.add(mx); // 9
		mxlist.add(mx); // 10
		mxlist.add(mx); // 11
		mxlist.add(mx); // 12
		mxlist.add(mx); // 13
		mxlist.add(mx); // 13
		mxlist.add(mx); // 13
		mxlist.add(mx); // 13
		mxlist.add(mx); // 13
		mxlist.add(mx); // 13
		mxlist.add(mx); // 13
		mxlist.add(mx); // 13
		mxlist.add(mx); // 13
		mxlist.add(mx); // 13
//		mxlist.add(mx); // 13
//		mxlist.add(mx); // 13
//		mxlist.add(mx); // 13
//		mxlist.add(mx); // 13
//		mxlist.add(mx); // 13
//		mxlist.add(mx); // 13
//		mxlist.add(mx); // 13
//		mxlist.add(mx); // 30
		// ====================================================
//		mxlist.add(mx); // 31
//		mxlist.add(mx); // 32
//		mxlist.add(mx); // 33
//		mxlist.add(mx); // 34
//		mxlist.add(mx); // 35
//		mxlist.add(mx); // 30
//		mxlist.add(mx); // 31
//		mxlist.add(mx); // 32
//		mxlist.add(mx); // 33
//		mxlist.add(mx); // 34
//		mxlist.add(mx); // 40
//		mxlist.add(mx); // 30
//		mxlist.add(mx); // 31
//		mxlist.add(mx); // 32
//		mxlist.add(mx); // 33
//		mxlist.add(mx); // 34
//		mxlist.add(mx); // 35
//		mxlist.add(mx); // 30
//		mxlist.add(mx); // 31
//		mxlist.add(mx); // 32
//		mxlist.add(mx); // 33
//		mxlist.add(mx); // 34
//		mxlist.add(mx); // 50
//		mxlist.add(mx); // 30
//		mxlist.add(mx); // 31
//		mxlist.add(mx); // 32
//		mxlist.add(mx); // 33
//		mxlist.add(mx); // 34
//		mxlist.add(mx); // 35
//		mxlist.add(mx); // 30
//		mxlist.add(mx); // 31
//		mxlist.add(mx); // 32
//		mxlist.add(mx); // 33
//		mxlist.add(mx); // 34
//		mxlist.add(mx); // 35
//		mxlist.add(mx); // 30
//		mxlist.add(mx); // 31
//		mxlist.add(mx); // 32
//		mxlist.add(mx); // 33
//		mxlist.add(mx); // 34
//		mxlist.add(mx); // 35
//		mxlist.add(mx); // 30
//		mxlist.add(mx); // 31
//		mxlist.add(mx); // 32
//		mxlist.add(mx); // 33
//		mxlist.add(mx); // 34
//		mxlist.add(mx); // 35
//		mxlist.add(mx); // 30
//		mxlist.add(mx); // 31
//		mxlist.add(mx); // 32
//		mxlist.add(mx); // 33
//		mxlist.add(mx); // 34
//		mxlist.add(mx); // 35
//		mxlist.add(mx); // 30
//		mxlist.add(mx); // 31
//		mxlist.add(mx); // 32
//		mxlist.add(mx); // 33
//		mxlist.add(mx); // 34
//		mxlist.add(mx); // 35
//		mxlist.add(mx); // 90
//		// ===================================
//		mxlist.add(mx); // 91

		// mx.setHwmc("税控盘");
		// mx.setTax("0.17");
		// mx.setSpmc("税控盘");
		// mx.setDw("盒");
		// mx.setGg("");
		// mx.setSl("1");
		// mx.setDj("-10");
		// mx.setJe("-10");
		// mx.setSl("0.17");
		// mx.setSe("1.7");
		// mxlist.add(mx);

		fp.setHjje("80");
		fp.setHjse("20.4");
		fp.setJshj("100.4");
		fp.setEwmPath("http://www.baidu.com");
		fp.setEwm("iVBORw0KGgoAAAANSUhEUgAAAJQAAACUCAIAAAD6XpeDAAAC/UlEQVR42u3cy26DUAwFwPz/T6frLqoK8LENDMuIUPDc6PqB+vkEju+C46/7qbrno9/93OWABw8evJfgJYJ1NKBVGAmkK9dPxBkePHjw4NXgHb3Rqs+v3ENV0K8kI4nFBw8ePHjw7odXdU46uUgU/vDgwYMH7114iZtOBL0zqYEHDx48ePN46c08EaCqBGdD4b9iqgAPHjx4D8arOhIN6yd9vvqABA8evAfjfcPHhnvbMIyNxBYePHjw4J1+rnTQEw3xzkVz5Zx4POHBgwcP3mm8qWNzglMFGWmsw4MHDx68f69flSx0viCUSIgSSUp6QcCDBw8evJr3aNIwVQ82lVAkFk1ZgQ8PHjx48EYazVOJQKJAroIZ+xXCgwcP3svxOpOCDQPYK6v4No1pePDgwYN3Gm9q0+4ckFYFOn0P8YeHBw8evJfgJQakVwLU2cDtHOqW1dnw4MGDB6/keaeK8XQh34nU2UCABw8ePHh9g8rEwLNzKNrZEChL0ODBgwcPXhSvs/Dc0AhOD34v/V148ODBg1eCl37BJrGBVzUEEg36xDnw4MGDB68GL7Fpdzap02CJpvzhvwUPHjx48E7PBasK8wRSZ+IzNfuM/wrhwYMHD155QzlRvN/xpal4YxoePHjw4FXEIf6PczYnMonrJJrg8ODBgwfvfD8zHdB0Q6CqaT716ykrzOHBgwcP3ul5XlUgruy72xoC6cVaNlWABw8ePHgleFWN4A2LY9tQOp6wwIMHDx688oI93WjubBpMNa/Hui3w4MGD90K8sU040EBIL5TOmMCDBw8evGPX3LBRT2346WFporHw63N48ODBg1fyPku6iZxIgtKD5XihHU4S4cGDBw9eNqFIDHsTG3hiwbUmLPDgwYMHLzqMTWzI6WBVFdStGeDUNBwePHjw4I00TxPFctU5iThcKtLhwYMHD94t8NLfTTSFVyRE8ODBgwfvNF7ni0ZTQ9eqZ0/EYcUwFh48ePAejNfZI93Q2N0wcF7X7IYHDx685+L9ACpql2Icyp6DAAAAAElFTkSuQmCC");
//		fp.setEwm();
		long startTime = System.currentTimeMillis(); // 获取开始时间
		createPdf(tmpPath, tempPdf1, null, null, fp, mxlist, true);

		long endTime = System.currentTimeMillis(); // 获取结束时间
		System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); // 输出程序运行时间

		System.out.println("success");
		System.out.println("tempPdf1  :"+tempPdf1);
		System.out.println("expPath1  :"+expPath1);

//		byte[] bytes = Img2Base64Util.fileToByte(expPath1);
//		byte[] bytes1 = CompressionUtil.compress(bytes,Level.BEST_COMPRESSION);
//
//		String ss = bytes1.toString();
//		File file = new File("E:\\onLineData1\\Test2055.txt");
//		FileOutputStream fos = new FileOutputStream(ss);
//		fos.write(bytes1);
//		System.out.println("写入成功");
//		fos.close();


//		FileUtils.printLog(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +"二进制文件流" + "\n\t" + bytes+"\n\t", FilePathConstant.LogFilePath + new SimpleDateFormat("yyyyMMdd").format(new Date())+"two2222.txt");
	}
}