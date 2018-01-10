package com.zzy.jms.topic;

import com.zzy.jms.common.JmsFactory;

import javax.jms.*;

/**
 * Created by zzy on 2018/1/10 0010.
 */
public class AppProducer {


    public static void main(String[] args)   throws JMSException {
        JmsFactory jmsFactory = new JmsFactory();
        //1.�ӹ�����ȡһ���Ự
        Session session = jmsFactory.getSession();
        //2.�ӹ�����ȡһ��Ŀ��destination
        Destination destination = jmsFactory.getTopicDestination();
        //3.����һ��������
        MessageProducer producer = session.createProducer(destination);
        jmsFactory.sendMessage(session, producer);


    }


}
