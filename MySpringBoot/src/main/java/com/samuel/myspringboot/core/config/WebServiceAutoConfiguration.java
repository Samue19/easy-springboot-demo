package com.samuel.myspringboot.core.config;

import com.samuel.myspringboot.core.AutoConfiguration;
import com.samuel.myspringboot.core.condition.MyConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceAutoConfiguration implements AutoConfiguration {

    @Bean
    @MyConditionalOnClass("org.apache.catalina.startup.Tomcat")
    public TomcatWebServer tomcatWebServer() {
        return new TomcatWebServer();
    }

    @Bean
    @MyConditionalOnClass("org.eclipse.jetty.server.Server")
    public JettyWebServer jettyWebServer() {
        return new JettyWebServer();
    }
}
