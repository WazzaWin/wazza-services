/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wazzawin.shared.contest;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
public enum ContestTypeEnum {

    CATCH_THE_TICKET(new AbstractContestType("Catch The Ticket", "http://", "http://", "red") {
    }), TREASURE_HUNT(new AbstractContestType("Treasure Hunt", "http://", "http://", "yellow") {
    });
    private IContestType contestType;

    private ContestTypeEnum(IContestType contestType) {
        this.contestType = contestType;
    }

    public IContestType getContestType() {
        return contestType;
    }
}
