package com.bwjf.createpdf.test;

import cn.hutool.extra.qrcode.BufferedImageLuminanceSource;
import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

//import java.util.Base64;

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

	/**
	 * 根据内容生成二维码
	 * @param contents
	 * @param wi
	 * @param he
	 * @return
	 */
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


	/**
	 * base64解密
	 * @param data
	 * @return
	 */
	public static byte[] Base64Decoder(String data) throws IOException {
			// BASE64解密
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] bytes = decoder.decodeBuffer(data);
			System.out.println("BASE64解密：" + new String(bytes));
			return bytes;
	}

	/**
	 * base64加密
	 * @return
	 * @throws IOException
	 */
	public static String Base64Encoder(byte[] bytes) throws IOException {
		// BASE64加密
		BASE64Encoder encoder = new BASE64Encoder();
		String dataResult = "";
		dataResult = encoder.encodeBuffer(bytes).trim().replaceAll("[\\s*\t\n\r]", "");
//		String dataResult
//		dataResult = encoder.encode(data.getBytes());
//		System.out.println("BASE64加密：" + data);
		return dataResult;
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

	/**
	 * 将base64编码转换成PDF
	 *
	 * @param base64sString
	 *            1.使用BASE64Decoder对编码的字符串解码成字节数组
	 *            2.使用底层输入流ByteArrayInputStream对象从字节数组中获取数据；
	 *            3.建立从底层输入流中读取数据的BufferedInputStream缓冲输出流对象；
	 *            4.使用BufferedOutputStream和FileOutputSteam输出数据到指定的文件中
	 */
	static void base64StringToPDF(String base64sString) {
		BufferedInputStream bin = null;
		FileOutputStream fout = null;
		BufferedOutputStream bout = null;
		try {
			// 将base64编码的字符串解码成字节数组
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] bytes = decoder.decodeBuffer(base64sString);
			// apache公司的API
			// byte[] bytes = Base64.decodeBase64(base64sString);
			// 创建一个将bytes作为其缓冲区的ByteArrayInputStream对象
			ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
			// 创建从底层输入流中读取数据的缓冲输入流对象
			bin = new BufferedInputStream(bais);
			// 指定输出的文件
			File file = new File("D:\\zht\\test.pdf");
			// 创建到指定文件的输出流
			fout = new FileOutputStream(file);
			// 为文件输出流对接缓冲输出流对象
			bout = new BufferedOutputStream(fout);

			byte[] buffers = new byte[1024];
			int len = bin.read(buffers);
			while (len != -1) {
				bout.write(buffers, 0, len);
				len = bin.read(buffers);
			}
			// 刷新此输出流并强制写出所有缓冲的输出字节，必须这行代码，否则有可能有问题
			bout.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bin.close();
				fout.close();
				bout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}



	/**
	 * 将base64编码转换成PDF
	 *
	 * @param base64sString
	 *            1.使用BASE64Decoder对编码的字符串解码成字节数组
	 *            2.使用底层输入流ByteArrayInputStream对象从字节数组中获取数据；
	 *            3.建立从底层输入流中读取数据的BufferedInputStream缓冲输出流对象；
	 *            4.使用BufferedOutputStream和FileOutputSteam输出数据到指定的文件中
	 */
	public synchronized static String base64ToPDF(String base64sString ,String filename) {
		String code  = "";
		BufferedInputStream bin = null;
		FileOutputStream fout = null;
		BufferedOutputStream bout = null;
		PDDocument pdDocument = null;
		try {
			// 将base64编码的字符串解码成字节数组
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] bytes = decoder.decodeBuffer(base64sString);
			// apache公司的API
			// byte[] bytes = Base64.decodeBase64(base64sString);
			// 创建一个将bytes作为其缓冲区的ByteArrayInputStream对象
			ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
			// 创建从底层输入流中读取数据的缓冲输入流对象
			bin = new BufferedInputStream(bais);
			// 指定输出的文件
			File file = new File(filename);
			// 创建到指定文件的输出流
			fout = new FileOutputStream(file);
			// 为文件输出流对接缓冲输出流对象
			bout = new BufferedOutputStream(fout);

			byte[] buffers = new byte[1024];
			int len = bin.read(buffers);
			while (len != -1) {
				bout.write(buffers, 0, len);
				len = bin.read(buffers);
			}
			// 刷新此输出流并强制写出所有缓冲的输出字节，必须这行代码，否则有可能有问题
			bout.flush();
			code = "success";
			pdDocument = PDDocument.load(file);
		} catch (IOException e) {
			e.printStackTrace();
			code = "failure";
		} finally {
			try {
				pdDocument.close();
				bin.close();
				fout.close();
				bout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return code;
	}


	public static String JiexiEWM(String filename) {
		String code  = "";

		try {
			MultiFormatReader formatReader = new MultiFormatReader();
//			File file = new File("D:/tmp/QQ截图20190415085210.png");
			File file = new File(filename);
			BufferedImage image = ImageIO.read(file);

			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));

			// 定义二维码参数
			HashMap hints = new HashMap();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
			hints.put(DecodeHintType.PURE_BARCODE, Boolean.TRUE);
			Result result = formatReader.decode(binaryBitmap,hints);

//			System.out.println("解析结果:"+result.toString());
//			System.out.println("二维码格式类型:"+result.getBarcodeFormat());
//			System.out.println("二维码文本内容:"+result.getText());
			code = result.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return code;
	}


	/**
	 * 解析二维码
	 * @param image 读入的二维码图片
	 * @return
	 */
	public static String decodeQrCode(BufferedImage image) {

		String qrCodeContent = null;
		try {
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			Binarizer binarizer = new HybridBinarizer(source);
			BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
			Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
			hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
			Result result = new MultiFormatReader().decode(binaryBitmap, hints);// 对图像进行解码
			qrCodeContent= result.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qrCodeContent;
	}



	public static void main(String[] args) {
		try {
			base64StringToPDF("JVBERi0xLjQKJeLjz9MKMSAwIG9iago8PC9SZWZlcmVuY2VbPDwvRGF0YSA2IDAgUi9UeXBlL1NpZ1JlZi9UcmFuc2Zvcm1QYXJhbXM8PC9UeXBlL1RyYW5zZm9ybVBhcmFtcy9WLzEuMi9QIDE+Pi9EaWdlc3RNZXRob2QvTUQ1L0RpZ2VzdExvY2F0aW9uWzAgMF0vRGlnZXN0VmFsdWUoJTu/0d6+dbf7tSyelGAgYtlJJ2nmoL2m6QU0Tjbqxq0pL1RyYW5zZm9ybU1ldGhvZC9Eb2NNRFA+Pl0vQ29udGVudHMgPDA0ODIwMTAwNWZjMTAzMzU1ZWQ0NzE1NTlkYzAwMWI0M2FiNzg5NTlkNTJmMjMzM2NkMGYxMGE1N2NkZTJlYzE2ZDU2YjNmZGVkZDE3NjczODdlYjMxZjg4NzhiNmY3NGNkNTY2YWI4OGFkNTJlZTUyNDc4Yjg3NDJhOTk1ODc3MGFiOTliZjI2MmI2ZWQ5MTM2NGFiMjQ2Yzc4Mjc5OTBmYmIzMjU0NGNhOGM2YWMxMmE1YzBhNDhlZjE4MjRjNjBkYjdhYTcwMzVjZTQ4YjU5NWQ2MmJkYzMyNDhhNTQ0OWY4YWFjNDE5ODFhZGRiZjZhOTI3NjhhZjhkMDc3ZTBhZTBjNmE3Mzc5YzEwMmQ3OWNjMjFhYmQwMjY1N2MzNzllMmJhOTViZjM2ODFmMDk1MzIzMjMwMjhiYmViNmU3NmZlODRjYThlNDA5YzY5ZWU5MGQ4YWY1Zjk1NjBlNzYwZTk3NzViYWY3OTExZjc0MGU0ZTMwNzcwZjgzZDY0ZDI2MzMxOGJhYWQ5ODUxMTMyNzY4N2ZjY2VlN2E0MDIzYjdlZjRlMjlmODQyMzBjMTk3NmJlYmJjYjE0MjkwMzIwZTdiZWRmOWY1MzU3YzIyYTRkYjA1NWFlZTI3MGJiMmU2NTI1ZWI2Y2RmZWRjODE3NDI0N2JkYmZhZGM5NzQwMWM4ZjFjNTQ+L1R5cGUvU2lnL1N1YkZpbHRlci9hZGJlLng1MDkucnNhX3NoYTEvTG9jYXRpb24oJTu/0d6+dbf7tSyelGAgYvLcreHrqiLlXZFt5BhrBH8pL05hbWUoJTu/0d6+dbf7tSyelGAgYs2DnH5VUL0/D6QYJ2p/iovyM1bxsxWuc2CBZq9x4vvzQcJY8KTUwvKNoMla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MDAwMDAgbiAKMDAwMDAzMzc3OCAwMDAwMCBuIAowMDAwMDAzNTg1IDAwMDAwIG4gCjAwMDAwMDM4NDEgMDAwMDAgbiAKMDAwMDAwNDM0NSAwMDAwMCBuIAowMDAwMDEzMzg5IDAwMDAwIG4gCjAwMDAwMzA2MjQgMDAwMDAgbiAKMDAwMDAxMzUxNSAwMDAwMCBuIAowMDAwMDMyOTgwIDAwMDAwIG4gCjAwMDAwMzMzMTUgMDAwMDAgbiAKMDAwMDAxMzY0OSAwMDAwMCBuIAowMDAwMDE1NTg0IDAwMDAwIG4gCjAwMDAwMzAzMTkgMDAwMDAgbiAKMDAwMDAyODc0NiAwMDAwMCBuIAowMDAwMDE2MTMwIDAwMDAwIG4gCjAwMDAwMjg1ODkgMDAwMDAgbiAKMDAwMDAxNTgyMyAwMDAwMCBuIAowMDAwMDMwNDExIDAwMDAwIG4gCjAwMDAwMzA5MDkgMDAwMDAgbiAKMDAwMDAzMjc5OSAwMDAwMCBuIAowMDAwMDMzNjg3IDAwMDAwIG4gCjAwMDAwMzM4NjMgMDAwMDAgbiAKdHJhaWxlcgo8PC9Sb290IDYgMCBSL0lEIFs8NmM0ZDUzY2E5N2E1NzU0YWRkZDU3NjY3ZWZjMzZlMWE+PDAwYzEzNjE4ZWZmYmZmM2EwMWU1NTQ1YjlhY2JmYzNkPl0vRW5jcnlwdCAyNiAwIFIvSW5mbyA3IDAgUi9TaXplIDI3Pj4Kc3RhcnR4cmVmCjM0MDc5CiUlRU9GCg==");
			// 对文件进行base64加密
			/*File f = new File("E:/PDFFile/caInfo/91320106598035469W.pfx");
			FileItem fileItem = new DiskFileItem("mainFile", Files.probeContentType(f.toPath()), false, f.getName(),
					(int) f.length(), f.getParentFile());
			InputStream input = new FileInputStream(f);
			OutputStream os = fileItem.getOutputStream();

			IOUtils.copy(input, os);
			MultipartFile mulFile = new CommonsMultipartFile(fileItem);
			String pdfstream = EWMbase64util.getPdfstream(mulFile);
			System.out.println(pdfstream);*/
			
			
			// 向文件写入内容
			/*String payResult = pdfstream;
			try {
				FileWriter fw = new FileWriter("d:/onLineData/testPDFFile1.txt",
						true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("\r\n" + payResult);
				bw.close();
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			*/
			
			
			// 对文件流进行解密
//			boolean generateImage = EWMbase64util.generateImage(pdfstream, "E:\\PDFFile\\PDFtemplate\\Jiangsu.pdf");

//			 System.out.println(generateImage);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
