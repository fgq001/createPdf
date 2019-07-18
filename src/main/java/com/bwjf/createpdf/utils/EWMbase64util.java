package com.bwjf.createpdf.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class EWMbase64util {

	
	
	/**
	 * * 对字节数组字符串进行Base64解码并生成图片，并将图片保存到指定位置      
	 * * @param imgStr          
	 *  转换为图片的字符串      
	 * * @param imgCreatePath     将64编码生成图片的路径      
	 * * @return  
	 *    
	 */
	public static boolean generateImage(String imgStr, String imgCreatePath) {
		if (imgStr == null) {
			// 图像数据为空
			return false;
		}

		try {
			BASE64Decoder decoder = new BASE64Decoder();
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 将图片保存到指定位置
			OutputStream out = new FileOutputStream(imgCreatePath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	/**
	 * 
	 * @Title: getPdfstream @Description: file文件转 流 并进行base64加密 @param @param
	 *         blFile @param @return 设定文件 @return String 返回类型 @throws
	 */
	public static String getPdfstream(MultipartFile blFile) {
		String binary = null;
		try {
			byte[] pdfbyte = blFile.getBytes();
			BASE64Encoder encoder = new BASE64Encoder();
			binary = encoder.encodeBuffer(pdfbyte).trim().replaceAll("[\\s*\t\n\r]", "");
			return binary;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
			}
		}
		return image;
	}

	public static String creatRrCode(String contents, int wi, int he) {
		String binary = null;
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		hints.put(EncodeHintType.MARGIN, 0);
		BitMatrix bitMatrix;
		try {
			bitMatrix = new QRCodeWriter().encode(contents, BarcodeFormat.QR_CODE, 120, 120, hints);
			int[] rec = bitMatrix.getEnclosingRectangle();
			int resWidth = rec[2] + 1;
			int resHeight = rec[3] + 1;
			BitMatrix resMatrix = new BitMatrix(resWidth, resHeight);
			resMatrix.clear();
			for (int i = 0; i < resWidth; i++) {
				for (int j = 0; j < resHeight; j++) {
					if (bitMatrix.get(i + rec[0], j + rec[1])) {
						resMatrix.set(i, j);
					}
				}
			}
			// 2
			int width = resMatrix.getWidth();
			int height = resMatrix.getHeight();
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					image.setRGB(x, y, resMatrix.get(x, y) == true ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
				}
			}
			// ImageIO.write(image,"png", new File("D:/AA/test.png"));
			// 转换成png格式的IO流
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ImageIO.write(image, "png", out);
			byte[] bytes = out.toByteArray();

			// 2、将字节数组转为二进制
			BASE64Encoder encoder = new BASE64Encoder();
			binary = encoder.encodeBuffer(bytes).trim().replaceAll("[\\s*\t\n\r]", "");
			System.out.println(binary);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return binary;
	}

	// 解密
	public static String getFromBase64(String s) {
		byte[] b = null;
		String result = null;
		if (s != null) {
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				b = decoder.decodeBuffer(s);
				result = new String(b, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static void main(String[] args) {
		try {

			String ewm = "iVBORw0KGgoAAAANSUhEUgAAAJQAAACUCAIAAAD6XpeDAAAC/UlEQVR42u3cy26DUAwFwPz/T6frLqoK8LENDMuIUPDc6PqB+vkEju+C46/7qbrno9/93OWABw8evJfgJYJ1NKBVGAmkK9dPxBkePHjw4NXgHb3Rqs+v3ENV0K8kI4nFBw8ePHjw7odXdU46uUgU/vDgwYMH7114iZtOBL0zqYEHDx48ePN46c08EaCqBGdD4b9iqgAPHjx4D8arOhIN6yd9vvqABA8evAfjfcPHhnvbMIyNxBYePHjw4J1+rnTQEw3xzkVz5Zx4POHBgwcP3mm8qWNzglMFGWmsw4MHDx68f69flSx0viCUSIgSSUp6QcCDBw8evJr3aNIwVQ82lVAkFk1ZgQ8PHjx48EYazVOJQKJAroIZ+xXCgwcP3svxOpOCDQPYK6v4No1pePDgwYN3Gm9q0+4ckFYFOn0P8YeHBw8evJfgJQakVwLU2cDtHOqW1dnw4MGDB6/keaeK8XQh34nU2UCABw8ePHh9g8rEwLNzKNrZEChL0ODBgwcPXhSvs/Dc0AhOD34v/V148ODBg1eCl37BJrGBVzUEEg36xDnw4MGDB68GL7Fpdzap02CJpvzhvwUPHjx48E7PBasK8wRSZ+IzNfuM/wrhwYMHD155QzlRvN/xpal4YxoePHjw4FXEIf6PczYnMonrJJrg8ODBgwfvfD8zHdB0Q6CqaT716ykrzOHBgwcP3ul5XlUgruy72xoC6cVaNlWABw8ePHgleFWN4A2LY9tQOp6wwIMHDx688oI93WjubBpMNa/Hui3w4MGD90K8sU040EBIL5TOmMCDBw8evGPX3LBRT2346WFporHw63N48ODBg1fyPku6iZxIgtKD5XihHU4S4cGDBw9eNqFIDHsTG3hiwbUmLPDgwYMHLzqMTWzI6WBVFdStGeDUNBwePHjw4I00TxPFctU5iThcKtLhwYMHD94t8NLfTTSFVyRE8ODBgwfvNF7ni0ZTQ9eqZ0/EYcUwFh48ePAejNfZI93Q2N0wcF7X7IYHDx685+L9ACpql2Icyp6DAAAAAElFTkSuQmCC";



			// 对文件流进行解密
//			boolean generateImage = EWMbase64util.generateImage(pdfstream, "E:\\PDFFile\\PDFtemplate\\Jiangsu.pdf");

//			 System.out.println(generateImage);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
