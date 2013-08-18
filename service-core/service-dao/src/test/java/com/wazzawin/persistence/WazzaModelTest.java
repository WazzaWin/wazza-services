package com.wazzawin.persistence;

import com.wazzawin.core.model.user.Profile;
import com.wazzawin.core.model.user.WazzaUser;
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
 * @author Nazzareno Sileno - CNR IMAA geoSDI Group
 * @email nazzareno.sileno@geosdi.org
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
    //
    private WazzaUser wazzaUser;
    private Profile profile;

    @Before
    public void setUp() {
        this.removeAll();
        this.wazzaUser = new WazzaUser();
        this.wazzaUser.setUserName("giasum");
        this.wazzaUser.setEmail("giasum@gmail.com");
        this.wazzaUser.setPassword("senatus");
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