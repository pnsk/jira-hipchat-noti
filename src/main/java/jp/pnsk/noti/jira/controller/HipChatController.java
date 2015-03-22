package jp.pnsk.noti.jira.controller;

import jp.pnsk.noti.jira.constants.Action;
import jp.pnsk.noti.jira.exception.HipChatException;
import jp.pnsk.noti.jira.exception.NotSupportedJiraActionException;
import jp.pnsk.noti.jira.service.HipChatService;
import jp.pnsk.noti.jira.utils.JiraUtil;
import jp.pnsk.noti.jira.view.HipChatView;
import jp.pnsk.pj.ProjectService;
import jp.pnsk.pj.exception.ProjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by okuda_junko on 14/06/28.
 */
@RestController
public class HipChatController {

    private static final String HIPCHARURL
            = "https://api.hipchat.com/v1/rooms/message?from=JIRA&color=yellow";
    private static final String JIRAURL
            = "https://jira,hogehoge";


    @Autowired
    private ProjectService projectService;

    @Autowired
    private HipChatService hipChatService;

    @Autowired
    private HipChatView hipChatView;


    @RequestMapping(value={"/hipchat","/hipchat/{action}/","/hipchat/{action}/{issueKey}"},method= {RequestMethod.GET, RequestMethod.POST})
    public HipChatView execute(@PathVariable String action, @PathVariable String issueKey)
            throws IOException, URISyntaxException {

        if (Action.getAction(action) == null) throw new NotSupportedJiraActionException("invalid action -> " + action);

        String developmentCode = JiraUtil.convertIssueToCode(issueKey);

        /**
         * TODO あとでAPIで切り分ける
         */
        if (!projectService.exists(developmentCode))throw new ProjectNotFoundException("invalid development_code -> " + developmentCode);

        List<Integer> roomIdList = hipChatService.getRoomId(developmentCode);

        for (Integer roomId : roomIdList) {

            ClientHttpRequest request
                    = getClientHttp().createRequest(new URI(HIPCHARURL + createHipchatUrl(roomId, issueKey, action, hipChatService.getAuthToken(developmentCode))), HttpMethod.GET);

            ClientHttpResponse response = request.execute();
            if (!HttpStatus.OK.equals(response.getStatusCode())) throw new HipChatException(" statusCode:" + response.getStatusCode());
        }
        hipChatView.setStatus(HttpStatus.OK.toString());
        hipChatView.setName(issueKey);

        return hipChatView;
    }

    /**
     * TODO jiraのURLはプロパティファイルにする
     */
    private String createHipchatUrl(int roomId, String issueKey, String action, String authToken) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        sb.append("&auth_token=" + authToken);
        sb.append("&room_id=" + roomId);
        sb.append("&message=" + URLEncoder.encode(action + " : " + "<a href=\""+ JIRAURL +"/browse/" + issueKey + "\">" + issueKey + "</a>", "UTF-8")); //TODO リファクタ

        return sb.toString();
    }

    private static HttpComponentsClientHttpRequestFactory getClientHttp() throws URISyntaxException, IOException {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(3000);
        factory.setReadTimeout(3000);
        return factory;
    }

}
