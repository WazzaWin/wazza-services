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
package com.wazzawin.core.model.contest;

import com.wazzawin.shared.contest.Frequency;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "periodicity")
@Entity
@Table(name = "PERIODICITY")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "periodicity")
public class Periodicity implements Serializable {

    private static final long serialVersionUID = -6933097719014182688L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "PERIODICITY_SEQ")
    @SequenceGenerator(name = "PERIODICITY_SEQ", sequenceName = "PERIODICITY_SEQ")
    private Long id;
    //
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "period_id", referencedColumnName = "id",
            nullable = false)
    @Index(name = "PERIODICITY_PERIOD_INDEX")
    private Period period;
    //
    @Column(name = "max_play_number", columnDefinition = "INTEGER")
    @Index(name = "PERIODICITY_MAX_PLAY_NUMBER_INDEX")
    private int maxPlayNumber;
    //
    @OneToMany(mappedBy = "periodicity", fetch = FetchType.LAZY, orphanRemoval = true)
    @Cascade(CascadeType.DELETE)
    private List<PrizePeriodicity> prizePeriodicityList;
    //
    @Enumerated(EnumType.STRING)
    private Frequency frequency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMaxPlayNumber() {
        return maxPlayNumber;
    }

    public void setMaxPlayNumber(int maxPlayNumber) {
        this.maxPlayNumber = maxPlayNumber;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public List<PrizePeriodicity> getPrizePeriodicityList() {
        return prizePeriodicityList;
    }

    public void setPrizePeriodicityList(List<PrizePeriodicity> prizePeriodicityList) {
        this.prizePeriodicityList = prizePeriodicityList;
    }

    @Override
    public String toString() {
        return "Periodicity{" + "id=" + id + ", period=" + period + ", maxPlayNumber=" + maxPlayNumber + ", prizePeriodicityList=" + prizePeriodicityList + '}';
    }

    /**
     * @return the frequency
     */
    public Frequency getFrequency() {
        return frequency;
    }

    /**
     * @param frequency the frequency to set
     */
    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }
}
