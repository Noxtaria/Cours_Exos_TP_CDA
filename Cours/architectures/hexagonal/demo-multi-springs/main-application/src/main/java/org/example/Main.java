package org.example;

import com.example.firstspring.FirstSpringApplication;
import com.example.secondspring.SecondSpringApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {


        SpringApplication second = new SpringApplication(SecondConfig.class);
        second.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
        ConfigurableApplicationContext secondContext = second.run();


        SpringApplication first = new SpringApplication(FirstConfig.class);
        first.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
        first.addInitializers(new FirstAppInitializer());
        ConfigurableApplicationContext firstContext = first.run();

    }
}


@SpringBootApplication(scanBasePackages = "com.example.firstspring")
class FirstConfig {

}

@SpringBootApplication(scanBasePackages = "com.example.secondspring")
class SecondConfig {

}