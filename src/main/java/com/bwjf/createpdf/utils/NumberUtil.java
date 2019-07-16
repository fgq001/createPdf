package com.bwjf.createpdf.utils;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;

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
  
  public static void main(String[] args) {
    String ss = double3Str("-100", 6);
    String dd = double2Str("11", 2);
    String dDd = double3Str("11", 2);
    
    double e = 1.2;
    
    
    System.out.println(ss);
    System.out.println(dDd);
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
}