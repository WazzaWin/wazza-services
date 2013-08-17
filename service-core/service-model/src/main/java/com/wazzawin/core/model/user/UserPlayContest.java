/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wazzawin.core.model.user;

import com.wazzawin.core.model.contest.Contest;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "user_play_contest")
@Entity
@Table(name = "USER_PLAY_CONTEST")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "user_play_contest")
public class UserPlayContest implements Serializable {

    private static final long serialVersionUID = 9069186651775466613L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "USER_PLAY_CONTEST_SEQ")
    @SequenceGenerator(name = "USER_PLAY_CONTEST_SEQ", sequenceName = "USER_PLAY_CONTEST_SEQ")
    private Long id;
    //
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "wazza_user_id", referencedColumnName = "id",
            nullable = false)
    @Index(name = "USER_PLAY_CONTEST_USER_INDEX")
    private WazzaUser wazzaUser;
    //
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "contest_id", referencedColumnName = "id",
            nullable = false)
    @Index(name = "USER_PLAY_CONTEST_CONTEST_INDEX")
    private Contest contest;
    //
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "timestamp")
    @Column(name = "play_date", columnDefinition = "DATE")
    @Index(name = "USER_PLAY_CONTEST_PLAY_DATE_INDEX")
    private Date playDate;
    //
    @Column(name = "play_code", columnDefinition = "VARCHAR(254)")
    @Index(name = "USER_PLAY_CONTEST_PLAY_CODE_INDEX")
    private String playCode;
    //
    @Column(name = "control_code", columnDefinition = "VARCHAR(254)")
    @Index(name = "USER_PLAY_CONTEST_CONTROL_CODE_INDEX")
    private String controlCode;
    //
    @Column(name = "winning", columnDefinition = "BOOL DEFAULT FALSE")
    @Index(name = "USER_PLAY_CONTEST_WINNING_INDEX")
    private boolean winning;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WazzaUser getWazzaUser() {
        return wazzaUser;
    }

    public void setWazzaUser(WazzaUser wazzaUser) {
        this.wazzaUser = wazzaUser;
    }

    public Contest getContest() {
        return contest;
    }

    public void setContest(Contest contest) {
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
        return "UserPlayContest{" + "id=" + id + ", user=" + wazzaUser + ", contest=" + contest + ", playDate=" + playDate + ", playCode=" + playCode + ", controlCode=" + controlCode + ", winning=" + winning + '}';
    }
}
