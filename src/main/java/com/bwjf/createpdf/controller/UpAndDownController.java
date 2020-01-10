package com.bwjf.createpdf.controller;


//import com.bwjf.fp365.service.KpFileInfoService;

import com.bwjf.createpdf.entity.BackupBwjfKpOutsideInteBaseInfoBean;
import com.bwjf.createpdf.entity.KpFileInfo;
import com.bwjf.createpdf.service.KpFileInfoService;
import com.bwjf.createpdf.test.EWMbase64util;
import com.bwjf.createpdf.utils.ExtractTextByArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
//import test.PdfConvertUtil;
//import test.PdfReader;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequestMapping("ud")
@Controller
public class UpAndDownController {
    @Autowired
    private KpFileInfoService kpFileInfoService;

    private static String pdfPath = "D:\\testPDF999\\testPDF\\koidID_";
//    private static String htmlPath = "D:\\testPDF999\\testHTML\\koidID_";


    @ResponseBody
    @RequestMapping("test1")
    public void test1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");


        String limitNum = request.getParameter("limitNum") == "" ? null : request.getParameter("limitNum");
        int limNum = Integer.parseInt(limitNum);
        List<KpFileInfo> kpFileInfos = kpFileInfoService.kpFileInfoAll(limNum);

        int number = kpFileInfos.size();


