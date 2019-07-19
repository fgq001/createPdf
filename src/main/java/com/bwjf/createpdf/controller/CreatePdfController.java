package com.bwjf.createpdf.controller;

import com.bwjf.createpdf.constant.FilePathConstant;
import com.bwjf.createpdf.entity.Xxfp;
import com.bwjf.createpdf.entity.Xxfpmx;
import com.bwjf.createpdf.service.CreatePdfService;
import com.bwjf.createpdf.service.XmlJxService;
import com.bwjf.createpdf.utils.FileUtils;
import com.bwjf.createpdf.utils.XMLDomUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2019/7/16.
 */


@Controller
@RequestMapping("/pdf")
public class CreatePdfController {

    @Autowired
    private CreatePdfService createPdfService;
//    @Autowired
//    private XmlJxService xmlJxService;

    @ResponseBody
    @PostMapping("/createPdf")
    public void CreatePdf(HttpServletRequest req, HttpServletResponse resp){
        long startTime = System.currentTimeMillis(); // 获取开始时间
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charset=UTF-8");

//            FileUtils.printLog(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "=====" + jsonData1.toString(), FilePathConstant.LogFilePath + new SimpleDateFormat("yyyyMMdd").format(new Date())+"execProcedureData.txt");

            //税控设备编号
            String strJQBH = req.getParameter("strJQBH") == "" ? null : req.getParameter("strJQBH");
            //pfx文件路径
            String pfx = req.getParameter("pfx") == "" ? null : req.getParameter("pfx");
            //开票的xml内容
            String xmlContent = req.getParameter("xmlContent") == "" ? null : req.getParameter("xmlContent");
            //印章地址
            String gif = req.getParameter("gif") == "" ? null : req.getParameter("gif");
            //pdf模板地址
            String tmpPath = req.getParameter("tmpPath") == "" ? null : req.getParameter("tmpPath");
            //创建的临时pdf路径
            String temPath = req.getParameter("temPath") == "" ? null : req.getParameter("temPath");
            //最终签名后的pdf路径
            String endPath = req.getParameter("endPath") == "" ? null : req.getParameter("endPath");
            //签章密码
            String password = req.getParameter("password") == "" ? null : req.getParameter("password");
//            System.out.println("strJQBH == "+strJQBH+"  pfx ==  "+pfx);

//            XMLDomUtils.XmlJx(xmlContent);

            Xxfp xxfp = new Xxfp();
            Xxfpmx xxfpmx = new Xxfpmx();
            List<Xxfpmx> xxfpmxList = new ArrayList<>();

            XMLDomUtils.XmlJx(xmlContent,tmpPath,temPath,endPath,xxfp,xxfpmxList,pfx,gif,password);
//            xxfpmxList = (List<Xxfpmx>) XMLDomUtils.XmlJx(xmlContent);
            System.out.println("xxfp.getJym()"+xxfp.getJym());

            createPdfService.createPdf(tmpPath,temPath,endPath,xxfp,xxfpmxList,pfx,gif,password,xmlContent);
//            xmlJxService.XmlJx(xmlContent, tmpPath, temPath, endPath, xxfp, xxfpmxList, pfx, gif, password);


        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis(); // 获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); // 输出程序运行时间
    }

}
