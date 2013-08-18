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
@XmlRootElement(name = "hintDTO")
public class HintDTO implements Serializable {

    private static final long serialVersionUID = -8261524873344045822L;
    private Long id;
    //
    private String text;
    //
    private int coinEffort;
    //
    private WalkStepDTO walkStep;
    //
    private ProductDTO product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCoinEffort() {
        return coinEffort;
    }

    public void setCoinEffort(int coinEffort) {
        this.coinEffort = coinEffort;
    }

    public WalkStepDTO getWalkStep() {
        return walkStep;
    }

    public void setWalkStep(WalkStepDTO walkStep) {
        this.walkStep = walkStep;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "HintDTO{" + "id=" + id + ", text=" + text + ", coinEffort=" + coinEffort + ", walkStep=" + walkStep + ", product=" + product + '}';
    }
}
