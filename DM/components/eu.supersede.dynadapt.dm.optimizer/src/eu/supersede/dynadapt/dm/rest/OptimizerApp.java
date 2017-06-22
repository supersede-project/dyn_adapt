package eu.supersede.dynadapt.dm.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import eu.supersede.dynadapt.dm.integration.ModuleLoader;


@SpringBootApplication
public class OptimizerApp {

    public static void main(String[] args) {
        SpringApplication.run(OptimizerApp.class, args);
        
        //Listening sent Adaptation Alerts
        ModuleLoader m;
		try {
			m = new ModuleLoader();
			m.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
