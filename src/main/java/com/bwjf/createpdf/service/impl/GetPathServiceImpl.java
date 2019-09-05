package com.bwjf.createpdf.service.impl;

import com.bwjf.createpdf.constant.FilePathConstant;
import com.bwjf.createpdf.constant.InvoiceConstant;
import com.bwjf.createpdf.dao.GetPathDao;
import com.bwjf.createpdf.entity.KpCacersubInfo;
import com.bwjf.createpdf.entity.TcrmPdftemplateBean;
import com.bwjf.createpdf.entity.Xxfp;
import com.bwjf.createpdf.service.GetPathService;
import com.bwjf.createpdf.utils.EWMbase64util;
import com.bwjf.createpdf.utils.FileUtils;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2019/7/22.
 */
@Service("getPathService")
public class GetPathServiceImpl implements GetPathService {
    @Autowired
    private GetPathDao getPathDao;


    @Override
    public Map<String, Object> getPfxPath(String xhdwsbh) {
        Map<String, Object> pfxMap = new HashMap<String, Object>();
        KpCacersubInfo pfx = getPathDao.getPfxPath(xhdwsbh);
//        String pfxFileAddr1 = pfx.getKcsiFileAddr(); //pfx文件路径
//        String pfxStream1 = pfx.getKcsiStream();     //pfx文件流
//        String pfxType1 = pfx.getKcsiType();         //文件类型
        JSONObject json = JSONObject.fromObject(pfxMap);

        String strPfxTemplate = "";
        // 验证是否有pfx 信息
        if (pfx != null) {
            strPfxTemplate = pfx.getKcsiFileAddr();              //pfx文件路径
                // 判断pfx路径是否存在
                File pdfTemplate = new File(strPfxTemplate);
                if (!pdfTemplate.exists()) {
                    // base64加密文件流
                    String pfxStream = pfx.getKcsiStream();     //pfx文件流
                    System.out.println("pfxStream = = = = = ="+pfxStream);
                    // 判断 有无 对应的 路径
                    if (!StringUtils.isBlank(pfxStream)) {
                        // 取文件流并存到对应的目录
                        boolean savePfxFile = EWMbase64util.generateImage(pfxStream, strPfxTemplate);
                        System.out.println("pfx文件路径:" + savePfxFile);
                    } else {
                        pfxMap.put("msg", InvoiceConstant.CA_INFO_STREAM_ERROR);
                        pfxMap.put("result", "ERROR");
                        pfxMap.put("code", "500146");
                        pfxMap.put("rows", "");

                        FileUtils.printLog(json.toString(),
                                FilePathConstant.LogFilePath + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "buildPdfLog.txt");
                        return pfxMap;
                    }
                }
            pfxMap.put("strPfxTemplate",strPfxTemplate);
        } else {
            pfxMap.put("msg", InvoiceConstant.XSF_CA_INFO_ERROR);
            pfxMap.put("result", "ERROR");
            pfxMap.put("code", "500130");
            pfxMap.put("rows", "");
            FileUtils.printLog(json.toString(),
                    FilePathConstant.LogFilePath + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "buildPdfLog.txt");
            return pfxMap;
        }

        pfxMap.put("strPfxTemplate",strPfxTemplate);
        return pfxMap;
    }

