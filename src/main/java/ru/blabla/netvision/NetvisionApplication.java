package ru.blabla.netvision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class NetvisionApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetvisionApplication.class, args);
    }

}
