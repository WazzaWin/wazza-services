/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wazzawin.responce.user;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "activityDTO")
public class ActivityDTO implements Serializable {

    private static final long serialVersionUID = -5431460644350202900L;
    private Long id;
    //
    private Date eventDate;
    //
    private int coinTransaction;
    //
    private String activityType;
    //
    private String eventText;
    //
    private ProfileDTO profileDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public int getCoinTransaction() {
        return coinTransaction;
    }

    public void setCoinTransaction(int coinTransaction) {
        this.coinTransaction = coinTransaction;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getEventText() {
        return eventText;
    }

    public void setEventText(String eventText) {
        this.eventText = eventText;
    }

    public ProfileDTO getProfileDTO() {
        return profileDTO;
    }

    public void setProfileDTO(ProfileDTO profileDTO) {
        this.profileDTO = profileDTO;
    }

    @Override
    public String toString() {
        return "ActivityDTO{" + "id=" + id + ", eventDate=" + eventDate + ", coinTransaction=" + coinTransaction + ", activityType=" + activityType + ", eventText=" + eventText + ", profileDTO=" + profileDTO + '}';
    }
}
