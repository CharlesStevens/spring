package com.stevens.spring_mvc_1.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.stevens.spring_mvc_1" })
public class Configurations implements WebMvcConfigurer {

	// For normal Json and XMl for Rest Controller/ not for MVC only for Rest.
//	@Override
//	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//		configurer.favorParameter(false).favorPathExtension(false).ignoreAcceptHeader(false).useJaf(false);
//	}

	// For MVC pattern
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorParameter(true).favorPathExtension(false).ignoreAcceptHeader(true)
				.mediaType("json", MediaType.APPLICATION_JSON).mediaType("html", MediaType.TEXT_HTML)
				.defaultContentType(MediaType.TEXT_HTML);
	}

	@Bean
	public ViewResolver contentNegotiationViewResolver(ContentNegotiationManager mn) {
		List<ViewResolver> resolvers = new ArrayList<>();

		InternalResourceViewResolver intRes = new InternalResourceViewResolver();
		intRes.setViewClass(JstlView.class);
		intRes.setPrefix("/WEB-INF/pages");
		intRes.setSuffix(".jsp");

		JsonViewResolver r2 = new JsonViewResolver();

		resolvers.add(intRes);
		resolvers.add(r2);

		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setContentNegotiationManager(mn);
		resolver.setViewResolvers(resolvers);
		return resolver;

	}

}
