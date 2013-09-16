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
package com.wazzawin.core.model.algorithms.common;

import com.google.common.collect.Maps;
import com.wazzawin.core.model.contest.Periodicity;
import com.wazzawin.core.model.contest.Prize;
import com.wazzawin.core.model.contest.PrizePeriodicity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gianvito Summa - WazzaWin Developer Group
 */
public class MapOfPrizes {

    private Map<Prize, Integer> map = Maps.<Prize, Integer>newHashMap();
    private Map<Prize, Integer> mapConstraints = Maps.<Prize, Integer>newHashMap();
    private Map<Prize, Integer> mapRemaining = Maps.<Prize, Integer>newHashMap();

    public void add(Prize p) {
        Integer pp = map.get(p);
        if (pp == null) {
            add(p, new Integer(1));
            return;
        }
        pp++;
        add(p, pp);
    }

    public void add(Prize p, Integer pp) {
        map.put(p, pp);
    }

    public int getOccurrences(Prize p) {
        return map.get(p);
    }

    public List<Prize> getRemainingPrizes() {
        mapRemaining.clear();
        List<Prize> list = new ArrayList<Prize>();
        int items = 0;
        for (Prize p : map.keySet()) {
            items = getRemainingItems(p);
            if (items > 0) {
                mapRemaining.put(p, items);
                list.add(p);
            }
        }
        return list;
    }

    public int getRemainingItems(Prize p) {
        Integer occurences = getOccurrences(p);
        Integer numberOfItems = mapConstraints.get(p);
        return numberOfItems - occurences;
    }

    public void addPeriodicityConstraints(Periodicity periodicity) {
        this.mapConstraints.clear();
        Prize prize;
        for (PrizePeriodicity pp : periodicity.getPrizePeriodicityList()) {
            prize = pp.getPrize();
            mapConstraints.put(prize, new Integer(pp.getNumberOfPrizes()));
        }
    }

    public Prize pickUpAPrize(AbstractPrizeComparator comp) {
        List<Prize> availablePrizes = this.getRemainingPrizes();
        comp.setMapRemainingPrizes(mapRemaining);
        Collections.sort(availablePrizes, comp);
        return availablePrizes.get(0);
    }
}