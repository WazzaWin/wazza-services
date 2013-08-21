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

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "prize_periodicity")
@Entity
@Table(name = "PRIZE_PERIODICITY")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "prize_periodicity")
public class PrizePeriodicity implements Serializable {

    private static final long serialVersionUID = 8109760184180383771L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "PRIZE_PERIODICITY_SEQ")
    @SequenceGenerator(name = "PRIZE_PERIODICITY_SEQ", sequenceName = "PRIZE_PERIODICITY_SEQ")
    private Long id;
    //
    @Column(name = "number_of_prizes", columnDefinition = "INTEGER")
    @Index(name = "PRIZE_PERIODICITY_NUMBER_OF_PRIZES_INDEX")
    private int numberOfPrizes;
    //
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "prize_id", referencedColumnName = "id",
            nullable = false)
    @Index(name = "PRIZE_PERIODICITY_PRIZE_INDEX")
    private Prize prize;
    //
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "periodicity_id", referencedColumnName = "id",
            nullable = false)
    @Index(name = "PRIZE_PERIODICITY_CONTEST_INDEX")
    private Periodicity periodicity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberOfPrizes() {
        return numberOfPrizes;
    }

    public void setNumberOfPrizes(int numberOfPrizes) {
        this.numberOfPrizes = numberOfPrizes;
    }

    public Prize getPrize() {
        return prize;
    }

    public void setPrize(Prize prize) {
        this.prize = prize;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "PrizePeriodicity{" + "id=" + id + ", numberOfPrizes=" + numberOfPrizes + ", prize=" + prize + ", periodicity=" + periodicity + '}';
    }
}
