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
@XmlRootElement(name = "productDTO")
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 5360036182182296342L;
    private Long id;
    //
    private String code;
    //
    private String brand;
    //
    private String area;
    //
    private Long price;
    //
    private List<CategoryDTO> categoryList;
    //
    private List<HintDTO> hintList;

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

    public List<CategoryDTO> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategoryDTO> categoryList) {
        this.categoryList = categoryList;
    }

    public List<HintDTO> getHintList() {
        return hintList;
    }

    public void setHintList(List<HintDTO> hintList) {
        this.hintList = hintList;
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "id=" + id + ", code=" + code + ", brand=" + brand + ", area=" + area + ", price=" + price + ", categoryList=" + categoryList + ", hintList=" + hintList + '}';
    }
}
