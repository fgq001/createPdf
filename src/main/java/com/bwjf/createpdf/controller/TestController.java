package com.bwjf.createpdf.controller;

import com.bwjf.createpdf.entity.KpOutsideInteBaseinfo;
import com.bwjf.createpdf.service.TestServer;
import com.bwjf.createpdf.utils.CommonUtilsTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("test")
public class TestController {

    @Resource
    private TestServer testServer;


    @RequestMapping("/dd")
    public void test(HttpServletRequest req, HttpServletResponse resp) {
        List<String> listCount = testServer.countBig();
        int updateCount =0;

        for (int i = 0; i < listCount.size(); i++) {
            String koibFpqqlshCount = listCount.get(i);
            System.out.println("koibFpqqlsh: "+koibFpqqlshCount);

            List<KpOutsideInteBaseinfo> listKp = testServer.kpList(koibFpqqlshCount);
            for (int j = 0; j < listKp.size(); j++) {
                KpOutsideInteBaseinfo baseinfo = new KpOutsideInteBaseinfo();
                String koibFpqqlshKp = listKp.get(j).getKoibFpqqlsh();
                String id = listKp.get(j).getId();
                System.out.println("koibFpqqlshKp: "+koibFpqqlshKp);

                String newFpqqlsh = CommonUtilsTest.getFpqqlsh(koibFpqqlshKp);
                System.out.println("newFpqqlsh: "+newFpqqlsh);

                baseinfo.setId(id);
                baseinfo.setKoibFpqqlsh(newFpqqlsh);

                testServer.updataFpqqlsh(baseinfo);
                updateCount++;

                System.out.println(baseinfo);
                //重复数据
                int repeat =  testServer.queryNumber(newFpqqlsh);
                System.out.println("重复数据： "+repeat);
                if (repeat != 1) {
                    break;
                }
            }
        }

        System.out.println("updateCount :" +updateCount);
        try {
            resp.getWriter().print("成功修改数据："+updateCount+"条！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
