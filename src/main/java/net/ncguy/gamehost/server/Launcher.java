package net.ncguy.gamehost.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Launcher {

    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Bean inspection");

            String[] names = ctx.getBeanDefinitionNames();
            Arrays.sort(names);
            for (String name : names) {
                System.out.println(name);
            }
        };
    }

}
