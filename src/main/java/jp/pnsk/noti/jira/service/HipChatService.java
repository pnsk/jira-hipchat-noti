package jp.pnsk.noti.jira.service;

import jp.pnsk.noti.jira.data.dao.JiraDao;
import jp.pnsk.noti.jira.data.dao.JiraHipchatroomRelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by okuda_junko on 14/06/26.
 */
@Service
public class HipChatService {

    @Autowired
    private JiraHipchatroomRelDao jiraHipchatroomRelDao;

    @Autowired
    private JiraDao jiraDao;

    public List<Integer> getRoomId(String code) {
        List<Integer> list = jiraHipchatroomRelDao.getRoomId(code);
        return list;
    }

    public String getAuthToken(String developmentCode) {
        return jiraDao.getAuthToken(developmentCode);
    }

}
