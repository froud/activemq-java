package com.zzy.jms.queue;

import com.zzy.jms.common.JmsFactory;

import javax.jms.*;

/**
 * Created by zzy on 2018/1/10 0010.
 */
public class AppConsumer {
    public static void main(String[] args) throws JMSException {
        JmsFactory jmsFactory = new JmsFactory();
        //1.从工厂获取一个会话
        Session session = jmsFactory.getSession();
        //2.从工厂获取一个目标destination
        Destination destination = jmsFactory.getQueueDestination();
        //3.创建一个消费者
        MessageConsumer consumer = session.createConsumer(destination);
        jmsFactory.getMessage(consumer);


    }
}
