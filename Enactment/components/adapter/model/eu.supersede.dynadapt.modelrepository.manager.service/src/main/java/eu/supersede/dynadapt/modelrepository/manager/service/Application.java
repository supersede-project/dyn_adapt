package eu.supersede.dynadapt.modelrepository.manager.service;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import eu.supersede.dynadapt.modelrepository.manager.Manager;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	
	final static Logger logger = Logger.getLogger(Application.class);
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		logger.debug("Initializing RESTful service");
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
