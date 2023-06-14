package com.angu.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author  angu
 */
@Configuration
@ComponentScan("com.angu.bean")
public class FirstAnnotation {
	public static void main(String[] args) {
		FirstAnnotation firstAnnotation = new FirstAnnotation();
		AnnotationConfigApplicationContext aac = firstAnnotation.instantAnnotationConfig();
		aac.register(FirstAnnotation.class);
		aac.refresh();
		System.out.println("============================================");
		Arrays.stream(aac.getBeanDefinitionNames()).forEach(System.out::println);
	}

	/**
	 * 构造AnnotationConfigApplicationContext时
	 * 会调用父类(GenericApplicationContext)的构造方法
	 * <pre class="code">
	 *     public GenericApplicationContext() {
	 *         this.beanFactory = new DefaultListableBeanFactory();
	 *      }
	 * </pre>
	 * 这里创建的beanFactory就是
	 * {@link org.springframework.context.support.AbstractApplicationContext}
	 * refresh方法里
	 * ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();
	 * 获取的beanFactory
	 */
	public AnnotationConfigApplicationContext  instantAnnotationConfig(){
       return new AnnotationConfigApplicationContext();
	}
}
