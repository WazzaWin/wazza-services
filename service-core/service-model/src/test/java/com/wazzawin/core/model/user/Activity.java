/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wazzawin.core.model.user;

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
@XmlRootElement(name = "activity")
@Entity
@Table(name = "ACTIVITY")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "activity")
public class Activity implements Serializable {

    private static final long serialVersionUID = 8659021263450163484L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "ACTIVITY_SEQ")
    @SequenceGenerator(name = "ACTIVITY_SEQ", sequenceName = "ACTIVITY_SEQ")
    private Long id;
    //
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "timestamp")
    @Column(name = "event_date", columnDefinition = "DATETIME")
    @Index(name = "ACTIVITY_EVENT_DATE_INDEX")
    private Date eventDate;
    //
    @Column(name = "coin_transaction", columnDefinition = "INTEGER")
    @Index(name = "ACTIVITY_COIN_TRANSACTION_INDEX")
    private int coinTransaction;
    //
    @Column(name = "activity_type", columnDefinition = "VARCHAR(254)")
    @Index(name = "ACTIVITY_TYPE_INDEX")
    private String activityType;
    //
    @Column(name = "event_text", columnDefinition = "VARCHAR(254)")
    @Index(name = "ACTIVITY_EVENT_TEXT_INDEX")
    private String eventText;
    //
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "profile_id", referencedColumnName = "id",
            nullable = false)
    @Index(name = "ACTIVITY_PROFILE_INDEX")
    private Profile profile;

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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
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

    @Override
    public String toString() {
        return "Activity{" + "id=" + id + ", eventDate=" + eventDate + ", coinTransaction=" + coinTransaction + ", activityType=" + activityType + ", eventText=" + eventText + '}';
    }
}
