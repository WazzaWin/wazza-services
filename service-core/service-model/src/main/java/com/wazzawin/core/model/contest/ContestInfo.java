/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
@XmlRootElement(name = "contest_info")
@Entity
@Table(name = "CONTEST_INFO")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "contest_info")
public class ContestInfo implements Serializable {
    private static final long serialVersionUID = 4516772948741878526L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "CONTEST_INFO_SEQ")
    @SequenceGenerator(name = "CONTEST_INFO_SEQ", sequenceName = "CONTEST_INFO_SEQ")
    private Long id;
    //
    //
    @Column(name = "title", columnDefinition = "VARCHAR(254)")
    @Index(name = "CONTEST_INFO_TITLE_INDEX")
    private String title;
    //
    @Column(name = "url_image", columnDefinition = "VARCHAR(254)")
    @Index(name = "CONTEST_INFO_URL_IMAGE_INDEX")
    private String urlImage;
    //
    @Column(name = "description", columnDefinition = "TEXT")
    @Index(name = "CONTEST_INFO_DESCRIPTION_INDEX")
    private String description;
    //
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "contest_id", referencedColumnName = "id",
            nullable = false)
    @Index(name = "CONTEST_INFO_CONTEST_INDEX")
    private Contest contest;

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

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Contest getContest() {
        return contest;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }

    @Override
    public String toString() {
        return "ContestInfo{" + "id=" + id + ", title=" + title + ", urlImage=" + urlImage + ", description=" + description + ", contest=" + contest + '}';
    }
}
