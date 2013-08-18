package com.wazzawin.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "RequestByID")
public class RequestByID {

    private Long id;
    private int page;
    private int num;

    /**
     *
     */
    public RequestByID() {
    }

    /**
     * @param id
     */
    public RequestByID(Long id) {
        this.id = id;
    }

    /**
     * @param id
     * @param pag
     * @param num
     */
    public RequestByID(Long id, int page, int num) {
        super();
        this.id = id;
        this.page = page;
        this.num = num;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    @XmlElement(required = true, nillable = false)
    public Long getId() {
        return id;
    }

    /**
     * @return int
     */
    public int getPage() {
        return page;
    }

    /**
     * @param pag
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * @return int
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num
     */
    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "RequestByID [id=" + id + ", num=" + num + ", pag=" + page + "]";
    }
}
