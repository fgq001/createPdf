package com.bwjf.createpdf.service.impl;

import com.bwjf.createpdf.constant.FilePathConstant;
import com.bwjf.createpdf.entity.Xxfp;
import com.bwjf.createpdf.entity.Xxfpmx;
import com.bwjf.createpdf.service.CreatePdfService;
import com.bwjf.createpdf.test.Img2Base64Util;
import com.bwjf.createpdf.utils.*;
import com.itextpdf.text.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Properties;

/**
 * Created by admin on 2019/7/19.
 */

@Service("createPdfService")
public class CreatePdfServiceImpl implements CreatePdfService{


    static long randomTime = System.currentTimeMillis();
//    static String qdmbPath = ("E:\\PDFFileTest" + File.separator + "qd(1).pdf");
    static String ewmPath = FilePathConstant.ewmPath + File.separator + randomTime + "发票.jpg";

    /**
     * 创建PDF
     * @param tmpPath   PDF模板路径
     * @param temPath   生成临时PDF路径
     * @param endPath   最终生成PDF路径
     * @param xxfp      发票信息
     * @param xxfpmxList    发票明细信息
     * @param pfx       pfx文件路径
     * @param gif       印章路径
     * @param password  签章密码
     * @param xmlContent    XML解析内容
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public boolean createPdf(String tmpPath,String temPath,String endPath,Xxfp xxfp,List<Xxfpmx> xxfpmxList, String pfx, String gif, String password, String xmlContent) {
        boolean bo = true;
        try {
        File nf = new File(temPath);
        if (!nf.getParentFile().exists()) {
            nf.getParentFile().mkdirs();
        }
        if (nf.exists()) {
            nf.delete();
        }
//            System.out.println("xxfp.getJym()========"+xxfp.getJym());
//            XMLDomUtils.XmlJx(xmlContent);
            createFp(tmpPath, temPath, endPath, xxfp, xxfpmxList,pfx,gif,password);
        } catch (FileNotFoundException e) {
            bo = false;
            System.err.print("发票pdf(带签章)生成失败,发票代码：" + xxfp.getFpdm() + ",发票号码：" +
                    xxfp.getFphm());
            e.printStackTrace();
        } catch (DocumentException e) {
            bo = false;
            System.err.print("发票pdf(带签章)生成失败,发票代码：" + xxfp.getFpdm() + ",发票号码：" +
                    xxfp.getFphm());
            e.printStackTrace();
        } catch (IOException e) {
            bo = false;
            System.err.print("发票pdf(带签章)生成失败,发票代码：" + xxfp.getFpdm() + ",发票号码：" +
                    xxfp.getFphm());
            e.printStackTrace();
        }
        return bo;
    }


    /**
     * 生成发票
     * @param tmpPath    PDF模板路径
     * @param temPath    生成临时PDF路径
     * @param endPath    最终生成PDF路径
     * @param xxfp       发票信息
     * @param mxlist     发票明细信息
     * @param pfx         pfx文件路径
     * @param gif         gif文件路径
     * @param password    签章密码
     * @throws IOException
     * @throws DocumentException
     */
    @Override
    public void createFp(String tmpPath, String temPath, String endPath, Xxfp xxfp, List<Xxfpmx> mxlist, String pfx, String gif, String password) throws IOException, DocumentException {
        // 读模板PDF路径
        PdfReader reader = new PdfReader(tmpPath);
        // 创建临时生成PDF路径
        String pdfTemp = temPath;	//临时PDF
//        String pdfEnd = endPath;	//最终PDF


        new File(temPath).getParentFile().mkdirs();
        FileOutputStream tempFile = new FileOutputStream(temPath);
        PdfStamper stamp = new PdfStamper(reader, tempFile);
        stamp.setFormFlattening(true);

        stamp.close();
        reader.close();
        tempFile.close();

        pdfTemp = handleTempalteSpfp(xxfp, mxlist, tmpPath, temPath);
        createCommonSpTest(pdfTemp, temPath, xxfp, mxlist,gif);
        SignPDF.sign(pfx, temPath, endPath, gif, password);
    }

