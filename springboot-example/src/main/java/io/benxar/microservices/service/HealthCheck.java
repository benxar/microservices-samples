package io.benxar.microservices.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author benxar
 */
@RestController
@RequestMapping("/api")
public class HealthCheck {

    @GetMapping("/healthz")
    public ResponseEntity<String> getHealth() {
        return ResponseEntity.ok().body("ready");
    }

}
