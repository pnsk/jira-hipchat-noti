package jp.pnsk.pj.config;

import jp.pnsk.config.Application;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by okuda_junko on 14/06/27.
 */
@Configuration
@Import(Application.class)
public class ProjectsDatabase {

    public DriverManagerDataSource getProjectsDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/projects?useUnicode=true&characterEncoding=UTF-8&socketTimeout=60000&connectTimeout=3000");
        dataSource.setUsername("root");
        return dataSource;
    }
}
