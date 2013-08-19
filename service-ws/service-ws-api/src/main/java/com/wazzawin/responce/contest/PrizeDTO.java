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
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "prizeDTO")
public class PrizeDTO implements Serializable {

    private static final long serialVersionUID = -4908166889598162653L;
    private Long id;
    //
    private String name;
    //
    private String description;
    //
    private String note;
    //
    private String urlImage;
    //
    private int prizeValue;
    //
    private int remainingPrizes;
    //
    private boolean instantWin;
    //
    private CompanyDTO company;
    //
    private List<PeriodicityDTO> periodicityList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public int getPrizeValue() {
        return prizeValue;
    }

    public void setPrizeValue(int prizeValue) {
        this.prizeValue = prizeValue;
    }

    public int getRemainingPrizes() {
        return remainingPrizes;
    }

    public void setRemainingPrizes(int remainingPrizes) {
        this.remainingPrizes = remainingPrizes;
    }

    public boolean isInstantWin() {
        return instantWin;
    }

    public void setInstantWin(boolean instantWin) {
        this.instantWin = instantWin;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public List<PeriodicityDTO> getPeriodicityList() {
        return periodicityList;
    }

    public void setPeriodicityList(List<PeriodicityDTO> periodicityList) {
        this.periodicityList = periodicityList;
    }

    @Override
    public String toString() {
        return "PrizeDTO{" + "id=" + id + ", name=" + name + ", description=" + description + ", note=" + note + ", urlImage=" + urlImage + ", prizeValue=" + prizeValue + ", remainingPrizes=" + remainingPrizes + ", instantWin=" + instantWin + ", company=" + company + ", periodicityList=" + periodicityList + '}';
    }
}
