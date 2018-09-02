package com.swastik;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NewService {

	@Value("${new.message}")
	String customMessage;

	public int someMethod(int a, int b) {
		System.out.println(customMessage);
		System.out.println("Add output : " + a + b);
		return a + b;
	}

}
