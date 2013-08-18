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
@XmlRootElement(name = "contestTypeDTO")
public class ContestTypeDTO implements Serializable {

    private static final long serialVersionUID = 4990165795322272453L;
    private Long id;
    //
    private String title;
    //
    private String color;
    //
    private String urlImage;
    //
    private String urlAgreement;
    //
    private List<ContestDTO> contestList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getUrlAgreement() {
        return urlAgreement;
    }

    public void setUrlAgreement(String urlAgreement) {
        this.urlAgreement = urlAgreement;
    }

    public List<ContestDTO> getContestList() {
        return contestList;
    }

    public void setContestList(List<ContestDTO> contestList) {
        this.contestList = contestList;
    }

    @Override
    public String toString() {
        return "ContestTypeDTO{" + "id=" + id + ", title=" + title + ", color=" + color + ", urlImage=" + urlImage + ", urlAgreement=" + urlAgreement + ", contestList=" + contestList + '}';
    }
}
