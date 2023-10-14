package com.angu.ioc;

import com.angu.bean.ServiceBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class FirstAnnotation {
	public static void main(String[] args) {
		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("classpath:beans.xml");
		//打印Spring容器中的Bean信息
		//Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
		ServiceBean bean = applicationContext.getBean(ServiceBean.class);
		//System.out.println(bean);
		System.out.println(bean.getBean1());
	}
}
