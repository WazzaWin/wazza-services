package com.wazzawin.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "PaginatedSearchRequest")
public class PaginatedSearchRequest extends SearchRequest {

    private int num;
    private int page;

    public PaginatedSearchRequest() {
    }

    public PaginatedSearchRequest(int num, int page) {
        this.num = num;
        this.page = page;
    }

    public PaginatedSearchRequest(String nameLike, int num, int page) {
        super(nameLike);
        this.num = num;
        this.page = page;
    }

    public PaginatedSearchRequest(String nameLike, LikePatternType likeType,
            int num, int page) {
        super(nameLike, likeType);
        this.num = num;
        this.page = page;
    }

    /**
     * @param num the number of entries per page (you may get less entries in
     * the last page)
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * @return the number of entries per page (you may get less entries in the
     * last page)
     */
    @XmlElement(required = true, nillable = false)
    public int getNum() {
        return num;
    }

    /**
     * @param page the page number
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * @return the page number
     */
    @XmlElement(required = true, nillable = false)
    public int getPage() {
        return page;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(getClass().getSimpleName());
        builder.append(" [num=").append(num);
        builder.append(", page=").append(page);
        builder.append(", like=").append(super.getNameLike()).append(']');
        return builder.toString();
    }
}