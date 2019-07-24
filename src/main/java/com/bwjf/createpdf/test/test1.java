package com.bwjf.createpdf.test;

import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by admin on 2019/7/18.
 */
public class test1 {


    public static void main(String[] args) throws UnsupportedEncodingException {


        System.out.println("sdfsd"+"\n\t"+"sfdsf");
//        System.out.println("039<*9//9-684*</22*>5042493-*21468>37716><46+>797<47234>--/665**<*4>*9/24/37-+<<959</146826-<50134791945-3890247");

//        String s = "</jqbh><skm>03145&lt;+--&lt;*/&gt;7&gt;2&lt;2484884*+&lt;/84&lt;1**885&lt;0&lt;*64966*-9&lt;&gt;70395111188-639&lt;/&lt;+0&lt;1+8+0/075/&gt;-075-//1&gt;*601&gt;47919703/57859-</skm><jym>145";
        String s = "<skm>03/9 67/1 <24-73 85 22<520005<7/ 5 8<< 87*<4 300 <>41>0<6010->9466 8/ 6491 745>*170>2*2/7<>32*01>47919*/4>2 >>/2</skm>";
        String s11 = null;
        s11 = "03145&lt;+--&lt;*/&gt;7&gt;2&lt;2484884*+&lt;/84&lt;1**885&lt;0&lt;*64966*-9&lt;&gt;70395111188-639&lt;/&lt;+0&lt;1+8+0/075/&gt;-075-//1&gt;*601&gt;47919703/57859-";
        System.out.println("原始："+s11);

        String s12 = "03145&lt;+--&lt;*/&gt;7&gt;2&lt;2484884*+&lt;/84&lt;1**885&lt;0&lt;*64966*-9&lt;&gt;70395111188-639&lt;/&lt;+0&lt;1+8+0/075/&gt;-075-//1&gt;*601&gt;47919703/57859-";
        s12.replaceAll("&lt;","<");//.replaceAll("&gt;",">");
        System.out.println("替换："+s12);

        String sdf = "df333f342";
        sdf.replaceAll("33","99");
        System.out.println("sdf:  "+sdf);

        String regex = "<skm>(.*?)</skm>";
        System.out.println(regex);
        List<String> list = new ArrayList<String>();
        List<String> extvounoLists = new ArrayList<String>();
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(s);
        while (m.find()) {
            int i = 1;
            list.add(m.group(i));
            i++;
        }
        for (String str : list) {
            System.out.println(str.replaceAll("<","&lt;").replaceAll(">","&gt;"));
            String[] strs = str.split("-");
            String strss = strs[strs.length-1];
            extvounoLists.add(strs[strs.length-1]);
        }


//        for (String string : extvounoLists) {
//            System.out.println(string);
//        }
















        String ss ="20190717094014";
        String d = ss.substring(0,4);
        String d1 = ss.substring(4,6);
        String d2 = ss.substring(6,8);
        System.out.println(d+d1+d2);


        // 生成带有清单发票
        // count: 30 pages: 1 PDFPages: 2
        // count: 31 pages: 2 PDFPages: 3
        int count = 9;
        int pages = count / 10 + (count % 10 == 0 ? 0 : 1);
//        System.out.println(pages);

//        String s = "中国人寿保险股份有限公司无锡市分公司中国人寿保险股份有";     //56
        String s5 = "阿裕食品桂花园子克阿裕食品桂花阿裕食品桂";      //42
        String s4 = "1234";
        String s1 = "===";
        String s2 = "ABC";
        String s3 = "abc";
//        int g = s5.trim().getBytes("uft-8").length;
////        int g = s.
//        System.out.println(g);


//        String a = "1234";
//        int num = a.getBytes("utf-16").length;
//        System.out.println(num);
//        a = "中国人寿保险股份有限公司无锡市分公司中国人寿保险股份有是";
//        num = a.getBytes("utf-16").length;
//        System.out.println(num);
//        a = "ABCDEFGABCDEABCDEABCDEABCDE ABCDEFGABCDEABCDEABCDF";
//        num = a.getBytes("utf-16").length;
//        System.out.println(num);
//        a = "()*!";
//        num = a.getBytes("utf-16").length;
//        System.out.println(num);
//        a = "（）—！";
//        num = a.getBytes("utf-16").length;
//        System.out.println(num);


//        byte[] b = {a};

//        Map<String,Object> map = new HashMap<>();
//        Map<String,Object> sonMap = new HashMap<>();
//        Map<String,Map<String,Object>> AMap = new HashMap<>();
//        sonMap.put("a","A");
//        sonMap.put("b","B");
//        map.put("msg","操作成功");
//        map.put("result","SUCCESS");
//        map.put("rows", sonMap);
//
//        AMap.put("ff",map);
//        AMap.put("xx",sonMap);
//        System.out.println(map);

//        try {
//        byte[] erm = ("iVBORw0KGgoAAAANSUhEUgAAAJQAAACUCAIAAAD6XpeDAAAC/UlEQVR42u3cy26DUAwFwPz/T6frLqoK8LENDMuIUPDc6PqB+vkEju+C46/7qbrno9/93OWABw8evJfgJYJ1NKBVGAmkK9dPxBkePHjw4NXgHb3Rqs+v3ENV0K8kI4nFBw8ePHjw7odXdU46uUgU/vDgwYMH7114iZtOBL0zqYEHDx48ePN46c08EaCqBGdD4b9iqgAPHjx4D8arOhIN6yd9vvqABA8evAfjfcPHhnvbMIyNxBYePHjw4J1+rnTQEw3xzkVz5Zx4POHBgwcP3mm8qWNzglMFGWmsw4MHDx68f69flSx0viCUSIgSSUp6QcCDBw8evJr3aNIwVQ82lVAkFk1ZgQ8PHjx48EYazVOJQKJAroIZ+xXCgwcP3svxOpOCDQPYK6v4No1pePDgwYN3Gm9q0+4ckFYFOn0P8YeHBw8evJfgJQakVwLU2cDtHOqW1dnw4MGDB6/keaeK8XQh34nU2UCABw8ePHh9g8rEwLNzKNrZEChL0ODBgwcPXhSvs/Dc0AhOD34v/V148ODBg1eCl37BJrGBVzUEEg36xDnw4MGDB68GL7Fpdzap02CJpvzhvwUPHjx48E7PBasK8wRSZ+IzNfuM/wrhwYMHD155QzlRvN/xpal4YxoePHjw4FXEIf6PczYnMonrJJrg8ODBgwfvfD8zHdB0Q6CqaT716ykrzOHBgwcP3ul5XlUgruy72xoC6cVaNlWABw8ePHgleFWN4A2LY9tQOp6wwIMHDx688oI93WjubBpMNa/Hui3w4MGD90K8sU040EBIL5TOmMCDBw8evGPX3LBRT2346WFporHw63N48ODBg1fyPku6iZxIgtKD5XihHU4S4cGDBw9eNqFIDHsTG3hiwbUmLPDgwYMHLzqMTWzI6WBVFdStGeDUNBwePHjw4I00TxPFctU5iThcKtLhwYMHD94t8NLfTTSFVyRE8ODBgwfvNF7ni0ZTQ9eqZ0/EYcUwFh48ePAejNfZI93Q2N0wcF7X7IYHDx685+L9ACpql2Icyp6DAAAAAElFTkSuQmCC".getBytes());
//        BASE64Decoder decoder = new BASE64Decoder();
//        byte[] b = decoder.decodeBuffer(String.valueOf(erm));
//        System.out.println(erm);
//        System.out.println(b);
//
//
//
//        String dd = "iVBORw0KGgoAAAANSUhEUgAAAJQAAACUCAIAAAD6XpeDAAAC/UlEQVR42u3cy26DUAwFwPz/T6frLqoK8LENDMuIUPDc6PqB+vkEju+C46/7qbrno9/93OWABw8evJfgJYJ1NKBVGAmkK9dPxBkePHjw4NXgHb3Rqs+v3ENV0K8kI4nFBw8ePHjw7odXdU46uUgU/vDgwYMH7114iZtOBL0zqYEHDx48ePN46c08EaCqBGdD4b9iqgAPHjx4D8arOhIN6yd9vvqABA8evAfjfcPHhnvbMIyNxBYePHjw4J1+rnTQEw3xzkVz5Zx4POHBgwcP3mm8qWNzglMFGWmsw4MHDx68f69flSx0viCUSIgSSUp6QcCDBw8evJr3aNIwVQ82lVAkFk1ZgQ8PHjx48EYazVOJQKJAroIZ+xXCgwcP3svxOpOCDQPYK6v4No1pePDgwYN3Gm9q0+4ckFYFOn0P8YeHBw8evJfgJQakVwLU2cDtHOqW1dnw4MGDB6/keaeK8XQh34nU2UCABw8ePHh9g8rEwLNzKNrZEChL0ODBgwcPXhSvs/Dc0AhOD34v/V148ODBg1eCl37BJrGBVzUEEg36xDnw4MGDB68GL7Fpdzap02CJpvzhvwUPHjx48E7PBasK8wRSZ+IzNfuM/wrhwYMHD155QzlRvN/xpal4YxoePHjw4FXEIf6PczYnMonrJJrg8ODBgwfvfD8zHdB0Q6CqaT716ykrzOHBgwcP3ul5XlUgruy72xoC6cVaNlWABw8ePHgleFWN4A2LY9tQOp6wwIMHDx688oI93WjubBpMNa/Hui3w4MGD90K8sU040EBIL5TOmMCDBw8evGPX3LBRT2346WFporHw63N48ODBg1fyPku6iZxIgtKD5XihHU4S4cGDBw9eNqFIDHsTG3hiwbUmLPDgwYMHLzqMTWzI6WBVFdStGeDUNBwePHjw4I00TxPFctU5iThcKtLhwYMHD94t8NLfTTSFVyRE8ODBgwfvNF7ni0ZTQ9eqZ0/EYcUwFh48ePAejNfZI93Q2N0wcF7X7IYHDx685+L9ACpql2Icyp6DAAAAAElFTkSuQmCC";
//        Img2Base64Util.GenerateImage(dd, "E:\\发票.jpg");
//        System.out.println("success");
//        } catch (IOException e) {
//            e.printStackTrace();
//        };

    }
}
