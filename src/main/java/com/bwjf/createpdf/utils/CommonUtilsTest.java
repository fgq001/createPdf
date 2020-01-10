package com.bwjf.createpdf.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CommonUtilsTest {


    /**
     * 生成发票流水号
     *
     * @param xsfNsrsbh
     * @return
     */
    public static String getFpqqlsh(String xsfNsrsbh) {
        StringBuffer sb = new StringBuffer();
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        String fpqqlsh = sdf.format(new Date());
        String EndNum = getCharAndNumr(4);
        xsfNsrsbh = xsfNsrsbh.substring(xsfNsrsbh.length() - 4, xsfNsrsbh.length());
        sb.append(fpqqlsh).append(EndNum).append(xsfNsrsbh);
        return sb.toString();

    }


    /**
     * 方法1：生成随机数字和字母组合
     *
     * @param length
     * @return
     */

    public static String getCharAndNumr(int length) {
        Random random = new Random();
        StringBuffer valSb = new StringBuffer();
        String charStr = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int charLength = charStr.length();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charLength);
            valSb.append(charStr.charAt(index));
        }
        return valSb.toString();
    }


    public static void main(String[] args) {
        String str = getFpqqlsh("DJ19092909S");
        System.out.println(str);
    }
}
