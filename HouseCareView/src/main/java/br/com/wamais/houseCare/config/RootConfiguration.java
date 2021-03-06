package br.com.wamais.houseCare.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ComponentScan(value = "br.com.wamais.houseCare", excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = RootConfiguration.class))
public class RootConfiguration {

	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean() {

		return new LocalValidatorFactoryBean();
	}

	@Bean
	public CommonAnnotationBeanPostProcessor commonAnnotationBeanPostProcessor() {

		return new CommonAnnotationBeanPostProcessor();
	}

}
