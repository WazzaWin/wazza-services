/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
    @Column(name = "value", columnDefinition = "INTEGER")
    @Index(name = "PRIZE_VALUE_INDEX")
    private int value;
    //
    @Column(name = "balance", columnDefinition = "INTEGER")
    @Index(name = "PRIZE_BALANCE_INDEX")
    private int balance;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
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
        return "Prize{" + "id=" + id + ", name=" + name + ", description=" + description + ", note=" + note + ", urlImage=" + urlImage + ", value=" + value + ", balance=" + balance + ", instantWin=" + instantWin + ", company=" + company + ", periodicityList=" + periodicityList + '}';
    }
}
