package com.lixiaozhuo.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

/**
 * 消息队列
 * 
 * @author lxz
 *
 */
public class ActiveMqTest {
	/**
	 * 点到点形式发送信息
	 * 
	 * @throws Exception
	 */
	@Test
	public void testQueueProducer() throws Exception {
		// 创建一个连接工厂对象,需要指定服务的IP及端口
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				"tcp://192.168.25.128:61616");
		// 使用工厂对象创建一个Connection对象
		Connection connection = connectionFactory.createConnection();
		// 开启连接,调用Connection对象的start方法
		connection.start();
		// 创建一个session对象
		// 第一个参数:是否开启事务,一般不开启事务,如果开启事务,第二个参数无意义
		// 第二个参数:应答模式,一般自动应答或者手动应答,一般是自动应答
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		// 使用Session对象创建一个Destination对象,两种形式queue topic
		Queue queue = session.createQueue("test-queue");
		// 使用Session对象创建一个Producer对象
		MessageProducer producer = session.createProducer(queue);
		// 创建一个message对象,可以使用TestMessage
		/*
		 * TextMessage textMessage = new ActiveMQTextMessage();
		 * textMessage.setText("hello");
		 */
		TextMessage textMessage = session.createTextMessage("hello");
		// 发送消息
		producer.send(textMessage);
		// 关闭资源
		producer.close();
		session.close();
		connection.close();
	}

	/**
	 *  点到点形式接受消息
	 * 
	 * @throws Exception
	 */
	@Test
	public void testQueueConsumer() throws Exception {
		// 创建一个连接工厂对象,需要制定服务的IP及端口
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				"tcp://192.168.25.128:61616");
		// 使用工厂对象创建一个Connection对象
		Connection connection = connectionFactory.createConnection();
		// 开启连接,调用Connection对象的start方法
		connection.start();
		// 创建一个session对象
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		// 使用Session对象创建一个Destination对象
		Queue queue = session.createQueue("test-queue");
		// 使用Session对象创建一个消费者对象
		MessageConsumer consumer = session.createConsumer(queue);
		// 接收消息
		consumer.setMessageListener(new MessageListener() {

			@Override
			public void onMessage(Message message) {
				// 打印结果
				TextMessage textMessage = (TextMessage) message;
				String text = "";
				try {
					text = textMessage.getText();
				} catch (JMSException e) {
					e.printStackTrace();
				}
				System.out.println(text);
			}
		});
		//等待消息
		System.in.read();

		// 关闭资源
		consumer.close();
		session.close();
		connection.close();
	}
	
	
	/**
	 * 订阅方式发送信息
	 * 
	 * @throws Exception
	 */
	@Test
	public void testTopicProducer() throws Exception {
		// 创建一个连接工厂对象,需要指定服务的IP及端口
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				"tcp://192.168.25.128:61616");
		// 使用工厂对象创建一个Connection对象
		Connection connection = connectionFactory.createConnection();
		// 开启连接,调用Connection对象的start方法
		connection.start();
		// 创建一个session对象
		// 第一个参数:是否开启事务,一般不开启事务,如果开启事务,第二个参数无意义
		// 第二个参数:应答模式,一般自动应答或者手动应答,一般是自动应答
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		// 使用Session对象创建一个Destination对象,两种形式queue topic
		Topic topic = session.createTopic("test-topic");
		// 使用Session对象创建一个Producer对象
		MessageProducer producer = session.createProducer(topic);
		// 创建一个message对象,可以使用TestMessage
		/*
		 * TextMessage textMessage = new ActiveMQTextMessage();
		 * textMessage.setText("hello");
		 */
		TextMessage textMessage = session.createTextMessage("topic");
		// 发送消息
		producer.send(textMessage);
		// 关闭资源
		producer.close();
		session.close();
		connection.close();
	}

	/**
	 *  订阅接受消息
	 * 
	 * @throws Exception
	 */
	@Test
	public void testTopicConsumer() throws Exception {
		// 创建一个连接工厂对象,需要制定服务的IP及端口
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				"tcp://192.168.25.128:61616");
		// 使用工厂对象创建一个Connection对象
		Connection connection = connectionFactory.createConnection();
		// 开启连接,调用Connection对象的start方法
		connection.start();
		// 创建一个session对象
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		// 使用Session对象创建一个Destination对象
		Topic topic = session.createTopic("test-topic");
		// 使用Session对象创建一个消费者对象
		MessageConsumer consumer = session.createConsumer(topic);
		// 接收消息
		consumer.setMessageListener(new MessageListener() {

			@Override
			public void onMessage(Message message) {
				// 打印结果
				TextMessage textMessage = (TextMessage) message;
				String text = "";
				try {
					text = textMessage.getText();
				} catch (JMSException e) {
					e.printStackTrace();
				}
				System.out.println(text);
			}
		});
		//等待消息
		System.in.read();

		// 关闭资源
		consumer.close();
		session.close();
		connection.close();
	}
}
