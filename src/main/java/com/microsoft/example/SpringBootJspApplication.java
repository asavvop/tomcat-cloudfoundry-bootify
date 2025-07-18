package com.microsoft.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.microsoft.example")
public class SpringBootJspApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootJspApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJspApplication.class);
    }

    @Bean
    public ServletRegistrationBean<HelloServlet> myServletRegistration(HelloServlet servlet) {
    ServletRegistrationBean<HelloServlet> registration = new ServletRegistrationBean<>(servlet, "/api/helloservlet/*");
    registration.setLoadOnStartup(1);
    return registration;
}
}