    @Override
    public Map<String, Object> getGifPath1(String xhdwsbh) {

        Map<String, Object> gifMap = new HashMap<String, Object>();
        KpCacersubInfo pfx = getPathDao.getGifPath(xhdwsbh);
//        String pfxFileAddr1 = pfx.getKcsiFileAddr(); //pfx文件路径
//        String pfxStream1 = pfx.getKcsiStream();     //pfx文件流
//        String pfxType1 = pfx.getKcsiType();         //文件类型
        JSONObject json = JSONObject.fromObject(gifMap);

        String strGifTemplate = "";
        // 验证是否有pfx 信息
        if (pfx != null) {
            strGifTemplate = pfx.getKcsiFileAddr();              //pfx文件路径
            // 判断pfx路径是否存在
            File pdfTemplate = new File(strGifTemplate);
            if (!pdfTemplate.exists()) {
                // base64加密文件流
                String gifStream = pfx.getKcsiStream();     //pfx文件流
                // 判断 有无 对应的 路径
                if (!StringUtils.isBlank(gifStream)) {
                    // 取文件流并存到对应的目录
                    boolean saveGifFile = EWMbase64util.generateImage(gifStream, strGifTemplate);
                    System.out.println("gif文件路径:" + saveGifFile);
                } else {
                    gifMap.put("msg", InvoiceConstant.CA_INFO_STREAM_ERROR);
                    gifMap.put("result", "ERROR");
                    gifMap.put("code", "500146");
                    gifMap.put("rows", "");

                    FileUtils.printLog(json.toString(),
                            FilePathConstant.LogFilePath + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "buildPdfLog.txt");
                    return gifMap;
                }
            }
            gifMap.put("strGifTemplate",strGifTemplate);
        } else {
            gifMap.put("msg", InvoiceConstant.XSF_CA_INFO_ERROR);
            gifMap.put("result", "ERROR");
            gifMap.put("code", "500130");
            gifMap.put("rows", "");
            FileUtils.printLog(json.toString(),
                    FilePathConstant.LogFilePath + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "buildPdfLog.txt");
            return gifMap;
        }

        gifMap.put("strGifTemplate",strGifTemplate);
        return gifMap;

    }

    @Override
    public Map<String, Object> getTemPath(String xhdwsbh) {
        Map<String, Object> temMap = new HashMap<String, Object>();
        TcrmPdftemplateBean templatePDF = getPathDao.getTemPath(xhdwsbh);
//        String pfxFileAddr1 = pfx.getKcsiFileAddr(); //pfx文件路径
//        String pfxStream1 = pfx.getKcsiStream();     //pfx文件流
//        String pfxType1 = pfx.getKcsiType();         //文件类型
        JSONObject json = JSONObject.fromObject(temMap);

        String strPDFTemplate = "";
        // 验证是否有pfx 信息
        if (templatePDF != null) {
            strPDFTemplate = templatePDF.getVpath();              //pfx文件路径
            // 判断pfx路径是否存在
            File pdfTemplate = new File(strPDFTemplate);
            if (!pdfTemplate.exists()) {
                // base64加密文件流
                String PDFStream = templatePDF.getPdfstream();     //pfx文件流
                // 判断 有无 对应的 路径
                if (!StringUtils.isBlank(PDFStream)) {
                    // 取文件流并存到对应的目录
                    boolean savePDFFile = EWMbase64util.generateImage(PDFStream, strPDFTemplate);
                    System.out.println("PDF文件路径:" + savePDFFile);
                } else {
                    temMap.put("msg", InvoiceConstant.CA_INFO_STREAM_ERROR);
                    temMap.put("result", "ERROR");
                    temMap.put("code", "500146");
                    temMap.put("rows", "");

                    FileUtils.printLog(json.toString(),
                            FilePathConstant.LogFilePath + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "buildPdfLog.txt");
                    return temMap;
                }
            }
            temMap.put("strPDFTemplate",strPDFTemplate);
        } else {
            temMap.put("msg", InvoiceConstant.XSF_CA_INFO_ERROR);
            temMap.put("result", "ERROR");
            temMap.put("code", "500130");
            temMap.put("rows", "");
            FileUtils.printLog(json.toString(),
                    FilePathConstant.LogFilePath + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "buildPdfLog.txt");
            return temMap;
        }

        temMap.put("strPDFTemplate",strPDFTemplate);
        return temMap;
    }

    @Override
    public Xxfp getFpqqlsh(String fphm) {
        return getPathDao.getFpqqlsh(fphm);
    }

}
