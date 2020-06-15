package com.bwjf.createpdf.utils;

import com.bwjf.createpdf.constant.FilePathConstant;
import com.bwjf.createpdf.entity.BwjfKpOutsideInteFyxmBean;
import com.bwjf.createpdf.entity.KpCustomerInfo;
import org.apache.pdfbox.exceptions.CryptographyException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.util.PDFTextStripperByArea;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;


/**
 *  解析PDF 获取PDF发票 票面上的值
 */
public class ExtractTextByArea {



    @Test
    public void test(){
        String file = "E:\\PDFFileTest1\\1.pdf";
        Map<String, Object> map = jiexiPDF_error(file, "123");
        System.out.println(map.toString());

//        List<String> list = new ArrayList<>();
//        List<String> list1 = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        System.out.println(list.toString());
//
//        String s1 = list.get(1);
//        System.out.println(s1);
//        for (int i = 0; i < list.size(); i++) {
//            String s = list.get(i);
//            list1.add(s);
//        }
//        System.out.println(list1.toString());
    }

    /**
     *      解析乱码的PDF文件  拿到乱码的值
     * @param PDFfilePath
     * @return
     */
    public static Map<String,Object> jiexiPDF_error(String PDFfilePath,String koibId){
        Map<String,Object> pdfInfoMap = new HashMap<>();
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
            Rectangle gfmc = new Rectangle( 105, 90, 230, 10 );    //(x坐标，y坐标，长，宽)
            Rectangle gfsh = new Rectangle( 105, 110, 230, 10 );    //(x坐标，y坐标，长，宽)
            Rectangle gfdz = new Rectangle( 105, 120, 230, 10 );    //(x坐标，y坐标，长，宽)
            Rectangle gfyh = new Rectangle( 105, 140, 230, 10 );    //(x坐标，y坐标，长，宽)
            Rectangle xfmc = new Rectangle( 105, 300, 230, 10 );    //(x坐标，y坐标，长，宽)
            Rectangle xfsh = new Rectangle( 105, 310, 230, 10 );    //(x坐标，y坐标，长，宽)
            Rectangle xfdz = new Rectangle( 105, 330, 230, 10 );    //(x坐标，y坐标，长，宽)
            Rectangle xfyh = new Rectangle( 105, 340, 230, 10 );    //(x坐标，y坐标，长，宽)
            Rectangle spmx1 = new Rectangle( 10, 165, 165, 10 );    //(x坐标，y坐标，长，宽)
            Rectangle spmx2 = new Rectangle( 10, 175, 165, 10 );    //(x坐标，y坐标，长，宽)
            Rectangle spmx3 = new Rectangle( 10, 185, 165, 10 );    //(x坐标，y坐标，长，宽)
            Rectangle spmx4 = new Rectangle( 10, 195, 165, 10 );    //(x坐标，y坐标，长，宽)
            Rectangle spmx5 = new Rectangle( 10, 215, 165, 10 );    //(x坐标，y坐标，长，宽)
            Rectangle spmx6 = new Rectangle( 10, 225, 165, 10 );    //(x坐标，y坐标，长，宽)
            Rectangle spmx7 = new Rectangle( 10, 235, 165, 10 );    //(x坐标，y坐标，长，宽)
            Rectangle spmx8 = new Rectangle( 10, 245, 165, 10 );    //(x坐标，y坐标，长，宽)
            Rectangle BZ = new Rectangle( 355, 300, 600, 60 );    //(x坐标，y坐标，长，宽)
            Rectangle skr = new Rectangle( 60, 350, 80, 20 );    //(x坐标，y坐标，长，宽)
            Rectangle fhr = new Rectangle( 210, 350, 80, 20 );    //(x坐标，y坐标，长，宽)
            Rectangle kpr = new Rectangle( 345, 350, 80, 20 );    //(x坐标，y坐标，长，宽)

            stripper.addRegion( "gfmc", gfmc );
            stripper.addRegion( "gfsh", gfsh );
            stripper.addRegion( "gfdz", gfdz );
            stripper.addRegion( "gfyh", gfyh );
            stripper.addRegion( "xfmc", xfmc );
            stripper.addRegion( "xfsh", xfsh );
            stripper.addRegion( "xfdz", xfdz );
            stripper.addRegion( "xfyh", xfyh );
            stripper.addRegion( "spmx1", spmx1 );
            stripper.addRegion( "spmx2", spmx2 );
            stripper.addRegion( "spmx3", spmx3 );
            stripper.addRegion( "spmx4", spmx4 );
            stripper.addRegion( "spmx5", spmx5 );
            stripper.addRegion( "spmx6", spmx6 );
            stripper.addRegion( "spmx7", spmx7 );
            stripper.addRegion( "spmx8", spmx8 );
            stripper.addRegion( "BZ", BZ );
            stripper.addRegion( "skr", skr );
            stripper.addRegion( "fhr", fhr );
            stripper.addRegion( "kpr", kpr );

            List allPages = document.getDocumentCatalog().getAllPages();
            PDPage firstPage = (PDPage)allPages.get( 0 );
            stripper.extractRegions( firstPage );
            /*System.out.println( "gfmc: "+stripper.getTextForRegion( "gfmc" ) );
            System.out.println( "gfsh: "+stripper.getTextForRegion( "gfsh" ) );
            System.out.println( "gfdz: "+stripper.getTextForRegion( "gfdz" ) );
            System.out.println( "gfyh: "+stripper.getTextForRegion( "gfyh" ) );
            System.out.println( "xfmc: "+stripper.getTextForRegion( "xfmc" ) );
            System.out.println( "xfsh: "+stripper.getTextForRegion( "xfsh" ) );
            System.out.println( "xfdz: "+stripper.getTextForRegion( "xfdz" ) );
            System.out.println( "xfyh: "+stripper.getTextForRegion( "xfyh" ) );
            System.out.println( "spmx1: "+RemoveBlankSpace(stripper.getTextForRegion( "spmx1" )) );
            System.out.println( "spmx2: "+RemoveBlankSpace(stripper.getTextForRegion( "spmx2" )) );
            System.out.println( "spmx3: "+RemoveBlankSpace(stripper.getTextForRegion( "spmx3" )) );
            System.out.println( "spmx4: "+RemoveBlankSpace(stripper.getTextForRegion( "spmx4" )) );
            System.out.println( "spmx5: "+RemoveBlankSpace(stripper.getTextForRegion( "spmx5" )) );
            System.out.println( "spmx6: "+RemoveBlankSpace(stripper.getTextForRegion( "spmx6" )) );
            System.out.println( "spmx7: "+RemoveBlankSpace(stripper.getTextForRegion( "spmx7" )) );
            System.out.println( "spmx8: "+RemoveBlankSpace(stripper.getTextForRegion( "spmx8" )) );
            System.out.println( "BZ: "+stripper.getTextForRegion( "BZ" ) );
            System.out.println( "skr: "+stripper.getTextForRegion( "skr" ) );
            System.out.println( "fhr: "+stripper.getTextForRegion( "fhr" ) );
            System.out.println( "kpr: "+stripper.getTextForRegion( "kpr" ) );*/

            pdfInfoMap.put("gfmc",RemoveBlankSpace(stripper.getTextForRegion( "gfmc" )));
            pdfInfoMap.put("gfsh",RemoveBlankSpace(stripper.getTextForRegion( "gfsh" )));
            pdfInfoMap.put("gfdz",RemoveBlankSpace(stripper.getTextForRegion( "gfdz" )));
            pdfInfoMap.put("gfyh",RemoveBlankSpace(stripper.getTextForRegion( "gfyh" )));
            pdfInfoMap.put("xfmc",RemoveBlankSpace(stripper.getTextForRegion( "xfmc" )));
            pdfInfoMap.put("xfsh",RemoveBlankSpace(stripper.getTextForRegion( "xfsh" )));
            pdfInfoMap.put("xfdz",RemoveBlankSpace(stripper.getTextForRegion( "xfdz" )));
            pdfInfoMap.put("xfyh",RemoveBlankSpace(stripper.getTextForRegion( "xfyh" )));
//            pdfInfoMap.put("spmx1",RemoveBlankSpace(stripper.getTextForRegion( "spmx1" )));
//            pdfInfoMap.put("spmx2",RemoveBlankSpace(stripper.getTextForRegion( "spmx2" )));
//            pdfInfoMap.put("spmx3",RemoveBlankSpace(stripper.getTextForRegion( "spmx3" )));
//            pdfInfoMap.put("spmx4",RemoveBlankSpace(stripper.getTextForRegion( "spmx4" )));
//            pdfInfoMap.put("spmx5",RemoveBlankSpace(stripper.getTextForRegion( "spmx5" )));
//            pdfInfoMap.put("spmx6",RemoveBlankSpace(stripper.getTextForRegion( "spmx6" )));
//            pdfInfoMap.put("spmx7",RemoveBlankSpace(stripper.getTextForRegion( "spmx7" )));
//            pdfInfoMap.put("spmx8",RemoveBlankSpace(stripper.getTextForRegion( "spmx8" )));
            pdfInfoMap.put("BZ",RemoveBlankSpace(stripper.getTextForRegion( "BZ" )));
            pdfInfoMap.put("skr",RemoveBlankSpace(stripper.getTextForRegion( "skr" )));
            pdfInfoMap.put("fhr",RemoveBlankSpace(stripper.getTextForRegion( "fhr" )));
            pdfInfoMap.put("kpr",RemoveBlankSpace(stripper.getTextForRegion( "kpr" )));

            List<String> spmxList = new ArrayList<>();
            List<BwjfKpOutsideInteFyxmBean> invoiceFyxmList = new ArrayList<>();

            spmxList.add(RemoveBlankSpace(stripper.getTextForRegion( "spmx1" )));
            spmxList.add(RemoveBlankSpace(stripper.getTextForRegion( "spmx2" )));
            spmxList.add(RemoveBlankSpace(stripper.getTextForRegion( "spmx3" )));
            spmxList.add(RemoveBlankSpace(stripper.getTextForRegion( "spmx4" )));
            spmxList.add(RemoveBlankSpace(stripper.getTextForRegion( "spmx5" )));
            spmxList.add(RemoveBlankSpace(stripper.getTextForRegion( "spmx6" )));
            spmxList.add(RemoveBlankSpace(stripper.getTextForRegion( "spmx7" )));
            spmxList.add(RemoveBlankSpace(stripper.getTextForRegion( "spmx8" )));

//            System.out.println(spmxList.toString());


            for (int i = 0; i < spmxList.size(); i++) {
                if (!spmxList.get(i).equals("")) {
                    BwjfKpOutsideInteFyxmBean inteFyxmBean = new BwjfKpOutsideInteFyxmBean();
                    inteFyxmBean.setKoifSpmc(spmxList.get(i));
                    inteFyxmBean.setKoibId(koibId);
                    inteFyxmBean.setKoifCreatetime(new Date());
                    invoiceFyxmList.add(inteFyxmBean);
//                    invoiceFyxmList.get(i).setKoifSpmc(spmxList.get(i));
                }
            }

            pdfInfoMap.put("invoiceFyxmList",invoiceFyxmList);
//            System.out.println(invoiceFyxmList.toString());

            pdfInfoMap.put("code","success");

            // 写日志
            String gfmc1 = RemoveBlankSpace(stripper.getTextForRegion("gfmc"));
            String gfsh1 = RemoveBlankSpace(stripper.getTextForRegion("gfsh"));
            String gfdz1 = RemoveBlankSpace(stripper.getTextForRegion("gfdz"));
            String gfyh1 = RemoveBlankSpace(stripper.getTextForRegion("gfyh"));
            String xfmc1 = RemoveBlankSpace(stripper.getTextForRegion("xfmc"));
            String xfsh1 = RemoveBlankSpace(stripper.getTextForRegion("xfsh"));
            String xfdz1 = RemoveBlankSpace(stripper.getTextForRegion("xfdz"));
            String xfyh1 = RemoveBlankSpace(stripper.getTextForRegion("xfyh"));
            String bz1 = RemoveBlankSpace(stripper.getTextForRegion("BZ"));
            String skr1 = RemoveBlankSpace(stripper.getTextForRegion("skr"));
            String fhr1 = RemoveBlankSpace(stripper.getTextForRegion("fhr"));
            String kpr1 = RemoveBlankSpace(stripper.getTextForRegion("kpr"));
            StringBuffer sb = new StringBuffer();
            sb.append("koib_id: ").append(koibId).append("\r\n");
            sb.append("gfmc1: ").append(gfmc1).append("\r\n").append("gfsh1: ").append(gfsh1).append("\r\n");
            sb.append("gfdz1: ").append(gfdz1).append("\r\n").append("gfyh1: ").append(gfyh1).append("\r\n");
            sb.append("xfmc1: ").append(xfmc1).append("\r\n").append("xfsh1: ").append(xfsh1).append("\r\n");
            sb.append("xfdz1: ").append(xfdz1).append("\r\n").append("xfyh1: ").append(xfyh1).append("\r\n");
            sb.append("bz1: ").append(bz1).append("\r\n").append("skr1: ").append(skr1).append("\r\n");
            sb.append("fhr1: ").append(fhr1).append("\r\n").append("kpr1: ").append(kpr1).append("\r\n");
            sb.append("invoiceFyxmList.toString(): ").append(invoiceFyxmList.toString());

            FileUtils.printLog(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "日志内容：" + "\n\t" + sb + "\n\t", FilePathConstant.LogFilePath + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "1.修复PDF乱码数据.txt");


        } catch (IOException e) {
            e.printStackTrace();
            pdfInfoMap.put("code","failure");
        } catch (CryptographyException e) {
            e.printStackTrace();
            pdfInfoMap.put("code","failure");
        }
        return pdfInfoMap;

    }


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
        Rectangle gfmc = new Rectangle( 105, 90, 200, 10 );    //(x坐标，y坐标，长，宽)

