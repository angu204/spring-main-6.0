package com.angu.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class FirstAnnotation {
	public static void main(String[] args) {
		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("classpath:beans.xml");

		Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
	}
}
