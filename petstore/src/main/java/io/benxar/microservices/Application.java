package io.benxar.microservices;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

import io.benxar.microservices.server.TomcatShutdown;

/**
 * @author  benxar
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // Customize servlet container so that we could stop Tomcat when requested.

    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(TomcatShutdown tomcatShutdown) {
        return container -> {
            if (container instanceof TomcatEmbeddedServletContainerFactory) {
                ((TomcatEmbeddedServletContainerFactory) container).addContextCustomizers(tomcatShutdown::setContext);
            }
        };
    }

    @Bean
    public TomcatShutdown tomcatShutdown() {
        return new TomcatShutdown();
    }
}
