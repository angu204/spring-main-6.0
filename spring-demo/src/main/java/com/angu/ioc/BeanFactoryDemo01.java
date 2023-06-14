package com.angu.ioc;

import com.angu.bean.Bean1;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;

public class BeanFactoryDemo01 {
	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		System.out.printf("bean的数量:%d\n", beanFactory.getBeanDefinitionCount());
		//手工注册beanDefinition
		AbstractBeanDefinition definition = BeanDefinitionBuilder.genericBeanDefinition(Bean1.class).getBeanDefinition();
		beanFactory.registerBeanDefinition("bean1", definition);
		System.out.printf("bean的数量:%d\n", beanFactory.getBeanDefinitionCount());
		beanFactory.getBean(Bean1.class);
		//手工注册beanPostProcess
		AnnotationConfigUtils.registerAnnotationConfigProcessors(beanFactory);
		System.out.printf("bean的数量:%d\n", beanFactory.getBeanDefinitionCount());
	}
}