//        Rectangle fpdm = new Rectangle( 475, 20, 200, 10 );    //(x坐标，y坐标，长，宽)
//        Rectangle fphm = new Rectangle( 475, 40, 200, 10 );    //(x坐标，y坐标，长，宽)
//        Rectangle kprq = new Rectangle( 475, 50, 200, 10 );    //(x坐标，y坐标，长，宽)
//        Rectangle jym = new Rectangle( 475, 70, 200, 10 );    //(x坐标，y坐标，长，宽)
//        Rectangle jqbm = new Rectangle( 68, 70, 200, 10 );    //(x坐标，y坐标，长，宽)
//        Rectangle BZ = new Rectangle( 365, 300, 600, 60 );    //(x坐标，y坐标，长，宽)
//        Rectangle mkq = new Rectangle( 365, 90, 600, 60 );    //(x坐标，y坐标，长，宽)
        stripper.addRegion( "gfmc", gfmc );

//        stripper.addRegion( "fpdm", fpdm );
//        stripper.addRegion( "fphm", fphm );
//        stripper.addRegion( "kprq", kprq );
//        stripper.addRegion( "jym", jym );
//        stripper.addRegion( "jqbm", jqbm );
//        stripper.addRegion( "BZ", BZ );
//        stripper.addRegion( "mkq", mkq );

        List allPages = document.getDocumentCatalog().getAllPages();
        PDPage firstPage = (PDPage)allPages.get( 0 );
        stripper.extractRegions( firstPage );

        String gfmcStr = stripper.getTextForRegion( "gfmc" );
