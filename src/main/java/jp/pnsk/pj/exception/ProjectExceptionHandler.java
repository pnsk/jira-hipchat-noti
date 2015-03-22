package jp.pnsk.pj.exception;

import jp.pnsk.noti.jira.view.ErrorView;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by okuda_junko on 14/06/30.
 */
@ControllerAdvice
public class ProjectExceptionHandler {

    @ExceptionHandler({ProjectNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorView handleException(Exception ex) {
        ErrorView errorView = new ErrorView();
        errorView.setStatus(HttpStatus.BAD_REQUEST.toString());
        errorView.setMassage(ex.getMessage());
        return errorView;
    }
}
