package com.wazzawin.dao.jpa.impl.user;

import com.wazzawin.core.model.user.Profile;
import com.wazzawin.dao.interf.user.IProfileDAO;
import com.wazzawin.dao.jpa.AbstractJpaDAO;
import org.springframework.stereotype.Repository;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Repository(value = "jpaProfileDAO")
@org.springframework.context.annotation.Profile(value = "jpa")
public class ProfileDAOImpl extends AbstractJpaDAO<Profile, Long> implements
        IProfileDAO {

    public ProfileDAOImpl() {
        super(Profile.class);
    }
}
