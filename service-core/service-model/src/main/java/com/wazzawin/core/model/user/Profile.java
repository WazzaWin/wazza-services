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
    @Column(name = "birth_date", columnDefinition = "DATE")
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

    public Profile() {
    }
    
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
    public class Place implements Serializable {

        private static final long serialVersionUID = 3438892635062853422L;
        //
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
        //
        @Column(name = "latitude")
        @Index(name = "PROFILE_PLACE_LATITUDE_INDEX")
        private long latitude;
        //
        @Column(name = "longitude")
        @Index(name = "PROFILE_PLACE_LONGITUDE_INDEX")
        private long longitude;

        public Place() {
        }
        
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

        public long getLatitude() {
            return latitude;
        }

        public void setLatitude(long latitude) {
            this.latitude = latitude;
        }

        public long getLongitude() {
            return longitude;
        }

        public void setLongitude(long longitude) {
            this.longitude = longitude;
        }

        @Override
        public String toString() {
            return "Place{" + "city=" + city + ", address=" + address + ", type=" + type + ", latitude=" + latitude + ", longitude=" + longitude + '}';
        }
    }
}
