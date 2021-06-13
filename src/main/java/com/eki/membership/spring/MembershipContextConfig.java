package com.eki.membership.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MembershipContextConfig {
	private static final Logger logger = LoggerFactory.getLogger(MembershipContextConfig.class);

	public MembershipContextConfig() {
		super();
		// TODO Auto-generated constructor stub
	}

	// beans

	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		logger.info("Init PropertySourcesPlaceholderConfigurer.............. ");

		return new PropertySourcesPlaceholderConfigurer();

	}

}
