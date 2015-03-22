package jp.pnsk.noti.jira.constants;

/**
 * Created by okuda_junko on 14/06/30.
 */

/**
 * JIRAのチケットアクション
 */
public enum Action {

    CREATED,
    UPDATED,
    DELETED;

    public static String getAction(String action) {
        for (Action a : Action.values()) {
            if (a.name().equals(action.toUpperCase())) return a.name();
        }
        return null;
    }
}
