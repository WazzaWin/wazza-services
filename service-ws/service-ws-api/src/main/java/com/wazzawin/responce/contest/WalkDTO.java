/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wazzawin.responce.contest;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "contestPrizeDTO")
public class WalkDTO extends AbstractConfigRuleDTO {

    private static final long serialVersionUID = -2325024796125518114L;
    private int step;
    //
    private List<ProductDTO> productList;
    //
    private List<WalkStepDTO> walkStepList;

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public List<ProductDTO> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductDTO> productList) {
        this.productList = productList;
    }

    public List<WalkStepDTO> getWalkStepList() {
        return walkStepList;
    }

    public void setWalkStepList(List<WalkStepDTO> walkStepList) {
        this.walkStepList = walkStepList;
    }

    @Override
    public String toString() {
        return "WalkDTO{" + "step=" + step + ", productList=" + productList + ", walkStepList=" + walkStepList + '}';
    }
}
