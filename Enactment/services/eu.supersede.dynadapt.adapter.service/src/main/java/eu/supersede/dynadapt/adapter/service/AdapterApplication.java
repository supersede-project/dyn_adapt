package eu.supersede.dynadapt.adapter.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//NOTE: SpringBootServletInitializer required for Web initialization (within a J2EE Container)
@SpringBootApplication
public class AdapterApplication extends SpringBootServletInitializer{
	public static void main(String[] args) {
        SpringApplication.run(AdapterApplication.class, args);
    }
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AdapterApplication.class);
    }
}
