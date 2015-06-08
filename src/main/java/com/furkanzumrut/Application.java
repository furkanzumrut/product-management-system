package com.furkanzumrut;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by furkanzumrut on 6/8/15.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.furkanzumrut")
public class Application extends SpringBootServletInitializer {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }



    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

}
