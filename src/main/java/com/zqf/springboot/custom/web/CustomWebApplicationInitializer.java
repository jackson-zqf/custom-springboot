package com.zqf.springboot.custom.web;

import com.zqf.springboot.custom.config.CustomAppConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Configuration
public class CustomWebApplicationInitializer implements WebApplicationInitializer {


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        /**
         * 初始化上下文对象，并注册配置类，刷新上下文，即启动IOC容器
         */
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        servletContext.addListener(new ContextLoaderListener(ac));
        ac.register(CustomAppConfig.class);
        ac.refresh();

        //基于java代码方式初始化 DispatcherServlet,  将servlet添加到web容器中
        DispatcherServlet dispatcherServlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
