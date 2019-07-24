package com.bwjf.createpdf.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test2 {
    public static void main(String[] args) {
        String s112 = "</jqbh><skm>03145<+--<*/>7>2<2484884*+</84<1**885<0<*64966*-9<>70395111188-639</<+0<1+8+0/075/>-075-//1>*601>47919703/57859-</skm><jym>145";
        System.out.println("传递的smk  s112 =  "+s112);
        String s113 = test2.strSkm(s112);
        System.out.println(s113);
    }
    public static String strSkm(String strSmk){
        String s = "<skm>03/9 67/1 <24-73 85 22<520005<7/ 5 8<< 87*<4 300 <>41>0<6010->9466 8/ 6491 745>*170>2*2/7<>32*01>47919*/4>2 >>/2</skm>";

//
//        String s11 = null;
//        s11 = "03145&lt;+--&lt;*/&gt;7&gt;2&lt;2484884*+&lt;/84&lt;1**885&lt;0&lt;*64966*-9&lt;&gt;70395111188-639&lt;/&lt;+0&lt;1+8+0/075/&gt;-075-//1&gt;*601&gt;47919703/57859-";
//        System.out.println("原始："+s11);
//
//        String s12 = "03145&lt;+--&lt;*/&gt;7&gt;2&lt;2484884*+&lt;/84&lt;1**885&lt;0&lt;*64966*-9&lt;&gt;70395111188-639&lt;/&lt;+0&lt;1+8+0/075/&gt;-075-//1&gt;*601&gt;47919703/57859-";
//        String s13 = s12.replace("&lt;","<").replaceAll("&gt;",">");
//        System.out.println("替换："+s13);


        String s111 = null;
        String regex = "<skm>(.*?)</skm>";
//        System.out.println(regex);
        List<String> list = new ArrayList<String>();
        List<String> extvounoLists = new ArrayList<String>();
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(strSmk);
        while (m.find()) {
            int i = 1;
            list.add(m.group(i));
            i++;
        }
        String str1 = null;
        for (String str : list) {
            str1 = str;
            String[] strs = str.split("-");
            String strss = strs[strs.length-1];
            extvounoLists.add(strs[strs.length-1]);
        }
//        System.out.println("截取去掉<skm>  str1  =  "+str1);
        s111 = str1.replaceAll("<","&lt;").replaceAll(">","&gt;");
//        System.out.println("替换后的<skm>值  s111  =  "+s111);

        String s221 = "<skm>"+str1+"</skm>";
//        System.out.println("s221 = "+s221);
        String s222 = "<skm>"+s111+"</skm>";
//        System.out.println("s222 = "+s222);

//        String aa="abcdefg";
//        String bb = "bcd";
//        String cc = "dcb";
//        String replaceStr  = aa.replace(bb, cc);
//        System.out.println("输出结果是"+replaceStr);

        String s333 =strSmk.replace(s221,s222);
//        System.out.println("s333 = "+s333);
        return s333;
    }

    public static String strEwm(String strSmk){
        String s111 = null;
        String regex = "<ewm>(.*?)</ewm>";
        List<String> list = new ArrayList<String>();
        List<String> extvounoLists = new ArrayList<String>();
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(strSmk);
        while (m.find()) {
            int i = 1;
            list.add(m.group(i));
            i++;
        }
        String str1 = null;
        for (String str : list) {
            str1 = str;
            String[] strs = str.split("-");
            String strss = strs[strs.length-1];
            extvounoLists.add(strs[strs.length-1]);
        }
//        System.out.println("截取去掉<skm>  str1  =  "+str1);
        s111 = str1.replaceAll("<","&lt;").replaceAll(">","&gt;");
//        System.out.println("替换后的<skm>值  s111  =  "+s111);

        String s221 = "<ewm>"+str1+"</ewm>";
//        System.out.println("s221 = "+s221);
        String s222 = "<ewm>"+s111+"</ewm>";
//        System.out.println("s222 = "+s222);
        String s333 =strSmk.replace(s221,s222);
//        System.out.println("s333 = "+s333);
        return s333;
    }
}
