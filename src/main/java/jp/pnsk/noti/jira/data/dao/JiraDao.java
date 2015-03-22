package jp.pnsk.noti.jira.data.dao;

import jp.pnsk.config.NotiDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by okuda_junko on 14/06/26.
 */
@Service
public class JiraDao {

    @Autowired
    private NotiDatabase notiDatabase;
    private JdbcTemplate jdbcTemplate;

    public String getAuthToken(String developerKey) {
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(notiDatabase.getNotiDataSource());
        String authToken = this.jdbcTemplate.queryForObject("select auth_token from jira where issue_key = ?", String.class, developerKey);
        return authToken;
    }

}
