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
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.NaturalId;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "contest_type")
@Entity
@Table(name = "CONTEST_TYPE")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "contest_type")
public class ContestType implements Serializable {

    private static final long serialVersionUID = -3299013060659935521L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "CONTEST_TYPE_SEQ")
    @SequenceGenerator(name = "CONTEST_TYPE_SEQ", sequenceName = "CONTEST_TYPE_SEQ")
    private Long id;
    //
    @NaturalId
    @Column(name = "title", columnDefinition = "VARCHAR(254)")
    @Index(name = "CONTEST_TYPE_TITLE_INDEX")
    private String title;
    //
    @Column(name = "color", columnDefinition = "VARCHAR(6)")
    @Index(name = "CONTEST_TYPE_COLOR_INDEX")
    private String color;
    //
    @Column(name = "url_image", columnDefinition = "VARCHAR(254)")
    @Index(name = "CONTEST_TYPE_URL_IMAGE_INDEX")
    private String urlImage;
    @Column(name = "url_agreement", columnDefinition = "VARCHAR(254)")
    @Index(name = "CONTEST_TYPE_URL_AGREEMENT_INDEX")
    private String urlAgreement;
    //
    @OneToMany(mappedBy = "contestType", fetch = FetchType.LAZY, orphanRemoval = true)
    @Cascade(CascadeType.DELETE)
    private List<Contest> contestList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    /**
     * @return the urlAgreement
     */
    public String getUrlAgreement() {
        return urlAgreement;
    }

    /**
     * @param urlAgreement the urlAgreement to set
     */
    public void setUrlAgreement(String urlAgreement) {
        this.urlAgreement = urlAgreement;
    }

    public List<Contest> getContestList() {
        return contestList;
    }

    public void setContestList(List<Contest> contestList) {
        this.contestList = contestList;
    }

    @Override
    public String toString() {
        return "ContestType{" + "id=" + id + ", title=" + title + ", color=" + color + ", urlImage=" + urlImage + ", urlAgreement=" + urlAgreement + ", contestList=" + contestList + '}';
    }
}
