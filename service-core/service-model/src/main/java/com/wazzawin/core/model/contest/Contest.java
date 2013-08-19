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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OneToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "period", referencedColumnName = "id", nullable = false)
    @Index(name = "CONTEST_PERIOD_INDEX")
    private Period period;
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

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "Contest{" + "id=" + id + ", minCoin=" + minCoin + ", urlAddress=" + urlAddress + ", numberOfWin=" + numberOfWin + ", regulation=" + regulation + ", contestType=" + contestType + ", period=" + period + ", company=" + company + ", contestInfoList=" + contestInfoList + ", configRuleList=" + configRuleList + '}';
    }
}
