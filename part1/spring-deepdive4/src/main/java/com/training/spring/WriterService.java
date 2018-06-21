package com.training.spring;

import org.springframework.stereotype.Component;

@Component("plain")
public class WriterService implements Writer {

	@Override
	public String write(String str) {
		System.out.println(str);
		return null;
	}

}
