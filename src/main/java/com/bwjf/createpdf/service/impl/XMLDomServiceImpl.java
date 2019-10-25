package com.bwjf.createpdf.service.impl;

import com.bwjf.createpdf.entity.Xxfp;
import com.bwjf.createpdf.entity.Xxfpmx;
import com.bwjf.createpdf.redis.key.InvoiceKey;
import com.bwjf.createpdf.redis.key.RedisService;
import com.bwjf.createpdf.service.XMLDomService;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Service("XMLDom")
public class XMLDomServiceImpl implements XMLDomService {

    @Autowired
    RedisService redisService;


    @Override
    public void XmlJx(String xmlContent, Xxfp xxfp, List<Xxfpmx> xxfpmxList) throws IOException, DocumentException {
        String Charset = "gb2312";
        SAXReader reader = new SAXReader();
        reader.setEncoding("gb2312");//这里设置文件编码
//			Charset = "UTF-16";
        org.dom4j.Document doc = reader.read(new ByteArrayInputStream(xmlContent.getBytes(Charset)));
//			doc = reader.read(new ByteArrayInputStream(context.getBytes("UTF-8")));
        org.dom4j.Element root = doc.getRootElement();
        org.dom4j.Element element;
//        System.out.println("根节点==="+root.getName());
        //获取子节点
//        Element node=root.element("body");//在root节点下面找username节点
//        System.out.println("节点名称------>"+node.getName()+",节点值------->"+node.getStringValue());

        Iterator j = root.elementIterator("body");// 开票成功
//        Iterator k = root.elementIterator("body");// 开票失败
//        Xxfp xxfp = new Xxfp();
//        List<Xxfpmx> xxfpmxList =new ArrayList<>();;
//        Xxfpmx xxfpmx = new Xxfpmx();
//        List<Xxfpmx> xxfpmxList = new ArrayList<>();
        if (j.hasNext()) {
            Element returncode = root.element("body").element("returncode");
            String returncode1 = returncode.getStringValue() == null ? "" : returncode.getStringValue();
            Element returnmsg = root.element("body").element("returnmsg");
            String returnmsg1 = returnmsg.getStringValue() == null ? "" : returnmsg.getStringValue();
//            System.out.println("returncode==  "+returncode1+"  returnmsg==  "+returnmsg1);

            for (Iterator i = root.element("body").element("returndata").element("kpxx").elementIterator(); i.hasNext(); ) { // 获取body下面元素
                element = (org.dom4j.Element) i.next();
//                System.out.println(element.toString());

                String fpdm = element.elementText("fpdm") == null ? "" : element.elementText("fpdm").trim();
//                System.out.println("<fpdm>150007899605</fpdm>=="+fpdm);
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
                String tspz = element.elementText("tspz") == null ? "" : element.elementText("tspz").trim();

                Element fyxm1 = root.element("body").element("returndata").element("kpxx").element("group").element("fyxm");
                String fyxm = fyxm1.attributeValue("count") + "  " == null ? "" : fyxm1.attributeValue("count") + "  ";

                Element qdxm1 = root.element("body").element("returndata").element("kpxx").element("group").element("qdxm");
                String qdxm = qdxm1.attributeValue("count") + "  " == null ? "" : qdxm1.attributeValue("count") + "  ";

                Element qtxm1 = root.element("body").element("returndata").element("kpxx").element("group").element("qdxm");
                String qtxm = qtxm1.attributeValue("count") + "  " == null ? "" : qtxm1.attributeValue("count") + "  ";

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

                String redisEwm = null;
                if (ewm.equals("")) {
                    //redis里边获取
                    redisEwm = redisService.get(InvoiceKey.kfiEwmKey, fpdm + fphm, String.class);
                }

                //获得更深层次的标签（一层一层的获取）
//                Element nameElem = root.element("body").element("returndata").element("kpxx").element("group").element("fpdm");
//                String fpdm = nameElem.getStringValue() == null ? "":nameElem.getStringValue();
//                System.out.println("fpdm=="+fpdm);
//                Element nameElem1 = root.element("body").element("returndata").element("kpxx").element("group").element("fyxm");
//                System.out.println(nameElem1.attributeValue("count")+"  ");
                String spmc = null;
                for (Iterator q = root.element("body").element("returndata").element("kpxx").element("group").element("fyxm").elementIterator(); q.hasNext(); ) { // 获取body下面元素
                    element = (org.dom4j.Element) q.next();

                    Xxfpmx xxfpmx = new Xxfpmx();


                    String group = element.attributeValue("xh") + "  " == null ? "" : element.attributeValue("xh") + "  ";

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


//                    System.out.println("dj = "+dj);

                    xxfpmx.setFphxz(fphxz);
                    xxfpmx.setSpmc(spmc);
//                        System.out.println("xxfpmx.getSpmc()"+xxfpmx.getSpmc());
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
                xxfp.setTspz(tspz);

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
                xxfp.setEwm(redisEwm);

            }
        }


    }
}
