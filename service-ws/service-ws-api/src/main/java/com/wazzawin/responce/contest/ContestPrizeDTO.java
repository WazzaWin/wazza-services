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
@XmlRootElement(name = "contestPrizeDTO")
public class ContestPrizeDTO implements Serializable {

    private static final long serialVersionUID = 6178211731111197055L;
    private Long id;
    //
    private int numberOfPrizes;
    //
    private PrizeDTO prize;
    //
    private ContestDTO contest;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberOfPrizes() {
        return numberOfPrizes;
    }

    public void setNumberOfPrizes(int numberOfPrizes) {
        this.numberOfPrizes = numberOfPrizes;
    }

    public PrizeDTO getPrize() {
        return prize;
    }

    public void setPrize(PrizeDTO prize) {
        this.prize = prize;
    }

    public ContestDTO getContest() {
        return contest;
    }

    public void setContest(ContestDTO contest) {
        this.contest = contest;
    }

    @Override
    public String toString() {
        return "ContestPrizeDTO{" + "id=" + id + ", numberOfPrizes=" + numberOfPrizes + ", prize=" + prize + ", contest=" + contest + '}';
    }
}
