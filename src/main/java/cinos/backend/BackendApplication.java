package cinos.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class BackendApplication {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @RequestMapping("/")
    String index() {
        return "index";
    }


}
