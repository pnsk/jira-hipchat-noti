package jp.pnsk.noti.jira.data.dao;

import jp.pnsk.config.NotiDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by okuda_junko on 14/06/27.
 */
@Service
public class JiraHipchatroomRelDao {

    @Autowired
    private NotiDatabase notiDatabase;
    private JdbcTemplate jdbcTemplate;


    public List<Integer> getRoomId(String jira_issue_key) {

        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(notiDatabase.getNotiDataSource());
        List<Integer> roomId = this.jdbcTemplate.queryForList("select room_id from jira_hipchatroom_rel where jira_issue_key = ?", Integer.class, jira_issue_key);
        return roomId;
    }
}
