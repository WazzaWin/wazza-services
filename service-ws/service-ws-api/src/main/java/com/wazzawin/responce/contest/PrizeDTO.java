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
