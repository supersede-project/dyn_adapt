package eu.supersede.dynadapt.adapter.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = { "eu.supersede.dynadapt.dm.dashboard", "eu.supersede.fe" })
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@EnableRedisHttpSession
public class AdaptationDashboardApplication extends SpringBootServletInitializer{

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(AdaptationDashboardApplication.class);
    }

    public static void main(String[] args)
    {
        SpringApplication.run(AdaptationDashboardApplication.class, args);
    }
}
