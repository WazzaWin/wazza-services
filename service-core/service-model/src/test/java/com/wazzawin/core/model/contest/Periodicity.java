/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wazzawin.core.model.contest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Index;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Entity
@Table(name = "PERIODICITY")
@PrimaryKeyJoinColumn(referencedColumnName = "id", name = "config_rule_id")
@XmlRootElement(name = "periodicity")
public class Periodicity extends AbstractConfigRule {

    //
    @Column(name = "max_play_number", columnDefinition = "INTEGER")
    @Index(name = "PERIODICITY_MAX_PLAY_NUMBER_INDEX")
    private int maxPlayNumber;
    
    
    
    //Period type
}
