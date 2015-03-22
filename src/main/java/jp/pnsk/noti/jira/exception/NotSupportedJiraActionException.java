package jp.pnsk.noti.jira.exception;


/**
 * Created by okuda_junko on 14/06/30.
 */
public class NotSupportedJiraActionException extends RuntimeException{

    public NotSupportedJiraActionException(String action) {
        super(action);
    }
}
