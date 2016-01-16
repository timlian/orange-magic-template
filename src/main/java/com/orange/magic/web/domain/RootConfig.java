package com.orange.magic.web.domain;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class RootConfig {
	
	public RootConfig() {
		System.out.println("root config constructing....");
	}

}

