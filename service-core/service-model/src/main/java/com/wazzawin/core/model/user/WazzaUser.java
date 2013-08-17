/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wazzawin.core.model.user;

import com.wazzawin.core.model.contest.Contest;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
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
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "USER_CONTEST", joinColumns =
            @JoinColumn(name = "wazza_user_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "contest_id", referencedColumnName = "id"))
    private List<Contest> contestList;

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

    public List<Contest> getContestList() {
        return contestList;
    }

    public void setContestList(List<Contest> contestList) {
        this.contestList = contestList;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userName=" + userName + ", email="
                + email + ", password=" + password + ", phoneNumber="
                + phoneNumber + ", enabled=" + enabled + ", lastLogin="
                + lastLogin + ", profile=" + profile + ", contestList="
                + contestList + '}';
    }
}
