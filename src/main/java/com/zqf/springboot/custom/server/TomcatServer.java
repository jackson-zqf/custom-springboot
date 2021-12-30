package com.zqf.springboot.custom.server;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

public class TomcatServer {
    Tomcat tomcat;
    public void start() throws  ServletException {
        tomcat = new Tomcat();
        tomcat.setPort(9999);
        // 读取项目路径 加载静态资源
        Context context = tomcat.addWebapp("/",new File("src/main").getAbsolutePath());
        context.setPath("");
        context.addLifecycleListener(new Tomcat.FixContextListener());
        tomcat.getHost().setAutoDeploy(false);
        try {
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

        //开启tomcat非守护线程
        Thread awaitThread = new Thread("tomcat-container."){
            @Override
            public void run() {
                tomcat.getServer().await();
            }
        };
        //设置为非守护线程
        awaitThread.setDaemon(false);
        awaitThread.start();

    }
}
