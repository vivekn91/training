package com.training.spring;

import org.springframework.stereotype.Component;

@Component("deco")
public class WriterDecoService implements Writer {

	@Override
	public String write(String str) {
		System.out.println("Deco :: "+str);
		return null;
	}

}
