package com.bwjf.createpdf.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Test12 {


    public static String compress(String source) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            GZIPOutputStream gos = new GZIPOutputStream(bos);
            gos.write(source.getBytes("ISO-8859-1"));
            gos.close();
            return bos.toString("ISO-8859-1");
        } catch (IOException var3) {
            System.out.println(var3.getStackTrace().toString());
            return source;
        }
    }

    /****
     * @Method compress  字符串解压方法
     * @author source 需要传入待解压的字符串
     * 返回值   返回解压后的字符串
     ****/
    public static String uncompress(String source) {
        if (source != null && source.length() != 0) {
            try {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ByteArrayInputStream bis = new ByteArrayInputStream(source.getBytes("ISO-8859-1"));
                GZIPInputStream gis = new GZIPInputStream(bis);
                byte[] data = new byte[1024];

                for(int len = gis.read(data); len != -1; len = gis.read(data)) {
                    bos.write(data, 0, len);
                }

                return bos.toString();
            } catch (IOException var6) {
                System.out.println(var6.getStackTrace().toString());
                return source;
            }
        } else {
            return source;
        }
    }

    public static String MD5(String sourceStr) {
        try {
            // 获得MD5摘要算法的 MessageDigest对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(sourceStr.getBytes());
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            StringBuffer buf = new StringBuffer();
            for (int i = 0; i < md.length; i++) {
                int tmp = md[i];
                if (tmp < 0)
                    tmp += 256;
                if (tmp < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(tmp));
            }
            //return buf.toString().substring(8, 24);// 16位加密
            return buf.toString().toUpperCase();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        // 字符串超过一定的长度
        String str = "{\n" +
                "    \"access_token\": \"acdc73ec1ad145fbbfbc2dfddd0c7372b5d9e04f0e8043f5b3a64e920d96b083\",\n" +
                "    \"serviceKey\": \"bwjf_InvoiceHandle_newBlueInvoice\",\n" +
                "    \"data\": \n" +
                "    {\n" +
                "    \"data_resources\": \"API\",\n" +
                "    \"nsrsbh\": \"91320106598035469W\",\n" +
                "    \"skph\":\"123213123212\",\n" +
                "    \"order_num\": \"iHkml3V154806120830\",\n" +
                "    \"bmb_bbh\": \"32.0\",\n" +
                "    \"zsfs\": \"0\",\n" +
                "    \"tspz\":\"00\",\n" +
                "    \"xsf_nsrsbh\": \"91320106598035469W\",\n" +
                "    \"xsf_mc\": \"江苏百旺金赋信息科技有限公司\",\n" +
                "    \"xsf_dzdh\": \"城市区人民中路188号飞驰新天地广场2幢1801室0515-88196558\",\n" +
                "    \"xsf_yhzh\": \"中国建设银行迎宾支行32050173513609916688\",\n" +
                "    \"gmf_nsrsbh\": \"913201022498209112\",\n" +
                "    \"gmf_mc\": \"测试用户0425\",\n" +
                "    \"gmf_dzdh\": \"崔老板的300平米豪宅110\",\n" +
                "    \"gmf_yhzh\": \"中国崔氏银行0000\",\n" +
                "    \"kpr\": \"崔老板111\",\n" +
                "    \"skr\": \"红字skr\",\n" +
                "    \"fhr\": \"红字fhr\", \n" +
                "    \"yfp_dm\": \"150007899605\",\n" +
                "    \"yfp_hm\": \"65439448\",\n" +
                "    \"jshj\": \"280.00\",\n" +
                "    \"hjje\": \"264.15\",\n" +
                "    \"hjse\": \"15.85\",\n" +
                "    \"kce\": \"0\",\n" +
                "    \"bz\": \"服务费截止时间：2019.4.27-2020.4.27\",\n" +
                "    \"jff_phone\":\"手机号\",\n" +
                "    \"jff_email\":\"电子邮件\",\n" +
                "    \"common_fpkj_xmxx\": [{\n" +
                "            \"fphxz\": \"0\",\n" +
                "            \"spbm\": \"3079900000000000000\",\n" +
                "            \"zxbm\": \"\",\n" +
                "            \"yhzcbs\": \"0\",\n" +
                "            \"lslbs\": \"\",\n" +
                "            \"zzstsgl\": \"\",\n" +
                "            \"xmmc\": \"税控系统技术维护费\",\n" +
                "            \"ggxh\": \"\",\n" +
                "            \"dw\": \"\",\n" +
                "            \"xmsl\": \"1.000000\",\n" +
                "            \"xmdj\": \"174.523654125654\",\n" +
                "            \"xmje\": \"174.52\",\n" +
                "            \"sl\": \"0.06\",\n" +
                "            \"se\": \"15.85\"\n" +
                "        },\n" +
                "\t\t{\n" +
                "            \"fphxz\": \"0\",\n" +
                "            \"spbm\": \"3079900000000000000\",\n" +
                "            \"zxbm\": \"\",\n" +
                "            \"yhzcbs\": \"0\",\n" +
                "            \"lslbs\": \"\",\n" +
                "            \"zzstsgl\": \"\",\n" +
                "            \"xmmc\": \"税控系统技术维护费2\",\n" +
                "            \"ggxh\": \"\",\n" +
                "            \"dw\": \"\",\n" +
                "            \"xmsl\": \"3.000000\",\n" +
                "            \"xmdj\": \"316.88\",\n" +
                "            \"xmje\": \"950.64\",\n" +
                "            \"sl\": \"0.06\",\n" +
                "            \"se\": \"15.85\"\n" +
                "        },{\n" +
                "            \"fphxz\": \"0\",\n" +
                "            \"spbm\": \"3079900000000000000\",\n" +
                "            \"zxbm\": \"\",\n" +
                "            \"yhzcbs\": \"0\",\n" +
                "            \"lslbs\": \"\",\n" +
                "            \"zzstsgl\": \"\",\n" +
                "            \"xmmc\": \"税控系统技术维护费3\",\n" +
                "            \"ggxh\": \"\",\n" +
                "            \"dw\": \"\",\n" +
                "            \"xmsl\": \"2.000000\",\n" +
                "            \"xmdj\": \"450.00\",\n" +
                "            \"xmje\": \"900.00\",\n" +
                "            \"sl\": \"0.06\",\n" +
                "            \"se\": \"15.85\"\n" +
                "        },{\n" +
                "            \"fphxz\": \"0\",\n" +
                "            \"spbm\": \"3079900000000000000\",\n" +
                "            \"zxbm\": \"\",\n" +
                "            \"yhzcbs\": \"0\",\n" +
                "            \"lslbs\": \"\",\n" +
                "            \"zzstsgl\": \"\",\n" +
                "            \"xmmc\": \"税控系统技术维护费4\",\n" +
                "            \"ggxh\": \"\",\n" +
                "            \"dw\": \"\",\n" +
                "            \"xmsl\": \"1.000000\",\n" +
                "            \"xmdj\": \"206.236545879651\",\n" +
                "            \"xmje\": \"206.24\",\n" +
                "            \"sl\": \"0.06\",\n" +
                "            \"se\": \"15.85\"\n" +
                "        }]\n" +
                "    }\n" +
                "}";


        //字符串原始长度处理
        String originalStr = str;
        System.out.println("原始的字符串长度:" + originalStr.length());

        //字符串压缩状态处理
        String compressStr = compress(originalStr);
        System.out.println("压缩的字符串长度:" + compressStr.length());
//        System.out.println("压缩的字符串:" + compressStr);

        //字符串解压方法以及测试解压后字符串长度
        String uncompress = uncompress(compressStr);
        System.out.println("解压后的字符串长度:" + uncompress.length());

        //字符串压缩率
        float rate = (float)compressStr.length() / uncompress.length();
        System.out.println("字符串压缩率：" + rate);

        if(originalStr.equals(uncompress)){
            System.out.println("解压后的字符串和原始的字符串长度一样");
        }

        //MD5加密数据
        String md5 = MD5(compressStr);
        System.out.println("MD5加密数据：" + md5);

    }
}
