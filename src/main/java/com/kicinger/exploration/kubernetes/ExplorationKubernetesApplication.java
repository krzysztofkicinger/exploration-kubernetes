package com.kicinger.exploration.kubernetes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class IndexController {

    @GetMapping("/")
    public String get() {
        return "Hello from K8s!";
    }

}

@SpringBootApplication
public class ExplorationKubernetesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExplorationKubernetesApplication.class, args);
    }

}
