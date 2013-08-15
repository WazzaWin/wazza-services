/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wazzawin.core.model.contest;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "hint")
@Entity
@Table(name = "HINT")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "hint")
public class Hint implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "HINT_INFO_SEQ")
    @SequenceGenerator(name = "HINT_INFO_SEQ", sequenceName = "HINT_INFO_SEQ")
    private Long id;
    //
    @Column(name = "text", columnDefinition = "TEXT")
    @Index(name = "HINT_TEXT_INDEX")
    private String text;
    //
    @Column(name = "coin_effort", columnDefinition = "INTEGER")
    @Index(name = "HINT_COIN_EFFORT_INDEX")
    private int coinEffort;
    //
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "walk_step_id", referencedColumnName = "id",
            nullable = false)
    @Index(name = "HINT_WALK_STEP_INDEX")
    private WalkStep walkStep;
    //
    @ManyToOne(optional = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "product_id", referencedColumnName = "id",
            nullable = false)
    @Index(name = "HINT_PRODUCT_INDEX")
    private Product product;

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

    public WalkStep getWalkStep() {
        return walkStep;
    }

    public void setWalkStep(WalkStep walkStep) {
        this.walkStep = walkStep;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Hint{" + "id=" + id + ", text=" + text + ", coinEffort=" + coinEffort + ", walkStep=" + walkStep + ", product=" + product + '}';
    }
}
