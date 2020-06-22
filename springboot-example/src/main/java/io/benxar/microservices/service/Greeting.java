package io.benxar.microservices.service;

/**
 * @author  benxar
 */
public class Greeting {

    private final String message;

    public Greeting() {
        this.message = null;
    }

    public Greeting(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}