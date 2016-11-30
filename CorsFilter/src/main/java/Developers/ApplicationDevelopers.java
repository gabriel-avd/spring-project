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

        System.out.println("Let's inspect the beans provided by spring Boot: ");

        String[] beanNames= ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);

        for(String beanName: beanNames){
            System.out.println(beanName);
        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ApplicationDevelopers.class);
    }
}
