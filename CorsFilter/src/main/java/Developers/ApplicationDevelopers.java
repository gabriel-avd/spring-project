package Developers;

import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

/**
 * Created by gvaldes on 25/11/2016.
 */

@SpringBootApplication
public class ApplicationDevelopers extends SpringBootServletInitializer {

    public static void main(String[] args){
        ApplicationContext ctx = SpringApplication.run(ApplicationDevelopers.class, args);

        System.out.println("APLICACION LEVANTADA!");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ApplicationDevelopers.class);
    }
}
