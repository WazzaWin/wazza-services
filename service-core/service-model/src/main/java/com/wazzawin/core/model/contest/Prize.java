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

import com.wazzawin.core.model.customer.Company;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "prize")
@Entity
@Table(name = "PRIZE")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "prize")
public class Prize implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "PRIZE_SEQ")
    @SequenceGenerator(name = "PRIZE_SEQ", sequenceName = "PRIZE_SEQ")
    private Long id;
    //
    @Column(name = "name", columnDefinition = "VARCHAR(254)")
    @Index(name = "PRIZE_NAME_INDEX")
    private String name;
    //
    @Column(name = "description", columnDefinition = "VARCHAR(254)")
    @Index(name = "PRIZE_DESCRIPTION_INDEX")
    private String description;
    //
    @Column(name = "note", columnDefinition = "VARCHAR(254)")
    @Index(name = "PRIZE_NOTE_INDEX")
    private String note;
    //
    @Column(name = "url_image", columnDefinition = "VARCHAR(254)")
    @Index(name = "PRIZE_URL_IMAGE_INDEX")
    private String urlImage;
    //
    @Column(name = "prize_value", columnDefinition = "INTEGER")
    @Index(name = "PRIZE_VALUE_INDEX")
    private int prizeValue;
    //
    @Column(name = "remaining_prizes", columnDefinition = "INTEGER")
    @Index(name = "PRIZE_REMAINING_PRIZES_INDEX")
    private int remainingPrizes;
    //
    @Column(name = "instant_win", columnDefinition = "BOOL DEFAULT FALSE")
    @Index(name = "PRIZE_INSTANT_WIN_INDEX")
    private boolean instantWin;
    //
    @ManyToOne(optional = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "company_id", referencedColumnName = "id",
            nullable = false)
    @Index(name = "PRIZE_COMPANY_INDEX")
    private Company company;
    //
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "PERIODICITY_PRIZE", joinColumns =
            @JoinColumn(name = "prize_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "periodicity_id", referencedColumnName = "id"))
    private List<Periodicity> periodicityList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public int getPrizeValue() {
        return prizeValue;
    }

    public void setPrizeValue(int value) {
        this.prizeValue = value;
    }

    public boolean isInstantWin() {
        return instantWin;
    }

    public void setInstantWin(boolean instantWin) {
        this.instantWin = instantWin;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Periodicity> getPeriodicityList() {
        return periodicityList;
    }

    public void setPeriodicityList(List<Periodicity> periodicityList) {
        this.periodicityList = periodicityList;
    }

    @Override
    public String toString() {
        return "Prize{" + "id=" + id + ", name=" + name + ", description=" + description + ", note=" + note + ", urlImage=" + urlImage + ", value=" + prizeValue + ", balance=" + getRemainingPrizes() + ", instantWin=" + instantWin + ", company=" + company + ", periodicityList=" + periodicityList + '}';
    }

    /**
     * @return the remainingPrizes
     */
    public int getRemainingPrizes() {
        return remainingPrizes;
    }

    /**
     * @param remainingPrizes the remainingPrizes to set
     */
    public void setRemainingPrizes(int remainingPrizes) {
        this.remainingPrizes = remainingPrizes;
    }
}
