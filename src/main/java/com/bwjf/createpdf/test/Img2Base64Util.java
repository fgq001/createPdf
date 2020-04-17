package com.bwjf.createpdf.test;

/**
 * Created by admin on 2019/7/18.
 */

import com.itextpdf.text.pdf.PdfEncodings;
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


    /**
     *      byte数组字符串生成pdf文件路径
     * @param b1        byte数组
     * @param filePdfPath   pdf文件路径
     * @return
     * @throws IOException
     */
    public static boolean CreatePdfByByte( byte[] b1, String filePdfPath) throws IOException {
        if (b1 == null) // 图像数据为空
            return false;
        OutputStream out = null;
        try {
            File temPdfFile = new File(filePdfPath);
            out = new FileOutputStream(temPdfFile);
            byte[] b = b1;
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
    /**
     * Java 文件转二进制
     * @param filePath
     * @return
     * @throws IOException
     */
    public static byte[] fileToByte(String filePath) throws IOException {
        byte[] bytes = null;
        FileInputStream fis = null;
        try {
            File file = new File(filePath);
            fis = new FileInputStream(file);
            bytes = new byte[(int) file.length()];
            fis.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            fis.close();
        }
        return bytes;
    }

    /**
     *
     * @Title: encodeBase64File @Description: 根据文件路径进行base64加密 @param @param
     *         path @param @return @param @throws Exception 设定文件 @return String
     *         返回类型 @throws
     */
    public static String encodeBase64File(String path) throws Exception {
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return new BASE64Encoder().encode(buffer).replaceAll("[\\s*\t\n\r]", "");

    }


    public static void main(String[] args) {
//        String str = Img2Base64Util.GetImageStr("E:/aaaa/1.ofd");
//        String dd = "iVBORw0KGgoAAAANSUhEUgAAAHQAAAB0CAIAAADb+IFwAAABpUlEQVR42u3dUXLCMAwEUN//0uEMibWKFZ4+O1OIXzpsvYZ2XSY2CwFcuAYuXLgG7nG4KzBVz3X3cV5bF1y4cOE+wN16US/CLQuZznXBhQsX7ibuXYhEsNx9/M51wYULF+4k3HiZAhcuXLh/jpu+Brhw4cKditsZIJ24n2rF4MKFOxo3cZB3wtc/e/oLFy7ccbgnFCjpUIqvES5cuHAbipt0mVJVuFRdP1y4cOFWBlpZedxYylTdsEhxAxcuXLhPvjmMXoWbvja4cOHCTeEmSpPOcr2zAIILFy7cykDrPFhM37zjNhFw4cKFWwh6wps5xuzQ4MKF+7e4O0H3VpnSeQAKFy5cuKv5AydVobSzEej8QYELFy7cjkBL/6I+ZXMBFy5cuFfhG/Eih3fhsrwq9CKBBhcuXLgPypF0OJwQjHDhwoXbjdsZXIkb81oAwoULF25DcZMuzk8OYbhw4cJdH/iD8J1wRx9QwoULF+4mbtUiE4X3+ECDCxfuaNzIRQSK6s4NC1y4cOFef/5/IhK4Y05/4cKFOw7X7A9cuHANXLhwDdzX5gftJbZzydpYAwAAAABJRU5ErkJggg==";
//        String dd = "iVBORw0KGgoAAAANSUhEUgAAAHQAAAB0CAIAAADb+IFwAAABpUlEQVR42u3dUXLCMAwEUN//0uEMibWKFZ4+O1OIXzpsvYZ2XSY2CwFcuAYuXLgG7nG4KzBVz3X3cV5bF1y4cOE+wN16US/CLQuZznXBhQsX7ibuXYhEsNx9/M51wYULF+4k3HiZAhcuXLh/jpu+Brhw4cKditsZIJ24n2rF4MKFOxo3cZB3wtc/e/oLFy7ccbgnFCjpUIqvES5cuHAbipt0mVJVuFRdP1y4cOFWBlpZedxYylTdsEhxAxcuXLhPvjmMXoWbvja4cOHCTeEmSpPOcr2zAIILFy7cykDrPFhM37zjNhFw4cKFWwh6wps5xuzQ4MKF+7e4O0H3VpnSeQAKFy5cuKv5AydVobSzEej8QYELFy7cjkBL/6I+ZXMBFy5cuFfhG/Eih3fhsrwq9CKBBhcuXLgPypF0OJwQjHDhwoXbjdsZXIkb81oAwoULF25DcZMuzk8OYbhw4cJdH/iD8J1wRx9QwoULF+4mbtUiE4X3+ECDCxfuaNzIRQSK6s4NC1y4cOFef/5/IhK4Y05/4cKFOw7X7A9cuHANXLhwDdzX5gftJbZzydpYAwAAAABJRU5ErkJggg==";
        String dd = "iVBORw0KGgoAAAANSUhEUgAAAHQAAAB0CAIAAADb IFwAAABpUlEQVR42u3dUXLCMAwEUN//0uEMibWKFZ4 O1OIXzpsvYZ2XSY2CwFcuAYuXLgG7nG4KzBVz3X3cV5bF1y4cOE wN16US/CLQuZznXBhQsX7ibuXYhEsNx9/M51wYULF 4k3HiZAhcuXLh/jpu Brhw4cKditsZIJ24n2rF4MKFOxo3cZB3wtc/e/oLFy7ccbgnFCjpUIqvES5cuHAbipt0mVJVuFRdP1y4cOFWBlpZedxYylTdsEhxAxcuXLhPvjmMXoWbvja4cOHCTeEmSpPOcr2zAIILFy7cykDrPFhM37zjNhFw4cKFWwh6wps5xuzQ4MKF 7e4O0H3VpnSeQAKFy5cuKv5AydVobSzEej8QYELFy7cjkBL/6I ZXMBFy5cuFfhG/Eih3fhsrwq9CKBBhcuXLgPypF0OJwQjHDhwoXbjdsZXIkb81oAwoULF25DcZMuzk8OYbhw4cJdH/iD8J1wRx9QwoULF 4mbtUiE4X3 ECDCxfuaNzIRQSK6s4NC1y4cOFef/5/IhK4Y05/4cKFOw7X7A9cuHANXLhwDdzX5gftJbZzydpYAwAAAABJRU5ErkJggg==";

        boolean str = false;
        try {
            str = Img2Base64Util.GenerateImage(dd,"E:/aaaa/11.png");
            str = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(str);
    }
}
