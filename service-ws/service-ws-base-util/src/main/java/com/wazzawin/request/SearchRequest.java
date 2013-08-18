package com.wazzawin.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "SearchRequest")
public class SearchRequest {

    private String nameLike;

    public SearchRequest() {
    }

    public SearchRequest(String nameLike) {
        this.nameLike = LikePatternType.CONTAINS.apply(nameLike);
    }

    public SearchRequest(String nameLike, LikePatternType likeType) {
        this.nameLike = likeType.apply(nameLike);
    }

    /**
     * @return a nullable case insensitive LIKE filter. Only matching items will
     * be returned.
     */
    @XmlElement(required = true, nillable = true)
    public String getNameLike() {
        return nameLike;
    }

    /**
     * Set a case insensitive LIKE filter. Only matching items will be returned.
     * <BR>
     * "%" wildcards have to already be in the search string. <BR>
     * This param is optional.
     *
     * @param nameLike
     */
    public void setNameLike(String nameLike) {
        this.nameLike = nameLike;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(getClass().getSimpleName());
        builder.append(" [like=").append(nameLike).append(']');
        return builder.toString();
    }
}