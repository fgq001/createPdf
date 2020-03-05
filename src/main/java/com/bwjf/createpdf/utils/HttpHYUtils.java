package com.bwjf.createpdf.utils;


import net.sf.json.JSONObject;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HttpHYUtils {

    private static final Log logger = LogFactory.getLog(HttpHYUtils.class);

    private static PoolingHttpClientConnectionManager connMgr;
    private static RequestConfig requestConfig;
    private static final int MAX_TIMEOUT = 2 * 60 * 1000;

    static {
        // 设置连接池
        connMgr = new PoolingHttpClientConnectionManager();
        // 设置连接池大小
        connMgr.setMaxTotal(100);
        connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());

        RequestConfig.Builder configBuilder = RequestConfig.custom();
        // 设置连接超时
        configBuilder.setConnectTimeout(MAX_TIMEOUT);
        // 设置读取超时
        configBuilder.setSocketTimeout(MAX_TIMEOUT);
        // 设置从连接池获取连接实例的超时
        configBuilder.setConnectionRequestTimeout(MAX_TIMEOUT);
        // 在提交请求之前 测试连接是否可用
//        configBuilder.setStaleConnectionCheckEnabled(true);
        requestConfig = configBuilder.build();
    }

    /**
     * 发送 POST 请求（HTTP），K-V形式
     *
     * @param apiUrl API接口URL
     * @param params 参数map
     * @return
     */
    public static JSONObject doPostJSON(String apiUrl, Map<String, Object> params) {
        JSONObject json = null;
        try {
            String result = doPost(apiUrl, params);
            json = JSONObject.fromObject(result);
        } catch (Exception e) {
            logger.error(e);
            JSONObject error = new JSONObject();
            error.put("requestURL", apiUrl);
            error.put("param", params);
            throw new RuntimeException(error.toString(), e);
        }
        return json;
    }

    /**
     * 发送 GET 请求（HTTP），不带输入数据
     *
     * @param url
     * @return
     */
    public static String doGet(String url) {
        return doGet(url, new HashMap<String, Object>());
    }

    /**
     * 发送 GET 请求（HTTP），字符串形式
     *
     * @param url
     * @return
     */

    public static String doGet(String url, String params) {
        String apiUrl = url;
        apiUrl += params;
        logger.debug("doget: url=" + apiUrl);
        String result = null;
        CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(connMgr)
                .setDefaultRequestConfig(requestConfig).build();
        try {
            HttpGet httpPost = new HttpGet(apiUrl);
            HttpResponse response = httpclient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();

            logger.debug("执行状态码 : " + statusCode);

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
                result = IOUtils.toString(instream, "UTF-8");
            }
        } catch (IOException e) {
            JSONObject error = new JSONObject();
            error.put("requestURL", apiUrl);
            error.put("param", params);
            throw new RuntimeException(error.toString(), e);
        }
        logger.debug("doget: url=" + apiUrl + "; result" + result);
        return result;
    }

    /**
     * 发送 GET 请求（HTTP），K-V形式
     *
     * @param url
     * @param params
     * @return
     */
    public static String doGet(String url, Map<String, Object> params) {

        String apiUrl = url;
        StringBuffer param = new StringBuffer();
        int i = 0;
        for (String key : params.keySet()) {
            if (i == 0)
                param.append("?");
            else
                param.append("&");
            param.append(key).append("=").append(params.get(key));
            i++;
        }
        apiUrl += param;
        logger.debug("doGet: url=" + apiUrl);
        String result = null;
        CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(connMgr)
                .setDefaultRequestConfig(requestConfig).build();
        try {
            HttpGet httpPost = new HttpGet(apiUrl);
            HttpResponse response = httpclient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();

            logger.debug("执行状态码 : " + statusCode);

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
                result = IOUtils.toString(instream, "UTF-8");
            }
        } catch (IOException e) {
            JSONObject error = new JSONObject();
            error.put("requestURL", apiUrl);
            error.put("param", params);
            throw new RuntimeException(error.toString(), e);
        }
        logger.debug("doget: url=" + apiUrl + "; result" + result);
        return result;
    }

    /**
     * 发送 POST 请求（HTTP），不带输入数据
     *
     * @param apiUrl
     * @return
     */
    public static String doPost(String apiUrl) {
        return doPost(apiUrl, new HashMap<String, Object>());
    }


    /**
     * 发送post请求
     * 带参数
     * 请求头 application/x-www-form-urlencoded
     * @param urlParam
     * @param params
     * @param charset
     * @return
     */
    public static String sendPostData(String urlParam, Map<String, String> params, String charset) {
        StringBuffer resultBuffer = null;
        // 构建请求参数
        StringBuffer sbParams = new StringBuffer();
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, String> e : params.entrySet()) {
                sbParams.append(e.getKey());
                sbParams.append("=");
                sbParams.append(e.getValue());
                sbParams.append("&");
            }
        }
        URLConnection con = null;
        OutputStreamWriter osw = null;
        BufferedReader br = null;
        try {
            URL realUrl = new URL(urlParam);
            // 打开和URL之间的连接
            con = realUrl.openConnection();
            // 设置通用的请求属性
            con.setRequestProperty("accept", "*/*");
            con.setRequestProperty("connection", "Keep-Alive");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            con.setDoOutput(true);
            con.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            osw = new OutputStreamWriter(con.getOutputStream(), charset);
            if (sbParams != null && sbParams.length() > 0) {
                // 发送请求参数
                osw.write(sbParams.substring(0, sbParams.length() - 1));
                // flush输出流的缓冲
                osw.flush();
            }
            // 定义BufferedReader输入流来读取URL的响应
            resultBuffer = new StringBuffer();
            String headerField = con.getHeaderField("Content-Length");
            System.out.println("headerField=="+headerField);
//            int contentLength = Integer.parseInt(con.getHeaderField("Content-Length"));
//            if (contentLength > 0) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));
                String temp;
                while ((temp = br.readLine()) != null) {
                    resultBuffer.append(temp);
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    osw = null;
                    throw new RuntimeException(e);
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    br = null;
                    throw new RuntimeException(e);
                }
            }
        }
        return resultBuffer.toString();
    }


    /**
     * 发送 POST 请求（HTTP），K-V形式
     *
     * @param apiUrl API接口URL
     * @param params 参数map
     * @return
     */
    public static String doPost(String apiUrl, Map<String, Object> params) {
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connMgr)
                .setDefaultRequestConfig(requestConfig).build();

        String httpStr = null;
        HttpPost httpPost = new HttpPost(apiUrl);
        CloseableHttpResponse response = null;
        logger.debug("doPost: url=" + apiUrl + "; params" + params);
        try {
            httpPost.setConfig(requestConfig);
            List<NameValuePair> pairList = new ArrayList<NameValuePair>(params.size());
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
                pairList.add(pair);
            }
            httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName("UTF-8")));
            response = httpClient.execute(httpPost);
            logger.debug(response.toString());
            HttpEntity entity = response.getEntity();
            httpStr = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException e) {
            JSONObject error = new JSONObject();
            error.put("requestURL", apiUrl);
            error.put("param", params);
            throw new RuntimeException(error.toString(), e);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    JSONObject error = new JSONObject();
                    error.put("requestURL", apiUrl);
                    error.put("param", params);
                    throw new RuntimeException(error.toString(), e);
                }
            }
        }
        logger.debug("doPost: url=" + apiUrl + "; result" + httpStr);
        return httpStr;
    }

    /**
     * 发送 SSL POST 请求（HTTP），JSON形式
     *
     * @param apiUrl API接口URL
     * @param json   JSON对象
     * @return
     */
    public static JSONObject doPostJSON2(String apiUrl, Object json) {
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connMgr)
                .setDefaultRequestConfig(requestConfig).build();
        HttpPost httpPost = new HttpPost(apiUrl);
        CloseableHttpResponse response = null;
        String httpStr = null;

        try {
            httpPost.setConfig(requestConfig);
            StringEntity stringEntity = new StringEntity(json.toString(), "UTF-8");// 解决中文乱码问题
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                return null;
            }
            HttpEntity entity = response.getEntity();
            if (entity == null) {
                return null;
            }
            httpStr = EntityUtils.toString(entity, "utf-8");
        } catch (Exception e) {
            JSONObject error = new JSONObject();
            error.put("requestURL", apiUrl);
            error.put("param", json);
            throw new RuntimeException(error.toString(), e);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    JSONObject error = new JSONObject();
                    error.put("requestURL", apiUrl);
                    error.put("param", json);
                    throw new RuntimeException(error.toString(), e);
                }
            }
        }
        return JSONObject.fromObject(httpStr);
    }

    public static String doPostEncode(String apiUrl, Object content, String encode) {
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connMgr)
                .setDefaultRequestConfig(requestConfig).build();
        HttpPost httpPost = new HttpPost(apiUrl);
        CloseableHttpResponse response = null;
        String httpStr = null;
        encode = encode == null || "".equals(encode) ? "UTF-8" : encode;
        try {
            httpPost.setConfig(requestConfig);
            StringEntity stringEntity = new StringEntity(content.toString(), encode);// 解决中文乱码问题
            stringEntity.setContentEncoding(encode);
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                return null;
            }
            HttpEntity entity = response.getEntity();
            if (entity == null) {
                return null;
            }
            httpStr = EntityUtils.toString(entity, encode);
        } catch (Exception e) {
            JSONObject error = new JSONObject();
            error.put("requestURL", apiUrl);
            error.put("param", content);
            throw new RuntimeException(error.toString(), e);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    JSONObject error = new JSONObject();
                    error.put("requestURL", apiUrl);
                    error.put("param", content);
                    throw new RuntimeException(error.toString(), e);
                }
            }
        }
        return httpStr;
    }

    /**
     * 发送 POST 请求（HTTP），JSON形式
     *
     * @param apiUrl
     * @param json   json对象
     * @return
     */
    public static String doPostJSON(String apiUrl, Object json) {
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connMgr)
                .setDefaultRequestConfig(requestConfig).build();
        String httpStr = null;
        HttpPost httpPost = new HttpPost(apiUrl);
        CloseableHttpResponse response = null;

        try {
            httpPost.setConfig(requestConfig);
            StringEntity stringEntity = new StringEntity(json.toString(), "UTF-8");// 解决中文乱码问题
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            logger.debug(response.getStatusLine().getStatusCode());
            httpStr = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException e) {
            JSONObject error = new JSONObject();
            error.put("requestURL", apiUrl);
            error.put("param", json);
            throw new RuntimeException(error.toString(), e);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    JSONObject error = new JSONObject();
                    error.put("requestURL", apiUrl);
                    error.put("param", json);
                    throw new RuntimeException(error.toString(), e);
                }
            }
        }
        return httpStr;
    }

    public static void main(String[] args) {
        String apiUrl = "https://www.fp365.com.cn:8888/TicketDownAndUploadController/toDownLoadPdf?fptqm=81B6NV";
        Map<String, Object> params = new HashMap<>();
        params.put("fptqm","81B6NV");
        String s = doPost(apiUrl, params);

        //3、String写入OutputStream
        OutputStream os = System.out;
        try {
            os.write(s.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(s);

    }

}
