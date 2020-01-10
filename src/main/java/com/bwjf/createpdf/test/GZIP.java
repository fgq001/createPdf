package com.bwjf.createpdf.test;



        import org.apache.commons.codec.binary.Base64;

        import java.io.ByteArrayInputStream;
        import java.io.ByteArrayOutputStream;
        import java.io.IOException;
        import java.util.zip.DeflaterOutputStream;
        import java.util.zip.GZIPInputStream;
        import java.util.zip.GZIPOutputStream;
/**
 *
 * 开发公司：sojson.com<br/>
 * 版权：sojson.com<br/>
 * <p>
 *
 * 字符串压缩
 *
 * <p>
 *
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2015年12月19日 　<br/>
 * <p>
 * *******
 * <p>
 * @author zhou-baicheng
 * @email  json@sojson.com
 * @version 1.0,2015年12月19日 <br/>
 *
 */
public class GZIP {

    /**
     * 字符串的压缩
     *
     * @param str
     *            待压缩的字符串
     * @return 返回压缩后的字符串
     * @throws IOException
     */
    public static String compress(String str) throws IOException {
        if (null == str || str.length() <= 0) {
            return str;
        }
        // 创建一个新的 byte 数组输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // 使用默认缓冲区大小创建新的输出流
        GZIPOutputStream gzip = new GZIPOutputStream(out);
        // 将 b.length 个字节写入此输出流
        gzip.write(str.getBytes());
        gzip.close();
        // 使用指定的 charsetName，通过解码字节将缓冲区内容转换为字符串
        return out.toString("UTF-8");
    }

