package com.mvctest.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@Import({druidConfig.class,mybatisConfig.class})
@ComponentScan(value = "com.mvctest.service")
public class springConfig {
}
