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
