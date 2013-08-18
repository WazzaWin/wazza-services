/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wazzawin.responce.contest;

import com.wazzawin.responce.customer.CompanyDTO;
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

    @Override
    public String toString() {
        return "ContestDTO{" + "id=" + id + ", minCoin=" + minCoin + ", urlAddress=" + urlAddress + ", numberOfWin=" + numberOfWin + ", regulation=" + regulation + ", contestType=" + contestType + ", period=" + period + ", company=" + company + ", contestInfoList=" + contestInfoList + ", configRuleList=" + configRuleList + '}';
    }
}
