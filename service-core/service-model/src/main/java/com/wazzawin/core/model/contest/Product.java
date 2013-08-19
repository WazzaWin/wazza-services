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
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Index;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "product")
@Entity
@Table(name = "PRODUCT")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = -4354680699434798199L;
    //
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "PRODUCT_RULE_SEQ")
    @SequenceGenerator(name = "PRODUCT_RULE_SEQ", sequenceName = "PRODUCT_RULE_SEQ")
    private Long id;
    //
    @Column(name = "product_code", columnDefinition = "VARCHAR(254)")
    @Index(name = "PRODUCT_CODE_INDEX")
    private String code;
    //
    @Column(name = "product_brand", columnDefinition = "VARCHAR(254)")
    @Index(name = "PRODUCT_BRAND_INDEX")
    private String brand;
    //
    @Column(name = "product_area", columnDefinition = "VARCHAR(254)")
    @Index(name = "PRODUCT_AREA_INDEX")
    private String area;
    //
    @Column(name = "price")
    @Index(name = "PRODUCT_PRICE_INDEX")
    private Long price;
    //
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    @Cascade(CascadeType.DELETE)
    @JoinTable(name = "PRODUCT_CATEGORY", joinColumns = {
        @JoinColumn(name = "product_id", referencedColumnName = "id")},
            inverseJoinColumns = {
        @JoinColumn(name = "category_id", referencedColumnName = "id")})
    private List<Category> categoryList;
    //
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, orphanRemoval = true)
    @Cascade(CascadeType.DELETE)
    private List<Hint> hintList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Hint> getHintList() {
        return hintList;
    }

    public void setHintList(List<Hint> hintList) {
        this.hintList = hintList;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", code=" + code + ", brand=" + brand + ", area=" + area + ", price=" + price + ", categoryList=" + categoryList + ", hintList=" + hintList + '}';
    }
}
