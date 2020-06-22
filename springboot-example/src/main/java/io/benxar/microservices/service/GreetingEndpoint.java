package io.benxar.microservices.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author  benxar
 */
@RestController
@RequestMapping("/api")
public class GreetingEndpoint {
    private static final String template = "Hello, %s!";

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam("name") String name) {
        String suffix = name != null ? name : "World";
        return new Greeting(String.format(template, suffix));
    }
}
