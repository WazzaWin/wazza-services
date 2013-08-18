/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wazzawin.responce.contest;

import java.io.Serializable;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
public abstract class AbstractConfigRuleDTO implements Serializable {

    private static final long serialVersionUID = -247442493798542816L;
    private Long id;
    //
    private String name;
    //
    private String description;
    //
    private ContestDTO contest;

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

    public ContestDTO getContest() {
        return contest;
    }

    public void setContest(ContestDTO contest) {
        this.contest = contest;
    }

    @Override
    public String toString() {
        return "AbstractConfigRuleDTO{" + "id=" + id + ", name=" + name + ", description=" + description + ", contest=" + contest + '}';
    }
}
