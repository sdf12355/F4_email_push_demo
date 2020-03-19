package com.yonyou.email;

import java.util.Properties;

import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * 本类测试html邮件
 * 
 * @author wangjianme
 * 
 */
public class HTMLMailDemo {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();

		// 设定mail server
		senderImpl.setHost("mail.ufida.com.cn");

		// 建立邮件消息,发送简单邮件和html邮件的区别
		MimeMessage mailMessage = senderImpl.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage);

		// 设置收件人，寄件人
		messageHelper.setTo("791023034@qq.com");  // 收件人
		messageHelper.setFrom("duxg1@yonyou.com"); //寄件人
		messageHelper.setSubject("测试HTML邮件！");
		// true 表示启动HTML格式的邮件
		messageHelper.setText("<html><head></head><body><h1>hello!!spring html Mail</h1></body></html>", true);

		senderImpl.setUsername("duxg1@yonyou.com");// 根据自己的情况,设置username
		senderImpl.setPassword("yonyou@1988"); // 根据自己的情况, 设置password
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
		prop.put("mail.smtp.timeout", "25000");
		senderImpl.setJavaMailProperties(prop);
		// 发送邮件
		senderImpl.send(mailMessage);

		System.out.println("html邮件发送成功..");
	}
}
