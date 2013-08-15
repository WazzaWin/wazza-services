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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "walk_step")
@Entity
@Table(name = "WALK_STEP")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "walk_step")
public class WalkStep implements Serializable {

    private static final long serialVersionUID = -8668455156624464975L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "WALK_STEP_SEQ")
    @SequenceGenerator(name = "WALK_STEP_SEQ", sequenceName = "WALK_STEP_SEQ")
    private Long id;
    //
    @Column(name = "step_order", columnDefinition = "INTEGER")
    @Index(name = "WALK_STEP_ORDER_INDEX")
    private int stepOrder;
    //
    @OneToMany(mappedBy = "walkStep", fetch = FetchType.LAZY, orphanRemoval = true)
    @Cascade(CascadeType.DELETE)
    private List<Hint> hintList;
    //
    @ManyToOne(optional = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "walk_id", referencedColumnName = "id",
            nullable = false)
    @Index(name = "WALK_STEP_WALK_INDEX")
    private Walk walk;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStepOrder() {
        return stepOrder;
    }

    public void setStepOrder(int stepOrder) {
        this.stepOrder = stepOrder;
    }

    public List<Hint> getHintList() {
        return hintList;
    }

    public void setHintList(List<Hint> hintList) {
        this.hintList = hintList;
    }

    public Walk getWalk() {
        return walk;
    }

    public void setWalk(Walk walk) {
        this.walk = walk;
    }

    @Override
    public String toString() {
        return "WalkStep{" + "id=" + id + ", stepOrder=" + stepOrder + ", hintList=" + hintList + ", walk=" + walk + '}';
    }
}
