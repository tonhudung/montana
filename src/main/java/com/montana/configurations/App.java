package com.montana.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by alexto on 10/10/15.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.montana")
@Import({Security.class, Mvc.class, Thymeleaf.class, Neo4j.class})
public class App {
}
