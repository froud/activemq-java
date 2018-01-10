package com.zzy.jms.topic;

import com.zzy.jms.common.JmsFactory;

import javax.jms.*;

/**
 * Created by zzy on 2018/1/10 0010.
 */
public class AppProducer {


    public static void main(String[] args)   throws JMSException {
        JmsFactory jmsFactory = new JmsFactory();
        //1.从工厂获取一个会话
        Session session = jmsFactory.getSession();
        //2.从工厂获取一个目标destination
        Destination destination = jmsFactory.getTopicDestination();
        //3.创建一个生产者
        MessageProducer producer = session.createProducer(destination);
        jmsFactory.sendMessage(session, producer);


    }


}
