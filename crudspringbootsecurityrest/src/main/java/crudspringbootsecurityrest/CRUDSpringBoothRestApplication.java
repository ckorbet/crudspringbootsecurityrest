package crudspringbootsecurityrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CRUDSpringBoothRestApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(CRUDSpringBoothRestApplication.class);
	
	public static final void main(final String args[]) {
		LOGGER.info("#######################################################");
		LOGGER.info("");
		LOGGER.info("Starting application.....");
		LOGGER.info("");
		LOGGER.info("#######################################################");
		SpringApplication.run(CRUDSpringBoothRestApplication.class, args);
		LOGGER.info("#######################################################");
		LOGGER.info("");
		LOGGER.info("Application up & running");
		LOGGER.info("");
		LOGGER.info("#######################################################");
	}
}