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

import com.wazzawin.core.model.user.UserPlayContest;
import com.wazzawin.shared.contest.Frequency;
import java.util.Calendar;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Gianvito Summa - WazzaWin Developer Group
 */


public class MapOfTimeSlot {

    private Map<Frequency, TimeSlot> map = new EnumMap<Frequency, TimeSlot>(Frequency.class);
    
    public MapOfTimeSlot(){
        initializeMap();
    }
 
    private void initializeMap() {
        for(Frequency f : Frequency.values()){
            this.map.put(f, new TimeSlot());
        }
    }
    
    public Set<Frequency> keySet(){
        return this.map.keySet();
    }
    
    public void add(UserPlayContest upc, Calendar cal, Calendar playDate){
        playDate.setTime(upc.getPlayDate());
        updateMap(Frequency.ONE_TIME, upc.isWinning());
        if(cal.get(Calendar.YEAR) == playDate.get(Calendar.YEAR)){
            updateMap(Frequency.YEARLY, upc.isWinning());
            if(cal.get(Calendar.WEEK_OF_YEAR) == playDate.get(Calendar.WEEK_OF_YEAR)){
                updateMap(Frequency.WEEKLY, upc.isWinning());
            }
            if(cal.get(Calendar.MONTH) == playDate.get(Calendar.MONTH)){
                updateMap(Frequency.MONTHLY, upc.isWinning());
                if(cal.get(Calendar.DAY_OF_MONTH) == playDate.get(Calendar.DAY_OF_MONTH)){
                    updateMap(Frequency.DAILY, upc.isWinning());
                    if(cal.get(Calendar.HOUR) == playDate.get(Calendar.HOUR)){
                        updateMap(Frequency.HOURLY, upc.isWinning());
                    }
                }
            }
        }
    }

    private void updateMap(Frequency frequency, boolean isWinning) {
        TimeSlot val = map.get(frequency);
        val.addAttempt();
        if(isWinning){
            val.addWinner();
        }
    }    

    public int getAttempts(Frequency f) {
        TimeSlot ts = this.map.get(f);
        return ts.getAttempts();
    }
}