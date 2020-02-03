package com.productServices;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.ResourceHandlerRegistrationCustomizer;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;


public class ProductServiceInterceptorAppConfig extends WebMvcAutoConfigurationAdapter   {

	public ProductServiceInterceptorAppConfig(ResourceProperties resourceProperties, WebMvcProperties mvcProperties,
			ListableBeanFactory beanFactory, ObjectProvider<HttpMessageConverters> messageConvertersProvider,
			ObjectProvider<ResourceHandlerRegistrationCustomizer> resourceHandlerRegistrationCustomizerProvider) {
		super(resourceProperties, mvcProperties, beanFactory, messageConvertersProvider, null);
		// TODO Auto-generated constructor stub
	}

	@Autowired
	ProductServiceInterceptor productInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(productInterceptor);
	}

}
