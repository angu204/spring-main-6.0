package com.angu.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.BeanProperty;

@Configuration
public class MyConfig {
	@Bean
	public Bean1 getBean1() {
		return new Bean1();
	}

	@Bean
	public Bean2 getBean2() {
		return new Bean2();
	}

}
