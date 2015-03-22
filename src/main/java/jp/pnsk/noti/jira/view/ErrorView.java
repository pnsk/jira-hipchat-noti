package jp.pnsk.noti.jira.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

/**
 * Created by okuda_junko on 14/06/30.
 */
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorView {

    private String status;

    private String massage;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }
}
