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
@XmlRootElement(name = "categoryDTO")
public class CategoryDTO implements Serializable {

    private static final long serialVersionUID = -8201545977022984655L;
    private Long id;
    //
    private String categoryName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" + "id=" + id + ", categoryName=" + categoryName + '}';
    }
}
