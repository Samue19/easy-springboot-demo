package com.samuel.myspringboot.core.config;

import org.springframework.context.ApplicationContext;

public class JettyWebServer implements WebServer {
    @Override
    public void start(ApplicationContext applicationContext) {
        System.out.println("启动 Jetty ");
    }
}
