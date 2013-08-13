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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlSeeAlso;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Entity
@Table(name = "CONFIG_RULE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@XmlSeeAlso(value = {Periodicity.class, Walk.class})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "config_rule")
public abstract class AbstractConfigRule implements Serializable {
    private static final long serialVersionUID = -8668455156624464975L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "CONFIG_RULE_SEQ")
    @SequenceGenerator(name = "CONFIG_RULE_SEQ", sequenceName = "CONFIG_RULE_SEQ")
    private Long id;
    //
    @Column(name = "name", columnDefinition = "VARCHAR(254)")
    @Index(name = "CONFIG_RULE_NAME_INDEX")
    private String name;
    //
    @Column(name = "description", columnDefinition = "TEXT")
    @Index(name = "CONFIG_RULE_DESCRIPTION_INDEX")
    private String description;
    //
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "contest_id", referencedColumnName = "id",
            nullable = false)
    @Index(name = "CONFIG_RULE_CONTEST_INDEX")
    private Contest contest;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "AbstractConfigRule{" + "id=" + id + ", name=" + name + ", description=" + description + ", contest=" + contest + '}';
    }
}
