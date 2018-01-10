package com.zzy.jms.queue;

import com.zzy.jms.common.JmsFactory;

import javax.jms.*;

/**
 * Created by zzy on 2018/1/10 0010.
 */
public class AppConsumer {
    public static void main(String[] args) throws JMSException {
        JmsFactory jmsFactory = new JmsFactory();
        //1.�ӹ�����ȡһ���Ự
        Session session = jmsFactory.getSession();
        //2.�ӹ�����ȡһ��Ŀ��destination
        Destination destination = jmsFactory.getQueueDestination();
        //3.����һ��������
        MessageConsumer consumer = session.createConsumer(destination);
        jmsFactory.getMessage(consumer);


    }
}