        response.getWriter().println("成功导出"+number+"条PDF数据");

    }



    @ResponseBody
    @RequestMapping("testPDF")
    public void testPDF(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        long startTime = System.currentTimeMillis(); // 获取开始时间
        int a = 0;
        int b = 0;
        String limitNum = request.getParameter("limitNum") == "" ? null : request.getParameter("limitNum");
        int limNum = Integer.parseInt(limitNum);
        List<KpFileInfo> kpFileInfos = kpFileInfoService.kpFileInfoAll(limNum);
//        List<KpFileInfo> kpFileInfos = kpFileInfoService.kpFileInfoAll("1");

        Map<String,String> pdfInfoMap = new HashMap<>();

//                outputPath = "D:\\code\\pdf\\HashMap.html";
//        byte[] bytes = getBytes("D:\\code\\pdf\\HashMap.pdf");
//        String htmlPath1 = "D:\\code\\pdf\\koidID_423.html";
//        String pdfPath1 = "D:\\code\\pdf\\koidID_423.pdf";


        if (kpFileInfos != null && kpFileInfos.size()>0) {
            for (int i = 0; i < kpFileInfos.size(); i++) {
                //PDF文件流
                String stream = kpFileInfos.get(i).getKOIF_FILE_ADDR();
                //PDF生成路径+文件名   "D:\\zht\\test.pdf"
                String koibId = kpFileInfos.get(i).getKOIB_ID();
                String pdfFilePath = pdfPath+koibId+".pdf";
//                String htmlFilePath = htmlPath+koibId+".html";

                //根据pdf文件流生成PDF文件   pdfFilePath：文件路径
                String CreatePDFcode = EWMbase64util.base64ToPDF(stream,pdfFilePath);
                if (CreatePDFcode == "success") {
                    try {
                        pdfInfoMap = ExtractTextByArea.jiexiPDF(pdfFilePath);

                        String jiexiCode = pdfInfoMap.get("code");

                        if (jiexiCode == "success") {

                            BackupBwjfKpOutsideInteBaseInfoBean baseInfoBean = new BackupBwjfKpOutsideInteBaseInfoBean();

                            //获取PDF解析后  需要的值
                            String fpdmStr = pdfInfoMap.get("fpdm");
                            String fphmStr = pdfInfoMap.get("fphmStr");
                            String kprqStr = pdfInfoMap.get("kprqStr");
                            String jymStr = pdfInfoMap.get("jymStr");
                            String jqbmStr = pdfInfoMap.get("jqbmStr");
                            String BZStr = pdfInfoMap.get("BZStr");
                            String mqkStr = pdfInfoMap.get("mkqStr");

                            //处理解析的值
                            String regEx="[^0-9]";  //正则规则
                            Pattern p = Pattern.compile(regEx);

                            Matcher m = p.matcher(kprqStr);
                            Matcher m1 = p.matcher(jymStr);
                            //开票日期正则截取
                            String newKprqStr = m.replaceAll("").trim();
                            //校验码正则截取
                            String newjymStr = m1.replaceAll("").trim();

                            System.out.println( "开票日期正则截取："+newKprqStr);
                            System.out.println( "校验码正则截取："+ newjymStr);

                            //处理  备注不换行 mqkStr
                            String newBzstr = BZStr;
                            String newmqkStr = mqkStr;
                            newBzstr = newBzstr.replaceAll("\r|\n", "");
                            newmqkStr = newmqkStr.replaceAll("\r|\n", "");
                            System.out.println("转换后newBzstr："+newBzstr);
                            System.out.println("转换后newmqkStr："+newmqkStr);

                            System.out.println("发票ID: "+koibId);
                            System.out.println("发票代码: "+fpdmStr);
                            System.out.println("发票号码: "+fphmStr);
                            System.out.println("开票日期: "+newKprqStr);
                            System.out.println("发票校验码: "+newjymStr);
                            System.out.println("发票机器编号: "+jqbmStr);
                            System.out.println("发票备注: "+newBzstr);

                            baseInfoBean.setId(Integer.parseInt(koibId));
                            baseInfoBean.setKoibFpdm(fpdmStr);
                            baseInfoBean.setKoibFphm(fphmStr);
                            baseInfoBean.setKoibKprq(newKprqStr);
                            baseInfoBean.setKoibJym(newjymStr);
                            baseInfoBean.setKoibJqbh(jqbmStr);
                            baseInfoBean.setKoibSkm(newmqkStr);
                            baseInfoBean.setKoibBz(newBzstr);

                            kpFileInfoService.saveBackupBaseInfo(baseInfoBean);
                            b++;

//                            删除PDF
                            File file1=new File(pdfFilePath);
                            if(file1.exists()&&file1.isFile())
                                file1.delete();

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }



                a++;


//                PdfConvertUtil pdf = new PdfConvertUtil();
//
//                pdf.pdfToHtmlTest(htmlFilePath,pdfFilePath);


//                PDF文件  转成 text文件
//                PdfReader pdfReader = new PdfReader();
//                try {
//                    pdfReader.readFdf(pdfFilePath);
//                    b++;
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    System.out.println("转text失败");
//                    response.getWriter().println("转text失败");
//                }


            }
        } else {
            System.out.println("未查询到数据");
            response.getWriter().println("未查询到数据");
        }
        System.out.println("成功导出"+a+"条PDF数据");
        response.getWriter().println("成功导出"+a+"条PDF数据");

        long endTime = System.currentTimeMillis(); // 获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); // 输出程序运行时间
        response.getWriter().println("程序运行时间"+(endTime - startTime)+"ms");

        System.out.println("保存到数据库"+b+"条PDF数据");
        response.getWriter().println("保存到数据库"+b+"条PDF数据");
    }


    @ResponseBody
    @RequestMapping("testEWM")
    public void testEWM(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        long startTime = System.currentTimeMillis(); // 获取开始时间
        int a = 0;
        int b = 0;
        String limitNum = request.getParameter("limitNum") == "" ? null : request.getParameter("limitNum");
        int limNum = Integer.parseInt(limitNum);
        List<KpFileInfo> kpFileInfos = kpFileInfoService.kpFileInfoAll(limNum);
//        List<KpFileInfo> kpFileInfos = kpFileInfoService.kpFileInfoAll("1");

        Map<String,String> pdfInfoMap = new HashMap<>();

//                outputPath = "D:\\code\\pdf\\HashMap.html";
//        byte[] bytes = getBytes("D:\\code\\pdf\\HashMap.pdf");
//        String htmlPath1 = "D:\\code\\pdf\\koidID_423.html";
//        String pdfPath1 = "D:\\code\\pdf\\koidID_423.pdf";


        if (kpFileInfos != null && kpFileInfos.size()>0) {
            for (int i = 0; i < kpFileInfos.size(); i++) {
                //PDF文件流
                String stream = kpFileInfos.get(i).getKOIF_FILE_ADDR();
                //PDF生成路径+文件名
                String koibId = kpFileInfos.get(i).getKOIB_ID();
                String pdfFilePath = pdfPath+koibId+".png";
//                String htmlFilePath = htmlPath+koibId+".html";


                //根据EWM文件流生成PDF文件   pdfFilePath：文件路径
                boolean CreatePDFcodeEWM = EWMbase64util.generateImage(stream,pdfFilePath);
                if (CreatePDFcodeEWM = true) {
                    System.out.println("成功");
                    String result = EWMbase64util.JiexiEWM(pdfFilePath);
                    System.out.println(result);


//                    String result = "01,10,150007899605,65440044,0.88,20191106,02284305162156547392,737B,";
                    String dataArray[]=result.split(String.valueOf(','));

                    BackupBwjfKpOutsideInteBaseInfoBean baseInfoBean = new BackupBwjfKpOutsideInteBaseInfoBean();
                    String fpdm = "";
                    String fphm = "";
                    String kprq = "";
                    String jym = "";

                    for(int j=0;j<1;j++){

                         fpdm = dataArray[2];
                         fphm = dataArray[3];
                         kprq = dataArray[5];
                         jym = dataArray[6];


//                        System.out.println(dataArray[j]);

                    }

                    baseInfoBean.setId(Integer.parseInt(koibId));
                    baseInfoBean.setKoibFpdm(fpdm);
                    baseInfoBean.setKoibFphm(fphm);
                    baseInfoBean.setKoibKprq(kprq);
                    baseInfoBean.setKoibJym(jym);

                    kpFileInfoService.saveBackupBaseInfo(baseInfoBean);
                    b++;

//                            删除PDF
                    File file1=new File(pdfFilePath);
                    if(file1.exists()&&file1.isFile())
                        file1.delete();
                }




                a++;


//                PdfConvertUtil pdf = new PdfConvertUtil();
//
//                pdf.pdfToHtmlTest(htmlFilePath,pdfFilePath);


//                PDF文件  转成 text文件
//                PdfReader pdfReader = new PdfReader();
//                try {
//                    pdfReader.readFdf(pdfFilePath);
//                    b++;
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    System.out.println("转text失败");
//                    response.getWriter().println("转text失败");
//                }


            }
        } else {
            System.out.println("未查询到数据");
            response.getWriter().println("未查询到数据");
        }
        System.out.println("成功导出"+a+"条EWM数据");
        response.getWriter().println("成功导出"+a+"条EWM数据");

        long endTime = System.currentTimeMillis(); // 获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); // 输出程序运行时间
        response.getWriter().println("程序运行时间"+(endTime - startTime)+"ms");

        System.out.println("保存到数据库"+b+"条EWM数据");
        response.getWriter().println("保存到数据库"+b+"条EWM数据");

    }
    public static void main(String[] args) {
//
//        String stream = "iVBORw0KGgoAAAANSUhEUgAAAJQAAACUCAIAAAD6XpeDAAAC/UlEQVR42u3aUY6kMAxAwb7/pXtPMNICfkmGqXy2WhBcQTh2Pp9gfH8YV/9T3Gvquf5nDlP3XTrgwYMH74/gfR+M4joF0tRienKdIj7w4MGDB+8+3tQHvAhukfgU859KoODBgwcP3jvxioAWgS4WIjx48ODBew9ekZg8KSDsKkzDgwcPHryz8IoA1QlOXXSuG9HHdRXgwYMH78V4U2MX6m/5/egBCR48eC/G+8ZjqnFaf+SLA055bOHBgwcP3u3nKg7wnLYBP6EZW8QTHjx48ODdxysShKlm5lSyUDdjp+YGDx48ePBm8KaCftpmvG4aTyUsY28bPHjw4MG7jVd8eHdt/FcmFPU14cGDBw/eSO33Uwe9CHS9eV9ZmE7eQnjw4MGDt2xTfPUhi/9PLdCjC9Pw4MGDB2/ieZNAr0Sq77Xt0BE8ePDgwbvdz1v5QZ4qcNcJ0co4XF708ODBgwdvBK8oUu/6yJ+waLYVpuHBgwcP3rKibT3pqQTkhML02FsIDx48ePBux7ko2haJ0lRQViY1efIIDx48ePDSZumTIB7RcY6L4GOHjuDBgwcP3rLnOq0xuzKBOq4wDQ8ePHjwxovRxUGa+ppFETw5UHR1nvDgwYMHbyR5eZIs7NqE1s3Sunk7lqzBgwcPHrzbhemVm/Fio71yU780wYEHDx48eCN4dYP0tA3vry9Mw4MHDx688XpmHdAnC+u0pKnYmD96C+HBgwcP3vjppV0wReJQFKaTxAcePHjw4I3s84pEpk4Kiubw1KKZehZ48ODBg9fi7Tp4s3I+RRI3leBsy7LgwYMH7wV433gUC+iEBKoo1l9eNPDgwYMHb8e3dqzovGsOuxZQMX948ODBgzffz1uZLNSN4tOauvDgwYMHbx3eroAWH/knjdZtm+Wr94IHDx48eEfh1QXcOhkp5g8PHjx48P4W3soC966ic54QwYMHDx6823j1hrc+sFQkCFPzfxJDePDgwYM33vv81A9fF7vrgnh96Oiza8CDBw/ee/H+AfmpuSTURsZYAAAAAElFTkSuQmCC";
//        String pdfFilePath = pdfPath+"18218"+".png";
//        boolean CreatePDFcode = EWMbase64util.generateImage(stream,pdfFilePath);
//        if (CreatePDFcode =true) {
//            System.out.println("成功");
//            String result = EWMbase64util.JiexiEWM(pdfFilePath);
//            System.out.println(result);
////            String result = "01,10,150007899605,65440044,0.88,20191106,02284305162156547392,737B,";
//            String dataArray[]=result.split(String.valueOf(','));
//            for(int i=0;i<dataArray.length;i++){
//                System.out.println(dataArray[i]);
//            }
//        }




//        try {
//            BufferedImage image = ImageIO.read(new File(pdfFilePath));
//            String dd = EWMbase64util.decodeQrCode(image);
//            System.out.println("success");
//            System.out.println(dd);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}