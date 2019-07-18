package com.bwjf.createpdf.test;

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
        String dd = "iVBORw0KGgoAAAANSUhEUgAAAJQAAACUCAIAAAD6XpeDAAAC/UlEQVR42u3cy26DUAwFwPz/T6frLqoK8LENDMuIUPDc6PqB+vkEju+C46/7qbrno9/93OWABw8evJfgJYJ1NKBVGAmkK9dPxBkePHjw4NXgHb3Rqs+v3ENV0K8kI4nFBw8ePHjw7odXdU46uUgU/vDgwYMH7114iZtOBL0zqYEHDx48ePN46c08EaCqBGdD4b9iqgAPHjx4D8arOhIN6yd9vvqABA8evAfjfcPHhnvbMIyNxBYePHjw4J1+rnTQEw3xzkVz5Zx4POHBgwcP3mm8qWNzglMFGWmsw4MHDx68f69flSx0viCUSIgSSUp6QcCDBw8evJr3aNIwVQ82lVAkFk1ZgQ8PHjx48EYazVOJQKJAroIZ+xXCgwcP3svxOpOCDQPYK6v4No1pePDgwYN3Gm9q0+4ckFYFOn0P8YeHBw8evJfgJQakVwLU2cDtHOqW1dnw4MGDB6/keaeK8XQh34nU2UCABw8ePHh9g8rEwLNzKNrZEChL0ODBgwcPXhSvs/Dc0AhOD34v/V148ODBg1eCl37BJrGBVzUEEg36xDnw4MGDB68GL7Fpdzap02CJpvzhvwUPHjx48E7PBasK8wRSZ+IzNfuM/wrhwYMHD155QzlRvN/xpal4YxoePHjw4FXEIf6PczYnMonrJJrg8ODBgwfvfD8zHdB0Q6CqaT716ykrzOHBgwcP3ul5XlUgruy72xoC6cVaNlWABw8ePHgleFWN4A2LY9tQOp6wwIMHDx688oI93WjubBpMNa/Hui3w4MGD90K8sU040EBIL5TOmMCDBw8evGPX3LBRT2346WFporHw63N48ODBg1fyPku6iZxIgtKD5XihHU4S4cGDBw9eNqFIDHsTG3hiwbUmLPDgwYMHLzqMTWzI6WBVFdStGeDUNBwePHjw4I00TxPFctU5iThcKtLhwYMHD94t8NLfTTSFVyRE8ODBgwfvNF7ni0ZTQ9eqZ0/EYcUwFh48ePAejNfZI93Q2N0wcF7X7IYHDx685+L9ACpql2Icyp6DAAAAAElFTkSuQmCC";
        Img2Base64Util.GenerateImage(dd, "E:\\发票.jpg");
        System.out.println("success");
    }
}
