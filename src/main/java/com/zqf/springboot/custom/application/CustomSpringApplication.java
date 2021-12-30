package com.zqf.springboot.custom.application;

import com.zqf.springboot.custom.server.TomcatServer;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;

public class CustomSpringApplication {


    public static void run() {
        try {
            //初始化tomcat服务，并启动tomcat
            TomcatServer tomcatServer = new TomcatServer();
            tomcatServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
