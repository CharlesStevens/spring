package com.swastik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ComponentService {

	@Value("${custom.message}")
	String customMessage;

	@Autowired
	NewService cnt;

	public int invokeCustomMessage(int i, int x) {
		System.out.println(customMessage);
		return cnt.someMethod(i, x);
	}
}
