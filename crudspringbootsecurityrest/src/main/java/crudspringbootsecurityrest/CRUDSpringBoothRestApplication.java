package crudspringbootsecurityrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@EnableAutoConfiguration
@PropertySources({		
	@PropertySource("classpath:application_db.properties"),
	@PropertySource("classpath:application_url.properties")		
})
public class CRUDSpringBoothRestApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(CRUDSpringBoothRestApplication.class);
	
	public static final void main(final String args[]) {
		LOGGER.info("#######################################################");
		LOGGER.info("");
		LOGGER.info("Starting application.....");
		LOGGER.info("");
		LOGGER.info("#######################################################");
		
		/*
		new SpringApplicationBuilder(CRUDSpringBoothRestApplication.class)
		.properties("spring.config.name:application,conf", "spring.config.location:classpath:/resources")
		.build()
		.run(args);
		*/
		
		SpringApplication.run(CRUDSpringBoothRestApplication.class, args);		
		
		LOGGER.info("#######################################################");
		LOGGER.info("");
		LOGGER.info("Application up & running");
		LOGGER.info("");
		LOGGER.info("#######################################################");
	}
}