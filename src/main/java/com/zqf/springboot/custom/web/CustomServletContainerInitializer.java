//package com.zqf.springboot.custom.web;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.util.ReflectionUtils;
//import org.springframework.web.WebApplicationInitializer;
//
//import javax.servlet.ServletContainerInitializer;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.HandlesTypes;
//import java.lang.reflect.Modifier;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Set;
//@HandlesTypes(WebApplicationInitializer.class)
//public class CustomServletContainerInitializer implements ServletContainerInitializer {
//
//    @Override
//    public void onStartup(Set<Class<?>> webAppInitializerClasses, ServletContext servletContext) throws ServletException {
//        List<WebApplicationInitializer> initializers = new LinkedList<>();
//
//        if(webAppInitializerClasses != null){
//
//            for (Class<?> waiClass : webAppInitializerClasses) {
//                if (!waiClass.isInterface() && !Modifier.isAbstract(waiClass.getModifiers()) &&
//                        WebApplicationInitializer.class.isAssignableFrom(waiClass)) {
//                    try {
//                        initializers.add((WebApplicationInitializer)
//                                ReflectionUtils.accessibleConstructor(waiClass).newInstance());
//                    }
//                    catch (Throwable ex) {
//                        throw new ServletException("Failed to instantiate WebApplicationInitializer class", ex);
//                    }
//                }
//            }
//        }
//
//        for (WebApplicationInitializer initializer : initializers) {
//            initializer.onStartup(servletContext);
//        }
//    }
//}
