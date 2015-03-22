package jp.pnsk.noti.jira.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

/**
* Created by okuda_junko on 14/06/24.
*/
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class HipChatView {

    private String status;

    private String name;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}