package com.bwjf.createpdf.rabbitmq;


import com.bwjf.createpdf.dao.BwjfKpOutsideInteMailinfoDao;
import com.bwjf.createpdf.dao.SysExceptionlogDao;
import com.bwjf.createpdf.entity.BwjfKpOutsideInteMailinfoBean;
import com.bwjf.createpdf.entity.SysExceptionlog;
import com.bwjf.createpdf.service.SendEmailService;
import com.bwjf.createpdf.utils.CommonUtils;
import com.bwjf.createpdf.utils.CommonException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MQReceiver {

    private static Logger log = LoggerFactory.getLogger(MQReceiver.class);


    @Autowired
    private SysExceptionlogDao sysExceptionlogDao;

    @Autowired
    private BwjfKpOutsideInteMailinfoDao kpOutsideInteMailinfoDao;

    @Autowired
    private SendEmailService sendmailService;


    /**
     * 发送邮件相关
     * @param message
     */
    @RabbitListener(queues = MQConfig.MAIL_INFO_QUEUE)
    public void receiveMailInfo(String message) {
        log.info("receive message:" + message);
        BwjfKpOutsideInteMailinfoBean mailInfo = CommonException.stringToBean(message, BwjfKpOutsideInteMailinfoBean.class);

        //发送邮件
        sendmailService.sendEmail(mailInfo.getKoibId(),mailInfo.getMailAddress());
        //保存信息
        mailInfo.setPushDate(new Date());
		mailInfo.setPushCount("1");
        int saveResult = kpOutsideInteMailinfoDao.saveMailInfo(mailInfo);

    }


    /**
     * 异常信息事务
     * @param message
     */
    @RabbitListener(queues = MQConfig.EXCEPTION_LOG_QUEUE)
    public void receiveExceptionLog(String message) {
        log.info("receive message:" + message);
        //存储异常信息
        SysExceptionlog sysExceptionlog = CommonException.stringToBean(message, SysExceptionlog.class);
        sysExceptionlogDao.saveExceptionLogInfo(sysExceptionlog);

			/*MiaoshaMessage mm  = RedisService.stringToBean(message, MiaoshaMessage.class);
			MiaoshaUser user = mm.getUser();
			long goodsId = mm.getGoodsId();
			
			GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
	    	int stock = goods.getStockCount();
	    	if(stock <= 0) {
	    		return;
	    	}
	    	//判断是否已经秒杀到了
	    	MiaoshaOrder order = orderService.getMiaoshaOrderByUserIdGoodsId(user.getId(), goodsId);
	    	if(order != null) {
	    		return;
	    	}
	    	//减库存 下订单 写入秒杀订单
	    	miaoshaService.miaosha(user, goods);*/
    }

//		@RabbitListener(queues=MQConfig.QUEUE)
//		public void receive(String message) {
//			log.info("receive message:"+message);
//		}
//		
//		@RabbitListener(queues=MQConfig.TOPIC_QUEUE1)
//		public void receiveTopic1(String message) {
//			log.info(" topic  queue1 message:"+message);
//		}
//		
//		@RabbitListener(queues=MQConfig.TOPIC_QUEUE2)
//		public void receiveTopic2(String message) {
//			log.info(" topic  queue2 message:"+message);
//		}
//		
//		@RabbitListener(queues=MQConfig.HEADER_QUEUE)
//		public void receiveHeaderQueue(byte[] message) {
//			log.info(" header  queue message:"+new String(message));
//		}
//		

}
