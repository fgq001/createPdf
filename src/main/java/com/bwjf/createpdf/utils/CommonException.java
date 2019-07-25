package com.bwjf.createpdf.utils;


import com.alibaba.fastjson.JSON;
import com.bwjf.createpdf.constant.ConfigureConstant;
import com.bwjf.createpdf.dao.SysExceptionlogDao;
import com.bwjf.createpdf.entity.SysExceptionlog;
import com.bwjf.createpdf.rabbitmq.MQSender;
import com.bwjf.createpdf.redis.JedisClient;
import com.bwjf.createpdf.result.CodeMsg;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * Title: CommonUtils
 * </p>
 * <p>
 * Description: 公共工具类
 * </p>
 * <p>
 * Company: 百旺金赋
 * </p>
 *
 * @author zht
 * @date 上午10:26:15
 */
@Component
public class CommonException {


   /* @Autowired
    private SysExceptionlogDao sysExceptionlogDao;*/

    /*@Autowired
    private static MQSender sender;*/

    // 注入 redis
   /* @Autowired
    private static JedisClient jedisClient;*/

    /**
     * @Title: saveExceptionInfo
     * @Description: 存储异常信息 @param @param sysExceptionlog 设定文件 @return void
     * 返回类型 @throws
     */

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class, isolation = Isolation.SERIALIZABLE)
    public static int saveExceptionInfo(Map<String, Object> params) {
        SysExceptionlog sysExceptionlog = new SysExceptionlog();

        String exceptionInfo = params.get("exceptionInfo") == null ? "" : params.get("exceptionInfo").toString().trim();
        String requestUrl = params.get("requestUrl") == null ? "" : params.get("requestUrl").toString().trim();
        String requestParam = params.get("requestParam") == null ? "" : params.get("requestParam").toString().trim();
        // 异常来源(1:全局异常 2:方法异常)
        String exceptionDatasource = params.get("exceptionDatasource") == null ? ""
                : params.get("exceptionDatasource").toString().trim();
        String exceptionClass = params.get("exceptionClass") == null ? ""
                : params.get("exceptionClass").toString().trim();
        String exceptionMethod = params.get("exceptionMethod") == null ? ""
                : params.get("exceptionMethod").toString().trim();

        sysExceptionlog.setRequestUrl(requestUrl);
        sysExceptionlog.setRequestParam(requestParam);
        sysExceptionlog.setExceptionInfo(exceptionInfo);
        sysExceptionlog.setExceptionClass(exceptionClass);
        sysExceptionlog.setExceptionMethod(exceptionMethod);
        sysExceptionlog.setExceptionDatasource(exceptionDatasource);
        sysExceptionlog.setCreteTime(new Date());
        //获取的是本地的IP地址 192.168.0.121
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String hostAddress = address.getHostAddress();//192.168.0.121
        sysExceptionlog.setExceprionServer(hostAddress + ConfigureConstant.SERVER_NAME);

        MQSender sender = SpringTool.getBean(MQSender.class);
        //发送到rabbitMQ
        sender.sendExceptionLogMessage(sysExceptionlog);

        /*7.1 **/
        //将数据集合存入redis，定时去取数据  并存入数据库
       /* List<SysExceptionlogMessage> exceptionList = null;
        int saveResult = 0;*/


        /*exceptionList = (List<SysExceptionlogMessage>) jedisClient.getList("sys_exceptionlog");
        if(exceptionList != null){
            if(exceptionList.size() > 0){
                exceptionList.add(sysExceptionlog);
                saveResult = 1;
            }else{
                exceptionList.add(sysExceptionlog);
                jedisClient.setList("sys_exceptionlog",exceptionList);
                saveResult = 1;
            }
        }else{
            exceptionList.add(sysExceptionlog);
            jedisClient.setList("sys_exceptionlog",exceptionList);
            saveResult = 1;
        }*/
        // 调用此方法，可以在普通的class中调用service或者dao的方法
        /*SysExceptionlogDao sysExceptionlogDao = SpringTool.getBean(SysExceptionlogDao.class);
        int saveExceptionResult = sysExceptionlogDao.saveExceptionLogInfo(sysExceptionlog);*/
        // 发送异常信息到邮箱
        sendEmail(ConfigureConstant.EMAIL_SUBJECT, params);

        return 1;
    }


    /**
     * @Title: sendEmail @Description: 发送邮箱 @param @param EmailContent
     * 邮件内容 @param @param emailAdress 邮箱地址 @param @param emailSubject
     * 邮件标题 @return void 返回类型 @throws
     */
    public static void sendEmailBaseMethod(String emailSubject, String htmlContent) {

        try {
//            String htmlContent = getExceptionInfoToEmail(params);
            Properties prop = new Properties();
            prop.setProperty("mail.transport.protocol", "smtp"); // 协议
            prop.setProperty("mail.smtp.host", "mail.nebulasystem.com.cn"); // 主机名
            prop.setProperty("mail.smtp.auth", "true"); // 是否开启权限控制
            prop.setProperty("mail.debug", "true"); // 返回发送的cmd源码
            Session session = Session.getInstance(prop);
            Message msg = new MimeMessage(session);
            // msg.setFrom(new InternetAddress("support@nebulasystem.com.cn"));
            // // 自己的email
            msg.setFrom(new InternetAddress("support@nebulasystem.com.cn")); // 自己的email
            // msg.setFrom(new InternetAddress("lojacui@126.com")); // 自己的email

            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(ConfigureConstant.EMAIL_ADDRESS)); // 要发送的email，可以设置数组
            msg.setSubject(emailSubject); // 邮件标题
            // msg.setContent("", "text/html");
            // 邮件内容 begin
            Multipart mainPart = new MimeMultipart();
            // 创建一个包含HTML内容的MimeBodyPart
            BodyPart html = new MimeBodyPart();
            // 设置HTML内容
            html.setContent(htmlContent, "text/html; charset=utf-8");
            mainPart.addBodyPart(html);
            // 将MiniMultipart对象设置为邮件内容
            msg.setContent(mainPart);
            // 邮件内容 end
            // msg.setText("请你于4:30到办公室开会");//邮件正文
            // 不被当作垃圾邮件的关键代码--Begin ，如果不加这些代码，发送的邮件会自动进入对方的垃圾邮件列表
            msg.addHeader("X-Priority", "3");
            msg.addHeader("X-MSMail-Priority", "Normal");
            msg.addHeader("X-Mailer", "Microsoft Outlook Express 6.00.2900.2869"); // 本文以outlook名义发送邮件，不会被当作垃圾邮件
            msg.addHeader("X-MimeOLE", "Produced By Microsoft MimeOLE V6.00.2900.2869");
            msg.addHeader("ReturnReceipt", "1");
            // 不被当作垃圾邮件的关键代码--end
            Transport trans = session.getTransport();
            trans.connect("support", "Aa123456"); // 邮件的账号密码
            trans.sendMessage(msg, msg.getAllRecipients());
            System.out.println("------------------已经发送----------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @Title: sendEmail @Description: 异常信息发送邮箱 @param @param EmailContent
     * 邮件内容 @param @param emailAdress 邮箱地址 @param @param emailSubject
     * 邮件标题 @return void 返回类型 @throws
     */
    public static void sendEmail(String emailSubject, Map<String, Object> params) {

        try {
            String htmlContent = getExceptionInfoToEmail(params);
            Properties prop = new Properties();
            prop.setProperty("mail.transport.protocol", "smtp"); // 协议
            prop.setProperty("mail.smtp.host", "mail.nebulasystem.com.cn"); // 主机名
            prop.setProperty("mail.smtp.auth", "true"); // 是否开启权限控制
            prop.setProperty("mail.debug", "true"); // 返回发送的cmd源码
            Session session = Session.getInstance(prop);
            Message msg = new MimeMessage(session);
            // msg.setFrom(new InternetAddress("support@nebulasystem.com.cn"));
            // // 自己的email
            msg.setFrom(new InternetAddress("support@nebulasystem.com.cn")); // 自己的email
            // msg.setFrom(new InternetAddress("lojacui@126.com")); // 自己的email

            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(ConfigureConstant.EMAIL_ADDRESS)); // 要发送的email，可以设置数组
            msg.setSubject(emailSubject); // 邮件标题
            // msg.setContent("", "text/html");
            // 邮件内容 begin
            Multipart mainPart = new MimeMultipart();
            // 创建一个包含HTML内容的MimeBodyPart
            BodyPart html = new MimeBodyPart();
            // 设置HTML内容
            html.setContent(htmlContent, "text/html; charset=utf-8");
            mainPart.addBodyPart(html);
            // 将MiniMultipart对象设置为邮件内容
            msg.setContent(mainPart);
            // 邮件内容 end
            // msg.setText("请你于4:30到办公室开会");//邮件正文
            // 不被当作垃圾邮件的关键代码--Begin ，如果不加这些代码，发送的邮件会自动进入对方的垃圾邮件列表
            msg.addHeader("X-Priority", "3");
            msg.addHeader("X-MSMail-Priority", "Normal");
            msg.addHeader("X-Mailer", "Microsoft Outlook Express 6.00.2900.2869"); // 本文以outlook名义发送邮件，不会被当作垃圾邮件
            msg.addHeader("X-MimeOLE", "Produced By Microsoft MimeOLE V6.00.2900.2869");
            msg.addHeader("ReturnReceipt", "1");
            // 不被当作垃圾邮件的关键代码--end
            Transport trans = session.getTransport();
            trans.connect("support", "Aa123456"); // 邮件的账号密码
            trans.sendMessage(msg, msg.getAllRecipients());
            System.out.println("------------------已经发送----------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getExceptionInfoToEmail(Map<String, Object> params) throws UnknownHostException {
        // 异常来源(1:全局异常 2:方法异常)
        String exceptionDatasource = params.get("exceptionDatasource") == null ? ""
                : params.get("exceptionDatasource").toString().trim();
        String exceptionInfo = params.get("exceptionInfo") == null ? "" : params.get("exceptionInfo").toString().trim();
        String requestUrl = params.get("requestUrl") == null ? "" : params.get("requestUrl").toString().trim();
        String requestParam = params.get("requestParam") == null ? "" : params.get("requestParam").toString().trim();
        String exceptionClass = params.get("exceptionClass") == null ? ""
                : params.get("exceptionClass").toString().trim();
        String exceptionMethod = params.get("exceptionMethod") == null ? ""
                : params.get("exceptionMethod").toString().trim();

        StringBuffer htmlContent = new StringBuffer();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");// 设置日期格式
        htmlContent.append("<!DOCTYPE html>");
        htmlContent.append("<html>");
        htmlContent.append("<head>");
        htmlContent.append("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />");
        htmlContent.append("<title>异常信息</title>");
        htmlContent.append("</head>");
        htmlContent.append("<body>");
        htmlContent.append("<table border='0' cellspacing='0' cellpadding='0'>");
        htmlContent.append("<tr>");
        htmlContent.append("<td>");
        //获取的是本地的IP地址 192.168.0.121
        InetAddress address = InetAddress.getLocalHost();
        String hostAddress = address.getHostAddress();//192.168.0.121
        //异常来源(1:全局异常 2:方法异常)
        if (exceptionDatasource.equals("1")) {
            htmlContent.append("发生异常日期:" + df.format(new Date()) + "服务器ip" + hostAddress + "===请求URL:" + requestUrl + "请求参数=" + requestParam);
        } else {
            htmlContent.append("发生异常日期:" + df.format(new Date()) + "服务器ip" + hostAddress + "===异常错误类:" + exceptionClass + "===异常方法:" + exceptionMethod);
        }

        htmlContent.append("</td>");
        htmlContent.append("</tr>");
        htmlContent.append("<hr />");
        htmlContent.append("<hr />");
        htmlContent.append("<tr>");
        htmlContent.append("<td>");
        htmlContent.append("异常信息如下:");
        htmlContent.append("</td>");
        htmlContent.append("<td>");
        htmlContent.append(exceptionInfo);
        htmlContent.append("</td>");
        htmlContent.append("</tr>");
        htmlContent.append("</table>");
        htmlContent.append("</body>");
        htmlContent.append("</html>");
        return htmlContent.toString();
    }


    public static void main(String[] args) {
        /*
         * SysExceptionlogMessage sysExceptionlog = new SysExceptionlogMessage();
		 * sysExceptionlog.setExceptionInfo("错误"); int saveExceptionInfo =
		 * CommonUtils.saveExceptionInfo(sysExceptionlog);
		 * System.out.println(saveExceptionInfo);
		 */
        try {
            // System.out.println(1 / 0);//会抛出ArithmeticException
            // System.out.println(new int[]
            // {}[0]);//会抛出ArrayIndexOutOfBoundsException
            String str = null;
            System.out.println(str.toString());// 会抛出NullPointerException
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

            sendEmail(ConfigureConstant.EMAIL_SUBJECT, new HashMap<String, Object>());
            // String exception = getException(e);
            // System.out.println(exception);
        }
    }

    /**
     * 将异常日志转换为字符串
     *
     * @param e
     * @return
     */
    public static String getException(Exception e) {
        Writer writer = null;
        PrintWriter printWriter = null;
        try {
            writer = new StringWriter();
            printWriter = new PrintWriter(writer);
            e.printStackTrace(printWriter);
            return writer.toString();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    // 拼接错误日志
    public static JSONObject getErrorInfo(CodeMsg msg) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("msg", msg.getMsg());
        params.put("result", msg.getResult());
        params.put("rows", msg.getRows());
        params.put("code", msg.getCode());
        JSONObject json = JSONObject.fromObject(params);
        // doBlueResult = json.toString();
        return json;
    }

    public static <T> String beanToString(T value) {
        if (value == null) {
            return null;
        }
        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class) {
            return "" + value;
        } else if (clazz == String.class) {
            return (String) value;
        } else if (clazz == long.class || clazz == Long.class) {
            return "" + value;
        } else {
            return JSON.toJSONString(value);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T stringToBean(String str, Class<T> clazz) {
        if (str == null || str.length() <= 0 || clazz == null) {
            return null;
        }
        if (clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(str);
        } else if (clazz == String.class) {
            return (T) str;
        } else if (clazz == long.class || clazz == Long.class) {
            return (T) Long.valueOf(str);
        } else {
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }

    /**
     * 获取ip地址
     *
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (int index = 0; index < ips.length; index++) {
                String strIp = (String) ips[index];
                if (!("unknown".equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    break;
                }
            }
        }
        return ip;
    }

    /**
     * 验证邮箱格式
     * @param string
     * @return
     */
    public static boolean isEmail(String string) {
        if (string == null){
            return false;
        }
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(string);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }

    }


}