//        String fpdmStr = stripper.getTextForRegion( "fpdm" );
//        String fphmStr = stripper.getTextForRegion( "fphm" );
//        String kprqStr = stripper.getTextForRegion( "kprq" );
//        String jymStr = stripper.getTextForRegion( "jym" );
//        String jqbmStr = stripper.getTextForRegion( "jqbm" );
//        String BZStr = stripper.getTextForRegion( "BZ" );
//        String mkqStr = stripper.getTextForRegion( "mkq" );
//        System.out.println( "Text in the area:" + fpdm );
//        System.out.println();
//        System.out.println( "fpdm: "+stripper.getTextForRegion( "fpdm" ) );
//        System.out.println( "fphm: "+stripper.getTextForRegion( "fphm" ) );
//        System.out.println( "kprq: "+stripper.getTextForRegion( "kprq" ) );
//        System.out.println( "jym: "+stripper.getTextForRegion( "jym" ) );
//        System.out.println( "jqbm: "+stripper.getTextForRegion( "jqbm" ) );
//        System.out.println( "mkqStr: "+stripper.getTextForRegion( "mkqStr" ) );

        pdfInfoMap.put("gfmc",gfmcStr);
//        pdfInfoMap.put("fpdm",fpdmStr);
//        pdfInfoMap.put("fphmStr",fphmStr);
//        pdfInfoMap.put("kprqStr",kprqStr);
//        pdfInfoMap.put("jymStr",jymStr);
//        pdfInfoMap.put("jqbmStr",jqbmStr);
//        pdfInfoMap.put("BZStr",BZStr);
//        pdfInfoMap.put("mkqStr",mkqStr);
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
//        String file = "F:\\fp365PDF\\pdfFlie\\795412.pdf";
//        String file = "D:\\Desktop\\PDF文件\\795412.pdf";
//        String file = "D:\\tastPDF1\\koidID_2514.pdf";
//        String file = "D:\\tastPDF1\\150003533299199573315236.pdf";
//        String file = "D:\\tastPDF1\\03200170011101989713.pdf";
        String file = "E:\\testPDF\\1.pdf";
