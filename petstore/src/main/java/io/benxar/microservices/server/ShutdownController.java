package io.benxar.microservices.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ShutdownController {

    private final TomcatShutdown tomcatShutdown;

    @Autowired
    public ShutdownController(TomcatShutdown tomcatShutdown) {
        this.tomcatShutdown = tomcatShutdown;
    }

    @RequestMapping("/stop")
    public void shutdown() throws Exception {
        tomcatShutdown.shutdown();
    }

}
