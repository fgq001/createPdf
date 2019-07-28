package com.bwjf.createpdf.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test2 {
    public static void main(String[] args) {
        String str = "北京神鼎飞丹砂海淀 hello world!";
        String str1 = "阿裕食品桂花园子克阿裕食品桂花阿裕食品桂花园子200克";
        System.out.println("fdsfsd = "+str1.trim().length());
        float dd = test2.StrCount(str1);

        System.out.println(dd);
    }

    public static float StrCount(String str){
        int count =0;
        Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
        char c[] = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            Matcher matcher = pattern.matcher(String.valueOf(c[i]));
            if (matcher.matches()){
                count++;
            }
        }
//        System.out.println("汉字数量为 = "+ count);
        int strSum = str.trim().length();
//        System.out.println("字符串总数为 = "+strSum);
        int notStr = strSum - count;
//        System.out.println("非字符串总数为 = "+notStr);
        float ff = count*8+notStr*4;
//        System.out.println("fffff = "+ff);
        return ff;

    }

}
