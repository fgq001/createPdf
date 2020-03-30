package com.bwjf.createpdf.controller;

import com.bwjf.createpdf.constant.FilePathConstant;
import com.bwjf.createpdf.constant.InvoiceConstant;
import com.bwjf.createpdf.entity.Xxfp;
import com.bwjf.createpdf.entity.Xxfpmx;
import com.bwjf.createpdf.service.CreatePdfService;
import com.bwjf.createpdf.service.GetPathService;
import com.bwjf.createpdf.service.XMLDomService;
import com.bwjf.createpdf.utils.ExtractTextByArea;
import com.bwjf.createpdf.utils.FileUtils;
import com.bwjf.createpdf.utils.NumberUtil;
import com.bwjf.createpdf.utils.XMLDomUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 2019/7/16.
 */


@Controller
@RequestMapping("/pdf")
public class CreatePdfController {

    @Autowired
    private CreatePdfService createPdfService;
    @Autowired
    private GetPathService getPathService;
    @Autowired
    private XMLDomService xmlDomService;


@Autowired
private XMLDomUtils xmlDomUtils;

    @ResponseBody
    @PostMapping("/createPdf")
    public JSONObject CreatePdf(HttpServletRequest req, HttpServletResponse resp) {
        long startTime = System.currentTimeMillis(); // 获取开始时间
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> sonMap = new HashMap<>();
        JSONObject jsonObject = null;
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charset=UTF-8");
//            FileUtils.printLog(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "=====" + jsonData1.toString(), FilePathConstant.LogFilePath + new SimpleDateFormat("yyyyMMdd").format(new Date())+"execProcedureData.txt");

            //开票的xml内容
            String xmlContentSkm = req.getParameter("xmlContent") == "" ? null : req.getParameter("xmlContent");
//            System.out.println("xmlContentSkm: "+xmlContentSkm);
            FileUtils.printLog(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "初始xml" + "\n\t" + xmlContentSkm + "\n\t", FilePathConstant.LogFilePath + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "xmlContent.txt");
              //替换xml中<smk>的  <>
//            String xmlContent = NumberUtil.strSkm(xmlContentSkm);
//            System.out.println("替换后: "+xmlContent);
//            FileUtils.printLog(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "修改后xml" + "\n\t" + xmlContent + "\n\t", FilePathConstant.LogFilePath + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "xmlContent.txt");

            Xxfp xxfp = new Xxfp();
            List<Xxfpmx> xxfpmxList = new ArrayList<>();

            //解析XML内容
//            XMLDomUtils.XmlJx(xmlContent, xxfp, xxfpmxList);
            xmlDomService.XmlJx(xmlContentSkm, xxfp, xxfpmxList);
            //获取销货单位识别号 查询path
            String xhdwsbh = xxfp.getXhdwsbh();
            //获取发票号码  查询发票id
            String fphm = xxfp.getFphm();
            String fpdm = xxfp.getFpdm();

            //获取ca证书 pfx 的文件路径与文件流
            Map<String, Object> pfxMap = getPathService.getPfxPath(xhdwsbh);
            if (pfxMap != null) {
                String strPfxTemplate = pfxMap.get("strPfxTemplate").toString();//pfx文件路径

                //获取 印章 gif 的文件路径与文件流
                Map<String, Object> gifMap = getPathService.getGifPath1(xhdwsbh);
                if (gifMap != null) {
                    String strGifTemplate = gifMap.get("strGifTemplate").toString();

                    //获取 模板PDF 的文件路径与文件流
                    Map<String, Object> tmpPath = getPathService.getTemPath(xhdwsbh);
                    if (tmpPath != null) {
                        String strPDFTemplate = tmpPath.get("strPDFTemplate").toString();

                        //根据发票号码 查询 发票请求流水号 作为保存PDF路径名称
                        Xxfp xxfp1 = new Xxfp();
                        xxfp1 = getPathService.getFpqqlsh(fphm);
                        if (xxfp1 != null) {
                            String fpqqlsh = xxfp1.getFpqqlsh();

                            String kplxName = null;
                            if (xxfp1.getKplx().equals("0")) {
                                kplxName = "Blue_";
                            } else {
                                kplxName = "Red_";
                            }
                            ;


                            //创建的临时pdf路径 E:\PDFFileTest\
                            String temPath = FilePathConstant.temPath + "Tem" + kplxName + fpqqlsh + ".pdf";
                            //最终签名后的pdf路径
                            String endPath = FilePathConstant.endPath + kplxName + fpqqlsh + ".pdf";
                            //签章密码
                            String password = FilePathConstant.password;

                            //创建PDF
                            boolean bo = createPdfService.createPdf(strPDFTemplate, temPath, endPath, xxfp, xxfpmxList, strPfxTemplate, strGifTemplate, password, xmlContentSkm);

                            //把签章后PDF路径转成流
                            String fileAddr = FileUtils.encodeBase64File(endPath);

                            sonMap.put("fpdm", fpdm);
                            sonMap.put("fphm", fphm);
                            sonMap.put("fileStream", fileAddr);

                            long endTime = System.currentTimeMillis(); // 获取结束时间
                            System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); // 输出程序运行时间

                            if (bo) {
                                System.out.println("生成文件路径: " + endPath );
                                map.put("msg", "操作成功");
                                map.put("result", "SUCCESS");
                                map.put("code", "0");
                                map.put("rows", sonMap);
                                jsonObject = JSONObject.fromObject(map);
                                FileUtils.printLog(new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(new Date()) + "=====程序运行时间====" + (endTime - startTime) + "ms=====" + fileAddr + "\n\t", FilePathConstant.LogFilePath + new SimpleDateFormat("yyyyMMdd100").format(new Date()) + "createPDFInfo.txt");
                            } else {
                                map.put("msg", InvoiceConstant.CREATE_PDF);
                                map.put("result", "ERROR");
                                map.put("code", "500147");
                                map.put("rows", "");
                                jsonObject = JSONObject.fromObject(map);
                                return jsonObject;
                            }
                        } else {    //fphm = null 发票号码为空
                            map.put("msg", InvoiceConstant.FPHM_INFO);
                            map.put("result", "ERROR");
                            map.put("code", "500148");
                            map.put("rows", "");
                            jsonObject = JSONObject.fromObject(map);
                            return jsonObject;
                        }
                    } else {    //  tmpPath  = null
                        map.put("msg", InvoiceConstant.TMPPATH_INFO);
                        map.put("result", "ERROR");
                        map.put("code", "500149");
                        map.put("rows", "");
                        jsonObject = JSONObject.fromObject(map);
                        return jsonObject;
                    }

                } else {     //  gifMap  = null
                    map.put("msg", InvoiceConstant.GIFMAP_INFO);
                    map.put("result", "ERROR");
                    map.put("code", "500150");
                    map.put("rows", "");
                    jsonObject = JSONObject.fromObject(map);
                    return jsonObject;
                }
            } else {    //  pfxMap  = null
                map.put("msg", InvoiceConstant.PFXMAP_INFO);
                map.put("result", "ERROR");
                map.put("code", "500151");
                map.put("rows", "");
                jsonObject = JSONObject.fromObject(map);
                return jsonObject;
            }


        } catch (Exception e) {
            map.put("msg", InvoiceConstant.CREATE_PDF_EXCEPTION);
            map.put("result", "ERROR");
            map.put("code", "500152");
            map.put("rows", "");
            jsonObject = JSONObject.fromObject(map);
            e.printStackTrace();
            FileUtils.printLog(new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(new Date()) + "，异常，内容为" + "\n\t" + FileUtils.getTrace(e), FilePathConstant.LogFilePath + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "PdfExceptionLog.txt");
            return jsonObject;
//
//            Map<String, Object> inteParam = new HashMap<String, Object>();
//            inteParam.put("exceptionDatasource", "2");
//            inteParam.put("exceptionClass", "TicketOpenServiceImpl");
//            inteParam.put("exceptionMethod", "buildPDFFile");
//            inteParam.put("exceptionInfo", CommonUtils.getException(e));
//            int saveExceptionLogInfo = CommonUtils.saveExceptionInfo(inteParam);
        }
        return jsonObject;
    }


    public static void main(String[] args) throws Exception {



        String file = "D:\\tastPDF22\\koidID_26645.pdf";
        Map<String,String> map = ExtractTextByArea.jiexiPDF(file);

        String fpdmStr = map.get("fpdm");
        String fphmStr = map.get("fphmStr");
        String kprqStr = map.get("kprqStr");
        String jymStr = map.get("jymStr");
        String jqbmStr = map.get("jqbmStr");
        String BZStr = map.get("BZStr");
        String mkqStr = map.get("mkqStr");



        System.out.println(fpdmStr);
        System.out.println(fphmStr);
        System.out.println(kprqStr);
        System.out.println(jymStr);
        System.out.println(jqbmStr);
        System.out.println(BZStr);
        System.out.println(mkqStr);



//        String a="love23next234csdn3423javaeye";
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
//        Matcher m = p.matcher(kprqStr);
        Matcher m = p.matcher(kprqStr);
        Matcher m1 = p.matcher(jymStr);
        System.out.println( "开票日期正则截取："+ m.replaceAll("").trim());
        System.out.println( "机器编码正则截取："+ m1.replaceAll("").trim());


//        String s = "'sds gdasda" + "\n" + "edaeafd'";
//        System.out.println("转换前："+s);
//        s = s.replaceAll("\r|\n", "");
//        System.out.println("转换后："+s);

        String Bzstr1 = BZStr;
        Bzstr1 = Bzstr1.replaceAll("\r|\n", "");
        System.out.println("转换后BZStr："+Bzstr1);


        File file1=new File(file);
        if(file1.exists()&&file1.isFile())
            file1.delete();

    }
}
