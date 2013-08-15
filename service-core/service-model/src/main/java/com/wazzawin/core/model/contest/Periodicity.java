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
@XmlRootElement(name = "periodicity")
@Entity
@Table(name = "PERIODICITY")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "periodicity")
public class Periodicity implements Serializable {

    private static final long serialVersionUID = -6933097719014182688L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "PERIODICITY_SEQ")
    @SequenceGenerator(name = "PERIODICITY_SEQ", sequenceName = "PERIODICITY_SEQ")
    private Long id;
    //
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "period_id", referencedColumnName = "id",
            nullable = false)
    @Index(name = "PERIODICITY_PERIOD_INDEX")
    private Period period;
    //
    @Column(name = "max_play_number", columnDefinition = "INTEGER")
    @Index(name = "PERIODICITY_MAX_PLAY_NUMBER_INDEX")
    private int maxPlayNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMaxPlayNumber() {
        return maxPlayNumber;
    }

    public void setMaxPlayNumber(int maxPlayNumber) {
        this.maxPlayNumber = maxPlayNumber;
    }

    @Override
    public String toString() {
        return "Periodicity{" + "id=" + id + ", period=" + period + ", maxPlayNumber=" + maxPlayNumber + '}';
    }
}
