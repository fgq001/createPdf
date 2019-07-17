package com.bwjf.createpdf.test;

import com.bwjf.createpdf.entity.Xxfp;
import org.dom4j.Attribute;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by admin on 2019/7/17.
 */
public class test {
    public static void main(String[] args) throws IOException, DocumentException {


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
                System.out.println("fpdm=="+fpdm);
                String fphm = element.elementText("fphm") == null ? "" : element.elementText("fphm").trim();
                String fpzt = element.elementText("fpzt") == null ? "" : element.elementText("fpzt").trim();
                String scbz = element.elementText("scbz") == null ? "" : element.elementText("scbz").trim();
                String kprq = element.elementText("kprq") == null ? "" : element.elementText("kprq").trim();
                String kplx = element.elementText("kplx") == null ? "" : element.elementText("kplx").trim();
                String jqbh = element.elementText("jqbh") == null ? "" : element.elementText("jqbh").trim();
                String skm = element.elementText("skm") == null ? "" : element.elementText("skm").trim();
                String jym = element.elementText("jym") == null ? "" : element.elementText("jym").trim();
                String bbh = element.elementText("bbh") == null ? "" : element.elementText("bbh").trim();
//                String fphm = element.elementText("fphm") == null ? "" : element.elementText("fphm").trim();
//                String fphm = element.elementText("fphm") == null ? "" : element.elementText("fphm").trim();
//                String fphm = element.elementText("fphm") == null ? "" : element.elementText("fphm").trim();
//                String fphm = element.elementText("fphm") == null ? "" : element.elementText("fphm").trim();
//                String fphm = element.elementText("fphm") == null ? "" : element.elementText("fphm").trim();
//                String fphm = element.elementText("fphm") == null ? "" : element.elementText("fphm").trim();
//                String fphm = element.elementText("fphm") == null ? "" : element.elementText("fphm").trim();
//                String fphm = element.elementText("fphm") == null ? "" : element.elementText("fphm").trim();
//                String fphm = element.elementText("fphm") == null ? "" : element.elementText("fphm").trim();
//                String fphm = element.elementText("fphm") == null ? "" : element.elementText("fphm").trim();
//                String fphm = element.elementText("fphm") == null ? "" : element.elementText("fphm").trim();
//                String fphm = element.elementText("fphm") == null ? "" : element.elementText("fphm").trim();
//                String fphm = element.elementText("fphm") == null ? "" : element.elementText("fphm").trim();
//                String fphm = element.elementText("fphm") == null ? "" : element.elementText("fphm").trim();
//                String fphm = element.elementText("fphm") == null ? "" : element.elementText("fphm").trim();
//                String fphm = element.elementText("fphm") == null ? "" : element.elementText("fphm").trim();
//                String fphm = element.elementText("fphm") == null ? "" : element.elementText("fphm").trim();
//                String fphm = element.elementText("fphm") == null ? "" : element.elementText("fphm").trim();
//                String fphm = element.elementText("fphm") == null ? "" : element.elementText("fphm").trim();
//                String fphm = element.elementText("fphm") == null ? "" : element.elementText("fphm").trim();
//                String fphm = element.elementText("fphm") == null ? "" : element.elementText("fphm").trim();
//                String fphm = element.elementText("fphm") == null ? "" : element.elementText("fphm").trim();


                //获得更深层次的标签（一层一层的获取）
//                Element nameElem = root.element("body").element("returndata").element("kpxx").element("group").element("fpdm");
//                String fpdm = nameElem.getStringValue() == null ? "":nameElem.getStringValue();
//                System.out.println("fpdm=="+fpdm);
//                Element nameElem1 = root.element("body").element("returndata").element("kpxx").element("group").element("fyxm");
//                System.out.println(nameElem1.attributeValue("count")+"  ");


                for (Iterator q = root.element("body").element("returndata").element("kpxx").element("group").element("fyxm").elementIterator(); q.hasNext(); ) { // 获取body下面元素
                    element = (org.dom4j.Element) q.next();

    //                System.out.println(element.toString());
    //                System.out.print(element.attributeValue("xh")+"  ");

                    System.out.print(element.attributeValue("xh")+"  ");
                    String spmc = element.elementText("spmc") == null ? "1" : element.elementText("spmc").trim();
                    String fphxz = element.elementText("fphxz") == null ? "1" : element.elementText("fphxz").trim();
                    String spbm = element.elementText("spbm") == null ? "1" : element.elementText("spbm").trim();
                    System.out.println("spmc=="+spmc+"  fphxz=="+fphxz+"  spbm=="+spbm);
                }
            }

        }
//        System.out.println(root.element("body").asXML());
//        System.out.println(xmlContent);
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
            "                    <fyxm count=\"10\">\n" +
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
            "                        <group xh=\"7\">\n" +
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
            "                        <group xh=\"8\">\n" +
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
            "                        <group xh=\"9\">\n" +
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
