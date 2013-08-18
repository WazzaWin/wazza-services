/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wazzawin.responce.customer;

import com.wazzawin.responce.contest.ContestDTO;
import com.wazzawin.responce.contest.PrizeDTO;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "companyDTO")
public class CompanyDTO implements Serializable {

    private static final long serialVersionUID = 3325127293188960549L;
    private Long id;
    //
    private String vatNumber;
    //
    private String businessName;
    //
    private String email;
    //
    private String password;
    //
    private boolean enabled;
    //
    private Date lastLogin;
    //
    private String tel;
    //
    private List<ContestDTO> contestList;
    //
    private List<PrizeDTO> prizeList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<ContestDTO> getContestList() {
        return contestList;
    }

    public void setContestList(List<ContestDTO> contestList) {
        this.contestList = contestList;
    }

    public List<PrizeDTO> getPrizeList() {
        return prizeList;
    }

    public void setPrizeList(List<PrizeDTO> prizeList) {
        this.prizeList = prizeList;
    }

    @Override
    public String toString() {
        return "CompanyDTO{" + "id=" + id + ", vatNumber=" + vatNumber + ", businessName=" + businessName + ", email=" + email + ", password=" + password + ", enabled=" + enabled + ", lastLogin=" + lastLogin + ", tel=" + tel + ", contestList=" + contestList + ", prizeList=" + prizeList + '}';
    }
}
