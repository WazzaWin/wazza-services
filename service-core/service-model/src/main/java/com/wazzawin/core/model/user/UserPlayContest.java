/*
 *  wazza-services
 *  WazzaWins Services
 *  https://github.com/WazzaWin/wazza-services
 * ====================================================================
 *
 * Copyright (C) 2012-2013 WazzaWin Developer Group (WazzaWin Team - Potenza - ITALY).
 *
 * This program is free software: you can redistribute it and/or modify it 
 * under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version. This program is distributed in the 
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without 
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR 
 * A PARTICULAR PURPOSE. See the GNU General Public License 
 * for more details. You should have received a copy of the GNU General 
 * Public License along with this program. If not, see http://www.gnu.org/licenses/ 
 *
 * ====================================================================
 *
 * Linking this library statically or dynamically with other modules is 
 * making a combined work based on this library. Thus, the terms and 
 * conditions of the GNU General Public License cover the whole combination. 
 * 
 * As a special exception, the copyright holders of this library give you permission 
 * to link this library with independent modules to produce an executable, regardless 
 * of the license terms of these independent modules, and to copy and distribute 
 * the resulting executable under terms of your choice, provided that you also meet, 
 * for each linked independent module, the terms and conditions of the license of 
 * that module. An independent module is a module which is not derived from or 
 * based on this library. If you modify this library, you may extend this exception 
 * to your version of the library, but you are not obligated to do so. If you do not 
 * wish to do so, delete this exception statement from your version. 
 *
 */
package com.wazzawin.core.model.user;

import com.wazzawin.core.model.contest.Contest;
import com.wazzawin.core.model.contest.Prize;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
    //
    @OneToOne(optional = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "prize_id", referencedColumnName = "id", nullable = true)
    private Prize prize;
    //
    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ticket_it", referencedColumnName = "id", nullable = true)
    private Ticket ticket;

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

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    /**
     * @return the prize
     */
    public Prize getPrize() {
        return prize;
    }

    /**
     * @param prize the prize to set
     */
    public void setPrize(Prize prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        return "UserPlayContest{" + "id=" + id + ", wazzaUser=" + wazzaUser + ", contest=" + contest + ", playDate=" + playDate + ", playCode=" + playCode + ", controlCode=" + controlCode + ", winning=" + winning + ", prize=" + prize + ", ticket=" + ticket + '}';
    }
}
