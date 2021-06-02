package com.eki.membership.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import({ // @formatter:off
    MembershipContextConfig.class,
    MembershipPersistenceJpaConfig.class,
    MembershipWebConfig.class,
    MembershipServiceConfig.class
 
}) // @formatter:on
public class MembershipApp {
	   public static void main(final String... args) {
	        new SpringApplicationBuilder(MembershipApp.class).listeners()
	            .run(args);
	    }

}