    /**
     * zlib压缩+base64
     */
    public static String compressData(String data) {
        ByteArrayOutputStream bos;
        DeflaterOutputStream zos;
        try {
            bos = new ByteArrayOutputStream();
            zos = new DeflaterOutputStream(bos);
            zos.write(data.getBytes());
            zos.close();
            return new       String(Base64.encodeBase64(bos.toByteArray()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 字符串的解压
     *
     * @param str
     *            对字符串解压
     * @return 返回解压缩后的字符串
     * @throws IOException
     */
    public static String unCompress(String str) throws IOException {
        if (null == str || str.length() <= 0) {
            return str;
        }
        // 创建一个新的 byte 数组输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // 创建一个 ByteArrayInputStream，使用 buf 作为其缓冲区数组
        ByteArrayInputStream in = new ByteArrayInputStream(str
                .getBytes("UTF-8"));
        // 使用默认缓冲区大小创建新的输入流
        GZIPInputStream gzip = new GZIPInputStream(in);
        byte[] buffer = new byte[256];
        int n = 0;
        while ((n = gzip.read(buffer)) >= 0) {// 将未压缩数据读入字节数组
            // 将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此 byte数组输出流
            out.write(buffer, 0, n);
        }
        // 使用指定的 charsetName，通过解码字节将缓冲区内容转换为字符串
        return out.toString("UTF-8");
    }

    public static void main(String[] args) throws IOException {
        String ss = "{\n" +
                "    \"access_token\": \"acdc73ec1ad145fbbfbc2dfddd0c7372b5d9e04f0e8043f5b3a64e920d96b083\",\n" +
                "    \"serviceKey\": \"bwjf_InvoiceHandle_newBlueInvoice\",\n" +
                "    \"data\": \n" +
                "    {\n" +
                "    \"data_resources\": \"API\",\n" +
                "    \"nsrsbh\": \"91320106598035469W\",\n" +
                "    \"skph\":\"123213123212\",\n" +
                "    \"order_num\": \"iHkml3V154806120830\",\n" +
                "    \"bmb_bbh\": \"32.0\",\n" +
                "    \"zsfs\": \"0\",\n" +
                "    \"tspz\":\"00\",\n" +
                "    \"xsf_nsrsbh\": \"91320106598035469W\",\n" +
                "    \"xsf_mc\": \"江苏百旺金赋信息科技有限公司\",\n" +
                "    \"xsf_dzdh\": \"城市区人民中路188号飞驰新天地广场2幢1801室0515-88196558\",\n" +
                "    \"xsf_yhzh\": \"中国建设银行迎宾支行32050173513609916688\",\n" +
                "    \"gmf_nsrsbh\": \"913201022498209112\",\n" +
                "    \"gmf_mc\": \"测试用户0425\",\n" +
                "    \"gmf_dzdh\": \"崔老板的300平米豪宅110\",\n" +
                "    \"gmf_yhzh\": \"中国崔氏银行0000\",\n" +
                "    \"kpr\": \"崔老板111\",\n" +
                "    \"skr\": \"红字skr\",\n" +
                "    \"fhr\": \"红字fhr\", \n" +
                "    \"yfp_dm\": \"150007899605\",\n" +
                "    \"yfp_hm\": \"65439448\",\n" +
                "    \"jshj\": \"280.00\",\n" +
                "    \"hjje\": \"264.15\",\n" +
                "    \"hjse\": \"15.85\",\n" +
                "    \"kce\": \"0\",\n" +
                "    \"bz\": \"服务费截止时间：2019.4.27-2020.4.27\",\n" +
                "    \"jff_phone\":\"手机号\",\n" +
                "    \"jff_email\":\"电子邮件\",\n" +
                "    \"common_fpkj_xmxx\": [{\n" +
                "            \"fphxz\": \"0\",\n" +
                "            \"spbm\": \"3079900000000000000\",\n" +
                "            \"zxbm\": \"\",\n" +
                "            \"yhzcbs\": \"0\",\n" +
                "            \"lslbs\": \"\",\n" +
                "            \"zzstsgl\": \"\",\n" +
                "            \"xmmc\": \"税控系统技术维护费\",\n" +
                "            \"ggxh\": \"\",\n" +
                "            \"dw\": \"\",\n" +
                "            \"xmsl\": \"1.000000\",\n" +
                "            \"xmdj\": \"174.523654125654\",\n" +
                "            \"xmje\": \"174.52\",\n" +
                "            \"sl\": \"0.06\",\n" +
                "            \"se\": \"15.85\"\n" +
                "        },\n" +
                "\t\t{\n" +
                "            \"fphxz\": \"0\",\n" +
                "            \"spbm\": \"3079900000000000000\",\n" +
                "            \"zxbm\": \"\",\n" +
                "            \"yhzcbs\": \"0\",\n" +
                "            \"lslbs\": \"\",\n" +
                "            \"zzstsgl\": \"\",\n" +
                "            \"xmmc\": \"税控系统技术维护费2\",\n" +
                "            \"ggxh\": \"\",\n" +
                "            \"dw\": \"\",\n" +
                "            \"xmsl\": \"3.000000\",\n" +
                "            \"xmdj\": \"316.88\",\n" +
                "            \"xmje\": \"950.64\",\n" +
                "            \"sl\": \"0.06\",\n" +
                "            \"se\": \"15.85\"\n" +
                "        },{\n" +
                "            \"fphxz\": \"0\",\n" +
                "            \"spbm\": \"3079900000000000000\",\n" +
                "            \"zxbm\": \"\",\n" +
                "            \"yhzcbs\": \"0\",\n" +
                "            \"lslbs\": \"\",\n" +
                "            \"zzstsgl\": \"\",\n" +
                "            \"xmmc\": \"税控系统技术维护费3\",\n" +
                "            \"ggxh\": \"\",\n" +
                "            \"dw\": \"\",\n" +
                "            \"xmsl\": \"2.000000\",\n" +
                "            \"xmdj\": \"450.00\",\n" +
                "            \"xmje\": \"900.00\",\n" +
                "            \"sl\": \"0.06\",\n" +
                "            \"se\": \"15.85\"\n" +
                "        },{\n" +
                "            \"fphxz\": \"0\",\n" +
                "            \"spbm\": \"3079900000000000000\",\n" +
                "            \"zxbm\": \"\",\n" +
                "            \"yhzcbs\": \"0\",\n" +
                "            \"lslbs\": \"\",\n" +
                "            \"zzstsgl\": \"\",\n" +
                "            \"xmmc\": \"税控系统技术维护费4\",\n" +
                "            \"ggxh\": \"\",\n" +
                "            \"dw\": \"\",\n" +
                "            \"xmsl\": \"1.000000\",\n" +
                "            \"xmdj\": \"206.236545879651\",\n" +
                "            \"xmje\": \"206.24\",\n" +
                "            \"sl\": \"0.06\",\n" +
                "            \"se\": \"15.85\"\n" +
                "        }]\n" +
                "    }\n" +
                "}";
        String d = compress(ss);
        System.out.println(d);

        String qq = compressData(ss);
        System.out.println(qq);

    }
}