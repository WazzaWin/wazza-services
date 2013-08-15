/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
