/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wazzawin.core.model.contest;

import com.wazzawin.shared.contest.Frequency;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Type;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "period")
@Entity
@Table(name = "PERIOD")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "period")
public class Period implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "PERIOD_SEQ")
    @SequenceGenerator(name = "PERIOD_SEQ", sequenceName = "PERIOD_SEQ")
    private Long id;
    //
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "timestamp")
    @Column(name = "start_date", columnDefinition = "DATETIME")
    @Index(name = "CONTEST_START_DATE_INDEX")
    private Date startDate;
    //
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "timestamp")
    @Column(name = "end_date", columnDefinition = "DATETIME")
    @Index(name = "CONTEST_END_DATE_INDEX")
    private Date endDate;
    //
    @Enumerated(EnumType.STRING)
    private Frequency frequency;
    //
    @OneToMany(mappedBy = "period", fetch = FetchType.LAZY, orphanRemoval = true)
    @Cascade(CascadeType.DELETE)
    private List<Periodicity> periodicityList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public List<Periodicity> getPeriodicityList() {
        return periodicityList;
    }

    public void setPeriodicityList(List<Periodicity> periodicityList) {
        this.periodicityList = periodicityList;
    }

    @Override
    public String toString() {
        return "Period{" + "id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", frequency=" + frequency + ", periodicityList=" + periodicityList + '}';
    }
}
