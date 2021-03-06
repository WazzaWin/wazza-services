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
