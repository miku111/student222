package com.mvctest.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
@Configuration
public class druidConfig {
	//add dataSource
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource=new DruidDataSource();
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUsername("root");
    dataSource.setPassword("dV|pbJjdc2");
    dataSource.setUrl("jdbc:mysql://mysql.xyzsss.tk:3306/school?useSSL=true");
return  dataSource;
    }
}
