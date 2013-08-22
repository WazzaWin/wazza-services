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
package com.wazzawin.core.model.algorithms.validation.rules;

import com.wazzawin.core.model.algorithms.distribution.MapOfTimeSlot;
import com.wazzawin.core.model.contest.Periodicity;
import com.wazzawin.core.model.user.UserPlayContest;
import com.wazzawin.shared.contest.Frequency;
import java.util.Set;

/**
 *
 * @author Gianvito Summa - WazzaWin Developer Group
 */


public class MaxNumberOfAttemptsRule implements IValidationRule {

    public static final int NO_LIMITS = 10000;
    
    @Override
    public boolean isValid(UserPlayContest upc) {
        MapOfTimeSlot mapOfAttempts = upc.getWazzaUser().getAttemptsByContest(upc.getContest());
        Set<Frequency> keys = mapOfAttempts.keySet();
        int maxAttempts;
        int userAttempts;
        for(Frequency f : keys){
            maxAttempts = getMaxAttemps(upc, f);
            if(isLimited(maxAttempts)){
                userAttempts = mapOfAttempts.getAttempts(f);
                if(userAttempts > maxAttempts){
                    return false;
                }
            }
        }
        return true;
    }

    private int getMaxAttemps(UserPlayContest upc, Frequency frequency){
        Periodicity periodicity = upc.getContest().getPeriod().getPeriodicityByFrequency(frequency);
        if(periodicity == null){
            return NO_LIMITS;
        }
        return periodicity.getMaxPlayNumber();
    }

    private boolean isLimited(int value) {
        return (value == NO_LIMITS) ? false: true;
    }    
}
