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
@XmlRootElement(name = "ticket_item")
@Entity
@Table(name = "TICKET_ITEM")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "ticket_item")
public class TicketItem implements Serializable {

    private static final long serialVersionUID = 8659021263450163484L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "TICKET_ITEM_SEQ")
    @SequenceGenerator(name = "TICKET_ITEM_SEQ", sequenceName = "TICKET_ITEM_SEQ")
    private Long id;
    //
    @Column(name = "ticket_item_name", columnDefinition = "VARCHAR(128)", nullable = false)
    @Index(name = "TICKET_ITEM_NAME_INDEX")
    private String itemName;
    //
    @Column(name = "ticket_item_price")
    @Index(name = "TICKET_ITEM_PRICE_INDEX")
    private Long itemPrice;
    //This field must be generalized using Unit of Measure
    @Column(name = "ticket_item_quantity", columnDefinition = "INTEGER")
    @Index(name = "TICKET_ITEM_AMOUNT_INDEX")
    private int itemQuantity;
    //
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ticket_id", referencedColumnName = "id",
            nullable = false)
    @Index(name = "TICKET_ITEM_TICKET_INDEX")
    private Ticket ticket;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Long itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "TicketItem{" + "id=" + id + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemQuantity=" + itemQuantity + ", ticket=" + ticket + '}';
    }
}
