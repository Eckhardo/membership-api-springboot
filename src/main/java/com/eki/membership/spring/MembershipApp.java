package com.eki.membership.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eki.membership.setup.MembershipAppContextInitializer;

@SpringBootApplication
public class MembershipApp {

	@SuppressWarnings("rawtypes")

	private final static Class[] CONFIGS = { // @formatter:off
			MembershipContextConfig.class, 
			MembershipPersistenceJpaConfig.class, 
			MembershipServiceConfig.class,
			MembershipApp.class

	}; // @formatter:on

	public static void main(final String... args) {
		final SpringApplication springApplication = new SpringApplication(CONFIGS);
		springApplication.addInitializers(new MembershipAppContextInitializer());
		springApplication.run(args);
	}


}
