package com.bwjf.createpdf.utils;


import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfSignatureAppearance.RenderingMode;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.security.BouncyCastleDigest;
import com.itextpdf.text.pdf.security.ExternalDigest;
import com.itextpdf.text.pdf.security.ExternalSignature;
import com.itextpdf.text.pdf.security.MakeSignature;
import com.itextpdf.text.pdf.security.MakeSignature.CryptoStandard;
import com.itextpdf.text.pdf.security.PrivateKeySignature;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Enumeration;
//import org.apache.log4j.Logger;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class SignPDF
{
//  private static Logger logger = Logger.getLogger(SignPDF.class);

  public static void sign(String mpath, String mbPath, String newPath, String gzUrl, String pwdkey)
  {
    File nf = new File(newPath);
    if (nf.exists()) {
      nf.delete();
    }
    BouncyCastleProvider provider = new BouncyCastleProvider();
    Security.addProvider(provider);
    KeyStore ks = null;
    PdfStamper stp = null;
    FileOutputStream fout = null;
    FileInputStream fint = null;
    PdfReader reader = null;
    try {
      ks = KeyStore.getInstance("pkcs12");

      fint = new FileInputStream(mpath);
      ks.load(fint, pwdkey == null ? null : pwdkey.toCharArray());
      String alias = (String)ks.aliases().nextElement();
      PrivateKey key = (PrivateKey)ks.getKey(alias, pwdkey == null ? null : pwdkey.toCharArray());
      Certificate[] chain = ks.getCertificateChain(alias);
      reader = new PdfReader(mbPath);
      fout = new FileOutputStream(newPath);
      stp = PdfStamper.createSignature(reader, fout, '\000');
      PdfSignatureAppearance appearance = stp.getSignatureAppearance();

      appearance.setVisibleSignature(new Rectangle(447.0F, 16.0F, 557.0F, 92.0F), 1, null);
//      appearance.setVisibleSignature(new Rectangle(435.0F, 10.0F, 525.0F, 70.0F), 1, null);
      Image image = Image.getInstance(gzUrl);
      appearance.setSignatureGraphic(image);
      appearance.setAcro6Layers(true);
      appearance.setRenderingMode(PdfSignatureAppearance.RenderingMode.GRAPHIC);
      ExternalDigest digest = new BouncyCastleDigest();
      ExternalSignature signature = new PrivateKeySignature(key, "SHA-1", provider.getName());
      MakeSignature.signDetached(appearance, digest, signature, chain, null, null, null, 0, MakeSignature.CryptoStandard.CMS);
      System.out.println("SignPDF==success");
    } catch (KeyStoreException e1) {
    	System.err.print("发票pdf签章生成失败");
    }
    catch (NoSuchAlgorithmException e)
    {
      System.err.print("发票pdf签章生成失败");

      if (stp != null) {
        try {
          stp.close();
        }
        catch (DocumentException e1) {
          e1.printStackTrace();
        }
        catch (IOException e1) {
          e1.printStackTrace();
        }
      }
      if (fout != null) {
        try {
          fout.close();
        }
        catch (IOException e1) {
          e1.printStackTrace();
        }
      }
      if (reader != null) {
        reader.close();
      }
      if (fint != null)
        try {
          fint.close();
        }
        catch (IOException e1) {
          e1.printStackTrace();
        }
    }
    catch (CertificateException e)
    {}
    catch (FileNotFoundException e)
    {}
    catch (IOException e)
    {}
    catch (DocumentException e)
    {}
    catch (GeneralSecurityException e)
    {}
    finally
    {
      if (stp != null) {
        try {
          stp.close();
        }
        catch (DocumentException e) {
          e.printStackTrace();
        }
        catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (fout != null) {
        try {
          fout.close();
        }
        catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (reader != null) {
        reader.close();
      }
      if (fint != null)
        try {
          fint.close();
        }
        catch (IOException e) {
          e.printStackTrace();
        }
    }

  }

  public static void main(String[] args)
  {
//    String s1 = "d:\\upload\\91330227144400005E\\91330227144400005E.pfx";
//    String s2 = "d:\\new.pdf";
//    String s3 = "d:\\new2.pdf";
//    String s4 = "d:\\upload\\91330227144400005E\\91330227144400005E.png";
//    String s5 = "111111";
    
    
//    String pfx = "E:\\PDFFileTest\\1.pfx";
//    String tmpPath = "E:\\PDFFileTest\\1562560846046.pdf";
//    String expPath = "E:\\PDFFileTest\\hhh22.pdf";
//    String gif = "E:\\PDFFileTest\\1.gif";
//    String password = "111111";
    
    String pfx = "E:\\PDFFileTest\\1.pfx";
    String tmpPath = "E:\\PDFFileTest\\1562570792439.pdf";
    String expPath = "E:\\PDFFileTest\\h83.pdf";
    String gif = "E:\\PDFFileTest\\1.gif";
    String password = "111111";
    try {
      sign(pfx, tmpPath, expPath, gif, password);
      System.out.println("success");
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
