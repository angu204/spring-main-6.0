package com.angu.bean;

import org.springframework.stereotype.Component;

@Component
public class Bean1 {
	public Bean1() {
		System.out.println("调用Bean1构造方法");
		bean1Name ="bean1Name";
		bean1Id = "bean1Id";
	}

	private String bean1Name;
	private String bean1Id;

	public String getBean1Name() {
		return bean1Name;
	}

	public void setBean1Name(String bean1Name) {
		this.bean1Name = bean1Name;
	}

	public String getBean1Id() {
		return bean1Id;
	}

	public void setBean1Id(String bean1Id) {
		this.bean1Id = bean1Id;
	}

	@Override
	public String toString() {
		return "Bean1{" +
				"bean1Name='" + bean1Name + '\'' +
				", bean1Id='" + bean1Id + '\'' +
				'}';
	}
}
