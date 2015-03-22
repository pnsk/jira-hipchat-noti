package jp.pnsk.pj;

import java.util.Date;

/**
* Project information.
* Created by okuda_junko on 14/06/25.
*/
public class Project {

    private String name;
    private short status; //active, close, before release
    private String developmentCode; //development code
    private Date createDate;
    private Date updateDate;
    private String mail; //TODO カラム追加忘れた。notiには不要だからあとでやる

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public short getStatus() {
        return status;
    }

    public void setDevelopmentCode(String developmentCode) {
        this.developmentCode = developmentCode;
    }

    public String getDevelopmentCode() {
        return developmentCode;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }
}
