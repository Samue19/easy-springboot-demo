package com.samuel.myspringboot.core.config;

import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.springframework.context.ApplicationContext;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class TomcatWebServer implements WebServer {
    @Override
    public void start(ApplicationContext applicationContext) {
        System.out.println("启动 Tomcat ");

        Tomcat tomcat = new Tomcat();
        Server server = tomcat.getServer();
        Service service = server.findService("Tomcat");
        Connector connector = new Connector();
        connector.setPort(8081);
        Engine engine = new StandardEngine();
        engine.setDefaultHost("localhost");
        Host host = new StandardHost();
        host.setName("localhost");
        String contextPath = "";
        Context context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());
        host.addChild(context);
        engine.addChild(host);
        service.setContainer(engine);
        service.addConnector(connector);
        tomcat.addServlet(contextPath, "dispatcher", new
                DispatcherServlet((WebApplicationContext) applicationContext));
        context.addServletMappingDecoded("/*", "dispatcher");
        try {
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }

}
