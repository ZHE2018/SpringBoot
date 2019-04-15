package com.websocket.websocketdemo;

import freemarker.template.Template;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WebsocketdemoApplicationTests {

	@Test
	public void contextLoads() {

		ExecutorService service = Executors.newCachedThreadPool();
		Lock lock = new ReentrantLock();
		Object o = new Object();
		JavaMailSender sender = new JavaMailSenderImpl();
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		TemplateEngine templateEngine;
	}


}
