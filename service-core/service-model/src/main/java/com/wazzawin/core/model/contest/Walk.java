/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wazzawin.core.model.contest;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Entity
@Table(name = "WALK")
@PrimaryKeyJoinColumn(referencedColumnName = "id", name = "config_rule_id")
@XmlRootElement(name = "walk")
public class Walk extends AbstractConfigRule {

    //
    @Column(name = "step", columnDefinition = "INTEGER")
    @Index(name = "WALK_STEP_INDEX")
    private int step;
    //
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "WALK_PRODUCT", joinColumns =
            @JoinColumn(name = "walk_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private List<Product> productList;
    //
    @OneToMany(mappedBy = "walk", fetch = FetchType.LAZY, orphanRemoval = true)
    @Cascade(CascadeType.DELETE)
    private List<WalkStep> walkStepList;

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<WalkStep> getWalkStepList() {
        return walkStepList;
    }

    public void setWalkStepList(List<WalkStep> walkStepList) {
        this.walkStepList = walkStepList;
    }

    @Override
    public String toString() {
        return "Walk{" + "step=" + step + ", productList=" + productList + ", walkStepList=" + walkStepList + '}';
    }
}
