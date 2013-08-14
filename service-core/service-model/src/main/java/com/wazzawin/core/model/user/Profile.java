/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wazzawin.core.model.user;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@XmlRootElement(name = "profile")
@Entity
@Table(name = "PROFILE")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "profile")
public class Profile implements Serializable {

    private static final long serialVersionUID = -1119604996312537139L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "PROFILE_SEQ")
    @SequenceGenerator(name = "PROFILE_SEQ", sequenceName = "PROFILE_SEQ")
    private Long id;
    //
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "timestamp")
    @Column(name = "birth_date", columnDefinition = "DATETIME")
    @Index(name = "PROFILE_BIRTH_DATE_INDEX")
    private Date birthDate;
    //
    @Column(name = "city", columnDefinition = "VARCHAR(254)")
    @Index(name = "PROFILE_CITY_INDEX")
    private String city;
    //
    @Column(name = "coin_balance", columnDefinition = "INTEGER")
    @Index(name = "PROFILE_COIN_BALANCE_INDEX")
    private int coinBalance;
    //
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY, orphanRemoval = true)
    @Cascade(CascadeType.DELETE)
    private List<Activity> activityList;
    //
    @ElementCollection
    @CollectionTable(name = "Place", joinColumns =
            @JoinColumn(name = "PROFILE_ID"))
    private List<Place> placeList;
    //
    @ElementCollection
    @CollectionTable(name = "Interest", joinColumns =
            @JoinColumn(name = "PROFILE_ID"))
    private List<String> interestList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCoinBalance() {
        return coinBalance;
    }

    public void setCoinBalance(int coinBalance) {
        this.coinBalance = coinBalance;
    }

    public List<Place> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(List<Place> placeList) {
        this.placeList = placeList;
    }

    public List<String> getInterestList() {
        return interestList;
    }

    public void setInterestList(List<String> interestList) {
        this.interestList = interestList;
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }

    @Override
    public String toString() {
        return "Profile{" + "id=" + id + ", birthDate=" + birthDate + ", city=" + city + ", coinBalance=" + coinBalance + ", activityList=" + activityList + ", placeList=" + placeList + ", interestList=" + interestList + '}';
    }

    @Embeddable
    public class Place {

        @Column(name = "city", columnDefinition = "VARCHAR(254)")
        @Index(name = "PROFILE_PLACE_CITY_INDEX")
        private String city;
        //
        @Column(name = "address", columnDefinition = "VARCHAR(254)")
        @Index(name = "PROFILE_PLACE_ADDRESS_INDEX")
        private String address;
        //
        @Column(name = "type")
        @Index(name = "PROFILE_PLACE_TYPE_INDEX")
        private String type;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Place{" + "city=" + city + ", address=" + address + ", type=" + type + '}';
        }
    }
}
