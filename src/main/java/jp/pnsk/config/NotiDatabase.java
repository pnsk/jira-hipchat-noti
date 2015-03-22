package jp.pnsk.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by okuda_junko on 14/06/26.
 */
@Configuration
@Import(Application.class)
public class NotiDatabase {

    @Bean
    public DriverManagerDataSource getNotiDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/noti?useUnicode=true&characterEncoding=UTF-8&socketTimeout=60000&connectTimeout=3000");
        dataSource.setUsername("root");
        return dataSource;
    }
}
