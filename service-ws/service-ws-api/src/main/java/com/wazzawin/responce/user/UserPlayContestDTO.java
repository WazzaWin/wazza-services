/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wazzawin.responce.user;

import com.wazzawin.responce.contest.ContestDTO;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "userPlayContestDTO")
public class UserPlayContestDTO implements Serializable {

    private static final long serialVersionUID = -8331860505456971364L;
    private Long id;
    //
    private WazzaUserDTO wazzaUser;
    //
    private ContestDTO contest;
    //
    private Date playDate;
    //
    private String playCode;
    //
    private String controlCode;
    //
    private boolean winning;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WazzaUserDTO getWazzaUser() {
        return wazzaUser;
    }

    public void setWazzaUser(WazzaUserDTO wazzaUser) {
        this.wazzaUser = wazzaUser;
    }

    public ContestDTO getContest() {
        return contest;
    }

    public void setContest(ContestDTO contest) {
        this.contest = contest;
    }

    public Date getPlayDate() {
        return playDate;
    }

    public void setPlayDate(Date playDate) {
        this.playDate = playDate;
    }

    public String getPlayCode() {
        return playCode;
    }

    public void setPlayCode(String playCode) {
        this.playCode = playCode;
    }

    public String getControlCode() {
        return controlCode;
    }

    public void setControlCode(String controlCode) {
        this.controlCode = controlCode;
    }

    public boolean isWinning() {
        return winning;
    }

    public void setWinning(boolean winning) {
        this.winning = winning;
    }

    @Override
    public String toString() {
        return "UserPlayContestDTO{" + "id=" + id + ", wazzaUser=" + wazzaUser + ", contest=" + contest + ", playDate=" + playDate + ", playCode=" + playCode + ", controlCode=" + controlCode + ", winning=" + winning + '}';
    }
}
