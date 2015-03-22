package jp.pnsk.noti.jira.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by okuda_junko on 14/06/26.
 */
@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="hipcaht error")
public class HipChatException extends RuntimeException{

    public HipChatException(String message) {
        super(message);
    }

}
