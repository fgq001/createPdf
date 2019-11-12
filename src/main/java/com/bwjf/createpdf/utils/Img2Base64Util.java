package com.bwjf.createpdf.utils;

/**
 * Created by admin on 2019/7/18.
 */

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * 将图片转换为Base64
 * 将base64编码字符串解码成img图片
 */
public class Img2Base64Util {


    public static String GetImageStr(String imgPath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        String imgFile = imgPath;// 待处理的图片
        InputStream in = null;
        byte[] data = null;
        String encode = null; // 返回Base64编码过的字节数组字符串
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        try {
            // 读取图片字节数组
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            encode = encoder.encode(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return encode;
    }



    public static boolean GenerateImage(String imgData, String imgFilePath) throws IOException { // 对字节数组字符串进行Base64解码并生成图片
        if (imgData == null) // 图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        OutputStream out = null;
        try {
            out = new FileOutputStream(imgFilePath);
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgData);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            out.write(b);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
            return true;
        }
    }


    public static void main(String[] args) throws IOException {
//        String imageStr = Img2Base64Util.GetImageStr("D://下载/企鹅.jpg");
//        System.out.println(imageStr);
//        String dd = "iVBORw0KGgoAAAANSUhEUgAAAJQAAACUCAIAAAD6XpeDAAADAklEQVR42u3aW26EMBAEwNz/0psTRAHcPZil FwhsF1eeR78/BSuzx/XkfuP/H72XUeec3ZeR8aQeu/oBQ8ePHgvwfssXKkFnQRoL/oK9unxwIMHDx68y3ipwe0WHLXP/kYABQ8ePHjwno23ErCkwNoA8ODBgwfvvXjtgnW7SJ3aWPDgwYMHby 8xmGeAmsHO6ng6PFdBXjw4MH7YrxGsdjvQ4sODx4kePBuaTxOHtSTHxG153h6TeDBgwcP3uU1aU 4XRBYSaIb751cT3jw4MGDl8FrFKMbMO0ib2MusXWABw8ePHj/Pr RCE82Y1ee2dhMk/fAgwcPHrzrePXi6WDif1fRoL2J4cGDBw/edbxGQtoY0A4F6DZArMANDx48ePAiSfrkxz Nd 0QTN1WmIYHDx48eJEDPFUUbp/H7QBndPzw4MGDBy ClwpYGs9sBCBtDHjw4MGDty9eI6lsN3LvCjQmgzt48ODBg5c5vxuJbfvQngw0UuOsNIHhwYMHD94Y3spzGol2CntlLql3HVofePDgwYN3Ga d4Lcn39gEqeBiJcCBBw8ePHhdvJ0T8DZSuziwlJjDgwcPHrzIOsQKpoWDurHo7YR6cpzw4MGDB 9cP28ycJg88NuF8gZq5d8GDx48eC/EmyxGtxPbdkCxW1AGDx48ePAyePUqQCjoSBXNU9ijhWl48ODBgxcpRjeCkcnJt8dfCUBS/0J48ODBg3cZ766PfFYWq70JUoX12CaGBw8ePHhb5Xmpga4c8u1icWpjbRdtwoMHD94X4zUWa4eG7Q7F98aHT/DgwYMHb66YmwpeJgu77WZpPZCBBw8ePHh3nLWV5mS7QdrYWCmARpMAHjx48ODlC6 TB/JdTeNGUHZbVwEePHjwXo7XSFrbSWhqw6U26OgFDx48ePC2wpsES22myXktFSvgwYMHD97j8BrN0sY9jUL84wMWePDgwXso3mTCm0qWJwOfRrN3u2YsPHjw4H0x3g410slBtz8uSjVgH1PghgcPHry98X4BxAy5JBgfwFkAAAAASUVORK5CYII=";
        String dd = "R0lGODlhHgHBAPEAAP8AAP///wAAAAAAACH5BAEAAAEALAAAAAAeAcEAAAj/AAMIHEiwoMGDCBMqXMiwocOHECNKnEixosWLGDNq3Mixo8ePIEOKHEnyI4CTKFOqXMmyJYCSMGPKnElToMubOHPqPFmzp8+fPncKHUqUJdCjSJNGLMq0qVOUSqNKDfq0qlWmU7Nq5Xi1q1esW8OKVfi1rNmiY9NqPdtyJFujauP2ZJuVrty7IsviDaB3r1+LXf+SvSq48ELChh0iTmy4KuOKVh/jfSp5I+XKYptiDul0c1TNn+OC9kyV6NqXNlGHBUtaJtqYqh/G5pkxNsjXrd2anklb8WzVtiH2tnl7d26PxjsG57tS+GyCyw+nLDgc+dDjlq/nbZtaOPXmvqd//yeZHLtE7eSrQ4+OEPXL4ezJtnct1Pz5na4Tupc98D3f7udB1x9N6Nk3mE4EArfef4p15x+DAfa330TxNVSfge3hR6GE93HoYHi0PVihfgtC6FxtGmIoYU4X8aQeQ1Ax596DME4H3IsWQvjeiAcFx2OGCGKYImADmgjjfy4yp2SOSQIoG3geLmUQjiDeZN+QLc4YI5MM2vgjceNRKB6YS/n4pX5BtpYmRdWpFGFvcD75HZXy9bjhlNnhpCaLGIUY45lgwldkjuPR2eNzZFoI1W9c8VnZmn3uGOKg0iU6qaJhjlmjgomCKKB1ej7maHaf3ojpkkv+6CZ8Wx7oJ6r8ybRII6guMTZqo4NqelhqWsKKppZwbfqqoXau16Ryt96VrHLGAtrlpLpmSBx3RzY54YnUyVqclXsta9Kfb3ap7ZEldirftdN6F6a5edaqbKjqEirjtOiem+69ZX5K7nJuNgins4Bxqxa8zn157LOt/orvrEwiWimSwSraL8BZujsWwdj6ZuKqPLZqm6qvUkpioOVK9y+4Gq8rbMSnUVtjyf7KuiO7U9Jp6JiCylmzpwP2K/GNgGL//JnFDTr5pog04znYw1EayTTMTzOab8JVQqmU0NKiSvG9ExLrtMpVn/li0NkaXXDARB+F9cgQez2fi6vKW7PbJYs9n85k0j331jJb/dPaaPLKsMGB+p313h2KvGuxKecNWa9sCvx32v7+KfW+SFO9M9uw3V10kXrD7POTlPNWusSOz1u0tYpvfvWheNMr5tihr8gyfbeTPqPtHYN77Yi110R3m8Evyu/Wp6eX+9EeEiseyr7+1bvTtR+rOdqGK5/97FtySmjC15PmcfiHzmxso8tvm36Eqe5+KvF8d/sbw4GbbX/F29Oav5i51lv/2EISXNN4dr9IrU8jkkOgpADk/7WQqYhx59MZ9JDlsm8d8HH+MV8DW/fAA8XKdmxaWbTQt78sCdB7S/taBxV2qrIlzmQlxGAMW7QiHcVvhSgaH/d+Nrp2jRBZWkMhDoXXPIA50FU9NOAMDejC4A0RRc3iXwH39sPIrY98qOPVxm74RPZB7WWqA14FZZhE10VKgBzsYnEg2EI/9e6CPMSi4OCHN4+pESa0w9a/ole+MpYJju0DpK+4eEcpmRGMl2ugIIHkR8/xjnD6KqTw5Fiiy+GLkVWMY+jUQ8lIqlCSeBye96jmvEXOqZGHG6DcQAkUUfYPVoo05Rw7qbLisXIypgqi6jRpRFnqUpWOvOXFTAW+6rWZcowf/JgThVmXmcENlr1c4iOXWa9nMrMwbtTgEf+IylNmUlhNJOQ1J6nFVMmOjLT0JdRYNU5cwu6X2OskMjNmv2W2M0Hv3KMSvzlLewYxOrS8p1TitMt9xpKfL4yiQOXSPWmK8GbqfBofF5qZuKnvmxEF40QpuhrLbQeV81TgRjkqGt3kL6QKFCdJ56JSTFLpggF950rlp73wwdGfn5xpRWuqOZSmUafHsSlOcwfIXAK1kCyz/1n2bgq0lh41MQmkIu266SRJxfSpAURiMU+qKWXOz6lYJScN+6ir9BF0kE3tKXsAytZUNg5s+vSkyar6Q/jpEGdw82opF6nUHjJVce6bazDLecq5DZawCqWr0tgYxrSaiVVdtWoNt6rIZhlur2Wd4Vl/urnH7oyT5vJfHj/5MVW2dbFKa5PIhIi05h0WSCwEJlntSkmHzVFenm2ibstmJsaVtlNGBSYAPfdbI9m2tQx8rVs9GDZvbtBsebVp60AL3NX672usXa1pAcrYV+bKhRtT4XVzesj66S6yVM2mEGW22ON1Npz64pdvd1vE7mKXbTkzbiTpl7T+stG99xkdTP/1utmC2rC82TVacNkVXNYG9pJyJW3TEmwn7q41X3x0YrB8ulHjzQ++YAOvjkAc4QYD1sD8vS9xHVZcPJFSwlIaLfcaStU/3m/BI71wfH3kW+5mC3zite+Ig3lhUr40wOVDp2PBarPt1um/pu3xYBcoIB+LOL6ck7BaswxDLhcMrzWWopRD/NPiUpfEV6Zyzw6r4yOXysXDVa5MLQhmhIZwxeWdomrrOeYQqxnC0/2VjhPbszgLeZI+yyi5PsvJtVrZuyX+c6CB/Og0VpHH1DNwf8Gq5GnmxaV55iCmo3e8Ecp3y6i1dNJGnVoAHzpBiXZoQi0bagb3WdTRsrBdu9v/ZjaPDEeDRsqGZa3JFH4x0O1l9Zxp9uf1qrhYlV61+VId4VWmtM52BucU6xmfM++Y2lcOMiyRHW6S5dnRpIbx7Eg4vjALeouLI/MArextxqI7v/IFt7nL3e10B3uHBv3qVdE47nivc96UcnaFRs1jfPP61wzf748rHG094vXL7UZoU0FHNgTLFt7PJrJcpz3kcFO4xeAt7akr/sEoiS1iA0asRwmeXI9XV7shd221C41lcJ+cvpaauJfJa/Cgn5e2pRw576Ql4+/SmrfLVtJjAehwBFfTukDWbsRfzchkH7ufzp1ePyW7q9P+mMCIOzf1ygqxb5OZ5OZ8utOr3F45tUdwXFUtt6ct6zagnW+vfTSsN6OO9xoOnkPTdmNh58R4aGYctF7VNNElbyNPLtxvHA4v0MM6lfE2vuvQ1Gqja6x4qbt84JwH4uRpvvnLX1azzQmZVTmd+gA5C6R6B7tUu43etNf+atTMdVxdWmo/xlWvv9+TdGF4vaIiHvXJl9+LRc/WMH84+h18nusv/dfVYz+oGOUq7L/PSqHuz/nkp+gBM59+9Q/Y3e2/J4fZH/92MpXY9S//f1Hxn39JCpL+/QdK9AeAAYhUfKVoBagiBNg3OJWAVyJLCxgan9ZywgZV6hSBSbFNZxQ7FGh3hPcu/IeBc1EuB4UlxoZxgJNKtMcZGSWCsGYpzrN5GMZN3mJe3peBipY8A+Vg7MM3xaNMuTd2/MdSQzhNK4graCU3zsaBqgJXvAR/rYSADNiA5BFlD+VTF1J0e9ZCI9VMUjiFR7iB6XaF75eC1hWE60KFofSFY7dTBaRUc7dJkOGEdQSCUEiGW4EbMjVKHXcnCCdB8oaDbGiEYTiHH8c0fGhIfghd1BdVwDeIfAd9+RE5cfhyQ0eI3aSGRFiEeJgZSgaAwLZwdFh0/2g4OS5IhoVIJPoWdiE1Gv+FcsR3h7jDiU+YimK2c1/3OdumhbA4W5DoQ9mGP7K4hqfoX7UmUVt4gqWIaLSIgpL4UccohFCIPECIix9ni86oiWGjjQgEg9voUPmGjL24e8P4Uc04Y8FYEpeyi2u0iqIzjqyYjjwlj8D4jKpnW1CEimIEKcvFWaZTjPF0jhuogeRohoCVdKLDhcuojjpIjL+4iA8WizUoUW6VjIIGkAFHj3T2kPQkjzgWMG81SG2Ej8zIkVaEkZR4d8mUYrPGZRbpSNwYkOXIgg05gbkIW1K3SZZEii+pUf54UQKpPzP5OItHOgykk55ndbmnhw4ZlJAb6ZSLtnThcXpBk22NtpTlYVIoqZUmeUil55PsxE0dKJIzuIldKZRDSYGQdXmFo5IERIo5eVUxeXRpCWs1OVbb1XwbF4jMRZGBdHvYGIl1WZJd6XeB55WGRk9Dd32K2ZRQ+Y93CZJwiV0t1TG6yIEM6Yi4pJn5F5gTuZmc6YBAeZZmuZWieZGmOTQGeZqfOJi9HfWZrEmDkWmBsBmbzDebomKCtqmPGkmbtbmbWYhDwbmb8fiY0jOcwImcXVQgrMmcAqic/eecwpSV6Ued42Sdv4ed8qedQMWUOsUaRwWeYeWK7uedqdcZ2yme34ee+qee8ecYTwSfpxkZBkKfxOkVnhEYxOmL7Amai7GfjXgZXtgXAJqNZpGZbzGX85mgDNqggemADhqh9lmg8yihFuqaFHqSF+qgGTqgG/qfHTowHwqdIeqbDVqi12SPMxUQADs=";
        Img2Base64Util.GenerateImage(dd, "E:\\发票二维码12.jpg");
        System.out.println("success");
    }
}
