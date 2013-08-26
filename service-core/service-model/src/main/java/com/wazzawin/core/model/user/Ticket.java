/*
 *  wazza-services
 *  WazzaWins Services
 *  https://github.com/WazzaWin/wazza-services
 * ====================================================================
 *
 * Copyright (C) 2012-2013 WazzaWin Developer Group (WazzaWin Team - Potenza - ITALY).
 *
 * This program is free software: you can redistribute it and/or modify it 
 * under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version. This program is distributed in the 
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without 
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR 
 * A PARTICULAR PURPOSE. See the GNU General Public License 
 * for more details. You should have received a copy of the GNU General 
 * Public License along with this program. If not, see http://www.gnu.org/licenses/ 
 *
 * ====================================================================
 *
 * Linking this library statically or dynamically with other modules is 
 * making a combined work based on this library. Thus, the terms and 
 * conditions of the GNU General Public License cover the whole combination. 
 * 
 * As a special exception, the copyright holders of this library give you permission 
 * to link this library with independent modules to produce an executable, regardless 
 * of the license terms of these independent modules, and to copy and distribute 
 * the resulting executable under terms of your choice, provided that you also meet, 
 * for each linked independent module, the terms and conditions of the license of 
 * that module. An independent module is a module which is not derived from or 
 * based on this library. If you modify this library, you may extend this exception 
 * to your version of the library, but you are not obligated to do so. If you do not 
 * wish to do so, delete this exception statement from your version. 
 *
 */
package com.wazzawin.core.model.user;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Type;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@XmlRootElement(name = "ticket")
@Entity
@Table(name = "TICKET")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "ticket")
public class Ticket implements Serializable {

    private static final long serialVersionUID = 8659021263450163484L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "TICKET_SEQ")
    @SequenceGenerator(name = "TICKET_SEQ", sequenceName = "TICKET_SEQ")
    private Long id;
    //data e ora dello scontrino 
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "timestamp")
    @Column(name = "ticket_date", columnDefinition = "DATE")
    @Index(name = "TICKET_DATE_INDEX")
    private Date ticketDate;
    //
    @Column(name = "ticket_number", columnDefinition = "INTEGER")
    @Index(name = "TICKET_NUMBER_INDEX")
    private int ticketNumber;
    //
    @Column(name = "ticket_amount", columnDefinition = "VARCHAR(254)")
    @Index(name = "TICKET_AMOUNT_INDEX")
    private Long ticketAmount;
    //
    @Column(name = "image")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;
    //
    @OneToMany(mappedBy = "ticket", fetch = FetchType.LAZY, orphanRemoval = true)
    @Cascade(CascadeType.DELETE)
    private List<TicketItem> ticketItemList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(Date ticketDate) {
        this.ticketDate = ticketDate;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Long getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(Long ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<TicketItem> getTicketItemList() {
        return ticketItemList;
    }

    public void setTicketItemList(List<TicketItem> ticketItemList) {
        this.ticketItemList = ticketItemList;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", ticketDate=" + ticketDate + ", ticketNumber=" + ticketNumber + ", ticketAmount=" + ticketAmount + ", image=" + image + ", ticketItemList=" + ticketItemList + '}';
    }
}
