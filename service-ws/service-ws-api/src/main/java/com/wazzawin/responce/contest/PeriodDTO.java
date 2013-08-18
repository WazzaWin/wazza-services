/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wazzawin.responce.contest;

import com.wazzawin.shared.contest.Frequency;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "periodDTO")
public class PeriodDTO implements Serializable {

    private static final long serialVersionUID = 4183679454791191371L;
    private Long id;
    //
    private Date startDate;
    //
    private Date endDate;
    //
    private Frequency frequency;
    //
    private List<PeriodicityDTO> periodicityList;

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

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public List<PeriodicityDTO> getPeriodicityList() {
        return periodicityList;
    }

    public void setPeriodicityList(List<PeriodicityDTO> periodicityList) {
        this.periodicityList = periodicityList;
    }

    @Override
    public String toString() {
        return "PeriodDTO{" + "id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", frequency=" + frequency + ", periodicityList=" + periodicityList + '}';
    }
}
