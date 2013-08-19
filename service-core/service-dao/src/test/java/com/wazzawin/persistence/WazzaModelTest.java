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
package com.wazzawin.persistence;

import com.wazzawin.core.model.user.Profile;
import com.wazzawin.core.model.user.WazzaUser;
import com.wazzawin.crypt.WazzaByteDigester;
import com.wazzawin.dao.interf.user.IProfileDAO;
import com.wazzawin.dao.interf.user.IWazzaUserDAO;
import com.wazzawin.persistence.loader.PersistenceLoaderTestConfigurer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceLoaderTestConfigurer.class},
        loader = AnnotationConfigContextLoader.class)
@ActiveProfiles(value = {"jpa"})
public class WazzaModelTest {

    private static final Logger logger = LoggerFactory.getLogger(
            WazzaModelTest.class);
    //
    @Autowired
    private IWazzaUserDAO jpaWazzaUserDAO;
    @Autowired
    private IProfileDAO jpaProfileDAO;
    @Autowired
    private WazzaByteDigester wazzaByteDigester;
    //
    private WazzaUser wazzaUser;
    private Profile profile;

    @Before
    public void setUp() {
        this.removeAll();
        this.wazzaUser = new WazzaUser();
        this.wazzaUser.setUserName("giasum");
        this.wazzaUser.setEmail("senatus@gmail.com");
        this.wazzaUser.setPassword(this.wazzaByteDigester.gsDigest("senatus"));
        logger.info("Coded Password: " + this.wazzaUser.getPassword());
        this.profile = new Profile();
        this.wazzaUser.setProfile(profile);
    }

    /**
     * Execute only this test using: mvn test -Dtest=WazzaModelTest#testUser
     */
    @Test
    public void testUser() {
        WazzaUser foundUser = this.jpaWazzaUserDAO.findByUserName("giasum");
        Assert.assertNull("Utente da inserire", foundUser);
        this.jpaProfileDAO.persist(profile);
        this.jpaWazzaUserDAO.persist(wazzaUser);
        this.wazzaUser = this.jpaWazzaUserDAO.findByUserName("giasum");
        Assert.assertNotNull("Utente salvato e trovato", this.wazzaUser);
        logger.debug("\n*** User SAVED:\n{}\n***", this.wazzaUser);
//        Assert.assertThat("La regione Basilicata deve contenere 129 comuni",
//                pagingContactoComuni.getTotalResults(), OrderingComparison.greaterThanOrEqualTo(129));
        //CoreMatchers.is()
    }

    private void removeAll() {
        this.removeAllUsers();
    }

    private void removeAllUsers() {
        this.jpaWazzaUserDAO.removeAll();
    }
}