package com.bwjf.createpdf.rabbitmq;

import com.bwjf.createpdf.entity.BwjfKpOutsideInteMailinfoBean;
import com.bwjf.createpdf.entity.SysExceptionlog;
import com.bwjf.createpdf.utils.CommonException;
import com.bwjf.createpdf.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MQSender {

	private static Logger log = LoggerFactory.getLogger(MQSender.class);
	
	@Autowired
    AmqpTemplate amqpTemplate ;

	/**
	 * 发送异常信息到交换机
	 * @param mm
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class, isolation = Isolation.SERIALIZABLE)
	public void sendExceptionLogMessage(SysExceptionlog mm) {
		String msg = CommonException.beanToString(mm);
		log.info("send message:"+msg);
		amqpTemplate.convertAndSend(MQConfig.EXCEPTION_LOG_QUEUE, msg);
	}

	/**
	 * 发送邮箱推送信息表  信息到交换机
	 * @param mailInfo
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class, isolation = Isolation.SERIALIZABLE)
	public void sendInteEmailInfo(BwjfKpOutsideInteMailinfoBean mailInfo) {
		String msg = CommonException.beanToString(mailInfo);
		log.info("send message:"+msg);
		amqpTemplate.convertAndSend(MQConfig.MAIL_INFO_QUEUE, msg);

	}

	
//	public void send(Object message) {
//		String msg = RedisService.beanToString(message);
//		log.info("send message:"+msg);
//		amqpTemplate.convertAndSend(MQConfig.QUEUE, msg);
//	}
//	
//	public void sendTopic(Object message) {
//		String msg = RedisService.beanToString(message);
//		log.info("send topic message:"+msg);
//		amqpTemplate.convertAndSend(MQConfig.TOPIC_EXCHANGE, "topic.key1", msg+"1");
//		amqpTemplate.convertAndSend(MQConfig.TOPIC_EXCHANGE, "topic.key2", msg+"2");
//	}
//	
//	public void sendFanout(Object message) {
//		String msg = RedisService.beanToString(message);
//		log.info("send fanout message:"+msg);
//		amqpTemplate.convertAndSend(MQConfig.FANOUT_EXCHANGE, "", msg);
//	}
//	
//	public void sendHeader(Object message) {
//		String msg = RedisService.beanToString(message);
//		log.info("send fanout message:"+msg);
//		MessageProperties properties = new MessageProperties();
//		properties.setHeader("header1", "value1");
//		properties.setHeader("header2", "value2");
//		Message obj = new Message(msg.getBytes(), properties);
//		amqpTemplate.convertAndSend(MQConfig.HEADERS_EXCHANGE, "", obj);
//	}

	
	
}
