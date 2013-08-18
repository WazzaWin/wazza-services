/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wazzawin.responce.contest;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "walkStepDTO")
public class WalkStepDTO implements Serializable {

    private static final long serialVersionUID = 1339619790673358270L;
    private Long id;
    //
    private int stepOrder;
    //
    private List<HintDTO> hintList;
    //
    private WalkDTO walk;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStepOrder() {
        return stepOrder;
    }

    public void setStepOrder(int stepOrder) {
        this.stepOrder = stepOrder;
    }

    public List<HintDTO> getHintList() {
        return hintList;
    }

    public void setHintList(List<HintDTO> hintList) {
        this.hintList = hintList;
    }

    public WalkDTO getWalk() {
        return walk;
    }

    public void setWalk(WalkDTO walk) {
        this.walk = walk;
    }

    @Override
    public String toString() {
        return "WalkStepDTO{" + "id=" + id + ", stepOrder=" + stepOrder + ", hintList=" + hintList + ", walk=" + walk + '}';
    }
}
