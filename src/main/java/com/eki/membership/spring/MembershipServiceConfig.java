package com.eki.membership.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.eki.membership.service" })
public class MembershipServiceConfig {

	public MembershipServiceConfig() {
		super();
	}
	// beans

}
