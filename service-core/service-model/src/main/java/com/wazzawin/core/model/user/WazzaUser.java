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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "wazza_user")
@Entity
@Table(name = "WAZZA_USER")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "wazza_user")
public class WazzaUser implements Serializable {

    private static final long serialVersionUID = -2206994069412185311L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "WAZZA_USER_SEQ")
    @SequenceGenerator(name = "WAZZA_USER_SEQ", sequenceName = "WAZZA_USER_SEQ")
    private Long id;
    //
    @NaturalId
    @Column(name = "user_name", columnDefinition = "VARCHAR(128)", nullable = false)
    @Index(name = "WAZZA_USER_NAME_INDEX")
    private String userName;
    //
    @Column(name = "email", columnDefinition = "VARCHAR(128)", nullable = false)
    @Index(name = "WAZZA_USER_EMAIL_INDEX")
    private String email;
    //
    @Column(name = "password", columnDefinition = "VARCHAR(254)", nullable = false)
    @Index(name = "WAZZA_USER_PASSWORD_INDEX")
    private String password;
    //
    @Column(name = "phone_number", columnDefinition = "VARCHAR(10)")
    @Index(name = "WAZZA_USER_PHONE_NUMBER_INDEX")
    private String phoneNumber;
    //
    @Column(name = "enabled", columnDefinition = "BOOL DEFAULT FALSE")
    @Index(name = "WAZZA_USER_ENABLED_INDEX")
    private boolean enabled;
    //
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "timestamp")
    @Column(name = "last_login", columnDefinition = "DATE")
    @Index(name = "WAZZA_USER_LAST_LOGIN_INDEX")
    private Date lastLogin;
    //
    @OneToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "profile", referencedColumnName = "id", nullable = false)
    @Index(name = "WAZZA_USER_PROFILE_INDEX")
    private Profile profile;
    //
    @OneToMany(mappedBy = "wazzaUser", fetch = FetchType.LAZY, orphanRemoval = true)
    @Cascade(CascadeType.DELETE)
    private List<UserPlayContest> userPlayContestList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<UserPlayContest> getUserPlayContestList() {
        return userPlayContestList;
    }

    public void setUserPlayContestList(List<UserPlayContest> userPlayContestList) {
        this.userPlayContestList = userPlayContestList;
    }

    @Override
    public String toString() {
        return "WazzaUser{" + "id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password + ", phoneNumber=" + phoneNumber + ", enabled=" + enabled + ", lastLogin=" + lastLogin + ", profile=" + profile + ", userPlayContestList=" + userPlayContestList + '}';
    }
}
