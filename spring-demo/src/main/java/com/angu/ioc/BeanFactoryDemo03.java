package com.angu.ioc;

import com.angu.bean.Bean1;
import com.angu.bean.Bean2;
import com.angu.bean.MyBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigUtils;

import java.util.Map;

public class BeanFactoryDemo03 {
	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		AnnotationConfigUtils.registerAnnotationConfigProcessors(beanFactory);
		AbstractBeanDefinition definition = BeanDefinitionBuilder.genericBeanDefinition(MyBean.class).getBeanDefinition();
		//手工注册配置项类
		beanFactory.registerBeanDefinition("myBean", definition);
		AbstractBeanDefinition definition1 = BeanDefinitionBuilder.genericBeanDefinition(Bean1.class).getBeanDefinition();
		//手工注册配置项类
		beanFactory.registerBeanDefinition("bean1", definition1);
		AbstractBeanDefinition definition2 = BeanDefinitionBuilder.genericBeanDefinition(Bean2.class).getBeanDefinition();
		//手工注册配置项类
		beanFactory.registerBeanDefinition("bean2", definition2);

		Map<String, BeanFactoryPostProcessor> beansOfType1 = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
		beansOfType1.values().forEach(e -> e.postProcessBeanFactory(beanFactory));
		Map<String, BeanPostProcessor> beansOfType = beanFactory.getBeansOfType(BeanPostProcessor.class);

		for(Map.Entry<String,BeanPostProcessor> entry : beansOfType.entrySet()){
			//开始处理Bean中@Autowired @Resource注解
			System.out.println(entry.getValue().getClass());
            beanFactory.addBeanPostProcessor(entry.getValue());
		}
		//预先创建单利Bean
		beanFactory.preInstantiateSingletons();

		System.out.printf("bean的数量:%d\n", beanFactory.getBeanDefinitionCount());
		MyBean bean = beanFactory.getBean(MyBean.class);
		System.out.println(bean.getBean1());
		System.out.println(bean.getBean2());
		System.out.printf("bean的数量:%d\n", beanFactory.getBeanDefinitionCount());
	}
}
