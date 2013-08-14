/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wazzawin.core.model.contest;

import com.wazzawin.core.model.customer.Company;
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
import javax.persistence.ManyToOne;
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
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "contest")
@Entity
@Table(name = "CONTEST")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "contest")
public class Contest implements Serializable {

    private static final long serialVersionUID = -8512452151076087531L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "CONTEST_SEQ")
    @SequenceGenerator(name = "CONTEST_SEQ", sequenceName = "CONTEST_SEQ")
    private Long id;
    //
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "timestamp")
    @Column(name = "start_date", columnDefinition = "DATETIME")
    @Index(name = "CONTEST_START_DATE_INDEX")
    private Date startDate;
    //
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "timestamp")
    @Column(name = "end_date", columnDefinition = "DATETIME")
    @Index(name = "CONTEST_END_DATE_INDEX")
    private Date endDate;
    //
    @Column(name = "min_coin", columnDefinition = "INTEGER")
    @Index(name = "CONTEST_MIN_COIN_INDEX")
    private int minCoin;
    //
    @Column(name = "url_address", columnDefinition = "VARCHAR(254)")
    @Index(name = "CONTEST_URL_ADDRESS_INDEX")
    private String urlAddress;
    //
    @Column(name = "number_of_win", columnDefinition = "INTEGER")
    @Index(name = "CONTEST_NUMBER_OF_WIN_INDEX")
    private int numberOfWin;
    //
    @Column(name = "regulation", columnDefinition = "TEXT")
    @Index(name = "CONTEST_REGULATION_INDEX")
    private String regulation;
    //
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "contest_type_id", referencedColumnName = "id",
            nullable = false)
    @Index(name = "CONTEST_CONTEST_TYPE_INDEX")
    private ContestType contestType;
    //
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "company_id", referencedColumnName = "id",
            nullable = false)
    @Index(name = "CONTEST_COMPANY_INDEX")
    private Company company;
    //
    @OneToMany(mappedBy = "contest", fetch = FetchType.LAZY, orphanRemoval = true)
    @Cascade(CascadeType.DELETE)
    private List<ContestInfo> contestInfoList;
    //
    @OneToMany(mappedBy = "contest", fetch = FetchType.LAZY, orphanRemoval = true)
    @Cascade(CascadeType.DELETE)
    private List<AbstractConfigRule> configRuleList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getMinCoin() {
        return minCoin;
    }

    public void setMinCoin(int minCoin) {
        this.minCoin = minCoin;
    }

    public String getUrlAddress() {
        return urlAddress;
    }

    public void setUrlAddress(String urlAddress) {
        this.urlAddress = urlAddress;
    }

    public int getNumberOfWin() {
        return numberOfWin;
    }

    public void setNumberOfWin(int numberOfWin) {
        this.numberOfWin = numberOfWin;
    }

    public String getRegulation() {
        return regulation;
    }

    public void setRegulation(String regulation) {
        this.regulation = regulation;
    }

    public ContestType getContestType() {
        return contestType;
    }

    public void setContestType(ContestType contestType) {
        this.contestType = contestType;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<ContestInfo> getContestInfoList() {
        return contestInfoList;
    }

    public void setContestInfoList(List<ContestInfo> contestInfoList) {
        this.contestInfoList = contestInfoList;
    }

    public List<AbstractConfigRule> getConfigRuleList() {
        return configRuleList;
    }

    public void setConfigRuleList(List<AbstractConfigRule> configRuleList) {
        this.configRuleList = configRuleList;
    }

    @Override
    public String toString() {
        return "Contest{" + "id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", minCoin=" + minCoin + ", urlAddress=" + urlAddress + ", numberOfWin=" + numberOfWin + ", regulation=" + regulation + ", contestType=" + contestType + ", company=" + company + ", contestInfoList=" + contestInfoList + ", configRuleList=" + configRuleList + '}';
    }
}
