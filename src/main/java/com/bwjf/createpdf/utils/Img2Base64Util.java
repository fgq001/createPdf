package com.bwjf.createpdf.utils;

/**
 * Created by admin on 2019/7/18.
 */

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * 将图片转换为Base64
 * 将base64编码字符串解码成img图片
 */
public class Img2Base64Util {


    public static String GetImageStr(String imgPath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        String imgFile = imgPath;// 待处理的图片
        InputStream in = null;
        byte[] data = null;
        String encode = null; // 返回Base64编码过的字节数组字符串
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        try {
            // 读取图片字节数组
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            encode = encoder.encode(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return encode;
    }



    public static boolean GenerateImage(String imgData, String imgFilePath) throws IOException { // 对字节数组字符串进行Base64解码并生成图片
        if (imgData == null) // 图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        OutputStream out = null;
        try {
            out = new FileOutputStream(imgFilePath);
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgData);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            out.write(b);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
            return true;
        }
    }


    public static void main(String[] args) throws IOException {
//        String imageStr = Img2Base64Util.GetImageStr("D://下载/企鹅.jpg");
//        System.out.println(imageStr);
//        String dd = "iVBORw0KGgoAAAANSUhEUgAAAJQAAACUCAIAAAD6XpeDAAADAklEQVR42u3aW26EMBAEwNz/0psTRAHcPZil FwhsF1eeR78/BSuzx/XkfuP/H72XUeec3ZeR8aQeu/oBQ8ePHgvwfssXKkFnQRoL/oK9unxwIMHDx68y3ipwe0WHLXP/kYABQ8ePHjwno23ErCkwNoA8ODBgwfvvXjtgnW7SJ3aWPDgwYMHby 8xmGeAmsHO6ng6PFdBXjw4MH7YrxGsdjvQ4sODx4kePBuaTxOHtSTHxG153h6TeDBgwcP3uU1aU 4XRBYSaIb751cT3jw4MGDl8FrFKMbMO0ib2MusXWABw8ePHj/Pr RCE82Y1ee2dhMk/fAgwcPHrzrePXi6WDif1fRoL2J4cGDBw/edbxGQtoY0A4F6DZArMANDx48ePAiSfrkxz Nd 0QTN1WmIYHDx48eJEDPFUUbp/H7QBndPzw4MGDBy ClwpYGs9sBCBtDHjw4MGDty9eI6lsN3LvCjQmgzt48ODBg5c5vxuJbfvQngw0UuOsNIHhwYMHD94Y3spzGol2CntlLql3HVofePDgwYN3Ga d4Lcn39gEqeBiJcCBBw8ePHhdvJ0T8DZSuziwlJjDgwcPHrzIOsQKpoWDurHo7YR6cpzw4MGDB 9cP28ycJg88NuF8gZq5d8GDx48eC/EmyxGtxPbdkCxW1AGDx48ePAyePUqQCjoSBXNU9ijhWl48ODBgxcpRjeCkcnJt8dfCUBS/0J48ODBg3cZ766PfFYWq70JUoX12CaGBw8ePHhb5Xmpga4c8u1icWpjbRdtwoMHD94X4zUWa4eG7Q7F98aHT/DgwYMHb66YmwpeJgu77WZpPZCBBw8ePHh3nLWV5mS7QdrYWCmARpMAHjx48ODlC6 TB/JdTeNGUHZbVwEePHjwXo7XSFrbSWhqw6U26OgFDx48ePC2wpsES22myXktFSvgwYMHD97j8BrN0sY9jUL84wMWePDgwXso3mTCm0qWJwOfRrN3u2YsPHjw4H0x3g410slBtz8uSjVgH1PghgcPHry98X4BxAy5JBgfwFkAAAAASUVORK5CYII=";
        String dd = "iVBORw0KGgoAAAANSUhEUgAAAHQAAAB0CAIAAADb+IFwAAABpUlEQVR42u3dUXLCMAwEUN//0uEMibWKFZ4+O1OIXzpsvYZ2XSY2CwFcuAYuXLgG7nG4KzBVz3X3cV5bF1y4cOE+wN16US/CLQuZznXBhQsX7ibuXYhEsNx9/M51wYULF+4k3HiZAhcuXLh/jpu+Brhw4cKditsZIJ24n2rF4MKFOxo3cZB3wtc/e/oLFy7ccbgnFCjpUIqvES5cuHAbipt0mVJVuFRdP1y4cOFWBlpZedxYylTdsEhxAxcuXLhPvjmMXoWbvja4cOHCTeEmSpPOcr2zAIILFy7cykDrPFhM37zjNhFw4cKFWwh6wps5xuzQ4MKF+7e4O0H3VpnSeQAKFy5cuKv5AydVobSzEej8QYELFy7cjkBL/6I+ZXMBFy5cuFfhG/Eih3fhsrwq9CKBBhcuXLgPypF0OJwQjHDhwoXbjdsZXIkb81oAwoULF25DcZMuzk8OYbhw4cJdH/iD8J1wRx9QwoULF+4mbtUiE4X3+ECDCxfuaNzIRQSK6s4NC1y4cOFef/5/IhK4Y05/4cKFOw7X7A9cuHANXLhwDdzX5gftJbZzydpYAwAAAABJRU5ErkJggg==";
        Img2Base64Util.GenerateImage(dd, "E:\\发票二维码1222.png");
        System.out.println("success");
    }
}
