package com.ch01.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.ch01.model.animal.Cat;
import com.ch01.model.animal.Pet;

@Configuration
public class BeanConfiguration {

	@Value("Catie")
	String name;
	
	@Bean
	@Scope(scopeName = "prototype")
	public Pet catie() {
		Cat c = new Cat(name);
		return c;
	}
}
