package jp.pnsk.noti.jira.exception;

import jp.pnsk.noti.jira.exception.NotSupportedJiraActionException;
import jp.pnsk.noti.jira.view.ErrorView;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by okuda_junko on 14/06/28.
 */
@ControllerAdvice
public class NotiJiraExceptionHandler {

    @ExceptionHandler({NotSupportedJiraActionException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorView handleException(Exception ex) {
        ErrorView errorView = new ErrorView();
        errorView.setStatus(HttpStatus.BAD_REQUEST.toString());
        errorView.setMassage(ex.getMessage());
        return errorView;
    }

    @ExceptionHandler({HipChatException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorView handleHipChatException(Exception ex) {
        ErrorView errorView = new ErrorView();
        errorView.setStatus(HttpStatus.BAD_REQUEST.toString());
        errorView.setMassage("HipChatError: " + ex.getMessage());
        return errorView;
    }
}
