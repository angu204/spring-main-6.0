package com.angu.bean;


import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceBean implements BeanNameAware {

	private Bean1 bean1;
	@Autowired
	private Bean2 Bean2;

	public ServiceBean() {
		System.out.println("调用 ServiceBean的构造方法");
	}

	public Bean1 getBean1() {
		return bean1;
	}

	@Autowired
	public void setBean1(Bean1 bean1) {
		System.out.println("注入属性Bean1");
		this.bean1 = bean1;
	}

	public com.angu.bean.Bean2 getBean2() {
		return Bean2;
	}

	public void setBean2(com.angu.bean.Bean2 bean2) {
		Bean2 = bean2;
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("setName" + name);
	}
}
