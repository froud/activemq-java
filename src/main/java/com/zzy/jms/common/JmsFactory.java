package com.zzy.jms.common;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by zzy on 2018/1/10 0010.
 */
public class JmsFactory {
    private  static  final String url = "tcp://127.0.0.1:61616";
    private  static  final String queueName = "Queue-test";
    private  static  final String topicName = "Topic-test";

    public Session getSession() throws JMSException {
        //1.创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        //2.获取连接
        Connection connection = connectionFactory.createConnection();
        //3.启动连接
        connection.start();
        //4.创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        return session;
    }


    public Destination getTopicDestination() throws JMSException {
        Session session = getSession();
        Destination destination = session.createTopic(topicName);
        return  destination;
    }
    public Destination getQueueDestination() throws JMSException {
        Session session = getSession();
        Destination destination = session.createQueue(queueName);
        return  destination;
    }
    public  void sendMessage(Session session, MessageProducer producer) throws JMSException {
        //2.发送消息
        for (int i = 0; i < 100; i++) {
            TextMessage textMessage;
            textMessage = session.createTextMessage("test-Topic"+i);
            producer.send(textMessage);
            System.out.println("发送消息为："+textMessage.getText());
        }
    }
    public  void getMessage(MessageConsumer consumer) throws JMSException {
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("接受到的消息为: " +textMessage.getText() );
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
