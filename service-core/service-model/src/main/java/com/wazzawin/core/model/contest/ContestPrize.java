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
@XmlRootElement(name = "contest_prize")
@Entity
@Table(name = "CONTEST_PRIZE")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "contest_prize")
public class ContestPrize implements Serializable {
    private static final long serialVersionUID = 8109760184180383771L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "CONTEST_PRIZE_SEQ")
    @SequenceGenerator(name = "CONTEST_PRIZE_SEQ", sequenceName = "CONTEST_PRIZE_SEQ")
    private Long id;
    //
    @Column(name = "number_of_prizes", columnDefinition = "INTEGER")
    @Index(name = "CONTEST_PRIZE_NUMBER_OF_PRIZES_INDEX")
    private int numberOfPrizes;
    //
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "prize_id", referencedColumnName = "id",
            nullable = false)
    @Index(name = "CONTEST_PRIZE_PRIZE_INDEX")
    private Prize prize;
    //
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "contest_id", referencedColumnName = "id",
            nullable = false)
    @Index(name = "CONTEST_PRIZE_CONTEST_INDEX")
    private Contest contest;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberOfPrizes() {
        return numberOfPrizes;
    }

    public void setNumberOfPrizes(int numberOfPrizes) {
        this.numberOfPrizes = numberOfPrizes;
    }

    public Prize getPrize() {
        return prize;
    }

    public void setPrize(Prize prize) {
        this.prize = prize;
    }

    public Contest getContest() {
        return contest;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }

    @Override
    public String toString() {
        return "ContestPrize{" + "id=" + id + ", numberOfPrizes=" + numberOfPrizes + ", prize=" + prize + ", contest=" + contest + '}';
    }
}
