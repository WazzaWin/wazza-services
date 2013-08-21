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
package com.wazzawin.responce.contest;

import com.wazzawin.responce.customer.CompanyDTO;
import com.wazzawin.responce.user.UserPlayContestDTO;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "contestDTO")
public class ContestDTO implements Serializable {

    private static final long serialVersionUID = -8062379367969291520L;
    private Long id;
    //
    private int minCoin;
    //
    private String urlAddress;
    //
    private int numberOfWin;
    //
    private String regulation;
    //
    private ContestTypeDTO contestType;
    //
    private PeriodDTO period;
    //
    private CompanyDTO company;
    //
    private List<ContestInfoDTO> contestInfoList;
    //
    private List<AbstractConfigRuleDTO> configRuleList;
    //
    private List<UserPlayContestDTO> userPlayContestDTOList;
    //
    private List<ContestPrizeDTO> contestPrizeDTOList;

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

    public ContestTypeDTO getContestType() {
        return contestType;
    }

    public void setContestType(ContestTypeDTO contestType) {
        this.contestType = contestType;
    }

    public PeriodDTO getPeriod() {
        return period;
    }

    public void setPeriod(PeriodDTO period) {
        this.period = period;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public List<ContestInfoDTO> getContestInfoList() {
        return contestInfoList;
    }

    public void setContestInfoList(List<ContestInfoDTO> contestInfoList) {
        this.contestInfoList = contestInfoList;
    }

    public List<AbstractConfigRuleDTO> getConfigRuleList() {
        return configRuleList;
    }

    public void setConfigRuleList(List<AbstractConfigRuleDTO> configRuleList) {
        this.configRuleList = configRuleList;
    }

    public List<UserPlayContestDTO> getUserPlayContestDTOList() {
        return userPlayContestDTOList;
    }

    public void setUserPlayContestDTOList(List<UserPlayContestDTO> userPlayContestDTOList) {
        this.userPlayContestDTOList = userPlayContestDTOList;
    }

    public List<ContestPrizeDTO> getContestPrizeDTOList() {
        return contestPrizeDTOList;
    }

    public void setContestPrizeDTOList(List<ContestPrizeDTO> contestPrizeDTOList) {
        this.contestPrizeDTOList = contestPrizeDTOList;
    }

    @Override
    public String toString() {
        return "ContestDTO{" + "id=" + id + ", minCoin=" + minCoin + ", urlAddress=" + urlAddress + ", numberOfWin=" + numberOfWin + ", regulation=" + regulation + ", contestType=" + contestType + ", period=" + period + ", company=" + company + ", contestInfoList=" + contestInfoList + ", configRuleList=" + configRuleList + ", userPlayContestDTOList=" + userPlayContestDTOList + ", contestPrizeDTOList=" + contestPrizeDTOList + '}';
    }
}
