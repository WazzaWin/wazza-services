/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wazzawin.responce.contest;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "periodicityDTO")
public class PeriodicityDTO implements Serializable {

    private static final long serialVersionUID = -5048544954929626642L;
    private Long id;
    //
    private PeriodDTO period;
    //
    private int maxPlayNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PeriodDTO getPeriod() {
        return period;
    }

    public void setPeriod(PeriodDTO period) {
        this.period = period;
    }

    public int getMaxPlayNumber() {
        return maxPlayNumber;
    }

    public void setMaxPlayNumber(int maxPlayNumber) {
        this.maxPlayNumber = maxPlayNumber;
    }

    @Override
    public String toString() {
        return "PeriodicityDTO{" + "id=" + id + ", period=" + period + ", maxPlayNumber=" + maxPlayNumber + '}';
    }
}
