package com.whisky.henallux.whisky.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.DefaultMessageCodesResolver;

@Configuration
public class TranslationConfiguration {
    @Bean
    public DefaultMessageCodesResolver defaultMessageCodesResolver(){
        return new DefaultMessageCodesResolver();
    }

    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasenames("translation/general", "translation/errors");
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;
    }
}
