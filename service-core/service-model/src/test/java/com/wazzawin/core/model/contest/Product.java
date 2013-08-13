/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
