package com.bwjf.createpdf.utils;

import org.apache.pdfbox.exceptions.CryptographyException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.util.PDFTextStripperByArea;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ExtractTextByArea {


    public static Map<String,String> jiexiPDF(String PDFfilePath){
        Map<String,String> pdfInfoMap = new HashMap<>();
        try {

            //        String file = "D:\\testPDF11\\koidID_2390.pdf";
        PDDocument document = null;
        document = PDDocument.load(new File(PDFfilePath));
        if( document.isEncrypted() ){
            document.decrypt("");
        }
        PDFTextStripperByArea stripper = null;

            stripper = new PDFTextStripperByArea();

        stripper.setSortByPosition( true );
//        纳税人识别号91330800MA28F14U3Q
//        Rectangle rect = new Rectangle( 30, 310, 200, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle fpdm = new Rectangle( 475, 20, 200, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle fphm = new Rectangle( 475, 40, 200, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle kprq = new Rectangle( 475, 50, 200, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle jym = new Rectangle( 475, 70, 200, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle jqbm = new Rectangle( 68, 70, 200, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle BZ = new Rectangle( 365, 300, 600, 60 );    //(x坐标，y坐标，长，宽)
        Rectangle mkq = new Rectangle( 365, 90, 600, 60 );    //(x坐标，y坐标，长，宽)

        stripper.addRegion( "fpdm", fpdm );
        stripper.addRegion( "fphm", fphm );
        stripper.addRegion( "kprq", kprq );
        stripper.addRegion( "jym", jym );
        stripper.addRegion( "jqbm", jqbm );
        stripper.addRegion( "BZ", BZ );
        stripper.addRegion( "mkq", mkq );

        List allPages = document.getDocumentCatalog().getAllPages();
        PDPage firstPage = (PDPage)allPages.get( 0 );
        stripper.extractRegions( firstPage );

        String fpdmStr = stripper.getTextForRegion( "fpdm" );
        String fphmStr = stripper.getTextForRegion( "fphm" );
        String kprqStr = stripper.getTextForRegion( "kprq" );
        String jymStr = stripper.getTextForRegion( "jym" );
        String jqbmStr = stripper.getTextForRegion( "jqbm" );
        String BZStr = stripper.getTextForRegion( "BZ" );
        String mkqStr = stripper.getTextForRegion( "mkq" );
//        System.out.println( "Text in the area:" + fpdm );
//        System.out.println();
//        System.out.println( "fpdm: "+stripper.getTextForRegion( "fpdm" ) );
//        System.out.println( "fphm: "+stripper.getTextForRegion( "fphm" ) );
//        System.out.println( "kprq: "+stripper.getTextForRegion( "kprq" ) );
//        System.out.println( "jym: "+stripper.getTextForRegion( "jym" ) );
//        System.out.println( "jqbm: "+stripper.getTextForRegion( "jqbm" ) );
//        System.out.println( "mkqStr: "+stripper.getTextForRegion( "mkqStr" ) );

        pdfInfoMap.put("fpdm",fpdmStr);
        pdfInfoMap.put("fphmStr",fphmStr);
        pdfInfoMap.put("kprqStr",kprqStr);
        pdfInfoMap.put("jymStr",jymStr);
        pdfInfoMap.put("jqbmStr",jqbmStr);
        pdfInfoMap.put("BZStr",BZStr);
        pdfInfoMap.put("mkqStr",mkqStr);
        pdfInfoMap.put("code","success");

        } catch (IOException e) {
            e.printStackTrace();
            pdfInfoMap.put("code","failure");
        } catch (CryptographyException e) {
            e.printStackTrace();
            pdfInfoMap.put("code","failure");
        }
        return pdfInfoMap;

    }

    public static void main( String[] args ) throws Exception{
//        String file = "C:/Users/Desktop/Wistron 201808 KR HK08 Sorting Handling Fee Invoice 6000499146.pdf";
//        String file = "D:\\Desktop\\PDF文件\\新建文件夹\\koidID_2151.pdf";
//        String file = "D:\\testPDF11\\koidID_2390.pdf";
        String file = "D:\\tastPDF1\\koidID_15.pdf";
        PDDocument document = null;
        document = PDDocument.load(new File(file));
        if( document.isEncrypted() ){
            document.decrypt("");
        }
        PDFTextStripperByArea stripper = new PDFTextStripperByArea();
        stripper.setSortByPosition( true );
//        纳税人识别号91330800MA28F14U3Q
//        Rectangle rect = new Rectangle( 30, 310, 200, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle fpdm = new Rectangle( 475, 20, 200, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle fphm = new Rectangle( 475, 40, 200, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle kprq = new Rectangle( 475, 50, 200, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle jym = new Rectangle( 475, 70, 200, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle jqbm = new Rectangle( 68, 70, 200, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle BZ = new Rectangle( 365, 300, 600, 60 );    //(x坐标，y坐标，长，宽)
        Rectangle mkq = new Rectangle( 365, 90, 600, 60 );    //(x坐标，y坐标，长，宽)
        stripper.addRegion( "fpdm", fpdm );
        stripper.addRegion( "fphm", fphm );
        stripper.addRegion( "kprq", kprq );
        stripper.addRegion( "jym", jym );
        stripper.addRegion( "jqbm", jqbm );
        stripper.addRegion( "BZ", BZ );
        stripper.addRegion( "mkq", mkq );
        List allPages = document.getDocumentCatalog().getAllPages();
        PDPage firstPage = (PDPage)allPages.get( 0 );
        stripper.extractRegions( firstPage );
//        System.out.println( "Text in the area:" + fpdm );
        System.out.println( "fpdm: "+stripper.getTextForRegion( "fpdm" ) );
        System.out.println( "fphm: "+stripper.getTextForRegion( "fphm" ) );
        System.out.println( "kprq: "+stripper.getTextForRegion( "kprq" ) );
        System.out.println( "jym: "+stripper.getTextForRegion( "jym" ) );
        System.out.println( "jqbm: "+stripper.getTextForRegion( "jqbm" ) );
        System.out.println( "BZ: "+stripper.getTextForRegion( "BZ" ) );
        System.out.println( "mkq: "+stripper.getTextForRegion( "mkq" ) );

    }

}
