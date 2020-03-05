package com.bwjf.createpdf.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
public class PdfToPng {


    /**
     * 实现pdf文件转换为png
     * @param pdffile       要转的转换的pdf 文件
     * @param targetPath    要存储的png图片的路径
     * @param dpi           图像清晰度
     */
    public  void pdfFileToImage(File pdffile, String targetPath, float dpi){
//        try {
//            FileInputStream instream = new FileInputStream(pdffile);
//            InputStream byteInputStream=null;
//            try {
//                PDDocument doc = PDDocument.load(instream);
//                PDFRenderer renderer = new PDFRenderer(doc);
//                int pageCount = doc.getNumberOfPages();
//                if (pageCount > 0) {
//                    BufferedImage image = renderer.renderImage(0, dpi);
//                    image.flush();
//                    ByteArrayOutputStream bs = new ByteArrayOutputStream();
//                    ImageOutputStream imOut;
//                    imOut = ImageIO.createImageOutputStream(bs);
//                    ImageIO.write(image, "jpg", imOut);
//                    byteInputStream = new ByteArrayInputStream(bs.toByteArray());
//                    byteInputStream.close();
//                }
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//            File uploadFile = new File(targetPath);
//            FileOutputStream fops;
//            fops = new FileOutputStream(uploadFile);
//            fops.write(readInputStream(byteInputStream));
//            fops.flush();
//            fops.close();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }

    public static void main(String[] args) {
        Img2Base64Util img2Base64Util = new Img2Base64Util();
        PdfToPng test3 = new PdfToPng();

        File file =new File("E:/发票101.pdf");
        //上传的是png格式的图片结尾
        String targetfile="E:/发票102.jpg";
        test3.pdfFileToImage(file,targetfile,1.8f);
    }
}
