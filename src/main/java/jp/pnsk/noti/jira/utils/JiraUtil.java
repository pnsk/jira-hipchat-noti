package jp.pnsk.noti.jira.utils;

/**
 * Created by okuda_junko on 14/06/25.
 */
public class JiraUtil {

    private JiraUtil(){}

    /**
     * チケット番号を開発コードに変換する
     * @param issueKey
     * @return code
     */
    public static String convertIssueToCode(String issueKey){
        return issueKey.split("-")[0];
    }
}
