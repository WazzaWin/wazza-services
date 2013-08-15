/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wazzawin.shared.contest;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
public abstract class AbstractContestType implements IContestType {

    private String title;
    private String urlAgreement;
    private String urlImage;
    private String color;

    public AbstractContestType(String title, String urlAgreement, String urlImage, String color) {
        this.title = title;
        this.urlAgreement = urlAgreement;
        this.urlImage = urlImage;
        this.color = color;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getUrlAgreement() {
        return urlAgreement;
    }

    @Override
    public String getUrlImage() {
        return urlImage;
    }

    @Override
    public String getColor() {
        return color;
    }
}