//        String file = "D:\\tastPDF1\\123.pdf";

        PDDocument document = null;
        document = PDDocument.load(new File(file));
        if( document.isEncrypted() ){
            document.decrypt("");
        }
        PDFTextStripperByArea stripper = new PDFTextStripperByArea();
        stripper.setSortByPosition( true );
//        纳税人识别号91330800MA28F14U3Q
        Rectangle gfmc = new Rectangle( 105, 90, 230, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle gfsh = new Rectangle( 105, 110, 230, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle gfdz = new Rectangle( 105, 120, 230, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle gfyh = new Rectangle( 105, 140, 230, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle xfmc = new Rectangle( 105, 300, 230, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle xfsh = new Rectangle( 105, 310, 230, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle xfdz = new Rectangle( 105, 330, 230, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle xfyh = new Rectangle( 105, 340, 230, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle spmx1 = new Rectangle( 10, 165, 165, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle spmx2 = new Rectangle( 10, 175, 165, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle spmx3 = new Rectangle( 10, 185, 165, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle spmx4 = new Rectangle( 10, 195, 165, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle spmx5 = new Rectangle( 10, 215, 165, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle spmx6 = new Rectangle( 10, 225, 165, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle spmx7 = new Rectangle( 10, 235, 165, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle spmx8 = new Rectangle( 10, 245, 165, 10 );    //(x坐标，y坐标，长，宽)
//        Rectangle rect = new Rectangle( 30, 310, 200, 10 );    //(x坐标，y坐标，长，宽)
//        Rectangle fpsf = new Rectangle( 180, 30, 40, 30 );    //(x坐标，y坐标，长，宽)
//        Rectangle fpdm = new Rectangle( 465, 20, 200, 10 );    //(x坐标，y坐标，长，宽)
//        Rectangle fphm = new Rectangle( 465, 40, 200, 10 );    //(x坐标，y坐标，长，宽)
//        Rectangle kprq = new Rectangle( 465, 60, 200, 15 );    //(x坐标，y坐标，长，宽)
//        Rectangle jym = new Rectangle( 465, 70, 200, 10 );    //(x坐标，y坐标，长，宽)
//        Rectangle jqbm = new Rectangle( 68, 70, 200, 10 );    //(x坐标，y坐标，长，宽)
        Rectangle BZ = new Rectangle( 355, 300, 600, 60 );    //(x坐标，y坐标，长，宽)
        Rectangle skr = new Rectangle( 60, 350, 80, 20 );    //(x坐标，y坐标，长，宽)
        Rectangle fhr = new Rectangle( 210, 350, 80, 20 );    //(x坐标，y坐标，长，宽)
        Rectangle kpr = new Rectangle( 345, 350, 80, 20 );    //(x坐标，y坐标，长，宽)
//        Rectangle mkq = new Rectangle( 365, 90, 600, 60 );    //(x坐标，y坐标，长，宽)
        stripper.addRegion( "gfmc", gfmc );
        stripper.addRegion( "gfsh", gfsh );
        stripper.addRegion( "gfdz", gfdz );
        stripper.addRegion( "gfyh", gfyh );
        stripper.addRegion( "xfmc", xfmc );
        stripper.addRegion( "xfsh", xfsh );
        stripper.addRegion( "xfdz", xfdz );
        stripper.addRegion( "xfyh", xfyh );

        stripper.addRegion( "spmx1", spmx1 );
        stripper.addRegion( "spmx2", spmx2 );
        stripper.addRegion( "spmx3", spmx3 );
        stripper.addRegion( "spmx4", spmx4 );
        stripper.addRegion( "spmx5", spmx5 );
        stripper.addRegion( "spmx6", spmx6 );
        stripper.addRegion( "spmx7", spmx7 );
        stripper.addRegion( "spmx8", spmx8 );
//        stripper.addRegion( "fpsf", fpsf );
//        stripper.addRegion( "fpdm", fpdm );
//        stripper.addRegion( "fphm", fphm );
//        stripper.addRegion( "kprq", kprq );
//        stripper.addRegion( "jym", jym );
//        stripper.addRegion( "jqbm", jqbm );
        stripper.addRegion( "BZ", BZ );
        stripper.addRegion( "skr", skr );
        stripper.addRegion( "fhr", fhr );
        stripper.addRegion( "kpr", kpr );
//        stripper.addRegion( "mkq", mkq );
        List allPages = document.getDocumentCatalog().getAllPages();
        PDPage firstPage = (PDPage)allPages.get( 0 );
        stripper.extractRegions( firstPage );
//        System.out.println( "Text in the area:" + fpdm );
        System.out.println( "gfmc: "+RemoveBlankSpace(stripper.getTextForRegion( "gfmc" )) );
        System.out.println( "gfsh: "+RemoveBlankSpace(stripper.getTextForRegion( "gfsh" )) );
        System.out.println( "gfdz: "+RemoveBlankSpace(stripper.getTextForRegion( "gfdz" )) );
        System.out.println( "gfyh: "+RemoveBlankSpace(stripper.getTextForRegion( "gfyh" )) );
        System.out.println( "xfmc: "+RemoveBlankSpace(stripper.getTextForRegion( "xfmc" )) );
        System.out.println( "xfsh: "+RemoveBlankSpace(stripper.getTextForRegion( "xfsh" )) );
        System.out.println( "xfdz: "+RemoveBlankSpace(stripper.getTextForRegion( "xfdz" )) );
        System.out.println( "xfyh: "+RemoveBlankSpace(stripper.getTextForRegion( "xfyh" )) );
        System.out.println( "spmx1: "+RemoveBlankSpace(stripper.getTextForRegion( "spmx1" )) );
        System.out.println( "spmx2: "+RemoveBlankSpace(stripper.getTextForRegion( "spmx2" )) );
        System.out.println( "spmx3: "+RemoveBlankSpace(stripper.getTextForRegion( "spmx3" )) );
        System.out.println( "spmx4: "+RemoveBlankSpace(stripper.getTextForRegion( "spmx4" )) );
        System.out.println( "spmx5: "+RemoveBlankSpace(stripper.getTextForRegion( "spmx5" )) );
        System.out.println( "spmx6: "+RemoveBlankSpace(stripper.getTextForRegion( "spmx6" )) );
        System.out.println( "spmx7: "+RemoveBlankSpace(stripper.getTextForRegion( "spmx7" )) );
        System.out.println( "spmx8: "+RemoveBlankSpace(stripper.getTextForRegion( "spmx8" )) );
//        System.out.println( "fpsf: "+stripper.getTextForRegion( "fpsf" ) );
//        System.out.println( "fpdm: "+stripper.getTextForRegion( "fpdm" ) );
//        System.out.println( "fphm: "+stripper.getTextForRegion( "fphm" ) );
//        System.out.println( "kprq: "+stripper.getTextForRegion( "kprq" ) );
//        System.out.println( "jym: "+stripper.getTextForRegion( "jym" ) );
//        System.out.println( "jqbm: "+stripper.getTextForRegion( "jqbm" ) );
        System.out.println( "BZ: "+RemoveBlankSpace(stripper.getTextForRegion( "BZ" )) );
        System.out.println( "skr: "+RemoveBlankSpace(stripper.getTextForRegion( "skr" )) );
        System.out.println( "fhr: "+RemoveBlankSpace(stripper.getTextForRegion( "fhr" )) );
        System.out.println( "kpr: "+RemoveBlankSpace(stripper.getTextForRegion( "kpr" )) );
//        System.out.println( "mkq: "+stripper.getTextForRegion( "mkq" ) );
        String gfmcStr = stripper.getTextForRegion("gfmc");
        String msg = gfmcStr.replaceAll("(\\\r\\\n|\\\r|\\\n|\\\t|\\\n\\\r)", "");

//        System.out.println("msg : " +msg);
        KpCustomerInfo customerInfo = new KpCustomerInfo();
        customerInfo.setKciName(gfmcStr);
        customerInfo.setKciCreatetime(new Date());



        List<String> spmxList = new ArrayList<>();
        List<String> spmxListNew = new ArrayList<>();
        List<BwjfKpOutsideInteFyxmBean> invoiceFyxmList = new ArrayList<>();
        BwjfKpOutsideInteFyxmBean inteFyxmBean = new BwjfKpOutsideInteFyxmBean();

        spmxList.add(RemoveBlankSpace(stripper.getTextForRegion( "spmx1" )));
        spmxList.add(RemoveBlankSpace(stripper.getTextForRegion( "spmx2" )));
        spmxList.add(RemoveBlankSpace(stripper.getTextForRegion( "spmx3" )));
        // 发票明细表
        for (int i = 0; i < spmxList.size(); i++) {
            if (!spmxList.get(i).equals("")) {
                inteFyxmBean.setKoifSpmc(spmxList.get(i));
                inteFyxmBean.setKoibId("dsf");
                inteFyxmBean.setKoifCreatetime(new Date());
                invoiceFyxmList.add(inteFyxmBean);
                spmxListNew.add(spmxList.get(i));
                System.out.println("第"+i+"个商品： " + spmxList.get(i));
            }
        }
        System.out.println(spmxList.toString());
        System.out.println(spmxListNew.toString());
        System.out.println(invoiceFyxmList.toString());
//        String spmx11  = RemoveBlankSpace(stripper.getTextForRegion( "spmx1" ));
        String gfmc1 = RemoveBlankSpace(stripper.getTextForRegion("gfmc"));
        String gfsh1 = RemoveBlankSpace(stripper.getTextForRegion("gfsh"));
        String gfdz1 = RemoveBlankSpace(stripper.getTextForRegion("gfdz"));
        String gfyh1 = RemoveBlankSpace(stripper.getTextForRegion("gfyh"));
        String xfmc1 = RemoveBlankSpace(stripper.getTextForRegion("xfmc"));
        String xfsh1 = RemoveBlankSpace(stripper.getTextForRegion("xfsh"));
        String xfdz1 = RemoveBlankSpace(stripper.getTextForRegion("xfdz"));
        String xfyh1 = RemoveBlankSpace(stripper.getTextForRegion("xfyh"));
        String bz1 = RemoveBlankSpace(stripper.getTextForRegion("BZ"));
        String skr1 = RemoveBlankSpace(stripper.getTextForRegion("skr"));
        String fhr1 = RemoveBlankSpace(stripper.getTextForRegion("fhr"));
        String kpr1 = RemoveBlankSpace(stripper.getTextForRegion("kpr"));
        StringBuffer sb = new StringBuffer();
        sb.append("koib_id: ").append("KOIB");
        sb.append("\r\n");
        sb.append("gfmc: ").append(gfmc1).append("\r\n").append("gfsh: ").append(gfsh1).append("\r\n");
        sb.append("gfdz1: ").append(gfdz1).append("\r\n").append("gfyh1: ").append(gfyh1).append("\r\n");
        sb.append("xfmc1: ").append(xfmc1).append("\r\n").append("xfsh1: ").append(xfsh1).append("\r\n");
        sb.append("xfdz1: ").append(xfdz1).append("\r\n").append("xfyh1: ").append(xfyh1).append("\r\n");
        sb.append("bz1: ").append(bz1).append("\r\n").append("skr1: ").append(skr1).append("\r\n");
        sb.append("fhr1: ").append(fhr1).append("\r\n").append("kpr1: ").append(kpr1).append("\r\n");
        sb.append("invoiceFyxmList.toString(): ").append(invoiceFyxmList.toString());

        FileUtils.printLog(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "日志内容：" + "\n\t" + sb + "\n\t", FilePathConstant.LogFilePath + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "1.修复PDF乱码数据.txt");

    }

    public static String RemoveBlankSpace(String str){
        String str1 = str.replaceAll("(\\\r\\\n|\\\r|\\\n|\\\n\\\r)", "");
        return str1;
    }
}
