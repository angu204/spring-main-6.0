package com.angu.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan("com.angu")
public class FirstAnnotation {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext aac =
				new AnnotationConfigApplicationContext(FirstAnnotation.class);
		Arrays.stream(aac.getBeanDefinitionNames()).forEach(System.out::println);
	}
}
