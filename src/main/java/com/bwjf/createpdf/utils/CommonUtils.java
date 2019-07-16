package com.bwjf.createpdf.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.UUID;

public class CommonUtils
{
  public static void nullConverNullString(Object obj)
    throws Exception
  {
    if (obj != null)
    {
      Class classz = obj.getClass();

      Field[] fields = classz.getDeclaredFields();

      for (Field field : fields) {
        Type t = field.getGenericType();
        if (!t.toString().equals("boolean")) {
          Method m = classz.getMethod("get" + change(field.getName()), new Class[0]);
          Object name = m.invoke(obj, new Object[0]);
          if (name == null) {
            Method mtd = classz.getMethod(
              "set" + change(field.getName()), 
              new Class[] { String.class });
            mtd.invoke(obj, new Object[] { "" });
          }
        }
      }
    }
  }

  public static String change(String src)
  {
    if (src != null) {
      StringBuffer sb = new StringBuffer(src);
      sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
      return sb.toString();
    }
    return null;
  }

  public static String getUUID()
  {
    UUID uuid = UUID.randomUUID();
    String str = uuid.toString();
    String uuidStr = str.replace("-", "");
    return uuidStr;
  }
}