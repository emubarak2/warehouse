//package com.progressoft.warehouse.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Description;
//import org.springframework.context.support.ResourceBundleMessageSource;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.spring4.SpringTemplateEngine;
//import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
//
//@Configuration
//public class TemplateResolver {
//
//    @Bean
//    public CommonsMultipartResolver multipartResolver () {
//        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
//        commonsMultipartResolver.setDefaultEncoding("utf-8");
//        commonsMultipartResolver.setMaxUploadSizePerFile(400000002);
//        return commonsMultipartResolver;
//    }
//
//
//    @Bean
//    public ResourceBundleMessageSource emailMessageSource() {
//        final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setBasename("mail/MailMessages");
//        return messageSource;
//    }
//
//
//    @Bean
//    public TemplateEngine uploadTemplateEngine() {
//        final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        // Resolver for HTML editable emails (which will be treated as a String)
//        templateEngine.addTemplateResolver(htmlTemplateResolver());
//        // Message source, internationalization specific to emails
//        templateEngine.setTemplateEngineMessageSource(emailMessageSource());
//        return templateEngine;
//    }
//
//
//
//    @Bean
//    @Description("Thymeleaf template resolver for HTML form ")
//    public SpringResourceTemplateResolver htmlTemplateResolver() {
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        templateResolver.setPrefix("classpath:/templates");
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode("DEFAULT_TEMPLATE_MODE");
//        templateResolver.setCacheable(false);
//        templateResolver.setCharacterEncoding("UTF-8");
//        return templateResolver;
//    }
//
//
//}
