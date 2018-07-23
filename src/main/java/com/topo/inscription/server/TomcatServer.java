package com.topo.inscription.server;

import com.topo.inscription.controllers.DisplayAccountServlet;
import com.topo.inscription.controllers.RegistrationServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

public class TomcatServer implements AppServer {

    private Tomcat tomcat;
    int PORT = 8080;
    String webappDirLocation = "src/main/webapp/";

    @Override
    public void create() {
        tomcat = new Tomcat();
    }

    @Override
    public void configure() {
        try {
            tomcat.setPort(PORT);
            StandardContext context = (StandardContext) tomcat.addWebapp("",new File(webappDirLocation).getAbsolutePath());
            System.out.println("Configuring app with baseDir: " + new File("./" + webappDirLocation).getAbsolutePath());
            File additionWebInfClass = new File("out/production/classes");
            WebResourceRoot resourceRoot = new StandardRoot(context);
            resourceRoot.addPostResources(new DirResourceSet(resourceRoot,"/WEB-INF/classes",
                    additionWebInfClass.getAbsolutePath(),"/"));
            context.setResources(resourceRoot);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start() {
        try {
            tomcat.addServlet("", "registration", new RegistrationServlet());
            tomcat.addServlet("", "display", new DisplayAccountServlet());
            tomcat.getConnector();
            tomcat.start();
            System.out.println("server deployed " + tomcat.getServer().getStateName());
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        try {
            tomcat.stop();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
