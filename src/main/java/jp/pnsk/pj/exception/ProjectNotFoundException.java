package jp.pnsk.pj.exception;

/**
 * Created by okuda_junko on 14/06/30.
 */
public class ProjectNotFoundException extends RuntimeException{

    public ProjectNotFoundException(String message) {
        super(message);
    }
}
