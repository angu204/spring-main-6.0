package com.angu.bean;

import org.springframework.stereotype.Component;

@Component
public class Bean2 {
	private String bean2Name;

	private String Bean2Id;

	public String getBean2Name() {
		return bean2Name;
	}

	public void setBean2Name(String bean2Name) {
		this.bean2Name = bean2Name;
	}

	public String getBean2Id() {
		return Bean2Id;
	}

	public void setBean2Id(String bean2Id) {
		Bean2Id = bean2Id;
	}
}
