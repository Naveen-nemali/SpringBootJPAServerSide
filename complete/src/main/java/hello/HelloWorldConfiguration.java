package hello;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan("hello.entity")
public class HelloWorldConfiguration {


    @Bean
    public Filter corsFilter() {
        return new CorsFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldConfiguration.class, args);
        
        /*ApplicationContext ctx = SpringApplication.run(HelloWorldConfiguration.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }*/
    }

}
