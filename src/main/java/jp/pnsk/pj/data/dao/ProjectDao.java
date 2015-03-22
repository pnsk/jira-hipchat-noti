package jp.pnsk.pj.data.dao;

import jp.pnsk.pj.Project;
import jp.pnsk.pj.config.ProjectsDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by okuda_junko on 14/06/27.
 */
@Service
public class ProjectDao {

    @Autowired
    private ProjectsDatabase projectsDatabase;
    private JdbcTemplate jdbcTemplate;

    public boolean exists(String development_code) {
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(projectsDatabase.getProjectsDataSource());
        Project project = this.jdbcTemplate.queryForObject("select * from project where development_code=?",
                        new RowMapper<Project>() {
                            public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
                                Project project = new Project();
                                project.setName(rs.getString("name"));
                                return project;
                            }
                        },development_code);
        return project != null;
    }

}
