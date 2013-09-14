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
package com.wazzawin.core.model.algorithms.distribution;

import com.wazzawin.core.model.algorithms.common.AbstractPrizeComparator;
import com.wazzawin.core.model.algorithms.common.MapOfTimeSlot;
import com.wazzawin.core.model.contest.Contest;
import com.wazzawin.core.model.contest.Prize;
import com.wazzawin.core.model.user.UserPlayContest;
import com.wazzawin.shared.contest.Frequency;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Gianvito Summa - WazzaWin Developer Group
 */

public class Distributor {

    private boolean assignNotAssignedPrizes;
    private Frequency frequency;
    private ProbabilityInterval probabilityInterval;
    private AbstractPrizeComparator prizeComp;
    
    public Distributor(boolean assignNotAssigned, ProbabilityInterval pi, AbstractPrizeComparator abc){
        this.assignNotAssignedPrizes = assignNotAssigned;
        this.probabilityInterval = probabilityInterval;
        this.prizeComp = abc;
    }
    
    public Prize chooseAPrize(UserPlayContest upc) {
        Contest c = upc.getContest();
        MapOfTimeSlot mapOfTimeSlot = c.getMapOfTimeSlot();
        chooseAndSetAFrequency(mapOfTimeSlot, upc.getPlayDate().getTime());
        double valRand = Math.random();
        double valProb = probabilityInterval.getProbabilityByCurrentDate(upc.getContest().getPeriod(), upc.getPlayDate());
        Prize p = null;
        if(valProb > valRand){
            p = mapOfTimeSlot.getMapOfPrizes(getFrequency()).pickUpAPrize(prizeComp);
        }
        if(p == null && isAssignNotAssignedPrizes()){
            //TODO try to assign not assigned prizes
            
        }
        return p;
    }

    public Frequency getFrequncy(){
        return getFrequency();
    }
    /**
     * @return the assignNotAssignedPrizes
     */
    public boolean isAssignNotAssignedPrizes() {
        return assignNotAssignedPrizes;
    }

    /**
     * @param assignNotAssignedPrizes the assignNotAssignedPrizes to set
     */
    public void setAssignNotAssignedPrizes(boolean assignNotAssignedPrizes) {
        this.assignNotAssignedPrizes = assignNotAssignedPrizes;
    }

    /**
     * @return the probabilityInterval
     */
    public ProbabilityInterval getProbabilityInterval() {
        return probabilityInterval;
    }

    /**
     * @param probabilityInterval the probabilityInterval to set
     */
    public void setProbabilityInterval(ProbabilityInterval probabilityInterval) {
        this.probabilityInterval = probabilityInterval;
    }

    private void chooseAndSetAFrequency(MapOfTimeSlot mapOfTimeSlot, long seed) {
        List<Frequency> availableFrequencies = mapOfTimeSlot.getAvailableFrequencies();
        Random r = new Random(seed);
        int randomic = r.nextInt(availableFrequencies.size());
        frequency = availableFrequencies.get(randomic);
    }

    /**
     * @return the prizeComp
     */
    public AbstractPrizeComparator getPrizeComp() {
        return prizeComp;
    }

    /**
     * @param prizeComp the prizeComp to set
     */
    public void setPrizeComp(AbstractPrizeComparator prizeComp) {
        this.prizeComp = prizeComp;
    }

    /**
     * @return the frequency
     */
    public Frequency getFrequency() {
        return frequency;
    }

}