    /**
     * 判断明细是否超过8条，是否生成清单发票
     * @param xxfp      发票信息
     * @param mxlist    发票明细信息
     * @return
     */
    @Override
    public boolean isQdfp(Xxfp xxfp, List<Xxfpmx> mxlist) {
        return (xxfp != null) && (mxlist != null) && (mxlist.size() > 8);
    }

    /**
     * 创建临时PDF
     * @param xxfp      发票信息
     * @param xxfpmx    发票明细
     * @param tmpPath   发票模板
     * @param temPath   临时PDF
     * @return
     */
    @Override
    public String handleTempalteSpfp(Xxfp xxfp, List<Xxfpmx> xxfpmx, String tmpPath, String temPath) {
        if (!isQdfp(xxfp, xxfpmx)) {
            int pages = 0;
            String tempPdf = tmpPath;
            handleTempalteNew(tempPdf, temPath, pages);
            return tempPdf;
        } else {
            //判断是否正负发票
            if(xxfp.getKplx().equals("0")) {
                int count = xxfpmx == null ? 0 : xxfpmx.size();
                int pages = count / 30 + (count % 30 == 0 ? 0 : 1);
                // String tempPdf = ("E:\\PDFFileTest" + File.separator + CommonUtils.getUUID()
                // + ".pdf");
                String tempPdf = tmpPath;
                handleTempalteNew(tempPdf, temPath, pages);
                return tempPdf;
            }else {
                int pages = 0;
                String tempPdf = tmpPath;
                handleTempalteNew(tempPdf, temPath, pages);
                return tempPdf;
            }
        }
    }

