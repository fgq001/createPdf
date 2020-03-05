package com.bwjf.createpdf.test;

import com.bwjf.createpdf.entity.Xxfp;
import com.bwjf.createpdf.entity.Xxfpmx;
import com.bwjf.createpdf.utils.CommonUtils;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by admin on 2019/7/17.
 */
public class test {

    //生成随机数
    static long randomTime = System.currentTimeMillis();
    //pfx文件路径
    static  String pfx = "E:\\PDFFileTest\\1.pfx";
    //印章地址
    static  String gif = "E:\\PDFFileTest\\1.gif";
    //pdf模板地址
    static String tmpPath = "E:\\PDFFileTest\\Jiangsu(2).pdf";
    //创建的pdf路径
    static String tempPdf1 = ("E:\\PDFFileTest" + File.separator + CommonUtils.getUUID() + ".pdf");
    //签名后的pdf路径
//    static String expPath1 = "E:\\PDFFileTest" + File.separator + randomTime + ".pdf";
    static String expPath1 = "E:\\aaaa" + File.separator + randomTime + ".pdf";
    //签章密码
    static String password = "111111";


    public static void main(String[] args) {
        try {
            test.XmlJx();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


    public static void XmlJx() throws IOException, DocumentException {

            String Charset = "gb2312";
//                                                     </group>
        SAXReader reader = new SAXReader();
        reader.setEncoding("GB2312");//这里设置文件编码
//			Charset = "UTF-16";
        org.dom4j.Document doc = reader.read(new ByteArrayInputStream(xmlContent.getBytes(Charset)));
//			doc = reader.read(new ByteArrayInputStream(context.getBytes("UTF-8")));
        org.dom4j.Element root = doc.getRootElement();
        org.dom4j.Element element;
        org.dom4j.Element element2;
        org.dom4j.Element element3;
        System.out.println("根节点==="+root.getName());
        //获取子节点
//        Element node=root.element("body");//在root节点下面找username节点
//        System.out.println("节点名称------>"+node.getName()+",节点值------->"+node.getStringValue());

        Iterator j = root.elementIterator("body");// 开票成功
        Iterator k = root.elementIterator("body");// 开票失败
        Xxfp xxfp = new Xxfp();
        List<Xxfpmx> xxfpmxList =new ArrayList<>();;
        Xxfpmx xxfpmx = new Xxfpmx();
        if (j.hasNext()) {
            Element returncode = root.element("body").element("returncode");
            String returncode1 = returncode.getStringValue() == null ? "":returncode.getStringValue();
            Element returnmsg = root.element("body").element("returnmsg");
            String returnmsg1 = returnmsg.getStringValue() == null ? "":returnmsg.getStringValue();
            System.out.println("returncode==  "+returncode1+"  returnmsg==  "+returnmsg1);

            for (Iterator i = root.element("body").element("returndata").element("kpxx").elementIterator(); i.hasNext(); ) { // 获取body下面元素
                element = (org.dom4j.Element) i.next();
//                System.out.println(element.toString());

                String fpdm = element.elementText("fpdm") == null ? "" : element.elementText("fpdm").trim();
                System.out.println("<fpdm>150007899605</fpdm>=="+fpdm);
                String fphm = element.elementText("fphm") == null ? "" : element.elementText("fphm").trim();
                String fpzt = element.elementText("fpzt") == null ? "" : element.elementText("fpzt").trim();
                String scbz = element.elementText("scbz") == null ? "" : element.elementText("scbz").trim();
                String kprq = element.elementText("kprq") == null ? "" : element.elementText("kprq").trim();
                String kplx = element.elementText("kplx") == null ? "" : element.elementText("kplx").trim();
                String jqbh = element.elementText("jqbh") == null ? "" : element.elementText("jqbh").trim();
                String skm = element.elementText("skm") == null ? "" : element.elementText("skm").trim();
                String jym = element.elementText("jym") == null ? "" : element.elementText("jym").trim();
                String bbh = element.elementText("bbh") == null ? "" : element.elementText("bbh").trim();
                String xhdwsbh = element.elementText("xhdwsbh") == null ? "" : element.elementText("xhdwsbh").trim();
                String xhdwmc = element.elementText("xhdwmc") == null ? "" : element.elementText("xhdwmc").trim();
                String xhdwdzdh = element.elementText("xhdwdzdh") == null ? "" : element.elementText("xhdwdzdh").trim();
                String xhdwyhzh = element.elementText("xhdwyhzh") == null ? "" : element.elementText("xhdwyhzh").trim();
                String ghdwsbh = element.elementText("ghdwsbh") == null ? "" : element.elementText("ghdwsbh").trim();
                String ghdwmc = element.elementText("ghdwmc") == null ? "" : element.elementText("ghdwmc").trim();
                String ghdwdzdh = element.elementText("ghdwdzdh") == null ? "" : element.elementText("ghdwdzdh").trim();
                String ghdwyhzh = element.elementText("ghdwyhzh") == null ? "" : element.elementText("ghdwyhzh").trim();
                String bmbbbh = element.elementText("bmbbbh") == null ? "" : element.elementText("bmbbbh").trim();
                String zsfs = element.elementText("zsfs") == null ? "" : element.elementText("zsfs").trim();

                Element fyxm1 = root.element("body").element("returndata").element("kpxx").element("group").element("fyxm");
                String fyxm = fyxm1.attributeValue("count")+"  " == null ? "":fyxm1.attributeValue("count")+"  ";
                System.out.println(" <fyxm count=\"10\">=="+fyxm);
                Element qdxm1 = root.element("body").element("returndata").element("kpxx").element("group").element("qdxm");
                String qdxm = qdxm1.attributeValue("count")+"  " == null ? "":qdxm1.attributeValue("count")+"  ";
                System.out.println("<qdxm count=\"0\" />=="+qdxm);
                Element qtxm1 = root.element("body").element("returndata").element("kpxx").element("group").element("qdxm");
                String qtxm = qtxm1.attributeValue("count")+"  " == null ? "":qtxm1.attributeValue("count")+"  ";
                System.out.println("<qdxm count=\"0\" />=="+qtxm);

                System.out.println("jym  "+jym+"jqbh"+jqbh);

                String zhsl = element.elementText("zhsl") == null ? "" : element.elementText("zhsl").trim();
                String hjje = element.elementText("hjje") == null ? "" : element.elementText("hjje").trim();
                String hjse = element.elementText("hjse") == null ? "" : element.elementText("hjse").trim();
                String jshj = element.elementText("jshj") == null ? "" : element.elementText("jshj").trim();
                String bz = element.elementText("bz") == null ? "" : element.elementText("bz").trim();
                String skr = element.elementText("skr") == null ? "" : element.elementText("skr").trim();
                String fhr = element.elementText("fhr") == null ? "" : element.elementText("fhr").trim();
                String kpr = element.elementText("kpr") == null ? "" : element.elementText("kpr").trim();
                String jmbbh = element.elementText("jmbbh") == null ? "" : element.elementText("jmbbh").trim();
                String zyspmc = element.elementText("zyspmc") == null ? "" : element.elementText("zyspmc").trim();
                String spsm = element.elementText("spsm") == null ? "" : element.elementText("spsm").trim();
                String qdbz = element.elementText("qdbz") == null ? "" : element.elementText("qdbz").trim();
                String ssyf = element.elementText("ssyf") == null ? "" : element.elementText("ssyf").trim();
                String kpjh = element.elementText("kpjh") == null ? "" : element.elementText("kpjh").trim();
                String tzdbh = element.elementText("tzdbh") == null ? "" : element.elementText("tzdbh").trim();
                String yfpdm = element.elementText("yfpdm") == null ? "" : element.elementText("yfpdm").trim();
                String yfphm = element.elementText("yfphm") == null ? "" : element.elementText("yfphm").trim();
                String zfrq = element.elementText("zfrq") == null ? "" : element.elementText("zfrq").trim();
                String zfr = element.elementText("zfr") == null ? "" : element.elementText("zfr").trim();
                String qmcs = element.elementText("qmcs") == null ? "" : element.elementText("qmcs").trim();
                String qmz = element.elementText("qmz") == null ? "" : element.elementText("qmz").trim();
                String ykfsje = element.elementText("ykfsje") == null ? "" : element.elementText("ykfsje").trim();
                String yqjg = element.elementText("yqjg") == null ? "" : element.elementText("yqjg").trim();
                String ewm = element.elementText("ewm") == null ? "" : element.elementText("ewm").trim();


                //获得更深层次的标签（一层一层的获取）
//                Element nameElem = root.element("body").element("returndata").element("kpxx").element("group").element("fpdm");
//                String fpdm = nameElem.getStringValue() == null ? "":nameElem.getStringValue();
//                System.out.println("fpdm=="+fpdm);
//                Element nameElem1 = root.element("body").element("returndata").element("kpxx").element("group").element("fyxm");
//                System.out.println(nameElem1.attributeValue("count")+"  ");
                String spmc = null;

                for (Iterator q = root.element("body").element("returndata").element("kpxx").element("group").element("fyxm").elementIterator(); q.hasNext(); ) { // 获取body下面元素
                    element = (org.dom4j.Element) q.next();

                    String group = element.attributeValue("xh")+"  " == null ? "" : element.attributeValue("xh")+"  ";
                    System.out.println("<group xh=\"9\">=="+group);

                    String fphxz = element.elementText("fphxz") == null ? "1" : element.elementText("fphxz").trim();
                     spmc = element.elementText("spmc") == null ? "1" : element.elementText("spmc").trim();
                    String ggxh = element.elementText("ggxh") == null ? "1" : element.elementText("ggxh").trim();
                    String dw = element.elementText("dw") == null ? "1" : element.elementText("dw").trim();
                    String spsl = element.elementText("spsl") == null ? "1" : element.elementText("spsl").trim();
                    String dj = element.elementText("dj") == null ? "1" : element.elementText("dj").trim();
                    String je = element.elementText("je") == null ? "1" : element.elementText("je").trim();
                    String sl = element.elementText("sl") == null ? "1" : element.elementText("sl").trim();
                    String se = element.elementText("se") == null ? "1" : element.elementText("se").trim();
                    String hsbz = element.elementText("hsbz") == null ? "1" : element.elementText("hsbz").trim();
                    String spbm = element.elementText("spbm") == null ? "1" : element.elementText("spbm").trim();
                    String zxbm = element.elementText("zxbm") == null ? "1" : element.elementText("zxbm").trim();
                    String yhzcbs = element.elementText("yhzcbs") == null ? "1" : element.elementText("yhzcbs").trim();
                    String lslbs = element.elementText("lslbs") == null ? "1" : element.elementText("lslbs").trim();
                    String zzstsgl = element.elementText("zzstsgl") == null ? "1" : element.elementText("zzstsgl").trim();


                    xxfpmx.setFphxz(fphxz);
                    xxfpmx.setSpmc(spmc);
                    xxfpmx.setSpsm(spsm);
                    xxfpmx.setGgxh(ggxh);
                    xxfpmx.setDw(dw);
                    xxfpmx.setSpsl(spsl);
                    xxfpmx.setDj(dj);
                    xxfpmx.setJe(je);
                    xxfpmx.setSl(sl);
                    xxfpmx.setSe(se);
                    xxfpmx.setHsbz(hsbz);
                    xxfpmx.setSpbm(spbm);
                    xxfpmx.setZxbm(zxbm);
                    xxfpmx.setYhzcbs(yhzcbs);
                    xxfpmx.setLslbs(lslbs);
                    xxfpmx.setZzstsgl(zzstsgl);

                    xxfpmxList.add(xxfpmx);
                    System.out.print("xxfpmxList  spmc = "+xxfpmxList.get(0).getSpmc());
                    System.out.println("xxfpmx  se = "+xxfpmx.getSe());
                    System.out.println("xxfpmx  Spsl = "+xxfpmx.getSpsl());
                    System.out.println("size = "+xxfpmxList.size());
                }



                xxfp.setFpdm(fpdm);
                xxfp.setFphm(fphm);
                xxfp.setFpzt(fpzt);
                xxfp.setScbz(scbz);
                xxfp.setKprq(kprq);
                xxfp.setKplx(kplx);
                xxfp.setJqbh(jqbh);
                xxfp.setSkm(skm);
                xxfp.setJym(jym);
                xxfp.setBbh(bbh);
                xxfp.setXhdwsbh(xhdwsbh);
                xxfp.setXhdwmc(xhdwmc);
                xxfp.setXhdwdzdh(xhdwdzdh);
                xxfp.setXhdwyhzh(xhdwyhzh);
                xxfp.setGhdwsbh(ghdwsbh);
                xxfp.setGhdwmc(ghdwmc);
                xxfp.setGhdwdzdh(ghdwdzdh);
                xxfp.setGhdwyhzh(ghdwyhzh);
                xxfp.setBmbbbh(bmbbbh);
                xxfp.setZsfs(zsfs);

                xxfp.setFyxmCount(fyxm);
                xxfp.setQdxmCount(qdxm);
                xxfp.setQtxmCount(qtxm);

                xxfp.setZhsl(zhsl);
                xxfp.setHjje(hjje);
                xxfp.setHjse(hjse);
                xxfp.setJshj(jshj);
                xxfp.setBz(bz);
                xxfp.setSkr(skr);
                xxfp.setFhr(fhr);
                xxfp.setKpr(kpr);
                xxfp.setJmbbn(jmbbh);
                xxfp.setZyspmc(zyspmc);
                xxfp.setSpsm(spsm);
                xxfp.setQdbz(qdbz);
                xxfp.setSsyf(ssyf);
                xxfp.setKpjh(kpjh);
                xxfp.setTzdbh(tzdbh);
                xxfp.setYfpdm(yfpdm);
                xxfp.setYfphm(yfphm);
                xxfp.setZfrq(zfrq);
                xxfp.setZfr(zfr);
                xxfp.setQmcs(qmcs);
                xxfp.setQmz(qmz);
                xxfp.setYkfsje(ykfsje);
                xxfp.setYqjg(yqjg);
//                xxfp.setEwmPath(ewm);



                System.out.println("dm = "+xxfp.getFpdm()+" hm= "+ xxfp.getFphm());




            }
//            System.out.print("xxfpmxList  spmc = "+xxfpmxList.get(0).getSpmc());
//            System.out.println("xxfpmx  Spsl = "+xxfpmxList.get(0).getSpsl());
//            System.out.println("size = "+xxfpmxList.size());
        }
//        System.out.println(root.element("body").asXML());
//        System.out.println(xmlContent);
//        String tmpPath = "E:\\PDFFileTest\\Jiangsu(2).pdf";
//        long startTime = System.currentTimeMillis();
//        String expPath = tempPdf1;
        System.out.println("expPath == "+tempPdf1);
        System.out.println("xxfpmxList = "+xxfpmxList.size());
        CreatePdfServiceImlpTest1.createPdf(tmpPath, expPath1, pfx, gif,password, xxfp, xxfpmxList, true);
        System.out.println("success");
        System.out.println("tempPdf1  :"+tempPdf1);
        System.out.println("expPath1  :"+expPath1);
    }








    static String xmlContent = "<?xml version=\"1.0\" encoding=\"gbk\"?>\n" +
            "<business id=\"10010\" comment=\"发票查询\">\n" +
            "    <body yylxdm=\"1\">\n" +
            "        <returncode>0</returncode>\n" +
            "        <returnmsg>成功</returnmsg>\n" +
            "        <returndata>\n" +
            "            <kpxx count=\"1\">\n" +
            "                <group xh=\"1\">\n" +
            "                    <fpdm>150007899605</fpdm>\n" +
            "                    <fphm>65437280</fphm>\n" +
            "                    <fpzt>0</fpzt>\n" +
            "                    <scbz>0</scbz>\n" +
            "                    <kprq>20190717094014</kprq>\n" +
            "                    <kplx>0</kplx>\n" +
            "                    <jqbh>499111004317</jqbh>\n" +
            "                    <skm>0370&gt;&lt;&gt;8-6&lt;8-&lt;2-9101+30*7+2/&gt;*2/74&lt;3/4/&gt;9&lt;2+&gt;60827753265*420/7&lt;32375&lt;&lt;5/&gt;&lt;09&lt;&lt;&lt;9*670/+4812-*5201+479195&lt;2-5-/*77</skm>\n" +
            "                    <jym>12031580821406162559</jym>\n" +
            "                    <bbh>03</bbh>\n" +
            "                    <xhdwsbh>91320106598035469W</xhdwsbh>\n" +
            "                    <xhdwmc>江苏百旺金赋信息科技有限公司</xhdwmc>\n" +
            "                    <xhdwdzdh>城市区人民中路188号飞驰新天地广场2幢1801室0515-88196558</xhdwdzdh>\n" +
            "                    <xhdwyhzh>中国建设银行迎宾支行32050173513609916688</xhdwyhzh>\n" +
            "                    <ghdwsbh>913201022498209112</ghdwsbh>\n" +
            "                    <ghdwmc>测试用户0425</ghdwmc>\n" +
            "                    <ghdwdzdh>崔老板的300平米豪宅110</ghdwdzdh>\n" +
            "                    <ghdwyhzh>中国崔氏银行0000</ghdwyhzh>\n" +
            "                    <bmbbbh>10.0</bmbbbh>\n" +
            "                    <zsfs></zsfs>\n" +
            "                    <fyxm count=\"7\">\n" +
            "                        <group xh=\"0\">\n" +
            "                            <fphxz>0</fphxz>\n" +
            "                            <spmc>税控系统技术维护费</spmc>\n" +
            "                            <spsm></spsm>\n" +
            "                            <ggxh></ggxh>\n" +
            "                            <dw></dw>\n" +
            "                            <spsl>1</spsl>\n" +
            "                            <dj>399.81</dj>\n" +
            "                            <je>399.81</je>\n" +
            "                            <sl>0.06</sl>\n" +
            "                            <se>23.99</se>\n" +
            "                            <hsbz></hsbz>\n" +
            "                            <spbm>3079900000000000000</spbm>\n" +
            "                            <zxbm></zxbm>\n" +
            "                            <yhzcbs>0</yhzcbs>\n" +
            "                            <lslbs></lslbs>\n" +
            "                            <zzstsgl></zzstsgl>\n" +
            "                        </group>\n" +
            "                        <group xh=\"1\">\n" +
            "                            <fphxz>0</fphxz>\n" +
            "                            <spmc>税控系统技术维护费2</spmc>\n" +
            "                            <spsm></spsm>\n" +
            "                            <ggxh></ggxh>\n" +
            "                            <dw></dw>\n" +
            "                            <spsl>3</spsl>\n" +
            "                            <dj>298.94</dj>\n" +
            "                            <je>896.83</je>\n" +
            "                            <sl>0.06</sl>\n" +
            "                            <se>53.81</se>\n" +
            "                            <hsbz></hsbz>\n" +
            "                            <spbm>3079900000000000000</spbm>\n" +
            "                            <zxbm></zxbm>\n" +
            "                            <yhzcbs>0</yhzcbs>\n" +
            "                            <lslbs></lslbs>\n" +
            "                            <zzstsgl></zzstsgl>\n" +
            "                        </group>\n" +
            "                        <group xh=\"2\">\n" +
            "                            <fphxz>0</fphxz>\n" +
            "                            <spmc>税控系统技术维护费3</spmc>\n" +
            "                            <spsm></spsm>\n" +
            "                            <ggxh></ggxh>\n" +
            "                            <dw></dw>\n" +
            "                            <spsl>2</spsl>\n" +
            "                            <dj>424.53</dj>\n" +
            "                            <je>849.06</je>\n" +
            "                            <sl>0.06</sl>\n" +
            "                            <se>50.94</se>\n" +
            "                            <hsbz></hsbz>\n" +
            "                            <spbm>3079900000000000000</spbm>\n" +
            "                            <zxbm></zxbm>\n" +
            "                            <yhzcbs>0</yhzcbs>\n" +
            "                            <lslbs></lslbs>\n" +
            "                            <zzstsgl></zzstsgl>\n" +
            "                        </group>\n" +
            "                        <group xh=\"3\">\n" +
            "                            <fphxz>0</fphxz>\n" +
            "                            <spmc>税控系统技术维护费4</spmc>\n" +
            "                            <spsm></spsm>\n" +
            "                            <ggxh></ggxh>\n" +
            "                            <dw></dw>\n" +
            "                            <spsl>1</spsl>\n" +
            "                            <dj>377.36</dj>\n" +
            "                            <je>377.36</je>\n" +
            "                            <sl>0.06</sl>\n" +
            "                            <se>22.64</se>\n" +
            "                            <hsbz></hsbz>\n" +
            "                            <spbm>3079900000000000000</spbm>\n" +
            "                            <zxbm></zxbm>\n" +
            "                            <yhzcbs>0</yhzcbs>\n" +
            "                            <lslbs></lslbs>\n" +
            "                            <zzstsgl></zzstsgl>\n" +
            "                        </group>\n" +
            "                        <group xh=\"4\">\n" +
            "                            <fphxz>0</fphxz>\n" +
            "                            <spmc>税控系统技术维护费4</spmc>\n" +
            "                            <spsm></spsm>\n" +
            "                            <ggxh></ggxh>\n" +
            "                            <dw></dw>\n" +
            "                            <spsl>1</spsl>\n" +
            "                            <dj>377.36</dj>\n" +
            "                            <je>377.36</je>\n" +
            "                            <sl>0.06</sl>\n" +
            "                            <se>22.64</se>\n" +
            "                            <hsbz></hsbz>\n" +
            "                            <spbm>3079900000000000000</spbm>\n" +
            "                            <zxbm></zxbm>\n" +
            "                            <yhzcbs>0</yhzcbs>\n" +
            "                            <lslbs></lslbs>\n" +
            "                            <zzstsgl></zzstsgl>\n" +
            "                        </group>\n" +
            "                        <group xh=\"5\">\n" +
            "                            <fphxz>0</fphxz>\n" +
            "                            <spmc>税控系统技术维护费4</spmc>\n" +
            "                            <spsm></spsm>\n" +
            "                            <ggxh></ggxh>\n" +
            "                            <dw></dw>\n" +
            "                            <spsl>1</spsl>\n" +
            "                            <dj>377.36</dj>\n" +
            "                            <je>377.36</je>\n" +
            "                            <sl>0.06</sl>\n" +
            "                            <se>22.64</se>\n" +
            "                            <hsbz></hsbz>\n" +
            "                            <spbm>3079900000000000000</spbm>\n" +
            "                            <zxbm></zxbm>\n" +
            "                            <yhzcbs>0</yhzcbs>\n" +
            "                            <lslbs></lslbs>\n" +
            "                            <zzstsgl></zzstsgl>\n" +
            "                        </group>\n" +
            "                        <group xh=\"6\">\n" +
            "                            <fphxz>0</fphxz>\n" +
            "                            <spmc>税控系统技术维护费4</spmc>\n" +
            "                            <spsm></spsm>\n" +
            "                            <ggxh></ggxh>\n" +
            "                            <dw></dw>\n" +
            "                            <spsl>1</spsl>\n" +
            "                            <dj>377.36</dj>\n" +
            "                            <je>377.36</je>\n" +
            "                            <sl>0.06</sl>\n" +
            "                            <se>22.64</se>\n" +
            "                            <hsbz></hsbz>\n" +
            "                            <spbm>3079900000000000000</spbm>\n" +
            "                            <zxbm></zxbm>\n" +
            "                            <yhzcbs>0</yhzcbs>\n" +
            "                            <lslbs></lslbs>\n" +
            "                            <zzstsgl></zzstsgl>\n" +
            "                        </group>\n" +
//            "                        <group xh=\"7\">\n" +
//            "                            <fphxz>0</fphxz>\n" +
//            "                            <spmc>税控系统技术维护费4</spmc>\n" +
//            "                            <spsm></spsm>\n" +
//            "                            <ggxh></ggxh>\n" +
//            "                            <dw></dw>\n" +
//            "                            <spsl>1</spsl>\n" +
//            "                            <dj>377.36</dj>\n" +
//            "                            <je>377.36</je>\n" +
//            "                            <sl>0.06</sl>\n" +
//            "                            <se>22.64</se>\n" +
//            "                            <hsbz></hsbz>\n" +
//            "                            <spbm>3079900000000000000</spbm>\n" +
//            "                            <zxbm></zxbm>\n" +
//            "                            <yhzcbs>0</yhzcbs>\n" +
//            "                            <lslbs></lslbs>\n" +
//            "                            <zzstsgl></zzstsgl>\n" +
//            "                        </group>\n" +
//            "                        <group xh=\"8\">\n" +
//            "                            <fphxz>0</fphxz>\n" +
//            "                            <spmc>税控系统技术维护费4</spmc>\n" +
//            "                            <spsm></spsm>\n" +
//            "                            <ggxh></ggxh>\n" +
//            "                            <dw></dw>\n" +
//            "                            <spsl>1</spsl>\n" +
//            "                            <dj>377.36</dj>\n" +
//            "                            <je>377.36</je>\n" +
//            "                            <sl>0.06</sl>\n" +
//            "                            <se>22.64</se>\n" +
//            "                            <hsbz></hsbz>\n" +
//            "                            <spbm>3079900000000000000</spbm>\n" +
//            "                            <zxbm></zxbm>\n" +
//            "                            <yhzcbs>0</yhzcbs>\n" +
//            "                            <lslbs></lslbs>\n" +
//            "                            <zzstsgl></zzstsgl>\n" +
//            "                        </group>\n" +
//            "                        <group xh=\"9\">\n" +
//            "                            <fphxz>0</fphxz>\n" +
//            "                            <spmc>税控系统技术维护费4</spmc>\n" +
//            "                            <spsm></spsm>\n" +
//            "                            <ggxh></ggxh>\n" +
//            "                            <dw></dw>\n" +
//            "                            <spsl>1</spsl>\n" +
//            "                            <dj>377.36</dj>\n" +
//            "                            <je>377.36</je>\n" +
//            "                            <sl>0.06</sl>\n" +
//            "                            <se>22.64</se>\n" +
//            "                            <hsbz></hsbz>\n" +
//            "                            <spbm>3079900000000000000</spbm>\n" +
//            "                            <zxbm></zxbm>\n" +
//            "                            <yhzcbs>0</yhzcbs>\n" +
//            "                            <lslbs></lslbs>\n" +
//            "                            <zzstsgl></zzstsgl>\n" +
//            "                        </group>\n" +
            "                    </fyxm>\n" +
            "                    <qdxm count=\"0\" />\n" +
            "                    <qtxm count=\"0\" />\n" +
            "                    <zhsl></zhsl>\n" +
            "                    <hjje>4787.22</hjje>\n" +
            "                    <hjse>287.22</hjse>\n" +
            "                    <jshj>5074.44</jshj>\n" +
            "                    <bz>服务费截止时间：2019.4.27-2020.4.27</bz>\n" +
            "                    <skr>红字skr</skr>\n" +
            "                    <fhr>红字fhr</fhr>\n" +
            "                    <kpr>崔老板111</kpr>\n" +
            "                    <jmbbh>20190220100839113555</jmbbh>\n" +
            "                    <zyspmc>税控系统技术维护费</zyspmc>\n" +
            "                    <spsm></spsm>\n" +
            "                    <qdbz>1</qdbz>\n" +
            "                    <ssyf>20190</ssyf>\n" +
            "                    <kpjh>0</kpjh>\n" +
            "                    <tzdbh></tzdbh>\n" +
            "                    <yfpdm></yfpdm>\n" +
            "                    <yfphm></yfphm>\n" +
            "                    <zfrq></zfrq>\n" +
            "                    <zfr></zfr>\n" +
            "                    <qmcs>01B4014282000000</qmcs>\n" +
            "                    <qmz></qmz>\n" +
            "                    <ykfsje>0.00</ykfsje>\n" +
            "                    <yqjg></yqjg>\n" +
            "                    <ewm>iVBORw0KGgoAAAANSUhEUgAAAJQAAACUCAIAAAD6XpeDAAAC/UlEQVR42u3cy26DUAwFwPz/T6frLqoK8LENDMuIUPDc6PqB+vkEju+C46/7qbrno9/93OWABw8evJfgJYJ1NKBVGAmkK9dPxBkePHjw4NXgHb3Rqs+v3ENV0K8kI4nFBw8ePHjw7odXdU46uUgU/vDgwYMH7114iZtOBL0zqYEHDx48ePN46c08EaCqBGdD4b9iqgAPHjx4D8arOhIN6yd9vvqABA8evAfjfcPHhnvbMIyNxBYePHjw4J1+rnTQEw3xzkVz5Zx4POHBgwcP3mm8qWNzglMFGWmsw4MHDx68f69flSx0viCUSIgSSUp6QcCDBw8evJr3aNIwVQ82lVAkFk1ZgQ8PHjx48EYazVOJQKJAroIZ+xXCgwcP3svxOpOCDQPYK6v4No1pePDgwYN3Gm9q0+4ckFYFOn0P8YeHBw8evJfgJQakVwLU2cDtHOqW1dnw4MGDB6/keaeK8XQh34nU2UCABw8ePHh9g8rEwLNzKNrZEChL0ODBgwcPXhSvs/Dc0AhOD34v/V148ODBg1eCl37BJrGBVzUEEg36xDnw4MGDB68GL7Fpdzap02CJpvzhvwUPHjx48E7PBasK8wRSZ+IzNfuM/wrhwYMHD155QzlRvN/xpal4YxoePHjw4FXEIf6PczYnMonrJJrg8ODBgwfvfD8zHdB0Q6CqaT716ykrzOHBgwcP3ul5XlUgruy72xoC6cVaNlWABw8ePHgleFWN4A2LY9tQOp6wwIMHDx688oI93WjubBpMNa/Hui3w4MGD90K8sU040EBIL5TOmMCDBw8evGPX3LBRT2346WFporHw63N48ODBg1fyPku6iZxIgtKD5XihHU4S4cGDBw9eNqFIDHsTG3hiwbUmLPDgwYMHLzqMTWzI6WBVFdStGeDUNBwePHjw4I00TxPFctU5iThcKtLhwYMHD94t8NLfTTSFVyRE8ODBgwfvNF7ni0ZTQ9eqZ0/EYcUwFh48ePAejNfZI93Q2N0wcF7X7IYHDx685+L9ACpql2Icyp6DAAAAAElFTkSuQmCC</ewm>\n" +
            "                </group>\n" +
            "            </kpxx>\n" +
            "        </returndata>\n" +
            "    </body>\n" +
            "</business>";
}
