//package com.progressoft.warehouse.config.templateresolver;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Description;
//import org.springframework.http.client.SimpleClientHttpRequestFactory;
//import org.springframework.web.client.RestTemplate;
//
///**
// * Created by ebader on 6/27/18.
// */
//@Configuration
//public class RestTemplateConfig {
//
//	/**
//	 * build a template engine based on a specific template resolver
//	 *
//	 * @return template engine
//	 */
//	@Bean
//	public TemplateEngine emailTemplateEngine() {
//		final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//		// Resolver for HTML editable emails (which will be treated as a String)
//		templateEngine.addTemplateResolver(htmlTemplateResolver());
//		// Message source, internationalization specific to emails
//		templateEngine.setTemplateEngineMessageSource(emailMessageSource());
//		return templateEngine;
//	}
//
//	/**
//	 * this method build the spring resource template resolver
//	 *
//	 * @return Spring Resource Template Resolver
//	 */
//	@Bean
//	@Description("Thymeleaf template resolver for email ")
//	public SpringResourceTemplateResolver htmlTemplateResolver() {
//		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//		templateResolver.setPrefix("classpath:/templates/");
//		templateResolver.setSuffix(".html");
//		templateResolver.setTemplateMode(TemplateResolver.DEFAULT_TEMPLATE_MODE);
//		templateResolver.setCacheable(false);
//		templateResolver.setCharacterEncoding("UTF-8");
//		return templateResolver;
//	}
//
//}
