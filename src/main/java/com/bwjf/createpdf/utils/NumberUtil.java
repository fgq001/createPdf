package com.bwjf.createpdf.utils;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberUtil
{
  public static String double2Str(String d)
  {
    String str = new BigDecimal(d).setScale(2, 4).toPlainString();
    return str;
  }

  public static String double2Str(String d, int l)
  {
    String str = new BigDecimal(d).setScale(l, 4).toPlainString();
    String res = "";
    for (int i = str.length() - 1; i >= 0; i--) {
      char c = str.charAt(i);
      if (c != '0') {
        if (c == '.') {
          res = str.substring(0, i);
          break;
        }
        res = str.substring(0, i + 1);
        break;
      }
    }

    return res;
  }

  public static String double2Str(double d, int l)
  {
    String str = new BigDecimal(d).setScale(l, 4).toPlainString();
    String res = "";
    for (int i = str.length() - 1; i >= 0; i--) {
      char c = str.charAt(i);
      if (c != '0') {
        if (c == '.') {
          res = str.substring(0, i);
          break;
        }
        res = str.substring(0, i + 1);
        break;
      }
    }

    return res;
  }

  public static String doubleFmt(String numStr)
  {
    String d = "";
    if ((numStr != null) && (!"".equals(numStr)))
      d = new BigDecimal(numStr).setScale(2, 4).toPlainString();
    else {
      d = "0";
    }

    return d;
  }

  public static String absAndFmt(String numStr)
  {
    double d = 0.0D;
    if ((numStr != null) && (!numStr.equals(""))) {
      d = Double.parseDouble(numStr);
      if (d < 0.0D) {
        d = -d;
      }
    }
    return double2Str(d, 2);
  }

  public static String doubleFmt(Double numD)
  {
    String d = new BigDecimal(numD.doubleValue()).setScale(2, 4).toPlainString();

    return d;
  }

  public static int toInteger(String numStr)
  {
    if ((numStr != null) && (!"".equals(numStr))) {
      return Integer.valueOf(numStr).intValue();
    }
    return -1;
  }

  public static String NumberFormat(Double number) {
    DecimalFormat myformat = new DecimalFormat("#0.00");
    if (number == null) {
      return "0.00";
    }
    return myformat.format(number);
  }

  public static String double3Str(String d, int l)
  {
    String str = new BigDecimal(d).setScale(l, 4).toPlainString();
    String res = "";
    for (int i = str.length() - 1; i >= 0; i--) {
      char c = str.charAt(i);
      if (c != '0') {
        if (c == '.') {
          res = str.substring(0, i);
          res = res + ".00";
          break;
        }
        res = str.substring(0, i + 1);
        break;
      }
    }

    return res;
  }

  public static String oracleNumberFormat(String d)
  {
    if ((d != null) && (d.startsWith("."))) {
      d = "0" + d;
    }
    if ((d != null) && (d.startsWith("-."))) {
      d = d.replace("-.", "-0.");
    }
    return d;
  }

  public static boolean isNumber(String str)
  {
    try
    {
      Double.parseDouble(str);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

  public static String toBhs(String hsje, String sl, int len)
  {
    if ((!isNumber(hsje)) && (!isNumber(sl))) {
      return "";
    }
    double d_hsje = Double.parseDouble(hsje);
    double d_sl = Double.parseDouble(sl);
    double d_bhsje = d_hsje / (1.0D + d_sl);
    return double2Str(d_bhsje, len);
  }

  public static String formatToNumber(BigDecimal obj) {
		DecimalFormat df = new DecimalFormat("#.00");
		if(obj.compareTo(BigDecimal.ZERO)==0) {
			return "0.00";
		}else if(obj.compareTo(BigDecimal.ZERO)>0&&obj.compareTo(new BigDecimal(1))<0){
			return "0"+df.format(obj).toString();
		}else {
			return df.format(obj).toString();
		}
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



  public static String[] toBhs2(String hsje, String sl, int len)
  {
    if ((!isNumber(hsje)) && (!isNumber(sl))) {
      return new String[] { "", "" };
    }
    double d_hsje = Double.parseDouble(hsje);
    double d_sl = Double.parseDouble(sl);
    double d_bhsje = d_hsje / (1.0D + d_sl);
    double se = d_bhsje * d_sl;
    return new String[] { double2Str(d_bhsje, len), double2Str(se, 2) };
  }

  public static String Tostr(String str) {
//		String str = "dsfdsafdsafdsafas";
    // 字符串长度
    int strlenth = str.length();
    // 需要加空格数量
    int blankcount = 0;
    // 判断字符串长度
    if (strlenth <= 5) {
      blankcount = 0;
    } else {
      blankcount = strlenth % 5 > 0 ? strlenth / 5 : str.length() / 5 - 1; // 需要加空格数量
    }
    // 插入空格
    if (blankcount > 0) {
      for (int i = 0; i < blankcount; i++) {
        str = str.substring(0, (i + 1) * 5 + i) + " " + str.substring((i + 1) * 5 + i, strlenth + i);
      }
    } else {
      System.out.println("输入的字符串不多于4位，不需要添加空格");
    }
    System.out.println(str);
    return str;
  }

  public static void main(String[] args) {
    /*String ss = double3Str("-100", 6);
    String dd = double2Str("11", 2);
    String dDd = double3Str("11", 2);
    double e = 1.2;
    System.out.println(ss);
    System.out.println(dDd);*/
    String s111 = null;

    String skm = "<fpdm>050003521106</fpdm><skm>03*6-108-17>101<410%2B156-1240-3-*><23><93-8*87-0848>3>557236*718</-42-74>9>131-<>-/*%2B2>6*3<86<801<4791977731>2>//</skm>";
    String regex = "<skm>(.*?)</skm>";
    List<String> list = new ArrayList<String>();
    List<String> extvounoLists = new ArrayList<String>();
    Pattern pattern = Pattern.compile(regex);
    Matcher m = pattern.matcher(skm);
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

    System.out.println("str1: "+str1);
    s111 = str1.replaceAll("<","&lt;").replaceAll(">","&gt;").replaceAll("%2B","+");
    System.out.println("str22: "+s111);


  }

  public static String strSkm(String strSmk){
    String s111 = null;
    String regex = "<skm>(.*?)</skm>";
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