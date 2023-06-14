package com.angu.ioc;

import com.angu.bean.Bean1;
import com.angu.bean.MyConfig;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;

import java.util.Map;

public class BeanFactoryDemo02 {
	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		AnnotationConfigUtils.registerAnnotationConfigProcessors(beanFactory);
		AbstractBeanDefinition definition = BeanDefinitionBuilder.genericBeanDefinition(MyConfig.class).getBeanDefinition();
		//手工注册配置项类
		beanFactory.registerBeanDefinition("myConfig", definition);
		Map<String, BeanFactoryPostProcessor> beansOfType = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
		for(Map.Entry<String,BeanFactoryPostProcessor> entry : beansOfType.entrySet()){
			//开始处理Bean中配置类@Configuration
			System.out.println(entry.getValue().getClass());
            entry.getValue().postProcessBeanFactory(beanFactory);
		}
		System.out.printf("bean的数量:%d\n", beanFactory.getBeanDefinitionCount());
	}
}
