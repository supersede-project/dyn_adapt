package eu.supersede.dynadapt.dm.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import eu.supersede.dynadapt.dm.integration.ModuleLoader;


@SpringBootApplication
public class OptimizerApp {

    public static void main(String[] args) {
        SpringApplication.run(OptimizerApp.class, args);
        
        //Listening sent Adaptation Alerts
        ModuleLoader m = new ModuleLoader();
		m.init();
    }
}
