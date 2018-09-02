package com.swastik;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application.yml")
@ContextConfiguration(classes = { ComponentService.class, NewService.class })
public class SpringTestClass {

	@Autowired
	ComponentService service;

	@SpyBean
	NewService ns;

	@Test
	public void test() {
		Mockito.doReturn(17).when(ns).someMethod(8, 9);
		int a = service.invokeCustomMessage(8, 9);
		Assert.assertEquals(8 + 9, a);
	}
}