    /**
     * 根据商品数判断页数，生成带有清单模板的PDF
     * @param tempPdf   PDF模板
     * @param temPath   临时PDF
     * @param pages     页数
     */
    @Override
    public void handleTempalteNew(String tempPdf, String temPath, int pages) {
        File file = new File(tempPdf);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            FileOutputStream os = new FileOutputStream(file);
            PdfReader pdfReader = null;
            pdfReader = new PdfReader(temPath);
            Document document = new Document(pdfReader.getPageSize(1));
            PdfCopy copy = new PdfCopy(document, os);
            document.open();
            for (int i = 0; i < pages + 1; i++) {
                PdfReader reader = null;
                if (i == 0)
                    reader = new PdfReader(temPath);
                else {
                    reader = new PdfReader(FilePathConstant.qdmbPath);
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

    /**
     * 模板内填充数据
     * @param tmpPath   PDF模板
     * @param tempPdf   临时PDF
     * @param xxfp      发票信息
     * @param mxlist    发票明细信息
     * @param gif       印章
     * @throws IOException
     * @throws DocumentException
     */
    @Override
    public void createCommonSpTest(String tmpPath, String tempPdf, Xxfp xxfp, List<Xxfpmx> mxlist, String gif) throws IOException, DocumentException {
        {

            PdfReader reader = new PdfReader(tmpPath);
            FileOutputStream tempFile = new FileOutputStream(tempPdf);
            PdfStamper stamp = new PdfStamper(reader, tempFile);

            int count = mxlist == null ? 0 : mxlist.size();

            // 读取配置文件信息
            Properties prop = new Properties();
            prop.load(this.getClass().getResourceAsStream("/font.properties"));

            // 宋体
            String fontST = prop.getProperty("bwjf.font.st.path");
            //黑体
            String fontHT = prop.getProperty("bwjf.font.ht.path");

            //宋体
//            BaseFont bfChineseST = BaseFont.createFont("src/main/resources/font/simsun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            BaseFont bfChineseST = BaseFont.createFont(fontST, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font fontST11 = new Font(bfChineseST,11.0F);
            Font fontST10 = new Font(bfChineseST,10.0F);
            Font fontST9 = new Font(bfChineseST,9.0F);
            Font fontST8 = new Font(bfChineseST,8.0F);
            Font fontST7 = new Font(bfChineseST,7.0F);
            //黑体
//            BaseFont bfChineseHT = BaseFont.createFont("src/main/resources/font/SIMHEI.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            BaseFont bfChineseHT = BaseFont.createFont(fontHT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font fontHT10 = new Font(bfChineseHT,10.0F);
            Font fontHT14 = new Font(bfChineseHT,14.0F);


            //Courier New 数字
            Font courier12 = FontFactory.getFont(BaseFont.COURIER, BaseFont.WINANSI, 12.0F);
            Font courier11 = FontFactory.getFont(BaseFont.COURIER, BaseFont.WINANSI, 11.0F);
            Font courier10 = FontFactory.getFont(BaseFont.COURIER, BaseFont.WINANSI, 10.0F);
            Font courier8 = FontFactory.getFont(BaseFont.COURIER, BaseFont.WINANSI, 8.0F);

            int pages = count / 30 + (count % 30 == 0 ? 0 : 1);
            int PDFPages = reader.getNumberOfPages();
            // 生成带有清单发票
            // count: 30 pages: 1 PDFPages: 2
            // count: 31 pages: 2 PDFPages: 3

            System.out.println("count:  " + count + "   pages:   " + pages + "   PDFPages:  " + PDFPages);
            // 生成第一页共有内容
            PdfContentByte over1 = stamp.getOverContent(1);


//		setSimpleText(xxfp.getFpdm(), 477.0F, 372.0F, 700.0F, 382.0F, font, over1);
//		setSimpleText(xxfp.getFphm(), 477.0F, 352.0F, 700.0F, 364.0F, font, over1);
            TextAlign.setSimpleTextLeft(xxfp.getFpdm(), 465.0F, 359.0F, 580.0F, 379.0F, courier10, over1);
            TextAlign.setSimpleTextLeft(xxfp.getFphm(), 465.0F, 342.0F, 580.0F, 362.0F, courier10, over1);
//            System.out.println("xxfp.getFphm()= "+xxfp.getFphm()+"xxfp.getFpdm()"+xxfp.getFpdm());
            String kprq = xxfp.getKprq().substring(0, 4) + "  " + xxfp.getKprq().substring(4, 6) + "  "
                    + xxfp.getKprq().substring(6, 8);
            TextAlign.setSimpleTextLeft(kprq, 465.0F, 333.0F, 580.0F, 345.0F, courier10, over1);
            TextAlign.setSimpleTextLeft(NumberUtil.Tostr(xxfp.getJym()), 465.0F, 318.5F, 580.0F, 328.5F, courier8, over1);
            TextAlign.setSimpleTextLeft(xxfp.getJqbh(), 74.0F, 307.0F, 220.0F, 327.0F, courier11, over1);
//            System.out.println("xxfp.getJqbh()= "+xxfp.getJqbh());
            //判断是否正负发票
            if(xxfp.getKplx().equals("1")) {
                TextAlign.setSimpleTextLeft("销项负数", 97.0F, 320.0F, 185.0F, 340.0F, fontHT14, over1);
            }

            String skm1 = xxfp.getSkm().substring(0, 28);
            String skm2 = xxfp.getSkm().substring(28, 56);
            String skm3 = xxfp.getSkm().substring(56, 84);
            String skm4 = xxfp.getSkm().substring(84);

            float lineTop1 = 12.5F;
            TextAlign.setSimpleTextLeft(skm1, 366.0F, 304 - lineTop1 * 1, 580.0F, 316 - lineTop1 * 1, courier12, over1);
            TextAlign.setSimpleTextLeft(skm2, 366.0F, 304 - lineTop1 * 2, 580.0F, 316 - lineTop1 * 2, courier12, over1);
            TextAlign.setSimpleTextLeft(skm3, 366.0F, 304 - lineTop1 * 3, 580.0F, 316 - lineTop1 * 3, courier12, over1);
            TextAlign.setSimpleTextLeft(skm4, 366.0F, 304 - lineTop1 * 4, 580.0F, 316 - lineTop1 * 4, courier12, over1);

            TextAlign.setSimpleTextLeft(xxfp.getGhdwmc(), 107.0F, 287.5F, 324.0F, 307.5F, fontST8, over1);
            TextAlign.setSimpleTextLeft(xxfp.getGhdwsbh(), 107.0F, 272.5F, 324.0F, 292.5F, fontST8, over1);
            TextAlign.setSimpleTextLeft(xxfp.getGhdwdzdh(), 107.0F, 255.5F, 324.0F, 277.5F, fontST8, over1);
            TextAlign.setSimpleTextLeft(xxfp.getGhdwyhzh(), 107.0F, 242.0F, 324.0F, 262.0F, fontST8, over1);

            TextAlign.setSimpleTextLeft(xxfp.getXhdwmc(), 107.0F, 83.5F, 300.0F, 103.5F, fontST8, over1);//+3
            TextAlign.setSimpleTextLeft(xxfp.getXhdwsbh(), 107.0F, 69.5F, 300.0F, 89.5F, fontST8, over1);
            TextAlign.setSimpleTextLeft(xxfp.getXhdwdzdh(), 107.0F, 55.5F, 300.0F, 75.5F, fontST8, over1);
            TextAlign.setSimpleTextLeft(xxfp.getXhdwyhzh(), 107.0F, 42.5F, 300.0F, 62.5F, fontST8, over1);

            TextAlign.setSimpleTextLeft(xxfp.getSkr(), 68.0F, 23.0F, 148.0F, 43.0F, fontST9, over1);//+3
            TextAlign.setSimpleTextLeft(xxfp.getFhr(), 215.0F, 23.0F, 295.0F, 43.0F, fontST9, over1);
            TextAlign.setSimpleTextLeft(xxfp.getKpr(), 345.0F, 23.0F, 425.0F, 43.0F, fontST9, over1);
            TextAlign.setSimpleTextLeft(xxfp.getBz(), 355.0F, 50.0F, 578.0F, 105.0F, fontST9, over1);



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

                        // String spbmJc = basSpbmDao.getSpbmJcByBm(mx.getBasSpbmBm() == null ? "" :
                        // mx.getBasSpbmBm());
                        String spbmJc = ("1030299000000000000");
                        if ((!"".equals(spbmJc)) && (spbmJc != null))
                            spbmJc = "*" + spbmJc + "*";
                        else {
                            spbmJc = "";
                        }

                        TextAlign.setSimpleTextLeft(mx.getSpmc(), 25.0F, 215 - i * lineTop, 167.0F, 235 - i * lineTop, fontST7, over);

                        TextAlign.setSimpleTextLeft(mx.getGgxh(), 174.0F, 215 - i * lineTop, 205.0F, 235 - i * lineTop, fontST7, over);

                        TextAlign.setSimpleTextRigth(mx.getDw(), 210.0F, 215 - i * lineTop, 246.0F, 235 - i * lineTop, fontST7, over);

                        TextAlign.setSimpleTextRigth(mx.getSpsl(), 250.0F, 215 - i * lineTop, 310.0F, 235 - i * lineTop, fontST7, over);

                        TextAlign.setSimpleTextRigth(NumberUtil.formatToNumber(new BigDecimal(mx.getDj())), 315.0F, 215 - i * lineTop,
                                380.0F, 235 - i * lineTop, fontST7, over);

                        TextAlign.setSimpleTextRigth(NumberUtil.formatToNumber(new BigDecimal(mx.getJe())), 385.0F, 215 - i * lineTop,
                                466.0F, 235 - i * lineTop, fontST7, over);

                        String slv = (Double.parseDouble(mx.getSl()) * 100.0D + "%").replace(".0", "");
                        TextAlign.setSimpleTextRigth(slv, 468.0F, 215 - i * lineTop, 490.0F, 235 - i * lineTop, fontST7, over);

                        TextAlign.setSimpleTextRigth(NumberUtil.formatToNumber(new BigDecimal(mx.getSe())), 493.0F, 215 - i * lineTop,
                                575.0F, 235 - i * lineTop, fontST7, over);

                        hjse += Double.parseDouble(mx.getSe());
                        hjje += Double.parseDouble(mx.getJe());

                    }
                    TextAlign.setSimpleTextRigth("￥" + myformat.format(hjje), 385.0F, 114, 466.0F, 138, fontST8, over);
                    TextAlign.setSimpleTextRigth("￥" + myformat.format(hjse), 493.0F, 114, 575.0F, 138, fontST8, over);

                    String jshj = myformat.format(hjse + hjje);
                    String jsdx = NumberToCN.number2CNMontrayUnit(jshj);
                    TextAlign.setSimpleTextLeft(jsdx, 192.0F, 108.5F, 420.0F, 121.5F, fontST10, over);
                    TextAlign.setSimpleTextRigth("￥" + jshj, 470.0F, 106.5F, 575.0F, 121.5F, fontHT10, over);
                }
            }





            // 生成带有清单发票
            // count: 30 pages: 1 PDFPages: 2
            // count: 31 pages: 2 PDFPages: 3



            if (isQdfp(xxfp, mxlist)) {


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
                        TextAlign.setSimpleTextLeft(xxfp.getBz(), 52.0F, 151.0F, 596.0F, 181.0F, fontST8, over2);
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

                            // String spbmJc = basSpbmDao.getSpbmJcByBm(mx.getBasSpbmBm() == null ? "" :
                            // mx.getBasSpbmBm());
                            String spbmJc = ("1030299000000000000");
                            if ((!"".equals(spbmJc)) && (spbmJc != null))
                                spbmJc = "*" + spbmJc + "*";
                            else {
                                spbmJc = "";
                            }

                            TextAlign.setSimpleTextLeft(mx.getSpmc(), 58.0F, 605 - (i - j * 30) * lineTop, 200.0F,
                                    625 - (i - j * 30) * lineTop, fontST8, over2);

                            TextAlign.setSimpleTextLeft(mx.getGgxh(), 210.0F, 605 - (i - j * 30) * lineTop, 260.0F,
                                    625 - (i - j * 30) * lineTop, fontST8, over2);

                            TextAlign.setSimpleTextRigth(mx.getDw(), 261.0F, 605 - (i - j * 30) * lineTop, 289.0F,
                                    625 - (i - j * 30) * lineTop, fontST8, over2);

                            TextAlign.setSimpleTextRigth(mx.getSpsl(), 291.0F, 605 - (i - j * 30) * lineTop, 346.0F,
                                    625 - (i - j * 30) * lineTop, fontST8, over2);

                            TextAlign.setSimpleTextRigth(NumberUtil.formatToNumber(new BigDecimal(mx.getDj())), 351.0F,
                                    605 - (i - j * 30) * lineTop, 403.0F, 625 - (i - j * 30) * lineTop, fontST8, over2);

                            TextAlign.setSimpleTextRigth(NumberUtil.formatToNumber(new BigDecimal(mx.getJe())), 407.0F,
                                    605 - (i - j * 30) * lineTop, 470.0F, 625 - (i - j * 30) * lineTop, fontST8, over2);

                            String slv = (Double.parseDouble(mx.getSl()) * 100.0D + "%").replace(".0", "");
                            TextAlign.setSimpleTextRigth(slv, 474.0F, 605 - (i - j * 30) * lineTop, 495.0F, 625 - (i - j * 30) * lineTop,
                                    fontST8, over2);

                            TextAlign.setSimpleTextRigth(NumberUtil.formatToNumber(new BigDecimal(mx.getSe())), 498.0F,
                                    605 - (i - j * 30) * lineTop, 565.0F, 625 - (i - j * 30) * lineTop, fontST8, over2);

                            hjse += Double.parseDouble(mx.getSe());
                            hjje += Double.parseDouble(mx.getJe());

                        }
                        TextAlign.setSimpleTextRigth("￥" + myformat.format(hjje), 407.0F, 186.0F, 470.0F, 206.0F, fontST10, over2);
                        TextAlign.setSimpleTextRigth("￥" + myformat.format(hjje), 407.0F, 175.0F, 470.0F, 195.0F, fontST10, over2);
                        TextAlign.setSimpleTextRigth("￥" + myformat.format(hjse), 498.0F, 186.0F, 565.0F, 206.0F, fontST10, over2);
                        TextAlign.setSimpleTextRigth("￥" + myformat.format(hjse), 498.0F, 175.0F, 565.0F, 195.0F, fontST10, over2);

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
    }

}
